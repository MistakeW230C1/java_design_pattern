package com.mistake.day10.demo7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author mistake
 */
public class MyFrame extends JFrame {
    JTextArea ta = new JTextArea();

    File curFile = null;

    private Action[][] actions = {{new NewAction(), new OpenAction(), new SaveAction(), new ExitAction()}};

    private void saveFile() {
        try {
            FileOutputStream out = new FileOutputStream(curFile);
            byte buf[] = ta.getText().getBytes();
            out.write(buf);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void savePathFile() {
        JFileChooser chooser = new JFileChooser();
        int ret = chooser.showSaveDialog(MyFrame.this);
        if (ret != JFileChooser.APPROVE_OPTION) {
            return;
        }
        try {
            curFile = chooser.getSelectedFile();
            FileOutputStream out = new FileOutputStream(curFile);
            out.write(ta.getText().getBytes());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preProcess() {
        if (curFile != null) {
            saveFile();
            return;
        }
        if (!ta.getText().equals("")) {
            savePathFile();
        }
    }

    protected JMenuBar createMenubar() {
        JMenuBar mb = new JMenuBar();
        String[] menuKeys = {"File"};
        String[][] itemKeys = {{"New", "Open", "Save", "Exit"}};
        for (int i = 0; i < menuKeys.length; i++) {
            JMenu m = new JMenu(menuKeys[i]);
            for (int j = 0; j < itemKeys[i].length; j++) {
                JMenuItem mi = new JMenuItem(itemKeys[i][j]);
                System.out.println(itemKeys[i][j]);
              //  mi.addActionListener(actions[i][j]);
                m.add(mi);
            }
            mb.add(m);
        }
        return mb;
    }

    public void init() {
        this.setJMenuBar(createMenubar());
        JScrollPane sp = new JScrollPane(ta);
        add(sp);
        setSize(600, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame().init();
    }

    class NewAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            preProcess();
            ta.setText("");
            curFile = null;
            MyFrame.this.setTitle("无标题");
        }
    }


    class OpenAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            preProcess();
            JFileChooser chooser = new JFileChooser();
            int ret = chooser.showOpenDialog(MyFrame.this);
            if (ret != JFileChooser.APPROVE_OPTION) {
                return;
            }
            try {
                curFile = chooser.getSelectedFile();
                if (curFile.isFile() && curFile.canRead()) {
                    int size = (int) curFile.length();
                    byte buf[] = new byte[size];
                    FileInputStream in = new FileInputStream(curFile);
                    in.read(buf);
                    in.close();
                    String s = new String(buf);
                    ta.setText(s);
                    MyFrame.this.setTitle(curFile.getName());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    class SaveAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (curFile != null) {
                saveFile();
                return;
            }
            savePathFile();
        }
    }

    class ExitAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}

