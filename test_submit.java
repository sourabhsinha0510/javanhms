import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import javax.swing.table.DefaultTableModel;
public class test_submit extends JFrame implements ActionListener,ItemListener,FocusListener,MouseListener,MouseMotionListener
{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
    Date dt=new Date();

    JLabel lblbackground  = new JLabel("");
   
    JLabel lblhead        = new JLabel("");
    JLabel lbltxt         = new JLabel("Test Submit");

    JLabel lblback1       = new JLabel("");
    JLabel lblback1a      = new JLabel("");
    
    JLabel lblback2       = new JLabel("");
    JLabel lblback2a      = new JLabel("");
    
    JLabel lblback3       = new JLabel("");
    JLabel lblback3a      = new JLabel("");
    
    JLabel lblback4       = new JLabel("");
    JLabel lblback4a      = new JLabel("");
    
    JLabel lbladmission_no        = new JLabel("Admission no - ");
    JLabel lblpat_id              = new JLabel("pat_id");
    JLabel lblpatient_name        = new JLabel("Name -");
    JLabel lblcontact             = new JLabel("Contact - ");
    JLabel lbldate                = new JLabel("Date - ");
    JLabel lblgender              = new JLabel("Gender - ");
    JLabel lblreport_id           = new JLabel("report_id - ");

    

    JTextField txtadmission_no      = new JTextField();
    JTextField txtpat_id            = new JTextField();
    JTextField txtpatient_name      = new JTextField();
    JTextField txtcontact           = new JTextField();
    JTextField txtdate              = new JTextField();
    JTextField txtgender            = new JTextField();
    JTextField txtreport_id         = new JTextField();
    
    
    JLabel lbltest[]  = new JLabel[20];
    JLabel lbltest2[] = new JLabel[20];
    
    
    JTextField txttest[] = new JTextField[20];


    JButton bnew     = new JButton("NEW");
    JButton bsave    = new JButton("SAVE");
    JButton bexit  = new JButton("EXIT");

    JComboBox  testbox = new JComboBox();
    JComboBox  boxtest_req = new JComboBox();

    JLabel lblpat      = new JLabel("Patient");
    JLabel lblnonpat   = new JLabel("Non-Patient");

    ButtonGroup bg        = new ButtonGroup();
    JRadioButton rbpat   = new JRadioButton();
    JRadioButton rbnonpat = new JRadioButton();

