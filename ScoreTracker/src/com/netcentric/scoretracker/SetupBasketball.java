package com.netcentric.scoretracker;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
 
public class SetupBasketball extends Activity {
	final Context context=this;
	Button button;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.basketball_setup);
		//addListenerOnButton();
		
	

	    
        button = (Button) findViewById(R.id.bballstart);

        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	Intent intent = new Intent(context, BasketballGame.class);
                startActivity(intent); 
            }
        });
 
		}
}