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
public class test_request extends JFrame implements ActionListener,FocusListener,ItemListener,MouseListener,MouseMotionListener

{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
    Date dt=new Date();

    JLabel lblback = new JLabel(" ");
    
    JLabel lblhead = new JLabel(" ");
    JLabel lbltstreq      = new JLabel("TEST REQUEST");

    JLabel lblback1    = new JLabel("");
    JLabel lblback1a   = new JLabel("");
    
    JLabel lblback2    = new JLabel("");
    JLabel lblback2a   = new JLabel("");
    
    JLabel lblback3    = new JLabel("");
    JLabel lblback3a   = new JLabel("");
    
    JLabel lblback4    = new JLabel("");
    JLabel lblback4a   = new JLabel("");

    JLabel lblline1   = new JLabel("");
    JLabel lblline2   = new JLabel("");
    JLabel lblline3   = new JLabel("");
    JLabel lblline4   = new JLabel("");

    JLabel lblpattx = new JLabel("Patient Details");
    JLabel lbltsttx = new JLabel("Test Details");
    JLabel lbldoctx = new JLabel("Doctor Details");
    JLabel lblpaytx = new JLabel("Payment Details");

    JLabel lbltstname     = new JLabel("TEST NAME");
    JLabel lblreqid       = new JLabel("TReq_ID");
    JLabel lblpatid       = new JLabel("PTReq_ID");
    JLabel lbldoctor      = new JLabel("DOCTOR");    
    JLabel lbltstid       = new JLabel("Test id ");
    JLabel lblcharge      = new JLabel("Charge ");
    JLabel lblcontact     = new JLabel("CONTACT");
    JLabel lblname        = new JLabel("NAME");
    JLabel lbltotamt      = new JLabel("Total");
    JLabel lbldiscount    = new JLabel("Discount");
    JLabel lblnpay        = new JLabel("Net Payable");
    JLabel lbltdate       = new JLabel("DATE");
    JLabel lbladmission   = new JLabel("Admission.id");
    JLabel lblpayid       = new JLabel("pay_id");
    JLabel lblpayingnow   = new JLabel("pay");
    JLabel lblbal         = new JLabel("bal");
    
    JTextField txreqid       = new JTextField("");
    JTextField txpatid       = new JTextField("");
    JTextField txdoctor      = new JTextField("");
    JTextField txtstid       = new JTextField("");
    JTextField txcharge      = new JTextField("");
    JTextField txcontact     = new JTextField("");
    JTextField txname        = new JTextField("");
    JTextField txtotamt      = new JTextField("");
    JTextField txnpay        = new JTextField("");
    JTextField txdiscount    = new JTextField("");
    JTextField txtdate       = new JTextField("");
    JTextField txadmission   = new JTextField("");
    JTextField txpayid       = new JTextField("");
    JTextField txtpayingnow  = new JTextField("");
    JTextField txtbal        = new JTextField("");

    JComboBox testbox  = new JComboBox();
    JComboBox docidbox = new JComboBox();
    JComboBox docbox   = new JComboBox();

    JLabel lblpat = new JLabel("Patient");
    JLabel lblnonpat = new JLabel("Non Patient");

    ButtonGroup bg = new ButtonGroup();
    JRadioButton rbpat = new JRadioButton();
    JRadioButton rbnonpat = new JRadioButton();

    JButton bnew     = new JButton("New");
    JButton bpay     = new JButton("PAY");
    JButton bsearch  = new JButton("Search");
    JButton bedit    = new JButton("Edit");
    JButton bsave    = new JButton("Save");
    JButton bexit    = new JButton("Exit");
    JButton badd     = new JButton("add");
    JButton bremove  = new JButton("remove");

	String[] col= {"Test Id","Test Name","Test Charge"};
    String ttid,ttname,ttcharge;
	Object[][] data = {{ttid,ttname,ttcharge}};
	DefaultTableModel  model = new DefaultTableModel(col,0);
	JTable jtbltest = new JTable(data,col);
    JScrollPane sc;

