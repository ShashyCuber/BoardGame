
public class Bird extends Animal {
	
	private int power = 3;
	//private int x, y;
	private int numMoves;
	//private RowColPair change; // = new RowColPair(x, y);
	
	public Bird() {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "bird";
	}

	@Override
	public RowColPair nextMove() {
		double r = Math.random() * 4;
		int a = 0, b = 0;
		if (r > 3) {
			a = 1;
		}
		else if (r > 2) {
			b = 1;
		}
		else if (r > 1) {
			a = -1;
		}
		else {
			b = -1;
		}
		numMoves += 1;
		return new RowColPair(a,b);
	}

	@Override
	public int getPower() {
		return numMoves + 3;
	}
	
	public String toString() {
		String result = super.toString();
		result += " numMoves: " + numMoves;
		return result;
	}

	public static void main(String[] args) {
		Bird jay = new Bird();
		Bird crow = new Bird();
		int i = 0;
		
		
		while (i <= 6) {
			//jay.nextMove();
			System.out.println("Bird moved: " + crow.nextMove());
			i += 1;
		}
		
		System.out.println(jay.getPower());
		System.out.println();
		jay.attack(crow);	
			//jay.attack(crow);
		System.out.println(jay);
		System.out.println(crow);
		
		
		
	}




}




