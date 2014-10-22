import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cal extends JPanel implements ActionListener
{	
	JTextField t;
	JTextField t2;
	JTextField t3;
	
	public Cal (JTextField t,JTextField t2,JTextField t3)
	{
		this.t=t;
		this.t2=t2;
		this.t3=t3;
	}
	
	public void actionPerformed(ActionEvent a) {
		
		
		
		
		try {
			
			 int ss= Integer.parseInt(t.getText());
			
			int ss2= Integer.parseInt(t2.getText());
			
		if(a.getActionCommand().equals("Add"))
		{
			if(t.getText().equals("")||t2.getText().equals(""))
			{
				JOptionPane.showConfirmDialog(null, "There are empty fields!");
			}
			else {
			int result=ss+ss2;
			
			
			t3.setText(""+result);
			}
			
		}
		if(a.getActionCommand().equals("Sub"))
		{
			
			if(t.getText().equals("")||t2.getText().equals(""))
			{
				JOptionPane.showConfirmDialog(null, "There are empty fields!");
			}
			else {
			
			int result= ss-ss2;
			
			
			t3.setText(""+result);
			}
		}
		if(a.getActionCommand().equals("Mul"))
		{
			if(t.getText().equals("")||t2.getText().equals(""))
			{
				JOptionPane.showConfirmDialog(null, "There are empty fields!");
			}
			else {
			
			int result= ss*ss2;
			
			
			t3.setText(""+result);
			}
		}
		if(a.getActionCommand().equals("Divide"))
		{
			if(t.getText().equals("")||t2.getText().equals(""))
			{
				JOptionPane.showConfirmDialog(null, "There are empty fields!");
			}
			else {
			if(ss2==0)
			{
				t3.setText("infinity");
			}
			else
			{
			
			int result= ss/ss2;
			
			
			
			t3.setText(""+result);
			}
			}
		}
		
		}
		catch(Exception e) {
			t.setText("");
			t2.setText("");
			
		}

		
		
	}

}
