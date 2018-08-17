
/**
 * plays roc paper scissors
 * 
 * @author (Madeline Holda)
 * @version (10/17/2017)
 */
import java.util.Scanner;
import java.util.Random;
public class RPS{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random gen = new Random();
        String player = "", cpu = "";
        int wins = 0, loses = 0, ties = 0;
        int num;
        do{
            do{
                System.out.print("Enter rock, paper, or scissors: ");
                player = sc.nextLine();
            } while(!player.equals("rock")&&!player.equals("scissors")&&!player.equals("paper")&&!player.equals(""));
            num = gen.nextInt(2);
            if (num==0){
                cpu = "rock";
            } else if (num==1){
                cpu = "paper";
            } else if (num==2){
                cpu = "scissors";
            }
            System.out.println("The computer picked "+cpu);
            if(player.equals(cpu)){
                System.out.println("Tie.");
                ties++;
            } else if(player.equals("rock")){
                if(cpu.equals("paper")){
                    System.out.println("You lose");
                    loses++;
                } else if(cpu.equals("scissors")){
                    System.out.println("You win!");
                    wins++;
                }
            } else if(player.equals("paper")){
                if(cpu.equals("rock")){
                    System.out.println("You win!");
                    loses++;
                } else if(cpu.equals("scissors")){
                    System.out.println("You lose");
                    loses++;
                }
            } else if(player.equals("scissors")){
                if(cpu.equals("rock")){
                    System.out.println("You lose");
                    loses++;
                } else if(cpu.equals("paper")){
                    System.out.println("You win!");
                    wins++;
                }
            }
            System.out.println();
        } while (!player.equals(""));
        System.out.println("Wins: "+wins);
        System.out.println("Loses: "+loses);
        System.out.println("Ties: "+ties);
    }
}
