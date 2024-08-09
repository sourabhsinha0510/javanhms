import java.awt.*;
import java.awt.event.*;
import java.lang.Character.Subset;
import java.sql.ResultSet;
import java.sql.*;

import javax.naming.NameNotFoundException;
import javax.naming.spi.DirStateFactory.Result;
import javax.sound.sampled.FloatControl.Type;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.math.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class patient_bed_details extends JFrame implements  ActionListener,MouseListener,MouseMotionListener,FocusListener
{
    
    JLabel lblback = new JLabel(" ");
    
    JLabel lblhead         = new JLabel(" ");
    JLabel lblbeddetail    = new JLabel("PATIENT BED RECORDS");
    
    JLabel lblback1    = new JLabel("");
    JLabel lblback1a   = new JLabel("");
    
    JLabel lbltxt1   = new JLabel("Bed Records");
    
    JLabel lblback2    = new JLabel("");
    JLabel lblback2a   = new JLabel("");
    
    JLabel lblpat_id = new JLabel("PATIENT ID - ");
    JTextField txtpat_id = new JTextField();

    JButton bexit = new JButton("Exit");

    String[] coll= {"Admission Id","From","To","Type"};
    String from,to,type,charge;
	Object[][] bdata = {{from,to,type,charge}};
	DefaultTableModel  bmodel = new DefaultTableModel(coll,0);
	JTable jtblbed = new JTable(bdata,coll);
    JScrollPane scb;

    String pat_id = "";

    String st1 , st2;

    public patient_bed_details(String patient_id)
    {
        setVisible(true);
        setSize(800,600);
        setTitle("BED RECORD");
        setLayout(null);
        setLocationRelativeTo(null);

        //head
        lblhead.setBounds(00,05,900,60);
        lblhead.setBackground(new Color (0,0,105));
        lblhead.setOpaque(true);
 
        lblbeddetail.setBounds(270,5,250,60);
        lblbeddetail.setFont(new Font("Arial",Font.BOLD,18));
        lblbeddetail.setForeground(new Color(255,255,255));
 
 
        //back1
        lblback1.setBounds(60,100,650,380);
        lblback1.setBackground(new Color(0,0,105));
        lblback1.setOpaque(true);
    
        lblback1a.setBounds(62,102,646,376);
        lblback1a.setBackground(new Color(200,206,211));
        lblback1a.setOpaque(true);

        lbltxt1.setBounds(70,80,115,40);
        lbltxt1.setFont(new Font("Arial",Font.BOLD,18));
        lbltxt1.setBackground(new Color(200,206,211));
        lbltxt1.setOpaque(true);
        
        lblpat_id.setBounds(280,110,120,30);
        lblpat_id.setFont(new Font("Arial",Font.BOLD,14));
        txtpat_id.setBounds(380,110,80,30);
        txtpat_id.setFont(new Font("Arial",Font.BOLD,14));

       

        //table
        
        scb=new JScrollPane(jtblbed);
		scb.setBounds(120,160,525 ,290);
		jtblbed.setModel(bmodel);
        add(scb);

        jtblbed.getTableHeader().setFont(new Font("SansSerif",Font.BOLD,14));

        jtblbed.setFont(new Font("Arial",Font.BOLD,18));
        jtblbed.setForeground(new Color(0,0,108));
        jtblbed.setRowHeight(25);
        jtblbed.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jtblbed.getColumnModel().getColumn(0).setPreferredWidth(165);
        jtblbed.getColumnModel().getColumn(1).setPreferredWidth(120);
        jtblbed.getColumnModel().getColumn(2).setPreferredWidth(120);
        jtblbed.getColumnModel().getColumn(3).setPreferredWidth(117);

        bexit.setBounds(340,490,70,30);
        bexit.setBackground(new Color(0,0,105));
        bexit.setForeground(new Color(255,255,255));


        

        //back
        lblback.setBounds(00,00,800,600);
        lblback.setBackground(new Color(200,206,211));
        lblback.setOpaque(true);
 


        //head
        add(lblbeddetail);
        add(lblhead);

        //back1
        add(lbltxt1);
        
        add(bexit);

        add(lblpat_id);
        add(txtpat_id);
        
        add(lblback1a);
        add(lblback1);


        //back
        add(lblback);

        txtpat_id.addFocusListener(this);

        bexit.addActionListener(this);
        bexit.addMouseListener(this);

        repaint();



        try
        {
            Connection con2=DriverManager.getConnection("jdbc:odbc:nursing");
            String str2="select * from patientbedtbl where patient_id ='"+pat_id+"'";
            Statement st2=con2.createStatement();
            ResultSet res2=st2.executeQuery(str2);

            while(res2.next())
            {
                Vector v = new Vector();
                v.add(res2.getString(1));
                v.add(res2.getString(5));
                v.add(res2.getString(7));
                v.add(res2.getString(6));
            
                bmodel.addRow(v);
            }
        }

        catch(Exception ee)
        {
            System.out.println(ee);
        }

    }

    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource() == bexit)
        {
            third obj2 = new third(st1,st2);
            this.dispose();
        }
    }

    public void focusGained(FocusEvent fe)
    {}

    public void focusLost(FocusEvent fe)
    {
        if(fe.getSource() == txtpat_id)
        {
            
            int count = 0;
            try
            {
                
                bmodel.setRowCount(0);

                Connection con2=DriverManager.getConnection("jdbc:odbc:nursing");
                String str2="select * from patientbedtbl where patient_id ='"+txtpat_id.getText()+"'";
                Statement st2=con2.createStatement();
                ResultSet res2=st2.executeQuery(str2);

                while(res2.next())
                {
                    count++;

                    Vector v = new Vector();
                    v.add(res2.getString(1));
                    v.add(res2.getString(5));
                    v.add(res2.getString(7));
                    v.add(res2.getString(6));
                
                    bmodel.addRow(v);
                }
                if(count == 0)
                {
                    JOptionPane.showMessageDialog(null,"Patient Not Found!!!");
                }
            }    

            catch(Exception ee)
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
        
      
      if(m.getSource()==bexit)
      {
        bexit.setForeground(new Color(0, 0, 105));
        bexit.setBackground(new Color(255,255,255));
      }

       
    }

    public void mouseExited(MouseEvent m)
    {
       
        
        
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
        patient_bed_details objj = new patient_bed_details("p/2");
    }



}