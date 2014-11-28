package com.netcentric.volleyball;

import com.netcentric.scoretracker.R;
import com.netcentric.scoretracker.R.id;
import com.netcentric.scoretracker.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class VolleyballGame extends Activity {

	TextView team1;
	TextView team2;
	TextView t1score;
	TextView t2score;
	Button attack;
	Button block;
	Button ace;
	Button err;
	Button dec;
	Button incdec;
	String fontPath;
	String teamname1;
	String teamname2;
	Typeface tf;
	int numset;
	int lastset;
	int team;
	int setIndex;
	int scmode;
	VolleyballTeam t1;
	VolleyballTeam t2;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.volleyball_main);

		// locate font style
		fontPath = "fonts/digital-7.ttf";
		tf = Typeface.createFromAsset(getAssets(), fontPath);

		team1 = (TextView) findViewById(R.id.vteam1);
		team2 = (TextView) findViewById(R.id.vteam2);
		t1score = (TextView) findViewById(R.id.t1score);
		t2score = (TextView) findViewById(R.id.t2score);
		numset = getIntent().getExtras().getInt("numset");
		lastset = getIntent().getExtras().getInt("lastset");
		attack = (Button) findViewById(R.id.attackbtn);
		block = (Button) findViewById(R.id.blockbtn);
		ace = (Button) findViewById(R.id.acebtn);
		err = (Button) findViewById(R.id.errbtn);
		incdec = (Button) findViewById(R.id.incdecbtn);
		team = 1;
		scmode = 1;

		// set font style
		t1score.setTypeface(tf);
		t2score.setTypeface(tf);

		// set team names
		if (getIntent().getExtras().getString("team1name").equalsIgnoreCase("")) {
			teamname1 = "Team 1";
		} else {
			teamname1 = getIntent().getExtras().getString("team1name");
		}
		
		if (getIntent().getExtras().getString("team2name").equalsIgnoreCase("")) {
			teamname2 = "Team 2";
		} else {
			teamname2 = getIntent().getExtras().getString("team2name");
		}
		
		team1.setText(teamname1);
		team2.setText(teamname2);
		
		VolleyballSet set1 = new VolleyballSet();
		VolleyballSet set2 = new VolleyballSet();
		setIndex = 0;
		t1 = new VolleyballTeam();
		t2 = new VolleyballTeam();
		t1.getSets().add(set1);
		t2.getSets().add(set2);
		
		
		//---------------------------onClick Listeneres-----------------------------------
		
		
		// set team 1 scoreboard to active
		t1score.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				t1score.setTextColor(Color.parseColor("#ffff00"));
				t2score.setTextColor(Color.parseColor("#d3d3d3"));
				team = 1;

			}
		});

		// set team 2 scoreboard to active
		t2score.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				t2score.setTextColor(Color.parseColor("#ffff00"));
				t1score.setTextColor(Color.parseColor("#d3d3d3"));
				team = 2;

			}
		});

		// attack button function
		attack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch(scmode){
				case 1:
					if (team == 1) {
						incScore(t1, t1score, 1);
					}else if(team == 2){
						incScore(t2, t2score, 1);
					}
					break;
				case 0:
					if (team == 1) {
						decScore(t1, t1score, 1);
					}else if(team == 2){
						decScore(t2, t2score, 1);
					}
				default:break;
				}
				

			}
		});
		
		//block button function
		block.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch(scmode){
				case 1:
					if (team == 1) {
						incScore(t1, t1score, 2);
					}else if(team == 2){
						incScore(t2, t2score, 2);
					}
					break;
				case 0:
					if (team == 1) {
						decScore(t1, t1score, 2);
					}else if(team == 2){
						decScore(t2, t2score, 2);
					}
				default:break;
				}

			}
		});

		//ace button function
		ace.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch(scmode){
				case 1:
					if (team == 1) {
						incScore(t1, t1score, 3);
					}else if(team == 2){
						incScore(t2, t2score, 3);
					}
					break;
				case 0:
					if (team == 1) {
						decScore(t1, t1score, 3);
					}else if(team == 2){
						decScore(t2, t2score, 3);
					}
				default:break;
				}

			}
		});

		//err button function
		err.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch(scmode){
				case 1:
					if (team == 1) {
						incScore(t1, t1score, 4);
					}else if(team == 2){
						incScore(t2, t2score, 4);
					}
					break;
				case 0:
					if (team == 1) {
						decScore(t1, t1score, 4);
					}else if(team == 2){
						decScore(t2, t2score, 4);
					}
				default:break;
				}

			}
		});
		
		//increment-decrement button function
				incdec.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						if(scmode == 1){
							incdec.setBackgroundResource(R.drawable.decrement);
							scmode = 0;
						}else{
							incdec.setBackgroundResource(R.drawable.increment);
							scmode = 1;
						}
						
					}

					
				});


	}

	//increment score
	public void incScore(VolleyballTeam team, TextView scoreboard, int btn) {
		switch (btn) {
		case 1:
			team.getSets().get(setIndex).setAttack(team.getSets().get(setIndex).getAttack()+1);
			break;
		case 2:
			team.getSets().get(setIndex).setBlock(team.getSets().get(setIndex).getBlock()+1);
			break;
		case 3:
			team.getSets().get(setIndex).setAce(team.getSets().get(setIndex).getAce()+1);
			break;
		case 4:
			team.getSets().get(setIndex).setErr(team.getSets().get(setIndex).getErr()+1);
			break;
		default:
			break;
		}
		
		team.getSets().get(setIndex).setScore(team.getSets().get(setIndex).getScore()+1);
		scoreboard.setText(Integer.toString(team.getSets().get(setIndex).getScore()));
		checkScore();
	}
	
	
		//decrement score
		public void decScore(VolleyballTeam team, TextView scoreboard, int btn) {
			switch (btn) {
			case 1:
				team.getSets().get(setIndex).setAttack(team.getSets().get(setIndex).getAttack()-1);
				break;
			case 2:
				team.getSets().get(setIndex).setBlock(team.getSets().get(setIndex).getBlock()-1);
				break;
			case 3:
				team.getSets().get(setIndex).setAce(team.getSets().get(setIndex).getAce()-1);
				break;
			case 4:
				team.getSets().get(setIndex).setErr(team.getSets().get(setIndex).getErr()-1);
				break;
			default:
				break;
			}
			
			team.getSets().get(setIndex).setScore(team.getSets().get(setIndex).getScore()-1);
			scoreboard.setText(Integer.toString(team.getSets().get(setIndex).getScore()));
			checkScore();
		}
	
	//check if the set is finish
	public void checkScore(){
		
		if(t1.getSets().get(setIndex).getScore() >= 25 || t2.getSets().get(setIndex).getScore() >= 25){
			
			//check for deuce score
			if(Math.abs(t1.getSets().get(setIndex).getScore()-t2.getSets().get(setIndex).getScore()) != 1 && Math.abs(t1.getSets().get(setIndex).getScore()-t2.getSets().get(setIndex).getScore()) != 0){
				
				//determines who won the set
				if(t1.getSets().get(setIndex).getScore() > t2.getSets().get(setIndex).getScore()){
					t1.setSetscore(t1.getSetscore() + 1);
				}else{
					t2.setSetscore(t1.getSetscore() + 1);
				}
				changeCourt();
			}
		}
		
	}
	
	//change court if the set is over
	public void changeCourt(){
		team1.setText(teamname2);
		team2.setText(teamname1);
		
		t1score.setText("00");
		t2score.setText("00");
		//t1score = (TextView) findViewById(R.id.t2score);
		//t2score = (TextView) findViewById(R.id.t1score);
	}

}
