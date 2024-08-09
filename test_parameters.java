import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class test_parameters extends JFrame implements ActionListener,KeyListener,MouseListener,MouseMotionListener
{

    JLabel lblback = new JLabel(" ");

    JLabel label1  = new JLabel("");
    JLabel label1a = new JLabel("");

    JLabel label2  = new JLabel("");
    JLabel label2a = new JLabel("");

    JLabel lbldiv = new JLabel("");
    JLabel lblparaname = new JLabel("PARAMETERS NAME",JLabel.CENTER);
    JLabel lblparavalue = new JLabel("DEFAULT VALUE",JLabel.CENTER);
  
    JLabel lblhead         = new JLabel(" ");
    JLabel lbltestdetail    = new JLabel("TEST PARAMETERS ");

    JLabel lbltestid         = new JLabel("Test id :-");
    JLabel lbltestname       = new JLabel("Test NAME :-");
    JLabel lbltestcharge     = new JLabel("testcharge :-");
    JLabel lblparameter      = new JLabel("Parameter Count:-");

    JTextField txtestid         = new JTextField();
    JTextField txtestname       = new JTextField();
    JTextField txtestcharge     = new JTextField();
    JTextField txparameter      = new JTextField();

    JButton bsave     = new JButton("Save");
    JButton bexit     = new JButton("Exit");

    JLabel lblpara[] = new JLabel[20];
    JTextField txtparaname[] = new JTextField[7];
    JTextField txtparavalue[] = new JTextField[7];
    int testpara = 0;

    String st1,st2; 

    public test_parameters(String a,String b,String c,Integer d)
    {
        setVisible(true);
        setSize(800,730);
        setTitle("Test");
        setLayout(null);
        setLocationRelativeTo(null);

        String testid = a;
        String testname = b;
        String testcharge = c;
        testpara = d;
        String testparastr = String.valueOf(testpara);

        //back
        lblback.setBounds(00,00,800,900);
        lblback.setBackground(new Color(200,206,211));
        lblback.setOpaque(true);

        
        //head
        lblhead.setBounds(00,05,900,60);
        lblhead.setBackground(new Color (0,0,105));
        lblhead.setOpaque(true);
        
        lbltestdetail.setBounds(290,5,800,60);
        lbltestdetail.setFont(new Font("Arial",Font.BOLD,18));
        lbltestdetail.setForeground(new Color(255,255,255));
        
        //box
        label1.setBounds(40,80,700,100);
        label1.setBackground(new Color(0,0,105));
        label1.setOpaque(true);

        label1a.setBounds(42,82,696,96);
        label1a.setBackground(new Color(200,206,211));
        label1a.setOpaque(true);

        lbldiv.setBounds(00,190,800,40);
        lbldiv.setBackground(new Color(0,0,105));
        lbldiv.setOpaque(true);
        

        lblparaname.setBounds(240,200,250,20);
        lblparaname.setForeground(new Color(255,255,255));
        lblparaname.setFont(new Font("Arial",Font.BOLD,16));
        lblparaname.setBackground(new Color(0,0,108));
        lblparaname.setOpaque(true);

        lblparavalue.setBounds(480,200,250,20);
        lblparavalue.setForeground(new Color(255,255,255));
        lblparavalue.setFont(new Font("Arial",Font.BOLD,16));
        lblparavalue.setBackground(new Color(0,0,108));
        lblparavalue.setOpaque(true);

        
        lbltestid.setBounds(180,90,110,30);
        lbltestname.setBounds(440,90,110,30);
        lbltestcharge.setBounds(120,130,110,30);
        lblparameter.setBounds(480,130,110,30);

        txtestid.setBounds(240,90,110,30);
        txtestname.setBounds(520,90,110,30);
        txtestcharge.setBounds(200,130,110,30);
        txparameter.setBounds(590,130,110,30);

        label2.setBounds(240,605,300,70);
        label2.setBackground(new Color(0,0,105));
        label2.setOpaque(true);

        label2a.setBounds(242,607,296,66);
        label2a.setBackground(new Color(200,206,211));
        label2a.setOpaque(true);

        bsave.setBounds(300,625,70,30);
        bsave.setBackground(new Color(0,0,105));
        bsave.setForeground(new Color(255,255,255));

        bexit.setBounds(410,625,70,30);
        bexit.setBackground(new Color(0,0,105));
        bexit.setForeground(new Color(255,255,255));

        for(int i=0 ; i<7 ; i++)
        {
            lblpara[i] = new JLabel("Parameter "+(i+1));
            txtparaname[i] = new JTextField();
            txtparavalue[i] = new JTextField();     
        }
        
        int j=0;
        int k=0;
        for(int ii=0 ; ii<testpara ; ii++)
        {
           
            lblpara[ii].setBounds(50,250+j,150,25);
            lblpara[ii].setFont(new Font("Arial",Font.BOLD,14));
            add(lblpara[ii]);
            j+=50;

            txtparaname[ii].setBounds(310,250+k,100,25);
            txtparaname[ii].setFont(new Font("Arial",Font.BOLD,14));
            add(txtparaname[ii]);  

            txtparavalue[ii].setBounds(550,250+k,100,25);
            txtparavalue[ii].setFont(new Font("Arial",Font.BOLD,14));
            add(txtparavalue[ii]);
            k+=50;
        }

        add(lbltestdetail);
        add(lblhead);

        add(lbltestid);
        add(lbltestname);
        add(lbltestcharge);
        add(lblparameter);

        add(txtestid);
        add(txtestname);
        add(txtestcharge);
        add(txparameter);
        
        add(label1a);
        add(label1);

        add(lblparaname);
        add(lblparavalue);
        add(lbldiv);

        add(bsave);
        add(bexit);

        add(label2a);
        add(label2);

        add(lblback);

        txtestid .setEditable(false);  
        txtestcharge .setEditable(false);  
        txparameter .setEditable(false);  
        txtestname.setEditable(false);  

        bexit.addActionListener(this);
        bsave.addActionListener(this);
       

        bexit.addMouseListener(this);
        bsave.addMouseListener(this);

        for(int aa=0 ; aa<7 ; aa++)
        {
            txtparaname[aa].addKeyListener(this);
            txtparavalue[aa].addKeyListener(this);
        }


        txtestid.setText(testid);
        txtestname.setText(testname);
        txtestcharge.setText(testcharge);
        txparameter.setText(testparastr);
        
        

        repaint();


    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == bsave)
        {
            int ctr=0;
            for(int i=0 ; i<testpara ; i++)
            {
                if(txtparaname[i].getText().equals(""))
                {
                    ctr++;
                }
                if(txtparavalue[i].getText().equals(""))
                {
                    ctr++;
                }
            }
            System.out.println(ctr);
            if(ctr==0)
            {
                try
                    {
                    Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
                    String str = "INSERT INTO testdetailstbl (testr_id,test_Name,nos,test_charge,parameter1,parameter2,parameter3,parameter4,parameter5,parameter6,parameter7)values(?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(str);
                    ps.setString(1, txtestid.getText());
                    ps.setString(2, txtestname.getText());
                    ps.setString(3, txparameter.getText());
                    ps.setString(4, txtestcharge.getText());
                    ps.setString(5, txtparaname[0].getText());
                    ps.setString(6, txtparaname[1].getText());
                    ps.setString(7, txtparaname[2].getText());
                    ps.setString(8, txtparaname[3].getText());
                    ps.setString(9, txtparaname[4].getText());
                    ps.setString(10, txtparaname[5].getText());
                    ps.setString(11, txtparaname[6].getText());
                    
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Saved Successfully");
                } 
                
                catch(Exception ee)
                {
                    System.out.println(ee);
                }
                try
                    {
                    Connection con1=DriverManager.getConnection("jdbc:odbc:nursing");
                    String str1 = "INSERT INTO testvaluetbl (test_id,test_name,nos,value1,value2,value3,value4,value5,value6,value7)values(?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement ps1 = con1.prepareStatement(str1);
                    ps1.setString(1, txtestid.getText());
                    ps1.setString(2, txtestname.getText());
                    ps1.setString(3, txparameter.getText());
                    ps1.setString(4, txtparavalue[0].getText());
                    ps1.setString(5, txtparavalue[1].getText());
                    ps1.setString(6, txtparavalue[2].getText());
                    ps1.setString(7, txtparavalue[3].getText());
                    ps1.setString(8, txtparavalue[4].getText());
                    ps1.setString(9, txtparavalue[5].getText());
                    ps1.setString(10, txtparavalue[6].getText());
                    
                    ps1.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Saved Successfully");
                } 
                
                catch(Exception ee)
                {
                    System.out.println(ee);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please fill all fields!!!");
            }
        }

       
        if(ae.getSource()==bexit)
        {

            third obj2 = new third(st1,st2);
            this.dispose(); 
        }
        
    }

    public void focusGained(FocusEvent fe)
    {}

    public void focusLost(FocusEvent fe)
    {}

    public void mouseClicked(MouseEvent m)
    {}

    public void mouseDragged(MouseEvent m)
    {}
    
     
    public void mouseEntered(MouseEvent m)
    {
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

    public void keyTyped(KeyEvent e) 
    {}
    
    public void keyPressed(KeyEvent e) 
    {}
    
    public void keyReleased(KeyEvent ke)
    {
        for(int j=0 ; j<7 ; j++)
        {
            if(ke.getSource() == txtparaname[j])
            {
                String pat_contact = txtparaname[j].getText();
                for(int i=0 ; i<pat_contact.length() ; i++)
                {
                char ch = pat_contact.charAt(i);
                if(ch>='a' & ch<='z' || ch>='A' & ch<='Z' || ch>='0' & ch<='9')
                {}
                else
                {
                    pat_contact = pat_contact.substring(0, pat_contact.length()-1);
                    txtparaname[j].setText(pat_contact);
                } 
                }
            }
        }

        for(int j=0 ; j<7 ; j++)
        {
            if(ke.getSource() == txtparavalue[j])
            {
                String pat_contact = txtparavalue[j].getText();
                for(int i=0 ; i<pat_contact.length() ; i++)
                {
                char ch = pat_contact.charAt(i);
                if(ch>='0' & ch<='9' || ch == '.' || ch == '>' || ch == '<')
                {}
                else
                {
                    pat_contact = pat_contact.substring(0, pat_contact.length()-1);
                    txtparavalue[j].setText(pat_contact);
                } 
                }
            }
        }
    }

    public static void main(String[] args) 
    {
        test_parameters obj4 = new test_parameters("aa","bb","cc",7);
        
    }
}


