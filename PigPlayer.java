
/**
 * Write a description of class PigPlayer here.
 *
 * @author (Madeline Holda)
 * @version (11/06/2017)
 */
import java.util.Scanner;
public class PigPlayer{
    //The PigPlayer class represents one player of the game, either player1, player2, or the computer.  
    //Each player tracks his total points and the points accumulated this round.
    //The player's limit is the number of points he is willing to accumulate in one round before passing to the next player.
    //This is dynamic for player1 and player2
    public boolean IS_CPU;
    private int total;  //total points accumulated in game
    private int round; //points accumulated in current round
    private int limit; //pass tolerance
    private String name;

    private static PairOfDice dice = new PairOfDice();

    //Initializes the point accumulators to zero, and the round limit as specified
    public PigPlayer (int max, String str){
        total = 0;
        round = 0;
        limit = max;
        name = str;
        IS_CPU = true;
    }
    
    public PigPlayer (String str){
        total = 0;
        round = 0;
        limit = 0;
        name = str;
        IS_CPU = false;
    }

    //Rolls the Dice once and deals with the results.
    //Returns true if the player should roll again and false otherwise.
    //The player will not roll again if he busts or wins, or if his round limit is reached (computer)
    public boolean roll (int goal){
        Scanner sc = new Scanner(System.in);
        String userChoice = "";
        boolean rollAgain = true;
        dice.roll();
        int die1 = dice.getDie1();
        int die2 = dice.getDie2();
        int tempTotal = total;
        System.out.println(toString()+" rolled a "+die1+" and a "+die2);
        if (die1==1&&die2==1){
            rollAgain = false;
            round = 0;
            total = 0;
            System.out.println("Bust! "+toString()+" loses all points");
        } else if(die1==1||die2==1){
            rollAgain = false;
            round = 0;
            System.out.println(toString()+" rolled a 1. "+toString()+" didn't get any points this round.");
        } else{
            round += die1;
            round += die2;
            tempTotal += die1;
            tempTotal += die2;
            System.out.println(toString()+" has "+round+" so far the round");
            if(IS_CPU){
                if(round>=20){
                    rollAgain = false;
                }
                if(tempTotal>=goal){
                    rollAgain = false;
                }
            } else{
                System.out.print("Would you ("+toString()+") like to roll again? (y/n): ");
                userChoice = sc.nextLine();
                if(userChoice.equals("y")){
                    rollAgain = true;
                } else{
                    rollAgain = false;
                }
            }
        }

        if(!rollAgain){
            total += round;
            round = 0;
        }
        return rollAgain;
    }

     //returns the total number of points accumulated by this player
    public int getPoints(){
        return total;
    }
    
    public String toString(){
        return name;
    }
}