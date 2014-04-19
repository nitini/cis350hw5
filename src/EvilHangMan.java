import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class EvilHangMan extends HangmanGame {
	private ArrayList<String> wordList = new ArrayList<String>();
	private boolean guessResult;
	private String finalWord;
	
	public EvilHangMan (int stringLength, int numGuesses) {
		super(stringLength, numGuesses);
		super.numLettersLeft = 26;
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("dictionary.txt"));// read the dictionary
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		while (scanner.hasNext()) {
			String temp = scanner.nextLine().toUpperCase();
			if (temp.length() == super.stringLength) {
				wordList.add(temp);
			}
		}
		
		for (int i = 0; i < super.stringLength; i++) {
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
	
	public String editWordList(char ch) {
		String finalWord = wordList.get(0);
		Iterator<String> wordIter = wordList.iterator();
		while (wordIter.hasNext()) {
			String word = wordIter.next();
			for (int i = 0; i < super.stringLength; i++) {
				if (word.charAt(i) == ch) {
					wordIter.remove();
					break;
				}
			}
		}
		return finalWord;
	}

	@Override
	public boolean makeGuess(char ch) {
		System.out.println("makeGuess: " + ch + "; numWords=" + wordList.size());
		guessResult = false;
		super.guess = ch;
		if (Character.isLetter(ch) && !super.alreadyGuessed(ch)) {
			if (wordList.size() != 0) {
				finalWord = editWordList(ch);
			}
			if (wordList.size() == 0) {
				System.out.println("tempWordNum is zero!");
				super.secretWord = finalWord;
				guessResult = true;
			} else {
				super.secretWord = wordList.get(0);
				super.guessesRemaining--;
				guessResult = false;
			}
			if (!guessResult) {
				super.letterHistory.add((Character) super.guess);
			}
		} else {
			return false;
		}
		
		return guessResult;
	}
}
