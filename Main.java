import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class Main extends JFrame implements ActionListener {

  private JTextField guessField;
  private JButton lowerButton;
  private JButton higherButton;
  private JButton correctButton;
  private JButton resetButton;

  private NumberGuesser guesser;
  
  public Main() {
    // Used to specify GUI component layout
    GridBagConstraints positionConst = null;

    // Set frame's title
    setTitle("Number Guesser");

    // Create the Number Guesser
    this.guesser = new RandomNumberGuesser(1, 100);

    // Create the display for the guess
    JLabel guessLabel = new JLabel("Current Guess: ");

    this.guessField = new JTextField(15);
    this.guessField.setText("" + this.guesser.getCurrentGuess());
    this.guessField.setEditable(false);

    // Create the four button objects
    this.lowerButton = new JButton("Lower");
    this.higherButton = new JButton("Higher");
    this.correctButton = new JButton("Correct");
    this.resetButton = new JButton("Reset");

    // Use "this" class to handle button presses
    this.lowerButton.addActionListener(this);
    this.higherButton.addActionListener(this);
    this.correctButton.addActionListener(this);
    this.resetButton.addActionListener(this);

    // Use a GridBagLayout
    setLayout(new GridBagLayout());
    positionConst = new GridBagConstraints();

    // 10 pixels vert, 5 horizontal around components
    positionConst.insets = new Insets(10, 5, 10, 5);

    // Add component using the specified constraints
    positionConst.gridx = 0;
    positionConst.gridy = 0;
    add(guessLabel, positionConst);

    positionConst.gridx = 1;
    positionConst.gridy = 0;
    add(this.guessField, positionConst);

    positionConst.gridx = 2;
    positionConst.gridy = 0;
    add(this.resetButton, positionConst);

    positionConst.gridx = 0;
    positionConst.gridy = 2;
    add(this.lowerButton, positionConst);

    positionConst.gridx = 1;
    positionConst.gridy = 2;
    add(this.higherButton, positionConst);

    positionConst.gridx = 2;
    positionConst.gridy = 2;
    add(this.correctButton, positionConst);
  }

  /*
   * Method is automatically called when a button is pressed
   * 
   * It needs some work. The logic here doesn't play a guessing game. It just
   * provides some examples that you can use.
   *
   * inside the action performed method you have access to this class's 
   * member fields. So you can access each of these:
   *  - this.lowerButton
   *  - this.higherButton
   *  - this.resetButton
   *  - this.cancelButton
   *  - this.numberGuesser
   */
  @Override
  public void actionPerformed(ActionEvent event) {
      Object buttonPressed = event.getSource();

      // Check if the "lower" button is pressed
      if (buttonPressed == this.lowerButton) {
          try {
              // Invoke lower() and update the guessField
              this.guesser.lower();
              this.guessField.setText("" + this.guesser.getCurrentGuess());
          } catch (NumberGuesserIllegalStateException e) {
              // Show a JOptionPane if cheating is detected
              JOptionPane.showMessageDialog(
                  null,
                  "Cheating! You're onto their schemes.",
                  "Notice",
                  JOptionPane.INFORMATION_MESSAGE
              );
          }
      }

      // Check if the "higher" button is pressed
      if (buttonPressed == this.higherButton) {
          try {
              // Invoke higher() and update the guessField
              this.guesser.higher();
              this.guessField.setText("" + this.guesser.getCurrentGuess());
          } catch (NumberGuesserIllegalStateException e) {
              // Show a JOptionPane if cheating is detected
              JOptionPane.showMessageDialog(
                  null,
                  "Cheating! You're onto their schemes.",
                  "Notice",
                  JOptionPane.INFORMATION_MESSAGE
              );
          }
      }

      // Check if the "reset" button is pressed
      if (buttonPressed == this.resetButton) {
          // Invoke reset() and update the guessField
          this.guesser.reset();
          this.guessField.setText("" + this.guesser.getCurrentGuess());
      }

      // Check if the "correct" button is pressed
      if (buttonPressed == this.correctButton) {
          // Exit the app
          System.exit(0);
      }
  }

  public static void main(String[] args) {
    Main myFrame = new Main();

    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.pack();
    myFrame.setVisible(true);
  }
}