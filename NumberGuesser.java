public class NumberGuesser {

  protected int low;
  protected int high;

  private int originalLow;
  private int originalHigh;

  public NumberGuesser(int low, int high) {
    this.originalHigh = high;
    this.high = high;

    this.originalLow = low;
    this.low = low;
  }

  public int getCurrentGuess() {
    return (low + high) / 2;
  }

  public void higher() throws NumberGuesserIllegalStateException {
    checkForCheating();
    low = getCurrentGuess() + 1;
  }

  public void lower() throws NumberGuesserIllegalStateException {
    checkForCheating();
    high = getCurrentGuess() - 1;
  }

  public void reset() {
    low = originalLow;
    high = originalHigh;
  }

  private void checkForCheating() throws NumberGuesserIllegalStateException {
    if (this.low >= this.high) {
      throw new NumberGuesserIllegalStateException("No guesses left");
    }
  }
}