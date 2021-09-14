package cn.ussshenzhou.cxcy.widgets;

import com.sun.java.swing.plaf.motif.MotifButtonUI;
import com.sun.java.swing.plaf.windows.WindowsButtonUI;
import com.sun.java.swing.plaf.windows.WindowsToggleButtonUI;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicToggleButtonUI;
import javax.swing.plaf.metal.MetalButtonUI;
import javax.swing.plaf.synth.SynthButtonUI;
import java.awt.*;

/**
 * @author USS_Shenzhou
 */
public class CButton extends JButton {
    public CButton(String text) {
        super(text);
        this.setFont(new Font("Microsoft YaHei UI",Font.PLAIN,18));
        this.setForeground(new Color(0x000000));

        //this.setContentAreaFilled(false);
        //this.setFocusPainted(false);

        this.setUI(new WindowsButtonUI());
    }
}
