import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Help extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help frame = new Help();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Help() {		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)(dim.getWidth() - getWidth()) / 2 -283, (int)(dim.getHeight() - getHeight()) / 2 -199, 566, 399);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// VARIABLES ////////// ////////// ////////// ////////// ////////// //////////
		
		Image img_HelpImage = new ImageIcon(this.getClass().getResource("Pictures/Help.png")).getImage();
		Image img_Ok = new ImageIcon(this.getClass().getResource("Pictures/Button_Ok.png")).getImage();
		Image img_Ok_Switch = new ImageIcon(this.getClass().getResource("Pictures/Button_Ok_Switch.png")).getImage();
		Image img_Ok_Pressed = new ImageIcon(this.getClass().getResource("Pictures/Button_Ok_Pressed.png")).getImage();
		
		// OK BUTTON ////////// ////////// ////////// ////////// ////////// //////////
			JLabel OkButton = new JLabel("");
			OkButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					OkButton.setIcon(new ImageIcon(img_Ok_Switch));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					OkButton.setIcon(new ImageIcon(img_Ok));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					OkButton.setIcon(new ImageIcon(img_Ok_Pressed));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					dispose();
				}
			});
				OkButton.setBounds(250, 300, 50, 50);
				OkButton.setIcon(new ImageIcon(img_Ok));
			contentPane.add(OkButton);
		
		// HELP IMAGE ////////// ////////// ////////// ////////// ////////// //////////
		JLabel HelpImage = new JLabel("");
			HelpImage.setBounds(0, 0, 550, 360);
			HelpImage.setIcon(new ImageIcon(img_HelpImage));
		contentPane.add(HelpImage);
	}

}
