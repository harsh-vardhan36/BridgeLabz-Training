package com.json.iplSensorAnalyzer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) 
public class Match {
	@CsvBindByName(column = "MatchID")
	@JsonProperty("match_id")
	private String matchId;

	@CsvBindByName(column = "Team1")
	@JsonProperty("team1")
	private String team1;

	@CsvBindByName(column = "Team2")
	@JsonProperty("team2")
	private String team2;

	@CsvBindByName(column = "PlayerOfMatch")
	@JsonProperty("player_of_match")
	private String playerOfMatch;

	// Getters and Setters
	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public String getPlayerOfMatch() {
		return playerOfMatch;
	}

	public void setPlayerOfMatch(String playerOfMatch) {
		this.playerOfMatch = playerOfMatch;
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
}