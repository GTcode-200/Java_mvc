
import java.awt.event.ActionListener;

import javax.swing.*;

public class View160 extends JFrame{

	private JTextField firstNumber  = new JTextField(5);
	private JTextField operator = new JTextField(1);
	private JTextField secondNumber = new JTextField(5);
	private JButton calculateButton = new JButton("Ans=");
	private JTextField calcSolution = new JTextField(5);
	private JLabel number=new JLabel("Enter the problem number to be viewed:");
	private JTextField no = new JTextField(3);
	private JButton view = new JButton("View");
	private JLabel lab=new JLabel("Ganesh Tarun S R\n PES1UG19CS160 \n MVC Assignment");
	private JTextField query = new JTextField(10);
	
	
	View160(){
		
		
		JPanel calcPanel = new JPanel(); //container class
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		
		
		
		calcPanel.add(firstNumber);
		calcPanel.add(operator);
		calcPanel.add(secondNumber);
		calcPanel.add(calculateButton);
		calcPanel.add(calcSolution);
		
		calcPanel.add(number);
		calcPanel.add(no);
		calcPanel.add(view);
		calcPanel.add(query);
		calcPanel.add(lab);
		
		this.add(calcPanel);
		
		
	}
	
	public float getFirstNumber(){
		
		return Float.parseFloat(firstNumber.getText());
		
	}
	
	public float getSecondNumber(){
		
		return Float.parseFloat(secondNumber.getText());
		
	}
	
	public int getQueryNumber(){
		
		return Integer.parseInt(no.getText());
		
	}
	
	public char getOperator()
	{
		return operator.getText().charAt(0);
	}
	
	public float getCalcSolution(){
		
		return Float.parseFloat(calcSolution.getText());
		
	}
	
	public void setCalcSolution(float solution){
		
		calcSolution.setText(Float.toString(solution));
		
	}
	
	
	void addCalculateListener(ActionListener listenForCalcButton){
		
		calculateButton.addActionListener(listenForCalcButton); //event is performed when button is clicked
		
	}
	
	void addRetriveListener(ActionListener listenForRetButton){	//attaching event to the calculate button
		
		view.addActionListener(listenForRetButton);
		
	}
	
	public void setQuery(String res){	
		
		query.setText(res);
		
	}
	
	
	void displayErrorMessage(String errorMessage){
		
		JOptionPane.showMessageDialog(this, errorMessage);
		
	}
	
}