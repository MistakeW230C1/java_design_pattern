package com.mistake.day8.demo4;


import com.sun.management.OperatingSystemMXBean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.ManagementFactory;

/**
 * 类描述：主窗口
 *
 * @version $Id: Exp$
 * <p>
 * History: Dec 26, 2014 3:47:44 PM Jing Created.
 * @author: Jing
 */
public class MyFrame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    /**
     * 参数面板
     */
    CtrlPanel ctrlPanel = new CtrlPanel();
    /**
     * 数值显示面板
     */
    ContentPanel contentPanel = new ContentPanel();
    /**
     * 状态面板
     */
    StatePanel statePanel = new StatePanel();
    /**
     * 定时器
     */
    Timer timer = new Timer(1000, this);

    int high, mid;

    /**
     * 方法说明：初始化
     * <p>
     * Author： Jing Create Date： Dec 26, 2014 3:51:54 PM
     *
     * @return void
     */
    public void init() {
        add(ctrlPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(statePanel, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 220);
        setVisible(true);
    }

    /**
     * 方法说明：启动自动检测
     * <p>
     * Author： Jing Create Date： Dec 26, 2014 3:53:53 PM
     *
     * @param high
     * @param mid
     * @return void
     */
    public void startMonitor(int high, int mid) {

        this.high = high;
        this.mid = mid;

        timer.start();

    }

    /**
     * 方法说明：停止检测
     * <p>
     * Author： Jing Create Date： Dec 26, 2014 3:54:51 PM
     *
     * @return void
     */
    public void stopMonitor() {
        timer.stop();
    }

    public void actionPerformed(ActionEvent e) {// 定时器响应方法
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long total = osmxb.getTotalPhysicalMemorySize();
        long free = osmxb.getFreePhysicalMemorySize();
        int ratio = (int) (free * 100L / total);

        contentPanel.setValue(total / (1024 * 1024), free / (1024 * 1024), ratio);

        int mark = -1;
        if (ratio >= high) {

            mark = 1;
        } else if (ratio < mid) {

            mark = 3;
        } else {

            mark = 2;
        }
        statePanel.setState(mark);
        statePanel.process();
    }

}
