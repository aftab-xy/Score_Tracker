package com.netcentric.scoretracker;


import com.netcentric.volleyball.SetupVolleyball;
import com.netcentric.volleyball.VolleyballGame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View.OnClickListener;
 
public class SetupBasketball extends Activity {
	final Context context=this;
	Button button;
	TextView team1name;
	TextView team2name;
	RadioGroup quarters;
	int radioId;
	
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.basketball_setup);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
        button = (Button) findViewById(R.id.bballstart);
        team1name = (TextView) findViewById(R.id.team1name);
        team2name = (TextView) findViewById(R.id.team2name);
        quarters = (RadioGroup) findViewById(R.id.quarterset);
        
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	radioId = quarters.getCheckedRadioButtonId();
				RadioButton tempBtn = (RadioButton) findViewById(radioId);
				int minutesperquarter = Integer.parseInt(tempBtn.getText().toString());
				
            	Intent intent = new Intent(context, BasketballGame.class);
            	intent.putExtra("team1name", team1name.getText().toString());
            	intent.putExtra("team2name", team2name.getText().toString());
            	intent.putExtra("quarterset", minutesperquarter);
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
		SetupBasketball.this.finish();
	}
}