
/**
 * contains a player object for ALL players
 *
 * @author (Madeline Holda, Shane Fisher)
 * @version (01/30/2018)
 */
import java.lang.Math;
import java.util.Scanner;
public class Player{
    //player type: human = 0, stupid computer = 1, AI = 2
    private int type;
    private String name;
    //marker type: Xs = 1, Os = 2
    private int marker;
    private TTT_Board game;
    private int wins, loses, ties;
    
    public Player(int t, String str, int XorO, TTT_Board g){
        type = t;
        name = str;
        marker = XorO;
        game = g;
        wins = 0;
        loses = 0;
        ties = 0;
    }
    
    //lets player choose character
    public void pickMarker(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n(1) X/O (default) \n(2) ☺ \n(3) ☻ \n(4) ♥ \n(5) ♫ \n(6) ▒ \n(7) § \n(8) ☼");
        System.out.print(toString()+", choose your character: ");
        int pick = sc.nextInt();
        game.setMarker(marker, pick);
    }
    
    //get move from player and edits board
    public void makeMove(){
        Scanner Sc = new Scanner(System.in);
        int row = 0;
        int column = 0;
        do{
            if (type == 0){
                System.out.print(name+", enter a row: ");
                row = Sc.nextInt();
                System.out.print(name+", enter a column: ");
                column = Sc.nextInt();
            } else if (type == 1) {
                row = (int) (Math.random() * 3);
                column = (int)(Math.random() * 3);
            } else if(type == 2){
                game.getPlace();
                row = game.getRow();
                column = game.getCol();
            }
            if(!game.isOpen(row, column)&&type==0){
                System.out.println("Invalid. Try again");
            }
        } while(!game.isOpen(row, column));
        game.doTurn(row, column, marker);
        if(type!=0){
            System.out.println(toString()+" placed an O at row "+row+", column "+column);
        }
    }
    
    //keeps track of wins/loses/ties
    public void changeScore(int w, int l, int t){
        wins += w;
        loses += l;
        ties += t;
    }
    
    //returns current score
    public String toStringWLT(){
        return(toString()+": "+wins+" wins, "+loses+" losses, and "+ties+" ties");
    }
    
    //returns number of wins
    public int getWins(){
        return wins;
    }
    
    //returns player name
    public String toString(){
        return name;
    }
}
