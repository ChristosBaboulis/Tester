package GUI_FrontEnd.User;

import java.awt.EventQueue;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserMenu2 extends JFrame
{
    static UserMenu2 frame;
    private JLabel contentPane;
    
    //USER MENU 2 FRAME LAUNCH
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
                        frame = new UserMenu2();
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

    public UserMenu2()
    {
        //FRAME & CONTENT PANE CREATION
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 500);
        contentPane = new JLabel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //TITLE MESSAGE CREATION
        JLabel title = new JLabel("User Section");
        title.setFont(new Font("Tahoma", Font.PLAIN, 18));
        title.setForeground(Color.GRAY);

        //BUTTONS CREATION
        JButton addBooks = new JButton("Add Books");
        addBooks.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    AddBooks.main(new String[] {});
                    frame.dispose();
                }
            }
        );

        JButton viewBooks = new JButton("View Books");
        viewBooks.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    ViewBooks.main(new String[] {});
                }
            }
        );

        JButton issueBook = new JButton("Issue Book");
        issueBook.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    IssueBook.main(new String[] {});
                    frame.dispose();
                }
            }
        );

        JButton viewIssuedBooks = new JButton("View Issued Books");
        viewIssuedBooks.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    ViewIssuedBooks.main(new String[] {});
                }
            }
        );

        JButton returnBook = new JButton("Return Book");
        returnBook.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    ReturnBook.main(new String[] {});
                    frame.dispose();
                }
            }
        );

        JButton logout = new JButton("Logout");
        logout.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    UserMenu.main(new String[] {});
                    frame.dispose();
                }
            }
        );

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(81, Short.MAX_VALUE)
					.addComponent(title)
					.addGap(150))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(132)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(logout, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(returnBook, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(viewIssuedBooks, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(issueBook, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(viewBooks, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(addBooks, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(101, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(title)
					.addGap(18)
					.addComponent(addBooks, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(viewBooks, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(issueBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(viewIssuedBooks, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(returnBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(logout, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
