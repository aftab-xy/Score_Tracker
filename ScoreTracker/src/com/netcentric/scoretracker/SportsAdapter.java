package com.netcentric.scoretracker;

import android.app.Activity;
import android.content.Context; 
import android.view.LayoutInflater; 
import android.view.View;
import android.view.ViewGroup; 
import android.widget.ArrayAdapter; 
import android.widget.ImageView; 
import android.widget.TextView;

public class SportsAdapter extends ArrayAdapter<Sport>{
	Context context;
	int layoutResourceId;
	Sport data[] = null;
	
	public SportsAdapter(Context context, int layoutResourceId, Sport[] data) {
	    super(context, layoutResourceId, data);
	    //Initialize local variables
	    this.layoutResourceId = layoutResourceId;
	    this.context = context;
	    this.data = data;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	    View row = convertView;
	    SportHolder holder = null;
	// If view is null it will initialize the LayoutInflater and the // FruitHolder
	if(row == null)
	{
	LayoutInflater inflater = ((Activity)context).getLayoutInflater(); row = inflater.inflate(layoutResourceId, parent, false);
	        holder = new SportHolder();
	        holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
	        holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
	        row.setTag(holder);
	    }
	else {
		holder = (SportHolder)row.getTag();
	}
	    Sport sport = data[position];
	    holder.txtTitle.setText(sport.title);
	    holder.imgIcon.setImageResource(sport.icon);
	    return row; }
    //Temporary holder class
	
    static class SportHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
    }
}
