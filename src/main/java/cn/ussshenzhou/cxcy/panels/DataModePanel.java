package cn.ussshenzhou.cxcy.panels;

import javax.swing.*;

/**
 * @author USS_Shenzhou
 */
public class DataModePanel extends JPanel implements LogViewer {
    JTextArea log = new JTextArea();

    @Override
    public JTextArea getLog() {
        return log;
    }
}
