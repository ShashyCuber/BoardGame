//Shashwat Sparsh
public class BoardGame {

	public BoardGame() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Board board = new Board(2, 3);
		
		Animal bull = new Frog();
		Animal jay = new Bird();
		Animal rat = new Mouse();
		
		board.addToBoard(bull);
		board.addToBoard(jay);
		board.addToBoard(rat);
		
		board.printBoard();
		
		while(board.getWinner() == null) {
			board.takeTurn();
		}
		
		
		System.out.println();
		System.out.println("Final Board");
		board.printBoard();
		System.out.println("The winner is " + board.getWinner());
		
		
		
	}

}
