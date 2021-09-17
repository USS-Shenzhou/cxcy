package cn.ussshenzhou.cxcy.communicate;

import cn.ussshenzhou.cxcy.panels.DataModePanel;
import cn.ussshenzhou.cxcy.panels.MainViewPanel;
import cn.ussshenzhou.cxcy.panels.ScanModePanel;
import cn.ussshenzhou.cxcy.utils.LogManager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author USS_Shenzhou
 */
public class DecodeManager {
    private static final char SPLIT = ' ';

    public static void decode() {
        ArrayList<Character> characters = CommManager.readPortAsChars();
        if (MainViewPanel.getCurrentPanel() instanceof ScanModePanel) {
            ArrayList<String> strings = new ArrayList<>();
            StringBuilder s = new StringBuilder();

            for (char c : characters) {
                if (Character.isDigit(c) || c == '-') {
                    s.append(c);
                } else if (c == SPLIT) {
                    strings.add(s.toString());
                    s = new StringBuilder();
                }
            }

            if (s.length() != 0) {
                strings.add(s.toString());
                s = new StringBuilder();
            }
            SwingUtilities.invokeLater(() -> {
                //((ScanModePanel) MainViewPanel.getCurrentPanel()).getRadarPanel().setPointByStringArray(strings);
            });
            LogManager.LOGGER.info(strings.toString());
        } else if (MainViewPanel.getCurrentPanel() instanceof DataModePanel) {

        } else {

        }
    }
}
