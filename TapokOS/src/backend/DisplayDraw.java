package backend;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.*;
import javax.swing.*;

import java.util.*;
import Display.*;

import java.io.*;
public class DisplayDraw  {
	Random rand = new Random();
	JTextArea textArea;
	public int cmdXrand = rand.nextInt(500);
	public int cmdYrand = rand.nextInt(500);
	public int cmdX = 150;
	public int cmdY = 150;
	public int crestX = cmdX+cmdXrand;
	public int crestY = cmdY+cmdYrand;
	public int menuX = 0;
	public int menuY = 1200;
	public int logoX = 1430;
	public int logoY = menuY;
	public int textX = 300;
	public int textY = 150;
	public int settingX = 150;
	public int settingY = 300;
	public int settingXrand = rand.nextInt(500);
	public int settingYrand = rand.nextInt(500);
	public String time = new java.util.Date().toString();
	DisplayControl dc;
	DisplaySetting ds;
	public BufferedImage command, logo, screen, textedit, setting, photo, screen1, screen2, screen3;
	public DisplayDraw(DisplaySetting ds, DisplayControl dc) {
		this.ds = ds;
		this.dc = dc;
		textArea = new JTextArea();
	}
	public void getOSimage() {
		try {
			command = ImageIO.read(getClass().getResourceAsStream("/app/command.png"));
			logo = ImageIO.read(getClass().getResourceAsStream("/logo/logo.png"));
			screen = ImageIO.read(getClass().getResourceAsStream("/logo/tapokOS.png"));	
			screen1 = ImageIO.read(getClass().getResourceAsStream("/logo/screen2.png"));
			screen2 = ImageIO.read(getClass().getResourceAsStream("/logo/screen3.png"));
			screen3 = ImageIO.read(getClass().getResourceAsStream("/logo/screen4.png"));
			textedit = ImageIO.read(getClass().getResourceAsStream("/app/textedit.png"));
			setting = ImageIO.read(getClass().getResourceAsStream("/app/setting.png"));
			if(dc.screenClick) {
				photo = screen;
			}
			if(dc.screen1Click) {
				photo = screen1;
			}
			if(dc.screen2Click) {
				photo = screen2;
			}
			if(dc.screen3Click) {
				photo = screen3;
			}
		} catch(IOException e) {
			JOptionPane.showMessageDialog(null, "ERROR LOAD IMAGE");
		}
	}
	public void draw(Graphics2D g2) {
		g2.drawImage(command, cmdX, cmdY, ds.tileSize * 2, ds.tileSize * 2, null);
		g2.drawImage(textedit, textX, textY, ds.tileSize * 2, ds.tileSize * 2, null);
		g2.drawImage(setting, settingX, settingY, ds.tileSize * 2, ds.tileSize * 2,  null);
	}
	public void drawCMD(Graphics2D g2) {
		g2.setColor(Color.black);
		g2.fillRect(cmdX+cmdXrand, cmdY+cmdYrand, ds.tileSize*6, ds.tileSize*6);
		textArea.setPreferredSize(new Dimension(ds.tileSize*4, ds.tileSize*4));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Arial", Font.PLAIN, 20));
		g2.setColor(Color.white);
		g2.fillRect(cmdX+cmdXrand, cmdY+cmdYrand, ds.tileSize*6, cmdX/4);
		g2.setColor(Color.red);
		g2.fillOval(crestX, crestY, 20, 20);
	}
	public void drawTextCmd(Graphics2D g2) {
		g2.drawString("/>", cmdX+cmdXrand+25, cmdY+cmdYrand+50);
		if(dc.w) {
			ds.update();
		}
	}
	public void drawMenu(Graphics2D g2) {
		g2.setColor(Color.WHITE);
		g2.fillRect(menuX, menuY, 1536, ds.tileSize);
		g2.setColor(Color.black);
		g2.drawString(time, menuX, menuY + 20);
		g2.drawImage(logo, logoX, logoY, ds.tileSize*2, ds.tileSize*2, null);
		if(dc.menuOpen) {
			g2.fillRect(logoX, logoY-96, ds.tileSize*2, ds.tileSize*5);
			g2.setColor(Color.red);
			g2.fillRect(logoX, logoY-48, ds.tileSize*2, ds.tileSize);
		}
		
	}
	public void drawHelp(Graphics2D g2) {
		g2.drawString("command: \n 1.time \n 2. exit 3.app", cmdX, cmdY);
	}
	public void drawTextEdit(Graphics2D g2) {
		
	}
	public void drawSetting(Graphics2D g2) {
		g2.setColor(Color.gray);
		g2.fillRect(settingX + settingXrand, settingY + settingYrand, ds.tileSize * 6, ds.tileSize * 6);
		g2.setColor(Color.white);
		g2.fillRect(settingX+settingXrand, settingY+settingYrand, ds.tileSize*6, settingX/4);
		g2.setColor(Color.red);
		g2.fillOval(settingX+settingXrand, settingY+settingYrand, 20, 20);
		if(ds.settingOpen) {
			g2.drawImage(screen, ds.imageX, ds.imageY, ds.tileSize, ds.tileSize,  null);
			g2.drawImage(screen1, ds.imageX+96, ds.imageY, ds.tileSize, ds.tileSize,  null);
			g2.drawImage(screen2, ds.imageX, ds.imageY+96, ds.tileSize, ds.tileSize,  null);
			g2.drawImage(screen3, ds.imageX+96, ds.imageY+96, ds.tileSize, ds.tileSize,  null);
		}
	}
}
