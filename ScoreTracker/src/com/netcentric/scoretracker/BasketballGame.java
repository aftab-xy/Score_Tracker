package com.netcentric.scoretracker;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
 
public class BasketballGame extends Activity {
	
	TextView team1name;
	TextView team2name;
	TextView team1score;
	TextView team2score;
	Button plus1btn;
	Button plus2btn;
	Button plus3btn;
	Button undobtn;
	int score1 = 0;
	int score2 = 0;
	int score1temp;
	int score2temp;
	
	
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.basketball_main);
		//addListenerOnButton();
		
		team1name = (TextView) findViewById(R.id.bballteam1);
		team2name = (TextView) findViewById(R.id.bballteam2);
		plus1btn = (Button) findViewById(R.id.plus1);
		plus2btn = (Button) findViewById(R.id.plus2);
		plus3btn = (Button) findViewById(R.id.plus3);
		undobtn = (Button) findViewById(R.id.undo);
		team1score = (TextView) findViewById(R.id.team1score);
		team2score = (TextView) findViewById(R.id.team2score);
		team1score.setFocusable(true);
		team2score.setFocusable(true);
		
		team1name.setText(getIntent().getExtras().getString("team1name"));
		team2name.setText(getIntent().getExtras().getString("team2name"));
		
		team1score.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				team1score.setSelected(true);
				team2score.setSelected(false);
				
				
			}
		});
		
		team2score.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				team2score.setSelected(true);
				team1score.setSelected(false);
				
				
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