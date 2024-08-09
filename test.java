import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import org.w3c.dom.events.EventException;

import java.text.SimpleDateFormat;
import java.util.Date;
public class test extends JFrame implements ActionListener,MouseListener,MouseMotionListener
{

    
    JLabel lblback = new JLabel(" ");
    
    JLabel lblhead         = new JLabel(" ");
    JLabel lbltest           = new JLabel("TEST");
  
    JLabel lblback1    = new JLabel("");
    JLabel lblback1a   = new JLabel("");
    
    JLabel lbltxt1   = new JLabel("Test Details");
  
    JLabel lblback2    = new JLabel("");
    JLabel lblback2a   = new JLabel("");

    JLabel lbltestid         = new JLabel("Test id :-");
    JLabel lbltestname       = new JLabel("Test NAME :-");
    JLabel lbltestcharge     = new JLabel("testcharge :-");
    JLabel lbltestdetails    = new JLabel("test Details :-");

    JTextField txtestid         = new JTextField();
    JTextField txtestname       = new JTextField();
    JTextField txtestcharge     = new JTextField();
    JTextField txtestdetails    = new JTextField();

    JButton bnew      = new JButton("New");
    JButton bnext     = new JButton("Next");
    JButton bexit     = new JButton("Exit");

    int ctr;
    String st1,st2;

    public test()
    {
        setVisible(true);
        setSize(600,500);
        setTitle("Test");
        setLayout(null);
        setLocationRelativeTo(null);

        //head
        lblhead.setBounds(00,05,900,60);
        lblhead.setBackground(new Color (0,0,105));
        lblhead.setOpaque(true);

        lbltest.setBounds(270,5,150,60);
        lbltest.setFont(new Font("Arial",Font.BOLD,18));
        lbltest.setForeground(new Color(255,255,255));


        //back1
        lblback1.setBounds(60,100,450,250);
        lblback1.setBackground(new Color(0,0,105));
        lblback1.setOpaque(true);
    
        lblback1a.setBounds(62,102,446,246);
        lblback1a.setBackground(new Color(200,206,211));
        lblback1a.setOpaque(true);

        lbltxt1.setBounds(70,80,115,40);
        lbltxt1.setFont(new Font("Arial",Font.BOLD,18));
        lbltxt1.setBackground(new Color(200,206,211));
        lbltxt1.setOpaque(true);

        
       
        lbltestid.setBounds(180,140,110,30);
        lbltestname.setBounds(180,190,110,30);
        lbltestcharge.setBounds(180,240,110,30);
        lbltestdetails.setBounds(180,290,110,30);

        txtestid.setBounds(280,140,110,30);
        txtestname.setBounds(280,190,110,30);
        txtestcharge.setBounds(280,240,110,30);
        txtestdetails.setBounds(280,290,110,30);

        //back2
        lblback2.setBounds(110,370,350,60);
        lblback2.setBackground(new Color(0,0,105));
        lblback2.setOpaque(true);
         
        lblback2a.setBounds(112,372,346,56);
        lblback2a.setBackground(new Color(200,206,211));
        lblback2a.setOpaque(true);

        bnew.setBounds(150,385,70,30);
        bnew.setBackground(new Color(0,0,105));
        bnew.setForeground(new Color(255,255,255));

        bnext.setBounds(250,385,70,30);
        bnext.setBackground(new Color(0,0,105));
        bnext.setForeground(new Color(255,255,255));

        bexit.setBounds(350,384,70,30);
        bexit.setBackground(new Color(0,0,105));
        bexit.setForeground(new Color(255,255,255));

        //back
        lblback.setBounds(00,00,600,500);
        lblback.setBackground(new Color(200,206,211));
        lblback.setOpaque(true);

        txtestid.setEditable(false);



      
        bexit.addActionListener(this);
        bnext.addActionListener(this);
        bnew.addActionListener(this);

        bexit.addMouseListener(this);
        bnext.addMouseListener(this);
        bnew.addMouseListener(this);
        
        //head
        add(lbltest);
        add(lblhead);
        //back1
        add(lbltxt1);

        add(lbltestid);
        add(lbltestname);
        add(lbltestcharge);
        add(lbltestdetails);

        add(txtestid);
        add(txtestname);
        add(txtestcharge);
        add(txtestdetails);


        add(lblback1a);
        add(lblback1);
        
        //back2
        add(bnew);
        add(bnext);
        add(bexit);

        add(lblback2a);
        add(lblback2);
        
        //back
        add(lblback);
        repaint();
    }

    
    public void actionPerformed(ActionEvent e)
    {
       
        if(e.getSource() == bnew)
        {
            try
          {
			      System.out.println("111111111");
            Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
            String str = "select tst_id from keytbl";
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(str);
			      System.out.println("22222222222222");
            while(res.next())
            {
				      System.out.println("33333333333333");
                      txtestid.setText("tst/"+res.getString(1));
            }
			      System.out.println("4444444");
            }
            catch(Exception ee)
            {
              System.out.print(ee);
            }
            
        }

        if(e.getSource()==bexit)
        {
            third obj2 = new third(st1,st2);
            this.dispose(); 
        }
        

        if(e.getSource() == bnext)
        {
          if(txtestid.getText().equals("")|| txtestcharge.getText().equals("")|| txtestdetails.getText().equals("")|| txtestname.getText().equals(""))
          {
            JOptionPane.showMessageDialog(null,"Complete all details");
          }
          else
          {
            
            if(ctr>0)
            {
              JOptionPane.showMessageDialog(null,"test exists");
            }
            else
            {
              try
              {
                int a =  Integer.parseInt(txtestcharge.getText());
                int b =  Integer.parseInt(txtestdetails.getText());
                if(b>7)
                {
                  JOptionPane.showMessageDialog(null,"parameter cannot be more than 7");
                }
                else
                {
                  test_parameters obj2 = new test_parameters(txtestid.getText(), txtestcharge.getText(),txtestname.getText(), Integer.parseInt(txtestdetails.getText()));
                }
              }
              catch(Exception ee)
              {
                System.out.print(ee);
              }
              this.dispose();
              JOptionPane.showMessageDialog(null,"Enter values in number format");
            }
          }
        }
    }

    public void mouseClicked(MouseEvent m)
    {}

    public void mouseDragged(MouseEvent m)
    {}
     
    public void mouseEntered(MouseEvent m)
    {
        
      if(m.getSource()==bnew)
      {
        bnew.setForeground(new Color(0, 0, 105));
        bnew.setBackground(new Color(255,255,255));
      }
      if(m.getSource()==bnext)
      {
        bnext.setForeground(new Color(0, 0, 105));
        bnext.setBackground(new Color(255,255,255));
      }
      if(m.getSource()==bexit)
      {
        bexit.setForeground(new Color(0, 0, 105));
        bexit.setBackground(new Color(255,255,255));
      }

       
    }

    public void mouseExited(MouseEvent m)
    {
        if(m.getSource()==bnew)
        {
            bnew.setForeground(new Color(255,255,255));
            bnew.setBackground(new Color(0, 0, 105));
        }
        
        if(m.getSource()==bnext)
        {
            bnext.setForeground(new Color(255,255,255));
            bnext.setBackground(new Color(0, 0, 105));
        }
        if(m.getSource()==bexit)
        {
            bexit.setForeground(new Color(255,255,255));
            bexit.setBackground(new Color(0, 0, 105));
        }

        
    }

    public void mouseMoved(MouseEvent m)
    {}

    public void mousePressed(MouseEvent m)
    {}

    public void mouseReleased(MouseEvent m)
    {}


   
    public static void main(String[] args) 
    {
        test obj5 = new test();
    }

}