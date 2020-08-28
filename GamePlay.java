import java.io.*;
import java.util.*;

/**
 * This class contains the main() driver it gets input from the user
 * a GamePlay object
 * 
 * @author Chidi Osakwe
 * @version 10/15/2018
 */
public class GamePlay
{

   public static void main(String[ ] args)throws IOException
   {  //Local variables 
       Scanner in = new Scanner(System.in);// Creates the scanner in object
       String Word= new String();//Creates the object for the string Word
       char guess;//Creates the refrence variable for the char guess
       GameWord myPhrase=new GameWord();//Creates the refrence variable for the object myPhrase
       int countOne=0;// intitializes variable int countOne
       char goAgain;//Creates the refrence variable for the goAgain char
       Scanner go= new Scanner(System.in);// Creates the scanner go object
       int type;//Creates the refrence variable for the int Type
       Scanner op= new Scanner(System.in);// Creates the scanner op object
       int catChoice;//Creates the refrence variable for the int catChoice
       Random line = new Random();// creates the object for the Random line
       int lineW;//Creates the refrence variable for the int LineW
       Scanner input = new Scanner(System.in);// Creates the scanner input object
       int losing=0;
       do{// Loops to know if the user would like to go again
           // Creates the options menu for the user to choose from.
       System.out.println("Type the correspoding number to the category you"+ 
       "\nwould like to choose from?"+
       "\n1: Famous People"+
       "\n2: Famous Movie Quotes "+
       "\n3: Historical Figures"+
       "\n4: Places Around the World "+
       "\n5: Cartoon Characters" );
       catChoice= op.nextInt();//Saves the users choice
       boolean [ ] used = new boolean[255];

       //This switch statement takes the users choice and then matchs it 
       //with the file. It then calls a random number and and searches the
       //file for the line and saves the line as Word. After it is saved as
       //Word it then takes Work ans put it into the setmethod of the Gameplay 
       //And begins the game.
           switch(catChoice)
           {
            case 1:
            //Creates a random number between 0 and 20
            lineW =(int)(line.nextInt((20-1)+1));
            //Sets input file
            input= new Scanner(new File("FamousPeople.txt"));
        
                    for(int i=0; i<lineW-1; i++)
                {
                    input.nextLine();
            }
            Word=input.nextLine();
                break; 
            case 2: 
            //Creates a random number between 0 and 20
            lineW =(int)(line.nextInt((20-1)+1));
             //Sets input file
            input= new Scanner(new File("FamousMovieQuotes.txt"));
        
                    for(int i=0; i<lineW-1; i++)
                {
                    input.nextLine();
            }
            Word=input.nextLine();
                break;      
            case 3: 
            //Creates a random number between 0 and 20
            lineW =(int)(line.nextInt((20-1)+1));
             //Sets input file
            input= new Scanner(new File("HistoricalFigures.txt"));
        
                    for(int i=0; i<lineW-1; i++)
                {
                    input.nextLine();
            }
            Word=input.nextLine();
            myPhrase= new GameWord(Word );
                break;       
            case 4: 
            //Creates a random number between 0 and 20
            lineW =(int)(line.nextInt((20-1)+1));
             //Sets input file
            input= new Scanner(new File("PlacesAroundTheWorld.txt"));
        
                    for(int i=0; i<lineW-1; i++)
                {
                    input.nextLine();
            }
            Word=input.nextLine();
                break;      
            case 5: 
            //Creates a random number between 0 and 20
            lineW =(int)(line.nextInt((20-1)+1));
             //Sets input file
            input= new Scanner(new File("CartoonCharacters.txt"));
        
                    for(int i=0; i<lineW-1; i++)
                {
                    input.nextLine();
            }
            Word=input.nextLine();
                break;      
       }
       // Calls the setMethod from gameWord and sets the phrase to the string 
       //Word
        myPhrase.setPhrase(Word);
       System.out.println("\n" + myPhrase.toString( ));//Prints toString
       //while loops checks to see if the game has been won or lost
       while(!myPhrase.checkWin( ) && ! myPhrase.getGameOver( ))
       {
         do{
           System.out.print("\nEnter your character: ");
           guess = in.nextLine( ).charAt(0);
           if(used[guess]) System.out.println("That letter already guessed.");
        }while (used[guess]);
         used[guess] = true; 
         myPhrase.find(guess);
         System.out.println("\n" + myPhrase.toString( ));//Prints toString
       }
       //If you have ran out of chances or if you have guessed the phrase the
       //if statement returns the printline.
       if(myPhrase.checkWin( ))
       {
         System.out.println("You got it!");
         countOne++;//Extra credit Incremints by one 
         losing=0;
       }
       // If the user was wrong it will tell them the correct answer.
       //And sets the countOne back to zero.
       else
       
       {
        System.out.println("The correct answer was "+ Word);
        countOne=0;
        losing++;
        }
        
       System.out.println("Game Over");  
       System.out.println("Game Over"); 
       System.out.println("Game Over"); 
       System.out.println("Game Over"); 
       if(countOne>0)
       {
       System.out.println("You are on a "+countOne+" game win streak!");
    }
    else{
        System.out.println("You are on a "+losing+" game losing streak.");
         }
       System.out.println("If you would like to play again Press y");
       goAgain =go.next().charAt(0);
        }while('y'==goAgain);
        System.out.println("Good-bye");//Prints the exit message
    }
    }

