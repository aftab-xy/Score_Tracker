package com.netcentric.scoretracker;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

public class GameOver extends Activity {
	
	TextView t1;
	TextView t2;
	TextView t1score;
	TextView t2score;
	TextView t1banner;
	TextView t2banner;
	Typeface tf;
	String fontPath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_over);
		
		fontPath = "fonts/digital-7.ttf";
		tf = Typeface.createFromAsset(getAssets(), fontPath);

		
		t1 = (TextView) findViewById(R.id.finalt1name);
		t2 = (TextView) findViewById(R.id.finalt2name);
		t1score = (TextView) findViewById(R.id.finalt1score);
		t2score = (TextView) findViewById(R.id.finalt2score);
		
		t1score.setTypeface(tf);
		t2score.setTypeface(tf);
		t1banner = (TextView)findViewById(R.id.t1banner);
		t2banner = (TextView) findViewById(R.id.t2banner);
		
		t1.setText(getIntent().getExtras().getString("t1name"));
		t2.setText(getIntent().getExtras().getString("t2name"));
		t1score.setText(Integer.toString(getIntent().getExtras().getInt("t1score")));
		t2score.setText(Integer.toString(getIntent().getExtras().getInt("t2score")));
		
		
		if(getIntent().getExtras().getInt("t1score") > getIntent().getExtras().getInt("t2score")){
			t1banner.setBackgroundResource(R.drawable.winner);
		}else{
			t2banner.setBackgroundResource(R.drawable.winner);
		}
		
	}
	
	
}
