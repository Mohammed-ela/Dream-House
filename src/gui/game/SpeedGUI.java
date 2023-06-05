package gui.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import config.HouseConfig;
import engine.map.Case;
import engine.map.Salon;
import engine.mobile.Meuble;
import engine.process.BoxElementManager;
import engine.process.MapBuilder;
import engine.process.MobileElementManager;
import engine.process.SimulationUtility;
import filtre.Filtre;
import java.util.*;
import java.io.*;




    



public class SpeedGUI extends JFrame implements Runnable{
	private static final long serialVersionUID = 1L;

	private Salon salon;
	
	private Dimension preferredSize = new Dimension(HouseConfig.WINDOW_WIDTH,HouseConfig.WINDOW_HEIGHT);
	
	private final static Dimension preferredSizeScroll = new Dimension(HouseConfig.WINDOW_WIDTH_BOX,HouseConfig.WINDOW_HEIGHT_BOX);
	
	private final static Dimension preferredSizeBox = new Dimension(HouseConfig.WINDOW_WIDTH_BOX,HouseConfig.WINDOW_HEIGHT_BOX+300);

	private static Font font = new Font(Font.SERIF, Font.PLAIN, 20);
	
	private static Color boxColor = new Color(250, 250, 210);
	
	private static Color mapColor = new Color(250, 250, 230);
	
	private MobileElementManager manager;
	
	private BoxElementManager boxManager;

	private MapDisplay dashboard;
	
	private BoxDisplay boxDashboard;
	
	private BoxElementManager meuble ;
	
	private static Filtre nature  = new Filtre();
	
	private static DefaultComboBoxModel natureChoice  = new DefaultComboBoxModel(nature.getNature());

	private int choiceMeuble ;
	
	private String style = "classique";
	
	private Random rand = new Random();
	
	private int budgetValue; 
     

	
	public SpeedGUI(String title,Color mapColor,String style,int budgetValue){
		super(title);
		this.mapColor = mapColor;
		this.style = style;
		this.budgetValue=budgetValue;
		
		init();
	}
	
	

