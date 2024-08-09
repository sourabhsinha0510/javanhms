import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import javax.naming.spi.DirStateFactory.Result;
import javax.sound.sampled.FloatControl.Type;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class payment extends JFrame implements ActionListener,FocusListener,MouseListener,MouseMotionListener
{
    double subtotal=0.0;
    double gst = 8;
    SimpleDateFormat sdf= new SimpleDateFormat("dd/MMM/yyyy");
    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MMM/yyyy");
    Date dt=new Date();
    String st1,st2;
     

    JLabel lblhead        = new JLabel("");
    JLabel lblpay         = new JLabel("PAYMENT");

    JLabel lblback        = new JLabel("");

    JLabel lblback1      = new JLabel("");
    JLabel lblback2      = new JLabel("");
    JLabel lblback3      = new JLabel("");
    
    JLabel lblback1a      = new JLabel("");
    JLabel lblback2a      = new JLabel("");
    JLabel lblback3a      = new JLabel("");
    
    JLabel lblline      = new JLabel("");
    
    
    JLabel lblpatid       = new JLabel("Pat_ID");
    JLabel lblpayid       = new JLabel("Pay_ID");
    JLabel lblpdate       = new JLabel("DATE");
    JLabel lblname        = new JLabel("NAME");
    JLabel lblcontact     = new JLabel("CONTACT");
    JLabel lbltesttot     = new JLabel("Test Total");
    JLabel lblbedtot      = new JLabel("Bed Total");
    JLabel lbltotamt      = new JLabel("Total Amt");
    JLabel lblgst         = new JLabel("GST");
    JLabel lblnpay        = new JLabel("Net Pay");
    JLabel lblpayingnow   = new JLabel("Pay now");
    JLabel lblbalance     = new JLabel("balance");
    JLabel lbladmission   = new JLabel("Admission_id");

    JTextField txpay         = new JTextField("");
    JTextField txpatid       = new JTextField("");
    JTextField txpayid       = new JTextField("");
    JTextField txpdate       = new JTextField("");
    JTextField txname        = new JTextField("");
    JTextField txcontact     = new JTextField("");
    JTextField txtesttot     = new JTextField("0");
    JTextField txbedtot      = new JTextField("0");
    JTextField txtotamt      = new JTextField("");
    JTextField txgst         = new JTextField(" 18% ");
    JTextField txnpay        = new JTextField("");
    JTextField txpayingnow   = new JTextField("");
    JTextField txbalance     = new JTextField("");
    JTextField txadmission   = new JTextField("");

    JButton bnew     = new JButton("New");
    JButton bpay     = new JButton("PAY");
    JButton bsearch  = new JButton("Search");
    JButton bedit    = new JButton("Edit");
    JButton bsave    = new JButton("Save");
    JButton bexit    = new JButton("Exit");
    
	String[] col= {"Test Id","Test Name","Test Charge"};
    String ttid,ttname,ttcharge;
	Object[][] data = {{ttid,ttname,ttcharge}};
	DefaultTableModel  model = new DefaultTableModel(col,0);
	JTable jtbltest = new JTable(data,col);
    JScrollPane sct;
	
    String[] coll= {"From","To","Type","Charge"};
    String from,to,type,charge;
	Object[][] bdata = {{ttid,ttname,ttcharge}};
	DefaultTableModel  bmodel = new DefaultTableModel(coll,0);
	JTable jtblbed = new JTable(bdata,coll);
    JScrollPane scb;

    Dimension di = Toolkit.getDefaultToolkit().getScreenSize();
	
	
	
	
	 double pymnt = 0;
	 double npymnt= 0;

    public payment()
    {
        setSize(1300,710);
        setTitle("Payment");
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);

        sct=new JScrollPane(jtbltest);
		sct.setBounds(100,220,500,200);
		jtbltest.setModel(model);
        
        scb=new JScrollPane(jtblbed);
		scb.setBounds(660,220,500,200);
		jtblbed.setModel(bmodel);

        //back1
         
        lblpayid.setBounds(50,130,70,30);
        lbladmission.setBounds(220,130,80,30);
        lblpatid.setBounds(470,130,70,30); 
        lblname.setBounds(620,130,70,30);
        lblcontact.setBounds(790,130,70,30);
        lblpdate.setBounds(1050,130,70,30);

        
        txpayid.setBounds(105,130,70,30);
        txadmission.setBounds(310,130,120,30);
        txpatid.setBounds(510,130,80,30);
        txname.setBounds(670,130,80,30);
        txcontact.setBounds(860,130,100,30);
        txpdate.setBounds(1100,130,80,30);

        txpdate.setBackground(new  Color(200,206,211));
        txpdate.setOpaque(true);

        
        //back2
        lbltesttot.setBounds(240,430,70,30);
        lblbedtot.setBounds(800,430,70,30);
        lbltotamt.setBounds(130,485,70,30);
        lblgst.setBounds(320,485,70,30);
        lblnpay.setBounds(510,485,70,30);
        lblpayingnow.setBounds(700,485,70,30);
        lblbalance.setBounds(880,485,70,30);
      
        txtesttot.setBounds(320,430,80,30);
        txbedtot.setBounds(880,430,80,30);
        txtotamt.setBounds(200,485,80,30);
        txgst.setBounds(390,485,80,30);
        txnpay.setBounds(580,485,80,30);
        txpayingnow.setBounds(770,485,70,30);
        txbalance.setBounds(950,485,70,30);
        
        //button
        bnew.setBounds(380,580,80,40);
        bsearch.setBounds(480,580,80,40);
        bpay.setBounds(580,580,80,40);
        bedit.setBounds(680,580,80,40);
        bsave.setBounds(780,580,80,40);
        bexit.setBounds(880,580,80,40);

        bnew.setBackground(new Color(0,0,105));      
        bsearch.setBackground(new Color(0,0,105));      
        bsave.setBackground(new Color(0,0,105));      
        bedit.setBackground(new Color(0,0,105));      
        bpay.setBackground(new Color(0,0,105));      
        bexit.setBackground(new Color(0,0,105));      

        
        bnew.setForeground(new Color(255,255,255));      
        bsearch.setForeground(new Color(255,255,255));      
        bsave.setForeground(new Color(255,255,255));      
        bedit.setForeground(new Color(255,255,255));      
        bpay.setForeground(new Color(255,255,255));      
        bexit.setForeground(new Color(255,255,255));      

        
        
        //heading
        lblhead.setBounds(00,05,1300,80);
        lblhead.setBackground(new Color(0,0,105));
        lblhead.setOpaque(true);
        lblpay.setBounds(560,25,200,30);
        lblpay.setForeground(new Color(255,255,255));
        lblpay.setFont(new Font("Arial",Font.BOLD,32));

        //back1
        lblback1.setBounds(40,115,1200,80);
        lblback1.setBackground(new Color(0,0,105));
        lblback1.setOpaque(true);
        lblback1a.setBounds(42,117,1196,76);
        lblback1a.setBackground(new Color(200,206,211));
        lblback1a.setOpaque(true);
 
        //back2
        lblback2.setBounds(40,215,1200,330);
        lblback2.setBackground(new Color(0,0,105));
        lblback2.setOpaque(true);
        lblback2a.setBounds(42,217,1196,326);
        lblback2a.setBackground(new Color(200,206,211));
        lblback2a.setOpaque(true);
        //line
        lblline.setBounds(40,470,1200,2);
        lblline.setBackground(new Color(0,0,105));
        lblline.setOpaque(true);
 
        //back3
        lblback3.setBounds(350,560,640,80);
        lblback3.setBackground(new Color(0,0,105));
        lblback3.setOpaque(true);
        lblback3a.setBounds(352,562,636,76);
        lblback3a.setBackground(new Color(200,206,211));
        lblback3a.setOpaque(true);
  
        //background
        lblback.setBounds(00,00,1300,710);
        lblback.setBackground(new Color(200,206,211));
        lblback.setOpaque(true);
        

        bnew.addActionListener(this);
        bsearch.addActionListener(this);
        bsave.addActionListener(this);
        bexit.addActionListener(this);
        bpay.addActionListener(this);
        bedit.addActionListener(this);

        bnew.addMouseListener(this);
        bsearch.addMouseListener(this);
        bsave.addMouseListener(this);
        bexit.addMouseListener(this);
        bpay.addMouseListener(this);
        bedit.addMouseListener(this);

    
        txadmission.addFocusListener(this);
        txpayingnow.addFocusListener(this);

        txpatid .setEditable(false);  
        txpayid.setEditable(false); 
        txpdate.setEditable(false);   
        txname.setEditable(false);   
        txcontact.setEditable(false); 
        txtesttot.setEditable(false); 
        txbedtot.setEditable(false); 
        txtotamt.setEditable(false);  
        txgst.setEditable(false);     
        txnpay .setEditable(false);   
        txbalance .setEditable(false);  

        txpdate.setText(sdf.format(dt));

        //heading
        add(lblpay);
        add(lblhead);

        //back1
        add(lblpayid);
        add(lbladmission);
        add(lblpatid);
        add(lblname);
        add(lblcontact);
        add(lblpdate);
        
        add(txpayid);
        add(txadmission);
        add(txpatid);
        add(txname);
        add(txcontact);
        add(txpdate);
       
        add(lblback1a);
        add(lblback1);


        //back2
        add(sct);
        add(scb); 

        add(lbltesttot);
        add(lblbedtot);

        add(txtesttot);
        add(txbedtot);

        add(lblline);

        add(lbltotamt);
        add(lblgst);
        add(lblnpay);
        add(lblpayingnow);
        add(lblbalance);
        
        add(txtotamt);
        add(txgst);
        add(txnpay);
        add(txpayingnow);
        add(txbalance);
        
        add(lblback2a);
        add(lblback2);


        //back3
        add(bnew);
        add(bpay);
        add(bsave);
        add(bedit);
        add(bsearch);
        add(bexit);
        add(lblback3a);
        add(lblback3);


        //background
        add(lblback);

        repaint();

    }

  

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == bnew)
        {

            try
            {
              Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
              String str = "select pay_id from keytbl";
              Statement st=con.createStatement();
              ResultSet res=st.executeQuery(str);
              while(res.next())
              {                
                  txpayid.setText("pay/"+res.getString(1));
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
                    if(txpayid.getText().length()==0)
                    {
                        System.out.println("llllllll");
                        JOptionPane.showMessageDialog(null , "Please provide a payment id");
                    }
                    else
                    {

                        Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
                        String str = "INSERT INTO paymenttbl (pay_id,admn_id,patient_id,patient_name,patient_contact,total_bill,paid,balance,testcharge,bedcharge,payment_date)values(?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement ps = con.prepareStatement(str);
                        if(Double.parseDouble(txpayingnow.getText()) > Double.parseDouble(txnpay.getText()) )
                        {
                            JOptionPane.showMessageDialog(null, "bill se paisa jayda hai ");
                            txpayingnow.setText(null);
                        }
                        else
                        {
                            ps.setString(1,txpayid.getText());
                            ps.setString(2,txadmission.getText());
                            ps.setString(3,txpatid.getText());
                            ps.setString(4,txname.getText());
                            ps.setString(5,txcontact.getText());
                            ps.setString(6,txnpay.getText());
                            ps.setString(7,txpayingnow.getText());
                            ps.setString(8,txbalance.getText());
                            ps.setString(9,txtesttot.getText());
                            ps.setString(10,txbedtot.getText());
                            ps.setString(11,txpdate.getText());
                            ps.executeUpdate();
                            String str1 = "update keytbl set pay_id = pay_id + 1";
                            Statement st1 = con.createStatement();
                            st1.executeUpdate(str1);
                            JOptionPane.showMessageDialog(null, "Record Saved Successfully");
                        }
                    }
                   
    
                 }
    
                 catch(Exception ee)
                 {
                   System.out.println(ee);
                 }
            }


        

        if(e.getSource()== bexit)
        {
            third obj2 = new third(st1,st2);
            this.dispose();
            
        }



    }

    public void clear_textbox()
    {
        txpay.setText(null);
        txpatid.setText(null);
        txname.setText(null);
        txtesttot.setText(null);
        txbedtot.setText(null);
    }
        
    
    public void focusLost(FocusEvent fe)
    {
        double testtotal=0;
        double bedtotal=0;
        Double sum=0.0;
       
    
        if(fe.getSource() == txadmission)
        {
            model.setRowCount(0);
            bmodel.setRowCount(0);
            txtesttot.setText(null);
            txbedtot.setText(null); 

            try
            {
                Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
                String str="select * from testrequesttbl where admn_id ='"+txadmission.getText().toString()+"'";
                Statement st=con.createStatement();
                ResultSet res=st.executeQuery(str); 

                while(res.next())
                {
                    txpatid.setText(res.getString(7));
                    txname.setText(res.getString(3));
                    txcontact.setText(res.getString(9));
                }
            }
            catch(Exception ee)
            {
                System.out.print(ee);
            }

            try
            {
                
                Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
                String str="select * from paymenttbl where admn_id ='"+txadmission.getText()+"'";
                Statement st=con.createStatement();
                ResultSet res_amt=st.executeQuery(str);
                while(res_amt.next())
                {
                    sum = sum + Double.parseDouble(res_amt.getString(7));
                }
                
                con.close();
            }
            catch(Exception ee)
            {
                System.out.print(ee);
            }

            try
            {
                Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
                String str="select * from testrequesttbl where admn_id ='"+txadmission.getText()+"'";
                Statement st=con.createStatement();
                ResultSet res=st.executeQuery(str);
                while(res.next())
                {
                    
                    testtotal=Double.parseDouble(res.getString(10));
                    txtesttot.setText(String.valueOf(testtotal));
                    System.out.println("bbbbbbbbbb");
                }
                con.close();
            }
            catch(Exception ee)
            {
                System.out.print(ee);
            }

        
            try
            {
                Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
                String str="select * from testrequesttbl where admn_id ='"+txadmission.getText().toString()+"'";
                Statement st=con.createStatement();
                ResultSet res=st.executeQuery(str);

                
                while(res.next())
                {
					Vector v = new Vector();
                    v.add(res.getString(1));
                    v.add(res.getString(2));
                    v.add(res.getString(4));
                
                model.addRow(v);
				}
                con.close();
            }
            
            catch(Exception ee)
            {
                System.out.print(ee);
            }
            
            
           

            
            try
            {
                Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
                String str="select * from patientbedtbl where admission_no ='"+txadmission.getText().toString()+"'";
                Statement st=con.createStatement();
                ResultSet res=st.executeQuery(str);
                while(res.next())
                {
                    String d1 = res.getString(5);
                    String dtn =res.getString(7);
					System.out.println("-"+dtn+"-");
                    if(dtn.equalsIgnoreCase("na"))
                    {
                        dtn = txpdate.getText().toString();
                    }
                    Date d2 = sdf.parse(d1);
                    Date d3 = sdf.parse(dtn);
                    double n1 = d3.getTime();
                    double n2 = d2.getTime();
                    n1 = Math.abs(n1/(1000*60*60*24));
                    n2 = Math.abs(n2/(1000*60*60*24));
                    Double day = Math.abs(n1-n2);
                    int day1 = day.intValue();
                    System.out.print(day1);
                    
                    Vector v = new Vector();
                    
                    v.add(d1);
                    v.add(dtn);
                    String bedtype1 = res.getString(6);
                    v.add(bedtype1);
                    String bedtype[] = bedtype1.split(" ");
                    String type = bedtype[0];  

                    Connection con1=DriverManager.getConnection("jdbc:odbc:nursing");
                    String str1="select * from wardtbl where ward ='"+type+"'";
                    Statement st1=con1.createStatement();
                    ResultSet res1=st1.executeQuery(str1);
                    while(res1.next())
                    {
                        String tcharge = res1.getString(2);
                        int totcharge = Integer.parseInt(tcharge)*(day1+1);
                        subtotal = testtotal+totcharge;
                        double tnpay = (subtotal+(subtotal*18)/100);
                        txtotamt.setText(String.valueOf(subtotal));
                       
                        
                        v.add(totcharge);

                    }

                    bmodel.addRow(v);
                    double bedtot =0 ;
                    for ( int i= 0 ;i<jtblbed.getRowCount();i++)
                    {
                            bedtot=bedtot+ (Double.parseDouble(jtblbed.getValueAt(i, 3).toString()));
                    }
                    txbedtot.setText(String.valueOf(bedtot));
                    double s1 = Double.parseDouble(txtesttot.getText())+bedtot;
                    txtotamt.setText(String.valueOf(s1));
                    double tnpay = (s1+(s1*18)/100);
                    txnpay.setText(String.valueOf(tnpay)); 
                    

                
                }
                con.close();   
            }

            catch(Exception ee)
            {
                System.out.print(ee);
            }

           
        }


       if(fe.getSource()==txpayingnow)
       {
         pymnt=Double.parseDouble(txpayingnow.getText());
         npymnt=Double.parseDouble(txnpay.getText());
         double bal  = (npymnt - pymnt);
         txbalance.setText(String.valueOf(bal));

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

        if(m.getSource()==bsave)
        {
            bsave.setForeground(new Color(0, 0, 105));
            bsave.setBackground(new Color(255,255,255));
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

        if(m.getSource()==bsave)
        {
            bsave.setForeground(new Color(255,255,255));
            bsave.setBackground(new Color(0, 0, 105));
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
       payment payobj = new payment(); 
    }

}