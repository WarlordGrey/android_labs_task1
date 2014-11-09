package android.labs.lab1.TwelveRocks.players;

import android.labs.lab1.TwelveRocks.R;
import android.labs.lab1.TwelveRocks.logic.GameLogic;
import android.labs.lab1.TwelveRocks.ui.MainUI;

public class EasyComputerPlayer extends Player {
	
	private static String MY_NAME = MainUI.getInstance().getString(R.string.easyComputerName);
	
	private static int [] pickTable = {
		0,0,	//0-1 rock(s) left
		1,2,	//2-3 rocks
		3,1,	//4-5 rocks
		1,2,	//6-7 rocks
		3,3		//8-9 rocks
	};
	
	public EasyComputerPlayer (){
		setName(MY_NAME);
	}

	@Override
	public int getPickedRocks() {
		int currentRocksCount  = GameLogic.getInstance().getCurrentRocksCount();
		int maxToPick = GameLogic.getMaxCountToPick();
		int highLimit = maxToPick*maxToPick;
		if (currentRocksCount <= highLimit){
			return pickTable[currentRocksCount];
		}
		return maxToPick;
	}


}
