package android.labs.lab1.TwelveRocks;

public class EasyComputerPlayer extends Player {
	
	private static String MY_NAME = "easy android";
	
	public EasyComputerPlayer (){
		setName(MY_NAME);
	}

	@Override
	public int getPickedRocks() {
		// TODO simple computer strategy for rocks picking
		return 0;
	}


}
