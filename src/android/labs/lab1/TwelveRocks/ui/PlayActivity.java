package android.labs.lab1.TwelveRocks.ui;

import java.util.LinkedList;

import android.app.Activity;
import android.content.Intent;
import android.labs.lab1.TwelveRocks.R;
import android.labs.lab1.TwelveRocks.filters.InputFilterMinMax;
import android.labs.lab1.TwelveRocks.logic.GameLogic;
import android.labs.lab1.TwelveRocks.players.Player;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PlayActivity extends Activity {

	private static int START_INDEX = -1;
	

	private static PlayActivity me = null;
	
	private LinkedList <Player> players = null;
	private int current = START_INDEX;
	
	private EditText txtRocksToPick = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		additionalInit();
	}
	
	private void nextTurn(Player player){
		GameLogic.getInstance().nextTurn(player);
		if (GameLogic.getInstance().isSomeoneWon()){
			switchToWinActivity();
		}
	}
	
	private void additionalInit(){
		me = this;
		newGame(MainUI.getInstance().getPlayers());
		txtRocksToPick = (EditText) findViewById(R.id.txtRocksToPick);
		txtRocksToPick.setFilters(
				new InputFilter[]{
						new InputFilterMinMax(
								GameLogic.getMinCountToPick(),
								GameLogic.getMaxCountToPick()
						)
				}
		);
		Button btnPick = (Button) findViewById(R.id.btnNextTurn);
		btnPick.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				pickRocks();
			}
		});
		Button btnSurrender = (Button) findViewById(R.id.btnSurrender);
		btnSurrender.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				surrender();
			}
		});
		startToPlay();
	}

	
	public void updateInfo(){
		TextView lblRocksCount = (TextView) findViewById(R.id.lblRocksCount);
		lblRocksCount.setText(String.valueOf(GameLogic.getInstance().getCurrentRocksCount()));
		TextView lblPlayer = (TextView) findViewById(R.id.lblPlayer);
		lblPlayer.setText(getCurrentPlayer().getName());
	}
	
	public static PlayActivity getInstance(){
		return me;
	}
	
	private void pickRocks(){
		nextTurn(getCurrentPlayer());
		if (!GameLogic.getInstance().isSomeoneWon()){
			computerTurn();
			
		} else if (GameLogic.getInstance().isPlayerPickedLast()) {
			GameLogic.getInstance().setWinner(getNextPlayer());
		}
	}
	
	private void computerTurn(){
		while (!getNextPlayer().isHumanPlayer()){
			nextTurn(getCurrentPlayer());
		}
		updateInfo();
	}
	
	public int getCurrentRocksToPick(){
		return Integer.parseInt(txtRocksToPick.getText().toString());
	}
	
	private Player getNextPlayer(){
		current++;
		if (current == players.size()){
			current = START_INDEX;
		}
		return getCurrentPlayer();
	}
	
	private Player getCurrentPlayer(){
		if (current == START_INDEX){
			current++;
		}
		return players.get(current);
	}
	
	public void newGame(LinkedList<Player> players){
		GameLogic.getInstance().newGame();
		this.players = players;
		current = START_INDEX;
	}
	
	private void surrender(){
		GameLogic.getInstance().setWinner(getNextPlayer());
		switchToWinActivity();
	}
	
	private void switchToWinActivity(){
		Intent intent = new Intent(PlayActivity.this, WinActivity.class);
		startActivity(intent);
		finish();
	}
	
	private void startToPlay(){
		computerTurn();
	}
	
}
