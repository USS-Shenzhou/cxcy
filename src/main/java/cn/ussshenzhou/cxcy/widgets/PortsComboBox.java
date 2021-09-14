package cn.ussshenzhou.cxcy.widgets;

import cn.ussshenzhou.cxcy.Cxcy;
import cn.ussshenzhou.cxcy.communicate.CommManager;
import cn.ussshenzhou.cxcy.utils.LogManager;
import com.sun.java.swing.plaf.windows.WindowsComboBoxUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author USS_Shenzhou
 */
public class PortsComboBox extends JComboBox<String> {
    public PortsComboBox() {
        this.refresh();
        this.setUI(new WindowsComboBoxUI());
        this.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));

        this.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });

        this.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Cxcy.dataThread.add(()->{
                            CommManager.setPort((String) e.getItem());
                    });
                }
            }
        });
    }

    public void refresh() {
        this.removeAllItems();
        Cxcy.dataThread.add(
                CommManager::refreshPorts,
                () -> {
                    for (String s : CommManager.getPortNames()) {
                        SwingUtilities.invokeLater(() -> {
                            this.addItem(s);
                        });
                    }
                });
    }
}
