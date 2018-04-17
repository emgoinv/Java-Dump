
/**
 * Write a description of class Satisfied_AI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Satisfied_AI extends Satisfied_Player{
    //2=safe, 3=normal, 4=risky
    private int threshold;
    
    public Satisfied_AI(String n, int personality){
        super (n);
        threshold = personality;
        tag = 1;
        card = new Card(15, 0);
    }
    
    private void increaseThresh(){
        threshold++;
    }
    
    public void giveCard(Card c){
        oldCardNum = card.getNum();
        super.giveCard(c);
    }
    
    public boolean isSatisfied(){
        System.out.print(name);
        if (oldCardNum<card.getNum()||card.getNum()>threshold){
            System.out.println(" is satisfied");
            return true;
        } else{
            System.out.println(" is not satisfied");
            return false;
        }
    }
}
