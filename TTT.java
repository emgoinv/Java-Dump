
/**
 * main method for TTT game
 *
 * @author (Madeline Holda, Shane Fisher)
 * @version (01/29/2018)
 */
import java.util.Scanner;
public class TTT{
    public static void main(String[] args){
        TTT_Board game = new TTT_Board();
        Scanner sc = new Scanner(System.in);
        //opening text
        System.out.println("Welcome to tic-tac-toe!");
        System.out.print("Please enter your name: ");
        String name = sc.nextLine();
        Player p1 = new Player(0, name, 1, game);
        Player p2;
        p1.pickMarker();
        System.out.println("\nWelcome "+p1+"! You will be the "+game.getMarker1()+"s");
        //choose mode and create coresponding player2 object
        System.out.println("(1) Player vs Player2\n(2) Player vs Computer (easy)\n(3) Player vs Computer (difficult)");
        System.out.print("Please select your game mode: ");
        int mode = sc.nextInt();
        if(mode==1){
            System.out.print("Player 2, please enter your name: ");
            name = sc.next();
            p2 = new Player(0, name, 2, game);
            p2.pickMarker();
            System.out.println("Welcome "+p2+"! You will be the "+game.getMarker2()+"s");
        } else if(mode==3){
            p2 = new Player(2, "cpu", 2, game);
        } else {
            p2 = new Player(1, "cpu", 2, game);
        }
        //plays game
        boolean play = true;
        int whoseTurn;
        int numOfTurns;
        String again;
        sc = new Scanner(System.in);
        System.out.println("\nRows and columns are numbered 0-2");
        while(play){
            System.out.println();
            numOfTurns = 0;
            whoseTurn = (int)(2*Math.random()+1);
            switch(whoseTurn){
                case 1: System.out.println(p1+" will go first"); break;
                case 2: System.out.println(p2+" will go first"); break;
            }
            game.clearBoard();
            while(!game.hasWon()&&numOfTurns<9){
                whoseTurn++;
                System.out.println("\n"+game);
                if(whoseTurn%2 == 0){
                    p1.makeMove();
                } else{
                    p2.makeMove();
                }
                numOfTurns++;
            }
            System.out.println(game);
            if(numOfTurns>=9){
                System.out.println("Cat's game: it's a tie!");
                p1.changeScore(0, 0, 1);
                p2.changeScore(0, 0, 1);
            } else if(whoseTurn%2 == 0){
                System.out.println(p1+" won!");
                p1.changeScore(1, 0, 0);
                p2.changeScore(0, 1, 0);
            } else{
                System.out.println(p2+" won!");
                p2.changeScore(1, 0, 0);
                p1.changeScore(0, 1, 0);
            }
            System.out.println(p1.toStringWLT()+"\n"+p2.toStringWLT());
            System.out.print("\nWould you like to play again?(y/n): ");
            again = sc.nextLine();
            if(!again.equals("y")){
                play = false;
            }
        }
        System.out.println();
        if(p1.getWins()>p2.getWins()){
            System.out.println(p1+" is the overall winner!");
        } else if(p2.getWins()>p1.getWins()){
            System.out.println(p2+" is the overall winner!");
        } else{
            System.out.println(p1+" and "+p2+" tied overall!");
        }
    }
}