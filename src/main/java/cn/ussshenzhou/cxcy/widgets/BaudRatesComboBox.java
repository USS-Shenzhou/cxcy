package cn.ussshenzhou.cxcy.widgets;

import cn.ussshenzhou.cxcy.Cxcy;
import cn.ussshenzhou.cxcy.communicate.CommManager;
import cn.ussshenzhou.cxcy.utils.LogManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author USS_Shenzhou
 */
public class BaudRatesComboBox extends JComboBox<Integer> {
    public BaudRatesComboBox() {
        this.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));

        this.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Cxcy.dataThread.add(() -> {
                        CommManager.setBaudRate((Integer) e.getItem());
                    });
                }
            }
        });
        this.addItem(9600);
        this.addItem(14400);
        this.addItem(19200);
        this.addItem(38400);
        this.addItem(43000);
        this.addItem(57600);
        this.addItem(76800);
        this.addItem(115200);
    }
}
