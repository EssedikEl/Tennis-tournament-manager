package com.gestion.tournoi;

public class MatchThread extends Thread{
	protected Match match;
	protected Boolean auto; 
	protected Boolean afficherDetail;
	
	MatchThread (Match match, Boolean auto, Boolean afficherDetail){
		this.match = match;
		this.auto = auto;
		this.afficherDetail = afficherDetail;
	}
	
	public void run() {
	    match.LancerMatch(auto,afficherDetail);
	}

}
