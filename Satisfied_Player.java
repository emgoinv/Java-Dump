
/**
 * Write a description of class Satisfied_Player here.
 *
 * @author (Madeline Holda)
 * @version (03/05/2018)
 */
import java.util.Scanner;
public class Satisfied_Player{
    public Card card;
    public String name;
    public int chips;
    public int tag = 0;
    public int oldCardNum;
    
    public Satisfied_Player(String n){
        name = n;
        chips = 3;
    }
    
    public void giveCard(Card c){
        card = c;
    }
    
    public Card getCard(){
        return card;
    }
    
    public void cardReveal(){
        Scanner sc = new Scanner(System.in);
        if(isHuman()){
            System.out.print(name+", press enter to reveal your card: ");
            String control = sc.nextLine();
            System.out.println(card);
            System.out.println("Press enter to clear the screen");
            control = sc.nextLine();
            System.out.print('\u000C');
        }
    }
    
    public void clearMemory(){
        if(!isHuman()) oldCardNum = 15;
    }
    
    public boolean isSatisfied(){
        Scanner sc = new Scanner(System.in);
        System.out.print(name+", are you satisfied? (y/n): ");
        String yn = sc.nextLine().toLowerCase();
        if(yn.equals("y")) return true;
        else return false;
    }
    
    public int getChips(){
        return chips;
    }
    
    public void looseChips(){
        chips--;
    }
    
    public boolean isHuman(){
        if (tag==0) return true;
        else return false;
    }
    
    public String toString_Card(){
        return name+": "+card;
    }
    
    public String toString(){
        return name;
    }
}
