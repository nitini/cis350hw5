import java.util.ArrayList;


public abstract class HangmanGame {
	
	protected String secretWord = "";
	protected int guessesRemaining;
	protected String state = "";
	protected ArrayList<Character> letterHistory = new ArrayList<Character>();
	protected char guess;
	protected int stringLength;
	protected int numLettersLeft;
	
	public HangmanGame(String secretWord, int numGuesses, ArrayList<Character> letterHistory) {
		this.secretWord = secretWord;
		this.guessesRemaining = numGuesses;
		this.letterHistory = letterHistory;
	}
	
	public HangmanGame(int stringLength, int numGuesses) {
		this.stringLength = stringLength;
		this.guessesRemaining = numGuesses;
	}
	
	public String getSecretWord() {
		return secretWord;
	}
	
	public int numGuessesRemaining() {
		return guessesRemaining;
	}
	
	public int numLettersRemaining() {
		return numLettersLeft;
	}
	
	public abstract boolean isWin();
	
	public abstract boolean gameOver();
	
	public String displayGameState() {
		return state;
	}
	
	public ArrayList<Character> lettersGuessed () {
		return letterHistory;
	}
	
	public boolean alreadyGuessed(char c) {
		for (char ch : letterHistory) {
			if (ch == c) {
				return true;
			}
		}
		return false;
	}
	
	public abstract boolean makeGuess(char ch);
	
}
