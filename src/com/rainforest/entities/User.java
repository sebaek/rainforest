package com.rainforest.entities;

public class User {
	private boolean isMatched = false;
	private	int seq;
	private int matchedSeq; 
	private boolean isOut = false;
	
	private String nickName;
	private String gender;
	private String hobby;
	private String city;
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isMatched() {
		return isMatched;
	}
	public void setMatched(boolean isMatched) {
		this.isMatched = isMatched;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getMatchedSeq() {
		return matchedSeq;
	}
	public void setMatchedSeq(int matchedSeq) {
		this.matchedSeq = matchedSeq;
	}
	public boolean isOut() {
		return isOut;
	}
	public void setOut(boolean isOut) {
		this.isOut = isOut;
	}
	@Override
	public String toString() {
		return "{\"isMatched\":\"" + isMatched + "\", \"seq\":\"" + seq
				+ "\", \"matchedSeq\":\"" + matchedSeq + "\", \"isOut\":\"" + isOut
				+ "\", \"nickName\":\"" + nickName + "\", \"gender\":\"" + gender + "\", \"hobby\":\""
				+ hobby + "\", \"city\":\"" + city + "\"}";
	}
}
