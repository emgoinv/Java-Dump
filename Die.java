
/**
 * represents one die with face showing values
 * values between 1 and number of faces
 *
 * @author (Madeline Holda)
 * @version (10//31/2017)
 */
import java.util.Random;
public class Die{
    private final int MIN_FACES = 4;
    private static Random generator = new Random();
    private int numFaces;
    private int faceValue;
    
    //defaults to six-sided die
    public Die(){
        numFaces = 6;
        faceValue = 1;
    }
    
    //sets the size of dice with given number of faces
    public Die(int faces){
        if(faces<MIN_FACES){
            numFaces = 6;
        }
        else{
            numFaces = faces;
        }
        faceValue = 1;
    }
    
    //rolls dice and returns result
    public int roll(){
        faceValue = generator.nextInt(numFaces)+1;
        return faceValue;
    }
    
    //returns current face value
    public int getFaceValue(){
        return faceValue;
    }
}
