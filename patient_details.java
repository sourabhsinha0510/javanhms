import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
public class patient_details extends JFrame implements ActionListener,MouseListener,MouseMotionListener
{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
    Date dt=new Date();
   
    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MMM/yyyy");
    Date dt1 = new Date();

    JLabel lblback = new JLabel(" ");
    
    JLabel lblhead         = new JLabel(" ");
    JLabel lbladmit      = new JLabel("Admit");
    

    JLabel lblback1    = new JLabel("");
    JLabel lblback1a   = new JLabel("");
    
    JLabel lbltxt1   = new JLabel("Patient Details");
  
    
    JLabel lblback2    = new JLabel("");
    JLabel lblback2a   = new JLabel("");
    
        


    JLabel lbladmission      = new JLabel("Admission.id");
    JLabel lblpatientid      = new JLabel("Patient id");
    JLabel lblpatientname    = new JLabel("Patient_NAME :-");
    JLabel lbladress         = new JLabel("ADRESS :-");
    JLabel lblcontact        = new JLabel("CONTACT:- ");
    JLabel lbldate           = new JLabel("DATE");
    JLabel lblgender         = new JLabel("Gender :- ");
    JLabel lblaadhar         = new JLabel("UID NUMBER :- ");
    JLabel lblbed            = new JLabel("BED allocation :- ");
    
    JLabel lblm = new JLabel("male ");
    JLabel lblf = new JLabel("female ");
    
   
    JTextField txadmission       = new JTextField();
    JTextField txpatientid       = new JTextField();
    JTextField txpatientname     = new JTextField();
    JTextField txadress          = new JTextField();
    JTextField txcontact         = new JTextField();
    JTextField txdate            = new JTextField();
    JTextField txgender          = new JTextField();
    JTextField txaadhar          = new JTextField();
    JTextField txbed             = new JTextField();
    
    
    ButtonGroup bg        = new ButtonGroup();
    JRadioButton rbmale   = new JRadioButton();
    JRadioButton rbfemale = new JRadioButton();

    JButton bnew     = new JButton("New");
    JButton bsave    = new JButton("Save");
    JButton bsearch  = new JButton("Search");
    JButton bedit    = new JButton("Edit");
    JButton bexit    = new JButton("Exit");

    Dimension di = Toolkit.getDefaultToolkit().getScreenSize();
    String str1,str2;

   

