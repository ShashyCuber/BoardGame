//Shashwat Sparsh
public abstract class Animal {
	private boolean isDead = false;
	
	
	public abstract String name();
	public abstract RowColPair nextMove();
	public abstract int getPower();
	
	public boolean isDead() {
		if (isDead) {
			return true;
		}
		return false;
	}
	
	public void wonAFight() {}
	
	public void resurrect() {
		isDead = false;	
	}
	
	public String toString() {
		return name() + " power: " + getPower() + " dead: " + isDead();
	}
		
	public void printWinner(Animal winner, Animal loser) {
		System.out.println(winner.name() + " killed " + loser.name() + " by " + winner.getPower() + " to " + loser.getPower());
	}
	
	public Animal attack(Animal target) {
		Animal winner = null;
		Animal loser = null;
		Animal attacker = this;
		int aPower = attacker.getPower();
		
		if (target == null) {
			winner = attacker;
			loser = target;
					
			return attacker;
		}
		else if (target != null) {	
			if (aPower > target.getPower()) {
				winner = attacker;
				loser = target;
			}
			else if (aPower == target.getPower()) {
				if (Math.random()*1 > .5) {
					winner = attacker;
					loser = target;
				}
				else {
					winner = target;
					loser = attacker;
				}
			}				
			else if (aPower < target.getPower()) {
				winner = target;
				loser = attacker;
			}
			printWinner(winner, loser);
			winner.wonAFight();
			loser.isDead = true;
			return winner;
		}
		
		return attacker;
	}
	
	
}
