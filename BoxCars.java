
/**
 * demonstrates the use of a class with overloaded constructors
 *
 * @author (Madeline Holda)
 * @version (10/31/2017)
 */
public class BoxCars{
    //creates two dices, rolls them, counts number of box cars
    public static void main(String[] args){
        final int ROLLS = 500;
        int boxCars = 0;
        PairOfDice pod = new PairOfDice();
        for(int roll=1; roll<= ROLLS; roll++){
            pod.roll();
            if(pod.getDie1()==6&&pod.getDie2()==6){
                boxCars++;
            }
        }
        System.out.println("Number of rolls: "+ROLLS);
        System.out.println("Number of boxCars: "+boxCars);
        System.out.println("Ratio: "+(double)boxCars/ROLLS);
    }
}
