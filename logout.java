import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class logout extends JFrame implements ActionListener
{
    int ctr = 0;
    JProgressBar pbar = new JProgressBar();
    JLabel lblback = new JLabel();
    JLabel l2 = new JLabel("", SwingConstants.CENTER);
   
    public logout()
    {
        setVisible(true);
        setSize(826,150);
        setTitle("logout");
        setLayout(null);
        setLocationRelativeTo(null);

        lblback.setBounds(00, 00, 826, 150);
        lblback.setBackground(new Color(200,206,211));
        lblback.setOpaque(true);

        pbar.setBounds(13,70,784,30);
        pbar.setValue(0 );
        pbar.setBorderPainted(false);
        pbar.setStringPainted(true);
        pbar.setBackground(new Color(200,206,211));
        pbar.setForeground(new Color(20,20,160));
        pbar.setFont(new Font("Arial", Font.BOLD, 20));
         
        l2.setBounds(10,30,826,40);
        l2.setFont(new Font("Arial",Font.BOLD,22));
        l2.setForeground(new Color(20,20,160)); 
        
        add(pbar);
        add(l2);
        add(lblback);

        start1();
        repaint();
    }

    public void actionPerformed(ActionEvent e)
    {}

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
                    l2.setText("Saving details ........");
                }
                else if(ctr>30 && ctr<34)
                {
                    i=500;
                    l2.setText("Closing Files......");
                }
                else if(ctr>60 && ctr<64)
                {
                    i=500;
                    l2.setText("processing................");
                }
                else
                {
                    i=50;
                    l2.setText("Loging Out......");
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
        logout obj = new logout();
    }
}