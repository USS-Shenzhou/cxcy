package cn.ussshenzhou.cxcy.panels;

import cn.ussshenzhou.cxcy.utils.LogManager;
import com.sun.java.swing.plaf.windows.WindowsScrollPaneUI;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.awt.*;

/**
 * @author USS_Shenzhou
 */
public class MainViewPanel extends JPanel {

    ScanModePanel scanModePanel = new ScanModePanel();
    DataModePanel dataModePanel = new DataModePanel();
    SettingPanel settingPanel = new SettingPanel();

    static JPanel currentPanel;

    public MainViewPanel() {
        super();
        this.setLayout(new CardLayout());

        this.add(scanModePanel, "scan");
        this.add(dataModePanel, "data");
        this.add(settingPanel,"setting");

    }

    private void setShow(String name) {
        CardLayout cardLayout = (CardLayout) this.getLayout();
        cardLayout.show(this, name);
    }

    public void setShow(int i){
        switch (i){
            case 0:
                this.setShow("scan");
                currentPanel = scanModePanel;
                break;
            case 1:
                this.setShow("data");
                currentPanel = dataModePanel;
                break;
            case 2:
                this.setShow("setting");
                currentPanel = settingPanel;
                break;
            default:
                this.setShow("scan");
                currentPanel = scanModePanel;
                break;
        }
    }

    public static JPanel getCurrentPanel(){
        return currentPanel;
    }

    public JPanel[] getAllPanels(){
        return new JPanel[]{this.scanModePanel,this.dataModePanel,this.settingPanel};
    }
}
