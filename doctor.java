import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
public class doctor extends JFrame implements ActionListener,MouseListener,MouseMotionListener,KeyListener

{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
    Date dt=new Date();

    JLabel lblback = new JLabel(" ");
    
    JLabel lblhead = new JLabel(" ");
    JLabel lbldoctor      = new JLabel("DOCTOR");
   

    JLabel lblback1    = new JLabel("");
    JLabel lblback1a   = new JLabel("");
    
    JLabel lbltxt1   = new JLabel("Doctor Details");
  
    
    JLabel lblback2    = new JLabel("");
    JLabel lblback2a   = new JLabel("");

   
    JLabel lbldoctorid    = new JLabel("DOCTOR_ID ");
    JLabel lbldoctorname  = new JLabel("DOCTOR_NAME ");
    JLabel lbladress      = new JLabel("ADDRESS ");
    JLabel lblemail       = new JLabel("Email id ");
    JLabel lblcontact     = new JLabel("CONTACT");
    JLabel lbldob         = new JLabel("DOB(dd/mm/yyy)");
    JLabel lbldoj         = new JLabel("DOJ(dd/mm/yyy)");
    JLabel lblgender      = new JLabel("Gender  ");
    JLabel lblspecialized = new JLabel("Specialization ");
    JLabel lblaadhar      = new JLabel("UID NUMBER ");
    
    JLabel lblm = new JLabel("male ");
    JLabel lblf = new JLabel("female ");
    
    JTextField txdoctorid        = new JTextField();
    JTextField txdoctorname      = new JTextField();
    JTextField txadress          = new JTextField();
    JTextField txemail           = new JTextField();
    JTextField txcontact         = new JTextField();
    JTextField txdob             = new JTextField();
    JTextField txdoj             = new JTextField();
    JTextField txgender          = new JTextField();
    JTextField txspecialized     = new JTextField();
    JTextField txaadhar          = new JTextField();
    
    
    JRadioButton rbmale   = new JRadioButton();
    JRadioButton rbfemale = new JRadioButton();
    ButtonGroup bg = new ButtonGroup();

    JButton bnew     = new JButton("New");
    JButton bsave    = new JButton("Save");
    JButton bsearch  = new JButton("Search");
    JButton bedit    = new JButton("Edit");
    JButton bexit    = new JButton("Exit");
    String s1,s2;
    Dimension di  = Toolkit.getDefaultToolkit().getScreenSize();