	private void init() {
		

		Container contentPane = getContentPane();
		
		contentPane.setLayout(new BorderLayout());
		  
		

		KeyControls keyControls = new KeyControls();
		
		
		JTextField textField = new JTextField();
		textField.addKeyListener(keyControls);
		contentPane.add(textField, BorderLayout.SOUTH);
		
		JLabel helpText = new JLabel("left click : crée un mur  | right click : supprime un mur | I : inserer un objet | P : pivoter | R : supprimer ");
		
		contentPane.add(helpText, BorderLayout.NORTH);
		salon = MapBuilder.buildSalon();
		// 
		manager = MapBuilder.buildInitMobile(salon,0);
		System.out.println(choiceMeuble);
		dashboard = new MapDisplay(salon, manager);
		//
		dashboard.setBackground(mapColor);
		
		boxDashboard = new BoxDisplay(boxManager);

		MouseControls mouseControls = new MouseControls();
		dashboard.addMouseListener(mouseControls);

		dashboard.setPreferredSize(preferredSize);
		boxDashboard.setPreferredSize(preferredSizeBox);
		
		contentPane.add(dashboard, BorderLayout.CENTER);
		//contentPane.add(boxDashboard,BorderLayout.EAST);
		JScrollPane scrollPane = new JScrollPane(boxDashboard);
		scrollPane.setPreferredSize(new Dimension(preferredSizeScroll));
		contentPane.add(scrollPane,BorderLayout.EAST);
		
		boxDashboard.setBackground(boxColor);
		
		boxDashboard.setLayout(null);
		

		//wall spdhouse
		
		int a ;
		int b =12*20 ;
		Case bombPosition;
		
		for( a=0 ;a < 690;) {
		
				
					bombPosition = dashboard.getWallPosition(a, b);
					manager.putWall(bombPosition);
					System.out.println(bombPosition);
					
				a += 20;
		}
		a=15*20;
		
		for( b=0 ;b < 540;) {
			
			
			bombPosition = dashboard.getWallPosition(a, b);
			manager.putWall(bombPosition);
			System.out.println(bombPosition);
			
		b += 20;
		}
		
		bombPosition = dashboard.getWallPosition(26*20, 12*20);
		manager.deleteWall(bombPosition);
		
		bombPosition = dashboard.getWallPosition(25*20, 12*20);
		manager.deleteWall(bombPosition);
		
		bombPosition = dashboard.getWallPosition(7*20, 12*20);
		manager.deleteWall(bombPosition);
		
		bombPosition = dashboard.getWallPosition(8*20, 12*20);
		manager.deleteWall(bombPosition);
		
		bombPosition = dashboard.getWallPosition(15*20, 4*20);
		manager.deleteWall(bombPosition);
		
		bombPosition = dashboard.getWallPosition(15*20, 5*20);
		manager.deleteWall(bombPosition);
		
		bombPosition = dashboard.getWallPosition(15*20, 19*20);
		manager.deleteWall(bombPosition);
		
		bombPosition = dashboard.getWallPosition(15*20, 20*20);
		manager.deleteWall(bombPosition);
			
		
		
		
		
		JLabel titre = new JLabel("Toolbox");
		titre.setFont(font);
		
		titre.setBounds(110, 300, 100, 60);
		boxDashboard.add(titre);
		
		
		JLabel filtre = new JLabel("filtre");
		filtre.setFont(font);
		
		filtre.setBounds(110, 10, 100,60 );
		boxDashboard.add(filtre);
		
		JComboBox nature = new JComboBox();
		
		nature.setModel(natureChoice);
		nature.setSelectedIndex(-1);
		nature.setBounds(10, 50, 100, 30);
		boxDashboard.add(nature);
		
		JLabel prix = new JLabel("Prix");
		prix.setFont(font);
		prix.setBounds(10, 100, 50, 30);
		boxDashboard.add(prix);
		
		JTextField min = new JTextField();
		min.setText("min");
		min.setBounds(60, 110, 96, 19);
		boxDashboard.add(min);
		
		JTextField max = new JTextField();
		max.setText("max");
		max.setBounds(160, 110, 96, 19);
		boxDashboard.add(max);
		
		JLabel sol = new JLabel("Sol");
		sol.setFont(font);
		sol.setBounds(10, 130, 50, 30);
		boxDashboard.add(sol);
		
		ButtonGroup bouttonGoup1 = new ButtonGroup();
		JRadioButton classique = new JRadioButton("classique");
		JRadioButton comtemporain = new JRadioButton("comtemporain");
		JRadioButton moderne = new JRadioButton("moderne");
		classique.setSelected(false);
		comtemporain.setSelected(false);	
		moderne.setSelected(false);
		classique.setBackground(boxColor);
		comtemporain.setBackground(boxColor);
		moderne.setBackground(boxColor);
		
		classique.setBounds(10, 160, 200, 30);
		comtemporain.setBounds(10, 190, 200, 30);
		moderne.setBounds(10, 220, 200, 30);
		
		bouttonGoup1.add(classique);
		bouttonGoup1.add(comtemporain);
		bouttonGoup1.add(moderne);
		boxDashboard.add(classique);
		boxDashboard.add(comtemporain);
		boxDashboard.add(moderne);
		
		classique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton source = (JRadioButton)e.getSource();
				if (source.isSelected()) {
					dashboard.setBackground(new Color(250, 250, 230));
				
				}
				if (!source.isSelected()) {
					dashboard.setBackground(mapColor);
								
				}
				boxDashboard.repaint();
			}
		});
		
		comtemporain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton source = (JRadioButton)e.getSource();
				if (source.isSelected()) {
					dashboard.setBackground(new Color(205, 122, 40));
					
				}
				if (!source.isSelected()) {
					dashboard.setBackground(mapColor);
								
				}
				boxDashboard.repaint();
			}
		});
		
		moderne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton source = (JRadioButton)e.getSource();
				if (source.isSelected()) {
					dashboard.setBackground(new Color(189, 58, 48));
				
				}
				if (!source.isSelected()) {
					
					dashboard.setBackground(mapColor);
				}
				boxDashboard.repaint();
			}
		});
		
		
		ButtonGroup bouttonGoup = new ButtonGroup();
		int posX = HouseConfig.WINDOW_WIDTH_BOX/5 ;
		int posY = (HouseConfig.WINDOW_HEIGHT_BOX /5 + 300) ; 
		int i;
		JRadioButton[] buttons = new JRadioButton[20];
		
		/*
		for(i = 0 ; i < 9 ; i ++) { 	
		
		buttons[i].setSelected(false);
		buttons[i].setBackground(boxColor);
		buttons[i].setBounds(posX, posY, 20, 20);
		boxDashboard.add(buttons[i]);
		posX += HouseConfig.WINDOW_WIDTH_BOX/5 +20 ;
		} */
		
		
		for( i = 0 ; i < 15 ; i ++) { 
			int j =i;
			
		buttons[i] = new JRadioButton("");
		buttons[i].setSelected(false);
		buttons[i].setBackground(boxColor);
		buttons[i].setBounds(posX, posY, 20, 20);
		bouttonGoup.add(buttons[i]);
		boxDashboard.add(buttons[i]);
		if (posX < HouseConfig.WINDOW_WIDTH_BOX -50) {
		posX += HouseConfig.WINDOW_WIDTH_BOX/5 +20 ;
		}
		else {
			posX = HouseConfig.WINDOW_WIDTH_BOX/5 ;
			posY += 100 ;
		}
		
		
		
		
		buttons[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton source = (JRadioButton)e.getSource();
				if (source.isSelected()) {
					Case block = salon.getCase(HouseConfig.LIGNE_COUNT - 1, (HouseConfig.COLUMN_COUNT - 1) / 2);
					Meuble meuble = new Meuble(block);
					BoxElementManager toolBox = new BoxElementManager();
					try {
						toolBox.createToolBox();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					meuble = toolBox.chooseMeuble(j*4); 
					manager.setMeuble(meuble);
					System.out.println(j);
					
				}
				if (!source.isSelected()) {
					
								
				}
				dashboard.repaint();
			}
		});
		}
		int budget = 0;
		if (style == "classique") {
			Case block = salon.getCase(HouseConfig.LIGNE_COUNT - 1, (HouseConfig.COLUMN_COUNT - 1) / 2);
			Meuble meuble = new Meuble(block);
			BoxElementManager toolBox = new BoxElementManager();
			try {
				toolBox.createToolBox();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			meuble = toolBox.chooseMeuble(9); 
			meuble.setPosition(new Case(2,5));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(10); 
			meuble.setPosition(new Case(8,8));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(0); 
			meuble.setPosition(new Case(3,9));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(8*4+1); 
			meuble.setPosition(new Case(5,20));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			
			meuble = toolBox.chooseMeuble(8*4+3); 
			meuble.setPosition(new Case(5,30));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			
			meuble = toolBox.chooseMeuble(9*4); 
			meuble.setPosition(new Case(1,26));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(12*4); 
			meuble.setPosition(new Case(25,5));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(17); 
			meuble.setPosition(new Case(19,2));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(19); 
			meuble.setPosition(new Case(19,10));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(13*4); 
			meuble.setPosition(new Case(19,6));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(9*4+1); 
			meuble.setPosition(new Case(23,25));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(9*4+3); 
			meuble.setPosition(new Case(16,25));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(12*4+1); 
			meuble.setPosition(new Case(16,16));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(12*4+3); 
			meuble.setPosition(new Case(24,33));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();

			
			
			
			}
			
			
			
		
		
		else if (style == "comtemporain") {
			Case block = salon.getCase(HouseConfig.LIGNE_COUNT - 1, (HouseConfig.COLUMN_COUNT - 1) / 2);
			Meuble meuble = new Meuble(block);
			BoxElementManager toolBox = new BoxElementManager();
			try {
				toolBox.createToolBox();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			meuble = toolBox.chooseMeuble(9); 
			meuble.setPosition(new Case(2,5));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(10); 
			meuble.setPosition(new Case(8,8));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(0); 
			meuble.setPosition(new Case(3,9));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(8*4+1); 
			meuble.setPosition(new Case(5,20));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			
			meuble = toolBox.chooseMeuble(8*4+3); 
			meuble.setPosition(new Case(5,30));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			
			meuble = toolBox.chooseMeuble(9*4); 
			meuble.setPosition(new Case(1,26));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(12*4); 
			meuble.setPosition(new Case(25,5));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(17); 
			meuble.setPosition(new Case(19,2));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(19); 
			meuble.setPosition(new Case(19,10));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(13*4); 
			meuble.setPosition(new Case(19,6));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(9*4+1); 
			meuble.setPosition(new Case(23,25));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(9*4+3); 
			meuble.setPosition(new Case(16,25));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(12*4+1); 
			meuble.setPosition(new Case(16,16));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			
			meuble = toolBox.chooseMeuble(12*4+3); 
			meuble.setPosition(new Case(24,33));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();

			
		}
		
		else if (style == "moderne") {
			
			Case block = salon.getCase(HouseConfig.LIGNE_COUNT - 1, (HouseConfig.COLUMN_COUNT - 1) / 2);
			Meuble meuble = new Meuble(block);
			BoxElementManager toolBox = new BoxElementManager();
			try {
				toolBox.createToolBox();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int randX=(rand.nextInt(15));
			int randY=(rand.nextInt(15));
	
			for(int index=0;index<16;index++) {
			if (budget<budgetValue) {
			meuble = toolBox.chooseMeuble(rand.nextInt(toolBox.getToolBox().size())); 
			meuble.setPosition(new Case(randX,randY));
			manager.putMeuble(meuble);
			budget += meuble.getPrix();
			budget += meuble.getPrix();
			randX=(rand.nextInt(26));
			randY=(rand.nextInt(15));
			}
			}
			
			
			
		}
		else {
			
			
		}
		dashboard.repaint();
	
		
	
		
		
			

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(HouseConfig.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

			
			dashboard.repaint();
			boxDashboard.repaint();
		}
	}
	private class KeyControls implements KeyListener {

		@Override
		public void keyPressed(KeyEvent event) {
			char keyChar = event.getKeyChar();
			switch (keyChar) {

			case 'q':
				manager.moveLeftMeuble();
				break;
			case 'd':
				manager.moveRightMeuble();
				break;
			case 'z':
				manager.moveTopMeuble();
				break;
			case 's':
				manager.moveBotMeuble();
				break;
			case 'p':
				manager.pivoter();
				break;
			case 'i':
				manager.putMeuble(manager.getMeuble());
				
				
				break;
			case 'r':
				manager.deleteMeuble();
				
				break;
				
			default:
				break;
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {

		}
	}

		
	
	private class MouseControls implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			int x = e.getX() ;
			int y = e.getY();

			Case bombPosition = dashboard.getWallPosition(x, y);
			if(SwingUtilities.isRightMouseButton(e)) {
				
				manager.deleteWall(bombPosition);
				System.out.println(bombPosition);
			}else {
				manager.putWall(bombPosition);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}



	
	
		
		
}
