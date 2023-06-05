package gui.acceuil;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import config.HouseConfig;
import engine.map.Case;
import engine.map.Salon;
import engine.process.BoxElementManager;
import engine.process.MapBuilder;
import engine.process.MobileElementManager;
import gui.game.MainGUI;
import gui.game.MapDisplay;
import gui.game.Paint;
import gui.game.SpeedGUI;






public class AcceuilGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;



	private final static Dimension preferredSize = new Dimension(HouseConfig.WINDOW_WIDTH_ACCUEIL,HouseConfig.WINDOW_HEIGHT_ACCUEIL);


	Container contentPane = getContentPane();
	
	
	private JPanel control = new JPanel();
	
	
	
	private JLabel titre = new JLabel("MY DREAM HOUSE");
	
	private static Font font = new Font(Font.SERIF, Font.PLAIN, 20);

	private JButton createDH = new JButton("create Dream House");
	
	private JButton speedH = new JButton("Speed House");
	
	private JButton help = new JButton("help");
	
	private static Color buttonColor = new Color(250, 250, 230);
	
	private static Color controlColor = new Color(250, 250, 200);
	
	private static Color mapColor = new Color(250, 250, 230);
	
	private int  longueur;
	private int largeur;
	
	private int budgetValue = 1000 ;
	
	private String style="classique";

	public AcceuilGUI(String title) {
		super(title);
		init();
		
		
	}

	private void init() {
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		control.setLayout(new FlowLayout(FlowLayout.CENTER));
		control.setLayout(null);
		control.setPreferredSize(preferredSize);
		control.setBackground(controlColor);
		
		contentPane.add(control);
		
		
		// Affichage page pricipale
		
		titre.setFont(font);
		
		titre.setBounds(250, 20, 200, 80);
		control.add(titre);
		
		
		JLabel dim = new JLabel("choisir une dimension");
		dim.setBackground(controlColor);
		dim.setBounds(500, 80, 200, 30);
		control.add(dim);
		
		
		
		JTextField min = new JTextField();
		min.setText("0");
		min.setBounds(480, 120, 96, 19);
		control.add(min);
		
		
		JTextField max = new JTextField();
		max.setText("0");
		max.setBounds(580, 120, 96, 19);
		control.add(max);
		
		
		
		
		createDH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				longueur = Integer.valueOf(min.getText());
				largeur = Integer.valueOf(min.getText());
			
				if(100 < longueur && longueur < 3000  && 100 < largeur && largeur < 3000 ) {
					MainGUI gameMainGUI = new MainGUI("create MY DREAM HOUSE",longueur,largeur);

					Thread gameThread = new Thread(gameMainGUI);
					gameThread.start();
				}
				else {
				MainGUI gameMainGUI = new MainGUI("create MY DREAM HOUSE");

				Thread gameThread = new Thread(gameMainGUI);
				gameThread.start();
				}
			}
		});
		
		createDH.setBounds(250, 105, 200, 50);
		createDH.setBackground(buttonColor);
		control.add(createDH);
		
		//affichage speed run
		
		JLabel title = new JLabel("CREATE YOUR SPEEEDHOUSE");
		title.setBackground(controlColor);
		title.setBounds(250, 50, 400, 50);
		title.setFont(font);
		
		
		JLabel sol = new JLabel("choisir le style de votre sol");
		sol.setBackground(controlColor);
		sol.setBounds(10, 130, 200, 30);
		
		JLabel meuble = new JLabel("choisir le style des meubles");
		meuble.setBackground(controlColor);
		meuble.setBounds(10, 250, 200, 30);
		
		JLabel budget = new JLabel("choisir votre budget");
		budget.setBackground(controlColor);
		budget.setBounds(10, 360, 200, 30);
		
		//button style sol
		ButtonGroup bouttonGoup = new ButtonGroup();
		JRadioButton classique = new JRadioButton("classique");
		JRadioButton comtemporain = new JRadioButton("comtemporain");
		JRadioButton moderne = new JRadioButton("moderne");
		classique.setSelected(false);
		comtemporain.setSelected(false);	
		moderne.setSelected(false);
		classique.setBackground(buttonColor);
		comtemporain.setBackground(buttonColor);
		moderne.setBackground(buttonColor);
		
		classique.setBounds(10, 160, 200, 30);
		comtemporain.setBounds(10, 190, 200, 30);
		moderne.setBounds(10, 220, 200, 30);
		
		bouttonGoup.add(classique);
		bouttonGoup.add(comtemporain);
		bouttonGoup.add(moderne);
		classique.setSelected(true);
		
		//button style meuble
		ButtonGroup bouttonGoup1 = new ButtonGroup();
		JRadioButton classique1 = new JRadioButton("classique");
		JRadioButton comtemporain1 = new JRadioButton("comtemporain");
		JRadioButton moderne1 = new JRadioButton("moderne");
		classique1.setSelected(false);
		comtemporain1.setSelected(false);	
		moderne1.setSelected(false);
		classique1.setBackground(buttonColor);
		comtemporain1.setBackground(buttonColor);
		moderne1.setBackground(buttonColor);
		
		classique1.setBounds(10, 280, 200, 30);
		comtemporain1.setBounds(10, 310, 200, 30);
		moderne1.setBounds(10, 340, 200, 30);
		
		bouttonGoup1.add(classique1);
		bouttonGoup1.add(comtemporain1);
		bouttonGoup1.add(moderne1);
		classique1.setSelected(true);
		
		JSlider prix = new JSlider();
		prix.setValue(1000);
		prix.setMaximum(100000);
		prix.setMinimum(1000);
		prix.setBounds(10, 390, 200, 30);
		
		JLabel mini = new JLabel("1000");
		mini.setBackground(controlColor);
		mini.setBounds(10, 420, 200, 30);
		
		JLabel maxi = new JLabel("100000");
		maxi.setBackground(controlColor);
		maxi.setBounds(200, 420, 200, 30);
		
		 
		
		JButton ok = new JButton("OK");
		ok.setBounds(250, 500, 96, 19);
		ok.setBackground(buttonColor);
		
		JButton back = new JButton("BACK");
		back.setBounds(20, 20, 96, 19);
		back.setBackground(buttonColor);
		
		classique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton source = (JRadioButton)e.getSource();
				if (source.isSelected()) {
					mapColor = new Color(250, 250, 230);
				
				}
				if (!source.isSelected()) {
					
								
				}
				
			}
		});
		
		comtemporain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton source = (JRadioButton)e.getSource();
				if (source.isSelected()) {
					mapColor = (new Color(205, 122, 40));
					
				}
				if (!source.isSelected()) {
					
								
				}
			
			}
		});
		
		moderne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton source = (JRadioButton)e.getSource();
				if (source.isSelected()) {
					mapColor =(new Color(189, 58, 48));
				
				}
				if (!source.isSelected()) {
					
					
				}
				
			}
		});
		
		classique1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				style="classique";
			}
		});
		
		comtemporain1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				style="comtemporain";
			
			}
		});
		
		moderne1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				style="moderne";
				
			}
		});
		
		
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				budgetValue = prix.getValue();
				
				SpeedGUI gameMainGUI = new SpeedGUI("create MY DREAM HOUSE",mapColor,style,budgetValue);

				Thread gameThread = new Thread(gameMainGUI);
				gameThread.start();
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
		
				AcceuilGUI gameMainGUI = new AcceuilGUI("MY DREAM HOUSE");

				Thread gameThread = new Thread(gameMainGUI);
				gameThread.start();
				
				}
		});
		
		
		speedH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.removeAll();
				control.repaint();
				
				control.add(title);
				control.add(classique);
				control.add(comtemporain);
				control.add(moderne);
				control.add(sol);
				control.add(classique1);
				control.add(comtemporain1);
				control.add(moderne1);
				control.add(meuble);
				control.add(budget);
				control.add(prix);
				control.add(mini);
				control.add(maxi);
				control.add(ok);
				control.add(back);
				
				
				
			}
		});
		speedH.setBounds(250, 205, 200, 50);
		speedH.setBackground(buttonColor);
		control.add(speedH);
		
		
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url_open ="http://decoration.alwaysdata.net";
				try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		help.setBounds(250, 305, 200, 50);
		help.setBackground(buttonColor);
		control.add(help);
	
	
	
		

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

			
		
		
		}
	}
	


	
	

}



