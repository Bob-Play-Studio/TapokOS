package backend;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.*;
import java.util.*;
import Display.*;

import java.io.*;
public class DisplayDraw {
	Random rand = new Random();
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
	public String time = new java.util.Date().toString();
	DisplayControl dc;
	DisplaySetting ds;
	public BufferedImage command, logo, screen;
	public DisplayDraw(DisplaySetting ds, DisplayControl dc) {
		this.ds = ds;
		this.dc = dc;
	}
	public void getOSimage() {
		try {
			command = ImageIO.read(getClass().getResource("/app/command.png"));
			logo = ImageIO.read(getClass().getResource("/logo/logo.png"));
			screen = ImageIO.read(getClass().getResource("/logo/tapokOS.png"));		
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void draw(Graphics2D g2) {
		g2.drawImage(command, cmdX, cmdY, ds.tileSize * 2, ds.tileSize * 2, null);
	}
	public void drawCMD(Graphics2D g2) {
		g2.setColor(Color.black);
		g2.fillRect(cmdX+cmdXrand, cmdY+cmdYrand, ds.tileSize*6, ds.tileSize*6);
		g2.setColor(Color.GREEN);
		g2.fillRect(cmdX+cmdXrand, cmdY+cmdYrand, ds.tileSize*6, cmdX/4);
		g2.setColor(Color.red);
		g2.fillOval(crestX, crestY, 15, 15);
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
}