    Dimension di  = Toolkit.getDefaultToolkit().getScreenSize();

    String srt1,srt2;
    double amttotal=0;
    double total=0;
    double discount=0;

    double npay=0.0;
    double paynow = 0.0;

    public test_request()
    {
		setVisible(true);
		
		
        setSize(1360,740);
        setTitle("Test Request");
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

		sc=new JScrollPane(jtbltest);
		sc.setBounds(750,80,500,500);
		jtbltest.setModel(model);

       

        //head
        lbltstreq.setBounds(580,26,200,30);
        lbltstreq.setForeground(new Color(255,255,255));
        lbltstreq.setFont(new Font("Arial",Font.BOLD,20));
        
        lblhead.setBounds(00, 05, 1360, 70);
        lblhead.setBackground(new Color(0,0,105));
        lblhead.setOpaque(true);
        

        //back1
        lblback1.setBounds(10,90,700,500);
        lblback1.setBackground(new Color(0,0,105));
        lblback1.setOpaque(true);
        
        lblback1a.setBounds(12,92,696,496);
        lblback1a.setBackground(new Color(200,206,211));
        lblback1a.setOpaque(true);

        lblline1.setBounds(12,220,696,2);
        lblline1.setBackground(new Color (0,0,105));
        lblline1.setOpaque(true);
        
        lblline2.setBounds(12,260,696,2);
        lblline2.setBackground(new Color (0,0,105));
        lblline2.setOpaque(true);
       
        lblline3.setBounds(12,500,696,2);
        lblline3.setBackground(new Color (0,0,105));
        lblline3.setOpaque(true);
        
        lblline4.setBounds(12,400,696,2);
        lblline4.setBackground(new Color (0,0,105));
        lblline4.setOpaque(true);

        lblpattx.setBounds(25,70,129,40);
        lblpattx.setFont(new Font("Arial",Font.BOLD,18));
        lblpattx.setBackground(new Color(200,206,211));
        lblpattx.setOpaque(true);

        lbltsttx.setBounds(25,240,105,40);
        lbltsttx.setFont(new Font("Arial",Font.BOLD,18));
        lbltsttx.setBackground(new Color(200,206,211));
        lbltsttx.setOpaque(true);
        
        lbldoctx.setBounds(25,380,125,40);
        lbldoctx.setFont(new Font("Arial",Font.BOLD,18));
        lbldoctx.setBackground(new Color(200,206,211));
        lbldoctx.setOpaque(true);
        
        lblpaytx.setBounds(25,480,148,40);
        lblpaytx.setFont(new Font("Arial",Font.BOLD,18));
        lblpaytx.setBackground(new Color(200,206,211));
        lblpaytx.setOpaque(true);
        
        //patient
       
        lblpat.setBounds(250,106,60,30);
        lblnonpat.setBounds(370,106,70,30);

        rbpat.setBounds(220,112,20,20); 
        rbpat.setBackground(new Color(200,206,211));
        rbpat.setOpaque(true);
    
        rbnonpat.setBounds(340,112,20,20);
        rbnonpat.setBackground(new Color(200,206,211));
        rbnonpat.setOpaque(true);

        lbladmission.setBounds(80, 150, 110, 30);
        lblpatid.setBounds(340, 150, 110, 30);
        lblname.setBounds(80, 210, 110, 30);
        lblcontact.setBounds(340, 210, 110, 30);

        txadmission.setBounds(170, 150, 110, 30);
        txpatid.setBounds(420, 150, 110, 30);
        txname.setBounds(170, 210, 110, 30);
        txcontact.setBounds(420, 210, 110, 30);

        //test

        testbox.setBackground(new Color(200,206,211)); 
        testbox.setOpaque(true);

        lblreqid.setBounds(80, 280, 110, 30);
        lbltstname.setBounds(340, 280, 110, 30);
        lbltstid.setBounds(80, 330, 100, 30);
        lblcharge.setBounds(340, 330, 100, 30);

        txreqid.setBounds(150, 280, 60, 30);
        testbox.setBounds(440, 280, 110, 30);
        txtstid.setBounds(150,330,60,30);
        txcharge.setBounds(400,330,60,30);

        //doctor

        lbldoctor.setBounds(50,420,100,30);

        txdoctor.setBounds(120, 420,70, 30);

        docidbox.setBounds(230,420,70,30);
        docidbox.setBackground(new Color(200,206,211)); 
        docidbox.setOpaque(true);

        docbox.setBounds(380,420,70,30);
        docbox.setBackground(new Color(200,206,211)); 
        docbox.setOpaque(true);

        //payment
        lbltotamt.setBounds(30,520,70,30);
        lbldiscount.setBounds(160,520,70,30);
        lblnpay.setBounds(315,520,70,30);
        lblpayingnow.setBounds(485,520,70,30);
        lblbal.setBounds(600,520,70,30);

        txtotamt.setBounds(70,520,70,30);
        txdiscount.setBounds(220,520,70,30);
        txnpay.setBounds(390,520,70,30);
        txtpayingnow.setBounds(510,520,70,30);
        txtbal.setBounds(630,520,70,30);


       //date
       lbltdate.setBounds(1150,80,100,30);
       txtdate.setBounds(1200,81,100,30);
       txtdate.setFont(new Font("Arial",Font.BOLD,12));
       txtdate.setBackground(new Color(200,206,211)); 
       txtdate.setOpaque(true);
       

        //back2
        lblback2.setBounds(750,120,500,400);
        lblback2.setBackground(new Color(0,0,105));
        lblback2.setOpaque(true);
        
        lblback2a.setBounds(752,122,496,396);
        lblback2a.setBackground(new Color(200,206,211));
        lblback2a.setOpaque(true);

        sc=new JScrollPane(jtbltest);
		sc.setBounds(790,160,420,320);
		jtbltest.setModel(model);
        

   
        //back3
        lblback3.setBounds(200,610,700,80);
        lblback3.setBackground(new Color(0,0,105));
        lblback3.setOpaque(true);
        
        lblback3a.setBounds(202,612,696,76);
        lblback3a.setBackground(new Color(200,206,211));
        lblback3a.setOpaque(true);
        
        //button
        bnew.setBounds(280,635,80,30);
        bsearch.setBounds(370,635,80,30);
        bpay.setBounds(460, 635,80,30);
        bedit.setBounds(550,635,80,30);
        bsave.setBounds(640,635,80,30);
        bexit.setBounds(730,635,80,30);

        bnew.setBackground(new Color(0,0,105));
        bsearch.setBackground(new Color(0,0,105));
        bpay.setBackground(new Color(0,0,105));
        bedit.setBackground(new Color(0,0,105));
        bsave.setBackground(new Color(0,0,105));
        bexit.setBackground(new Color(0,0,105));
       
        bnew.setForeground(new Color(255,255,225));
        bsearch.setForeground(new Color(255,255,255));
        bpay.setForeground(new Color(255,255,255));
        bedit.setForeground(new Color(255,255,255));
        bsave.setForeground(new Color(255,255,255));
        bexit.setForeground(new Color(255,255,255));
       
       
        //back4
        lblback4.setBounds(850,530,300,60);
        lblback4.setBackground(new Color(0,0,105));
        lblback4.setOpaque(true);
        
        lblback4a.setBounds(852,532,296,56);
        lblback4a.setBackground(new Color(200,206,211));
        lblback4a.setOpaque(true);

        badd.setBounds(900,540,80,40);
        badd.setBackground(new Color(0,0,105));
        badd.setForeground(new Color(255,255,225));

        bremove.setBounds(1000,540,80,40);
        bremove.setBackground(new Color(0,0,105));
        bremove.setForeground(new Color(255,255,225)); 
        

        //back
        lblback.setBounds(0,0,1360,740);
        lblback.setBackground(new Color(200,206,211));
        lblback.setOpaque(true);

       

        rbnonpat.addActionListener(this);
        rbpat.addActionListener(this);
        
        testbox.addItemListener(this);
        
        bnew.addActionListener(this);
        bsearch.addActionListener(this);
        bsave.addActionListener(this);
        bexit.addActionListener(this);
        bpay.addActionListener(this);
        
        bnew.addMouseListener(this);
        bsave.addMouseListener(this);
        bsearch.addMouseListener(this);
        bpay.addMouseListener(this);
        bedit.addMouseListener(this);
        bexit.addMouseListener(this);
        badd.addMouseListener(this);
        bremove.addMouseListener(this);
        
        badd.addActionListener(this);
        bremove.addActionListener(this);

        
       
        testbox.addActionListener(this);
        docidbox.addActionListener(this);
        docbox.addActionListener(this);

        txdiscount.addFocusListener(this);
        txnpay.addFocusListener(this);
        
       
       
        
        txcharge.setEditable(false);
        txname.setEditable(false);
        txcontact.setEditable(false);
        txtstid.setEditable(false);
        txtotamt.setEditable(false);
        txnpay.setEditable(false);
        txtdate.setEditable(false);
        txpatid.setEditable(false);
        txtstid.setEditable(false);
        txreqid.setEditable(false);
        txpayid.setEditable(false);
        txtpayingnow.setEditable(false);
        txtbal.setEditable(false);
        txadmission.setEditable(false);
        bpay.setEnabled(false);
        rbpat.setEnabled(false);
        rbnonpat.setEnabled(false);

        txdoctor.setVisible(false);

        txtdate.setText(sdf.format(dt));

        //head
        
        add(lbltstreq);
        add(lblhead);

        //back1

        add(lblpattx);

        add(lblpat);
        add(lblnonpat);
        bg.add(rbpat);
        bg.add(rbnonpat);
        add(rbpat);
        add(rbnonpat);

        //patient

        add(lbladmission);
        add(lblpatid);
        add(lblname);
        add(lblcontact);

        add(txadmission);
        add(txpatid);
        add(txname);
        add(txcontact);

        //test
        add(lblreqid);
        add(lbltstname);
        add(lbltstid);
        add(lblcharge);

        add(txreqid);
        add(testbox);
        add(txtstid);
        add(txcharge);

        //doctor

        add(lbldoctor);
        add(txdoctor);
        add(docidbox);
        add(docbox);

        //payment
        add(lbltotamt);
        add(lbldiscount);
        add(lblnpay);
        add(lblpayingnow);
        add(lblbal);

        add(txtotamt);
        add(txdiscount);
        add(txnpay);
        add(txtpayingnow);
        add(txtbal);

       // add(lblline1);
        add(lbltsttx);
        add(lblline2);
        
        add(lbldoctx);
        add(lblline4);

        add(lblpaytx);
        add(lblline3);
        
        
        add(lblback1a);
        add(lblback1);
        
        //date
        add(lbltdate);
        add(txtdate);
        //back2
        add(sc);
        add(lblback2a);
        add(lblback2);
        
        
        //back3
        
        //button
        add(bnew);
        add(bsearch);
        add(bpay);
        add(bedit);
        add(bsave);
        add(bexit);

        add(lblback3a);
        add(lblback3);
       
        //back4
        add(badd);
        add(bremove);
        add(lblback4a);
        add(lblback4);

        //background
        add(lblback);
        
        repaint();

        
        try
        {
            Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
            String str = "select * from doctbl";
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(str);
            while(res.next())
            {
                String id = res.getString(1);
                docidbox.addItem(id);             
            }
            
        }
        catch(Exception ee)
        {
            System.out.print(ee);
        }


        try
        {
            Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
            String str = "select * from testdetailstbl";
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(str);
            while(res.next())
            {
                String name = res.getString(2);
                testbox.addItem(name);             
            }

           
        
            
        }
        catch(Exception ee)
        {
            System.out.print(ee);
        }

        try
        {
            Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
            String str = "select * from doctbl";
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(str);
            while(res.next())
            {
                String id = res.getString(2);
                docbox.addItem(id);             
            }
            docbox.addItem("Others");
            
        }
        catch(Exception ee)
        {
            System.out.print(ee);
        }
        
        docidbox.addActionListener(this);
        docidbox.addItemListener(this);
        repaint();
    }

