package cn.ussshenzhou.cxcy;

import javax.swing.*;
import java.awt.*;

/**
 * @author USS_Shenzhou
 */
public class Cxcy {

    public static void main(String[] strings) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                init();
            }
        });
    }

    private static void init(){
        MainWindow mainWindow = new MainWindow("电磁探测系统可视化程序");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(1152,648);
        mainWindow.setVisible(true);
    }
}
