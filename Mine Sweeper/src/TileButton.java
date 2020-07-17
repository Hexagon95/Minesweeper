import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TileButton {
	// VARIABLES ////////// ////////// ////////// ////////// ////////// //////////
	private int x;
	private int y;
	private boolean Unflagged = true;
		public boolean Get_Flagged() {
			return this.Unflagged;
		}
	
	private char[][] Map;
	
	private JLabel CursorCounter;
	
	private JLabel Tile = new JLabel();	
	
	private Image img_Tile = new ImageIcon(this.getClass().getResource("Pictures/Tile_Mysterious.png")).getImage();
	private Image img_TileSwitch = new ImageIcon(this.getClass().getResource("Pictures/Tile_Mysterious_Switch.png")).getImage();
	
	private Image img_Tile_X = new ImageIcon(this.getClass().getResource("Pictures/Tile_X.png")).getImage();
	
	private Image img_Cursor = new ImageIcon(this.getClass().getResource("Pictures/Tile_Cursor.png")).getImage();
	private Image img_Cursor_Correct = new ImageIcon(this.getClass().getResource("Pictures/Tile_Cursor_Correct.png")).getImage();
	private Image img_Cursor_Incorrect = new ImageIcon(this.getClass().getResource("Pictures/Tile_Cursor_Incorrect.png")).getImage();	
		
	// CONSTRUCTOR ////////// ////////// ////////// ////////// ////////// //////////
	public TileButton( JFrame Game, JPanel contentPane,JLabel CursorCounter, int Row, int Column) {
		this.x = Row;
		this.y = Column;
		this.Map = Database.Map;
		this.CursorCounter = CursorCounter;
		
		CreateTile( Game, contentPane);
	}
	
	// MOUSE LISTENER ////////// ////////// ////////// ////////// ////////// //////////
	MouseListener ml = new MouseAdapter() {		
		@Override
		public void mouseEntered(MouseEvent evt) {
			if(Unflagged)Tile.setIcon(new ImageIcon(img_TileSwitch));
		}
		@Override
		public void mouseExited(MouseEvent evt) {
			if(Unflagged)Tile.setIcon(new ImageIcon(img_Tile));
		}			
		@Override
		public void mousePressed(MouseEvent evt) {	
			if(SwingUtilities.isLeftMouseButton(evt) && Unflagged){
				Tile.setIcon(null);				
				if(Map[x][y] == '0') {
					GameBuilder.TopFrameClick(x, y);
					GameBuilder.RightFrameClick(x, y);
					GameBuilder.BottomFrameClick(x, y);
					GameBuilder.LeftFrameClick(x, y);
				}
				else if(Map[x][y] == 'X') GameBuilder.Loose(x,y);
				Tile.removeMouseListener(this);
			}
			else if(SwingUtilities.isRightMouseButton(evt)) {
				if(Unflagged == true && Database.Remaining_Cursors > 0) {
					Tile.setIcon(new ImageIcon(img_Cursor));
					Database.Remaining_Cursors--;
					CursorCounter.setText(String.valueOf(Database.Remaining_Cursors));
					Unflagged = false;
						if(Database.Remaining_Cursors == 0) GameBuilder.IsWin();					
				}
				else if(Unflagged == false){
					Tile.setIcon(new ImageIcon(img_Tile));
					Database.Remaining_Cursors++;	
					CursorCounter.setText(String.valueOf(Database.Remaining_Cursors));
					Unflagged = true;
				}
				else {}
			}
		}			
	};
	
	// METHODS ////////// ////////// ////////// ////////// ////////// //////////
	private void CreateTile(JFrame Game, JPanel contentPane) {
			
		Tile.addMouseListener(ml);
			Tile.setBounds(50 + y * 50, 50 + x * 50, 50, 50);
		contentPane.add(Tile);
			Tile.setIcon(new ImageIcon(img_Tile));
	}
	
	// PUBLIC METHODS ////////// ////////// ////////// ////////// ////////// //////////
	public void TopClick() {
		Tile.setIcon(null);	
			if(Map[x][y] == '0')GameBuilder.TopFrameClick(x, y);
		Tile.removeMouseListener(ml);		
	}
	public void RightClick() {
		Tile.setIcon(null);	
			if(Map[x][y] == '0')GameBuilder.RightFrameClick(x, y);
		Tile.removeMouseListener(ml);		
	}
	public void BottomClick() {
		Tile.setIcon(null);	
			if(Map[x][y] == '0')GameBuilder.BottomFrameClick(x, y);
		Tile.removeMouseListener(ml);		
	}
	public void LeftClick() {
		Tile.setIcon(null);	
			if(Map[x][y] == '0')GameBuilder.LeftFrameClick(x, y);
		Tile.removeMouseListener(ml);		
	}

	public void WinOption() {		
		if(Unflagged == false) Tile.setIcon(new ImageIcon(img_Cursor_Correct));
		Tile.removeMouseListener(ml);
	}

	public void LooseOption(int Row, int Column) {
		if(Row == x && Column == y)	Tile.setIcon(new ImageIcon(img_Tile_X));	
		else if(Map[x][y] == 'X' && Unflagged == true) {
			Tile.setIcon(null);
			Tile.removeMouseListener(ml);
		}
		else if(Map[x][y] == 'X' && Unflagged == false) {
			Tile.setIcon(new ImageIcon(img_Cursor_Correct));
			Tile.removeMouseListener(ml);
		}
		else if(Map[x][y] != 'X' && Unflagged == false) {
			Tile.setIcon(new ImageIcon(img_Cursor_Incorrect));
			Tile.removeMouseListener(ml);
		}
		else Tile.removeMouseListener(ml);
	}
}
