
/**
 * first verion for deck of cards
 *
 * @author (Madeline Holda)
 * @version (02/22/2018)
 */
import java.util.*;
public class DeckOfCards{
    private ArrayList<Card> deck = new ArrayList<Card>(52);
    
    public DeckOfCards(){
        for(int i=0; i<4; i++){
            for(int j=1; j<= 13; j++){
                deck.add(new Card(j, i));
            }
        }
    }
    
    public DeckOfCards(ArrayList start){
        deck.addAll(start);
    }
    
    public void shuffle(){
        deck = getCards(deck.size());
    }
    
    //returns randomly drawn cards as an ArrayList<Card>
    public ArrayList getCards(int num){
        Random gen = new Random();
        ArrayList draw = new ArrayList(num);
        for(int i=0; i<num; i++){
            draw.add(deck.remove(gen.nextInt(deck.size())));
        }
        return draw;
    }
    
    //returns one randomly drawn Card object
    public Card drawCard(){
        Random gen = new Random();
        Card draw = deck.remove(gen.nextInt(deck.size()));
        return draw;
    }
    
    //returns half of the deck as a DeckOfCards object
    public DeckOfCards splitDeck(){
        ArrayList<Card> half = new ArrayList(52);
        final int START_SIZE = deck.size();
        while(half.size()<deck.size()){
            half.add(deck.remove(26));
        }
        DeckOfCards newHalf = new DeckOfCards(half);
        return newHalf;
    }
    
    public void addCards(ArrayList LD){
        if(deck.size()+LD.size()<=52) deck.addAll(LD);
    }
    
    public void addCard(Card c){
        if(deck.size()<52) deck.add(c);
    }
    
    public int cardsLeft(){
        return deck.size();
    }
    
    public String toString(){
        String str = "";
        for(int i=0; i<deck.size(); i++){
            str += (deck.get(i)).toString();
            if(i != deck.size()-1){
                str += ", ";
            }
        }
        return str;
    }
}
