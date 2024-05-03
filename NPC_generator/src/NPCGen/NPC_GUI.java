package NPCGen;

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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class NPC_GUI extends JFrame implements ActionListener {
		
		//declarations
		JButton numberButton;
		JButton nationButton;
		JComboBox homeland;
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
		JTextArea results;
		private static ImageIcon planes = new ImageIcon(NPC_GUI.class.getResource("/images/The Planes of Eberron.png"));

		Border dash = BorderFactory.createDashedBorder(new Color(0,0,0));
		
		
		public NPC_GUI () {
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
			welcome.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
			many = new JLabel("Enter the number of NPCs to generate: ");
			many.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 14));
			nation = new JLabel("Choose a nation from which to generate NPCs: ");
			nation.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 14));
			title = new JLabel("New NPC Generation");
			title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
			menu = new JLabel(test());
			
			//welcome label
			
			
			//Number of NPC accept button 
			numberButton = new JButton();
			numberButton.setBounds(200, 200, 100, 150);
			numberButton.addActionListener(this);
			numberButton.setText("Submit"); 
			numberButton.setForeground(Color.BLACK);
			numberButton.setBackground(new Color(0x5d5d5d));
			numberButton.setBorder(BorderFactory.createRaisedBevelBorder());
			
			//number of NPCs
			howMany = new JTextField();
			howMany.setPreferredSize(new Dimension(50,40));
			howMany.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,40)); 
			howMany.setForeground(new Color(0xf0ffe1));  
			howMany.setBackground(new Color(0x73964f));
			
			//Which nation is the NPC from?
			whereFrom = new JTextField();
			whereFrom.setPreferredSize(new Dimension(50,40));
			whereFrom.setFont(new Font("Comic Sans",Font.ITALIC,24));
			whereFrom.setForeground(new Color(0xf0ffe1));  
			whereFrom.setBackground(new Color(0x73964f));
			
			//scroll
			test = new JScrollPane(results);
			test.setBounds(20,20,400,400);
			
			//text area
			results = new JTextArea();
			results.setEditable(false);
			test = new JScrollPane(results);
			
			//combo box for nation selection
			String[] nations = {"Random", "Breland", "Zilargo", "Darguun", "Valenar", "Q'Barra","The Talenta Plains", "Karrnath",
								"The Mror Holds", "Thrane", "Aundair", "The Eldeen Reaches", "The Demon Wastes", 
								"The Shadow Marches",	"Droaam", "The Lhazaar Principalities"};
			homeland = new JComboBox(nations);
			
			//adding the components
			this.add(topPanel);
			this.getContentPane().setLayout(null);
			topPanel.add(welcome);
			this.add(midPanel);
			midPanel.add(many);
			midPanel.add(howMany);
			midPanel.add(nation);
			midPanel.add(homeland);
			midPanel.add(numberButton);
			this.add(lowPanel);
			lowPanel.add(title);
			lowPanel.add(test);
			lowPanel.add(results);

			
			// Finish setting up the frame
			this.setIconImage(planes.getImage());
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(new FlowLayout());
			this.pack();
			this.setSize(1100,1100);
			this.setVisible(true);

		}
		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == numberButton) {
				int numberOfNPCs = Integer.parseInt(howMany.getText().trim());
				int homelandIndex = homeland.getSelectedIndex();
				
				try {
					List<NPC_Object> npcList = builder(numberOfNPCs, homelandIndex);
					StringBuilder displayText = new StringBuilder();
					for (NPC_Object npc : npcList) {
						displayText.append(npc.toString()).append("\n\n");
					}
					results.setText(displayText.toString());
				} catch (Exception ex) {
					results.setText("Error generating NPCs: " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		}
		

	
	public static List<NPC_Object> builder(int numberOfNPCs, int homelandIndex) throws NullPointerException, IOException {
		List<NPC_Object> npcList = new ArrayList<>();
		for (int i = 0; i < numberOfNPCs; i++) {
			NPC_Object npc = new NPC_Object(); // Ensure you have a suitable constructor
			descGen who = new descGen();
			namesAndOrigins where = new namesAndOrigins();
			
			try {
				where.randomize(npc, homelandIndex); // Modify to accept NPC_Object
			} catch (ArrayIndexOutOfBoundsException ex) {
				System.out.println(ex.getMessage());
			}
			
			try {
				who.randomize(npc, npc.getRace()); // Modify to accept NPC_Object
			} catch (NullPointerException ex) {
				System.out.println(ex.getMessage());
			}
			
			who.profession(npc); // Modify to accept NPC_Object
			npcList.add(npc);
		}
		return npcList;
	}
	
    
    public static void menu() {
    	System.out.print("Choose a nation from which to generate NPCs:");
        System.out.print("\n 00 = Random               01 = Breland               02 = Zilargo               03 = Darguun");
        System.out.print("\n 04 = Valenar              05 = Q'barra               06 = The Talenta Plains    07 = Karrnath");
        System.out.print("\n 08 = The Mror Holds       09 = Thrane                10 = Aundair               11 = The Eldeen Reaches");
        System.out.print("\n 12 = The Demon Wastes     13 = The Shadow Marches    14 = Droaam                15 = The Lhazaar Principalities \n");
        System.out.print("\n Enter nation number here: ");
    	
    }
    
    public static String test() {
    	String test = "BORK! \nBORK!";
    	return test;
    }
    
    public static void main(String[] args) throws NullPointerException, IOException{
    	NPC_GUI frame = new NPC_GUI();
    }
    
}

		