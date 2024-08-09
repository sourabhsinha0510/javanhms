import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class wardsel extends JFrame implements ActionListener, ItemListener
{
    JButton b[] = new JButton[20];
    JButton a = new JButton();
    JComboBox wardbox = new JComboBox();
    JButton bexit = new JButton("exit");
    int xx;
    String st1,st2;

    JLabel lbl[] = new JLabel[20];
    Dimension di = Toolkit.getDefaultToolkit().getScreenSize();
    
    public wardsel( int xy)
    {
        xx=xy;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        Date dt=new Date();
        setVisible(true);
        setSize(900,700);
        setTitle("BED SELECTION");
        setLayout(null);
        setSize((int)di.getWidth(),(int)di.getHeight());
        
        wardbox.addItem("ICU");
        wardbox.addItem("GENM");
        wardbox.addItem("GENF");
        wardbox.addItem("CCU");

        wardbox.setBounds(500,500,100,60);
        bexit.setBounds(300,500,80,40);
        add(wardbox);
        add(bexit);
        wardbox.addActionListener(this);
        bexit.addActionListener(this);
        repaint();


        int x=100;
        int y = 100;  
        
       
		
		for(int j=0 ; j<15 ; j++)
		{
			b[j] = new JButton();
		}
        for(int j=0 ; j<15 ; j++)
        {
            if(x%500==0)
            {
                x = 100;
                y=y+100;
            }
            b[j].setBounds(x,y,70,70);
            x=x+100;
            b[j].setIcon(new ImageIcon("zimg4.jpg"));
            add(b[j]);
            b[j].addActionListener(this);
    
        b[j].setBackground(new Color(125,255,125));
        }

        for(int j=0 ; j<15 ; j++)
		{
			lbl[j] = new JLabel();
		}

        x=0;
        y=0;
        for(int k=0 ; k<15 ; k++)
        {
            if(x%500==0)
            {
                x = 300;
                y=y+300;
            }
            lbl[k].setBounds(x,y,70,70);
            x=x+100;
           // lbl[k].setIcon(new ImageIcon("zimg4.jpg"));
            add(lbl[k]);
            //lbl[i].setBackground(new Color(255,68,68));
        }
        
            System.out.print("hello");
			wardbox.addItemListener(this);
    }
	public void itemStateChanged(ItemEvent ie)
	{
        int flag = 0;
        int i;
		if(ie.getStateChange()==ItemEvent.SELECTED)
		{
            flag =1;
			try
			{
				int ctr=0; 
				Connection con=DriverManager.getConnection("jdbc:odbc:nursing");
				String str="select * from wardtbl where ward='"+wardbox.getSelectedItem().toString()+"'";
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery(str);
				while(res.next())
				{
          
					for(i=3;i<18;i++)
					{
                        String tstat=res.getString(i);
						if(tstat.equalsIgnoreCase("x"))
						{
							ctr++;
                            b[i-3].setVisible(false);
                            b[i-3].setBackground(new Color(255,68,68));
                            b[i-3].setEnabled(false);
						}
                        else
                        {
                            if(tstat.equalsIgnoreCase("NA"))
                            {
                                b[i-3].setVisible(true);
                                b[i-3].setBackground(new Color(255,68,68));
                                b[i-3].setEnabled(false);
    
                            }
                            if(tstat.equalsIgnoreCase("A"))
                            {
                                b[i-3].setVisible(true);
                                b[i-3].setBackground(new Color(125,255,125));
								b[i-3].setEnabled(true);
                                b[i-3].setText(wardbox.getSelectedItem().toString()+" "+(i-2));
                            }
                        }
					}
					for(i=0;i<14-ctr;i++)
					{
						b[i].setVisible(true);
					}

					for(i=3;i<18;i++)
					{
                        //System.out.print(i);
						/*if(res.getString(i).equalsIgnoreCase("A"))
                        {w
						    b[i].setBackground(new Color(255,68,68));
						    b[i].setEnabled(false);
                        }
                        */
					}
                    
                    //System.out.print("111111111111");
					
				}
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
            
		}
	}
    public void actionPerformed(ActionEvent e)
    {
        for(int i=0 ; i<15 ; i++)
        {
            if(e.getSource() == b[i])
            {
                if(xx == 1)
                {

                    String txt = b[i].getText().toString();
                    b[i].setBackground(new Color(255,68,68));
                    patient_details pdobj = new patient_details(txt);
                    this.dispose();
                }

                else
                {
                    String txt = b[i].getText().toString();
                    b[i].setBackground(new Color(255,68,68));
                    bedchange bdobj = new bedchange(txt);
                    this.dispose();
                }
            }
        }
        if(e.getSource()==bexit)
        {
            third obj2 = new third(st1,st2);
            this.dispose();
        }
            
    }
    public static void main(String[] args) {
        wardsel obj2 = new wardsel(10);
    }
    
}