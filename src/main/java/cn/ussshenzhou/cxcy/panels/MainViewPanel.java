package cn.ussshenzhou.cxcy.panels;

import javax.swing.*;
import java.awt.*;

/**
 * @author USS_Shenzhou
 */
public class MainViewPanel extends JPanel {

    ScanModePanel scanModePanel = new ScanModePanel();
    DataModePanel dataModePanel = new DataModePanel();

    JPanel currentPanel;

    public MainViewPanel() {
        super();
        this.setLayout(new CardLayout());

        this.add(scanModePanel, "scan");
        this.add(dataModePanel, "data");
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
            default:
                this.setShow("scan");
                currentPanel = scanModePanel;
                break;
        }
    }

    public JPanel getCurrentPanel(){
        return currentPanel;
    }
}
