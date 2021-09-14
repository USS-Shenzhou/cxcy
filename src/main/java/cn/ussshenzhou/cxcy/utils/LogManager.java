package cn.ussshenzhou.cxcy.utils;

import cn.ussshenzhou.cxcy.Cxcy;
import cn.ussshenzhou.cxcy.panels.LogViewer;
import cn.ussshenzhou.cxcy.panels.MainViewPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.logging.*;

/**
 * @author USS_Shenzhou
 */
public class LogManager {
    public static final Logger LOGGER = Logger.getLogger("cxcy");
    private static FileHandler fileHandler;

    public static void init() {
        {
            try {
                fileHandler = new FileHandler("info.log");
            } catch (IOException ignored) {
            }
        }
        fileHandler.setFormatter(new Formatter());
        LOGGER.addHandler(fileHandler);

        WindowHandler windowHandler = new WindowHandler();
        windowHandler.setFormatter(new Formatter());
        LOGGER.addHandler(windowHandler);
        LOGGER.info("start!");
    }

    private static class WindowHandler extends StreamHandler {

        @Override
        public synchronized void publish(LogRecord record) {
            super.publish(record);
            try {
                String msg = getFormatter().format(record);

                for (JPanel p : Cxcy.getMainWindow().getMainViewPanel().getAllPanels()) {
                    JTextArea log = ((LogViewer) p).getLog();
                    if (Level.SEVERE.equals(record.getLevel())) {
                        log.setForeground(new Color(0xAB3636));
                    } else if (Level.WARNING.equals(record.getLevel())) {
                        log.setForeground(new Color(0x9F9624));
                    } else if (Level.INFO.equals(record.getLevel())) {
                        log.setForeground(new Color(0x2b7cb3));
                    } else {
                        log.setForeground(new Color(0x297D19));
                    }
                    log.setText(msg);
                }
            } catch (Exception ignored) {
            }
        }
    }

    private static class Formatter extends java.util.logging.Formatter {
        @Override
        public String format(LogRecord record) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(record.getMillis());
            return "["
                    + calendar.get(Calendar.HOUR_OF_DAY)
                    + ":"
                    + calendar.get(Calendar.MINUTE)
                    + ":"
                    + calendar.get(Calendar.SECOND)
                    + "] ["
                    + Thread.currentThread().getName()
                    + "/"
                    + record.getLevel()
                    + "] ["
                    + record.getSourceClassName()
                    + "/"
                    + record.getSourceMethodName()
                    + "]: "
                    + record.getMessage()
                    + "\n"
                    ;
        }

    }
}
