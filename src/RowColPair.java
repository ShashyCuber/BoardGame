//Shashwat Sparsh
public class RowColPair {
	private int row;
	private int col;
	
	public RowColPair(int r, int c) {
		row = r;
		col = c;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public String toString() {
		return "[" + row + "][" + col + "]";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RowColPair pair = new RowColPair(7, 10);
		System.out.println(pair);
	}

}
