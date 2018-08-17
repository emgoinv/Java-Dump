
/**
 * lets ths user play slots tha are not rigged
 *
 * @author (Madeline Holda)
 * @version (10/18/2017)
 */
import java.util.Scanner;
import java.util.Random;
public class SlotMachine{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random gen = new Random();
        System.out.println("Welcome to the slot machine!");
        System.out.println("You start off with $500");
        int money = 500;
        System.out.println("Every time you play costs $10");
        System.out.println("You may quit at any time,");
        System.out.println("or when you run out of money");
        System.out.println("Good luck!\n");
        System.out.print("Enter \"yes\" to start: ");
        String cont = sc.nextLine();
        int num1, num2, num3;
        
        while(cont.equals("yes")&&money>9){
            money -= 10;
            num1 = gen.nextInt(10)+1;
            num2 = gen.nextInt(10)+1;
            num3 = gen.nextInt(10)+1;
            if(num1==10){
                System.out.print("J ");
            } else{
                System.out.print(num1+" ");
            }
            if(num2==10){
                System.out.print("J ");
            } else{
                System.out.print(num2+" ");
            }
            if(num3==10){
                System.out.print("J ");
            } else{
                System.out.print(num3+" ");
            }
            
            if(num1==10&&num2==10&&num3==10){
                System.out.println("Jackpot! You win $1000");
                money += 500;
            } else if(num1==7&&num2==7&&num3==7){
                System.out.println("Luck 7's! You win $200");
                money += 200;
            } else if(num1==num2&&num2==num3){
                System.out.println("Three of a kind! You win $50");
                money += 50;
            } else if(num1==num2||num1==num3||num2==num3){
                System.out.println("Two ofa kind. You win $10");
                money += 10;
            }
            
            System.out.println("You have $"+money+" left");
            System.out.println("Would you like to play again? (yes to continue): ");
            cont = sc.nextLine();
            System.out.println();
        }
        if(money<10){
            System.out.println("Sorry, not enough money to play");
        }
    }
}