    public void itemStateChanged(ItemEvent ie)
	{
    
		if(ie.getStateChange()==ItemEvent.SELECTED)
		{
            
			try
			{
                
				Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
				String str="select * from testdetailstbl where Test_Name ='"+testbox.getSelectedItem().toString()+"'";
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery(str);
				while(res.next())
                {
                    String id = res.getString("testr_id");
                    String charge = res.getString("test_charge");
                    txtstid.setText(id);
                    txcharge.setText(charge);
                    System.out.print(id);
                }
            }
            catch(Exception ee)
            {
                System.out.print(ee);
            }
        }

        if(ie.getStateChange()==ItemEvent.SELECTED)
        {
            try
			{
				Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
				String str="select doctor_id from doctbl where doctor_name ='"+docbox.getSelectedItem().toString()+"'";
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery(str);
				while(res.next())
                {
                    int a = docbox.getSelectedIndex();
                    docidbox.setSelectedIndex(a);
                }
            }
            catch(Exception ee)
            {
                System.out.print(ee);
            }
        }
    }
    

    
    /*
    
    {
        try
        {
            System.out.print("!111111111111");

            String s = testbox.getSelectedItem().toString();
            Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
            String str="select test_id from testdetailstbl where Test Name ='s'";
            Statement st= con.createStatement();
            ResultSet res= st.executeQuery(str);
            while(res.next())
            {
                txtstid.setText(res.getString(1));
            }
        }
        catch(Exception ee)
        {
            System.out.print("333333333333");
            System.out.print(ee);
        }
    }

    
    */

