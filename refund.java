import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import javax.naming.spi.DirStateFactory.Result;
import javax.sound.sampled.FloatControl.Type;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
public class refund extends JFrame implements ActionListener  ,FocusListener
{

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
    Date dt=new Date();

    JLabel  lblrefund =  new JLabel("Refund");



    JLabel  lblrefid           =  new JLabel("Refund_id");
    JLabel  lblpatid           =  new JLabel("Patient_id");
    JLabel  lblpatname         =  new JLabel("Name");
    JLabel  lbldate            =  new JLabel("Date");
    JLabel  lblcontact         =  new JLabel("Contact");
    JLabel  lblsecuritymoney   =  new JLabel("Security Money");
    JLabel  lblstatus          =  new JLabel("Status");
    JLabel  lblrefstatus       =  new JLabel(" Refund Status");

    Dimension di = Toolkit.getDefaultToolkit().getScreenSize();

  
    JTextField  txrefid           =  new JTextField("");
    JTextField  txpatid           =  new JTextField("");
    JTextField  txpatname         =  new JTextField("");
    JTextField  txdate            =  new JTextField("");
    JTextField  txcontact         =  new JTextField("");
    JTextField  txsecuritymoney   =  new JTextField("");
    JTextField  txstatus          =  new JTextField("");
    JTextField   txrefstatus      =  new JTextField("");

    JButton  brefund = new JButton("REFUND");
    JButton  bnew    = new JButton("NEW");
    JButton  bcancel = new JButton("Cancel");
    



   
    public refund()
    {

        setVisible(true);
        setTitle("Doctor");
        setLayout(null);
        setSize((int)di.getWidth(),(int)di.getHeight());
        setResizable(false);

        lblrefund.setBounds(400,5,120,20);

        lblrefid.setBounds(20,70,70,30);
        lblpatid.setBounds(220,70,70,30);
        lblpatname.setBounds(20,140,70,30);
        lbldate.setBounds(420,70,70,30);
        lblcontact.setBounds(220,140,80,30);
        lblsecuritymoney.setBounds(20,210,100,30);
        lblstatus.setBounds(220,210,100,30);
        lblrefstatus.setBounds(100,250,100,30);

        txrefid.setBounds(120,70,70,30);
        txpatid.setBounds(320,70,70,30);
        txpatname.setBounds(120,140,70,30);
        txdate.setBounds(520,70,70,30);
        txcontact.setBounds(320,140,70,30);
        txsecuritymoney.setBounds(120,210,70,30);
        txstatus.setBounds(320,210,70,30);
        txrefstatus.setBounds(190,250,70,30);


        bnew.setBounds(200,300,100,30);
        brefund.setBounds(120,350,100,30);
        bcancel.setBounds(320,350,100,30);

        add(lblrefund);
       
        add(lblpatid);
        add(lblrefid);
        add(lblpatname);
        add(lbldate);
        add(lblcontact);
        add(lblsecuritymoney);
        add(lblstatus);
      
        
        add(txpatid);
        add(txrefid);
        add(txpatname);
        add(txdate);
        add(txcontact);
        add(txsecuritymoney);
        add(txstatus);
        

        add(brefund);
        add(bcancel);
        add(bnew);

        

        txpatid.addFocusListener(this);

        brefund.addActionListener(this);
        bcancel.addActionListener(this);
        bnew.addActionListener(this);

        txdate.setText(sdf.format(dt));

        txpatname.setEditable(false);
        txdate.setEditable(false);
        txcontact.setEditable(false);
        txsecuritymoney.setEditable(false);
        txstatus.setEditable(false);
        txrefid.setEditable(false);



    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == brefund)
        {
            try
            {
                Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
                String str3 = "INSERT INTO refundtbl (refund_id,patient_id,patient_name,contact,refund_status,r_date)values(?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(str3);
                ps.setString(1, txrefid.getText());
                ps.setString(2, txpatid.getText());
                ps.setString(3, txpatname.getText());
                ps.setString(4, txcontact.getText());
                ps.setString(5, "refunded");
                ps.setString(6, txdate.getText());
                ps.executeUpdate();
                String str1 = "update keytbl set refund_id = refund_id + 1";
                Statement st1 = con.createStatement();
                st1.executeUpdate(str1);
                System.out.println("jgijdifdhcusjfuh");
                JOptionPane.showMessageDialog(null, "Record Saved Successfully");
            }
            catch(Exception ee)
            {
                System.out.print(ee);
            }

            JOptionPane.showMessageDialog(null, "Refunded");
            
        }

        if(e.getSource() == bnew)
        {
            try
            {
                
                Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
                String str = "select refund_id from keytbl";
                Statement st=con.createStatement();
                ResultSet res=st.executeQuery(str);
                while(res.next())
                {
                        
                    txrefid.setText("ref/"+res.getString(1));
                }
                      
            }
            catch(Exception ee)
            {
                System.out.print(ee);
            }
        }

        if(e.getSource()==bcancel)
        {
            this.dispose();
        }
    }

    public void focusLost(FocusEvent fe)
    {
        if(fe.getSource()== txpatid)
        {
            try
            {
                Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
                String str="select * from pattbl where pat_id ='"+txpatid.getText().toString()+"'";
                Statement st=con.createStatement();
                ResultSet res=st.executeQuery(str);
                while(res.next())
                {
                    txpatname.setText(res.getString(2));
                    txcontact.setText(res.getString(4));
                    txsecuritymoney.setText(res.getString(9));
                    txstatus.setText(res.getString(8));
                }
                
            }
            catch(Exception ee)
            {
                System.out.print(ee);
            }

            if(txstatus.getText().equalsIgnoreCase("admitted"))
            {
                   brefund.setEnabled(false);
            }

            else
            {
                brefund.setEnabled(true);
            }
        

        }
          
    }
   
    public void focusGained(FocusEvent fe)
    {}
    
    public static void main(String[] args) 
    {
        refund rfobj = new refund();
    }

}  














