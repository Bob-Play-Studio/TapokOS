package Display;
import java.awt.*;
import javax.swing.*;
public class DisplayManager  {
	public static void main(String[] args) {
		JPanel panel = new JPanel(new BorderLayout()); 
        JWindow splash = new JWindow();
        JLabel label = new JLabel("TapokOS beta 2 загружается...", SwingConstants.CENTER);
        JLabel label1 = new JLabel("Bob Play Stutio™", SwingConstants.CENTER);
        label1.setFont(new Font("Arial", Font.BOLD, 12));
        label1.setForeground(Color.CYAN);
        label1.setBackground(new Color(30, 30, 40));
        label1.setOpaque(true);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(Color.CYAN);
        label.setBackground(new Color(30, 30, 40));
        label.setOpaque(true);
        panel.add(label, BorderLayout.CENTER);
        panel.add(label1, BorderLayout.SOUTH);
        splash.add(panel);
        splash.setSize(350, 150);
        splash.setLocationRelativeTo(null);
        splash.setVisible(true);
        
        try { Thread.sleep(2000); } catch(Exception e) {} // Ждём 2 секунды
        splash.dispose();
		JFrame windows = new JFrame();
		windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windows.setTitle("TapokOS beta 2");
		windows.setResizable(false);
		DisplaySetting ds = new DisplaySetting();
		windows.add(ds);
		windows.pack();
		windows.setVisible(true);
		windows.setLocationRelativeTo(null);
		ds.OSthread();
		JOptionPane.showMessageDialog(null, "Добро пожаловать, вот управление:\n 1. esc - закрыть все окна 2. ЛКМ - открыть окно 3. ПКМ - изменить фото в настройках \n "
				+ " обновления: \n TapokOS beta 1: \n cmd, закрытие окон, время, выключение \n TapokOS beta 2: \n исправление esc добавление смены обоев и этого сообщения ");
	}
}
