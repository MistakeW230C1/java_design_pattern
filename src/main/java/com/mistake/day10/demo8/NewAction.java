package com.mistake.day10.demo8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author mistake
 */
public class NewAction extends AbstractAction {
    JFrame jFrame;

    JTextArea jTextArea;

    File curFile;

    public NewAction(JFrame frame, JTextArea textArea) {
        this.jFrame = frame;
        this.jTextArea = textArea;
    }

    private void saveFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(curFile);
            byte buf[] = jTextArea.getText().getBytes();
            fileOutputStream.write(buf);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveFilePath() {
        JFileChooser chooser = new JFileChooser();
        int ref = chooser.showSaveDialog(jFrame);
        if (ref != JFileChooser.APPROVE_OPTION) {
            return;
        }
        try {
            curFile = chooser.getSelectedFile();
            FileOutputStream fileOutputStream = new FileOutputStream(curFile);
            fileOutputStream.write(jTextArea.getText().getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preProcess() {
        curFile = ((IFileInter) jFrame).getFile();
        if (curFile != null) {
            saveFile();
            return;
        }
        if (!jTextArea.getText().equals("")) {
            saveFilePath();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        preProcess();
        jTextArea.setText("");
        curFile = null;
        ((IFileInter)jFrame).setFile(curFile);
        jFrame.setTitle("无标题");
    }
}
