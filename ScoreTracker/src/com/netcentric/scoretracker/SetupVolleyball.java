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

public class SetupVolleyball extends Activity {
	final Context context=this;
	Button setVolleybtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.volleyball_setup);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		setVolleybtn = (Button) findViewById(R.id.setVolleybtn);
		
		setVolleybtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	Intent intent = new Intent(context, VolleyballGame.class);
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
