
public class Mouse extends Animal {
	
	private int numWonFights = 0;
	public Mouse() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Mouse";
	}

	@Override
	public RowColPair nextMove() {
		//numMoves += 1;
		return new RowColPair (-1, -1);
	}

	@Override
	public int getPower() {
		// TODO Auto-generated method stub
		return 7 - numWonFights;
	}
	
	@Override
	public void wonAFight() {
		numWonFights++;
	}
	
	public String toString() {
		String result = super.toString();
		result += " Won: " + numWonFights + " Fights";
		return result;	
	}

	public static void main(String[] args) {

		Bird crow = new Bird();
		Mouse remmy = new Mouse();
		int a = 0;
		int i = 0;
		while (i <= 6) {
			remmy.attack(crow);
			if (remmy.isDead()) {
				remmy.resurrect();
			}
			else if(crow.isDead()) {
				crow.resurrect();
			}
			i += 1;
		}
		
		System.out.println(remmy);
		System.out.println(crow);
		//System.out.println("My only move is " + nextMove());
	}

}