    public doctor()
    {
        setVisible(true);
        setSize(900,600);
        setTitle("Doctor");
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        //head
        lblhead.setBounds(00,05,900,60);
        lblhead.setBackground(new Color (0,0,105));
        lblhead.setOpaque(true);

        lbldoctor.setBounds(370,5,150,60);
        lbldoctor.setFont(new Font("Arial",Font.BOLD,18));
        lbldoctor.setForeground(new Color(255,255,255));

        //back1
        lblback1.setBounds(100,100,650,350);
        lblback1.setBackground(new Color(0,0,105));
        lblback1.setOpaque(true);

        lblback1a.setBounds(102,102,646,346);
        lblback1a.setBackground(new Color(200,206,211));
        lblback1a.setOpaque(true);

        lbltxt1.setBounds(110,80,125,40);
        lbltxt1.setFont(new Font("Arial",Font.BOLD,18));
        lbltxt1.setBackground(new Color(200,206,211));
        lbltxt1.setOpaque(true);



        lbldoctorid.setBounds(140,150,110,30);
        lbladress.setBounds(140,210,110,30);
        lblcontact.setBounds(140,270,110,30);
        lbldoj.setBounds(140,330,110,30);
        lblspecialized.setBounds(140,390,110,30);
        
        lbldoctorname.setBounds(450,150,110,30);
        lblgender.setBounds(450,210,110,30);
        lblemail.setBounds(450,270,110,30);
        lbldob.setBounds(450,330,110,30);
        lblaadhar.setBounds(450,390,110,30);

        txdoctorid.setBounds(240,150,110,30);
        txadress.setBounds(240,210,110,30);
        txcontact.setBounds(240,270,110,30);
        txdoj.setBounds(240,330,110,30);
        txspecialized.setBounds(240,390,110,30);
        
        txdoctorname.setBounds(570,150,110,30);
        txemail.setBounds(570,270,110,30);
        txdob.setBounds(570,330,110,30);
        txaadhar.setBounds(570,390,110,30);

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
 
        bnew.addActionListener(this);
        bsave.addActionListener(this);
        bsearch.addActionListener(this);
        bedit.addActionListener(this);
        bexit.addActionListener(this);
        
        txdoctorname.addKeyListener(this);
        txcontact.addKeyListener(this);
        txspecialized.addKeyListener(this);
        txaadhar.addKeyListener(this);
        
        bnew.addMouseListener(this);
        bsave.addMouseListener(this);
        bsearch.addMouseListener(this);
        bedit.addMouseListener(this);
        bexit.addMouseListener(this);
        
        
        txdoctorid.setEditable(false);
        txdoj.setEditable(false);
        
        txdoj.setText(sdf.format(dt));

        //lblhead
        add(lbldoctor);
        add(lblhead);

        //back1
        add(lbltxt1);

        add(lbldoctorid);
        add(lbladress);
        add(lblcontact);
        add(lbldoj);
        add(lblspecialized);
        
        add(lbldoctorname);
        add(lblgender);
        add(lblemail);
        add(lbldob);
        add(lblaadhar);

        add(txdoctorid);
        add(txadress);
        add(txcontact);
        add(txdoj);
        add(txspecialized);

        add(txdoctorname);
        add(txemail);
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
            String str = "select doctor_id from keytbl";
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(str);
			      System.out.println("22222222222222");
            while(res.next())
            {
				      System.out.println("33333333333333");
              txdoctorid.setText("Doc/"+res.getString(1));
            }
			      System.out.println("4444444");
            }
            catch(Exception ee)
            {
              System.out.print(ee);
            }
            
        }
         if(e.getSource() == bedit)
        {
          txdoctorid.setEditable(false);
          txdoctorname.setEditable(true);
          txdob.setEditable(true);
          txspecialized.setEditable(true);
          txdoj.setEditable(true);
          txaadhar.setEditable(true);
          txcontact.setEditable(true);
          txemail.setEditable(true);
          txadress.setEditable(true);
          rbmale.setEnabled(true);
          rbfemale.setEnabled(true);
        }

        
        if(e.getSource() == bsearch)
        {
          txdoctorid.setEditable(false);
          txdoctorname.setEditable(false);
          txdob.setEditable(false);
          txspecialized.setEditable(false);
          txdoj.setEditable(false);
          txaadhar.setEditable(false);
          txcontact.setEditable(false);
          txemail.setEditable(false);
          txadress.setEditable(false);
          rbmale.setEnabled(false);
          rbfemale.setEnabled(false);


          String id = "";
          try
          {
            id = txdoctorid.getText();
            Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
			      String tdocid=JOptionPane.showInputDialog(null,"Enter doctor id:");
            String str = "select * from doctbl where doctor_id ='"+tdocid+"'";  
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(str);

            while(res.next())
            {
              txdoctorid.setText(res.getString(1));
              txdoctorname.setText(res.getString(2));
              txadress.setText(res.getString(3));
              txemail.setText(res.getString(4));
              txdoj.setText(res.getString(5));
              txaadhar.setText(res.getString(9));
              if(res.getString(7).equalsIgnoreCase("Male"))
              {
                rbmale.setSelected(true);
              }
              else
              {
                rbfemale.setSelected(true);
              }
              txcontact.setText(res.getString(6));
              txspecialized.setText(res.getString(8));
              txdob.setText(res.getString(10));
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
            if(txdoctorid.getText().length()==0)
            {
              
              JOptionPane.showMessageDialog(null , "Please provide a Doctor id");
            }

            if(txdoctorname.getText().length()==0)
            {
              
              JOptionPane.showMessageDialog(null , "Please provide a Doctor name");
            }

            if(txcontact.getText().length()==0)
            {
              
              JOptionPane.showMessageDialog(null , "Please provide a Doctor Contact");
            }

            if(txaadhar.getText().length()==0)
            {
              
              JOptionPane.showMessageDialog(null , "Please provide a Doctor UID");
            }

            if(txspecialized.getText().length()==0)
            {
              
              JOptionPane.showMessageDialog(null , "Please provide a Doctor Specialization");
            }
            if(txdob.getText().length()==0)
            {
              
              JOptionPane.showMessageDialog(null , "Please provide a Doctor UID");
            }
            if(txemail.getText().length()==0)
            {
              
              JOptionPane.showMessageDialog(null , "Please provide a Doctor email");
            }
            else
            {

              Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
              String str = "INSERT INTO doctbl (doctor_id,doctor_name,doc_adress,doc_email,doc_doj,doc_contact,doc_gender,doc_specialised,doc_aadhar,doc_dob)values(?,?,?,?,?,?,?,?,?,?)";
              PreparedStatement ps = con.prepareStatement(str);
              ps.setString(1, txdoctorid.getText());
              ps.setString(2, txdoctorname.getText());
              ps.setString(3, txadress.getText());
              ps.setString(4, txemail.getText());
              ps.setString(5, txdoj.getText());
              ps.setString(6, txcontact.getText());
              if(rbmale.isSelected())
              {
                gen = "Male";
              }
              else
              {
                gen = "Female";
              }
              ps.setString(7, gen);
              ps.setString(9, txaadhar.getText());
              ps.setString(8, txspecialized.getText());
              ps.setString(10, txdob.getText());
              ps.executeUpdate();
              String str1 = "update keytbl set doctor_id = doctor_id + 1";
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
    
        if(e.getSource() == bexit)
        {
          third obj2 = new third(s1,s2);
          this.dispose();
            
        }

        //bnewclearform
        if(e.getSource()==bnew)
        {
          
          txdoctorname .setText("");
          txadress.setText("");
          txemail.setText("");
          txcontact.setText("");
          txdob.setText("");
          txspecialized.setText("");
          txaadhar.setText("");
          bg.clearSelection();
        }

        if(e.getSource() == bedit)
        {

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
      if(ke.getSource() == txdoctorname)
      {
        String dname = txdoctorname.getText();
       
        for(i=0 ; i<dname.length();i++)
        {
          char ch = dname.charAt(i);
          if(ch>='a'& ch<='z'||ch>='A' & ch<='Z'|| ch == ' ')
          {}
          else
          {
            dname = dname.substring(0,dname.length()-1);
            txdoctorname.setText(dname);
          }

        }
        
      }
      
      if(ke.getSource() == txspecialized)
      {
        String dspl = txspecialized.getText();
       
        for(i=0 ; i<dspl.length();i++)
        {
          char ch = dspl.charAt(i);
          if(ch>='a'& ch<='z'||ch>='A' & ch<='Z'|| ch == ' ')
          {}
          else
          {
            dspl = dspl.substring(0,dspl.length()-1);
            txspecialized.setText(dspl);
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
        doctor obj3 = new doctor();
        
    }


}