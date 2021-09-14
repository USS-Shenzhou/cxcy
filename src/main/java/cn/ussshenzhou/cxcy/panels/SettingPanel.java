package cn.ussshenzhou.cxcy.panels;

import cn.ussshenzhou.cxcy.widgets.BaudRatesComboBox;
import cn.ussshenzhou.cxcy.widgets.CButton;
import cn.ussshenzhou.cxcy.widgets.PortsComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author USS_Shenzhou
 */
public class SettingPanel extends JPanel implements LogViewer{

    JTextArea log = new JTextArea();

    JLabel serial = new JLabel("串口设置");

    JLabel portChoose = new JLabel("端口选择");
    PortsComboBox ports = new PortsComboBox();
    CButton refreshPorts = new CButton("刷新");

    JLabel portBaudRate = new JLabel("波特率");
    BaudRatesComboBox baudRatesComboBox = new BaudRatesComboBox();


    int titleSize = 24;
    int textSize = 18;


    public SettingPanel() {
        super();
        this.setLayout(new Layout());
        serial.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, titleSize));

        portChoose.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, textSize));
        portBaudRate.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, textSize));
        log.setEditable(false);

        this.add(log);
        this.add(serial);
        this.add(ports);
        this.add(refreshPorts);
        this.add(portChoose);
        this.add(portBaudRate);
        this.add(baudRatesComboBox);

        refreshPorts.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                ports.refresh();
            }
        });
    }

    @Override
    public JTextArea getLog() {
        return log;
    }


    private class Layout implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {

        }

        @Override
        public void removeLayoutComponent(Component comp) {

        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return null;
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return null;
        }

        @Override
        public void layoutContainer(Container parent) {
            int width = parent.getWidth();
            int height = parent.getHeight();

            if (log.isVisible()) {
                log.setBounds(0, height - 20, width, 20);
            }

            int titleX = (int) (width * 0.01);
            int titleWidth = 150;
            int titleHeight = 50;
            int textX = (int) (width * 0.05);
            int textWidth = 100;
            int textHeight = 40;
            int spaceY = 5;
            int spaceX = 10;

            if (serial.isVisible()) {
                serial.setBounds(titleX, titleX, titleWidth, titleHeight);
            }
            if (portChoose.isVisible()) {
                portChoose.setBounds(textX, titleX + titleHeight + spaceY, textWidth, textHeight);
            }
            if (ports.isVisible()) {
                ports.setBounds(textX + textWidth + spaceX, titleX + titleHeight + spaceY, textWidth, textHeight);
            }
            if (refreshPorts.isVisible()) {
                refreshPorts.setBounds(textX + (textWidth + spaceX) * 2, titleX + titleHeight + spaceY, textWidth, textHeight);
            }
            if (portBaudRate.isVisible()) {
                portBaudRate.setBounds(textX, titleX + (titleHeight + spaceY) * 2, textWidth, textHeight);
            }
            if (baudRatesComboBox.isVisible()){
                baudRatesComboBox.setBounds(textX + textWidth + spaceX,titleX + (titleHeight + spaceY) * 2, textWidth, textHeight);
            }
        }
    }
}
