import java.sql.DriverManager;
import java.sql.*; 

public class Main160 {
    
    public static void main(String[] args) {
    	
    	
    	
    	
    	View160 theView = new View160(); //view obj
        
    	Model160 theModel = new Model160(theView); //model obj
        
        Controller160 theController = new Controller160(theView,theModel); // controller obj and calling ctt
        
        theView.setVisible(true);
        
    }
}