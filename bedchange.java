import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
public class bedchange extends JFrame implements ActionListener ,FocusListener,MouseListener,MouseMotionListener
{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
    Date dt=new Date();

    JLabel lblback = new JLabel(" ");
    
    JLabel lblhead = new JLabel(" ");
    JLabel lblbedchange      = new JLabel("BED CHANGE");
   

    JLabel lblback1    = new JLabel("");
    JLabel lblback1a   = new JLabel("");
    
    JLabel lbltxt1   = new JLabel("Patient Details");
    JLabel lbltxt2   = new JLabel("Bed Details");
    
    JLabel lblback2    = new JLabel("");
    JLabel lblback2a   = new JLabel("");
   
    JLabel lblback3    = new JLabel("");
    JLabel lblback3a   = new JLabel("");
   
    JLabel lblpatientid    = new JLabel("Patient id");
    JLabel lblpatientname  = new JLabel("Patient_NAME ");
    JLabel lblcontact      = new JLabel("CONTACT");
    JLabel lblnewallocdate = new JLabel("NEW DATE");
    JLabel lblpreallocdate = new JLabel("Old DATE");
    JLabel lblbedallocated = new JLabel("Allocated Beds ");
    JLabel lblnewbed       = new JLabel("newA Beds ");
    JLabel lbladmission    = new JLabel("Admission.id");

    
   
    JTextField txpatientid       = new JTextField();
    JTextField txpatientname     = new JTextField();
    JTextField txcontact         = new JTextField();
    JTextField txnewallocdate    = new JTextField();
    JTextField txpreallocdate    = new JTextField();
    JTextField txbedallocated    = new JTextField();
    JTextField txnewbed          = new JTextField();
    JTextField txadmission       = new JTextField(); 
   
    JButton bsave     = new JButton("Save");
    JButton bexit     = new JButton("Exit");
    JButton bbedalloc = new JButton("New Bed");
    String str1,str2;

