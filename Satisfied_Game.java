
/**
 * Write a description of class Satisfied_Game here.
 *
 * @author (Madeline Holda)
 * @version (03/05/2018)
 */
import java.util.*;
public class Satisfied_Game{
    private ArrayList<Satisfied_Player> group;
    private DeckOfCards deck;
    
    public Satisfied_Game(int num){
        group = new ArrayList<Satisfied_Player>(num);
        deck = new DeckOfCards();
        deck.shuffle();
    }
    
    public void addPlayer(String n){
        group.add(new Satisfied_Player(n));
    }
    
    public void addAI(String n, int p){
        group.add(new Satisfied_AI(n, p));
    }
    
    public void playRound(int roundNum){
        dealCards();
        if(roundNum%5 == 0) deck.shuffle();
        System.out.println("CARD REVEAL.\nREMEMBER YOUR CARD.\nDO NOT SHOW OTHER PLAYERS YOUR CARD.");
        for(int i=0; i<group.size(); i++){
            group.get(i).cardReveal();
        }
        for(int i=0; i<group.size(); i++){
            if(group.get(i).getCard().getNum() == 13){
                System.out.println(group.get(i)+" has a King! ("+group.get(i).getCard()+")");
            }
        }
        System.out.println();
        boolean hasTraded = false;
        int j;
        for(int i=0; i<group.size(); i++){
            if(!(group.get(i)).isSatisfied()){
                j = i+1;
                do{
                    hasTraded = tradeCards(i, j);
                    j++;
                } while(!hasTraded);
            }
        }
        showCards();
        roundLoser();
        returnCards();
        changePositions();
    }
    
    public void dealCards(){
        for(int i=0; i<group.size(); i++){
            (group.get(i)).giveCard(deck.drawCard());
            group.get(i).clearMemory();
        }
    }
    
    //returns true if cards have been successfully traded
    public boolean tradeCards(int i, int j){
        if(j<group.size()){
            if(group.get(j).getCard().getNum() == 13){
                System.out.println(group.get(j)+" has a King! ("+group.get(j).getCard()+")");
                return false;
            } else{
                System.out.println(group.get(i)+" traded cards with "+group.get(j));
                Card temp = group.get(i).getCard();
                (group.get(i)).giveCard(group.get(j).getCard());
                (group.get(j)).giveCard(temp);
                group.get(i).cardReveal();
                group.get(j).cardReveal();
                return true;
            }
        } else{
            System.out.println(group.get(i)+" has a "+(group.get(i)).getCard());
            deck.addCard(group.get(i).getCard());
            (group.get(i)).giveCard(deck.drawCard());
            System.out.println(group.get(i)+" drew a "+(group.get(i)).getCard()+" from the deck");
            return true;
        }
    }
    
    public void changePositions(){
        group.add(group.size()-1, group.remove(0));
    }
    
    public void roundLoser(){
        ArrayList<Satisfied_Player> losers = new ArrayList<Satisfied_Player>();
        int lowestNum = 15;
        for(int i=0; i<group.size(); i++){
            if(group.get(i).getCard().getNum() < lowestNum){
                lowestNum = group.get(i).getCard().getNum();
            }
        }
        for(int i=0; i<group.size(); i++){
            if(group.get(i).getCard().getNum() == lowestNum){
                losers.add(group.get(i));
            }
        }
        System.out.println("\n"+losers.size()+" player(s) had the lowest number");
        for(int i=0; i<losers.size(); i++){
            losers.get(i).looseChips();
            System.out.println(losers.get(i)+" put in a chip. "+losers.get(i)+" has "+losers.get(i).getChips()+" chip(s) left");
        }
    }
    
    public void returnCards(){
        ArrayList<Card> discard = new ArrayList<Card>(group.size());
        for(int i=0; i<group.size(); i++){
            discard.add(group.get(i).getCard());
        }
        deck.addCards(discard);
    }
    
    public void showCards(){
        System.out.println();
        for(int i=0; i<group.size(); i++){
            System.out.println(group.get(i).toString_Card());
        }
    }
    
    public void eliminatePlayers(){
        for(int i=0; i<group.size(); i++){
            if(group.get(i).getChips() == 0){
                System.out.println(group.get(i)+" is out!");
                group.remove(i);
            }
        }
    }
        
    public boolean hasWinner(){
        if(group.size()==1) return true;
        else return false;
    }
    
    public String winner(){
        return group.get(0)+"";
    }
}
