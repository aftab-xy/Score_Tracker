package com.netcentric.volleyball;

import com.netcentric.scoretracker.*;
import com.netcentric.scoretracker.R;
import com.netcentric.scoretracker.R.id;
import com.netcentric.scoretracker.R.layout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VolleyballGame extends Activity {

	TextView team1;
	TextView team2;
	TextView t1score;
	TextView t2score;
	TextView t1setscore;
	TextView t2setscore;
	TextView time;
	TextView setnum;
	Button attack;
	Button block;
	Button ace;
	Button err;
	Button dec;
	Button incdec;
	Button timeout;
	Button pause;
	String fontPath;
	String teamname1;
	String teamname2;
	Typeface tf;
	int numset;
	int lastset;
	int team;
	int setIndex;
	int scmode;
	int setnumtrack;
	VolleyballTeam t1;
	VolleyballTeam t2;
	VolleyballSet set1;
	VolleyballSet set2;
	long millisec=0;
	long seconds=0;
	long minutes=0;
	String stringTime="";
	final Context context = this;


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
		t1setscore = (TextView) findViewById(R.id.t1setscore);
		t2setscore = (TextView) findViewById(R.id.t2setscore);
		numset = getIntent().getExtras().getInt("numset");
		lastset = getIntent().getExtras().getInt("lastset");
		attack = (Button) findViewById(R.id.attackbtn);
		block = (Button) findViewById(R.id.blockbtn);
		ace = (Button) findViewById(R.id.acebtn);
		err = (Button) findViewById(R.id.errbtn);
		incdec = (Button) findViewById(R.id.incdecbtn);
		timeout = (Button) findViewById(R.id.timeoutbtn);
		setnum = (TextView)findViewById(R.id.setnum);
		pause = (Button) findViewById(R.id.pausebtn);

		team = 1;
		scmode = 1;
		setnumtrack = 1;

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

		// set team sets
		set1 = new VolleyballSet();
		set2 = new VolleyballSet();

		// create teams
		setIndex = 0;
		t1 = new VolleyballTeam(teamname1);
		t2 = new VolleyballTeam(teamname2);

		// add first set
		t1.getSets().add(set1);
		t2.getSets().add(set2);

		team1.setText(t1.getTeamname());
		team2.setText(t2.getTeamname());

		// ---------------------------onClickListeneres-----------------------------------

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
				switch (scmode) {
				case 1:
					if (team == 1) {
						incScore(t1, t1score, 1);
					} else if (team == 2) {
						incScore(t2, t2score, 1);
					}
					break;
				case 0:
					if (team == 1) {
						decScore(t1, t1score, 1);
					} else if (team == 2) {
						decScore(t2, t2score, 1);
					}
				default:
					break;
				}

			}
		});

		// block button function
		block.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (scmode) {
				case 1:
					if (team == 1) {
						incScore(t1, t1score, 2);
					} else if (team == 2) {
						incScore(t2, t2score, 2);
					}
					break;
				case 0:
					if (team == 1) {
						decScore(t1, t1score, 2);
					} else if (team == 2) {
						decScore(t2, t2score, 2);
					}
				default:
					break;
				}

			}
		});

		// ace button function
		ace.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (scmode) {
				case 1:
					if (team == 1) {
						incScore(t1, t1score, 3);
					} else if (team == 2) {
						incScore(t2, t2score, 3);
					}
					break;
				case 0:
					if (team == 1) {
						decScore(t1, t1score, 3);
					} else if (team == 2) {
						decScore(t2, t2score, 3);
					}
				default:
					break;
				}

			}
		});

		// err button function
		err.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (scmode) {
				case 1:
					if (team == 1) {
						incScore(t1, t1score, 4);
					} else if (team == 2) {
						incScore(t2, t2score, 4);
					}
					break;
				case 0:
					if (team == 1) {
						decScore(t1, t1score, 4);
					} else if (team == 2) {
						decScore(t2, t2score, 4);
					}
				default:
					break;
				}

			}
		});

		// increment-decrement button function
		incdec.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (scmode == 1) {
					incdec.setBackgroundResource(R.drawable.decrement);
					attack.setBackgroundResource(R.drawable.decattack);
					block.setBackgroundResource(R.drawable.decblock);
					ace.setBackgroundResource(R.drawable.decace);
					err.setBackgroundResource(R.drawable.decopperr);
					scmode = 0;
				} else {
					incdec.setBackgroundResource(R.drawable.increment);
					attack.setBackgroundResource(R.drawable.attackbutton);
					block.setBackgroundResource(R.drawable.blockbutton);
					ace.setBackgroundResource(R.drawable.acebutton);
					err.setBackgroundResource(R.drawable.opperrorbutton);
					scmode = 1;
				}

			}

		});
		
		pause.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				PauseDialog();
				
			}
		});
		
		//---------------------------------------timer-----------------------------

		timeout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TimeoutDialog();
			}
		});

	}
	
	
	public void TimeoutDialog() {
		// TODO Auto-generated method stub
		final Dialog dialog = new Dialog(VolleyballGame.this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.timeoutdialog);
		
		time = (TextView)dialog.findViewById(R.id.timeoutView);
		
		
		new CountDownTimer(30000, 1000) {

			public void onTick(long millisUntilFinished) {
				//millisec = millisUntilFinished / 1000 ;
				seconds = (millisUntilFinished % 60000) / 1000;
				minutes = millisUntilFinished / 60000;
				stringTime = String.format("%02d:%02d", minutes, seconds, millisec);
				time.setText(stringTime);
			}

			public void onFinish() {
				dialog.dismiss();
			}
		}.start();
		
		dialog.show();

		// final EditText editText =
		// (EditText)dialog.findViewById(R.id.editText1);

		
	}
	
	public void PauseDialog() {
		// TODO Auto-generated method stub
		final Dialog dialog = new Dialog(VolleyballGame.this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.pause);
		
		Button home = (Button) dialog.findViewById(R.id.home);
		Button back = (Button) dialog.findViewById(R.id.back);
		
		home.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(context, MainActivity.class);
				startActivity(intent);
				
				finish();
				
			}
		});
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.dismiss();
				
			}
		});
		
		dialog.show();


		
	}

	// increment score
	public void incScore(VolleyballTeam team, TextView scoreboard, int btn) {
		switch (btn) {
		case 1:
			team.getSets().get(setIndex)
					.setAttack(team.getSets().get(setIndex).getAttack() + 1);
			break;
		case 2:
			team.getSets().get(setIndex)
					.setBlock(team.getSets().get(setIndex).getBlock() + 1);
			break;
		case 3:
			team.getSets().get(setIndex)
					.setAce(team.getSets().get(setIndex).getAce() + 1);
			break;
		case 4:
			team.getSets().get(setIndex)
					.setErr(team.getSets().get(setIndex).getErr() + 1);
			break;
		default:
			break;
		}

		team.getSets().get(setIndex)
				.setScore(team.getSets().get(setIndex).getScore() + 1);
		scoreboard.setText(Integer.toString(team.getSets().get(setIndex)
				.getScore()));
		checkScore();
	}

	// decrement score
	public void decScore(VolleyballTeam team, TextView scoreboard, int btn) {
		switch (btn) {
		case 1:
			team.getSets().get(setIndex)
					.setAttack(team.getSets().get(setIndex).getAttack() - 1);
			break;
		case 2:
			team.getSets().get(setIndex)
					.setBlock(team.getSets().get(setIndex).getBlock() - 1);
			break;
		case 3:
			team.getSets().get(setIndex)
					.setAce(team.getSets().get(setIndex).getAce() - 1);
			break;
		case 4:
			team.getSets().get(setIndex)
					.setErr(team.getSets().get(setIndex).getErr() - 1);
			break;
		default:
			break;
		}

		team.getSets().get(setIndex)
				.setScore(team.getSets().get(setIndex).getScore() - 1);
		scoreboard.setText(Integer.toString(team.getSets().get(setIndex)
				.getScore()));
		checkScore();
	}

	// check if the set is finish
	public void checkScore() {

		if (t1.getSets().get(setIndex).getScore() >= 25
				|| t2.getSets().get(setIndex).getScore() >= 25) {

			// check for deuce score
			if (Math.abs(t1.getSets().get(setIndex).getScore()
					- t2.getSets().get(setIndex).getScore()) != 1
					&& Math.abs(t1.getSets().get(setIndex).getScore()
							- t2.getSets().get(setIndex).getScore()) != 0) {

				// determines who won the set
				if (t1.getSets().get(setIndex).getScore() > t2.getSets()
						.get(setIndex).getScore()) {
					t1.setSetscore(t1.getSetscore() + 1);
					checkMatchPoint();
				} else {
					t2.setSetscore(t2.getSetscore() + 1);
					checkMatchPoint();
				}
				
				
				setEndDialog();
				changeCourt();
			}
		}

	}
	
	
	public void setEndDialog() {
		// TODO Auto-generated method stub
		final Dialog dialog = new Dialog(VolleyballGame.this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.set_end);
		
		Button proceed = (Button)dialog.findViewById(R.id.proceed);
		TextView set;
		set = (TextView)dialog.findViewById(R.id.sett1);
		set.setText(t1.getTeamname());
		set = (TextView)dialog.findViewById(R.id.sett2);
		set.setText(t2.getTeamname());
		
		set = (TextView)dialog.findViewById(R.id.t1attack);
		set.setText(Integer.toString(t1.getSets().get(setIndex).getAttack()));
		set = (TextView)dialog.findViewById(R.id.t1block);
		set.setText(Integer.toString(t1.getSets().get(setIndex).getBlock()));
		set = (TextView)dialog.findViewById(R.id.t1ace);
		set.setText(Integer.toString(t1.getSets().get(setIndex).getAce()));
		set = (TextView)dialog.findViewById(R.id.t1err);
		set.setText(Integer.toString(t1.getSets().get(setIndex).getErr()));
		set = (TextView)dialog.findViewById(R.id.t1sc);
		set.setText(Integer.toString(t1.getSets().get(setIndex).getScore()));
		
		set = (TextView)dialog.findViewById(R.id.t2attack);
		set.setText(Integer.toString(t2.getSets().get(setIndex).getAttack()));
		set = (TextView)dialog.findViewById(R.id.t2block);
		set.setText(Integer.toString(t2.getSets().get(setIndex).getBlock()));
		set = (TextView)dialog.findViewById(R.id.t2ace);
		set.setText(Integer.toString(t2.getSets().get(setIndex).getAce()));
		set = (TextView)dialog.findViewById(R.id.t2err);
		set.setText(Integer.toString(t2.getSets().get(setIndex).getErr()));
		set = (TextView)dialog.findViewById(R.id.t2sc);
		set.setText(Integer.toString(t2.getSets().get(setIndex).getScore()));
		
		set = (TextView)dialog.findViewById(R.id.set);
		set.setText("Set "+(setnumtrack-1));
		
		
		
		proceed.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.dismiss();
				
			}
		});
		
		
		dialog.show();

		
	}
	
	//checks who won the game
	public void checkMatchPoint(){
		if(t1.getSetscore() > numset/2 || t2.getSetscore() > numset/2){
			gameResult();	
		}else{
			setnumtrack++;
		}
	}
	
	public void gameResult(){
		
		Intent intent = new Intent(context, GameOver.class);
		intent.putExtra("t1name", t1.getTeamname());
		intent.putExtra("t2name", t2.getTeamname());
		intent.putExtra("t1score", t1.getSetscore());
		intent.putExtra("t2score", t2.getSetscore());
		startActivity(intent);
	}

	// change court if the set is over
	public void changeCourt() {
		
		

		VolleyballTeam tmp;
		tmp = t1;
		t1 = t2;
		t2 = tmp;

		set1 = new VolleyballSet();
		set2 = new VolleyballSet();
		t1.getSets().add(set1);
		t2.getSets().add(set2);
		setIndex++;

		team1.setText(t1.getTeamname());
		team2.setText(t2.getTeamname());

		t1score.setText("00");
		t2score.setText("00");
		t1setscore.setText(Integer.toString(t1.getSetscore()));
		t2setscore.setText(Integer.toString(t2.getSetscore()));
		setnum.setText(Integer.toString(setnumtrack));

	}
	
	
	
	

}
