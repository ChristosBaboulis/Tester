package GUI_FrontEnd;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMenu2 extends JFrame
{
    static AdminMenu2 frame;
    private JLabel contentPane;
    
    //ADMIN MENU 2 LAUNCH
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
                        frame = new AdminMenu2();
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

    public AdminMenu2()
    {
        //FRAME AND CONTENT PANE CREATION
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 500);
        contentPane = new JLabel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //TITLE MESSAGE CREATION
        JLabel adminSection = new JLabel("Admin Section");
        adminSection.setFont(new Font("Tahoma", Font.PLAIN, 22));
		adminSection.setForeground(Color.GRAY);

        //BUTTONS CREATION
        JButton addUser = new JButton("Add User");
        addUser.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    AddUser.main(new String[] {});
                    frame.dispose();
                }
            }    
        );
        addUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JButton viewUsers = new JButton("View Users");
        viewUsers.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {

                }
            }    
        );
        viewUsers.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JButton deleteUser = new JButton("Delete User");
        deleteUser.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {

                }
            }    
        );
        deleteUser.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JButton logout = new JButton("Logout");
        logout.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    AdminMenu.main(new String[]{});
                    frame.dispose();
                }
            }    
        );
        logout.setFont(new Font("Tahoma", Font.PLAIN, 15));

        //CONTENT PANE'S CUSTOM LAYOUT CREATION
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(150, Short.MAX_VALUE)
					.addComponent(adminSection, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addGap(123))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(134)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(logout, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteUser, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(viewUsers, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(addUser, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(109, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(adminSection, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(addUser, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(viewUsers, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(deleteUser, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(logout, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
    }
}
