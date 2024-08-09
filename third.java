import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
public class third extends JFrame implements ActionListener,MouseListener,MouseMotionListener

{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
    Date dt=new Date();

    JLabel lblbackground  = new JLabel("");

    JLabel lblhead        = new JLabel("");
    JLabel lbltxt         = new JLabel("NURSING HOME MANAGMENT SYSTEM");

    JLabel lblback1 = new JLabel("");

    JLabel lbl1[] = new JLabel[10];
    JLabel lbl2[] = new JLabel[10];

    JMenuBar mb = new JMenuBar();
    JMenu menmaster = new JMenu("MASTER");
    JMenu mentrans = new JMenu("TRANSACTION");
    JMenu menreports = new JMenu("REPORTS");
    JMenu menexit = new JMenu("EXIT");

    JMenuItem mastpatient = new JMenuItem("PATIENT");
    JMenuItem mastdoctor = new JMenuItem("DOCTOR");
    JMenuItem mastward = new JMenuItem("WARD");
    JMenuItem masttest = new JMenuItem("TESTS");

    JMenuItem transadmit = new JMenuItem("ADMIT");
    JMenuItem transdischarge = new JMenuItem("DISCHARGE");
    JMenuItem transpayment = new JMenuItem("PAYMENT");
    JMenuItem transtestrequest = new JMenuItem("TEST REQUEST");
    JMenuItem transrefund = new JMenuItem("REFUND");
    JMenuItem transbedchange = new JMenuItem("BED CHANGE");

    JMenuItem reporttest = new JMenuItem("TEST REPORT");
    JMenuItem reportpay = new JMenuItem("PAYMENT REPORT");
    JMenuItem exiting = new JMenuItem("EXITING");

    JLabel label1 = new JLabel("Patients Currently Admitted",JLabel.CENTER);
    JLabel label11 = new JLabel("",JLabel.CENTER);
    JLabel label2 = new JLabel("Payment Recived Today",JLabel.CENTER);
    JLabel label22 = new JLabel("",JLabel.CENTER);
    JLabel label3 = new JLabel("Tests Conducted Today",JLabel.CENTER);
    JLabel label33 = new JLabel("",JLabel.CENTER);
    JLabel label4 = new JLabel("No.Of Doctors",JLabel.CENTER);
    JLabel label44 = new JLabel("",JLabel.CENTER);
    JLabel label5 = new JLabel("Tests Available",JLabel.CENTER);
    JLabel label55 = new JLabel("",JLabel.CENTER);
    JLabel label6 = new JLabel("Patients Discharged Today",JLabel.CENTER);
    JLabel label66 = new JLabel("",JLabel.CENTER);
    JLabel label7 = new JLabel("Beds available in CCU",JLabel.CENTER);
    JLabel label77 = new JLabel("",JLabel.CENTER);
    JLabel label8 = new JLabel("Beds available in ICU",JLabel.CENTER);
    JLabel label88 = new JLabel("",JLabel.CENTER);
    JLabel label9 = new JLabel(" beds available in GENM",JLabel.CENTER);
    JLabel label99 = new JLabel("",JLabel.CENTER);
    JLabel label10 = new JLabel(" beds available in GENF",JLabel.CENTER);
    JLabel label110 = new JLabel("",JLabel.CENTER);

    JLabel lbldate = new JLabel();
    JLabel lbllogout = new JLabel("LOGOUT");
    JButton blogout = new JButton(new ImageIcon("zimg6.png"));
   
    JLabel l1 = new JLabel();
    String t1,t2;
    int xy;
    Dimension di  = Toolkit.getDefaultToolkit().getScreenSize();