    public patient_details(String txt)
    {

      setVisible(true);
      setSize(900,600);
      setTitle("Admit");
      setLayout(null);
      setLocationRelativeTo(null);

      //head
      lblhead.setBounds(00,05,900,60);
      lblhead.setBackground(new Color (0,0,105));
      lblhead.setOpaque(true);
 
      lbladmit.setBounds(410,5,150,60);
      lbladmit.setFont(new Font("Arial",Font.BOLD,18));
      lbladmit.setForeground(new Color(255,255,255));
 
 
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

      lbladmission.setBounds(300,150,110,30);
      txadmission.setBounds(390,150,110,30);
 
      lblpatientid.setBounds(140,210,110,30);
      lbladress.setBounds(140,270,110,30);
      lblcontact.setBounds(140,330,110,30);
      lbldate.setBounds(140,390,110,30);
       
      
      lblpatientname.setBounds(450,210,110,30);
      lblgender.setBounds(450,270,110,30);
      lblaadhar.setBounds(450,330,110,30);
      lblbed.setBounds(450,390,110,30);
 
      txpatientid.setBounds(240,210,110,30);
      txadress.setBounds(240,270,110,30);
      txcontact.setBounds(240,330,110,30);
      txdate.setBounds(240,390,110,30);
      
      txpatientname.setBounds(570,210,110,30);
      txaadhar.setBounds(570,330,110,30);
      txbed.setBounds(570,390,110,30);
 
      rbmale.setBounds(520,275,20,20);
      rbmale.setBackground(new Color(200,206,211));
      rbmale.setOpaque(true);
 
      lblm.setBounds(550,269,100,30);
 
      rbfemale.setBounds(610,275,20,20);
      rbfemale.setBackground(new Color(200,206,211));
      rbfemale.setOpaque(true);
 
      lblf.setBounds(650,269,100,30);
      
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
 

      txadmission.setEditable(false);
      txpatientid.setEditable(false);
      txpatientname.setEditable(false);
      txcontact.setEditable(false);
      txadress.setEditable(false);
      txdate.setEditable(false);
      txaadhar.setEditable(false);
      txbed.setEditable(false);
      
      txbed.setText(txt);
     
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
     add(lbladmit);
     add(lblhead);
     //back1
     add(lbltxt1);
     add(lblpatientid);
     add(lbladress);
     add(lblcontact);
     add(lbldate);
    
     add(lbladmission);
     add(txadmission);
     
     
     
     add(lblpatientname);
     add(lblgender);
     add(lblbed);
     
     add(lblaadhar);
     add(txpatientid);
     add(txadress);
     add(txcontact);
     add(txdate);
     
     
     add(txpatientname);
     add(txaadhar);
     add(txbed);

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
            String dat=txdate.getText();
            char tdat = dat.charAt(dat.length()-1);
            String dt[]=dat.split("/");
            String yr =  dt[2];
          
      
          try
          {
			      System.out.println("111111111");
            Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
            String str = "select admission_id from keytbl";
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(str);
            
			      System.out.println("22222222222222");
            while(res.next())
            {
				      System.out.println("33333333333333");
              txadmission.setText("admn-"+res.getString(1)+"/"+txpatientid.getText()+"/"+yr);

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
          try
          {
            id = txpatientid.getText();
            Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
			      String tpatid=JOptionPane.showInputDialog(null,"Enter doctor id:");
            String str = "select * from pattbl where pat_id ='"+tpatid+"'";  
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(str);

            while(res.next())
            {
              txpatientid.setText(res.getString(1));
              txpatientname.setText(res.getString(2));
              txadress.setText(res.getString(3));
              txcontact.setText(res.getString(4));
              if(res.getString(5).equalsIgnoreCase("Male"))
              {
                rbmale.setSelected(true);
              }
              else
              {
                rbfemale.setSelected(true);
              }
              txaadhar.setText(res.getString(6));
              
            }
          }
          catch(Exception ee)
          {
            System.out.print(ee);
          }
        }
        
       
        
        if(e.getSource() == bsave)
        {
          try
          {
            if(txpatientid.getText().length()==0)
            {
              System.out.println("llllllll");
              JOptionPane.showMessageDialog(null , "Please provide a patient id");
            }
            if(txadmission.getText().length()==0)
            {
              System.out.println("llllllll");
              JOptionPane.showMessageDialog(null , "Please provide a admission id");
            }
            
            else
            {

              Connection con = DriverManager.getConnection("jdbc:odbc:nursing");
              String str = "Insert into patientbedtbl(admission_no,patient_id,patient_name,patient_contact,date_from,bed_type,date_to)values(?,?,?,?,?,?,?)";
              PreparedStatement ps = con.prepareStatement(str);
              ps.setString(1,txadmission.getText().toString());
              ps.setString(2,txpatientid.getText().toString());
              ps.setString(3,txpatientname.getText().toString());
              ps.setString(4,txcontact.getText().toString());
              ps.setString(5,String.valueOf(txdate.getText()));
              String bed = txbed.getText();
              char bedno = bed.charAt(bed.length()-1);
              String bedtype[]=bed.split(" ");  
              String type = bedtype[0]; 
              System.out.println(type);
              int bednum = Integer.parseInt(String.valueOf(bedno));
              String col = "X"+String.valueOf(bednum);    
              System.out.println(col);
              System.out.println(bednum);
              ps.setString(6,txbed.getText());
              ps.setString(7,"na");
              ps.executeUpdate();
              System.out.println("ccccccccccccccccccccccccccccccccccc");
  
              String val = "NA";
              String str1 = "update wardtbl set x"+bednum+"= 'NA' where ward = '"+type+"'";
              System.out.println(type);
              Statement st1 = con.createStatement();
              st1.executeUpdate(str1);
              System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
              String str2 = "update keytbl set admission_id = admission_id + 1";
              Statement st2 = con.createStatement();
              st1.executeUpdate(str2);
              JOptionPane.showMessageDialog(null, "Record Saved Successfully");
            }

          }
          catch(Exception ee)
        {
            System.out.println(ee);
        }
         
          
         
        }
     
         
      if(e.getSource()==bexit)
        {

          wardsel obj2 = new wardsel(0);
          this.dispose();
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
   
   
    public static void main(String[] args) 
    {
      patient_details pdobj = new patient_details("eeee");
    }

    
}