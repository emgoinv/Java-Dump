
/**
 * Write a description of class Pig here.
 *
 * @author (Madeline Holda)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Pig{
    private int goal;
    private PairOfDice dice;
    private PigPlayer computer, player1, player2, currentPlayer;

    //Your constructor, sets up the game
    public Pig (int target){
        goal = target;
        computer = new PigPlayer(20, "Computer");
        player1 = new PigPlayer("Player1");
        player2 = new PigPlayer("Player2");
    }

    //This method contains the primary game loop, which terminates only once a player has won the game
    public void play (){
        Scanner sc = new Scanner(System.in);
        boolean noWinnerYet= true;
        int whoseTurn = 3;
        String blank;
        showStatus();
        System.out.println();
        do{
            if(whoseTurn%3==0){
                currentPlayer = computer;
            }else if(whoseTurn%3-1==0){
                currentPlayer = player1;
            }else{
                currentPlayer = player2;
            }
            takeTurn();
            if(currentPlayer.getPoints()>=goal){
                noWinnerYet = false;
            }
            System.out.println("\n-->Press Enter to continue");
            blank = sc.nextLine();
            whoseTurn++;
        } while (noWinnerYet) ;
        showStatus();
        announceWinner();
    }

    //Plays one player's complete turn, allowing the player to roll the dice multiple times
    private void takeTurn(){
        boolean stillRolling = true;
        while(stillRolling){
             stillRolling = currentPlayer.roll(goal);
        }
        System.out.println(currentPlayer+" has "+currentPlayer.getPoints()+" points total");
        showStatus();
    }

    public void showStatus(){
        System.out.println("\n"+computer+": "+computer.getPoints()+" points");
        System.out.println(player1.toString()+": "+player1.getPoints()+" points");
        System.out.println(player2.toString()+": "+player2.getPoints()+" points");
    }
    
    //Announces the winner and prints the results
    private void announceWinner(){
        if(computer.getPoints()>=100){
            System.out.println("\n"+computer+" wins");
        } else if(player1.getPoints()>=100){
            System.out.println("\n"+player1+" wins");
        } else if(player2.getPoints()>=100){
            System.out.println("\n"+player2+" wins");
        }
    }
}