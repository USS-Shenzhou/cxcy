package cn.ussshenzhou.cxcy;

import cn.ussshenzhou.cxcy.panels.MainMenuList;
import cn.ussshenzhou.cxcy.panels.MainViewPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author USS_Shenzhou
 */
public class MainWindow extends JFrame {

    MainMenuList mainMenuList = new MainMenuList();
    MainViewPanel mainViewPanel = new MainViewPanel();

    public MainWindow(String title) throws HeadlessException {
        super(title);
        Container rootContainer = this.getContentPane();
        rootContainer.setLayout(new BorderLayout());

        this.initListener();

        rootContainer.add(mainMenuList,BorderLayout.LINE_START);
        rootContainer.add(mainViewPanel,BorderLayout.CENTER);
        mainMenuList.setSelectedIndex(0);
        mainViewPanel.setShow(0);
    }

    private void initListener(){

        mainMenuList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int i = mainMenuList.locationToIndex(e.getPoint());
                if (i>=0){
                    mainViewPanel.setShow(i);
                }
            }
        });
    }

    public MainViewPanel getMainViewPanel(){
        return  this.mainViewPanel;
    }
}
