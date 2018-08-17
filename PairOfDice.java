
/**
 * Write a description of class PairOfDice here.
 *
 * @author (Madeline Holda)
 * @version (10/31/2017)
 */
public class PairOfDice{
    private Die die1, die2;
    int face1, face2;
    
    /**
     * constructor for the class PairOfDice()
     */
    public PairOfDice(){
        die1 = new Die();
        die2 = new Die();
        face1 = die1.getFaceValue();
        face2 = die2.getFaceValue();
    }
    
    /**
     * rolls both dice
     */
    public void roll(){
        face1 = die1.roll();
        face2 = die2.roll();
    }
    
    /**
     * returns the combined value of the faces
     */
    public int getTotal(){
        return (face1+face2);
    }
    
    /**
     * returns the value of die1
     */
    public int getDie1(){
        return face1;
    }
    
    /**
     * returns the value of die2
     */
    public int getDie2(){
        return face2;
    }
}