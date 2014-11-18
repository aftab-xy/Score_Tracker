package com.netcentric.scoretracker;

public class Sport {
	public int icon;
    public String title;
    public Sport(){
    	super();
    }
    public Sport(int icon, String title) {
        super();
        this.icon = icon;
        this.title = title;
    }
    public String getTitle() {
		return title;
	}
    
    public int getIcon() {
		return icon;
	}
	public void setIcon(int icon) {
		this.icon = icon;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
