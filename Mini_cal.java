import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Mini_cal extends JFrame {
	public JTextField t;
	public JTextField t2;
	public JTextField t3;
	public Mini_cal()
	{
		
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		p1.setLayout(new GridLayout(1,6));
		p2.setLayout(new GridLayout(1,4));
		JLabel l=new JLabel("Number 1->");
		JLabel l2=new JLabel("Number 2->");
		JLabel l3=new JLabel("Result:->");
		
		
		JTextField t=new JTextField ("");
		JTextField t2=new JTextField ("");
		JTextField t3=new JTextField ("");
		t3.setEditable(false);
		
		Cal action=new Cal(t,t2,t3);
		JButton b=new JButton("Add");
		b.addActionListener(action);
		JButton b2=new JButton("Sub");
		b2.addActionListener(action);
		JButton b3=new JButton("Mul");
		b3.addActionListener(action);
		JButton b4=new JButton("Divide");
		b4.addActionListener(action);
		
		
		
		p1.add(l);
		p1.add(t);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		p1.add(t3);
		
		p2.add(b);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		c.add(p1,BorderLayout.NORTH);
		c.add(p2,BorderLayout.SOUTH);
		
		
		
		
		
	}

	
	public static void main(String[] args) {
		Mini_cal m=new Mini_cal();
		
		m.setSize(500, 100);
		m.setTitle("Mini Calculator");
		m.setVisible(true);

		
	}

}
