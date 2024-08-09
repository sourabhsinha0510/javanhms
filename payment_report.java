import java.awt.*;
import java.awt.event.*;
import java.io.PrintWriter;

import javax.swing.*;

import org.omg.SendingContext.RunTime;

import java.sql.*;
public class payment_report extends JFrame implements ActionListener,MouseListener,MouseMotionListener
{
    JLabel lblback = new JLabel(" ");
    
    JLabel lblhead         = new JLabel(" ");
    JLabel lbltest         = new JLabel("PAYMENT REPORT");
  
    JLabel lblback1    = new JLabel("");
    JLabel lblback1a   = new JLabel("");

    JLabel lbldatefrom     = new JLabel("Date from :-");
    JLabel lbldateto       = new JLabel("Date to :-");
    
    JTextField txdatefrom    = new JTextField();
    JTextField txdateto      = new JTextField();

    JButton bok      = new JButton("OK");
    
    public payment_report()
    {
        setVisible(true);
        setSize(600,400);
        setTitle("Test");
        setLayout(null);
        setLocationRelativeTo(null);

        
        lblhead.setBounds(00,05,600,60);
        lblhead.setBackground(new Color (0,0,105));
        lblhead.setOpaque(true);

        lbltest.setBounds(240,5,150,60);
        lbltest.setFont(new Font("Arial",Font.BOLD,18));
        lbltest.setForeground(new Color(255,255,255));

        lblback1.setBounds(65,80,450,250);
        lblback1.setBackground(new Color(0,0,105));
        lblback1.setOpaque(true);
    
        lblback1a.setBounds(67,82,446,246);
        lblback1a.setBackground(new Color(200,206,211));
        lblback1a.setOpaque(true);

        lbldatefrom.setBounds(75,95,80,50);
        lbldateto.setBounds(290,95,80,50);
        txdatefrom.setBounds(155,105,100,30);
        txdateto.setBounds(390,105,100,30);

        bok.setBounds(250,200,80,30);
        bok.setFont(new Font("Arial",Font.BOLD,18));
        bok.setBackground(new Color(0,0,255));
        bok.setForeground(new Color(255,255,255));

        //back
        lblback.setBounds(00,00,600,400);
        lblback.setBackground(new Color(200,206,211));
        lblback.setOpaque(true);

        add(lbltest);
        add(lblhead);
        add(lbldatefrom);
        add(txdatefrom);
        add(lbldateto);
        add(txdateto);
        add(bok);
        add(lblback1a);
        add(lblback1);
        add(lblback);

        bok.addActionListener(this);
        bok.addMouseListener(this);

        repaint();

    }

    public void actionPerformed(ActionEvent e)
    {
      if(e.getSource()==bok)
      {
        try 
        {
          Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
          String str = "select * from paymenttbl where payment_date between #"+ txdateto.getText()+"# and #"+txdatefrom.getText()+"#";
          Statement st=con.createStatement();
          ResultSet res=st.executeQuery(str);
          PrintWriter pw = new PrintWriter("pay.txt");
          pw.println("\t\t\t\t\tPayment Report");
          pw.println("");
          pw.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
          pw.print("\t Payment ID ");
          pw.print("\tPatient ID ");
          pw.print("\tTest Charge");
          pw.print("\tBed Charge");
          pw.print("\tTotal Bill");
          pw.print("\t\tAmt Paid");
          pw.println("");
          pw.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
          while(res.next())
          {
            pw.printf("%30s",res.getString(1));
            pw.printf("%35s",res.getString(3));
            pw.printf("%34s",res.getString(9));
            pw.printf("%33s",res.getString(10));
            pw.printf("%31s",res.getString(6));
            pw.printf("%29s",res.getString(7));
            pw.println("");
            pw.println("");
          }
          pw.close();
          Runtime rt = Runtime.getRuntime();
          rt.exec("notepad pay.txt");
          
        } 
        catch (Exception ee) 
        {
          System.out.println(ee);
        }
      }
    }

    public void mouseClicked(MouseEvent m)
    {}

    public void mouseDragged(MouseEvent m)
    {}
     
    public void mouseEntered(MouseEvent m)
    {
      if(m.getSource()==bok)
      {
        bok.setForeground(new Color(0, 0, 105));
        bok.setBackground(new Color(255,255,255));
      }
    }

    public void mouseExited(MouseEvent m)
    {
        if(m.getSource()==bok)
        {
          bok.setBackground(new Color(0, 0, 105));
          bok.setForeground(new Color(255,255,255));
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
        payment_report objd = new payment_report();
    }


}