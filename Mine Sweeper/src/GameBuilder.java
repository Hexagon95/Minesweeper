import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GameBuilder {
	static JFrame Game;
	static JPanel contentPane;
	static TileButton[][] TB = new TileButton[8][8];		
	
	Image img_0 = new ImageIcon(this.getClass().getResource("Pictures/Tile_Empty.png")).getImage();
	Image img_1 = new ImageIcon(this.getClass().getResource("Pictures/Tile_1.png")).getImage();
	Image img_2 = new ImageIcon(this.getClass().getResource("Pictures/Tile_2.png")).getImage();
	Image img_3 = new ImageIcon(this.getClass().getResource("Pictures/Tile_3.png")).getImage();
	Image img_4 = new ImageIcon(this.getClass().getResource("Pictures/Tile_4.png")).getImage();
	Image img_5 = new ImageIcon(this.getClass().getResource("Pictures/Tile_5.png")).getImage();
	Image img_6 = new ImageIcon(this.getClass().getResource("Pictures/Tile_6.png")).getImage();
	Image img_7 = new ImageIcon(this.getClass().getResource("Pictures/Tile_7.png")).getImage();
	Image img_8 = new ImageIcon(this.getClass().getResource("Pictures/Tile_8.png")).getImage();
	Image img_xU = new ImageIcon(this.getClass().getResource("Pictures/Tile_X_Unfound.png")).getImage();
	
	private static int[] MineArray_x;
	private static int[] MineArray_y;
	
	// CONSTRUCTOR ////////// ////////// ////////// ////////// ////////// //////////
	public GameBuilder() {		
		Generate_Mine_Map();
		Generate_Game_Map();
		Generate_Game_GUI();				
	}
	
	// METHODS ////////// ////////// ////////// ////////// ////////// //////////
	private void Generate_Mine_Map() {
		int Mines = Database.Number_of_Mines;
		char[][] Map = Database.Map;
		
		int[] x = new int[Mines];			
		int[] y = new int[Mines];			
		
		do {
			x = ArryFiller(Mines);
			y = ArryFiller(Mines);	
		} while (Check(x,y,Mines));
		
		MineArray_x = x;
		MineArray_y = y;
		
		for (int i = 0; i < Mines; i++) {
			Map[x[i]][y[i]] = 'X';
		}
		
		Database.Set_Map(Map);
	}
		private int[] ArryFiller(int Length) {
			int[] x = new int[Length];
			Random r = new Random();			
			
			for (int i = 0; i < x.length; i++) {
				x[i] = r.nextInt(8);
			}			
			
			return x;					
		}
		private boolean Check(int[] x, int[] y, int Length) {
			int a = 0;
			
			for (int i = 0; i < Length; i++) {
				for (int j = 0; j < Length; j++) {
					if(x[j] == x[i] && y[j] == y[i]) a += 1;
				}
			}
			
			if(a != Length) return true;
			
			return false;
		}
	
	private void Generate_Game_Map() {
		char[][] Map = Database.Map;
		int db;
		
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if(Map[y][x] != 'X') {
					db = 0;				
					if (x >= 1 && x <= 6 && y >= 1 && y <= 6 ) {
						if(Map[y-1][x-1] == 'X') db++;
						if(Map[y-1][x] == 'X') db++;
						if(Map[y-1][x+1] == 'X') db++;
						if(Map[y][x-1] == 'X') db++;
						if(Map[y][x+1] == 'X') db++;						
						if(Map[y+1][x-1] == 'X') db++;
						if(Map[y+1][x] == 'X') db++;
						if(Map[y+1][x+1] == 'X') db++;					
					}
					if (x >= 1 && x <= 6 && y == 0) {
						if(Map[y+1][x-1] == 'X') db++;
						if(Map[y+1][x] == 'X') db++;
						if(Map[y+1][x+1] == 'X') db++;
						if(Map[y][x-1] == 'X') db++;
						if(Map[y][x+1] == 'X') db++;						
					}
					if (x == 7 && y >= 1 && y <= 6) {
						if(Map[y-1][x-1] == 'X') db++;
						if(Map[y-1][x] == 'X') db++;						
						if(Map[y][x-1] == 'X') db++;												
						if(Map[y+1][x-1] == 'X') db++;
						if(Map[y+1][x] == 'X') db++;	
					}
					if (x >= 1 && x <= 6 && y == 7) {						
						if(Map[y][x-1] == 'X') db++;
						if(Map[y][x+1] == 'X') db++;						
						if(Map[y-1][x-1] == 'X') db++;
						if(Map[y-1][x] == 'X') db++;
						if(Map[y-1][x+1] == 'X') db++;
					}
					if (x == 0 && y >= 1 && y <= 6) {
					
						if(Map[y-1][x] == 'X') db++;
						if(Map[y-1][x+1] == 'X') db++;					
						if(Map[y][x+1] == 'X') db++;			
						if(Map[y+1][x] == 'X') db++;
						if(Map[y+1][x+1] == 'X') db++;
					}
					if (x == 0 && y == 0) {						
						if(Map[y][x+1] == 'X') db++;					
						if(Map[y+1][x] == 'X') db++;
						if(Map[y+1][x+1] == 'X') db++;
					}
					if (x == 7 && y == 0) {				
						if(Map[y][x-1] == 'X') db++;										
						if(Map[y+1][x-1] == 'X') db++;
						if(Map[y+1][x] == 'X') db++;				
					}
					if (x == 7 && y == 7) {
						if(Map[y-1][x-1] == 'X') db++;
						if(Map[y-1][x] == 'X') db++;					
						if(Map[y][x-1] == 'X') db++;						
					}
					if (x == 0 && y == 7) {						
						if(Map[y-1][x] == 'X') db++;
						if(Map[y-1][x+1] == 'X') db++;					
						if(Map[y][x+1] == 'X') db++;				
					}
					Map[y][x] = Character.forDigit(db, 10);
				}
			}
		}
		Database.Set_Map(Map);
	}
	
	private void Generate_Game_GUI() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();		
		Game = new JFrame();
			Game.setVisible(true);			
			Game.setTitle("Game");
			Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
			Game.setBounds((int)(dim.getWidth() - Game.getWidth())/2 - (525 / 2), (int)(dim.getHeight() - Game.getHeight())/2 - (550 / 2), 525, 550);			
		contentPane = new JPanel();		
			contentPane.setForeground(Color.YELLOW);
			contentPane.setBackground(Color.BLACK);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Game.setContentPane(contentPane);
			contentPane.setLayout(null);	
		
		JLabel Lbl_1 = new JLabel("REMAINING CURSORS:");		
			Lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
			Lbl_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
			Lbl_1.setForeground(Color.BLUE);
			Lbl_1.setBounds(0, 0, 260, 25);
		contentPane.add(Lbl_1);		
	
		JLabel CursorCounter = new JLabel("");
			CursorCounter.setText(String.valueOf(Database.Remaining_Cursors));
			CursorCounter.setHorizontalAlignment(SwingConstants.CENTER);
			CursorCounter.setFont(new Font("Arial Black", Font.PLAIN, 20));
			CursorCounter.setForeground(Color.WHITE);
			CursorCounter.setBounds(260, 0, 30, 25);
		contentPane.add(CursorCounter);
			
		Add_Buttons(CursorCounter);
		Draw_Tiles();				
	}
		private void Draw_Tiles() {
			char[][] Map = Database.Map;
			
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
				JLabel Tile = new JLabel();
					Tile.setBounds(50 + j * 50, 50 + i * 50, 50, 50);
				contentPane.add(Tile);
					switch (Map[i][j]) {
					case '1':
						Tile.setIcon(new ImageIcon(img_1));
						break;
					case '2':
						Tile.setIcon(new ImageIcon(img_2));
						break;
					case '3':
						Tile.setIcon(new ImageIcon(img_3));
						break;
					case '4':
						Tile.setIcon(new ImageIcon(img_4));
						break;
					case '5':
						Tile.setIcon(new ImageIcon(img_5));
						break;
					case '6':
						Tile.setIcon(new ImageIcon(img_6));
						break;
					case '7':
						Tile.setIcon(new ImageIcon(img_7));
						break;
					case '8':
						Tile.setIcon(new ImageIcon(img_8));
						break;
					case 'X':
						Tile.setIcon(new ImageIcon(img_xU));
						break;
					default:
						Tile.setIcon(new ImageIcon(img_0));
						break;
					}
				}
			}
		}
		private void Add_Buttons(JLabel CursorCounter) {			
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					TB[i][j] = new TileButton(Game, contentPane,CursorCounter, i, j);
				}
			}
		}
		
	//STATIC METHODS ////////// ////////// ////////// ////////// ////////// //////////
	public static void LeftFrameClick(int Row, int Column) {		
		try {
			TB[Row-1][Column-1].LeftClick();			
		}
		catch (Exception e) {}
		try {			
			TB[Row][Column-1].LeftClick();			
		}
		catch (Exception e) {}
		try {			
			TB[Row+1][Column-1].LeftClick();
		}
		catch (Exception e) {}
	}
	public static void RightFrameClick(int Row, int Column) {		
		try {
			TB[Row-1][Column+1].RightClick();			
		}
		catch (Exception e) {}
		try {			
			TB[Row][Column+1].RightClick();			
		}
		catch (Exception e) {}
		try {			
			TB[Row+1][Column+1].RightClick();
		}
		catch (Exception e) {}
	}
	public static void BottomFrameClick(int Row, int Column) {		
		try {
			TB[Row+1][Column-1].BottomClick();			
		}
		catch (Exception e) {}
		try {			
			TB[Row+1][Column].BottomClick();			
		}
		catch (Exception e) {}
		try {			
			TB[Row+1][Column+1].BottomClick();
		}
		catch (Exception e) {}
	}
	public static void TopFrameClick(int Row, int Column) {		
		try {
			TB[Row-1][Column-1].TopClick();			
		}
		catch (Exception e) {}
		try {			
			TB[Row-1][Column].TopClick();			
		}
		catch (Exception e) {}
		try {			
			TB[Row-1][Column+1].TopClick();
		}
		catch (Exception e) {}
	}	

	public static void IsWin() {		
		int db = 0;		
		
		for (int i = 0; i < Database.Number_of_Mines; i++) {
			if(TB[MineArray_x[i]][MineArray_y[i]].Get_Flagged() == false) db++;			
		}	
		if(db == Database.Number_of_Mines)WIN();
	}	
		private static void WIN() {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					TB[i][j].WinOption();
				}
			}
			Add_NewGameButton();
		}
	public static void Loose(int Row, int Column) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				TB[i][j].LooseOption(Row, Column);
			}
		}
		Add_NewGameButton();
	}
	
	private static void Add_NewGameButton() {
		JLabel NewGameButton = new JLabel("NEW GAME");			
		NewGameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				NewGameButton.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				NewGameButton.setForeground(Color.YELLOW);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Game.dispose();
				MainMenu2.main(null, Database.Number_of_Mines);				
			}
		});
			NewGameButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
			NewGameButton.setForeground(Color.YELLOW);			
			NewGameButton.setBounds(190, 480, 125, 25);
			NewGameButton.setHorizontalAlignment(SwingConstants.CENTER);			
		contentPane.add(NewGameButton);
		NewGameButton.setEnabled(false);	
		NewGameButton.setEnabled(true);
	}
}