    String st1,st2;


   
    public  test_submit() 
    {   
        
        setVisible(true);
        setSize(1365,720);
        setTitle("Test Submit");
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        
        //back1
        
        lblback1.setBounds(10,100,1320,50);
        lblback1.setBackground(new Color(0,0,105));
        lblback1.setOpaque(true);
        lblback1a.setBounds(12,102,1316,46);
        lblback1a.setBackground(new Color(200,206,211));
        lblback1a.setOpaque(true);
        
        lblreport_id.setBounds(20,106,80,30);
        lbladmission_no.setBounds(200,105,120,30);
        lblpat_id.setBounds(430,105,80,30);
        lblpatient_name.setBounds(580,105,80,30);
        lblcontact.setBounds(730,105,80,30);
        lblgender.setBounds(910,105,70,30);
        lbldate.setBounds(1110,105,80,30);

        txtreport_id.setBounds(100,107,80,30);
        txtadmission_no.setBounds(290,107,120,30);
        txtpat_id.setBounds(475,107,80,30);
        txtpatient_name.setBounds(630,107,80,30);
        txtcontact.setBounds(800,107,90,30);
        txtgender.setBounds(970,107,85,30);
        txtdate.setBounds(1170,107,80,30);

        txtdate.setBackground(new Color(200,206,211));


        //back2
        lblback2.setBounds(420,170,290,40);
        lblback2.setBackground(new Color(0,0,105));
        lblback2.setOpaque(true);
        lblback2a.setBounds(422,172,286,36);
        lblback2a.setBackground(new Color(200,206,211));
        lblback2a.setOpaque(true);
       
        lblpat.setBounds(490,171,80,40);
        lblnonpat.setBounds(620,171,80,40);

        rbpat.setBounds(450,180,20,20);
        rbnonpat.setBounds(580,180,20,20);
        
        rbpat.setBackground(new Color(200,206,211));
        rbpat.setOpaque(true);
        
        rbnonpat.setBackground(new Color(200,206,211));
        rbnonpat.setOpaque(true);
        

        
        //back3
        lblback3.setBounds(180,270,250,230);
        lblback3.setBackground(new Color(0,0,105));
        lblback3.setOpaque(true);
        lblback3a.setBounds(182,272,246,226);
        lblback3a.setBackground(new Color(200,206,211));
        lblback3a.setOpaque(true);

        testbox.setBounds(240,290,130,50);
        boxtest_req.setBounds(240,370,130,50);

        

        //back4
        lblback4.setBounds(390,550,350,70);
        lblback4.setBackground(new Color(0,0,105));
        lblback4.setOpaque(true);
        lblback4a.setBounds(392,552,346,66);
        lblback4a.setBackground(new Color(200,206,211));
        lblback4a.setOpaque(true);
        

        bnew.setBounds(415, 570,80,30);
        bsave.setBounds(525,570,80,30);
        bexit.setBounds(635,570,80,30);

        bnew.setBackground(new Color(0,0,105)); 
        bsave.setBackground(new Color(0,0,105));
        bexit.setBackground(new Color(0,0,105));

        bnew.setForeground(new Color(255,255,255)); 
        bsave.setForeground(new Color(255,255,255));
        bexit.setForeground(new Color(255,255,255));
        

        //heading
        lblhead.setBounds(00,5,1360,80);
        lblhead.setBackground(new Color(0,0,105));
        lblhead.setOpaque(true);
        
        lbltxt.setBounds(550,10,250,70);
        lbltxt.setForeground(new Color(255,255,255));
        lbltxt.setFont(new Font("Arial",Font.BOLD,32));

        //background

        lblbackground.setBounds(00,00,1365,680);
        lblbackground.setBackground(new Color(200,206,211));
        lblbackground.setOpaque(true);
     
      
        for(int i=0 ; i<20 ; i++)
        {
            lbltest[i] = new JLabel("");
            lbltest2[i] = new JLabel("");
            txttest[i] = new JTextField("");
        }

        int a=0;
        int d=0;
        for(int j=0 ; j<8 ; j++)
        {
            a+=70; 
            lbltest[j].setText("parameter");
            lbltest[j].setBounds(860,90 + a,110,20);
            lbltest[j].setFont(new Font("Arial" , Font.BOLD , 16));
            add(lbltest[j]);
            lbltest[j].setEnabled(false);

            lbltest2[j].setText("parameter");
            lbltest2[j].setBounds(1100,90 + a,90,20);
            lbltest2[j].setFont(new Font("Arial" , Font.BOLD , 16));
            add(lbltest2[j]);
            lbltest2[j].setEnabled(false);


            d+=70;
            txttest[j].setText("");
            txttest[j].setBounds(980,90 + d,90,20);
            txttest[j].setFont(new Font("Arial" , Font.BOLD , 16));
            add(txttest[j]);
            txttest[j].setEnabled(false);
        }
       
        //head
        add(lbltxt);
        add(lblhead);

        //back1
        add(lblreport_id);
        add(txtreport_id);
        add(lbladmission_no);
        add(txtadmission_no);
        add(lblpat_id);
        add(txtpat_id);
        add(lblpatient_name);
        add(txtpatient_name);
        add(lblcontact);
        add(txtcontact);
        add(lblgender);
        add(txtgender);
        add(lbldate);
        add(txtdate);


        add(lblback1a);
        add(lblback1);
        
        //back2
        add(lblpat);
        add(lblnonpat);
        
        bg.add(rbpat); 
        bg.add(rbnonpat);
        add(rbpat);
        add(rbnonpat);
        
        add(lblback2a);
        add(lblback2);

        //back3
        add(testbox);
        add(boxtest_req);
        
        add(lblback3a);
        add(lblback3);

        //back4
        add(bsave);        
        add(bnew);
        add(bexit);

        add(lblback4a);
        add(lblback4);

        //background
        add(lblbackground);
        
        txtdate.setText(sdf.format(dt));

        bexit.addActionListener(this);
        bsave.addActionListener(this);
        bnew.addActionListener(this);

        bexit.addMouseListener(this);
        bsave.addMouseListener(this);
        bnew.addMouseListener(this);
        
        
        bnew.addActionListener(this);
        bsave.addActionListener(this);
        bexit.addActionListener(this);

        rbpat.addActionListener(this);
        rbnonpat.addActionListener(this);

        txtadmission_no.addFocusListener(this);
        txtpat_id.addFocusListener(this);
        testbox.addActionListener(this);
        //testbox.addItemListener(this);
        boxtest_req.addActionListener(this);
       // boxtest_req.addItemListener(this);

        txtpatient_name.setEditable(false);
        txtpat_id.setEditable(false);
        txtcontact.setEditable(false);
        txtgender.setEditable(false);
        txtdate.setEditable(false);
        
        txtreport_id.setEditable(false);
        
       // getContentPane().setBackground(new java.awt.Color(120, 130, 190));

        repaint();
    }

