package sgt2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class CoffeeMakerGUI extends JFrame
{
	private Dimension monitorSize = Toolkit.getDefaultToolkit().getScreenSize();
	private double monitorWidth=monitorSize.getWidth();
	private double monitorHeight = monitorSize.getHeight();
	private JPanel panel;
	private JLabel price;
	private ArrayList<String> coffee = new ArrayList<String>();
	private ArrayList<String> shots = new ArrayList<String>();
	private JComboBox coffeeOptions;
	private JComboBox shotsOptions;
	private JCheckBox decaff;
	private JTextField name;
	private double total = 0.00;
	private double selectedCoffeePrice;
	private double shotPrice;
	private double decaffPrice;
	public CoffeeMakerGUI()
	{
		window();
		panel = new JPanel(new FlowLayout());
		windowWidgets(panel);
	}
	
	public void window()
	{
		monitorHeight = monitorHeight/14;
		setSize((int) ((int) monitorWidth/(1.5)),(int)monitorHeight);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		//creating a dropdown to select a type of coffee. 
		coffee.add("Expresso");
		coffee.add("Americano");
		coffee.add("Cappuccino");
		coffee.add("Macchiato");
		coffee.add("Mocha");
		coffee.add("Instant");
		
		// creating a dropdown to select shots
		shots.add("No extra shots");
		shots.add("1 extra shot");
		shots.add("2 extra shots");
		shots.add("Over 9000 extra shots");
	}
	
	public void windowWidgets(JPanel userPanel)
	{
		
		 add(userPanel);
		
	
		
		coffeeOptions =new JComboBox();
		for(int i=0;i<coffee.size();i++)
		{
			coffeeOptions.addItem(coffee.get(i));
		}
		
				
		coffeeOptions.addActionListener(new MyActionListeners());
		userPanel.add(coffeeOptions);
		
		
		
		shotsOptions = new JComboBox();
		for (int i=0;i<shots.size();i++)
		{
			shotsOptions.addItem(shots.get(i));
		}
		shotsOptions.addActionListener(new MyActionListeners());
		userPanel.add(shotsOptions);
		
		
		//Creating decaff checkBox
		decaff = new JCheckBox("Decaff");
		decaff.addActionListener(new MyActionListeners());
		userPanel.add(decaff);
		
		//creating a textfield for customer name
		name = new JTextField();
		name.setColumns(12);
		name.addCaretListener(new CaretListener()
		{
			public void caretUpdate(CaretEvent e)
			{
				//name option
				if (name.getText().equals("andrew"))
				{
					price.setText("Free");
				}
				else
				{
					price.setText("£"+total);
				}
				
			}
		});
		userPanel.add(name);
		
		//creating a price label
		
		price = new JLabel("£"+total);
		userPanel.add(price);
		
		JButton addNew = new JButton("+");
		addNew.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				monitorHeight = monitorHeight*1.75;
				setSize((int) ((int) monitorWidth/(1.5)),(int)monitorHeight);
				JPanel newPanel = new JPanel(new FlowLayout());
				windowWidgets(newPanel);
			}
		});
		userPanel.add(addNew);
		pack();
	}
	

	
	class MyActionListeners implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			// coffee option
			String coffeeSelected = coffeeOptions.getSelectedItem().toString();
			if (coffeeSelected.equals("Expresso"))
			{
				selectedCoffeePrice=1.80;
			}
			else if (coffeeSelected.equals("Americano"))
			{
				selectedCoffeePrice = 2.00;
			}
			else if  (coffeeSelected.equals("Cappuccino"))
			{
				selectedCoffeePrice = 2.10;
			}
			else if (coffeeSelected.equals("Macchiato"))
			{
				selectedCoffeePrice = 1.90;
			}
			else if (coffeeSelected.equals("Mocha"))
			{
				selectedCoffeePrice = 2.40;
			}
			else
			{
				selectedCoffeePrice = 0.80;
			}
			
			//shots option
			String shotsSelected = shotsOptions.getSelectedItem().toString();
			if (shotsSelected.equals("1 extra shot"))
			{
				shotPrice = 0.20;
			}
			else if(shotsSelected.equals("1 extra shot"))
			{
				shotPrice = 0.40;
			}
			else if(shotsSelected.equals("Over 9000 extra shots"))
			{
				shotPrice = 7.50;
			}
			else
			{
				shotPrice = 0.00;
			}
			
			//decaff option
			if (decaff.isSelected()==true)
			{
				decaffPrice = 20.00;
			}
			else
			{
				decaffPrice = 0.00;
			}
			
			total = selectedCoffeePrice + shotPrice + decaffPrice;
			
			//name option
			if (name.getText().equals("andrew"))
			{
				price.setText("Free");
			}
			else
			{
				price.setText("£"+total);
			}
		}
	}
	
}

