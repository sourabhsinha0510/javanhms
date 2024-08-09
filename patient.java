import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
public class patient extends JFrame implements ActionListener,MouseListener,MouseMotionListener,KeyListener
{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
    Date dt=new Date();

    JLabel lblback = new JLabel(" ");
    
    JLabel lblhead         = new JLabel(" ");
    JLabel lblpatient      = new JLabel("Patient");
   

    JLabel lblback1    = new JLabel("");
    JLabel lblback1a   = new JLabel("");
    
    JLabel lbltxt1   = new JLabel("Patient Details");
  
    
    JLabel lblback2    = new JLabel("");
    JLabel lblback2a   = new JLabel("");


    
    JLabel lblpatientid    = new JLabel("Patient id");
    JLabel lblpatientname  = new JLabel("Patient_NAME :-");
    JLabel lbladress       = new JLabel("ADRESS :-");
    JLabel lblcontact      = new JLabel("CONTACT:- ");
    JLabel lbldate         = new JLabel("date ");
    JLabel lblgender       = new JLabel("Gender :- ");
    JLabel lblaadhar       = new JLabel("UID NUMBER :- ");
    JLabel lbldob       = new JLabel("DOB ");
   
    JLabel lblm = new JLabel("male ");
    JLabel lblf = new JLabel("female ");
    
    JTextField txpatientid       = new JTextField();
    JTextField txpatientname     = new JTextField();
    JTextField txadress          = new JTextField();
    JTextField txcontact         = new JTextField();
    JTextField txdate             = new JTextField();
    JTextField txgender          = new JTextField();
    JTextField txaadhar          = new JTextField();
    JTextField txdob          = new JTextField();
    
    ButtonGroup bg        = new ButtonGroup();
    JRadioButton rbmale   = new JRadioButton();
    JRadioButton rbfemale = new JRadioButton();

    Dimension di = Toolkit.getDefaultToolkit().getScreenSize();

    JButton bnew     = new JButton("New");
    JButton bsave    = new JButton("Save");
    JButton bsearch  = new JButton("Search");
    JButton bedit    = new JButton("Edit");
    JButton bexit    = new JButton("Exit");
    String str1,str2;

