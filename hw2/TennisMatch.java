package hw2;
/**
 * This represents a tennis match.
 * @author Isaac Plambeck
 **/
import hw2.TennisPlayer;

public class TennisMatch {
	/**
	 * If the tennis match is best out of three.
	 */
	private boolean bestOfThree;
	/**
	 * The Server
	 */
	private int server;
	/**
	 * Amount of faults in current game.
	 */
	private int faults;
	/**
	 * The number of server faults.
	 */
	private boolean serveFault;
	/**
	 * The number if games played.
	 */
	private int gamesPlayed;
	
	
	//if ball in play, true
	//if ball out of play, false.
	private boolean ballInPlay;
	
	/**
	 * The winner of the match.
	 */
	private String winner;
	/**
	 * If the ball is served.
	 */
	private boolean ballServed;
	
	//if game is over, true
	//if game going on , false
	private boolean isGameOver;
	
	//whoever last hit the ball.
	private int lastHit;
	/**
	 * player one end.
	 */
	private int p1End;
	/**
	 * Player 2 End.
	 */
	private int p2End;
	/**
	 * Tennis Player 1 from TennisPlayer Class.
	 */
	private TennisPlayer p1;
	/**
	 * Tennis Player 2 from TennisPlayer Class.
	 */
	private TennisPlayer p2;
	
	//constructor
	public TennisMatch(java.lang.String p1Name,
            java.lang.String p2Name,
            boolean playBestOfThree,
            int initialServer,
            int initialServerEnd) {
		
		server = initialServer;
		
		if (playBestOfThree == true) {
			bestOfThree = true;
		}
		else {
			bestOfThree = false;
		}
		
		if(initialServer == 1) {
			server = 1;
			if(initialServerEnd == 1) {
				p1End = 1;
				p2End = 2;
			}
			else {
				p1End = 2;
				p2End = 1;
			}
		}
		
		if(initialServer == 2) {
			server = 2;
			if(initialServerEnd == 1) {
				p2End = 1;
				p1End = 2;
			}
			else {
				p2End = 2;
				p1End= 1;
			}
		}

		p1 = new TennisPlayer(p1Name, p1End);
		
		p2 = new TennisPlayer(p2Name, p2End);
		
		
		ballInPlay = false;
		
		isGameOver = false;
		
		lastHit = 0;
		
		faults = 0;
		
		serveFault = false;
		
		ballServed = false;
		
		winner = "Game is not over!";
		
		gamesPlayed = 0;
		
		
		
	}
	
	
	/**
	 * Serves the ball. Does nothing if the game is over.
	 */
	public void serve() {
		if(isGameOver == false) {
			lastHit = 0;
			ballInPlay = true;	
			ballServed = true;
		}
		else {
			ballServed = false;
		}
		
	}
	
	/**
	 * Registers a serve fault. Does nothing if the ball is not being served. Two serve faults yield a game point for the receiver.
	 */
	public void fault() {
		if(ballServed == true) {
			serveFault = true;
		
		if(faults == 0) {
			faults++;
		}
		else if(faults == 1) {
			faults = 0;
			if(server == 1) {
				incrementGamePoints(p2, p1);
			}
			else if(server == 2) {
				incrementGamePoints(p1, p2);
			}
		}
		
		}
		else {
			serveFault = false;
		}
		
	}
	
	/**
	 * Reverses the direction of the ball. Ball is no longer being served. Does nothing if the ball is not in play.
	 */
	public void returnBall() {
		if(ballInPlay == false) {
		}
		else if(ballInPlay == true) {
			ballServed = false;
			if(lastHit ==0) {
				if(server == 1) {
					lastHit = 2;
				}
				else if(server == 2) {
					lastHit = 1;
				}
			}
			else if(lastHit == 1) {
				lastHit = 2;
			}
			else if(lastHit == 2) {
				lastHit = 1;
			}
		}
	}
	/**
	 * Takes the ball out of play. The player who last served or returned the ball scores a game point.
	 */
	public void failedReturn() {
		if(lastHit == 0) {
			if(server == 1) {
				incrementGamePoints(p1, p2);
			}
			else if(server == 2) {
				incrementGamePoints(p2, p1);
			}
		}
		else if(lastHit == 1) {
			incrementGamePoints(p1, p2);
		}
		else if(lastHit == 2) {
			incrementGamePoints(p2, p1);
		}
	}
	
	/**
	 * Ends the current point early without a point being scored.
	 */
	public void let() {
		ballServed = false;
		ballInPlay = false;
		lastHit= 0;
	}
	
