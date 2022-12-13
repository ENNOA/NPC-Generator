package NPCGen;

/**
 * Class to retrieve and print data to describe NPCs
 *
 * Jaison Eccleston
 * 2.0
 */
import java.io.*;
import java.util.*;
public class npc{
    public static void main(String[] args)throws NullPointerException, IOException{
        Scanner input= new Scanner(System.in);
        String sentinel;
        int npcs=0;
        int homeland;

        do{
            System.out.print("Generate how many NPCs? ");
            npcs=input.nextInt();
            System.out.println();
            menu();
            homeland=input.nextInt();
            System.out.println();
                for(int i=0;i<npcs;i++){    
                    System.out.println("New NPC Generation");
                    System.out.println("------------------");
                    //System.out.println();
                    
                    descGen who= new descGen();
                    namesAndOrigins where=new namesAndOrigins();
                    try {
                    where.randomize(homeland);
                    } catch(ArrayIndexOutOfBoundsException ex) {
                    	System.out.println(ex.getMessage());
                    }
                    System.out.println(where.toString());
                    try {
                    who.randomize(where.getRace());
                    }catch (NullPointerException ex) {
                    	System.out.println(ex.getMessage());
                    }
                    who.profession();
                    System.out.println(who.toString());
                    System.out.println("\n");
            }
            
            System.out.println("\n");
            System.out.print("Start over? Yes or No?: ");
            sentinel=input.next();
            
        } while(sentinel.equalsIgnoreCase("yes"));
        System.out.println("Thank you! Have a fun game!");
        input.close();
    }
    
    public static void menu() {
    	System.out.print("Choose a nation from which to generate NPCs:");
        System.out.print("\n 00 = Random               01 = Breland               02 = Zilargo               03 = Darguun");
        System.out.print("\n 04 = Valenar              05 = Q'barra               06 = The Talenta Plains    07 = Karrnath");
        System.out.print("\n 08 = The Mror Holds       09 = Thrane                10 = Aundair               11 = The Eldeen Reaches");
        System.out.print("\n 12 = The Demon Wastes     13 = The Shadow Marches    14 = Droaam                15 = The Lhazaar Principalities \n");
        System.out.print("\n Enter nation number here: ");
    	
    }
}