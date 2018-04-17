
/**
 * Write a description of class Satisfied here.
 *
 * @author (Madeline Holda)
 * @version (03/05/2018)
 */
import java.util.Scanner;
import java.util.Random;
public class Satisfied{
    public static void main(String[] args){
        //openning text
        Scanner sc = new Scanner(System.in);
        Scanner scSTR = new Scanner(System.in);
        System.out.println("Welcome to Satisfied!");
        System.out.print("View directions? (y/n): ");
        if(sc.nextLine().toLowerCase().equals("y")) printDirections();
        System.out.print("How many human players? (1-10): ");
        int people = sc.nextInt();
        System.out.print("How many total players? (5-10): ");
        int total = sc.nextInt();
        int cpuNum = total - people;
        Satisfied_Game game = new Satisfied_Game(total);
        
        //adds people to the game
        String name = "";
        int personality;
        Random gen = new Random();
        for (int i=0; i<people; i++){
            System.out.print("Player "+(i+1)+", enter name: ");
            name = scSTR.nextLine();
            game.addPlayer(name);
        }
        for (int i=0; i<cpuNum; i++){
            personality = gen.nextInt(3)+2;
            switch(personality){
                case 2: name = "Safe Sam"; break;
                case 3: name = "Normal Nolan"; break;
                case 4: name = "Risky Rachel"; break;
            }
            name += "_"+(i+1);
            game.addAI(name, personality);
        }
        
        //plays game
        int roundNum = 0;
        while(!game.hasWinner()){
            roundNum++;
            System.out.println();
            game.playRound(roundNum);
            game.eliminatePlayers();
        }
        System.out.println("\n\n"+game.winner()+" wins the game!");
    }
    
    public static void printDirections(){
        String[] rules = {"Satisfied is a card game played with a standard deck and 5-10 players",
            "The game begins by dealing each player one card",
            "The goal of each round is to NOT have the LOWEST card",
            "Again, you don't need the highest card, you just can't be the lowest",
            "When it is your turn, you can either keep your card (satisfied), or trade it with the next player (not satisfied)",
            "Players start with three chips, and the player(s) with the lowest card(s) at the end loose a chip",
            "The last one standing wins!",
            "Also, Aces are the lowest card, and Kings are automatically revealed at the start of each round",
            "If you have a king, you are protected. No one can trade with you",
            "Have fun!"};
        System.out.println();
        try {
            Thread.sleep(1000);
            for(int i=0; i<rules.length; i++){
                System.out.println(rules[i]);
                Thread.sleep(3000);
            }
            Thread.sleep(1000);
        }catch (Exception e) {
                e.printStackTrace();
        }
        System.out.println();
    }
}
