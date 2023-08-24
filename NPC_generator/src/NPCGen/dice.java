package NPCGen;

/**
 * dice objects.
 *
 * Jaison Eccleston
 * 14APR2022
 */
import java.util.Random;
public class dice{
    Random gen= new Random();
    // instance variables
    static int faces=0;
    int sum;
    
    // construct dice
    dice(){
    }
    
    @SuppressWarnings("static-access")
	dice(int newFaces){
        this.faces=newFaces;
    }
    
    // return result of dice roll
   public static int getDiceRoll(int rolls){
        int sum=0;
        Random gen=new Random();
        for(int i=0; i<rolls; i++)
            sum+=(1+gen.nextInt(1+faces));
        return sum;
    }
    public static int getDiceRoll(int sides,int rolls){
        int sum=0;
        int faces=sides;
        Random gen=new Random();
        for(int i=0; i<rolls; i++)
            sum+=(1+gen.nextInt(1+faces));
        return sum;
    }

	
}