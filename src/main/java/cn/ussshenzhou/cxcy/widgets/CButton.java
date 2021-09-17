package cn.ussshenzhou.cxcy.widgets;


import javax.swing.*;
import java.awt.*;

/**
 * @author USS_Shenzhou
 */
public class CButton extends JButton {
    public CButton(String text) {
        super(text);
        this.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        this.setForeground(new Color(0x000000));

        //this.setContentAreaFilled(false);
        //this.setFocusPainted(false);

    }
}
