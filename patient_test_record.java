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
public class patient_test_record extends JFrame implements  ActionListener,MouseListener,MouseMotionListener,FocusListener
{
    
    JLabel lblback = new JLabel(" ");
    
    JLabel lblhead         = new JLabel(" ");
    JLabel lbltestdetail    = new JLabel("PATIENT TEST RECORDS");
    
    JLabel lblback1    = new JLabel("");
    JLabel lblback1a   = new JLabel("");
    
    JLabel lbltxt1   = new JLabel("Test Records");
    
    JLabel lblback2    = new JLabel("");
    JLabel lblback2a   = new JLabel("");
    
    JLabel lblpat_id = new JLabel("PATIENT ID - ");
    JTextField txtpat_id = new JTextField();

    JButton bexit = new JButton("Exit");

    String[] col= {"Test ReqId","Test Name","Test Id","Test Charge","Test Date"};
    String test_reqid,ttid,ttname,ttcharge,test_date;
	Object[][] data = {{test_reqid,ttid,ttname,ttcharge,test_date}};
	DefaultTableModel  model = new DefaultTableModel(col,0);
	JTable jtbltest = new JTable(data,col);
    JScrollPane sct;

    String pat_id = "";

    String st1 , st2;

    public patient_test_record(String patient_id)
    {
        setVisible(true);
        setSize(1000,600);
        setTitle("TEST RECORDS");
        setLayout(null);
        setLocationRelativeTo(null);

        //head
        lblhead.setBounds(00,05,1000,60);
        lblhead.setBackground(new Color (0,0,105));
        lblhead.setOpaque(true);
 
        lbltestdetail.setBounds(350,5,250,60);
        lbltestdetail.setFont(new Font("Arial",Font.BOLD,18));
        lbltestdetail.setForeground(new Color(255,255,255));
 
 
        //back1
        lblback1.setBounds(50,100,850,380);
        lblback1.setBackground(new Color(0,0,105));
        lblback1.setOpaque(true);
    
        lblback1a.setBounds(52,102,846,376);
        lblback1a.setBackground(new Color(200,206,211));
        lblback1a.setOpaque(true);

        lbltxt1.setBounds(70,80,123,40);
        lbltxt1.setFont(new Font("Arial",Font.BOLD,18));
        lbltxt1.setBackground(new Color(200,206,211));
        lbltxt1.setOpaque(true);
        
        lblpat_id.setBounds(380,110,120,30);
        lblpat_id.setFont(new Font("Arial",Font.BOLD,14));
        txtpat_id.setBounds(480,110,80,30);
        txtpat_id.setFont(new Font("Arial",Font.BOLD,14));

       

        //table
        
        sct=new JScrollPane(jtbltest);
		sct.setBounds(80,160,790,290);
		jtbltest.setModel(model);
        add(sct);

        jtbltest.getTableHeader().setFont(new Font("SansSerif",Font.BOLD,14));

        jtbltest.setFont(new Font("Arial",Font.BOLD,14));
        jtbltest.setForeground(new Color(0,0,108));
        jtbltest.setRowHeight(25);
        jtbltest.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jtbltest.getColumnModel().getColumn(0).setPreferredWidth(105);
        jtbltest.getColumnModel().getColumn(1).setPreferredWidth(340);
        jtbltest.getColumnModel().getColumn(2).setPreferredWidth(120);
        jtbltest.getColumnModel().getColumn(3).setPreferredWidth(110);
        jtbltest.getColumnModel().getColumn(4).setPreferredWidth(110);

        bexit.setBounds(440,490,70,30);
        bexit.setBackground(new Color(0,0,105));
        bexit.setForeground(new Color(255,255,255));

        //back
        lblback.setBounds(00,00,1000,600);
        lblback.setBackground(new Color(200,206,211));
        lblback.setOpaque(true);
 
        //head
        add(lbltestdetail);
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
            model.setRowCount(0);
            Connection con2=DriverManager.getConnection("jdbc:odbc:nursing");
            String str2="select * from testrequesttbl where pt_reqid ='"+pat_id+"'";
            Statement st2=con2.createStatement();
            ResultSet res2=st2.executeQuery(str2);

                    
            while(res2.next())
            {

                Vector v = new Vector();
                v.add(res2.getString(8));
                v.add(res2.getString(2));
                v.add(res2.getString(1));
                v.add(res2.getString(4));
                v.add(res2.getString(11));
                    
                model.addRow(v);
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
                model.setRowCount(0);

                Connection con2=DriverManager.getConnection("jdbc:odbc:nursing");
                String str2="select * from testrequesttbl where pt_reqid ='"+txtpat_id.getText()+"'";
                Statement st2=con2.createStatement();
                ResultSet res2=st2.executeQuery(str2);

                        
                while(res2.next())
                {
                    System.out.print("1111111");
                    count++;
                    Vector v = new Vector();
                    v.add(res2.getString(8));
                    v.add(res2.getString(2));
                    v.add(res2.getString(1));
                    v.add(res2.getString(4));
                    v.add(res2.getString(11));
                    model.addRow(v);
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
        patient_test_record objj = new patient_test_record("p/2");
    }



}