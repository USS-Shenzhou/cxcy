package cn.ussshenzhou.cxcy.panels;

import cn.ussshenzhou.cxcy.jogl.RadarPanel3d;
import cn.ussshenzhou.cxcy.widgets.DepthGradientBar;
import cn.ussshenzhou.cxcy.widgets.RadarPanel;
import com.jogamp.opengl.awt.GLJPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author USS_Shenzhou
 */
public class ScanModePanel extends JPanel implements LogViewer {

    JTextArea log = new JTextArea();

    RadarPanel3d radarPanel3d = new RadarPanel3d();
    //RadarPanel radarPanel = new RadarPanel();
    //DepthGradientBar depthGradientBar = new DepthGradientBar();
    //JLabel depth1 = new JLabel("0");
    //JLabel depth3 = new JLabel("3 m");


    public ScanModePanel() {
        super();
        this.setLayout(new Layout());

        //depth1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        //depth3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));

        log.setEditable(false);
        this.add(log);
        this.add(radarPanel3d);
        //this.add(depth1);
        //this.add(depth3);
        //this.add(depthGradientBar);
        //this.add(radarPanel);

    }

    //public RadarPanel getRadarPanel() {
    //    return radarPanel;
    //}

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
            //if (radarPanel.isVisible()) {
            //    radarPanel.setBounds((int) (width * 0.01), (int) (width * 0.01), (int) (width * 0.4), (int) (width * 0.4));
            //}
            //if (depthGradientBar.isVisible()) {
            //    depthGradientBar.setBounds((int) (width * 0.43), (int) (width * 0.01), (int) (width * 0.02), (int) (width * 0.4));
            //}
            //if (depth1.isVisible()) {
            //    depth1.setBounds((int) (width * 0.455), (int) (width * 0.01) - 10, 80, 40);
            //}
            //if (depth3.isVisible()) {
            //    depth3.setBounds((int) (width * 0.455), (int) (width * 0.41) - 30, 80, 40);
            //}
            if (radarPanel3d.isVisible()) {
                radarPanel3d.setBounds(0, 0, width, height);
            }
        }
    }
}