    public void clrboxes()
    {
        txtpatient_name.setText("");
        txtcontact.setText("");
        txtgender.setText("");
    }

    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource()==bnew)
        {
          try
          {
              
            Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
            String str = "select report_id from keytbl";
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(str);
            while(res.next())
            {      
               txtreport_id.setText("rep-"+res.getString(1));
            }
                    
          }
          catch(Exception ee)
          {
              System.out.print(ee);
            }
        } 
        
        if(ae.getSource()==rbpat)
        {
            
          txtadmission_no.setVisible(true);
          txtpat_id.setText("");
          txtpat_id.setEditable(false);
          txtpatient_name.setText("");
          txtgender.setText("");
          txtcontact.setText("");
          txtreport_id.setText("");

          for(int j=0 ; j<8 ; j++)
          {
            txttest[j].setText("");
          }
          
        }
        if(ae.getSource()==rbnonpat)
        {
            txtpat_id.requestFocus();
            txtadmission_no.setVisible(false);
            txtpatient_name.setText("");
            txtgender.setText("");
            txtcontact.setText("");
            txtreport_id.setText("");
            txtpat_id.setEditable(true);
            for(int j=0 ; j<8 ; j++)
            {
              txttest[j].setText("");
            }
            
        }

      
      if(ae.getSource()==bsave)
      {
             String tstid="";
             String tstname ="";
             try
             {
               Connection con2=DriverManager.getConnection("jdbc:odbc:nursing");
               String str2="select test_reqid,test_name from test_result";
               Statement st2=con2.createStatement();
               ResultSet res2=st2.executeQuery(str2);
               
               while(res2.next())
               {
                   tstid = res2.getString("test_reqid");
                   tstname = res2.getString("test_name");                   
               }
               System.out.println(tstname);
               System.out.println(tstid);
               
               if(tstid.equalsIgnoreCase(boxtest_req.getSelectedItem().toString()) && tstname.equalsIgnoreCase(testbox.getSelectedItem().toString()))
               {
              
                   JOptionPane.showMessageDialog(null, "Record Already Exists!!");
               }
               else
               {
                 try
                   {
              
                       Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
                       String str3 = "INSERT INTO testsubmittbl (report_id,admission_id,p_id,p_name,p_contact,gender,test_name,r_date,value_1,value_2,value_3,value_4,value_5,value_6,value_7)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                       PreparedStatement ps = con.prepareStatement(str3);
                       ps.setString(1, txtreport_id.getText());
                       ps.setString(2, txtadmission_no.getText());
                       ps.setString(3, txtpat_id.getText());
                       ps.setString(4, txtpatient_name.getText());
                       ps.setString(5, txtcontact.getText());
                       ps.setString(6, txtgender.getText());
                       ps.setString(7,  boxtest_req.getSelectedItem().toString());
                       ps.setString(8,  txtdate.getText());
                       ps.setString(9,  txttest[0].getText());
                       ps.setString(10,  txttest[1].getText());
                       ps.setString(11,  txttest[2].getText());
                       ps.setString(12, txttest[3].getText());
                       ps.setString(13, txttest[4].getText());
                       ps.setString(14, txttest[5].getText());
                       ps.setString(15, txttest[6].getText());
                       ps.setString(16, txttest[7].getText());
                       if(rbnonpat.isSelected())
                       {
                           ps.setString(2,"na");
                       }
                       ps.executeUpdate();
                       String str1 = "update keytbl set report_id = report_id + 1";
                       Statement st1 = con.createStatement();
                       st1.executeUpdate(str1);
                       JOptionPane.showMessageDialog(null, "Record Saved Successfully");
                   }
                   catch(Exception ee)
                   {
                       System.out.print(ee);
                   }
               }
            }
            catch(Exception ee)
            {
               System.out.print(ee);
            }
        }

        if(ae.getSource() == testbox)
        {

            //testbox.setSelectedIndex(boxtest_req.getSelectedIndex());

            try
            {
                Connection con2=DriverManager.getConnection("jdbc:odbc:nursing");
                String str2="select * from testrequesttbl where test_id ='"+boxtest_req.getSelectedItem().toString()+"'";
                Statement st2=con2.createStatement();
                ResultSet res2=st2.executeQuery(str2);
                
                System.out.println("printtttttt");
                while(res2.next())
                {
                    testbox.removeAllItems();
                    String var1 = res2.getString(2);
                    String vv[] = var1.split(",");
                    for(int a=0 ; a<vv.length ; a++)
                    {
                        testbox.addItem(vv[a]);
                    }
                    System.out.println("1111111111111");
    
                }
            }
    
            catch(Exception ee)
            {
                System.out.print(ee);
            }    
            
        }

       if(ae.getSource() == boxtest_req)
        {
           // boxtest_req.setSelectedIndex(testbox.getSelectedIndex());
          
          System.out.println("aaaaaaaaaaaaaaaaaa");
            try
            {
                Connection con2=DriverManager.getConnection("jdbc:odbc:nursing");
                String str2="select * from testdetailstbl where test_Name = '"+boxtest_req.getSelectedItem().toString()+"'";
                Statement st2=con2.createStatement();
                ResultSet res2=st2.executeQuery(str2);
                int b=0;
                int c=5;
                System.out.println(boxtest_req.getSelectedItem());
                while(res2.next())
                {
                    System.out.println("hellooooooo");

                    int totnum = Integer.valueOf(res2.getString(3));
                    for(int i=0 ; i<totnum ; i++)
                    {
                        System.out.print("11111111/");
                        lbltest[b].setText(res2.getString(c));
                        lbltest[b].setVisible(true);
                        lbltest[b].setEnabled(true);

                        lbltest2[b].setText("hello");
                        lbltest2[b].setVisible(true);
                        lbltest2[b].setEnabled(true);

                        txttest[b].setVisible(true);
                        txttest[b].setEnabled(true);
                        b++;
                        c++;
                    }
                    for(int i=totnum ; i<20 ; i++)
                    {
                        lbltest[i].setVisible(false);
                        txttest[i].setVisible(false);
                        lbltest2[i].setVisible(false);
                    }
				}
            }

            catch(Exception ee)
            {
                System.out.print(ee);
            }

            try
            {
                Connection con3=DriverManager.getConnection("jdbc:odbc:nursing");
                String str3="select * from testvaluetbl where test_Name = '"+testbox.getSelectedItem().toString()+"'";
                Statement st3=con3.createStatement();
                ResultSet res3=st3.executeQuery(str3);

                int e=0;
                int f=4;
                while(res3.next())
                {
                    System.out.println("3333333333");
                    int totnum1 = Integer.valueOf(res3.getString(3));
                    for(int i=0 ; i<totnum1 ; i++)
                    {
                        System.out.print("222222222222222222222222");
                        
                        lbltest2[e].setText(res3.getString(f));
                        lbltest2[e].setVisible(true);
                        lbltest2[e].setEnabled(true);

                       
                        e++;
                        f++;
                    }
                    for(int i=totnum1 ; i<20 ; i++)
                    {
                        lbltest[i].setVisible(false);
                        txttest[i].setVisible(false);
                        lbltest2[i].setVisible(false);
                    }
				}
                
                
            }

            catch(Exception ee)
            {
                System.out.print(ee);
            }

        }
      
        if(ae.getSource()==bexit)
        {

            third obj2 = new third(st1,st2);
            this.dispose(); 
        }
    }

    public void itemStateChanged(ItemEvent ie)
    {

       /* if(ie.getSource() == testbox)
        {

            System.out.println("aaaaaaaaaaaaaaaaaa");
            try
            {
                Connection con2=DriverManager.getConnection("jdbc:odbc:nursing");
                String str2="select * from testdetailstbl where test_Name = '"+testbox.getSelectedItem().toString()+"'";
                Statement st2=con2.createStatement();
                ResultSet res2=st2.executeQuery(str2);
                int b=0;
                int c=5;
                System.out.println(testbox.getSelectedItem());
                while(res2.next())
             
                {
                    System.out.println("hellooooooo");
    
                    int totnum = Integer.valueOf(res2.getString(3));
                    for(int i=0 ; i<totnum ; i++)
                    {
                        System.out.print("11111111/");
                        lbltest[b].setText(res2.getString(c));
                        lbltest[b].setVisible(true);
                        lbltest[b].setEnabled(true);
    
                        lbltest2[b].setText("hello");
                        lbltest2[b].setVisible(true);
                        lbltest2[b].setEnabled(true);
    
                        txttest[b].setVisible(true);
                        txttest[b].setEnabled(true);
                        b++;
                        c++;
                    }
                    for(int i=totnum ; i<20 ; i++)
                    {
                        lbltest[i].setVisible(false);
                        txttest[i].setVisible(false);
                        lbltest2[i].setVisible(false);
                    }
                }
            }
    
            catch(Exception ee)
            {
                System.out.print(ee);
            }
    
            try
            {
                Connection con3=DriverManager.getConnection("jdbc:odbc:nursing");
                String str3="select * from testvaluetbl where test_Name = '"+testbox.getSelectedItem().toString()+"'";
                Statement st3=con3.createStatement();
                ResultSet res3=st3.executeQuery(str3);
    
                int e=0;
                int f=4;
                while(res3.next())
                {
                    System.out.println("3333333333");
                    int totnum1 = Integer.valueOf(res3.getString(3));
                    for(int i=0 ; i<totnum1 ; i++)
                    {
                        System.out.print("222222222222222222222222");
                        
                        lbltest2[e].setText(res3.getString(f));
                        lbltest2[e].setVisible(true);
                        lbltest2[e].setEnabled(true);
    
                       
                        e++;
                        f++;
                    }
                    for(int i=totnum1 ; i<20 ; i++)
                    {
                        lbltest[i].setVisible(false);
                        txttest[i].setVisible(false);
                        lbltest2[i].setVisible(false);
                    }
                }
                
                
            }
    
            catch(Exception ee)
            {
                System.out.print(ee);
            }

        }  */
        
        
       /*  if(ie.getSource() == boxtest_req)
        {

            //testbox.setSelectedIndex(boxtest_req.getSelectedIndex());

            try
            {
                Connection con2=DriverManager.getConnection("jdbc:odbc:nursing");
                String str2="select * from testrequesttbl where test_id ='"+boxtest_req.getSelectedItem().toString()+"'";
                Statement st2=con2.createStatement();
                ResultSet res2=st2.executeQuery(str2);
                
                System.out.println("printtttttt");
                while(res2.next())
                {
                    testbox.removeAllItems();
                    String var1 = res2.getString(2);
                    String vv[] = var1.split(",");
                    for(int a=0 ; a<vv.length ; a++)
                    {
                        testbox.addItem(vv[a]);
                    }
                    System.out.println("1111111111111");
    
                }
            }
    
            catch(Exception ee)
            {
                System.out.print(ee);
            }

            
            
        }*/

    }

    public void focusLost(FocusEvent fe)
    {
        String test = "";
        String testid = "";

        if(fe.getSource() == txtadmission_no)
        {   
            try
            {
                Connection con2=DriverManager.getConnection("jdbc:odbc:nursing");
                String str2="select * from testrequesttbl where admn_id ='"+txtadmission_no.getText().toString()+"'";
                Statement st2=con2.createStatement();
                ResultSet res2=st2.executeQuery(str2);
                boxtest_req.removeAllItems();
               
                while(res2.next())
                {
                   test = res2.getString(2);

				}
               
                String tst[] = test.split(",");
                for(int i=0;i<tst.length;i++)
                {
                    boxtest_req.addItem( tst[i] );
                    System.out.println(tst[i]);
                }
                
                
                

                con2.close();
            }

            catch(Exception ee)
            {
                System.out.print(ee);
            }
              
            try
            {
                Connection con3=DriverManager.getConnection("jdbc:odbc:nursing");
                String str3="select * from testrequesttbl where admn_id ='"+txtadmission_no.getText().toString()+"'";
                Statement st3=con3.createStatement();
                ResultSet res3=st3.executeQuery(str3);
                testbox.removeAllItems();

                while(res3.next())
                {
                   testid = res3.getString(8);

				}
               
                String tstid[] = testid.split(",");
                for(int i=0;i<tstid.length;i++)
                {
                    testbox.addItem(  tstid[i] );
                    System.out.println(tstid[i]);
                }
                con3.close();
            
            }

            catch(Exception ee)
            {
                System.out.print(ee);
            }
             

        }
        
        
        try
            {
                Connection con2=DriverManager.getConnection("jdbc:odbc:nursing");
                String str2="select * from testrequesttbl where admn_id ='"+txtadmission_no.getText().toString()+"'";
                Statement st2=con2.createStatement();
                ResultSet res2=st2.executeQuery(str2);

                
                while(res2.next())
                {
                    txtpat_id.setText(res2.getString(7));
					Vector v = new Vector();
                    v.add(res2.getString(2));
                    
                    
				}
            }

            catch(Exception ee)
            {
                System.out.print(ee);
            }

            int ctr = 0;
            String id="";
            try
            {
                id = txtadmission_no.getText();
                Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
                String str = "select * from pattbl where pat_id ='"+txtpat_id.getText()+"'";  
                Statement st=con.createStatement();
                ResultSet res=st.executeQuery(str);

                while(res.next())
                {
                    ctr=1;
                    txtpatient_name.setText(res.getString(2));
                    txtcontact.setText(res.getString(4));
                    txtgender.setText(res.getString(5));
                }
                
            }
            catch(Exception ee)
            {
                System.out.print(ee);
            }

            if(fe.getSource()==txtpat_id)
            {
               
                try
                {
                    Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
                    String str="select * from testrequesttbl where pt_reqid ='"+txtpat_id.getText().toString()+"'";
                    Statement st=con.createStatement();
                    ResultSet res3=st.executeQuery(str); 
                    while(res3.next())
                {
                    txtpatient_name.setText(res3.getString(3));
                    txtcontact.setText(res3.getString(9));
                    Vector v = new Vector();
                    v.add(res3.getString(2));
                    
                   
                }
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
        
      if(m.getSource()==bnew)
      {
        bnew.setForeground(new Color(0, 0, 105));
        bnew.setBackground(new Color(255,255,255));
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


    public void focusGained(FocusEvent fe)
    {}

    public static void main(String[] args) 
    {
        test_submit obj = new test_submit();
    }
}
