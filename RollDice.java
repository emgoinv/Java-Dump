
/**
 * Write a description of class RollDice here.
 *
 * @author (Madeline Holda)
 * @version (10/31/2017)
 */
import java.util.Scanner;
public class RollDice{
    private static Die d = new Die(getChoice());
    public static void main(String[] args){
        run();
    }
    
    /**
     * gets the number of sides and returns it
     */
    private static int getChoice(){
        Scanner sc = new Scanner(System.in);
        System.out.print("How many side would you like on the die?: ");
        int sides = sc.nextInt();
        while(sides<4){
            System.out.print("Too few sides. Please reenter your choice: ");
            sides = sc.nextInt();
        }
        return sides;
    }
    
    /**
     * makes a roll and displays the result
     */
    private static void rollAndDisplay(){
        int face = d.roll();
        System.out.println(face);
    }
    
    /**
     * allows ths user to roll a die with the number of sides they specify
     */
    public static void run(){
        System.out.print("You rolled: ");
        rollAndDisplay();
    }
}
