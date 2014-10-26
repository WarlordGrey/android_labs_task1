package android.labs.lab1.TwelveRocks;


public class HumanPlayer extends Player {
	
	private IRocksPicker picker;
	
	public HumanPlayer(String name, IRocksPicker picker){
		setName(name);
		this.picker = picker;
	}

	@Override
	public int getPickedRocks() {
		return picker.pickRocks();
	}

}