    String n1 ;
    String n2;
    public third(String string, String string2)
    {     
        setVisible(true);
        setSize((int)di.getWidth(),(int)di.getHeight());
        setTitle("Menu");
        setLayout(null);
        setResizable(false);

        l1.setBounds(50,50,500,100);
        //l1.setFont(new Font("Arial" , Font.BOLD,40));

        //box

        label1.setBounds(270,110,280,40);
        label1.setOpaque(true);
        label1.setBackground(Color.decode("#00A36C"));
        label11.setBounds(270,150,280,110);
        label11.setOpaque(true);
        label11.setBackground(Color.decode("#3090C7"));
        label11.setFont(new Font("Arial",Font.BOLD,48));
         
        
        label2.setBounds(610,110,280,40);
        label2.setOpaque(true);
        label2.setBackground(Color.decode("#00A36C"));
        label22.setBounds(610,150,280,110);
        label22.setOpaque(true);    
        label22.setBackground(Color.decode("#3090C7"));
        label22.setFont(new Font("Arial",Font.BOLD,48));

        label3.setBounds(940,110,280,40);
        label3.setOpaque(true);
        label3.setBackground(Color.decode("#00A36C"));
        label33.setBounds(940,150,280,110);
        label33.setOpaque(true);
        label33.setBackground(Color.decode("#3090C7"));
        label33.setFont(new Font("Arial",Font.BOLD,48));

        label4.setBounds(270,310,280,40);
        label4.setOpaque(true);
        label4.setBackground(Color.decode("#00A36C"));
        label44.setBounds(270,350,280,110);
        label44.setOpaque(true);
        label44.setBackground(Color.decode("#3090C7"));
        label44.setFont(new Font("Arial",Font.BOLD,48));

        
        label5.setBounds(610,310,280,40);
        label5.setOpaque(true);
        label5.setBackground(Color.decode("#00A36C"));
        label55.setBounds(610,350,280,110);
        label55.setOpaque(true);    
        label55.setBackground(Color.decode("#3090C7"));
        label55.setFont(new Font("Arial",Font.BOLD,48));

        label6.setBounds(940,310,280,40);
        label6.setOpaque(true);
        label6.setBackground(Color.decode("#00A36C"));
        label66.setBounds(940,350,280,110);
        label66.setOpaque(true);
        label66.setBackground(Color.decode("#3090C7"));
        label66.setFont(new Font("Arial",Font.BOLD,48));

        label7.setBounds(240,510,230,40);
        label7.setOpaque(true);
        label7.setBackground(Color.decode("#00A36C"));
        label77.setBounds(240,550,230,110);
        label77.setOpaque(true);
        label77.setBackground(Color.decode("#3090C7"));
        label77.setFont(new Font("Arial",Font.BOLD,48));

        
        label8.setBounds(530,510,230,40);
        label8.setOpaque(true);
        label8.setBackground(Color.decode("#00A36C"));
        label88.setBounds(530,550,230,110);
        label88.setOpaque(true);    
        label88.setBackground(Color.decode("#3090C7"));
        label88.setFont(new Font("Arial",Font.BOLD,48));


        label9.setBounds(820,510,230,40);
        label9.setOpaque(true);
        label9.setBackground(Color.decode("#00A36C"));
        label99.setBounds(820,550,230,110);
        label99.setOpaque(true);
        label99.setBackground(Color.decode("#3090C7"));
        label99.setFont(new Font("Arial",Font.BOLD,48));

        
        label10.setBounds(1110,510,230,40);
        label10.setOpaque(true);
        label10.setBackground(Color.decode("#00A36C"));
        label110.setBounds(1110,550,230,110);
        label110.setOpaque(true);
        label110.setBackground(Color.decode("#3090C7"));
        label110.setFont(new Font("Arial",Font.BOLD,48));

        
        //back1
        lblback1.setBounds(00,15,200,700);
        lblback1.setBackground(new Color(07, 115, 180));
        lblback1.setOpaque(true);
        
        //heading
        lblhead.setBounds(00,00,1360,80);
        lblhead.setBackground(new Color(0,0,105));
        lblhead.setOpaque(true);
        
        lbltxt.setBounds(370,05,650,70);
        lbltxt.setForeground(new Color(255,255,255));
        lbltxt.setFont(new Font("Algerian",Font.BOLD,32));

        //background
        lblbackground.setBounds(0,0,(int)di.getWidth(),(int)di.getHeight());
        lblbackground.setBackground(new Color(200,206,211));
        lblbackground.setOpaque(true);

        lbldate.setBounds(1220,70,130,50);
        lbldate.setBackground(new Color(200,206,211));
        lbldate.setOpaque(true);
        lbldate.setFont(new Font("Algerian",Font.BOLD,16));

        lbllogout.setBounds(20,650,110,50);
        lbllogout.setBackground(new Color(07, 115, 180));
        lbllogout.setOpaque(true);
        lbllogout.setFont(new Font("Arial",Font.BOLD,16));

        blogout.setBounds(130,650,50,52);
        blogout.setBackground(new Color(07, 115, 180));
        
        //lbl1
        
        for(int j=0 ; j<10 ; j++)
		{
			lbl1[j] = new JLabel();
		}

        int a =0;
        for(int i=0;i<10;i++)
        {
            a+=60;
            lbl1[i].setBounds(30,60+a,110,30);
            lbl1[i].setFont(new Font("Arial",Font.BOLD,16));

           lbl1[0].setText("Doctor");
           add(lbl1[0]);
           lbl1[1].setText("Patient");
           add(lbl1[1]);
           lbl1[2].setText("Test Request");
           add(lbl1[2]);
           lbl1[3].setText("Payment");
           add(lbl1[3]);
           lbl1[4].setText("Admit");
           add(lbl1[4]);
           lbl1[5].setText("Bed Change");
           add(lbl1[5]);
           lbl1[6].setText("Discharge");
           add(lbl1[6]);
           lbl1[7].setText("Test Report");
           add(lbl1[7]);
           lbl1[8].setText("Pay Report");
           add(lbl1[8]);
           
        }
       
        //MENUBAR
        add(menmaster);
        add(mentrans);

        mb.add(menmaster);
        mb.add(mentrans);
        mb.add(menreports);
        mb.add(menexit);

        menmaster.add(mastpatient);
        menmaster.add(mastdoctor);
        menmaster.add(mastward);
        menmaster.add(masttest);
        mentrans.add(transadmit);
        mentrans.add(transdischarge);
        mentrans.add(transpayment);
        mentrans.add(transtestrequest);
       // mentrans.add(transrefund);
        mentrans.add(transbedchange);
        menreports.add(reporttest);
        menreports.add(reportpay);
        menexit.add(exiting);
//      add(mb);
        add(l1);
        
        menmaster.addActionListener(this);
        mentrans.addActionListener(this);
        menreports.addActionListener(this);
        menexit.addActionListener(this);
        mastpatient.addActionListener(this);
        mastdoctor.addActionListener(this);
        mastward.addActionListener(this);
        masttest.addActionListener(this);
        transadmit.addActionListener(this);
        transdischarge.addActionListener(this);
        transpayment.addActionListener(this);
        transtestrequest.addActionListener(this);
        transrefund.addActionListener(this);
        transbedchange.addActionListener(this);
        reporttest.addActionListener(this);
        reportpay.addActionListener(this);
        exiting.addActionListener(this);
        blogout.addActionListener(this);
        for(int j=0 ; j<10 ; j++)
		{
			lbl1[j].addMouseListener(this);;
		}
       
        this.setJMenuBar(mb);
        lbldate.setText(sdf.format(dt));

        //heading
        add(lbltxt);
        add(lblhead);
        
        //box
        add(label1);
        add(label11);
        add(label2);
        add(label22);
        add(label3);
        add(label33);
        add(label4);
        add(label44);
        add(label5);
        add(label55);
        add(label6);
        add(label66);
        add(label7);
        add(label77);
        add(label8);
        add(label88);
        add(label9);
        add(label99);
        add(label10);
        add(label110);
        add(lbldate);
        add(lbllogout);
        add(blogout);

        //back1
        add(lblback1);

        //backgrou-nd
        add(lblbackground);

        int ctr=0;
        try
        {
            Connection con = DriverManager.getConnection("jdbc:odbc:nursing");
            String str = "select pat_id  from pattbl where status = 'admitted'";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(str);

            while(res.next())
            {
                ctr++;
            }
           

            label11.setText(String.valueOf(ctr));

        }
        catch(Exception ee)
        {
            System.out.print(ee);
        }

        int ctrd=0;
        try
        {
            Connection con = DriverManager.getConnection("jdbc:odbc:nursing");
            String str = "select doctor_id  from doctbl '";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(str);

            while(res.next())
            {
                ctrd++;
            }

            label44.setText(String.valueOf(ctrd));


        }
        catch(Exception ee)
        {
            System.out.print(ee);
        }

        int ctrt=0;
        try
        {
            Connection con = DriverManager.getConnection("jdbc:odbc:nursing");
            String str = "select t_reqid from testrequesttbl where test_date ='"+sdf.format(dt)+"'";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(str);
            while(res.next())
            {
                ctrt++;
            }

            System.out.print(ctrt);

            label33 .setText(String.valueOf(ctrt));


        }
        catch(Exception ee)
        {
            System.out.print(ee);
        }



        int ctrta=0;
        try
        {
            Connection con = DriverManager.getConnection("jdbc:odbc:nursing");
            String str = "select testr_id  from testdetailstbl '";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(str);

            while(res.next())
            {
                ctrta++;
            }

            label55.setText(String.valueOf(ctrta));


        }
        catch(Exception ee)
        {
            System.out.print(ee);
        }

        int ctrdt=0;
        try
        {
            Connection con = DriverManager.getConnection("jdbc:odbc:nursing");
            String str = "select pat_id  from pattbl where status = 'discharged'"+ " and discharge_date = '"+sdf.format(dt)+"'";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(str);
            while(res.next())
            {
                ctrdt++;
            }

            System.out.print(ctrdt);

            label66.setText(String.valueOf(ctrdt));


        }
        catch(Exception ee)
        {
            System.out.print(ee);
        }

        int ctrp=0;
        try
        {
            Connection con = DriverManager.getConnection("jdbc:odbc:nursing");
            String str ="select pay_id from paymenttbl where payment_date ='"+sdf.format(dt)+"'";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(str);
            while(res.next())
            {
                ctrp++;
            }

            label22.setText(String.valueOf(ctrp));


        }
        catch(Exception ee)
        {
            System.out.print(ee);
        }

        int ctrbc=0;
        try
        {
            Connection con = DriverManager.getConnection("jdbc:odbc:nursing");
            String str ="select * from wardtbl where ward ='CCU'";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(str);
            while(res.next())
            {
                for(int i=3;i<18;i++)
                {
                    String cstat=res.getString(i);
                    if(cstat.equalsIgnoreCase("A"))
                    {
                       ctrbc++;
                    } 
                }
            }

            label77.setText(String.valueOf(ctrbc));
        }
        catch(Exception ee)
        {
            System.out.print(ee);
        }

        int ctrbi=0;
        try
        {
            Connection con = DriverManager.getConnection("jdbc:odbc:nursing");
            String str ="select * from wardtbl where ward ='ICU'";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(str);
            while(res.next())
            {
                for(int i=3;i<18;i++)
                {
                    String istat=res.getString(i);
                    if(istat.equalsIgnoreCase("A"))
                    {
                       ctrbi++;
                    } 
                }
            }

            label88.setText(String.valueOf(ctrbi));
        }
        catch(Exception ee)
        {
            System.out.print(ee);
        }

        int ctrbgm=0;
        try
        {
            Connection con = DriverManager.getConnection("jdbc:odbc:nursing");
            String str ="select * from wardtbl where ward ='GENM'";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(str);
            while(res.next())
            {
                for(int i=3;i<18;i++)
                {
                    String mstat=res.getString(i);
                    if(mstat.equalsIgnoreCase("A"))
                    {
                       ctrbgm++;
                    } 
                }
            }

            label99.setText(String.valueOf(ctrbgm));
        }
        catch(Exception ee)
        {
            System.out.print(ee);
        }

        int ctrbgf=0;
        try
        {
            Connection con = DriverManager.getConnection("jdbc:odbc:nursing");
            String str ="select * from wardtbl where ward ='CCU'";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(str);
            while(res.next())
            {
                for(int i=3;i<18;i++)
                {
                    String fstat=res.getString(i);
                    if(fstat.equalsIgnoreCase("A"))
                    {
                       ctrbgf++;
                    } 
                }
            }

            label110.setText(String.valueOf(ctrbgf));
        }
        catch(Exception ee)
        {
            System.out.print(ee);
        }
    

        repaint();
        
    }

  
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == mastpatient)
        {
            
            patient obj4 = new patient();
            this.dispose();
           
           
        }
        if(e.getSource()==mastdoctor)
        {
            doctor obj3 = new doctor();
            this.dispose();
          
        }
        
        if(e.getSource()==masttest)
        {
            test obj5 = new test();
            this.dispose();
            
          
        }
        if(e.getSource()==mastward)
        {
            ward wobj = new ward();
            this.dispose();
        }

        if(e.getSource() ==  transadmit)
        {
            wardsel obj2 = new wardsel(1);
            this.dispose();
        }
        
        if(e.getSource() ==  transtestrequest)
        {
            test_request trobj = new test_request();
            this.dispose();
        }

        if(e.getSource()== transpayment)
        {
            payment payobj = new payment(); 
            this.dispose();

        }

        if(e.getSource() ==  exiting)
        {
            splash_page obj1 = new splash_page();
            this.dispose();
        }

        if(e.getSource() ==  transdischarge)
        {
            discharge objd = new discharge();
            this.dispose();
        }
        
        if(e.getSource() ==  transrefund)
        {
            refund rfobj = new refund();
            this.dispose();
        }
        
        if(e.getSource() ==  transbedchange)
        {
            bedchange bdobj = new bedchange("");
            this.dispose();
        }

        if(e.getSource() ==  reporttest)
        {
            test_report trobj = new test_report();
            this.dispose();
        }

        if(e.getSource() == reportpay)
        {
            payment_report bdobj = new payment_report();
            this.dispose();
        }

        if(e.getSource() ==  blogout)
        {
            logout objl = new logout();
            this.dispose();
        }
            
    }

    public void mouseClicked(MouseEvent m)
    {
        if(m.getSource() == lbl1[0])
        {
            doctor objd = new doctor();
            this.dispose();
        }
        if(m.getSource() == lbl1[1])
        {
            patient objp = new patient();
            this.dispose();
        }
        if(m.getSource() == lbl1[2])
        {
            test_request objtr = new test_request();
            this.dispose();
        }
        if(m.getSource() == lbl1[3])
        {
            payment objpy = new payment(); 
            this.dispose();

        }
        if(m.getSource() == lbl1[4])
        {
            wardsel obj2 = new wardsel(1);
            this.dispose();
        }
        if(m.getSource() == lbl1[5])
        {
            bedchange bdobj = new bedchange("");
            this.dispose();
        }
        if(m.getSource() == lbl1[6])
        {
            doctor objd = new doctor();
            this.dispose();
        }
        if(m.getSource() ==  lbl1[7])
        {
            test_report trobj = new test_report();
            this.dispose();
        }

        if(m.getSource() == lbl1[8])
        {
            payment_report bdobj = new payment_report();
            this.dispose();
        }
    }

    public void mouseDragged(MouseEvent m)
    {}
     
    public void mouseEntered(MouseEvent m)
    {}

    public void mouseExited(MouseEvent m)
    {}

    public void mouseMoved(MouseEvent m)
    {}

    public void mousePressed(MouseEvent m)
    {}

    public void mouseReleased(MouseEvent m)
    {}


   

    public static void main(String[] args) 
    {
        third obj = new third ("s","e"); 
    }

    
    
}
