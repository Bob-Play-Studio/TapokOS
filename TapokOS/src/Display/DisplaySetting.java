package Display;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import backend.*;
public class DisplaySetting extends JPanel implements Runnable {
	public final int tileSize = 48;
	final int maxScreenCol = 32;
	final int maxScreenRow = 26;
	public final int WIDTH = maxScreenCol * tileSize;
	public final int HEIGHT = maxScreenRow * tileSize;
	public boolean runningCMD = false, cmd = true;
	public String command = " ";
	Thread OS;
	boolean helpRun = false;
	boolean send = false;
	DisplayControl dc = new DisplayControl(this);
	DisplayDraw dr = new DisplayDraw(this, dc);
	public DisplaySetting() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.blue);
		this.setDoubleBuffered(true);
		this.addKeyListener(dc);
		this.addMouseListener(dc);
	}
	public void OSthread() {
		OS = new Thread(this);
		OS.start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(dr.screen, 0, 0, WIDTH, HEIGHT, null);
		dr.drawMenu(g2);
		if(dc.rightClick) {
			runningCMD = false;
			
		}
		if(dc.cmdClick && cmd) {
			runningCMD = true;
			if(runningCMD) {
				dr.drawCMD(g2);
				dr.drawTextCmd(g2);
				if(send) {
					dr.drawTextCmd(g2);
				}
			}
		}
		dr.draw(g2);
		g2.dispose();
	}
	public void save() {
		try {
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("save.txt", true)));
			writer.write(command);
			writer.println(helpRun);
			writer.print(runningCMD);
			writer.print(dc.cmdClick);
			writer.print(dc.menuOpen);
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		if(runningCMD) {
			if(dc.q) {
				command += "q";
			}
			if(dc.w) {
				command += "w";
			}
			if(dc.e) {
				command += "e";
			}
			if(dc.r) {
				command += "r";
			}
			if(dc.t) {
				command += "t";
			}
			if(dc.y) {
				command += "y";
			}
			if(dc.u) {
				command += "u";
			}
			if(dc.i) {
				command += "i";
			}
			if(dc.o) {
				command += "o";
			}
			if(dc.p) {
				command += "p";
			}
			if(dc.a) {
				command += "a";
			}
			if(dc.s) {
				command += "s";
			}
			if(dc.d) {
				command += "d";
			}
			if(dc.f) {
				command += "f";
			}
			if(dc.g) {
				command += "g";
			}
			if(dc.h) {
				command += "h";
			}
			if(dc.j) {
				command += "j";
			}
			if(dc.k) {
				command += "k";
			}
			if(dc.l) {
				command += "l";
			}
			if(dc.z) {
				command += "z";
			}
			if(dc.x) {
				command += "x";
			}
			if(dc.c) {
				command += "c";
			}
			if(dc.v) {
				command += "v";
			}
			if(dc.b) {
				command += "b";
			}
			if(dc.n) {
				command += "n";
			}
			if(dc.m) {
				command += "m";
			}
			if(dc.space) {
				command += " ";
			}
			if(dc.enter) {
				send = true;
			}
			if(dc.backspace) {
				command = "";
			}
		}
		switch(command) {
		case "help":
			helpRun = true;
		break;
		}
		dr.getOSimage();
	}
	public void run() {
		while(OS != null) {
			update();
			repaint();
			save();
			try {
				OS.sleep(16);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
