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
import java.util.Timer;
import javax.swing.JOptionPane;
import th.co.softpos.ws.client.POSConstant;
import th.co.softpos.ws.main.ConfigUI;
import th.co.softpos.ws.main.SPClientUI;
import th.co.softpos.ws.main.TaskUI;

public class SystemTrayMain {

    public static TrayIcon trayIcon;

    public static void main(String[] args) {
        if (!SystemTray.isSupported()) {
            JOptionPane.showMessageDialog(null, "System tray is not supported !!! ");
        }

        SystemTray systemTray = SystemTray.getSystemTray();
        String pathImg = "app/services_tray.png";
        Image image = Toolkit.getDefaultToolkit().getImage(pathImg);

        PopupMenu trayPopupMenu = new PopupMenu();
        MenuItem mServiceTest = new MenuItem("Service Test");
        mServiceTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SPClientUI openUi = new SPClientUI(null, true);
                openUi.setVisible(true);
            }
        });
        trayPopupMenu.add(mServiceTest);
        MenuItem mTaskMonitor = new MenuItem("Task Monitor");
        mTaskMonitor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaskUI task = new TaskUI(null, true);
                task.setVisible(true);
            }
        });
        trayPopupMenu.add(mTaskMonitor);
        trayPopupMenu.addSeparator();

        MenuItem mConfig = new MenuItem("Configuration");
        mConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfigUI config = new ConfigUI(null, true);
                config.setVisible(true);
            }
        });
        trayPopupMenu.add(mConfig);
        trayPopupMenu.addSeparator();

        MenuItem mExit = new MenuItem("Exit");
        mExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trayIcon.displayMessage("Softpos Service Client", "Close Service Monitor Bye", TrayIcon.MessageType.WARNING);
                System.exit(0);
            }
        });
        trayPopupMenu.add(mExit);

        trayIcon = new TrayIcon(image, "Softpos Service Client", trayPopupMenu);
        trayIcon.setImageAutoSize(true);
        try {
            systemTray.add(trayIcon);
            trayIcon.displayMessage("Softpos Service Client", "Service Monitor Working", TrayIcon.MessageType.INFO);
        } catch (AWTException e) {
        }

        // start service task automation
        System.out.println("Start Task Schedule Jobs");
        Timer timeTask = new Timer();
        ServicesTask serviceTask = new ServicesTask("ServiceTask");
        timeTask.scheduleAtFixedRate(serviceTask, 1000, POSConstant.SCHEDULE_TASK);
    }
}
