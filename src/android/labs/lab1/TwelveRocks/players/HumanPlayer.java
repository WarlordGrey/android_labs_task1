package android.labs.lab1.TwelveRocks.players;


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
	
	@Override
	public boolean isHumanPlayer(){
		return true;
	}

}
