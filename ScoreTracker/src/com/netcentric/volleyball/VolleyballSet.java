package com.netcentric.volleyball;

public class VolleyballSet{
	int score;
	int attack;
	int block;
	int ace;
	int err;
	
	public VolleyballSet(){
		score = 0;
		attack = 0;
		block = 0;
		ace = 0;
		err = 0;

	}
	
	
	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public int getAttack() {
		return attack;
	}


	public void setAttack(int attack) {
		this.attack = attack;
	}


	public int getBlock() {
		return block;
	}


	public void setBlock(int block) {
		this.block = block;
	}


	public int getAce() {
		return ace;
	}


	public void setAce(int ace) {
		this.ace = ace;
	}


	public int getErr() {
		return err;
	}


	public void setErr(int err) {
		this.err = err;
	}
	
}
