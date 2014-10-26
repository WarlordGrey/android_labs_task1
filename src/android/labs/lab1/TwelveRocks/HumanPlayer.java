package android.labs.lab1.TwelveRocks;

public class HumanPlayer extends Player {
	
	public HumanPlayer(String name){
		setName(name);
	}

	@Override
	protected int pickStrategy(int rocksCount) {
		return rocksCount;
	}

}
