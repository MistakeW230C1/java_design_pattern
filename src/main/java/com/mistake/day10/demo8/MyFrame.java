package com.mistake.day10.demo8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class MyFrame extends JFrame implements IFileInter {

    private JTextArea ta = new JTextArea();

    private File curFile = null;

    private String menuKeys[];

    private String itemKeys[][];

    private String actKeys[][];

    private Action[][] actions = null;

    class ExitAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    /**
     * 动态添加菜单及响应事件
     *
     * @return
     */
    protected JMenuBar createMenubar() {
        JMenuBar mb = new JMenuBar();
        for (int i = 0; i < menuKeys.length; i++) {
            JMenu m = new JMenu(menuKeys[i]);
            for (int j = 0; j < itemKeys[i].length; j++) {
                JMenuItem jMenuItem = new JMenuItem(itemKeys[i][j]);
                m.add(jMenuItem);
                jMenuItem.addActionListener(actions[i][j]);
            }
            mb.add(m);
        }
        // 添加exit退出 菜单命令事件
        JMenu menu = mb.getMenu(0);
        JMenuItem jMenuItem = new JMenuItem("Exit");
        jMenuItem.addActionListener(new ExitAction());
        menu.add(jMenuItem);
        return mb;
    }

    private void createAction() {
        actions = new Action[actKeys.length][];
        try {
            for (int i = 0; i < actKeys.length; i++) {
                actions[i] = new Action[actKeys[i].length];
                for (int j = 0; j < actKeys[i].length; j++) {
                    System.out.println("actKeys[i][j]" + actKeys[i][j]);
                    Class classInfo = Class.forName("com.mistake.day10.demo8." + actKeys[i][j]);
                    Constructor c = classInfo.getConstructor(new Class[]{JFrame.class, JTextArea.class});
                    actions[i][j] = (Action) c.newInstance(new Object[]{this, ta});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读配置文件
     */
    private void initConfig() {
        try {
            Properties p = new Properties();
            p.loadFromXML(new FileInputStream("src/main/resources/day10.demo8/config.xml"));
            String s = p.getProperty("menubar");
            menuKeys = s.split(" ");
            itemKeys = new String[menuKeys.length][];
            for (int i = 0; i < menuKeys.length; i++) {
                s = p.getProperty(menuKeys[0] + "menu");
                itemKeys[i] = s.split(" ");
            }
            actKeys = new String[menuKeys.length][];
            for (int i = 0; i < menuKeys.length; i++) {
                // 获取对应的 菜单子项总事件响应类名
                s = p.getProperty(menuKeys[0] + "action");
                //  拆分后 填充具体的菜单子项事件响应类数据
                actKeys[i] = s.split(" ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init() {
        initConfig();
        createAction();
        this.setJMenuBar(createMenubar());
        JScrollPane sp = new JScrollPane();
        add(sp);
        setSize(600, 500);
        setVisible(true);
    }

    @Override
    public void setFile(File f) {
        curFile = f;
    }

    @Override
    public File getFile() {
        return curFile;
    }

    public static void main(String[] args) {
        new MyFrame().init();
    }
}