    public patient()
    {
        setVisible(true);
        setSize(900,600);
        setTitle("Patient");
        setLayout(null);
        setLocationRelativeTo(null);

        //head
        lblhead.setBounds(00,05,900,60);
        lblhead.setBackground(new Color (0,0,105));
        lblhead.setOpaque(true);

        lblpatient.setBounds(370,5,150,60);
        lblpatient.setFont(new Font("Arial",Font.BOLD,18));
        lblpatient.setForeground(new Color(255,255,255));


        //back1
        lblback1.setBounds(100,100,650,350);
        lblback1.setBackground(new Color(0,0,105));
        lblback1.setOpaque(true);

        lblback1a.setBounds(102,102,646,346);
        lblback1a.setBackground(new Color(200,206,211));
        lblback1a.setOpaque(true);

        lbltxt1.setBounds(110,80,130,40);
        lbltxt1.setFont(new Font("Arial",Font.BOLD,18));
        lbltxt1.setBackground(new Color(200,206,211));
        lbltxt1.setOpaque(true);

        lblpatientid.setBounds(140,150,110,30);
        lbladress.setBounds(140,210,110,30);
        lblcontact.setBounds(140,270,110,30);
        lbldate.setBounds(140,330,110,30);
      
        
        lblpatientname.setBounds(450,150,110,30);
        lblgender.setBounds(450,210,110,30);
        lbldob.setBounds(450,330,110,30);
        lblaadhar.setBounds(450,270,110,30);

        txpatientid.setBounds(240,150,110,30);
        txadress.setBounds(240,210,110,30);
        txcontact.setBounds(240,270,110,30);
        txdate.setBounds(240,330,110,30);
        
        txpatientname.setBounds(570,150,110,30);
        txdob.setBounds(570,330,110,30);
        txaadhar.setBounds(570,270,110,30);

        rbmale.setBounds(520,215,20,20);
        rbmale.setBackground(new Color(200,206,211));
        rbmale.setOpaque(true);

        lblm.setBounds(550,209,100,30);

        rbfemale.setBounds(610,215,20,20);
        rbfemale.setBackground(new Color(200,206,211));
        rbfemale.setOpaque(true);

        lblf.setBounds(650,209,100,30);
        
        //back2
        lblback2.setBounds(180,470,500,70);
        lblback2.setBackground(new Color(0,0,105));
        lblback2.setOpaque(true);
      
        lblback2a.setBounds(182,472,496,66);
        lblback2a.setBackground(new Color(200,206,211));
        lblback2a.setOpaque(true);

        bnew.setBounds(200,490,70,30);
        bnew.setBackground(new Color(0,0,105));
        bnew.setForeground(new Color(255,255,255));

        bsearch.setBounds(300,490,80,30);
        bsearch.setBackground(new Color(0,0,105));
        bsearch.setForeground(new Color(255,255,255));

        bsave.setBounds(400,490,70,30);
        bsave.setBackground(new Color(0,0,105));
        bsave.setForeground(new Color(255,255,255));

        bedit.setBounds(500,490,70,30);
        bedit.setBackground(new Color(0,0,105));
        bedit.setForeground(new Color(255,255,255));

        bexit.setBounds(590,490,70,30);
        bexit.setBackground(new Color(0,0,105));
        bexit.setForeground(new Color(255,255,255));

        //back
        lblback.setBounds(00,00,900,630);
        lblback.setBackground(new Color(200,206,211));
        lblback.setOpaque(true);


        txpatientid.setEditable(false);
        txdate.setEditable(false);

        txpatientname.addKeyListener(this);
        txcontact.addKeyListener(this);
        txaadhar.addKeyListener(this);


        bnew.addActionListener(this);
        bsave.addActionListener(this);
        bsearch.addActionListener(this);
        bedit.addActionListener(this);
        bexit.addActionListener(this);

        bnew.addMouseListener(this);
        bsave.addMouseListener(this);
        bsearch.addMouseListener(this);
        bedit.addMouseListener(this);
        bexit.addMouseListener(this);
        
        
        txdate.setText(sdf.format(dt));

         //lblhead
         add(lblpatient);
         add(lblhead);
 
         //back1
         add(lbltxt1);
 
         add(lblpatientid);
         add(lbladress);
         add(lblcontact);
         add(lbldate);
         
         
         add(lblpatientname);
         add(lblgender);
         add(lbldob);
         add(lblaadhar);
 
         add(txpatientid);
         add(txadress);
         add(txcontact);
         add(txdate);
         
         
         add(txpatientname);
         add(txdob);
         add(txaadhar);

         bg.add(rbmale);
         bg.add(rbfemale);
 
         add(rbmale);
         add(rbfemale);
         
         add(lblm);
         add(lblf);
 
  
         add(lblback1a);
         add(lblback1);
 
         //back2
         add(bnew);
         add(bsearch);
         add(bsave);
         add(bedit);
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
            String str = "select pat_id from keytbl";
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(str);
			      System.out.println("22222222222222");
            while(res.next())
            {
				      System.out.println("33333333333333");
                      txpatientid.setText("pat-"+res.getString(1));
            }
			      System.out.println("4444444");
            }
            catch(Exception ee)
            {
              System.out.print(ee);
            }
            
        }

        if(e.getSource() == bsearch)
        {
          String id = "";
          txpatientname.setEditable(false);
          txadress.setEditable(false);
          txaadhar.setEditable(false);
          txdob.setEditable(false);
          rbmale.setEnabled(false);
          rbfemale.setEnabled(false);
          try
          {
            id = txpatientid.getText();
            Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
			      String tpatid=JOptionPane.showInputDialog(null,"Enter patient id:");
            String str = "select * from pattbl where pat_id ='"+tpatid+"'";  
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(str);

            while(res.next())
            {
              txpatientid.setText(res.getString(1));
              txpatientname.setText(res.getString(2));
              txadress.setText(res.getString(3));
              txcontact.setText(res.getString(4));
              txaadhar.setText(res.getString(6));
              txdate.setText(res.getString(7));
              txdob.setText(res.getString(9));
              if(res.getString(5).equalsIgnoreCase("Male"))
              {
                rbmale.setSelected(true);
              }
              else
              {
                rbfemale.setSelected(true);
              }
              txcontact.setText(res.getString(5));
              
            }
          }
          catch(Exception ee)
          {
            System.out.print(ee);
          }
        }
        
       
        
        if(e.getSource() == bsave)
        {
          String gen="";
          try
          {
            if(txpatientid.getText().length()==0)
            {
              JOptionPane.showMessageDialog(null , "Please provide a patient id");
            }
            if(txpatientname.getText().length()==0)
            {
              JOptionPane.showMessageDialog(null , "Please provide a patient name");
            }
            if(txcontact.getText().length()==0)
            {
              JOptionPane.showMessageDialog(null , "Please provide a patient contact ");
            }
            if(txaadhar.getText().length()==0)
            {
              JOptionPane.showMessageDialog(null , "Please provide a patient uid ");
            }
            if(txadress.getText().length()==0)
            {
              JOptionPane.showMessageDialog(null , "Please provide a patient address ");
            }
            if(txdob.getText().length()==0)
            {
              JOptionPane.showMessageDialog(null , "Please provide a patient dob ");
            }
            else
            {

              Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
              String str = "INSERT INTO pattbl (pat_id,pat_name,pat_adress,pat_contact,pat_gender,pat_aadhar,p_date,status,p_dob,discharge_date)values(?,?,?,?,?,?,?,?,?,?)";
              PreparedStatement ps = con.prepareStatement(str);
              ps.setString(1, txpatientid.getText());
              ps.setString(2, txpatientname.getText());
              ps.setString(3, txadress.getText());
              
              ps.setString(4, txcontact.getText());
              if(rbmale.isSelected())
              {
                gen = "Male";
              }
              else
              {
                gen = "Female";
              }
              ps.setString(5, gen);
              ps.setString(6, txaadhar.getText());
              ps.setString(7, txdate.getText());
              ps.setString(8,"admitted");
              ps.setString(9,txdob.getText());
              System.out.println("hhvhhfh");
              ps.setString(10,"na");
            
              ps.executeUpdate();
              String str1 = "update keytbl set pat_id = pat_id + 1";
              Statement st1 = con.createStatement();
              st1.executeUpdate(str1);
              JOptionPane.showMessageDialog(null, "Record Saved Successfully");
            }
          }
        
          catch(Exception ee)
          {
            System.out.println(ee);
          }
        }

     //bnewclearform
     if(e.getSource()==bnew)
     {


      txpatientname.setText("");
      txadress.setText("");
      txcontact.setText("");
      txgender.setText("");
      txaadhar.setText("");
      bg.clearSelection();
      
                 
        
     }
         
      if(e.getSource()==bexit)
        {

             third obj2 = new third(str1,str2);
             this.dispose();
        }
    }

    public void focusGained(FocusEvent fe)
    {}

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
      if(m.getSource()==bsearch)
      {
        bsearch.setForeground(new Color(0, 0, 105));
        bsearch.setBackground(new Color(255,255,255));
      }
      if(m.getSource()==bedit)
      {
        bedit.setForeground(new Color(0, 0, 105));
        bedit.setBackground(new Color(255,255,255));
      }
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
      if(m.getSource()==bnew)
      {
        bnew.setForeground(new Color(255,255,255));
        bnew.setBackground(new Color(0, 0, 105));
      }
      if(m.getSource()==bsearch)
      {
        bsearch.setForeground(new Color(255,255,255));
        bsearch.setBackground(new Color(0, 0, 105));
      }
      if(m.getSource()==bedit)
      {
        bedit.setForeground(new Color(255,255,255));
        bedit.setBackground(new Color(0, 0, 105));
      }
      
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

    public void keyPressed(KeyEvent ke)
    {}

    public void keyReleased(KeyEvent ke)
    {
      int i;
      if(ke.getSource() == txpatientname)
      {
        String pname = txpatientname.getText();
       
        for(i=0 ; i<pname.length();i++)
        {
          char ch = pname.charAt(i);
          if(ch>='a'& ch<='z'||ch>='A' & ch<='Z'|| ch == ' ')
          {}
          else
          {
            pname = pname.substring(0,pname.length()-1);
            txpatientname.setText(pname);
          }

        }
        
      }
     
      if(ke.getSource() == txcontact)
      {
        String pcontact = txcontact.getText();
       
        for(i=0 ; i<pcontact.length();i++)
        {
          char ch = pcontact.charAt(i);
          if(ch>='0'& ch<='9')
          {}
          else
          {
            pcontact = pcontact.substring(0,pcontact.length()-1);
            txcontact.setText(pcontact);
          }

        }
        
      }
      
      if(ke.getSource() == txaadhar)
      {
        String puid = txaadhar.getText();
       
        for(i=0 ; i<puid.length();i++)
        {
          char ch = puid.charAt(i);
          if(ch>='0'& ch<='9')
          {}
          else
          {
            puid = puid.substring(0,puid.length()-1);
            txaadhar.setText(puid);
          }

        }
        
      }
    }
    
    public void keyTyped(KeyEvent ke)
    {}

  
   
    public static void main(String[] args) 
    {
        patient obj4 = new patient();
    }


}