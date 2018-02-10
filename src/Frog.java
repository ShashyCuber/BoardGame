
public class Frog extends Animal {
	//private int numMoves;
	private int power = 6;
	
	
	public Frog() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Frog";
	}

	@Override
	public RowColPair nextMove() {
		double r = Math.random() * 4;
		int a = 0, b = 0;
		if (r > 3) {
			a = 2;
		}
		else if (r > 2) {
			b = 2;
		}
		else if (r > 1) {
			a = -2;
		}
		else {
			b = -2;
		}
		//numMoves += 1;
		return new RowColPair(a,b);
	}

	@Override
	public int getPower() {
		// TODO Auto-generated method stub
		return power;
	}
	
	
	public static void main(String[] args) {
		Bird jay = new Bird();
		Bird crow = new Bird();
		Frog bull = new Frog();
		
		int i = 0;
		while (i <= 6) {
			System.out.println("Frog moved: " + bull.nextMove());
			System.out.println("Bird moved: " + crow.nextMove());
			bull.attack(crow);
			if (bull.isDead()) {
				bull.resurrect();
			}
			else if(crow.isDead()) {
				crow.resurrect();
			}
			i += 1;
		}
		
		System.out.println();
		System.out.println(bull);
		System.out.println(crow);
	}
}