	/**
	 * Returns the match score p1-p2
	 * @return The match score
	 */
	public java.lang.String getMatchScore(){
		return "Match score: " + p1.getMatchPoints() + "-" + p2.getMatchPoints();
	}
	/**
	 * Returns the set score p1-p2
	 * @return The set score
	 */
	public java.lang.String getSetScore(){
		return "Set score: " + p1.getSetPoints() + "-" + p2.getSetPoints();
	}
	
	/**
	 * Returns the game score p1-p2, Advantage name or Deuce. See section 5 of the Friend of the Court.
	 * @return The game score
	 */
	public java.lang.String getGameScore(){
		
		
		String p1g = null;
		String p2g = null;

		
		if(p1.getGamePoints() >= 0) {
			if(p1.getGamePoints() == 0) {
				p1g = "Love";
			}
			else if(p1.getGamePoints() == 1) {
				p1g = "15";
			}
			else if(p1.getGamePoints() == 2) {
				p1g = "30";
			}
			else if(p1.getGamePoints() == 3) {
				p1g = "40";
			}
		}
		
		if(p2.getGamePoints() >= 0) {
			if(p2.getGamePoints() == 0) {
				p2g = "Love";
			}
			else if(p2.getGamePoints() == 1) {
				p2g = "15";
			}
			else if(p2.getGamePoints() == 2) {
				p2g = "30";
			}
			else if(p2.getGamePoints() == 3) {
				p2g = "40";
			}
		}
	

		
		if((p1.getGamePoints() == p2.getGamePoints()) && (p1.getGamePoints() >= 3 && p2.getGamePoints() >= 3 )) {
			return "Game score: " + "Deuce";
		}
		
		if(p1.getGamePoints() >= (p2.getGamePoints() + 2) && (p1.getGamePoints() >= 3 && p2.getGamePoints() >= 3 )) {
			p1.setGamePoints(0);
			p2.setGamePoints(0);
			return "Game score: " + p1g + "-" + p2g;
		}
		
		if(p2.getGamePoints() >= (p1.getGamePoints() + 2) && (p1.getGamePoints() >= 3 && p2.getGamePoints() >= 3 )) {
			p2.setGamePoints(0);
			p1.setGamePoints(0);
			return "Game score: " + p1g + "-" + p2g;
		}
		
		if((p1.getGamePoints() >= p2.getGamePoints()) && (p1.getGamePoints() >= 3 && p2.getGamePoints() >= 3 )){
			return "Advantage: " + p1.getName();
		}
		
		if((p2.getGamePoints() >= p1.getGamePoints()) && (p1.getGamePoints() >= 3 && p2.getGamePoints() >= 3 )){
			return "Advantage: " + p2.getName();
		}

			return "Game score: " + p1g + "-" + p2g;
	}
	
	/**
	 * Set the game, set, and match scores
	 * @param givenp1Game - Player 1's new game score
	 * @param givenp2Game - Player 2's new game score
	 * @param givenp1Set - Player 1's new set score
	 * @param givenp2Set - Player 2's new set score
	 * @param givenp1Match - Player 1's new match score
	 * @param givenp2Match - Player 2's new match score
	 */
	public void setScore(int p1Game, int p2Game, int p1Set, int p2Set, int p1Match, int p2Match) {
		
		p1.setGamePoints(p1Game);
		p2.setGamePoints(p2Game);
		p1.setSetPoints(p1Set);
		p2.setSetPoints(p2Set);
		p1.setMatchPoints(p1Match);
		p2.setMatchPoints(p2Match);
	}
	
	/**
	 * Returns the full game, set, and match score
	 * @return The score
	 */
	public java.lang.String getScore(){
		if(isGameOver == true) {
			return getMatchScore();
		}
		else {
			return getGameScore()+"\n"+getSetScore()+"\n"+getMatchScore();
		}
	}
	
	/**
	 * Sets the game score
	 * @param p1Game - Player 1's new game score
	 * @param p2Game - Player 2's new game score
	 */
	public void setGameScore(int p1Game, int p2Game) {
		p1.setGamePoints(p1Game);
		p2.setGamePoints(p2Game);
	}
	
	/**
	 * Sets the set score
	 * @param p1Set - Player 1's new set score
	 * @param p2Set - Player 2's new set score
	 */
	public void setSetScore(int p1Set, int p2Set) {
		p1.setSetPoints(p1Set);
		p2.setSetPoints(p2Set);
	}
	/**
	 * Sets the match score
	 * @param p1Match - Player 1's new match score
	 * @param p2Match - Player 2's new match score
	 */
	public void setMatchScore(int p1Match, int p2Match) {
		p1.setMatchPoints(p1Match);
		p2.setMatchPoints(p2Match);
	}
	
