package cn.ussshenzhou.cxcy;

import cn.ussshenzhou.cxcy.communicate.DataThread;
import cn.ussshenzhou.cxcy.utils.LogManager;

import javax.swing.*;
import javax.swing.plaf.synth.SynthLookAndFeel;
import java.awt.*;

/**
 * @author USS_Shenzhou
 */
public class Cxcy {

    public static DataThread dataThread = new DataThread();
    static MainWindow mainWindow = new MainWindow("电磁探测系统可视化程序");

    public static void main(String[] strings) {
        Thread.currentThread().setName("Render Thread");
        LogManager.init();


        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                init();
            }
        });

        dataThread.setName("Data Thread");
        dataThread.start();
    }

    private static void init() {
        try {
            UIManager.setLookAndFeel(new SynthLookAndFeel());
        } catch (UnsupportedLookAndFeelException ignored) {
        }
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(1152, 648);
        mainWindow.setVisible(true);
        mainWindow.setMinimumSize(new Dimension(800, 600));
    }

    public static MainWindow getMainWindow() {
        return mainWindow;
    }
}
