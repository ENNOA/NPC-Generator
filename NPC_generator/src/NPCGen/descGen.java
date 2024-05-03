package NPCGen;

/*
 * Class to generare physical stats like age, weight, height, etc.
 */

import java.util.*;
import java.io.*;
public class descGen{
    int race=0;
    int height=0;
    int weight=0;
    int age=0;
    String hair;
    String eyes;
    String job;
    
    //randoms and dice
    Random gen= new Random();
    dice roll=new dice();

    //physical description
    String[] hairColor={"Blonde","Brown", "Red","Black", "Auburn", "Chestnut", "Gray"};
    String[] hairstyle={"Cropped","tied back","buzz cut","Long dutch braid","Long and unkempt"," Short and unkempt", "bald", "Short mohawk", "Long mohawk", "Long intricate braids", "Short curly", "Long curly", "medium curly",
                        "Long and wavy", "Short and Wavy", "bowl cut", };
    String[] eyeColor={"Dark Brown","Light Brown", "bright Blue","deep blue"," dark green","light green", "Dark hazel", "Hazel", "light amber", "Gray"};

    public void randomize(NPC_Object npc, String specie) throws IOException{
        if (specie.equalsIgnoreCase("Dragonborn")){
            age=(gen.nextInt(15,81));
            height= (roll.getDiceRoll(8,2)+66);
            weight= ((height-66)*roll.getDiceRoll(6,2))+175;
            eyes= eyeColor[(gen.nextInt(eyeColor.length))];
            hair= hairColor[(gen.nextInt(hairColor.length))]+" "+hairstyle[(gen.nextInt(hairstyle.length))];
        }
        
        else if (specie.equalsIgnoreCase("Dwarf")){
            age= (gen.nextInt(50,350));
            height= (roll.getDiceRoll(4, 2)+48);
            weight= (height-48)*roll.getDiceRoll(6,2)+130;
            eyes= eyeColor[(gen.nextInt(eyeColor.length))];
            hair= hairColor[(gen.nextInt(hairColor.length))]+" "+hairstyle[(gen.nextInt(hairstyle.length))];
        }
        
        else if (specie.equalsIgnoreCase("Elf")){
            age=(gen.nextInt(100,750));
            height= (roll.getDiceRoll(10, 2)+52);
            weight= (height-48)*roll.getDiceRoll(6,1)+100;
            eyes= eyeColor[(gen.nextInt(eyeColor.length))];
            hair= hairColor[(gen.nextInt(hairColor.length))]+" "+hairstyle[(gen.nextInt(hairstyle.length))];
        }
        
        else if (specie.equalsIgnoreCase("Gnome")){
            age=(gen.nextInt(40,450));
            height= (roll.getDiceRoll(4,2)+34);
            weight= (height-35)+35;
            eyes= eyeColor[(gen.nextInt(eyeColor.length))];
            hair= hairColor[(gen.nextInt(hairColor.length))]+" "+hairstyle[(gen.nextInt(hairstyle.length))];
        }
        
        else  if (specie.equalsIgnoreCase("Half-elf")){
            age=(gen.nextInt(20,160));
            height= ((roll.getDiceRoll(10,2)+52));
            weight= (height-48)*roll.getDiceRoll(6,1)+100;
            eyes= eyeColor[(gen.nextInt(eyeColor.length))];
            hair= hairColor[(gen.nextInt(hairColor.length))]+" "+hairstyle[(gen.nextInt(hairstyle.length))];
        }
        
        else if (specie.equalsIgnoreCase("Halfling")){
            age=(gen.nextInt(20,150));
            height= (roll.getDiceRoll(6,2)+31);
            weight= (height-31)+35;
            eyes= eyeColor[(gen.nextInt(eyeColor.length))];
            hair= hairColor[(gen.nextInt(hairColor.length))]+" "+hairstyle[(gen.nextInt(hairstyle.length))];
        }
        
        else if (specie.equalsIgnoreCase("Half-Orc")){
            age=(gen.nextInt(14,75));
            height= ((roll.getDiceRoll(10,2)+58));
            weight= (height-58)*roll.getDiceRoll(6,2)+140;
            eyes= eyeColor[(gen.nextInt(eyeColor.length))];
            hair= hairColor[(gen.nextInt(hairColor.length))]+" "+hairstyle[(gen.nextInt(hairstyle.length))];
        }
        
        else if (specie.equalsIgnoreCase("Human")){
            age=(gen.nextInt(18,100));
            height= ((roll.getDiceRoll(10, 2)+56));
            weight= (height-56)*(roll.getDiceRoll(4,2))+110;
            eyes= eyeColor[(gen.nextInt(eyeColor.length))];
            hair= hairColor[(gen.nextInt(hairColor.length))]+" "+hairstyle[(gen.nextInt(hairstyle.length))];
        }
        
        else if (specie.equalsIgnoreCase("Tiefling")){
            age=(gen.nextInt(18,110));
            height= ((roll.getDiceRoll(10, 2)+57));
            weight= (height-57)*(roll.getDiceRoll(4,2))+110;
            eyes= eyeColor[(gen.nextInt(eyeColor.length))];
            hair= hairColor[(gen.nextInt(hairColor.length))]+" "+hairstyle[(gen.nextInt(hairstyle.length))];
        }        

        else if (specie.equalsIgnoreCase("Goblin")){
            age=(gen.nextInt(8,60));
            height= ((roll.getDiceRoll(4,2)+41));
            weight= (height-41)*roll.getDiceRoll(4,2)+35;
            eyes= eyeColor[(gen.nextInt(eyeColor.length))];
            hair= hairColor[(gen.nextInt(hairColor.length))]+" "+hairstyle[(gen.nextInt(hairstyle.length))];
        }

        else if (specie.equalsIgnoreCase("Hobgoblin")){
            age=(gen.nextInt(17,111));
            height= ((roll.getDiceRoll(10, 2)+56));
            weight= (height-56)*(roll.getDiceRoll(4, 2))+110;
            eyes= eyeColor[(gen.nextInt(eyeColor.length))];
            hair= hairColor[(gen.nextInt(hairColor.length))]+" "+hairstyle[(gen.nextInt(hairstyle.length))];
        }
        
        else if (specie.equalsIgnoreCase("Bugbear")){
            age=(gen.nextInt(15,90));
            height= ((roll.getDiceRoll(12,2)+72));
            weight= (height-72)*(roll.getDiceRoll(6, 2))+200;
            eyes= eyeColor[(gen.nextInt(eyeColor.length))];
            hair= hairColor[(gen.nextInt(hairColor.length))]+" "+hairstyle[(gen.nextInt(hairstyle.length))];
        }

        else if (specie.equalsIgnoreCase("Lizardfolk")){
            age=(gen.nextInt(14,75));
            height= ((roll.getDiceRoll(10, 2)+57));
            weight= (height-57)*(roll.getDiceRoll(6,2))+120;
            eyes= eyeColor[(gen.nextInt(eyeColor.length))];
            hair= hairColor[(gen.nextInt(hairColor.length))]+" "+hairstyle[(gen.nextInt(hairstyle.length))];
        }

        else if (specie.equalsIgnoreCase("Orc")){
            age=(gen.nextInt(12,60));
            height= ((roll.getDiceRoll(10, 2)+64));
            weight= (height-64)*(roll.getDiceRoll(12, 1))+155;
            eyes= eyeColor[(gen.nextInt(eyeColor.length))];
            hair= hairColor[(gen.nextInt(hairColor.length))]+" "+hairstyle[(gen.nextInt(hairstyle.length))];
        }

        else if (specie.equalsIgnoreCase("Shifter")){
            age=(gen.nextInt(10,81));
            height= ((roll.getDiceRoll(6,2)+54));
            weight= (height-54)*(roll.getDiceRoll(6,2))+85;
            eyes= eyeColor[(gen.nextInt(eyeColor.length))];
            hair= hairColor[(gen.nextInt(hairColor.length))]+" "+hairstyle[(gen.nextInt(hairstyle.length))];
        }

        else if (specie.equalsIgnoreCase("Minotaur")){
            age=(gen.nextInt(10,100));
            height= (roll.getDiceRoll(6,2)+66);
            weight= (height-66)*(roll.getDiceRoll(8,2))+185;
            eyes= eyeColor[(gen.nextInt(eyeColor.length))];
            hair= hairColor[(gen.nextInt(hairColor.length))]+" "+hairstyle[(gen.nextInt(hairstyle.length))];
        }

        else if (specie.equalsIgnoreCase("Gnoll")){
            age=(gen.nextInt(5,36));
            height= (roll.getDiceRoll(12,2)+82);
            weight= (height-66)*(roll.getDiceRoll(1))+205;
            eyes= eyeColor[(gen.nextInt(eyeColor.length))];
            hair= hairColor[(gen.nextInt(hairColor.length))]+" "+hairstyle[(gen.nextInt(hairstyle.length))];
        }

        else if (specie.equalsIgnoreCase("Medusa")){
            age=(gen.nextInt(15,175));
            height= (roll.getDiceRoll(8,2)+58);
            weight= (height-58)*(roll.getDiceRoll(6,2))+170;
            eyes= eyeColor[(gen.nextInt(eyeColor.length))];
        }
        
        else if (specie.equalsIgnoreCase("Changeling")){
            age=(gen.nextInt(15,130));
            height= (roll.getDiceRoll(6,2)+61);
            weight= (height-61)*(roll.getDiceRoll(4,2))+115;
            eyes= eyeColor[(gen.nextInt(eyeColor.length))];
            hair= hairColor[(gen.nextInt(hairColor.length))]+" "+hairstyle[(gen.nextInt(hairstyle.length))];
        }
        else{
            age=000;//(int)(17+Math.random()*91);
            height= 000;//((roll.getDiceRoll(2)+57));
            weight= 000;//(height*(roll.getDiceRoll(2))+110);
            eyes= "No Data";//eyeColor[(gen.nextInt(eyeColor.length))];
            hair= "no data";//hairColor[(gen.nextInt(hairColor.length))]+" "+hairstyle[(gen.nextInt(hairstyle.length))];
        }

        npc.setAge = age;
        npc.setHeight = height/12+"'"+height%12+"\"";
        npc.setWeight = weight;
        npc.setEyColor = eyes;
        npc.setHairColor = hair;
    }
    
