import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import java.text.SimpleDateFormat;
import java.util.Date;
public class ward extends JFrame implements ActionListener,MouseListener,MouseMotionListener
{

     
    JLabel lblback = new JLabel(" ");
    
    JLabel lblhead         = new JLabel(" ");
    JLabel lblward         = new JLabel("Ward");
   

    JLabel lblback1    = new JLabel("");
    JLabel lblback1a   = new JLabel("");
    
    JLabel lbltxt1   = new JLabel("Ward Details");
  
    
    JLabel lblback2    = new JLabel("");
    JLabel lblback2a   = new JLabel("");

    JLabel lblward_box = new JLabel("WARD TYPE");
    JLabel lblward_bed = new JLabel("BED");
    JLabel lblward_charge = new JLabel("BED CHARGE");
   
    JTextField txtward_bed = new JTextField();
    JTextField txtward_charge = new JTextField();
    
    JComboBox wardbox = new JComboBox();

  
    JButton bsave = new JButton("SAVE");
    JButton bexit = new JButton("EXIT");

   
    String st1 , st2;

    public ward()
    {
        setVisible(true);
        setBackground(new Color(211,126,239));
        setSize(600,500);
        setLocationRelativeTo(null);  
        setLayout(null);
       
        wardbox.addItem("CCU");
        wardbox.addItem("GEN MALE");
        wardbox.addItem("GEN FEMALE");
        wardbox.addItem("ICU");


        //head
        lblhead.setBounds(00,05,900,60);
        lblhead.setBackground(new Color (0,0,105));
        lblhead.setOpaque(true);

        lblward.setBounds(270,5,150,60);
        lblward.setFont(new Font("Arial",Font.BOLD,18));
        lblward.setForeground(new Color(255,255,255));


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

        
       
        lblward_box.setBounds(180,140,110,30);
        lblward_bed.setBounds(180,240,110,30);
        lblward_charge.setBounds(180,290,110,30);
        

        wardbox.setBounds(280,140,110,30);
        
        txtward_bed.setBounds(280,240,110,30);
        txtward_charge.setBounds(280,290,110,30);
        
        
        //back2
        lblback2.setBounds(180,370,200,60);
        lblback2.setBackground(new Color(0,0,105));
        lblback2.setOpaque(true);
         
        lblback2a.setBounds(182,372,196,56);
        lblback2a.setBackground(new Color(200,206,211));
        lblback2a.setOpaque(true);

       

        bsave.setBounds(200,385,70,30);
        bsave.setBackground(new Color(0,0,105));
        bsave.setForeground(new Color(255,255,255));

        bexit.setBounds(300,384,70,30);
        bexit.setBackground(new Color(0,0,105));
        bexit.setForeground(new Color(255,255,255));

    

        //back
        lblback.setBounds(00,00,600,500);
        lblback.setBackground(new Color(200,206,211));
        lblback.setOpaque(true);


        bexit.addActionListener(this);
        bsave.addActionListener(this);
      
        bexit.addMouseListener(this);
        bsave.addMouseListener(this);
      
        wardbox.addActionListener(this);
        
        //head
        add(lblward);
        add(lblhead);
        //back1
        add(lbltxt1);

        add(lblward_box);
        add(lblward_bed);
        add(lblward_charge);

        add(wardbox);

        add(txtward_bed);
        add(txtward_charge);

        add(lblback1a);
        add(lblback1);

        //back2

        add(bsave);
        add(bexit);
        
        add(lblback2a);
        add(lblback2);

        
        //back
        add(lblback);

        repaint();
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
       
        if(e.getSource() == bexit)
        {
            third obj2 = new third(st1,st2);
            this.dispose();
        }
        
        if(e.getSource() == bsave)
        {
			int i;
            try
            {
              Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
              Statement st=con.createStatement();
			  for(i=1;i<=Integer.parseInt(txtward_bed.getText());i++)
			  {
				st.executeUpdate("update wardtbl set x"+i+"='A' where ward='"+wardbox.getSelectedItem()+"'");
			  }
              for(;i<=15;i++)
			  {
				st.executeUpdate("update wardtbl set x"+i+"='X' where ward='"+wardbox.getSelectedItem()+"'");
			  }
			  st.executeUpdate("update wardtbl set Charges='"+ txtward_charge.getText()+"' where ward='"+wardbox.getSelectedItem()+"'");
			  JOptionPane.showMessageDialog(null,"Beds Added");
              
              String a = wardbox.getSelectedItem().toString();
              int b = Integer.parseInt(txtward_bed.getText());
              
			}
            catch(Exception ee)
            {
                System.out.print(ee);
            }
        }
        }

    public void mouseClicked(MouseEvent m)
    {}

    public void mouseDragged(MouseEvent m)
    {}
     
    public void mouseEntered(MouseEvent m)
    {
        
      
      if(m.getSource()==bsave)
      {
        bsave.setForeground(new Color(0, 0, 105));
        bsave.setBackground(new Color(255,255,255));
      }
      if(m.getSource()==bexit)
      {
        bexit.setForeground(new Color(0, 0, 105));
        bexit.setBackground(new Color(255,255,255));
      }

       
    }

    public void mouseExited(MouseEvent m)
    {
       
        
        if(m.getSource()==bsave)
        {
            bsave.setForeground(new Color(255,255,255));
            bsave.setBackground(new Color(0, 0, 105));
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
        ward objw = new ward();
    }
}
