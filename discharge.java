import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import javax.lang.model.util.ElementScanner6;
import javax.naming.spi.DirStateFactory.Result;
import javax.sound.sampled.FloatControl.Type;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class discharge extends JFrame implements ActionListener  ,FocusListener,MouseListener,MouseMotionListener
{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
    Date dt=new Date();

    JLabel lblbackground     = new JLabel("");


    JLabel lbldischarge     = new JLabel("");
    JLabel lbltxt           = new JLabel("DISCHARGE");

    JLabel lblpatd = new JLabel("PATIENT DETAILS");
    JLabel lblpayd = new JLabel("PAYMENT DETAILS");

    JLabel lblback1      = new JLabel("");
    JLabel lblback2      = new JLabel("");
    JLabel lblback3      = new JLabel("");
    
    JLabel lblback1a      = new JLabel("");
    JLabel lblback2a      = new JLabel("");
    JLabel lblback3a      = new JLabel("");

    JLabel lbladmisson      = new JLabel("Admission_id");
    JLabel lblpayid         = new JLabel("Payment id");
    JLabel lblpatientid     = new JLabel("Patient id");
    JLabel lblname          = new JLabel("Name");
    JLabel lblcontact       = new JLabel("CONTACT:- ");
    JLabel lbldate          = new JLabel("DATE ");
    JLabel lbltestcharge    = new JLabel("TOTAL TEST CHARGE");
    JLabel lblbedcharge     = new JLabel("TOTAL BED CHARGE");
    JLabel lbltotalcharge   = new JLabel("TOTAL CHARGE");
    JLabel lblamtpaid       = new JLabel("Amount Paid");
    JLabel lblamtremain     = new JLabel("Amount To Be paid ");
    JLabel lblbed           = new JLabel("bed");
    JLabel lblstatus        = new JLabel("Status");
    
    JTextField txadmission            = new JTextField("");
    JTextField txpayid                = new JTextField("");
    JTextField txpatientid            = new JTextField("");
    JTextField txname                 = new JTextField("");
    JTextField txcontact              = new JTextField("");
    JTextField txdate                 = new JTextField("");
    JTextField txtestcharge           = new JTextField("");
    JTextField txbedcharge            = new JTextField("");
    JTextField txtotalcharge          = new JTextField("");
    JTextField txamtpaid              = new JTextField("");
    JTextField txamtremain            = new JTextField("");
    JTextField txbed                  = new JTextField("");
    JTextField txstatus               = new JTextField("");
    
    JButton bnew          = new JButton("New");
    JButton bdischarge    = new JButton("Discharge");
    JButton bsearch       = new JButton("Search");
    JButton bedit         = new JButton("Edit");
    JButton bpay          = new JButton("Pay");
    JButton bexit         = new JButton("Exit");
    
    String str1,str2;

    public discharge()
    {
        setVisible(true);
        setSize(1150,680);
        setTitle("Discharge");
        setLayout(null);
        setLocationRelativeTo(null);

    
        //patdetails
        lbladmisson.setBounds(60,190,130,70);
        lblpatientid.setBounds(60,230,130,70);
        lblname.setBounds(60,270,130,70);
        lblcontact.setBounds(60,310,130,70);
        lblstatus.setBounds(60,350,130,70);
        lblbed.setBounds(60,390,130,70);
        
        txadmission.setBounds(150,210,130,30);
        txpatientid.setBounds(150,250,130,30);
        txname.setBounds(150,290,130,30);
        txcontact.setBounds(150,330,130,30);
        txstatus.setBounds(150,370,130,30);
        txbed.setBounds(150,410,130,30);
        

       //paydetails
       lbldate.setBounds(900,80,130,70);
       
       lblpayid.setBounds(600,190,130,70);
       lbltestcharge.setBounds(600,230,130,70);
       lblbedcharge.setBounds(600,270,130,70);
       lbltotalcharge.setBounds(600,310,130,70);
       lblamtpaid.setBounds(600,350,130,70);
       lblamtremain.setBounds(600,390,130,70);
      
        txdate.setBounds(950,100,90,30);
        
        txpayid.setBounds(750,210,130,30);
        txtestcharge.setBounds(750,250,130,30);
        txbedcharge.setBounds(750,290,130,30);
        txtotalcharge.setBounds(750,330,130,30);
        txamtpaid.setBounds(750,370,130,30);
        txamtremain.setBounds(750,410,130,30);



        txdate.setBackground(new Color(200,206,211));
       
    
        
       //buttons
        bnew.setBounds(210,545,80,40);
        bsearch.setBounds(320,545,80,40);
        bdischarge.setBounds(430,545,80,40);
        bedit.setBounds(540,545,80,40);
        bpay.setBounds(650,545,80,40);
        bexit.setBounds(760,545,80,40);
        
        bnew.setBackground(new Color(0,0,105));      
        bsearch.setBackground(new Color(0,0,105));      
        bdischarge.setBackground(new Color(0,0,105));      
        bedit.setBackground(new Color(0,0,105));      
        bpay.setBackground(new Color(0,0,105));      
        bexit.setBackground(new Color(0,0,105));      

        //backround
        lblbackground.setBounds(00,00,1150,680);
        lblbackground.setBackground(new Color(200,206,211));
        lblbackground.setOpaque(true);
        
        //pat&pay
        lblpatd.setBounds(60,100,160,70);
        lblpatd.setOpaque(true);
        lblpatd.setBackground(new Color(200,206,211));
        lblpatd.setFont(new Font("Arial",Font.BOLD,18));

        lblpayd.setBounds(600,100,180,70);
        lblpayd.setFont(new Font("Arial",Font.BOLD,18));
        lblpayd.setBackground(new Color(200,206,211));
        lblpayd.setOpaque(true);
       
        //heading
        lbldischarge.setBounds(00,5,1150,80);
        lbldischarge.setBackground(new Color(0,0,105));
        lbldischarge.setOpaque(true);
        
        lbltxt.setBounds(500,10,250,70);
        lbltxt.setForeground(new Color(255,255,255));
        lbltxt.setFont(new Font("Arial",Font.BOLD,32));

        //back1
        lblback1.setBounds(40,135,500,350);
        lblback1.setBackground(new Color(0,0,105));
        lblback1.setOpaque(true);
        lblback1a.setBounds(42,137,496,346);
        lblback1a.setBackground(new Color(200,206,211));
        lblback1a.setOpaque(true);

        //back2
        lblback2.setBounds(580,135,500,350);
        lblback2.setBackground(new Color(0,0,105));
        lblback2.setOpaque(true);
        lblback2a.setBounds(582,137,496,346);
        lblback2a.setBackground(new Color(200,206,211));
        lblback2a.setOpaque(true);

        //back3
        lblback3.setBounds(150,520,750,100);
        lblback3.setBackground(new Color(0,0,105));
        lblback3.setOpaque(true);
        lblback3a.setBounds(152,522,746,96);
        lblback3a.setBackground(new Color(200,206,211));
        lblback3a.setOpaque(true);
 
        bdischarge.setEnabled(false);
        bpay.setEnabled(false);


        txpatientid.setEditable(false);
        txpayid.setEditable(false);
        txname.setEditable(false);     
        txcontact.setEditable(false); 
        txdate.setEditable(false);     
          
        txtestcharge.setEditable(false);
        txbedcharge.setEditable(false);
        txtotalcharge.setEditable(false);
        txamtpaid.setEditable(false);
        txamtremain.setEditable(false);
        txstatus.setEditable(false);
        txbed.setEditable(false);

        txadmission.addFocusListener(this);

        bnew.addActionListener(this);
        bdischarge.addActionListener(this);
        bsearch.addActionListener(this);
        bpay.addActionListener(this);
        bedit.addActionListener(this);
        bexit.addActionListener(this);

        bnew.addMouseListener(this);
        bdischarge.addMouseListener(this);
        bsearch.addMouseListener(this);
        bpay.addMouseListener(this);
        bedit.addMouseListener(this);
        bexit.addMouseListener(this);


        
        
        //heading
        add(lbltxt);
        add(lbldischarge);
        
        //back1
        add(lblname);
        add(lblpatd);
        add(lbladmisson);
        add(lblpatientid);
        add(lblcontact);
        add(lblstatus);
        add(lblbed);

        add(txpatientid);
        add(txadmission);
        add(txname);
        add(txstatus);
        add(txcontact);
        add(txbed);

        add(lblback1a);
        add(lblback1);
        
        //back2
        add(lbldate);
        add(lblpayid);
        add(lbltestcharge);
        add(lblbedcharge);
        add(lbltotalcharge);
        add(lblamtpaid);
        add(lblamtremain);

        add(txdate);
        
        add(txpayid);
        add(txtestcharge);
        add(txbedcharge);
        add(txtotalcharge);
        add(txamtpaid);
        add(txamtremain);

        add(lblpayd);
        add(lblback2a);
        add(lblback2);
        
        //back3
        add(bnew);
        add(bdischarge);
        add(bpay);
        add(bedit);
        add(bsearch);
        add(bexit);

        add(lblback3a);
        add(lblback3);

        //background
        add(lblbackground);

        txdate.setText(sdf.format(dt));
        repaint();     
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == bdischarge)
        {
            try
            {
                Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
                String str3 = "update pattbl set status = 'discharged' where pat_id = '"+txpatientid.getText()+"' ";
                Statement st3=con.createStatement();
                st3.executeUpdate(str3);
            }
            catch(Exception ee)
            {
                System.out.println(ee);
            }

            try
            {
                Connection con1=DriverManager.getConnection("jdbc:odbc:nursing");
                String str2 = "update pattbl set discharge_date = '"+txdate.getText()+"'where discharge_date = 'na'"+ " and pat_id= '"+txpatientid.getText()+"'";
                Statement st2 = con1.createStatement();
                st2.executeUpdate(str2);
            }

            catch(Exception ee)
            {
                System.out.println(ee);
            }

            
            
             try
            {
                Connection con1=DriverManager.getConnection("jdbc:odbc:nursing");
                String str2 = "update patientbedtbl set date_to = '"+txdate.getText()+"'where date_to = 'na'"+ " and patient_id= '"+txpatientid.getText()+"'";
                Statement st2 = con1.createStatement();
                st2.executeUpdate(str2);
            }

            catch(Exception ee)
            {
                System.out.println(ee);
            }

            try
            {

                
                Connection con2=DriverManager.getConnection("jdbc:odbc:nursing");
                String bedtype1[] =txbed.getText().split(" ");      
                String str3= "update wardtbl set x"+Integer.parseInt(bedtype1[1])+"='A' where ward ='"+bedtype1[0]+"'";
                Statement st3=con2.createStatement();
                st3.executeUpdate(str3);
            }

             catch(Exception ee)
            {
                System.out.println(ee);
            }

            JOptionPane.showMessageDialog(null, " Patient Discharged");
        }

        if(e.getSource() == bexit)
        {
            third obj2 = new third(str1,str2);
            this.dispose(); 
        }

        
    }

    public void focusLost(FocusEvent fe)
    {
        double sum = 0.0;
        double left = 0.0;
        if(fe.getSource()== txadmission)
        {
            System.out.println("kgkgkgkgkgkgkgkgkgkgkgkg");
            try
            {
                Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
                String str="select * from paymenttbl where admn_id ='"+txadmission.getText().toString()+"'";
                Statement st=con.createStatement();
                ResultSet res=st.executeQuery(str);
                try
                    {
                        String str1 = "select * from paymenttbl where admn_id = '"+txadmission.getText()+"'";
                        Statement st1=con.createStatement();
                        ResultSet res1=st1.executeQuery(str1);
                        while(res1.next())
                        {
                            System.out.print("kkkkkkkkkkkkkkkkkkkkkkkk");
                            sum = sum + Double.parseDouble(res1.getString(6));
                        }
                        
                    }
                    catch(Exception ee)
                    {
                        System.out.println(ee);
                    }
                while(res.next())
                {
                    String netp = res.getString(6);
                    
                  double bal = Double.parseDouble(netp) - sum;
                  txamtremain.setText(String.valueOf(bal));

                  txpayid.setText(res.getString(1));
                  txpatientid.setText(res.getString(3));
                  txname.setText(res.getString(4));
                  txcontact.setText(res.getString(5));
                  txtestcharge.setText(res.getString(9));
                  txbedcharge.setText(res.getString(10));
                  txtotalcharge.setText(netp);
                  txamtpaid.setText(res.getString(7));
                  txamtremain.setText(res.getString(8));
            
                 
                }
                String balamt1 = txamtremain.getText();
                double balamt2 = Double.parseDouble(balamt1);
                if(  balamt2 == 0.0)
                {
                    bdischarge.setEnabled(true);
                }
                if(balamt2 > 0)
                {
                    bpay.setEnabled(true);
                }
            }
           
            catch(Exception ee)
            {
              System.out.print(ee);
            }

            
            try
            {
                Connection con1=DriverManager.getConnection("jdbc:odbc:nursing");
                String str1 ="select * from patientbedtbl where admission_no ='"+txadmission.getText()+"'and date_to = 'na'";
                Statement st1=con1.createStatement();
                ResultSet res1=st1.executeQuery(str1);
                while(res1.next())
                {
                  txbed.setText(res1.getString(6));
                }
                


            }
            catch(Exception ee)
            {
                System.out.println(ee);
            }

            try
            {
                Connection con2 = DriverManager.getConnection("jdbc:odbc:nursing");
                String str2 = "select * from pattbl where pat_id = '"+txpatientid.getText()+"'";
                Statement st2= con2.createStatement();
                ResultSet res2=st2.executeQuery(str2);
                while(res2.next())
                {
                    txstatus.setText(res2.getString(8));
                }

                if(txstatus.getText().equalsIgnoreCase("discharged"))
                {  
                    System.out.println("lkkkk");
                    bdischarge.setEnabled(false);

                }

                else
                {
                
                    bdischarge.setEnabled(true);
                }
              
            }
            catch(Exception ee)
            {
                System.out.println(ee);
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
        if(m.getSource()==bpay)
        {
            bpay.setForeground(new Color(0, 0, 105));
            bpay.setBackground(new Color(255,255,255));
        }
        if(m.getSource()==bexit)
        {
            bexit.setForeground(new Color(0, 0, 105));
            bexit.setBackground(new Color(255,255,255));
        }

        if(m.getSource()==bdischarge)
        {
            bdischarge.setForeground(new Color(0, 0, 105));
            bdischarge.setBackground(new Color(255,255,255));
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
        if(m.getSource()==bpay)
        {
            bpay.setForeground(new Color(255,255,255));
            bpay.setBackground(new Color(0, 0, 105));
        }
        if(m.getSource()==bexit)
        {
            bexit.setForeground(new Color(255,255,255));
            bexit.setBackground(new Color(0, 0, 105));
        }

        if(m.getSource()==bdischarge)
        {
            bdischarge.setForeground(new Color(255,255,255));
            bdischarge.setBackground(new Color(0, 0, 105));
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
        discharge objd = new discharge();
    }

}