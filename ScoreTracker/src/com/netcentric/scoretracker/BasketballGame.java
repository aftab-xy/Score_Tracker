package com.netcentric.scoretracker;

import com.netcentric.scoretracker.R;
import com.netcentric.scoretracker.R.id;
import com.netcentric.scoretracker.R.layout;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.os.CountDownTimer;

public class BasketballGame extends Activity {
	
	 
	
	TextView team1name;
	TextView team2name;
	TextView team1score;
	TextView team2score;
	TextView time;
	Button plus1btn;
	Button plus2btn;
	Button plus3btn;
	Button undobtn;
	Button timeoutbtn;
	Button startbtn;
	Button pausebtn;
	int score1 = 0;
	int score2 = 0;
	int score1temp;
	int score2temp;
	int isStart=0;
	long minutes, seconds;
	String stringTime;
	Typeface tf;
	String fontPath;
	
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.basketball_main);
		//addListenerOnButton();
		
		
		
		fontPath = "fonts/digital-7.ttf";
		tf = Typeface.createFromAsset(getAssets(), fontPath);
		
		team1name = (TextView) findViewById(R.id.bballteam1);
		team2name = (TextView) findViewById(R.id.bballteam2);
		time = (TextView) findViewById(R.id.timer);
		plus1btn = (Button) findViewById(R.id.plus1);
		plus2btn = (Button) findViewById(R.id.plus2);
		plus3btn = (Button) findViewById(R.id.plus3);
		undobtn = (Button) findViewById(R.id.undo);
		startbtn = (Button) findViewById(R.id.start);
		pausebtn = (Button) findViewById(R.id.pause);
		timeoutbtn = (Button) findViewById(R.id.timeoutbutton);
		team1score = (TextView) findViewById(R.id.team1score);
		team2score = (TextView) findViewById(R.id.team2score);
		team1score.setFocusable(true);
		team2score.setFocusable(true);
		
		team1name.setText(getIntent().getExtras().getString("team1name"));
		team2name.setText(getIntent().getExtras().getString("team2name"));
		
		team1score.setTypeface(tf);
		team2score.setTypeface(tf);
		team1score.setTextColor(Color.parseColor("#d3d3d3"));
		team2score.setTextColor(Color.parseColor("#d3d3d3"));
		
		
		
		
		team1score.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				team1score.setSelected(true);
				team2score.setSelected(false);
				team1score.setTextColor(Color.parseColor("#ffff00"));
				team2score.setTextColor(Color.parseColor("#d3d3d3"));
				
			}
		});
		
		team2score.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				team2score.setSelected(true);
				team1score.setSelected(false);
				team2score.setTextColor(Color.parseColor("#ffff00"));
				team1score.setTextColor(Color.parseColor("#d3d3d3"));
				
			}
		});
		
		
		
		
		startbtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				new CountDownTimer(300000, 1000) {

				    public void onTick(long millisUntilFinished) {
				   	 	seconds = (millisUntilFinished % 60000)/1000;
						minutes = millisUntilFinished / 60000;
						stringTime = String.format("%02d:%02d", minutes, seconds);
				        time.setText(stringTime);
				     }

				     public void onFinish() {
				        time.setText("done!");
				     }
				  }.start();
			}
		});
		
		
		pausebtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				new CountDownTimer(300000, 1000) {

				     public void onTick(long millisUntilFinished) {
				         time.setText(""+millisUntilFinished / 1000);
				     }

				     public void onFinish() {
				        time.setText("done!");
				     }
				  }.cancel();
			}
		});
		
		
		
		
		plus1btn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				if(team1score.isSelected()){
					score1temp = score1;
					score1++;
					team1score.setText(Integer.toString(score1));
					System.out.println("plus 1");
				}else if(team2score.isSelected()){
					score2temp = score2;
					score2++;
					team2score.setText(Integer.toString(score2));
				}
			}
		});
		
		plus2btn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				if(team1score.isSelected()){
					score1temp = score1;
					score1+=2;
					team1score.setText(Integer.toString(score1));
				}else if(team2score.isSelected()){
					score2temp = score2;
					score2+=2;
					team2score.setText(Integer.toString(score2));
				}
			}
		});
		
		plus3btn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				if(team1score.isSelected()){
					score1temp = score1;
					score1+=3;
					team1score.setText(Integer.toString(score1));
				}else if(team2score.isSelected()){
					score2temp = score2;
					score2+=3;
					team2score.setText(Integer.toString(score2));
				}
			}
		});
		
		
		undobtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				if(team1score.isSelected()){
					team1score.setText(Integer.toString(score1temp));
				}else if(team2score.isSelected()){
					team2score.setText(Integer.toString(score2temp));
				}
			}
		});

	    
		}	
}