    public void profession(NPC_Object npc) throws IOException{
    	//1D arrays
    	String[] Agri=lineReader(new File("/NPC generator/src/texts/Agriculture.txt"));
    	String[] Arch=lineReader(new File("/NPC generator/src/texts/Architecture.txt"));
    	String[] Arts=lineReader(new File("/NPC generator/src/texts/Arts.txt"));
    	String[] Busi=lineReader(new File("/NPC generator/src/texts/Business.txt"));
    	String[] Crim=lineReader(new File("/NPC generator/src/texts/Crime.txt"));
    	String[] Educ=lineReader(new File("/NPC generator/src/texts/Education.txt"));
    	String[] Law=lineReader(new File("/NPC generator/src/texts/Law.txt"));
    	String[] Health=lineReader(new File("/NPC generator/src/texts/Health.txt"));
    	String[] Hosp=lineReader(new File("/NPC generator/src/texts/Hospitality.txt"));
    	String[] Magic=lineReader(new File("/NPC generator/src/texts/Magic.txt"));
    	String[] War=lineReader(new File("/NPC generator/src/texts/War.txt"));
    	String[] Relig=lineReader(new File("/NPC generator/src/texts/Religion.txt"));
    	String[] Transport=lineReader(new File("/NPC generator/src/texts/Transportation.txt"));
    	String[] Unem=lineReader(new File("/NPC generator/src/texts/Unemployed.txt"));

        int category=gen.nextInt(1,15);
        switch (category) {
        case 1: job= Agri[(gen.nextInt(Agri.length))];
        	break;
        case 2: job= Arch[(gen.nextInt(Arch.length))];
        	break;
        case 3: job= Arts[(gen.nextInt(Arts.length))];
        	break;
        case 4: job= Busi[(gen.nextInt(Busi.length))];
        	break;
        case 5: job= Crim[(gen.nextInt(Crim.length))];
        	break;
        case 6: job= Educ[(gen.nextInt(Educ.length))];
       		break;
        case 7: job= Law[(gen.nextInt(Law.length))];
        	break;
        case 8: job= Health[(gen.nextInt(Health.length))];
    		break;
        case 9: job= Hosp[(gen.nextInt(Hosp.length))];
    		break;
        case 10: job= Magic[(gen.nextInt(Magic.length))];
    		break;
        case 11: job= War[(gen.nextInt(War.length))];
    		break;
        case 12: job= Relig[(gen.nextInt(Relig.length))];
    		break;
        case 13: job= Transport[(gen.nextInt(Transport.length))];
    		break;
        case 14: job= Unem[(gen.nextInt(Unem.length))];
    		break;
        }
        npc.setJob = job;
    }

    public String toString(){
        return "Age: "+age+"\nCareer: "+job+"\nHeight: "+height/12+"'"+(height%12)+"\nWeight: "+weight+"\nEyes: "+eyes+"\nHair: "+hair;
    }

    public void addInfo(NPC_Object npc){
        npc.setAge = age;
        npc.setJob = job;
        npc.setHeight = height/12+"'"+height%12+"\"";
        npc.setWeight = weight;
        npc.setEyColor = eyes;
        npc.setHairColor = hair;
    }
    
    public static String[] lineReader(File filename) throws IOException {
		 BufferedReader br = new BufferedReader(new FileReader(filename));
		 String[] fields = null;
	        List lines = new ArrayList<String>();
	        for(String line = br.readLine();line != null;line = br.readLine()) {
	            fields = line.split(", ");
	        }
	        br.close();
	        return fields;
	    }
} 