package NPCGen;

/*
 * Class to generate Names based on race, gender, and nationality.
 * 
 */


import java.io.*;
import java.util.*;
public class namesAndOrigins {
	//reader reader=new reader();
    Random gen=new Random();
   // dice d2=new dice(); 
   // dice d10=new dice(10);
   // dice d100=new dice(100);
    dice roll=new dice();
    //variables
        
    int gender=roll.getDiceRoll(2,1);
    String sex;
    String nation;
    String firstName="";
    String lastName="";
    String surname="";
    String clanName="";
   
    int race1;
    String race="";
    //String sentinel;

    //1D arrays
    String[] nationality={"Breland", "Zilargo", "Darguun", "Valenar", "Q'Barra", "The Talenta Plains", "Karrnath", "The Mror Holds", "Thrane",
            "Aundair", "The Eldeen Reaches", "The Demon Wastes", "The Shadow Marches", "Droaam", "The Lhazaar Prinicipalities"};
    String[] raceList={"Dragonborn", "Dwarf", "Elf", "Gnome", "Half-Elf", "Halfling", "Half-Orc", "Human","Tiefling","Changeling","Gnoll","Orc","Minotaur","Medusa"};
    
    public void randomize(int origin) throws IOException{
    	   //2D arrays
        String[][] aundairanNames=reader(new File(getClass().getResource("/texts/aundairanNames.txt").getFile()));
        String[][] brelishNames=reader(new File(getClass().getResource("/texts/brelishNames.txt").getFile()));
    	String[][] karrnathiNames=reader(new File(getClass().getResource("/texts/karrnathiNames.txt").getFile()));
    	String[][] thraneNames=reader(new File(getClass().getResource("/texts/thraneNames.txt").getFile()));               
    	String[][] goblinNames=reader(new File(getClass().getResource("/texts/goblinNames.txt").getFile()));
    	String[][] gnomeNames=reader(new File(getClass().getResource("/texts/gnomeNames.txt").getFile()));
     	String[][] dwarfNames=reader(new File(getClass().getResource("/texts/dwarfNames.txt").getFile()));
        String[][] halflingNames=reader(new File(getClass().getResource("/texts/halflingNames.txt").getFile()));
        String[][] elfNames=reader(new File(getClass().getResource("/texts/elfNames.txt").getFile()));
        String[][] halfOrcNames=reader(new File(getClass().getResource("/texts/halfOrcNames.txt").getFile()));
        String[][] scalyNames=reader(new File(getClass().getResource("/texts/scalyNames.txt").getFile()));
        
        if(gender==1)
            sex= "Male";
            else
            sex= "Female";

        switch (origin) {
            case 0: origin=gen.nextInt(1,16);
            	randomize(origin);
            	break;
            case 1: nation="Breland";
                if(sex.equals("Male"))
                    firstName= brelishNames[0][(gen.nextInt(brelishNames[0].length))];
                    else
                    firstName= brelishNames[1][(gen.nextInt(brelishNames[1].length))];
                surname=brelishNames[2][(gen.nextInt(brelishNames[2].length))]; 
                race1= roll.getDiceRoll(100,1);
                if(race1<=44)
                    race="Human";
                else if(race1>44 &&race1<=58)
                    race="Gnome";
                else if(race1>58 &&race1<=68)
                    race="Half-elf";
                else if(race1>68 &&race1<=76)
                    race="Elf";
                else if(race1>76 &&race1<=83)
                    race="Dwarf";
                else if(race1>83 &&race1<=90)
                    race="Halfling";
                else if(race1>90 &&race1<=95)
                    race=goblinoid();
                else if(race1>95 &&race1<=98)
                    race="Half-Orc";
                else
                    race="Orc";
                break;
        
            case 2: nation="Zilargo";
                if(sex.equals("Male"))
                    firstName= gnomeNames[0][(gen.nextInt(gnomeNames[0].length))];
                    else
                    firstName= gnomeNames[1][(gen.nextInt(gnomeNames[1].length))];
                surname=gnomeNames[2][(gen.nextInt(gnomeNames[2].length))];
                clanName=gnomeNames[3][(gen.nextInt(gnomeNames[3].length))];
                race1= roll.getDiceRoll(100,1);
                if(race1<=75)
                        race="Gnome";
                else if(race1>75 &&race1<=90)
                    race="Human";
                else if(race1>90 &&race1<=98)
                    race="Half-Dwarf";
                else
                    race=goblinoid();
                break;
            case 3: nation="Darguun";
                if(sex.equals("Male"))
                    firstName= goblinNames[0][(gen.nextInt(goblinNames[0].length))];
                    else
                    firstName= goblinNames[1][(gen.nextInt(goblinNames[1].length))];
                surname="";
                race1= gen.nextInt(101);
                if(race1<=44)
                    race="Goblin";
                else  if(race1>44 &&race1<=78)
                    race="Hobgoblin";
                else if(race1>78 &&race1<=91)
                    race="Bugbear";
                else 
                    race="Human";
                break;
            case 4: nation="Valenar";
                if(sex.equals("Male"))
                    firstName= elfNames[0][(gen.nextInt(elfNames[0].length))];
                    else
                    firstName= elfNames[1][(gen.nextInt(elfNames[1].length))];
                surname=elfNames[2][(gen.nextInt(elfNames[2].length))]; 
                race1= roll.getDiceRoll(100,1);
                if(race1<=43)
                    race="Elf";
                if(race1>43 &&race1<=71)
                    race="Human";
                if(race1>71 &&race1<=89)
                    race="Half-elf";
                if(race1>89 &&race1<=94)
                    race="Halfling";
                if(race1>94 &&race1<=100)
                    race=goblinoid();
                break;
            case 5: nation="Q'Barra";
                if(sex.equals("Male")){
                	race1=gen.nextInt(101);
                    if(race1<=25){
                        setRace("Lizardfolk");
                        firstName=scalyNames[0][(gen.nextInt(scalyNames[0].length))];
                        surname=scalyNames[3][(gen.nextInt(scalyNames[3].length))];                        
                    }
                    else if(race1>25 && race1<=40){
                        setRace("Dragonborn");
                        firstName=scalyNames[0][(gen.nextInt(scalyNames[0].length))];
                        surname=scalyNames[2][(gen.nextInt(scalyNames[2].length))];
                    }
                    else if(race1>40 && race1<=70){
                    	setRace("Human");
                        firstName= brelishNames[0][(gen.nextInt(brelishNames[0].length))];
                        surname=brelishNames[2][(gen.nextInt(brelishNames[2].length))];
                    }
                    else if (race1>70 && race1<=86){
                    	setRace("Halfling");
                        firstName=halflingNames[0][(gen.nextInt(halflingNames[0].length))];
                        surname=halflingNames[2][(gen.nextInt(halflingNames[2].length))];
                    }
                    else if (race1>=86 && race1<95){
                    	setRace("Dwarf");
                        firstName=dwarfNames[0][(gen.nextInt(dwarfNames[0].length))];
                        surname=dwarfNames[2][(gen.nextInt(dwarfNames[2].length))];
                    }
                    else if (race1>=95 && race1<=100){
                    	setRace("Half-elf");
                        firstName= elfNames[0][(gen.nextInt(elfNames[0].length))];
                        surname=brelishNames[2][(gen.nextInt(brelishNames[2].length))];
                    }
                }
                else {
                    if(race1<=25){
                        setRace("Lizardfolk");
                        firstName=scalyNames[1][(gen.nextInt(scalyNames[1].length))];
                        surname=scalyNames[2][(gen.nextInt(scalyNames[2].length))];
                    }
                    if(race1>25 && race1<=40){
                        setRace("Dragonborn");
                        firstName=scalyNames[1][(gen.nextInt(scalyNames[1].length))];
                        surname=scalyNames[3][(gen.nextInt(scalyNames[3].length))];
                    }
                    if(race1<40 && race1<=70){
                    	setRace("Human");
                        firstName= brelishNames[1][(gen.nextInt(brelishNames[1].length))];
                        surname=brelishNames[2][(gen.nextInt(brelishNames[2].length))];
                    }
                    if (race1<70 && race1<=86){
                    	setRace("Halfling");
                        firstName=halflingNames[1][(gen.nextInt(halflingNames[1].length))];
                        surname=halflingNames[2][(gen.nextInt(halflingNames[2].length))];
                    }
                    if (race1<=86 && race1<95){
                    	setRace("Dwarf");
                        firstName=dwarfNames[1][(gen.nextInt(dwarfNames[1].length))];
                        surname=dwarfNames[2][(gen.nextInt(dwarfNames[2].length))];
                    }
                    if (race1<=95 && race1<=100){
                    	setRace("Half-elf");
                        firstName= elfNames[1][(gen.nextInt(elfNames[1].length))];
                        surname=brelishNames[2][(gen.nextInt(brelishNames[2].length))];
                    }
                }
                    break;
                    
            case 6: nation="The Talenta Plains";
                if(sex.equals("Male"))
                    firstName=halflingNames[0][(gen.nextInt(halflingNames[0].length))];
                    else
                    firstName=halflingNames[1][(gen.nextInt(halflingNames[1].length))];
                surname=halflingNames[2][(gen.nextInt(halflingNames[2].length))];
                race1= roll.getDiceRoll(100,1);
                if(race1<=80)
                    race="Halfling";
                if(race1>80 &&race1<=90)
                    race="Human";
                if(race1>90 &&race1<=96)
                    race="Dwarf";
                if(race1>96 &&race1<=100)
                    race=goblinoid();
                break;
            case 7: nation="Karrnath";
                if(sex.equals("Male"))
                    firstName= karrnathiNames[0][(gen.nextInt(karrnathiNames[0].length))];
                    else
                    firstName= karrnathiNames[1][(gen.nextInt(karrnathiNames[1].length))];
                surname= karrnathiNames[2][(gen.nextInt(karrnathiNames[2].length))];
                race1= roll.getDiceRoll(100,1);
                if(race1<=52)
                    race="Human";
                if(race1>52 &&race1<=70)
                    race="Dwarf";
                if(race1>70 &&race1<=80)
                    race="Halfling";
                if(race1>80 &&race1<=90)
                    race="Half-elf";
                if(race1>90 && race1<=100)
                    race= "Elf";
                break;
            case 8: nation="The Mror Holds";
                if(sex.equals("Male"))
                    firstName=dwarfNames[0][(gen.nextInt(dwarfNames[0].length))];
                    else
                    firstName=dwarfNames[1][(gen.nextInt(dwarfNames[1].length))];
                surname=dwarfNames[2][(gen.nextInt(dwarfNames[2].length))];
                race1= roll.getDiceRoll(100,1);
                if(race1<=65)
                    race="Dwarf";
                if(race1>65 &&race1<=77)
                    race="Human";
                if(race1>77 &&race1<=87)
                    race="Orc";
                if(race1>87 &&race1<=95)
                    race="Gnome";
                if(race1>95 && race1<=100)
                    race= goblinoid();
                break;
            case 9: nation="Thrane";
                if(sex.equals("Male"))
                    firstName=thraneNames[1][(gen.nextInt(thraneNames[0].length))];
                    else
                    firstName=thraneNames[2][(gen.nextInt(thraneNames[1].length))];
                surname= thraneNames[2][(gen.nextInt(thraneNames[2].length))];
                race1= roll.getDiceRoll(100,1);
                if(race1<=70)
                    race="Human";
                if(race1>70 &&race1<=80)
                    race="Half-elf";
                if(race1>80 &&race1<=89)
                    race="Dwarf";
                if(race1>89 &&race1<=95)
                    race="Elf";
                if(race1>95 && race1<=100)
                    race= "Halfling";
                break;
            case 10: nation="Aundair";
                if(sex.equals("Male"))
                    firstName=aundairanNames[0][(gen.nextInt(aundairanNames[0].length))];
                    else
                    firstName=aundairanNames[1][(gen.nextInt(aundairanNames[1].length))];
                surname=aundairanNames[2][(gen.nextInt(aundairanNames[2].length))];
                race1= roll.getDiceRoll(100,1);
                if(race1<=51)
                    race="Human";
                if(race1>51 &&race1<=67)
                    race="Half-elf";
                if(race1>67 &&race1<=78)
                    race="Elf";
                if(race1>78 &&race1<=89)
                    race="Gnome";
                if(race1>89 && race1<=96)
                    race= "Shifter";
                if(race1>96 && race1<100)
                    race="Halfling";
                break;
            case 11: nation="The Eldeen Reaches";
                if(sex.equals("Male"))
                    firstName=aundairanNames[0][(gen.nextInt(aundairanNames[0].length))];
                    else
                    firstName=aundairanNames[1][(gen.nextInt(aundairanNames[1].length))];
                surname=aundairanNames[2][(gen.nextInt(aundairanNames[2].length))];
                race1= roll.getDiceRoll(100,1);
                if(race1<=45)
                    race="Human";
                if(race1>45 &&race1<=61)
                    race="Half-elf";
                if(race1>61 &&race1<=77)
                    race="Shifter";
                if(race1>77 &&race1<=84)
                    race="Gnome";
                if(race1>84 && race1<=93)
                    race= "Halfling";
                if(race1>93 && race1<100)
                    race="Orc";
                break;   
            case 12: nation="The Demon Wastes";
                if(sex.equals("Male"))
                    if((roll.getDiceRoll(10,1))<3)
                        firstName= brelishNames[0][(gen.nextInt(brelishNames[0].length))];
                    else
                        firstName= halfOrcNames[0][(gen.nextInt(halfOrcNames[0].length))];
                else
                    if((roll.getDiceRoll(10,1))<3)
                        firstName= brelishNames[1][(gen.nextInt(brelishNames[1].length))];
                    else
                        firstName= halfOrcNames[1][(gen.nextInt(halfOrcNames[1].length))];
                surname="";
                race1= roll.getDiceRoll(100,1);
                if(race1<=45)
                    race="Human";
                if(race1>45 &&race1<=90)
                    race="Orc";
                if(race1>90 &&race1<=100)
                    race="Half-Orc";
                break;
            case 13: nation="The Shadow Marches";
                if(sex.equals("Male"))
                    firstName=halfOrcNames[0][(gen.nextInt(halfOrcNames[0].length))];
                    else
                    firstName=halfOrcNames[1][(gen.nextInt(halfOrcNames[1].length))];
                race1= roll.getDiceRoll(100,1);
                if(race1<=55)
                    race="Orc";
                if(race1>55 &&race1<=80)
                    race="Human";
                if(race1>80 &&race1<=90)
                    race=goblinoid();
                if(race1>90 &&race1<=100)
                    race="Half-Orc";
                break;
            case 14: nation="Droaam";
                if(sex.equals("Male"))
                    if((roll.getDiceRoll(10,1))<4)
                        firstName= halfOrcNames[0][(gen.nextInt(halfOrcNames[0].length))];
                    else
                        firstName= goblinNames[0][(gen.nextInt(goblinNames[0].length))];
                else
                    if((roll.getDiceRoll(10,1))<4)
                        firstName= halfOrcNames[1][(gen.nextInt(halfOrcNames[1].length))];
                    else
                        firstName= goblinNames[1][(gen.nextInt(goblinNames[1].length))];
                    race1= roll.getDiceRoll(100,1);
                if(race1<=20)
                    race="Gnoll";
                if(race1>20 &&race1<=39)
                    race="Orc";
                if(race1>39 &&race1<=57)
                    race=goblinoid();
                if(race1>57 &&race1<=62)
                    race="Shifter";
                if(race1>62 && race1<=100)
                    race= raceList[(gen.nextInt(raceList.length))];
                break;
            case 15: nation="The Lhazaar Principalities";
        	int race2=roll.getDiceRoll(10,1);
            if(sex.equals("Male")){
                if(race2>=6){
                	race="Human";
                    firstName= brelishNames[0][(gen.nextInt(brelishNames[0].length))];
                    surname= brelishNames[2][(gen.nextInt(brelishNames[2].length))];
                }
                else if(race2==5){
                	race="Halfling";
                    firstName= halflingNames[0][(gen.nextInt(halflingNames[0].length))];
                    surname= halflingNames[2][(gen.nextInt(halflingNames[2].length))];
                }
                else if(race2==4){
                	race="Dwarf";
                    firstName= dwarfNames[0][(gen.nextInt(dwarfNames[0].length))];
                    surname= dwarfNames[2][(gen.nextInt(dwarfNames[2].length))];
                }
                else if(race2==3){
                	race="Gnome";
                    firstName= gnomeNames[0][(gen.nextInt(gnomeNames[0].length))];
                    surname= gnomeNames[2][(gen.nextInt(gnomeNames[2].length))];
                    clanName= gnomeNames[3][(gen.nextInt(gnomeNames[3].length))];
                }
                else if(race2==2){
                	race="Human";
                    firstName= karrnathiNames[0][(gen.nextInt(halflingNames[0].length))];
                    surname= karrnathiNames[2][(gen.nextInt(karrnathiNames[2].length))];
                }
                else{
                	race= "Elf";
                    firstName= elfNames[0][(gen.nextInt(elfNames[0].length))];
                    surname= elfNames[2][(gen.nextInt(elfNames[2].length))];
                    }
                }    
            else {
                if(race2>=6){
                	race= "Human";
                    firstName= brelishNames[1][(gen.nextInt(brelishNames[1].length))];
                    surname= brelishNames[2][(gen.nextInt(brelishNames[2].length))];
                }
                if(race2==5){
                	race= "Halfing";
                    firstName= halflingNames[1][(gen.nextInt(halflingNames[1].length))];
                    surname= halflingNames[2][(gen.nextInt(halflingNames[2].length))];
                }
                if(race2==4){
                	race= "Dwarf";
                    firstName= dwarfNames[1][(gen.nextInt(dwarfNames[1].length))];
                    surname= dwarfNames[2][(gen.nextInt(dwarfNames[2].length))];
                }
                if(race2==3){
                	race= "Gnome";
                    firstName= gnomeNames[1][(gen.nextInt(gnomeNames[1].length))];
                    surname= gnomeNames[2][(gen.nextInt(gnomeNames[2].length))];
                    clanName= gnomeNames[3][(gen.nextInt(gnomeNames[3].length))];
                }
                if(race2==2){
                	race= "Human";
                    firstName= karrnathiNames[1][(gen.nextInt(halflingNames[1].length))];
                    surname= karrnathiNames[2][(gen.nextInt(karrnathiNames[2].length))];
                }
                else{
                	race= "Elf";
                    firstName= elfNames[1][(gen.nextInt(elfNames[1].length))];
                    surname= elfNames[2][(gen.nextInt(elfNames[2].length))];
                    }
                }
            break;
        }        
    
    }
    
    public String goblinoid() {
    	int gobType= roll.getDiceRoll(10, 1);
        if (gobType<=5)
            race="Goblin";
        else if (gobType>5 && gobType<8)
            race="Bugbear";
        else
            race="Hobgoblin";
        return race;
    }

    public String getRace(){
        return race;
    }
    
    public void setRace(String specie) {
    	this.race=specie;
    }
    
    public String toString(){
        return    "Race: "+race+"\nGender: "+sex+"\nNation: "+nation+"\nName: "+firstName+" "+surname+" "+clanName;
    }
    
  
	public String[][] reader(File filename) throws IOException {
		try( BufferedReader br = new BufferedReader(new FileReader(filename))) {
			List lines = new ArrayList<String>();
	        for(String line = br.readLine();line != null;line = br.readLine()) {
	            String[] fields = line.split(" ");
	            lines.add(fields);
	        }
	        String[][] strings = (String[][]) lines.toArray(new String[lines.size()][]);
	        return strings;
		
	    }
	} 
}