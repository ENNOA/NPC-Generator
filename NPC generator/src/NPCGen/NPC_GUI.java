package description;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GUI extends JFrame implements ActionListener {
		
		//declarations
		JButton numberButton;
		JButton nationButton;
		JPanel topPanel;
		JPanel midPanel;
		JPanel lowPanel;
		JLabel welcome;
		JLabel many;
		JLabel nation;
		JLabel title;
		JLabel menu;
		JTextField howMany;
		JTextField whereFrom;
		JScrollPane test;

		Border dash = BorderFactory.createDashedBorder(new Color(0,0,0));
		
		
		public GUI () {
			//panels
			topPanel = new JPanel();
			midPanel = new JPanel();
			lowPanel = new JPanel();
			
			topPanel.setBounds(0, 0, 900, 30);
			topPanel.setBorder(dash);
			midPanel.setBounds(0, 30, 900, 50);
			midPanel.setBorder(dash);
			lowPanel.setBounds(0, 80, 900, 50);
			lowPanel.setBorder(dash);
			
			//labels
			welcome = new JLabel("Eberron NPC Generator");
			many = new JLabel("Enter the number of NPCs to generate: ");
			nation = new JLabel("Choose a nation from to generate NPCs: ");
			title = new JLabel("New NPC Generation");
			menu = new JLabel("");
			
			//Number of NPC accept button 
			numberButton = new JButton();
			numberButton.setBounds(200, 200, 100, 150);
			numberButton.addActionListener(this);
			numberButton.setText("Submit"); 
			numberButton.setForeground(Color.BLACK);
			numberButton.setBackground(new Color(0x5d5d5d));
			numberButton.setBorder(BorderFactory.createRaisedBevelBorder());
			
			//nation selection button
			nationButton = new JButton();
			nationButton.setBounds(200, 200, 100, 150);
			nationButton.addActionListener(this);
			nationButton.setText("Submit"); 
			nationButton.setForeground(Color.BLACK);
			nationButton.setBackground(new Color(0x5d5d5d));
			nationButton.setBorder(BorderFactory.createRaisedBevelBorder());
			
			//number of NPCs
			howMany = new JTextField();
			howMany.setPreferredSize(new Dimension(300,40));
			howMany.setFont(new Font("Comic Sans",Font.ITALIC,24)); 
			howMany.setForeground(new Color(0xf0ffe1));  
			howMany.setBackground(new Color(0x73964f));
			
			//Which nation is the NPC from?
			whereFrom = new JTextField();
			whereFrom.setPreferredSize(new Dimension(300,40));
			whereFrom.setFont(new Font("Comic Sans",Font.ITALIC,24));
			whereFrom.setForeground(new Color(0xf0ffe1));  
			whereFrom.setBackground(new Color(0x73964f));
			
			//adding the components
			//Components
			this.add(topPanel);
			this.getContentPane().setLayout(null);
			topPanel.add(welcome);
			this.add(midPanel);
			midPanel.add(many);
			midPanel.add(howMany);
			midPanel.add(numberButton);
			midPanel.add(nation);
			this.add(lowPanel);
			lowPanel.add(title);

			
			
			// Finish setting up the frame
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(null);
			this.setSize(900,167);
			this.setVisible(true);

		}
		
	public void actionPerformed(ActionEvent e) {
		String text="";
		String text2="";
		if (e.getSource()==howMany){				 
			System.out.println("Generate how many NPCs? "+howMany.getText());  
		    text = howMany.getText();
		}
		menu();
		
		if (e.getSource()==whereFrom) {
			text2=whereFrom.getText();
		}
		
		int howMany=Integer.parseInt(text);
		int whereFrom=Integer.parseInt(text2);
	}
	/*	
	public void numberOfNPC(ActionEvent many) {
		String text="";
		
		if (many.getSource()==howMany){				 
			  System.out.println("Generate how many NPCs? "+howMany.getText());  
		      text = howMany.getText();
		}
		
		int howMany=Integer.parseInt(text);
	}
	
	
	public void nationOfNPC(ActionEvent nation) {
		// TODO Auto-generated method stub
		
	}
	*/
	
	public static void main(String[] args) throws NullPointerException, IOException{
		GUI frame = new GUI();
		/*
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
        */
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