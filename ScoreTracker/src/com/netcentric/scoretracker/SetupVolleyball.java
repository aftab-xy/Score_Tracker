package com.netcentric.scoretracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SetupVolleyball extends Activity {
	final Context context = this;
	Button setVolleybtn;
	EditText team1name;
	EditText team2name;
	RadioGroup scoremode;
	RadioGroup numset;
	RadioGroup lastset;
	RadioButton tempBtn;
	int radioId;
	String sScoremode;
	String sTeam1name;
	String sTeam2name;
	int nLastset;
	int nNumset;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.volleyball_setup);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		setVolleybtn = (Button) findViewById(R.id.setVolleybtn);
		team1name = (EditText) findViewById(R.id.team1name);
		team2name = (EditText) findViewById(R.id.team2name);
		scoremode = (RadioGroup) findViewById(R.id.scoremode);
		numset = (RadioGroup) findViewById(R.id.numset);
		lastset = (RadioGroup) findViewById(R.id.lastset);
		
		
		
		

		setVolleybtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				sTeam1name = team1name.getText().toString();
				sTeam2name = team2name.getText().toString();
				
				radioId = scoremode.getCheckedRadioButtonId();
				tempBtn = (RadioButton) findViewById(radioId);
				sScoremode = tempBtn.getText().toString();
				
				radioId = lastset.getCheckedRadioButtonId();
				tempBtn =(RadioButton) findViewById(radioId);
				nLastset = Integer.parseInt(tempBtn.getText().toString());
				
				radioId = numset.getCheckedRadioButtonId();
				tempBtn =(RadioButton) findViewById(radioId);
				nNumset = Integer.parseInt(tempBtn.getText().toString());
				
				Intent intent = new Intent(context, VolleyballGame_Simple.class);
				
				if(sScoremode.equals("detailed")){
					//intent = new Intent(context, )
				}
				intent.putExtra("team1name", sTeam1name);
				intent.putExtra("team2name", sTeam2name);
				intent.putExtra("lastset", nLastset);
				intent.putExtra("numset", nNumset);
				startActivity(intent);
				
				
			}
		});
		
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		// Respond to the action bar's Up/Home button
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		moveTaskToBack(true);
		SetupVolleyball.this.finish();
	}

}