    public void actionPerformed(ActionEvent e)
    {
        String testids = "";
        String testnames = "";
        String testcharges = "";
       
        if(e.getSource()==rbpat)
        {
           
            txadmission.setEditable(false);
            txcontact.setEditable(false);
            txname.setEditable(false);
            txtbal.setText("");
            txtpayingnow.setText("");
            txtpayingnow.setVisible(false);
            txtbal.setVisible(false);
            txpayid.setVisible(false);;
            bpay.setEnabled(false);
            txtotamt.setText("");
            txnpay.setText("");
            txpatid.setText("");
            txadmission.setVisible(true);


            model.setRowCount(0);
            
            String id = "";
            try
            {
                id = txtstid.getText();
                Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
                String admid=JOptionPane.showInputDialog(null,"Enter admission number:");
                String str = "select * from patientbedtbl where admission_no ='"+admid+"'";  
                Statement st=con.createStatement();
                ResultSet res=st.executeQuery(str);

                while(res.next())
                {
                    txname.setText(res.getString(3));
                    txcontact.setText(res.getString(4));
                    txpatid.setText(res.getString(2));
                    txadmission.setText(res.getString(1));
                }
            }
            catch(Exception ee)
            {
                System.out.print(ee);
            }


            
        }
        if(e.getSource()==rbnonpat)
        {
            
           
            txcontact.setEditable(true);
            txname.setEditable(true);
            txpayid.setVisible(true);
            txtpayingnow.setVisible(true);
            txtbal.setVisible(true);
            txadmission.setVisible(false);
            txtotamt.setText("");
            txnpay.setText("");
            txtbal.setText("");
            txtpayingnow.setText("");
            txpatid.setText("");
            bpay.setEnabled(true);


            model.setRowCount(0);
            try
            {
              Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
              String str = "select npat_id from keytbl";
              Statement st=con.createStatement();
              ResultSet res=st.executeQuery(str);
              while(res.next())
              {                
                  txpatid.setText("npat-"+res.getString(1));
              }
              
              
              
            }
            
            catch(Exception ee)
            {
              System.out.print(ee);
            }

            try
            {
               Connection con1=DriverManager.getConnection("jdbc:odbc:nursing");
               String str1="select pay_id from keytbl";
               Statement st1=con1.createStatement();
               ResultSet res1= st1.executeQuery(str1);
               while(res1.next())
               {
                txpayid.setText("pay/"+res1.getString(1));
               }
               
            }

            catch(Exception ee)
            {
              System.out.print(ee);
            }


        }
       
        

        if(e.getSource() == bnew)
        {
          rbpat.setEnabled(true);
          rbnonpat.setEnabled(true);
          try
          {
            Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
            String str = "select testr_id from keytbl";
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(str);
            while(res.next())
            {                
                txreqid.setText("TR/"+res.getString(1));
            }
            
            txcontact.setText("");
            txdoctor.setText("");
            txname.setText("");
            txpatid.setText("");
            
			
          }
            catch(Exception ee)
            {
              System.out.print(ee);
            }
        } 

        if(e.getSource() == bpay)
        {
            try
            {
                Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
                String str = "INSERT INTO paymenttbl(pay_id,admn_id,patient_id,patient_name,patient_contact,total_bill,paid,balance,testcharge,bedcharge,payment_date)values(?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(str);
                ps.setString(1,txpayid.getText());
                ps.setString(2,"na");
                ps.setString(3,txpatid.getText());
                ps.setString(4,txname.getText());
                ps.setString(5,txcontact.getText());
                ps.setString(6,txnpay.getText());
                ps.setString(7,txnpay.getText());
                ps.setString(8,"na");
                ps.setString(9,txtotamt.getText());
                ps.setString(10,txtbal.getText());
                ps.setString(11,txtdate.getText());
                ps.executeUpdate();
                String str1 = "update keytbl set pay_id = pay_id + 1";
                Statement st1 = con.createStatement();
                st1.executeUpdate(str1);
                JOptionPane.showMessageDialog(null, "Amount paid");
            }
            catch(Exception ee)
            {
              System.out.print(ee);
            }
        }

        
        if(e.getSource() == bsave)
        {
          String type="";
                try
                {
                    if(txreqid.getText().length()==0)
                    {
                        JOptionPane.showMessageDialog(null , "Please provide a Test Request id");
                    }

                    if(txpatid.getText().length()==0)
                    {
                        JOptionPane.showMessageDialog(null , "Please provide a patient Request id");
                    }

                    if(txtotamt.getText().length()==0)
                    {
                        JOptionPane.showMessageDialog(null , "Please provide a amt");
                    }

                    if(txnpay.getText().length()==0)
                    {
                        JOptionPane.showMessageDialog(null , "Please provide a amt");
                    }

                    if(txdiscount.getText().length()==0)
                    {
                        JOptionPane.showMessageDialog(null , "Please provide a amt");
                    }

                    if(txtpayingnow.getText().length()==0)
                    {
                        JOptionPane.showMessageDialog(null , "Please provide a amt");
                    }

                    else
                    {

                        Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
                        String str = "INSERT INTO testrequesttbl (test_id,test_name,p_name,tcharge,types,admn_id,pt_reqid,t_reqid,contact,net__payable,test_date)values(?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement ps = con.prepareStatement(str);
                        
                        for(int a=0;a<jtbltest.getRowCount();a++)
                        {
                          testids = testids+","+jtbltest.getValueAt(a,0).toString();
                          testnames = testnames+","+jtbltest.getValueAt(a,1).toString();
                          testcharges = testcharges+","+jtbltest.getValueAt(a,2).toString();
                        }
     
                        ps.setString(1, testids.substring(1));
                        ps.setString(2, testnames.substring(1));
                        ps.setString(3, txname.getText());
                        ps.setString(4, testcharges.substring(1));
                        ps.setString(6, txadmission.getText());
                        ps.setString(7, txpatid.getText());
                        ps.setString(8, txreqid.getText());
                        System.out.println("1111111111111");
                        if(rbpat.isSelected())
                        {
                          type = "patient";
                          
                        }
                        else
                        {
                          type = "non patient";
                        }
                        ps.setString(5, type);
                        ps.setString(9, txcontact.getText());
                        ps.setString(10, txnpay.getText());
                        ps.setString(11, txtdate.getText());
        
                        ps.executeUpdate();
                        String str1 = "update keytbl set testr_id = testr_id + 1";
                        Statement st1 = con.createStatement();
                        st1.executeUpdate(str1);
                        if(rbnonpat.isSelected())
                        {
                         String str2 = "update keytbl set npat_id = npat_id + 1";
                         Statement st2 = con.createStatement();
                         st2.executeUpdate(str2);
                        }
                        JOptionPane.showMessageDialog(null, "Record Saved Successfully");
         
                    }
                }

         
                catch(Exception ee)
                {
                  System.out.println(ee);
                }
                    
            }

        if(e.getSource() == badd)
        {
            

           
            int found=0;
            for(int aa=0 ; aa<jtbltest.getRowCount() ; aa++)
            {
				System.out.println(jtbltest.getValueAt(aa, 0));
                if(jtbltest.getValueAt(aa, 0).equals(txtstid.getText().toString()))
                {
                    JOptionPane.showMessageDialog(null,"Test already exists!");
					found=1;
					break;
                }
			}
			if(found==0)
			{
				if(txtstid.getText().equals("") || txcharge.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Please select a test!");
                    }
                    else
                    {
                    Vector v = new Vector();
                    v.add(txtstid.getText());
                    v.add(testbox.getSelectedItem().toString());
                    v.add(txcharge.getText());
                    model.addRow(v);
                    amttotal=0;
					for(int kk=0;kk<jtbltest.getRowCount();kk++)
					{
				        amttotal=amttotal+Double.parseDouble(""+jtbltest.getValueAt(kk,2));	
                        	
                    }
                    txtotamt.setText(""+amttotal);

                    }
                
            }
        }
        if(e.getSource() == bremove)
        {
            int row = jtbltest.getSelectedRow();
            if(row < 0)
            {
                JOptionPane.showMessageDialog(null,"Please select a row to remove!");
            }
            else
            {
                model.removeRow(jtbltest.getSelectedRow());
                amttotal=0;
                for(int kk=0;kk<jtbltest.getRowCount();kk++)
                {
                    amttotal=amttotal+Double.parseDouble(""+jtbltest.getValueAt(kk,2));		
                }
                txtotamt.setText(""+amttotal);
            }
			
        }

        if (e.getSource() == bexit )
        {
            third obj2 = new third(srt1,srt2);
            this.dispose();
        }


        

      
        if(e.getSource()==docbox)
        {            
            if(docbox.getSelectedItem().toString().equals("Others"))
            {
                txdoctor.setVisible(true);
                txdoctor.requestFocus();
            }
            else
            {
                docidbox.setSelectedIndex(docbox.getSelectedIndex());          
            }
        }
    
        

    }

