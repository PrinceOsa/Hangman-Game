/**
 * A set of method that creats a constructor and loops to see if letters were
 * guessed correctly.
 * 
 * @author Chidi Osakwe 
 * @version 10/15/2018
 */
public class GameWord
{
   private String phrase;
   private StringBuilder inProgress;
   private int numberWrongGuesses;
   private StringBuilder state;
   private boolean gameOver;
   /**
    * The no-args constructor sets all the values of the fields to their 
    * initial values
    */
   public GameWord( )
  {
       //intializes all the parameters 
       inProgress = new StringBuilder( );//Sets Creates a String builder object
       phrase = new String( );//Creates the string object
       numberWrongGuesses = 0;
       state = new StringBuilder( );
       gameOver = false;
    }
    /**
     * This Constructor method updates the the users board are replaces the
     * spaces with letters if they guess the correct letter.
     * @param String phraseToGuess takes in the phrase the player will use to guess
     */
    public GameWord(String phraseToGuess)
    {
        phrase = new String(phraseToGuess);//Sets phrase to the phrase passed in
        state = new StringBuilder( );// Creates the state object
        inProgress = new StringBuilder( );// creates the inProgress object
        for(int k = 0; k < phrase.length( ); k++)
        {
            inProgress.append( "_ ");
        }
        numberWrongGuesses = 0; // Sets the number of wrong guesses to 0
        gameOver = false;// sets the gameOver boolean to false
  }
     /**
      * This is the setMethod that changes updates the users board and replaces
      * the spaces with letters if the letter is guessed correctly.
      * @param String phraseToGuess Takes in the string the user will use to guess
      */
    public void setPhrase(String phraseToGuess)
  {
        phrase = new String(phraseToGuess);//Sets phrase to the phrase passed in
        state = new StringBuilder( );//Creates the state object
        inProgress = new StringBuilder( );// creates the inProgress object
        for(int k = 0; k < phrase.length( ); k++)
        {
            inProgress.append( "_ ");
        }
        numberWrongGuesses = 0;// Sets the number of wrong guesses to 0
        state = new StringBuilder( );// Creates the state string builder object
        gameOver = false;// sets the gameOver boolean to false
    }
  /**
     * This method checks to see if the player has ran out of guess chances 
     * and checks if the user has either won or lost the game.
     */
    public boolean getGameOver( )
    {
        return gameOver;//return the game over boolean
    }
    /**
     * This method checks to see if the letter guessed by the user is correct
     * it then changes the letter in the String builder to the correct letter
     * It also updates the numberWrongGuesses field if the user guesses 
     * incorrectly.
     * @param char symbol takes the letter the user guesses 
     */
    public void find(char symbol)
    {
        int count = 0;// creates and initilizes the local variable count
        int pos = 0;// creates and initilizes the local variable pos
        pos = phrase.indexOf(symbol);
        //Checks the condition of pos and updates count
        while(pos != -1)
        { 
          count++;//Increments count
          inProgress.setCharAt(pos*2,symbol);
          pos = phrase.indexOf(symbol, pos + 1);;
        }
        //Checks if the count is equal to 0
        if(count == 0)
        {
            numberWrongGuesses++;//Increments numberWrongGuesses
            updateState( );
        }
  }
  /**
     * This method check to see if the user has won the game.
     */
   public boolean checkWin( )
   {
      boolean match = true;
      //write the loop that checks to see
      //if all the characters have been
      //guessed
      //
      if(numberWrongGuesses<7)//checks to see if wrong guesses is less than 7
      {
      for(int i=0; i<inProgress.length(); i++)
      { 
        if(inProgress.charAt(i)!= '_')//Checks if inProgress at the increment
        //is equal to the space holder
        {
        match = true;//sets match to true
        }
        else
        {
        match=false;//sets match to false
        break;
        }
      }

    }
    else
      {
        match=false;//sets match to false
        }
    return match;//returns match
        }

    /**
     * This method updates the state String builder 
     */
   private void updateState( )
   { 
         //If everytime the number of wrong guesses goes up
         //the case for the corresponding number is called and draws the 
         //hangman
       switch(numberWrongGuesses)
       {
           case 1: state.append("\n\t\t\t\t\t 0");
                   break;
           case 2: state.append( "\n\t\t\t\t       /");
                   break;
           case 3: state.append(" |");
                   break;
           case 4: state.append( " \\");
                   break;
           case 5: state.append("\n\t\t\t\t         |");
                   break;
           case 6: state.append("\n\t\t\t\t        /");
                   break;
           case 7: state.append(" \\\n\n\t\t\t\t      OH NO!!\n");
                   gameOver = true;
                   
        
      }
      
  }
  /**
   * This method return a toString that return the values for each field.
   */
  public String toString(  )
  {
      return new String("\n***************************************\n" 
            + inProgress + "\n" + state.toString( ));
  }
}