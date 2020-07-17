
public class Database {
	
	// VARIABLES //////////////////// ////////// ////////// ////////// //////////
	public static int Number_of_Mines;			
	public static char[][] Map = new char[8][8];		
	public static int Remaining_Cursors;		
	
	// CONSTRUCTORS ////////// ////////// ////////// ////////// ////////// //////////
	public Database() {
		Number_of_Mines = 3;
		Remaining_Cursors = 3;		
		Initialize_Map();			
	}
	public Database(int x) {
		Number_of_Mines = x;
		Remaining_Cursors = x;		
		Initialize_Map();			
	}
	
	// SET FUNTIONS ////////// ////////// ////////// ////////// ////////// ////////// 
	public static void Set_Number_of_Mines(int increase) {
		try {
			int x = Number_of_Mines;
				x += increase;
			
			if(x >= 3 && x <= 30) {
				Number_of_Mines = x;
				Remaining_Cursors = x;
			}
			else {
				throw new E_Intervalum();
			}			
		} catch (Exception E_Intervalum) {}
	}
	public static void Set_Map(char[][] GameMap) {
		Map = GameMap;
	}	
	
	// OTHER METHODS ////////// ////////// ////////// ////////// ////////// //////////
	private void Initialize_Map() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				this.Map[i][j] = '0';
			}
		}		
	}
}
