package th.co.softpos.ws.tray;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import th.co.softpos.ws.main.SPClientUI;

public class SystemTrayMain {

    public static void main(String[] args) {
        if (!SystemTray.isSupported()) {
            System.err.println("System tray is not supported !!! ");
        }

        SystemTray systemTray = SystemTray.getSystemTray();
        URL pathImg = SystemTrayMain.class.getClassLoader().getResource("services_tray.png");
//        Image image = Toolkit.getDefaultToolkit().getImage("src/main/resources/services_tray.png");
        Image image = Toolkit.getDefaultToolkit().getImage(pathImg);

        PopupMenu trayPopupMenu = new PopupMenu();
        MenuItem action = new MenuItem("Open");
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SPClientUI openUi = new SPClientUI(null, true);
                openUi.setVisible(true);
            }
        });
        trayPopupMenu.add(action);
        trayPopupMenu.addSeparator();
        
        MenuItem close = new MenuItem("Close");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        trayPopupMenu.add(close);
        
        TrayIcon trayIcon = new TrayIcon(image, "Softpos Service Client", trayPopupMenu);
        trayIcon.setImageAutoSize(true);
        try {
            systemTray.add(trayIcon);
        } catch (AWTException e) {
        }
    }
}
