
/**
 * contains data for a single card
 *
 * @author (Madeline Holda)
 * @version (02/22/2018)
 */
public class Card{
    private int number, suit;
    
    /** 0=♥, 1=♦, 2=♣, 3=♠
     * A-10 = 1-10; J = 11; Q = 12; K = 13
     */
    public Card(int num, int s){
        number = num;
        suit = s;
    }
    
    public int getNum(){
        return number;
    }
    
    public String toString(){
        String str = "";
        if(number<11 && number>1){
            str += number;
        } else{
            switch(number){
                case 1: str += "A"; break;
                case 11: str += "J"; break;
                case 12: str += "Q"; break;
                case 13: str += "K"; break;
            }
        }
        switch(suit){
            case 0: str += "♥"; break;
            case 1: str += "♦"; break;
            case 2: str += "♣"; break;
            case 3: str += "♠"; break;
        }
        return str;
    }
}
