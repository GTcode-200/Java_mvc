import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Model160 {
	
	private float calculationValue=0;
	private int ser_no=0;
	
	private View160 theView;
	String message="Invalid operator!";
	Model160(View160 theView)
	{
		this.theView=theView;
	}
	
	public void calculate(float firstNumber,char op, float secondNumber){
		if(op != '+' && op != '-' && op != '*' && op != '/')
			theView.displayErrorMessage(message);
		else
		{
		switch(op)
		{
		case '+':
		calculationValue = firstNumber + secondNumber;
		break;
		case '-':
		calculationValue = firstNumber - secondNumber;
		break;
		case '*':
		calculationValue = firstNumber * secondNumber;
		break;
		case '/':
		calculationValue = firstNumber / secondNumber;
		break;
		default:
		calculationValue = 0;
		}
		
		try{  
    		Class.forName("com.mysql.cj.jdbc.Driver");  
    		Connection con=DriverManager.getConnection(  
    		"jdbc:mysql://localhost:3306/MVC_PES1UG19CS160","root","Ganesh@456");  
    		Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    			    ResultSet.CONCUR_READ_ONLY);  
    		ResultSet rs=stmt.executeQuery("select * from pes1ug19cs160");
    		if(rs.last())
    			ser_no=rs.getInt("sno")+1;
    		else
    			ser_no=1;
    		stmt.executeUpdate("insert into pes1ug19cs160 values("+ser_no+","+firstNumber+",'"+op+"',"+secondNumber+","+calculationValue+");");
    		
    		//System.out.println(ser_no);
    		//System.out.println(rs.getInt("sno"));
    		/*while(rs.next())  
    		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  */
    		con.close();  
    		}catch(Exception e){ System.out.println(e);}
		}
		
		
		
	}
	
	public float getCalculationValue(){
		
		return calculationValue;
		
	}
	
	public String retrive(int pno) {
		
		String s="";
		
		try{  
    		Class.forName("com.mysql.cj.jdbc.Driver");  
    		Connection con=DriverManager.getConnection(  
    		"jdbc:mysql://localhost:3306/MVC_PES1UG19CS160","root","Ganesh@456");  
    		Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    			    ResultSet.CONCUR_READ_ONLY);  
    		ResultSet rs=stmt.executeQuery("select * from pes1ug19cs160 where sno="+pno);
    		if(rs.last())
    		{
    		for(int i=2;i<=5;i++)
    		{
    			s=s+rs.getString(i);
    			if(i==4)
    			{
    				s=s+"=";
    			}
    		}
    		System.out.print(s);
    		}
    		else
    			s="Range exceeds";
    		
    		//stmt.executeUpdate("insert into pes1ug19cs160 values("+ser_no+","+firstNumber+",'"+op+"',"+secondNumber+","+calculationValue+");");
    		
    		//System.out.println(ser_no);
    		//System.out.println(rs.getInt("sno"));
    		/*while(rs.next())  
    		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  */
    		con.close();  
    		}catch(Exception e){ System.out.println(e);}
		
		return s;
		
	}
	
}