    public bedchange( String txt)
    {

        setVisible(true);
        setSize(900,630);
        setTitle("Bed Change");
        setLayout(null);
        setLocationRelativeTo(null);
        
        //head
        lblhead.setBounds(00,05,900,60);
        lblhead.setBackground(new Color (0,0,105));
        lblhead.setOpaque(true);

        lblbedchange.setBounds(370,5,150,60);
        lblbedchange.setFont(new Font("Arial",Font.BOLD,18));
        lblbedchange.setForeground(new Color(255,255,255));

        //back1
        lblback1.setBounds(60,100,350,350);
        lblback1.setBackground(new Color(0,0,105));
        lblback1.setOpaque(true);

        lblback1a.setBounds(62,102,346,346);
        lblback1a.setBackground(new Color(200,206,211));
        lblback1a.setOpaque(true);

        lbltxt1.setBounds(70,80,130,40);
        lbltxt1.setFont(new Font("Arial",Font.BOLD,18));
        lbltxt1.setBackground(new Color(200,206,211));
        lbltxt1.setOpaque(true);

        lbladmission.setBounds(100,120,110,30);
        lblpatientid.setBounds(100,200,110,30);
        lblpatientname.setBounds(100,280,110,30);
        lblcontact.setBounds(100,360,110,30);
        

        txadmission.setBounds(190,120,110,30);
        txpatientid.setBounds(190,200,110,30);
        txpatientname.setBounds(190,280,110,30);
        txcontact.setBounds(190,360,110,30);
        
        //back2
        lblback2.setBounds(450,100,350,350);
        lblback2.setBackground(new Color(0,0,105));
        lblback2.setOpaque(true);
        
        lblback2a.setBounds(452,102,346,346);
        lblback2a.setBackground(new Color(200,206,211));
        lblback2a.setOpaque(true);

        
        lbltxt2.setBounds(460,80,105,40);
        lbltxt2.setFont(new Font("Arial",Font.BOLD,18));
        lbltxt2.setBackground(new Color(200,206,211));
        lbltxt2.setOpaque(true);

        lblbedallocated.setBounds(500,120,110,30);
        lblpreallocdate.setBounds(500,200,110,30);
        lblnewbed.setBounds(500,280,110,30);
        lblnewallocdate.setBounds(500,360,110,30);

        txbedallocated.setBounds(590,120,110,30);
        txpreallocdate.setBounds(590,200,110,30);
        txnewbed.setBounds(590,280,110,30);
        txnewallocdate.setBounds(590,360,110,30);

        //back3
        lblback3.setBounds(250,470,400,70);
        lblback3.setBackground(new Color(0,0,105));
        lblback3.setOpaque(true);
        
        lblback3a.setBounds(252,472,396,66);
        lblback3a.setBackground(new Color(200,206,211));
        lblback3a.setOpaque(true);

        bbedalloc.setBounds(270,490,100,30);
        bbedalloc.setBackground(new Color(0,0,105));
        bbedalloc.setForeground(new Color(255,255,255));

        bsave.setBounds(400,490,100,30);
        bsave.setBackground(new Color(0,0,105));
        bsave.setForeground(new Color(255,255,255));

        bexit.setBounds(530,490,100,30);
        bexit.setBackground(new Color(0,0,105));
        bexit.setForeground(new Color(255,255,255));


        //back
        lblback.setBounds(00,00,900,630);
        lblback.setBackground(new Color(200,206,211));
        lblback.setOpaque(true);

        
        txnewbed.setText(txt);


        txpatientid.setEditable(false);
        txnewbed.setEditable(false);
        txbedallocated.setEditable(false);
        txpatientname.setEditable(false);
        txcontact.setEditable(false);
        txnewallocdate.setEditable(false);
        txpreallocdate.setEditable(false);
        
        
      
        bsave.addActionListener(this);
        bexit.addActionListener(this);
        bbedalloc.addActionListener(this);


        bsave.addMouseListener(this);
        bexit.addMouseListener(this);
        bbedalloc.addMouseListener(this);

        txadmission.addFocusListener(this);
        
        txnewallocdate.setText(sdf.format(dt));

        //head
        add(lblbedchange);
        add(lblhead);

        //back1
        add(lbltxt1);

        add(lbladmission);
        add(lblpatientid);
        add(lblpatientname);
        add(lblcontact);

        add(txadmission);
        add(txpatientid);
        add(txpatientname);
        add(txcontact);
        
        add(lblback1a);
        add(lblback1);

        //back2
        add(lbltxt2);

        
        add(lblnewallocdate);
        add(lblpreallocdate);
        add(lblbedallocated);        
        add(lblnewbed);
        
        add(txnewallocdate);
        add(txpreallocdate);
        add(txbedallocated);        
        add(txnewbed);
        
        add(lblback2a);
        add(lblback2);

        //back3
        add(bbedalloc);
        add(bsave);
        add(bexit);

        add(lblback3a);
        add(lblback3);


       
        
        //background
        add(lblback);

        repaint();
      }
    

  
    public void actionPerformed(ActionEvent e)
    {
      if(e.getSource() == bbedalloc)
      {
        wardsel objws = new wardsel(2);
         this.dispose();
      }

      if(e.getSource() == bsave)
      {
        try
        {
          Connection con = DriverManager.getConnection("jdbc:odbc:nursing");
          
          String str3 = "update patientbedtbl set date_to = '"+txnewallocdate.getText().toString()+"' where patient_id = '"+txpatientid.getText().toString()+"' and  date_to = 'na'";
          Statement st3=con.createStatement();
          st3.executeUpdate(str3);
         
          String str = "Insert into patientbedtbl(admission_no,patient_id,patient_name,patient_contact,date_from,bed_type,date_to)values(?,?,?,?,?,?,?)";
          PreparedStatement ps = con.prepareStatement(str);


          ps.setString(1,txadmission.getText().toString());
          ps.setString(2,txpatientid.getText().toString());
          ps.setString(3,txpatientname.getText().toString());
          ps.setString(4,txcontact.getText().toString());
          ps.setString(5,String.valueOf(txnewallocdate.getText()));    
          ps.setString(6,txnewbed.getText());
          ps.setString(7,"na");
         
         
          String bedtype[] =txnewbed.getText().split(" ");      
          String str1 = "update wardtbl set x"+Integer.parseInt(bedtype[1])+"='NA' where ward ='"+bedtype[0]+"'";
          Statement st1=con.createStatement();
          st1.executeUpdate(str1);

          String bedtype1[] =txbedallocated.getText().split(" ");      
          String str2 = "update wardtbl set x"+Integer.parseInt(bedtype1[1])+"='A' where ward ='"+bedtype1[0]+"'";
          Statement st2=con.createStatement();
          st2.executeUpdate(str2);
          
          ps.executeUpdate();
          System.out.println("hjjhjhjhjjhjhjhjhjhjjhjhjhjhj");

          JOptionPane.showMessageDialog(null, "Record Saved Successfully");
        }
        catch(Exception ee)
        {
          System.out.println(ee);
        }
       
      }

      if(e.getSource()==bexit)
        
      {

        wardsel obj2 = new wardsel(1);
        this.dispose();
      }

        
    } 
    
   
    public void focusLost(FocusEvent fe)
    {
      if( fe.getSource()== txadmission)
      {
        try
        {
          Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
          String str="select * from patientbedtbl where admission_no ='"+txadmission.getText().toString()+"'";
          Statement st=con.createStatement();
          ResultSet res=st.executeQuery(str);
          while(res.next())
          {
            txpatientid.setText(res.getString(2));
            txpatientname.setText(res.getString(3));
            txcontact.setText(res.getString(4));
            txpreallocdate.setText(res.getString(5));
            txbedallocated.setText(res.getString(6));
          }
        }
     
        catch(Exception ee)
        {
          System.out.print(ee);
        }
               
          
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
        
      if(m.getSource()==bbedalloc)
      {
        bbedalloc.setForeground(new Color(0, 0, 105));
        bbedalloc.setBackground(new Color(255,255,255));
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
        if(m.getSource()==bbedalloc)
        {
            bbedalloc.setForeground(new Color(255,255,255));
            bbedalloc.setBackground(new Color(0, 0, 105));
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
        bedchange bdobj = new bedchange("");
    }


}