	/**
	 * Sets the server
	 * @param player - the new server
	 */
	public void setServe(int player) {
		server = player;
	}
	/**
	 * Sets the server's end
	 * @param end - the new end
	 */
	public void setServerEnd(int end) {
		if(server == 1) {
			p1.setEnd(end);
			if(end == 1) {
				p2.setEnd(2);
			}
			else {
				p2.setEnd(1);
			}
		}
		else if(server == 2){
			p2.setEnd(end);
			if(end == 1) {
				p1.setEnd(2);
			}
			else {
				p1.setEnd(1);
			}
		}
	}
	
	/**
	 * Returns the winner's name, or an error message if the game is not over.
	 * @return the winner
	 */
	public java.lang.String getWinner(){
		return winner;
	}
	
	/**
	 * Swaps the ends of the two players
	 */
	public void changeEnds() {
		if(p1.getEnd() == 1) {
			p1.setEnd(2);
			p2.setEnd(1);
		}
		else if(p1.getEnd() == 2) {
			p1.setEnd(1);
			p2.setEnd(2);
		}
	}
	
	/**
	 * Swaps the server and receiver
	 */
	public void changeServer() {
		if(server == 1) {
			server = 2;
		}
		else {
			server = 1;
		}
	}
	
	/**
	 * Adds one game point to addTo's game total. Zeros game score and increments set score if game has ended. Removes ball from play. Clears faults.
	 * @param addTo - The player who has scored a point
	 * @param noAdd - The other player
	 */
	public void incrementGamePoints(TennisPlayer addTo, TennisPlayer noAdd) {
		
		
		
		ballInPlay = false;
		ballServed = false;
		lastHit = 0;
		if(addTo == p1) {
			if(p1.getGamePoints() == 0) {
				p1.incrementGamePoints();
			}
			else if(p1.getGamePoints() == 1) {
				p1.incrementGamePoints();
			}
			else if(p1.getGamePoints() == 2) {
				p1.incrementGamePoints();
			}
			else if(p1.getGamePoints() == 3) {
				if(p2.getGamePoints() == 3) {
					p1.incrementGamePoints();	
				}
				else if(p2.getGamePoints() <= 2) {
					incrementSetPoints(p1, p2);
					changeServer();
					p1.setGamePoints(0);
					p2.setGamePoints(0);
					gamesPlayed = gamesPlayed +1;
					if(gamesPlayed%2 == 0) {
					}
					else {
						changeEnds();
					}
				}
				
				else if(p2.getGamePoints() > 3) {
					p1.incrementGamePoints();
					p2.setGamePoints(4);
				}
			}
			else if(p1.getGamePoints() >= 4 && p1.getGamePoints() == p2.getGamePoints()) {
				p1.setGamePoints(4);
				p2.setGamePoints(3);
			}
			else if(p1.getGamePoints() >= 4 && p1.getGamePoints() > p2.getGamePoints()) {
				incrementSetPoints(p1, p2);
				changeServer();
				p1.setGamePoints(0);
				p2.setGamePoints(0);
				gamesPlayed = gamesPlayed +1;
				if(gamesPlayed%2 == 0) {
				}
				else {
					changeEnds();
				}
			}
			else if(p1.getGamePoints() >= 4 && p1.getGamePoints() < p2.getGamePoints()) {
				p2.setGamePoints(3);
				p1.setGamePoints(3);
			}
		}
		else if(addTo == p2) {
			if(p2.getGamePoints() == 0) {
				p2.incrementGamePoints();
			}
			else if(p2.getGamePoints() == 1) {
				p2.incrementGamePoints();
			}
			else if(p2.getGamePoints() == 2) {
				p2.incrementGamePoints();
			}
			else if(p2.getGamePoints() == 3) {
				if(p1.getGamePoints() == 3) {
					p2.incrementGamePoints();	
				}
				else if(p1.getGamePoints() <= 2) {
					incrementSetPoints(p2, p1);
					changeServer();
					p1.setGamePoints(0);
					p2.setGamePoints(0);
					gamesPlayed = gamesPlayed +1;
					if(gamesPlayed%2 == 0) {
					}
					else {
						changeEnds();
					}
				}
				else if(p1.getGamePoints() > 3) {
					p2.incrementGamePoints();
					p1.setGamePoints(4);
				}
				
			}
			else if(p2.getGamePoints() >= 4 && p2.getGamePoints() == p1.getGamePoints()) {
				p2.setGamePoints(4);
				p1.setGamePoints(3);
			}
			else if(p2.getGamePoints() >= 4 && p2.getGamePoints() > p1.getGamePoints()) {
				incrementSetPoints(p2, p1);
				changeServer();
				p1.setGamePoints(0);
				p2.setGamePoints(0);
				gamesPlayed = gamesPlayed +1;
				if(gamesPlayed%2 == 0) {
				}
				else {
					changeEnds();
				}
			}
			else if(p2.getGamePoints() >= 4 && p2.getGamePoints() < p1.getGamePoints()) {
				p1.setGamePoints(3);
				p2.setGamePoints(3);
			}
		}
	}
	/**
	 * Adds one set point to addTo's total. Zeros set score and increments match score if set has ended. Changes server. Changes ends after odd numbered sets.
	 * @param addTo - The player who has scored a point
	 * @param noAdd - The other player
	 */
	public void incrementSetPoints(TennisPlayer addTo, TennisPlayer noAdd) {

		
		if(addTo == p1) {
			if(p1.getSetPoints() == 0) {
				p1.incrementSetPoints();
			}
			else if(p1.getSetPoints() == 1) {
				p1.incrementSetPoints();
			}
			else if(p1.getSetPoints() == 2) {
				p1.incrementSetPoints();
			}
			else if(p1.getSetPoints() == 3) {
				p1.incrementSetPoints();
			}
			else if(p1.getSetPoints() == 4) {
				p1.incrementSetPoints();
			}
			else if(p1.getSetPoints() == 5) {
				if(p2.getSetPoints() >= 5) {
					p1.incrementSetPoints();
				}
				else if(p2.getSetPoints() <= 4) {
					incrementMatchPoints(p1, p2);
					p1.setSetPoints(0);
					p2.setSetPoints(0);
				}
			}
			else if(p1.getSetPoints() >= 6 && p1.getSetPoints() == p2.getSetPoints()) {
				p1.setSetPoints(7);
				p2.setSetPoints(6);
			}
			else if(p1.getSetPoints() >= 6 && p1.getSetPoints() > p2.getSetPoints()) {
				incrementMatchPoints(p1, p2);
				p1.setSetPoints(0);
				p2.setSetPoints(0);
			}
			else if(p1.getSetPoints() >= 6 && p1.getSetPoints() < p2.getSetPoints()) {
				p1.setSetPoints(6);
				p2.setSetPoints(6);
			}
		}
		else if(addTo == p2) {
			if(p2.getSetPoints() == 0) {
				p2.incrementSetPoints();
			}
			else if(p2.getSetPoints() == 1) {
				p2.incrementSetPoints();
			}
			else if(p2.getSetPoints() == 2) {
				p2.incrementSetPoints();
			}
			else if(p2.getSetPoints() == 3) {
				p2.incrementSetPoints();
			}
			else if(p2.getSetPoints() == 4) {
				p2.incrementSetPoints();
			}
			else if(p2.getSetPoints() == 5) {
				if(p1.getSetPoints() == 5) {
					p2.incrementSetPoints();
				}
				else if(p1.getSetPoints() <= 4) {
					incrementMatchPoints(p2, p1);
					p2.setSetPoints(0);
					p1.setSetPoints(0);
				}
			}
			else if(p2.getSetPoints() >= 6 && p2.getSetPoints() == p1.getSetPoints()) {
				p2.setSetPoints(7);
				p1.setSetPoints(6);
			}
			else if(p2.getSetPoints() >= 6 && p2.getSetPoints() > p1.getSetPoints()) {
				incrementMatchPoints(p2, p1);
				p2.setSetPoints(0);
				p1.setSetPoints(0);
			}
			else if(p2.getSetPoints() >= 6 && p2.getSetPoints() < p1.getSetPoints()) {
				p2.setSetPoints(6);
				p1.setSetPoints(6);
			}
		}
	}
	/**
	 * Adds one match point to addTo's total. Sets game over if match has ended.
	 * @param addTo - The player who has scored a point
	 * @param noAdd - The other player
	 */
	public void incrementMatchPoints(TennisPlayer addTo, TennisPlayer noAdd) {
		if(bestOfThree == true) {
			if(addTo == p1) {
				if(p1.getMatchPoints() == 0) {
					p1.incrementMatchPoints();
				}
				else if(p1.getMatchPoints() == 1) {
					winner = p1.getName();
					isGameOver = true;
					p1.incrementMatchPoints();
				}
			}
			else if(addTo == p2) {
				if(p2.getMatchPoints() == 0) {
					p2.incrementMatchPoints();
				}
				else if(p2.getMatchPoints() == 1) {
					winner = p2.getName();
					isGameOver = true;
					p2.incrementMatchPoints();
				}
			}
		}
		if(bestOfThree == false) {
			if(addTo == p1) {
				if(p1.getMatchPoints() == 0) {
					p1.incrementMatchPoints();
				}
				else if(p1.getMatchPoints() == 1) {
					p1.incrementMatchPoints();
				}
				else if(p1.getMatchPoints() == 2) {
					winner = p1.getName();
					isGameOver = true;
					p1.incrementMatchPoints();
				}
			}
			else if(addTo == p2) {
				if(p2.getMatchPoints() == 0) {
					p2.incrementMatchPoints();
				}
				else if(p2.getMatchPoints() == 1) {
					p2.incrementMatchPoints();
				}
				else if(p2.getMatchPoints() == 2) {
					winner = p2.getName();
					isGameOver = true;
					p2.incrementMatchPoints();
				}
			}
		}
	}
	
	
	/**
	 * Returns p1's end
	 * @return p1's end
	 */
	public int getP1End() {
		return p1.getEnd();
	}
	
