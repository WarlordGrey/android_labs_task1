package android.labs.lab1.TwelveRocks.ui;

import java.util.LinkedList;

import android.app.Activity;
import android.content.Intent;
import android.labs.lab1.TwelveRocks.R;
import android.labs.lab1.TwelveRocks.players.EasyComputerPlayer;
import android.labs.lab1.TwelveRocks.players.HumanPlayer;
import android.labs.lab1.TwelveRocks.players.IRocksPicker;
import android.labs.lab1.TwelveRocks.players.Player;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainUI extends Activity {
	
	private static MainUI me = null;
	
	private LinkedList<Player> players = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rocks_main);
		additionalInit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_ui, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void additionalInit(){
		me = this;
		final Button btnPvP = (Button) findViewById(R.id.btnPvP);
		btnPvP.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				playerVsPlayer();
			}
		});
		final Button btnPvC = (Button) findViewById(R.id.btnPvC);
		btnPvC.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				playerVsComputer();
			}
		});
		final Button btnExit = (Button) findViewById(R.id.btnExit);
		btnExit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				exit();
			}
		});
	}
	
	public static MainUI getInstance(){
		return me;
	}
	
	private void playerVsPlayer(){
		players = new LinkedList<Player>();
		IRocksPicker picker = getIRocksPicker();
		HumanPlayer player1 = new HumanPlayer(getString(R.string.player1), picker);
		players.add(player1);
		HumanPlayer player2 = new HumanPlayer(getString(R.string.player2), picker);
		players.add(player2);
		newGame();
	}
	
	private void playerVsComputer(){
		players = new LinkedList<Player>();
		EasyComputerPlayer comp = new EasyComputerPlayer();
		players.add(comp);
		IRocksPicker picker = getIRocksPicker();
		HumanPlayer human = new HumanPlayer(getString(R.string.player1), picker);
		players.add(human);
		newGame();
	}
	
	private IRocksPicker getIRocksPicker(){
		return new IRocksPicker() {
			
			@Override
			public int pickRocks() {
				return PlayActivity.getInstance().getCurrentRocksToPick();
			}
			
		};
	}
	
	private void newGame(){	
		switchToPlayActivity();
	}
	
	public LinkedList<Player> getPlayers(){
		return players;
	}
	
	private void switchToPlayActivity(){
		Intent intent = new Intent(MainUI.this, PlayActivity.class);
		startActivity(intent);
	}
	
	private void exit(){
		finish();
	}
	
}
