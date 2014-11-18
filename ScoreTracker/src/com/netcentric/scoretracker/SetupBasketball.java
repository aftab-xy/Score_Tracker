package com.netcentric.scoretracker;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
 
public class SetupBasketball extends Activity {
	final Context context=this;
	Button button;
	TextView team1name;
	TextView team2name;
	
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.basketball_setup);
		
        button = (Button) findViewById(R.id.bballstart);
        team1name = (TextView) findViewById(R.id.team1name);
        team2name = (TextView) findViewById(R.id.team2name);

        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	Intent intent = new Intent(context, BasketballGame.class);
            	intent.putExtra("team1name", team1name.getText().toString());
            	intent.putExtra("team2name", team2name.getText().toString());
                startActivity(intent); 
            }
        });
 
		}
}