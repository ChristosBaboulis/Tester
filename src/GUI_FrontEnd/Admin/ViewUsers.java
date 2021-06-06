package GUI_FrontEnd.Admin;

import java.util.EventListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ViewUsers extends JFrame
{
    static ViewUsers frame;
    private JLabel contentPane;
    private JTable table;
    
    //VIEW USERS FRAME LAUNCH
    public static void main(String[] args)
    {
        EventQueue.invokeLater
        (
            new Runnable()
            {
                public void run()
                {
                    try
                    {
                        frame = new ViewUsers();
                        frame.setVisible(true);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        );
    }

    public ViewUsers()
        {
            //FRAME & CONTENT PANE CREATION
            setDefaultCloseOperation(HIDE_ON_CLOSE);
            setBounds(100, 100, 650, 300);
            contentPane = new JLabel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);

            //TABLE CREATION
            //BackEnd Code
            table = new JTable(100, 10);

            //CONTENT PANE"S LAYOUT CREATION
            contentPane.setLayout(new BorderLayout(0, 0));

            //SCROLL PANE CREATION
            JScrollPane sp = new JScrollPane(table);
            contentPane.add(sp, BorderLayout.CENTER);
            
        }
}
