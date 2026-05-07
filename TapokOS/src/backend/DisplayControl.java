package backend;
import java.awt.event.*;

import javax.swing.JOptionPane;

import Display.*;
import java.awt.*;
public class DisplayControl implements MouseListener, KeyListener, ActionListener {
	public boolean leftClick = false, rightClick = false, cmdClick = false, menuOpen = false;;
	DisplaySetting ds;
	public String input = "";
	public boolean q, w, e, r, t, y, u,  i, o, p, a, s, d, f, g, h, j, k, l,z, x, c, v, b, n, m, space, enter, backspace, close;
	DisplayDraw dr = new DisplayDraw(ds, this);
	public void command() {
		switch(input) {
		case "help":
			JOptionPane.showMessageDialog(null, "1.help/n 2.exit\n 3.time");
		break;
		}
	}
	public DisplayControl(DisplaySetting ds) {
		this.ds = ds;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent E) {
		int code = E.getKeyCode();
		if(code == KeyEvent.VK_Q) {
			q = true;
		}
		if(code == KeyEvent.VK_W) {
			w = true;
		}
		if(code == KeyEvent.VK_E) {
			e = true;
		}
		if(code == KeyEvent.VK_R) {
			r = true;
		}
		if(code == KeyEvent.VK_T) {
			t = true;
		}
		if(code == KeyEvent.VK_Y) {
			y = true;
		}
		if(code == KeyEvent.VK_U) {
			u = true;
		}
		if(code == KeyEvent.VK_I) {
			i = true;
		}
		if(code == KeyEvent.VK_O) {
			o = true;
		}
		if(code == KeyEvent.VK_P) {
			p = true;
		}
		if(code == KeyEvent.VK_A) {
			a = true;
		}
		if(code == KeyEvent.VK_S) {
			s = true;
		}
		if(code == KeyEvent.VK_D) {
			d = true;
		}
		if(code == KeyEvent.VK_F) {
			f = true;
		}
		if(code == KeyEvent.VK_G) {
			g = true;
		}
		if(code == KeyEvent.VK_H) {
			h = true;
		}
		if(code == KeyEvent.VK_J) {
			j = true;
		}
		if(code == KeyEvent.VK_K) {
			k = true;
		}
		if(code == KeyEvent.VK_L) {
			l = true;
		}
		if(code == KeyEvent.VK_Z) {
			z = true;
		}
		if(code == KeyEvent.VK_X) {
			x = true;
		}
		if(code == KeyEvent.VK_C) {
			c = true;
		}
		if(code == KeyEvent.VK_V) {
			v = true;
		}
		if(code == KeyEvent.VK_B) {
			b = true;
		}
		if(code == KeyEvent.VK_N) {
			n = true;
		}
		if(code == KeyEvent.VK_M) {
			m = true;
		}
		if(code == KeyEvent.VK_SPACE) {
			space = true;
		}
		if(code == KeyEvent.VK_ENTER) {
			enter = true;
		}
		if(code == KeyEvent.VK_BACK_SPACE) {
			backspace = true;
		}
		if(code == KeyEvent.VK_ESCAPE) {
			close = true;
			System.out.println("CLOSE ALL");
		}
	}

	@Override
	public void keyReleased(KeyEvent E) {
		int code = E.getKeyCode();
		if(code == KeyEvent.VK_Q) {
			q = false;
		}
		if(code == KeyEvent.VK_W) {
			w = false;
		}
		if(code == KeyEvent.VK_E) {
			e = false;
		}
		if(code == KeyEvent.VK_R) {
			r = false;
		}
		if(code == KeyEvent.VK_T) {
			t = false;
		}
		if(code == KeyEvent.VK_Y) {
			y = false;
		}
		if(code == KeyEvent.VK_U) {
			u = false;
		}
		if(code == KeyEvent.VK_I) {
			i = false;
		}
		if(code == KeyEvent.VK_O) {
			o = false;
		}
		if(code == KeyEvent.VK_P) {
			p = false;
		}
		if(code == KeyEvent.VK_A) {
			a = false;
		}
		if(code == KeyEvent.VK_S) {
			s = false;
		}
		if(code == KeyEvent.VK_D) {
			d = false;
		}
		if(code == KeyEvent.VK_F) {
			f = false;
		}
		if(code == KeyEvent.VK_G) {
			g = false;
		}
		if(code == KeyEvent.VK_H) {
			h = false;
		}
		if(code == KeyEvent.VK_J) {
			j = false;
		}
		if(code == KeyEvent.VK_K) {
			k = false;
		}
		if(code == KeyEvent.VK_L) {
			l = false;
		}
		if(code == KeyEvent.VK_Z) {
			z = false;
		}
		if(code == KeyEvent.VK_X) {
			x = false;
		}
		if(code == KeyEvent.VK_C) {
			c = false;
		}
		if(code == KeyEvent.VK_V) {
			v = false;
		}
		if(code == KeyEvent.VK_B) {
			b = false;
		}
		if(code == KeyEvent.VK_N) {
			n = false;
		}
		if(code == KeyEvent.VK_M) {
			m = false;
		}
		if(code == KeyEvent.VK_SPACE) {
			space = false;
		}
		if(code == KeyEvent.VK_ENTER) {
			enter = false;
		}
		if(code == KeyEvent.VK_BACK_SPACE) {
			backspace = false;
		}
		if(code == KeyEvent.VK_ESCAPE && code == KeyEvent.VK_G) {
			close = false;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
	    int code = e.getButton();
	    int mouseX = e.getX();
	    int mouseY = e.getY();

	    if (code == MouseEvent.BUTTON1) {
	        leftClick = true;
	        if(!ds.runningSetting) {
	        	if(mouseX >= dr.settingX && mouseY >= dr.settingY && mouseX <= dr.settingX + ds.tileSize * 2 && mouseY <= dr.settingY + ds.tileSize * 2) {
	        		ds.runningSetting = true;
	        		ds.settingOpen = true;
	        		System.out.println("SETTING");
	        	}
	        }
	        if (ds.runningCMD) {
	            if (mouseX >= dr.crestX && mouseY >= dr.crestY
		                && mouseX <= dr.crestX + 20 && mouseY <= dr.crestY + 20) {
	                ds.runningCMD = false;
	                cmdClick = false;
	                System.out.println("CLOSE");
	            }
	        }

	        if (!ds.runningCMD) {
	            if (mouseX >= dr.cmdX && mouseY >= dr.cmdY
	                && mouseX <= dr.cmdX + ds.tileSize * 2
	                && mouseY <= dr.cmdY + ds.tileSize * 2) {
	                cmdClick = true;
	                ds.runningCMD = true;
	                System.out.println("CLICK");
	                command();
	            }
	        }

	        if (mouseX >= dr.logoX && mouseY >= dr.logoY
	            && mouseX <= dr.logoX + ds.tileSize * 2
	            && mouseY <= dr.logoY + ds.tileSize * 2) {
	            menuOpen = true;
	        }

	        if (mouseX >= dr.logoX && mouseY >= dr.logoY - 48
	            && mouseX <= dr.logoX + ds.tileSize * 2
	            && mouseY <= dr.logoY - 48 + ds.tileSize) {
	            System.exit(0);
	        }
	    }
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		int code = e.getButton();
		int x = e.getX();
		int y = e.getY();
		if(code == MouseEvent.BUTTON1) {
			leftClick = false;
		}
		if(code == MouseEvent.BUTTON3) {
			rightClick = false;
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
