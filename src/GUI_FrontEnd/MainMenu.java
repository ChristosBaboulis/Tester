package GUI_FrontEnd;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame
{
    static MainMenu frame;
    private JPanel contentPane;

    //APPLICATION LAUNCH
    public static void main(String[] args)
    {
        EventQueue.invokeLater
        (new Runnable()
            {
                public void run()
                {
                    try
                    {
                        frame = new MainMenu();
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

    public MainMenu()
    {
        //FRAME & CONTENT PANE CREATION
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        
        //TITLE MESSAGE CREATION
        JLabel title = new JLabel("Library Management Application");
        title.setFont(new Font("Tahoma", Font.PLAIN, 18));
        title.setForeground(Color.GRAY);
        
        //BUTTONS CREATION
        JButton adminLogin, userLogin;
        adminLogin = new JButton("Admin Login");
        adminLogin.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent arg0)
                {
                    AdminMenu.main(new String[]{});
                    frame.dispose();
                }
            }    
        );
        adminLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));

        userLogin = new JButton("User Login");
        userLogin.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent arg0)
                {
                    UserMenu.main(new String[]{});
                    frame.dispose();
                }
            }    
        );
        userLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));

        //CONTENT PANE'S CUSTOM LAYOUT CREATION
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup
        (
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                            .addGroup
                            (
                                gl_contentPane.createSequentialGroup()
                                .addGroup
                                (
                                    gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup
                                        (
                                            gl_contentPane.createSequentialGroup()
                                                .addGap(64)
                                                .addComponent(title)
                                        )
                                    .addGroup
                                    (
                                        gl_contentPane.createSequentialGroup()
                                        .addGap(140)
                                        .addGroup
                                        (
                                            gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                            .addComponent(userLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(adminLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                        )
                                    )
                                )
                                .addContainerGap(95, Short.MAX_VALUE)
                            )
        );
        gl_contentPane.setVerticalGroup
        (
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup
                (
                    gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(title)
                    .addGap(32)
                    .addComponent(adminLogin, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(userLogin, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE)
                )
        );
        contentPane.setLayout(gl_contentPane);
    }
}
