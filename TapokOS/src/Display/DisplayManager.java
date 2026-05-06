package Display;
import java.awt.*;

import javax.swing.*;
public class DisplayManager  {
	public static void main(String[] args) {
        JWindow splash = new JWindow();
        JLabel label = new JLabel("TapokOS загружается...", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(Color.CYAN);
        label.setBackground(new Color(30, 30, 40));
        label.setOpaque(true);
        splash.add(label);
        splash.setSize(350, 150);
        splash.setLocationRelativeTo(null);
        splash.setVisible(true);
        
        try { Thread.sleep(2000); } catch(Exception e) {} // Ждём 2 секунды
        splash.dispose();
		JFrame windows = new JFrame();
		windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windows.setTitle("TapokOS");
		windows.setResizable(false);
		DisplaySetting ds = new DisplaySetting();
		windows.add(ds);
		windows.pack();
		windows.setVisible(true);
		windows.setLocationRelativeTo(null);
		ds.OSthread();
	}
}
