package com.netcentric.volleyball;

import java.util.ArrayList;

public class VolleyballTeam {
	ArrayList<VolleyballSet> sets;
	int setscore;
	
	public VolleyballTeam(){
		setscore = 0;
		sets = new ArrayList<VolleyballSet>();
	}
	
	public VolleyballTeam(VolleyballSet set){
		setscore = 0;
		sets.add(set);
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

}
