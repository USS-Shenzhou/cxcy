package cn.ussshenzhou.cxcy.panels;

import cn.ussshenzhou.cxcy.widgets.CButton;

import javax.swing.*;
import java.awt.*;

/**
 * @author USS_Shenzhou
 */
public class MainMenuList extends JList<String> {
    public MainMenuList() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("实时扫描");
        listModel.addElement("离线数据");
        listModel.addElement("设置");

        this.setModel(listModel);
        this.setCellRenderer(new MainMenuListRenderer());
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setPreferredSize(new Dimension(200, 0));
        this.setBackground(new Color(0x151f26));
        this.setForeground(new Color(0x84c8f5));
        this.setSelectionBackground(new Color(0x184766));
        this.setSelectionForeground(new Color(0x84c8f5));
    }

}