	/**
	 * Returns p1's end
	 * @return p1's end
	 */
	public int getP2End() {
		return p2.getEnd();
	}
	
	/**
	 * Returns serve fault status
	 * @return serve fault status
	 */
	public boolean getServeFault() {
		return serveFault;
	}
	
	/**
	 * Returns the server's name or "No server"
	 * @return the server's name
	 */
	public java.lang.String getServer(){
		String serverName = null;
		
		if(server == 1) {
			serverName = p1.getName();
		}
		else if(server == 2) {
			serverName = p2.getName();
		}
		else {
			serverName = "No server";
		}
		
	return serverName;
		
		
	}
	
	/**
	 * Returns the reveiver's name or "No receiver"
	 * @return the receiver's name
	 */
	public java.lang.String getReceiver(){
		String receiverName = null;
		
		if(server == 1) {
			receiverName = p2.getName();
		}
		else if(server == 2) {
			receiverName = p1.getName();
		}
		else {
			receiverName = "No receiver";
		}
		
		return receiverName;
		
	}
	
	/**
	 * Returns the name of the player whom the ball is heading toward or "Ball not in play"
	 * @return ballTo's name
	 */
	public java.lang.String getBallTo(){
		String ballTo = null;
		if(ballInPlay == false) {
			ballTo = "Ball not in play";
		}
		else if(ballInPlay == true) {
			if(lastHit == 0) {
				if(server == 1) {
					ballTo = p2.getName();
				}
				else if(server == 2) {
					ballTo = p1.getName();
				}
			}
			else if(lastHit == 1) {
				ballTo = p2.getName();
			}
			else if(lastHit == 2) {
				ballTo = p1.getName();
			}
		}
		return ballTo;
	}
	
