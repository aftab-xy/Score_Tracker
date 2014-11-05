package com.netcentric.scoretracker;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import android.view.KeyEvent;
import android.view.View.OnKeyListener;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.content.Context;
import android.content.Intent;



public class MainActivity extends Activity {
	// Declare the UI component
	    private ListView listitem;
	    private EditText edittext;
	    
	    final Context context=this;
	/** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	    	
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	  
	        Sport sport_data[] = new Sport[]
	                {
	        new Sport(R.drawable.basketball, "Basketball"),
	        new Sport(R.drawable.soccerball, "Soccer"),
	        new Sport(R.drawable.volleyball, "Volleyball"),
	        new Sport(R.drawable.customsport, "Custom Sport")
	        };
	    listitem = (ListView)findViewById(R.id.listitem);
	    SportsAdapter adapter = new SportsAdapter(this, R.layout.list_sports,
	    		sport_data);
	    listitem.setAdapter(adapter);
	    //addKeyListener();
	    
	    listitem.setOnItemClickListener(new OnItemClickListener() {
	    	 
	    	
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
               int position, long id) {
              
              Sport sport1= new Sport();
              sport1=(Sport) parent.getAdapter().getItem(position);
              String string1=sport1.getTitle();
              
              
              if(string1.equals("Basketball")){
              Intent intent = new Intent(context, SetupBasketball.class);
              startActivity(intent); 
              }
            }
	    });	 	    
	    }
	
	    
	    
}

    	
		