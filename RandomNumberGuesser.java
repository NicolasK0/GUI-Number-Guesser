import java.util.Random;

public class RandomNumberGuesser extends NumberGuesser {
	private int currentGuess;
	private Random random;

	public RandomNumberGuesser(int low, int high) {
		super(low, high);
		this.currentGuess = low - 1;
		this.random = new Random();
	}

	@Override
	public int getCurrentGuess() {

		// If the current guess is outside of the valid range, 
    // calculate a new one that is inside the range. 
    // The current number is outside of the range after
		// higher() or lower() has been invoked
		if (this.currentGuess < low || this.currentGuess > high) {
			this.currentGuess = generateValidRandomGuess();
		}

		return currentGuess;
	}

	private int generateValidRandomGuess() {
		return low + this.random.nextInt(1 + (high - low));
	}

  public void reset() {
    super.reset();
    this.currentGuess = low - 1;
  }
}