
/**
 * Write a description of class BlackJackCPU here.
 *
 * @author (Madeline Holda)
 * @version (10/23/2017)
 */
import java.util.Random;
public class BlackJackCPU{
    private int num1, num2, num3=0, num4=0, num5=0, total=0;
    private String card1, card2, card3, card4, card5;
    private String name;
    private boolean active;
    
    /** constructor
     * draws first two cards
     */
    public BlackJackCPU(String n, boolean a){
        name = n;
        active = a;
        num1 = drawCard();
        num2 = drawCard();
        card1 = cardName(num1);
        if(active){
            System.out.println("The first card "+name+" drew was a "+card1);
        }
        card2 = cardName(num2);
        findTotal();
    }
    
    public void findTotal(){
        total = 0;
        total += numberToAdd(num1);
        total += numberToAdd(num2);
        total += numberToAdd(num3);
        total += numberToAdd(num4);
        total += numberToAdd(num5);
    }
    
    public int getTotal(){
        if(!active){
            total = 0;
        }
        return(total);
    }
    
    public String getName(){
        return(name);
    }
    
    public void thirdCard(){
        if(total<16){
            num3 = drawCard();
            card3 = cardName(num3);
            if(active){
                System.out.println(name+" drew a "+card3);
            }
        } else if(active){
            System.out.println(name+" did not draw a third card");
        }
        findTotal();
    }
    
    public void fourthCard(){
        if(total<16){
            num4 = drawCard();
            card4 = cardName(num4);
            if(active){
                System.out.println(name+" drew a "+card4);
            }
        } else if(active){
            System.out.println(name+" did not draw a fourth card");
        }
        findTotal();
    }
    
    public void fifthCard(){
        if(total<16){
            num5 = drawCard();
            card5 = cardName(num5);
            if(active){
                System.out.println(name+" drew a "+card5);
            }
        } else if(active){
            System.out.println(name+" did not draw a fifth card");
        }
        findTotal();
    }
    
    private int numberToAdd(int num){
        int add = 0;
        if(num<=10&&num!=1){
            add = num;
        } else if (num>10){
            add = 10;
        } else if (num==1){
            if(total>8){
                add = 11;
            } else{
                add = 1;
            }
        }
        return(add);
    }
    
    public int drawCard(){
        Random gen = new Random();
        int num = gen.nextInt(13)+1;
        return(num);
    }
    
    public String cardName(int num){
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
    
}
