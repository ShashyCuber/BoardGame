//Shashwat Sparsh

import java.util.ArrayList; 


public class Board {
	
	private int xMax;
	private int yMax;
	private Animal[][] board;
	private ArrayList<Animal> animalsOnBoard;
	
	public Board(int numRows, int numCols) {
		board = new Animal[numRows][numCols];
		animalsOnBoard = new ArrayList<Animal>(); 
		animalsOnBoard.clear();
	}
	
	public RowColPair getRandomPosition() {
		//int a = 0, b = 0;
		int rx = (int) (Math.random() * board.length);
		int ry = (int) (Math.random() * board[0].length);
		
		return new RowColPair(rx, ry);
	}
	
	public void addToBoard(Animal anim) {
		RowColPair location = getRandomPosition();
		//System.out.println(location);
		while (board[location.getRow()][location.getCol()] != null) {
			//System.out.println("location is null");
			location = getRandomPosition();
			//System.out.println(location);
		
		}
		board[location.getRow()][location.getCol()] = anim;
		animalsOnBoard.add(anim);
		
	}
	
	public RowColPair findAnimal(Animal anim) {
		//int x = 0, y = 0;
		for (int i = 0; i < board.length; i ++) {
			for (int j = 0; j < board[1].length; j++) {
				if (board[i][j] == anim) {
					return new RowColPair(i, j);
				}
			}
		}
		return null;
	}
	
	public Animal takeTurn() {
		for (Animal a : animalsOnBoard) {
			if (a.isDead()) continue;
			if (getWinner() != null) break;
			move(a);
			printBoard();
		}
		return getWinner();
	}

	
	//
	
	public void move(Animal anim) {
		RowColPair currentPos = findAnimal(anim);
		RowColPair distance = anim.nextMove();
		RowColPair newPos = movePosition(currentPos, distance);
		//System.out.println(newPos);
		Animal a = board[newPos.getRow()][newPos.getCol()];
		System.out.println(anim + " moved from " + currentPos + " + " + distance + " to " + newPos);
		Animal winner = anim;
		if (a == anim) {
			return;
		}
		if (a != null) {
			winner = anim.attack(a);
		}
		board[newPos.getRow()][newPos.getCol()] = winner;
		board[currentPos.getRow()][currentPos.getCol()] = null;
		/*RowColPair location = findAnimal(anim);
		RowColPair pos = anim.nextMove();
		Animal a = board[pos.getRow()][pos.getCol()];
		System.out.println(anim + " " + location);
		Animal winner = anim;
		System.out.println(anim + " moved from " + location + " to " + pos);
		board[location.getRow()][location.getCol()] = null;
		
		if (a != null) {
			winner = anim.attack(a);
		}
		board[pos.getRow()][pos.getCol()] = winner;*/
	}
	
	//
	
	
	public int validIndex(int val, int length) {
		while(val >= length) {
			val = val - length;
		}
		while(val < 0) {
			val += length;
		}
		return val;
	}
	
	public RowColPair movePosition(RowColPair oldP, RowColPair nextMove) {
		int newY = nextMove.getRow();
		int newX = nextMove.getCol();
		int oldY = oldP.getRow();
		int oldX = oldP.getCol();
		newX += oldX;
		newY += oldY;
		
		newY = validIndex(newY, board.length);
		newX = validIndex(newX, board[0].length);
		
		if (newY >= board.length) {
			newY = validIndex(newY, board.length);
			System.out.println(board.length + " " + newY);
		}
		else if (newX >= board[0].length) {
			newX = validIndex(newX, board[0].length);
			System.out.println(board[0].length + " " + newX);
		}
		RowColPair pos = new RowColPair(newY, newX);
		return pos;		
	}
	
	public Animal getWinner() {
		Animal result = null;
		int num = animalsOnBoard.size();
		int c = 0;
		for (Animal animal : animalsOnBoard) {
			if (!animal.isDead()) {
				result = animal;
				c++;
			}
		}
		if (c > 1) return null;
		
		return result;
	}
	
	public String toString() {
		
		return "There are " + animalsOnBoard.size() + " animals on a " + board.length + " by " + board[0].length + " board";
	}
	
	public void printBoard() {
		System.out.print("     ");
		for (int i = 0; i < board[0].length; i++) {
		   System.out.print("[" + i + "]  ");
		   }

	   System.out.println();

	   for (int r = 0; r < board.length; r++) {
	      System.out.print("[" + r + "]   ");
	      for (int c = 0; c < board[r].length; c++) {
	         if (board[r][c] == null) {
	            System.out.print(" -   ");
	         } else {
	            System.out.print(board[r][c].name() + " ");
	         }
	      }
	      System.out.println();
	   }

	}

	public static void main(String[] args) {
		Board b = new Board(3, 2);
		Bird bird = new Bird();
		
		
		
		
		
		/*
		Board b = new Board(3, 2);
		Bird bird = new Bird();
		
		b.addToBoard(bird);
		System.out.println(b + " bird is at " + b.findAnimal(bird));
		b.printBoard();  
		System.out.println();
		
		b  = new Board(4, 6);
		b.addToBoard(bird);
		System.out.println(b + " bird is at " + b.findAnimal(bird));
		Animal winner = b.getWinner();
		System.out.println("The winner is " + winner + " and is at " + b.findAnimal(winner));
		Frog f = new Frog();
		
		
		b.addToBoard(f);
		
		
		System.out.println(b + " frog is at " + b.findAnimal(f));
		winner = b.getWinner();
		System.out.println("The winner is " + winner + " and is at " + b.findAnimal(winner));
		b.printBoard(); 
		
		
		System.out.println("////////////////////////////////////////");
		System.out.println("////////////////////////////////////////");
		System.out.println("////////////////////////////////////////");
		
		System.out.println();
		RowColPair p = new RowColPair(3, 2);
		RowColPair move = new RowColPair(0, 3);
		System.out.println("Start at " + p + " move " + move);
		p = b.movePosition(p, move);
		move = new RowColPair(5, -5);
		System.out.println("Now at " + p + " move " + move);
		p = b.movePosition(p, move);
		System.out.println("Now at " + p + " move " + move);
		move = new RowColPair(-3, 3);
		p = b.movePosition(p, move);
		System.out.println("Now at " + p + " move " + move);
		move = new RowColPair(1, 2);
		p = b.movePosition(p, move);
		System.out.println("Now at " + p + " move " + move);
		move = new RowColPair(1, 0);
		p = b.movePosition(p, move);
		System.out.println("End at " + p );
		*/
		
	}
}
