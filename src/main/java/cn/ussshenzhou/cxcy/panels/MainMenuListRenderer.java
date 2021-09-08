package cn.ussshenzhou.cxcy.panels;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * @author USS_Shenzhou
 */
public class MainMenuListRenderer implements ListCellRenderer {

    JLabel label = new JLabel();
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setText(value.toString());
        label.setBorder(BorderFactory.createBevelBorder(50,new Color(0xffffff),new Color(0x000000)));
        label.setOpaque(true);
        label.setFont(new Font("Microsoft YaHei UI",Font.PLAIN,17));
        label.setPreferredSize(new Dimension(0,50));
        if (isSelected){
            label.setBackground(list.getSelectionBackground());
            label.setForeground(list.getSelectionForeground());
        } else {
            label.setBackground(list.getBackground());
            label.setForeground(list.getForeground());
        }
        return label;
    }
}
