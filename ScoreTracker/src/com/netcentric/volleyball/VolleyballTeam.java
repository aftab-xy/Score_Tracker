package com.netcentric.volleyball;

import java.util.ArrayList;

public class VolleyballTeam {
	String teamname;
	ArrayList<VolleyballSet> sets;
	int setscore;
	
	
	public VolleyballTeam(){
		setscore = 0;
		sets = new ArrayList<VolleyballSet>();
		teamname = null;
	}
	
	public VolleyballTeam(String teamname){
		setscore = 0;
		sets = new ArrayList<VolleyballSet>();
		this.teamname = teamname;
	}

	public ArrayList<VolleyballSet> getSets() {
		return sets;
	}

	public void setSets(ArrayList<VolleyballSet> sets) {
		this.sets = sets;
	}

	public int getSetscore() {
		return setscore;
	}

	public void setSetscore(int setscore) {
		this.setscore = setscore;
	}
	
	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
}
