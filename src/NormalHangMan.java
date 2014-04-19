import java.util.ArrayList;


public class NormalHangMan extends HangmanGame {
	
	public NormalHangMan (String secretWord, int numGuesses, ArrayList<Character> letterHistory) {
		super(secretWord, numGuesses, letterHistory);
		super.numLettersLeft = secretWord.length();
		for(int i = 0; i < secretWord.length(); i++)
        {
            super.state += "_ ";
            for(int j = i; j > 0; j--)
            {
                if(secretWord.charAt(i) == secretWord.charAt(j-1))
                {
                    this.numLettersLeft--;//If the letter appears many times in the secret word, it will be counted just once.
                    break;
                }
            }
        }
	}

	@Override
	public boolean isWin() {
		if (guessesRemaining == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean gameOver() {
		if (super.guessesRemaining == 0 || super.numLettersLeft == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean makeGuess(char ch) {
    	if (Character.isLetter(ch) == false) return false;
        super.guess = ch;
        boolean tempB = updateState(ch);
        if (!alreadyGuessed(ch)) {
            super.letterHistory.add((Character) super.guess);

            if (tempB) {
                super.numLettersLeft--;
            }
            else {
                super.guessesRemaining--;
            }
            return tempB;
        }
        else return false;
    }

	public boolean updateState(char ch) {
    	boolean tempB = false;
    	for (int i = 0; i < super.secretWord.length(); i++) {
    		if (super.secretWord.charAt(i) == ch) {
                String temp = "";
                for (int j = 0; j < super.secretWord.length(); j++)
                {
                    if (super.secretWord.charAt(j) == ch)
                    {
                        temp = temp + ch + " ";
                    }
                    else
                    {
                        temp = temp + super.state.charAt(2*j) + super.state.charAt(2*j+1);              
                    }
                }
                super.state = temp;
                tempB = true;
                break;
            }
    	}	
    	return tempB;
    }
}
