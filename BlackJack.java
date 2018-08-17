
/**
 * lets the user play Black Jack
 *
 * @author (Madeline Holda)
 * @version (10/18/2017)
 */
import java.util.Scanner;
import java.util.Random;
public class BlackJack{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random gen = new Random();
        System.out.println("Welcome to Black Jack!");
        int money = 100;
        System.out.println("You have $"+money);
        System.out.println("Every time you play, it costs $5");
        System.out.println("If you win, you earn $50!");
        System.out.println("The game ends when you run out of money or decide to quit");
        System.out.print("Good luck! (Press enter to start)");
        String start = sc.nextLine();
        
        String cont, card1, card2, card3, card4, card5, another;
        int num1, num2, num3, num4, num5, total, numPlayers = 0;
        boolean a2, a3, a4, a5;
        do{
            System.out.println();
            money -= 5;
            num1 = drawCard();
            num2 = drawCard();
            card1 = cardName(num1);
            card2 = cardName(num2);
            num3 = 0;
            num4 = 0;
            num5 = 0;
            total = 0;
            a2 = false;
            a3 = false;
            a4 = false;
            a5 = false;
            
            numPlayers = gen.nextInt(5)+1;
            System.out.println("Number of other players: "+numPlayers);
            if(numPlayers>1){
                a2 = true;
            }
            if(numPlayers>2){
                a3 = true;
            }
            if(numPlayers>3){
                a4 = true;
            } 
            if(numPlayers>4){
                a5 = true;
            }
            System.out.println("You first two cards are: "+card1+", "+card2);
            BlackJackCPU p1 = new BlackJackCPU("player 1", true);
            BlackJackCPU p2 = new BlackJackCPU("player 2", a2);
            BlackJackCPU p3 = new BlackJackCPU("player 3", a3);
            BlackJackCPU p4 = new BlackJackCPU("player 4", a4);
            BlackJackCPU p5 = new BlackJackCPU("player 5", a5);
            
            System.out.print("Would you like another card? (Enter y/n): ");
            another = sc.nextLine();
            
            p1.thirdCard();
            p2.thirdCard();
            p3.thirdCard();
            p4.thirdCard();
            p5.thirdCard();
            
            if(another.equals("y")){
                num3 = drawCard();
                card3 = cardName(num3);
                System.out.println("You drew a "+card3);
                System.out.println("Would you like a fourth card? (Enter y/n): ");
                another = sc.nextLine();
                p1.fourthCard();
                p2.fourthCard();
                p3.fourthCard();
                p4.fourthCard();
                p5.fourthCard();
                if(another.equals("y")){
                    num4 = drawCard();
                    card4 = cardName(num4);
                    System.out.println("You drew a "+card4);
                    System.out.print("Would you like a fifth card?");
                    another = sc.nextLine();
                    p1.fifthCard();
                    p2.fifthCard();
                    p3.fifthCard();
                    p4.fifthCard();
                    p5.fifthCard();
                    if(another.equals("y")){
                        num5 = drawCard();
                        card5 = cardName(num3);
                        System.out.println("You drew a "+card5);
                        System.out.println("You may not draw any more cards");
                    }
                }
            }
            
            System.out.print("-->Press Enter to continue");
            start = sc.nextLine();
            total += valueToAdd(num1);
            total += valueToAdd(num2);
            total += valueToAdd(num3);
            total += valueToAdd(num4);
            total += valueToAdd(num5);
            System.out.println("Your total is "+total);
            System.out.println(p1.getName()+" has "+p1.getTotal()+" points");
            if(numPlayers>1){
                System.out.println(p2.getName()+" has "+p2.getTotal()+" points");
            }
            if(numPlayers>2){
                System.out.println(p3.getName()+" has "+p3.getTotal()+" points");
            }
            if(numPlayers>3){
                System.out.println(p4.getName()+" has "+p4.getTotal()+" points");
            } 
            if(numPlayers>4){
                System.out.println(p5.getName()+" has "+p5.getTotal()+" points");
            }
            
            System.out.print("-->Press Enter to continue");
            start = sc.nextLine();
            
            if((total>p1.getTotal()||p1.getTotal()>21)&&(total>p2.getTotal()||p2.getTotal()>21)&&(total>p3.getTotal()||p3.getTotal()>21)&&(total>p4.getTotal()||p4.getTotal()>21)&&(total>p5.getTotal()||p5.getTotal()>21)&&total<22){
                System.out.println("You won!");
                money +=50;
            } else{
                System.out.println("You lost");
            }
            System.out.println("You have $"+money);
            
            System.out.print("Would you like to play again? (Enter y/n): ");
            cont = sc.nextLine();
        } while(cont.equals("y")&&money>=5);
    }
    
    public static int drawCard(){
        Random gen = new Random();
        int num = gen.nextInt(13)+1;
        return(num);
    }
    
    public static String cardName(int num){
        String card = "";
        if(num==1){
            card = "ace";
        } else if(num<11){
            card += num;
        } else if (num==11){
            card = "jack";
        } else if(num==12){
            card = "queen";
        } else if(num==13){
            card = "king";
        }
        return(card);
    }
    
    public static int valueToAdd(int num){
        Scanner sc = new Scanner(System.in);
        int add = 0;
        if(num<=10&&num!=1){
            add = num;
        } else if(num==1){
            System.out.print("Do you want the ace to count as 1 or 11? ");
            add = sc.nextInt();
            while(add!=1&&add!=11){
                System.out.println("Excuse me, are you trying to cheat?!?");
                System.out.println("Please reenter you choice: ");
                add = sc.nextInt();
            }
        } else if (num>10){
            add = 10;
        }
        return(add);
    }
}
