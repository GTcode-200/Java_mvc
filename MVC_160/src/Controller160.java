import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Controller160 {
	
	private View160 theView;
	private Model160 theModel;
	
	public Controller160(View160 theView, Model160 theModel) {
		this.theView = theView;
		this.theModel = theModel;		
		this.theView.addCalculateListener(new CalculateListener()); //call addCalculateListener with CalculateListner obj as parameter
		this.theView.addRetriveListener(new RetriveListener());
	}
	
	class CalculateListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			float firstNumber, secondNumber = 0;
			char op='+';
			try{
			
				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();
				op=theView.getOperator();
				
				theModel.calculate(firstNumber,op, secondNumber);
				
				theView.setCalcSolution(theModel.getCalculationValue());
			
			}

			catch(NumberFormatException ex){
				
				System.out.println(ex);
				
				theView.displayErrorMessage("You Need to Enter 2 Integers");
				
			}
			
		}
		
	}
	
	class RetriveListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			int problem;
			try{
			
				problem = theView.getQueryNumber();
				
				//theModel.retrive(pno);
				
				theView.setQuery(theModel.retrive(problem));
			
			}

			catch(NumberFormatException ex){
				
				System.out.println(ex);
				
				theView.displayErrorMessage("Enter query number properly");
				
			}
	}
}
}
	
