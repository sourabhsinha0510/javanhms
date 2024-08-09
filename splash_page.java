import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class splash_page extends JFrame implements ActionListener
{
    int ctr = 0;
    JProgressBar pbar = new JProgressBar();
    JLabel lblback2 = new JLabel();
    JLabel lblback1 = new JLabel();
    JLabel lblback = new JLabel(new ImageIcon("zimg1.jpeg"));
    JLabel l1 = new JLabel("NURSING HOME");
    JLabel l2 = new JLabel("", SwingConstants.CENTER);
    JLabel l4 = new JLabel("DEVELOPED BY - sourabh");
    
    public splash_page()
    {
        setVisible(true);
        
        setSize(826,700);
        setTitle("Nursing Home");
        setLayout(null);
        setLocationRelativeTo(null);
        setBackground(new Color(120,120,120));

        lblback2.setBounds(00,05,826,80);
        lblback2.setBackground(new Color(0,0,105));
        lblback2.setOpaque(true);

        pbar.setBounds(13,500,784,30);
        lblback.setBounds(-10,100,826,300);
        l1.setBounds(280,-100,826,300);
        l2.setBounds(-10,450,826,40);
        
        l4.setBounds(390,600,350,40);
        
        lblback.setOpaque(true);
        lblback1.setOpaque(true);
        pbar.setValue(0 );
        pbar.setBorderPainted(false);
        pbar.setStringPainted(true);
        pbar.setBackground(new Color(200,206,211));
        pbar.setForeground(new Color(20,20,160));
        pbar.setFont(new Font("Arial", Font.BOLD, 20));

        lblback1.setBounds(0,0,826,1000);
        lblback1.setBackground(new Color(200,206,211));
        
        
        l1.setFont(new Font("Algerian",Font.BOLD,36));
        l1.setForeground(new Color(255,255,255));
        l2.setFont(new Font("Arial",Font.BOLD,22));
        l2.setForeground(new Color(20,20,160)); 
      
        l4.setFont(new Font("Algerian",Font.BOLD,16));
        l4.setForeground(new Color(20,20,160)); 
       
        add(l1);
        add(lblback2);
        add(pbar);
        add(l2);
                             
        add(l4);
       // add(b1);
        add(lblback);
        add(lblback1);

       
        start1();

    }
    public void actionPerformed(ActionEvent e)
    {
    }
    public void start1()
    {
        int i=0;
        pbar.setValue(0);
        ctr = 0;
        while(ctr<=100)
        {
            pbar.setValue(ctr);
            try
            {
                if(ctr<30)
                {
                    i=50;
                    l2.setText("Working on it");
                }
                else if(ctr>30 && ctr<34)
                {
                    i=500;
                    l2.setText("Loading......");
                }
                else if(ctr>60 && ctr<64)
                {
                    i=500;
                    l2.setText("Loading the system for you!!!");
                }
                else
                {
                    i=50;
                    l2.setText("Processing......");
                }
                Thread.sleep(i);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            ctr++;
            if(ctr==100)
        {
            
            this.dispose();
            login obj1 = new login();
        }
        }
        
    }
    public static void main(String[] args) 
    {
        splash_page obj = new splash_page();
    }
}