    public void focusLost(FocusEvent fe)
    {
        if(fe.getSource()==txdiscount)
        {
            txtotamt.setText(""+amttotal);
            discount = Double.parseDouble(txdiscount.getText());
            total = Double.parseDouble(txtotamt.getText());
            double tnpay = (total-(total*(discount/100)));
            txnpay.setText(String.valueOf(tnpay)); 
            txtpayingnow.setText(String.valueOf(tnpay));
            npay=Double.parseDouble(txnpay.getText());
            paynow=Double.parseDouble(txtpayingnow.getText());
            Double bal = (npay- paynow);
            txtbal.setText(String.valueOf(bal));
             
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

        if(m.getSource()==badd)
        {
            badd.setForeground(new Color(0, 0, 105));
            badd.setBackground(new Color(255,255,255));
        }

        if(m.getSource()==bremove)
        {
            bremove.setForeground(new Color(0, 0, 105));
            bremove.setBackground(new Color(255,255,255));
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

        if(m.getSource()==badd)
        {
            badd.setForeground(new Color(255,255,255));
            badd.setBackground(new Color(0, 0, 105));
        }

        if(m.getSource()==bremove)
        {
            bremove.setForeground(new Color(255,255,255));
            bremove.setBackground(new Color(0, 0, 105));
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
       test_request trobj = new test_request(); 
    }
}