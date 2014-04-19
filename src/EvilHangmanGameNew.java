import java.io.File;
import java.util.Scanner;


public class EvilHangmanGameNew extends HangmanGameAbstract {
	
	private String[] wordList = new String[235000];
	private int numWords = 0;
	private boolean guessResult;
	
	public EvilHangmanGameNew (int stringLength, int numGuesses) {
		super(stringLength, numGuesses);
		super.numLettersLeft = 26;
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("dictionary.txt"));// read the dictionary
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		int i = 0;
		while (scanner.hasNext()) {
			String temp = scanner.nextLine().toUpperCase();
			if (temp.length() == super.stringLength) {
				wordList[i] = temp;
				i++;
				numWords++;
			}
		}
		
		for (i = 0; i < super.stringLength; i++) {
			super.state += "_ ";
		}
		scanner.close();
	}

	@Override
	public boolean isWin() {
		return false;
	}

	@Override
	public boolean gameOver() {
		if (super.guessesRemaining == 0)
			return true;
		else
			return false;
	}
	
	// adjust the Wordlist in order to avoid the word with the letter
	// user guessed
	public int adjustWordList(char ch) {
		int tempWordNum = 0;
		for (int i = 0; i < numWords; i++) {
			for (int j = 0; j < super.stringLength; j++) {
				if (wordList[i].charAt(j) == ch) {
					break;
				} else {
					if (j == super.stringLength - 1) {
						if (wordList[i].charAt(j) != ch) {
							tempWordNum++;
						}
					}
				}
			}
		}
		return tempWordNum;
	}
	
	// we choose the words that don't contain the letter the user
	// guessed, and they will be the new possible secret words.
	public String[] generateNewWordList(int tempWordNum, char ch) {
		String[] temp = new String[tempWordNum];
		int tempIndex = 0;
		for (int i = 0; i < numWords; i++) {
			for (int j = 0; j < super.stringLength; j++) {
				if (wordList[i].charAt(j) == ch) {
					break;
				} else {
					if (j == super.stringLength - 1) {
						if (wordList[i].charAt(j) != ch) {
							temp[tempIndex] = wordList[i];
							tempIndex++;
						}
					}
				}
			}
		}
		return temp;
	}

	@Override
	public boolean makeGuess(char ch) {
		System.out.println("makeGuess: " + ch + "; numWords=" + numWords);
		guessResult = false;
		super.guess = ch;
		if (Character.isLetter(ch) && !super.alreadyGuessed(ch)) {

			int tempWordNum = adjustWordList(ch);
			String temp[] = generateNewWordList(tempWordNum, ch);
			
			if (tempWordNum == 0) {
				System.out.println("tempWordNum is zero!");
				super.secretWord = wordList[0];
				guessResult = true;
			} else {
				secretWord = temp[0];
				numWords = tempWordNum;
				wordList = temp;
				super.guessesRemaining--;
				guessResult = false;
			}
			if (!guessResult) {
				super.letterHistory = super.letterHistory + super.guess;
			}
		} else {
			return false;
		}
		
		return guessResult;
	}
}
