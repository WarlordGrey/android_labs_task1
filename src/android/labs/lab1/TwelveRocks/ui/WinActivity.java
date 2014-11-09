package android.labs.lab1.TwelveRocks.ui;

import android.app.Activity;
import android.labs.lab1.TwelveRocks.R;
import android.labs.lab1.TwelveRocks.logic.GameLogic;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_win);
		additionalInit();
	}
	
	private void additionalInit(){
		TextView lblWinnerName = (TextView) findViewById(R.id.lblWinnerName);
		lblWinnerName.setText(GameLogic.getInstance().getWinner().getName());
		Button btnMenu = (Button) findViewById(R.id.btnMenu);
		btnMenu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				backToTheMainMenu();
			}
		});
	}
	
	private void backToTheMainMenu(){
		finish();
	}
	
}