	/**
	 * Returns the name of the player who last successfully served or returned the ball or "Ball not in play"
	 * @return ballFrom's name
	 */
	public java.lang.String getBallFrom(){
		String ballFrom = null;
		if(ballInPlay == false) {
			ballFrom = "Ball not in play";
		}
		else if(ballInPlay == true) {
			if(lastHit == 0) {
				if(server == 1) {
					ballFrom = p1.getName();
				}
				else if(server == 2) {
					ballFrom = p2.getName();
				}
			}
			else if(lastHit == 1) {
				ballFrom = p1.getName();
			}
			else if(lastHit == 2) {
				ballFrom = p2.getName();
			}
		}
		return ballFrom;
	}	
	
	/**
	 * Returns ballInPlay
	 * @return ballInPlay
	 */
	public boolean getBallInPlay() {
		return ballInPlay;
	}
	
	/**
	 * Returns ballServed
	 * @return ballServed
	 */
	public boolean getBallServed() {
		return ballServed;
	}
	
	/**
	 * returns bestOfThree
	 * @return bestOfThree
	 */
	public boolean getBestOfThree() {
		return bestOfThree;
	}
	
	/**
	 * Returns gameOver
	 * @return gameOver
	 */
	public boolean getGameOver() {
		return isGameOver;
	}
	
	/**
	 * Returns player's name
	 * @param player - the player
	 * @return player's name
	 */
	public java.lang.String getName(int player){
		if(player == 1) {
			return p1.getName();
		}
		else {
			return p2.getName();
		}
		
	}
	
	
}