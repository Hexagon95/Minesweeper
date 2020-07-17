import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu {

	private JFrame frmMineSweaper;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frmMineSweaper.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Database D = new Database();
		
		frmMineSweaper = new JFrame();
		frmMineSweaper.getContentPane().setBackground(Color.BLACK);
		frmMineSweaper.getContentPane().setLayout(null);
		frmMineSweaper.setTitle("Mine Sweeper");
		frmMineSweaper.setBounds((int)(dim.getWidth() - frmMineSweaper.getWidth()) / 2 -200, (int)(dim.getHeight() - frmMineSweaper.getHeight()) / 2 -180, 400, 300);
		frmMineSweaper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// VARIABLES ////////// ////////// //////////	////////// ////////// //////////
		Image img_Monitor = new ImageIcon(this.getClass().getResource("Pictures/Monitor.png")).getImage();
		
		Image img_Plus = new ImageIcon(this.getClass().getResource("Pictures/Button_Plus.png")).getImage();
		Image img_Plus_Switch = new ImageIcon(this.getClass().getResource("Pictures/Button_Plus_Switch.png")).getImage();
		Image img_Plus_Pressed = new ImageIcon(this.getClass().getResource("Pictures/Button_Plus_Pressed.png")).getImage();
		
		Image img_Minus = new ImageIcon(this.getClass().getResource("Pictures/Button_Minus.png")).getImage();
		Image img_Minus_Switch = new ImageIcon(this.getClass().getResource("Pictures/Button_Minus_Switch.png")).getImage();
		Image img_Minus_Pressed = new ImageIcon(this.getClass().getResource("Pictures/Button_Minus_Pressed.png")).getImage();
		
		Image img_Play = new ImageIcon(this.getClass().getResource("Pictures/Button_Play.png")).getImage();
		Image img_Play_Switch = new ImageIcon(this.getClass().getResource("Pictures/Button_Play_Switch.png")).getImage();
		Image img_Play_Pressed = new ImageIcon(this.getClass().getResource("Pictures/Button_Play_Pressed.png")).getImage();
		
		Image img_Quit = new ImageIcon(this.getClass().getResource("Pictures/Button_Quit.png")).getImage();
		Image img_Quit_Switch = new ImageIcon(this.getClass().getResource("Pictures/Button_Quit_Switch.png")).getImage();
		Image img_Quit_Pressed = new ImageIcon(this.getClass().getResource("Pictures/Button_Quit_Pressed.png")).getImage();
		
		Image img_Help = new ImageIcon(this.getClass().getResource("Pictures/Button_Help.png")).getImage();
		Image img_Help_Switch = new ImageIcon(this.getClass().getResource("Pictures/Button_Help_Switch.png")).getImage();
		Image img_Help_Pressed = new ImageIcon(this.getClass().getResource("Pictures/Button_Help_Pressed.png")).getImage();
		
		// MONITOR'S VALUE ////////// ////////// //////////	////////// ////////// //////////	
		JLabel MonitorValue = new JLabel("3");
			MonitorValue.setFont(new Font("Agency FB", Font.BOLD, 30));
			MonitorValue.setHorizontalAlignment(SwingConstants.CENTER);
			MonitorValue.setForeground(Color.YELLOW);
			MonitorValue.setBounds(142, 135, 100, 50);
		frmMineSweaper.getContentPane().add(MonitorValue);
		
		// MONITOR'S FRAME ////////// ////////// //////////	////////// ////////// //////////	
		JLabel Monitor = new JLabel("");				
			Monitor.setBounds(142, 135, 100, 50);		
			Monitor.setIcon(new ImageIcon(img_Monitor));
		frmMineSweaper.getContentPane().add(Monitor);					
			
		// PLUS BUTTON ////////// ////////// //////////	////////// ////////// //////////	
		
		JLabel Button_Plus = new JLabel("");
		Button_Plus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {				
				Button_Plus.setIcon(new ImageIcon(img_Plus_Switch));
			}
			@Override
			public void mouseExited(MouseEvent e) {				
				Button_Plus.setIcon(new ImageIcon(img_Plus));
			}
			@Override
			public void mousePressed(MouseEvent e) {				
				Button_Plus.setIcon(new ImageIcon(img_Plus_Pressed));					
				Database.Set_Number_of_Mines(+1);
				MonitorValue.setText(String.valueOf(Database.Number_of_Mines));
			}
			@Override
			public void mouseReleased(MouseEvent e) {				
				Button_Plus.setIcon(new ImageIcon(img_Plus));
			}
		});
			Button_Plus.setBounds(252, 135, 50, 50);		
			Button_Plus.setIcon(new ImageIcon(img_Plus));
		frmMineSweaper.getContentPane().add(Button_Plus);
		
		// MINUS BUTTON ////////// ////////// ////////// ////////// ////////// //////////	
		JLabel Button_Minus = new JLabel("");
		Button_Minus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {				
				Button_Minus.setIcon(new ImageIcon(img_Minus_Switch));
			}
			@Override
			public void mouseExited(MouseEvent e) {				
				Button_Minus.setIcon(new ImageIcon(img_Minus));
			}
			@Override
			public void mousePressed(MouseEvent e) {				
				Button_Minus.setIcon(new ImageIcon(img_Minus_Pressed));					
				Database.Set_Number_of_Mines(-1);
				MonitorValue.setText(String.valueOf(Database.Number_of_Mines));
			}
			@Override
			public void mouseReleased(MouseEvent e) {				
				Button_Minus.setIcon(new ImageIcon(img_Minus));
			}
		});
			Button_Minus.setBounds(82, 135, 50, 50);		
			Button_Minus.setIcon(new ImageIcon(img_Minus));
		frmMineSweaper.getContentPane().add(Button_Minus);
		
		// PLAY BUTTON ////////// ////////// //////////	////////// ////////// //////////	
		JLabel Play_Button = new JLabel("");
		Play_Button.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseEntered(MouseEvent e) {				
				Play_Button.setIcon(new ImageIcon(img_Play_Switch));
			}
			@Override
			public void mouseExited(MouseEvent e) {				
				Play_Button.setIcon(new ImageIcon(img_Play));
			}
			@Override
			public void mousePressed(MouseEvent e) {				
				Play_Button.setIcon(new ImageIcon(img_Play_Pressed));
			}
			@Override
			public void mouseReleased(MouseEvent e) {				
				Play_Button.setIcon(new ImageIcon(img_Play));					
				frmMineSweaper.dispose();
				GameBuilder GB = new GameBuilder();
			}
		});
			Play_Button.setBounds(165, 196, 50, 50);		
			Play_Button.setIcon(new ImageIcon(img_Play));
		frmMineSweaper.getContentPane().add(Play_Button);
		
		// QUIT BUTTON ////////// ////////// //////////	////////// ////////// //////////	
		JLabel Button_Quit = new JLabel("");
		Button_Quit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {				
				Button_Quit.setIcon(new ImageIcon(img_Quit_Switch));
			}
			@Override
			public void mouseExited(MouseEvent e) {				
				Button_Quit.setIcon(new ImageIcon(img_Quit));
			}
			@Override
			public void mousePressed(MouseEvent e) {				
				Button_Quit.setIcon(new ImageIcon(img_Quit_Pressed));				
			}
			@Override
			public void mouseReleased(MouseEvent e) {				
				Button_Quit.setIcon(new ImageIcon(img_Quit));					
				System.exit(0);
			}
		});
			Button_Quit.setBounds(225, 196, 50, 50);		
			Button_Quit.setIcon(new ImageIcon(img_Quit));
		frmMineSweaper.getContentPane().add(Button_Quit);
		
		// HELP BUTTON ////////// ////////// //////////	////////// ////////// //////////
		JLabel Button_Help = new JLabel("");
		Button_Help.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {				
				Button_Help.setIcon(new ImageIcon(img_Help_Switch));
			}
			@Override
			public void mouseExited(MouseEvent e) {				
				Button_Help.setIcon(new ImageIcon(img_Help));
			}
			@Override
			public void mousePressed(MouseEvent e) {				
				Button_Help.setIcon(new ImageIcon(img_Help_Pressed));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				Button_Help.setIcon(new ImageIcon(img_Help));
				Help.main(null);
			}
		});
			Button_Help.setBounds(105, 196, 50, 50);		
			Button_Help.setIcon(new ImageIcon(img_Help));
		frmMineSweaper.getContentPane().add(Button_Help);
		
		// OTHER LABELS ////////// ////////// //////////	////////// ////////// //////////
		JLabel Lbl_1 = new JLabel("MINE SEEPER");
			Lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
			Lbl_1.setFont(new Font("Arial Black", Font.PLAIN, 40));
			Lbl_1.setForeground(Color.YELLOW);
			Lbl_1.setBounds(10, 11, 364, 68);
		frmMineSweaper.getContentPane().add(Lbl_1);		
		
		JLabel Lbl_2 = new JLabel("Number of Mines");
			Lbl_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
			Lbl_2.setForeground(Color.YELLOW);
			Lbl_2.setHorizontalAlignment(SwingConstants.CENTER);
			Lbl_2.setBounds(10, 101, 364, 29);
		frmMineSweaper.getContentPane().add(Lbl_2);			
	}
}
