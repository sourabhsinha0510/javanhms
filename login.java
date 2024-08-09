import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class login extends JFrame implements ActionListener,MouseListener,MouseMotionListener
{
    JLabel  lblback = new JLabel("");
    JLabel  lblimg = new JLabel(new ImageIcon("zimg3.jpg"));
    JLabel  lblhead = new JLabel("");    
    JLabel  lbltxt = new JLabel(" USER LOGIN");    
    JLabel l2 = new JLabel(" user_id");
    JLabel l3 = new JLabel("password");

    JLabel lblback1a =new JLabel("");
    JLabel lblback1 =new JLabel("");
   
    JTextField tx1 = new JTextField();
    JPasswordField tx2 = new JPasswordField();
    JButton bok = new JButton("login");
    JButton bcancel = new JButton("CANCEL");

    public login()
    {
        setVisible(true);
        setSize(900,500);
        setTitle("Login Page");
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        lblimg.setBounds(00,00,500,500 );

        lblhead.setBounds(502,05,400,70);
        lblhead.setBackground(new Color(00,00,105));
        lblhead.setOpaque(true);

        lbltxt.setBounds(650,20,250,40);
        lbltxt.setForeground(new Color(255,255,255));
        lbltxt.setFont(new Font("Arial", Font.BOLD,22));

        
        lblback.setBounds(00,00,900,500);
        lblback.setBackground(new Color(200,206,211));

        //back1
        lblback1.setBounds(550,110,300,250);
        lblback1.setBackground(new Color(0,0,105));
        lblback1.setOpaque(true);
    
        lblback1a.setBounds(552,112,296,246);
        lblback1a.setBackground(new Color(200,206,211));
        lblback1a.setOpaque(true);
         
        l2.setBounds(620,120,70,30);
        l3.setBounds(620,200,70,30);
        
        tx1.setBounds(620,150,170,30);
        tx2.setBounds(620,230,170,30);

        bok.setBounds(620,300,80,30);
        bok.setBackground(new Color(0,0,105));
        bok.setForeground(new Color(255,255,255));
        
        bcancel.setBounds(720,300,80,30);
        bcancel.setBackground(new Color(0,0,105));
        bcancel.setForeground(new Color(255,255,255));

        
 
        lblback.setOpaque(true);

        bok.addActionListener(this);
        bcancel.addActionListener(this);

        bok.addMouseListener(this);
        bcancel.addMouseListener(this);


        add(lblimg);
        add(lbltxt);
        add(lblhead);
        add(l2);
        add(l3);
        add(tx1);
        add(tx2);
        add(bok);
        add(bcancel);
        add(lblback1a);
        add(lblback1);
        add(lblback);

        repaint();
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == bok)
        {
            int flg=0;
            
			try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
				
				String str="select * from logintbl where usr='"+tx1.getText()+"' and pwd='"+tx2.getText()+"'";
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery(str);
				while(res.next())
				{
					flg=1;
					third obj2 = new third(tx1.getText(),tx2.getText());
					this.dispose();		
				}
				if(flg==0)
                {

					JOptionPane.showMessageDialog(null,"Invalid login");
                    tx1.setText("");
                    tx2.setText("");
                    tx1.requestFocus();
            
                    con.close();
                }
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
        }
        
        if(e.getSource() == bcancel)
        {
           this.dispose();
        }
    }

    public void mouseClicked(MouseEvent m)
    {}

    public void mouseDragged(MouseEvent m)
    {}
     
    public void mouseEntered(MouseEvent m)
    {
        
      
      if(m.getSource()==bok)
      {
        bok.setForeground(new Color(0, 0, 105));
        bok.setBackground(new Color(255,255,255));
      }
      if(m.getSource()==bcancel)
      {
        bcancel.setForeground(new Color(0, 0, 105));
        bcancel.setBackground(new Color(255,255,255));
      }

       
    }

    public void mouseExited(MouseEvent m)
    {
       
        
        if(m.getSource()==bok)
        {
            bok.setForeground(new Color(255,255,255));
            bok.setBackground(new Color(0, 0, 105));
        }
        if(m.getSource()==bcancel)
        {
            bcancel.setForeground(new Color(255,255,255));
            bcancel.setBackground(new Color(0, 0, 105));
        }

        
    }

    public void mouseMoved(MouseEvent m)
    {}

    public void mousePressed(MouseEvent m)
    {}

    public void mouseReleased(MouseEvent m)
    {}

 public static void main(String[] args) {
     login obj1=new login();
 }
}
