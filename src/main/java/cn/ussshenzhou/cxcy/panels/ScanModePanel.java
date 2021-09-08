package cn.ussshenzhou.cxcy.panels;

import cn.ussshenzhou.cxcy.widgets.DepthGradientBar;
import cn.ussshenzhou.cxcy.widgets.RadarPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author USS_Shenzhou
 */
public class ScanModePanel extends JPanel {
    RadarPanel radarPanel = new RadarPanel();
    DepthGradientBar depthGradientBar = new DepthGradientBar();

    public ScanModePanel() {
        super();
        this.setLayout(new Layout());

        this.add(depthGradientBar);
        this.add(radarPanel);
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
            if (radarPanel.isVisible()) {
                radarPanel.setBounds((int) (width * 0.01), (int) (width * 0.01), (int) (width * 0.4), (int) (width * 0.4));
            }
            if (depthGradientBar.isVisible()){
                depthGradientBar.setBounds((int) (width * 0.43), (int) (width * 0.01), (int) (width * 0.02), (int) (width * 0.4));
            }
        }
    }
}
