package GUI_FrontEnd;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;

public class UserMenu  extends JFrame
{
    static UserMenu frame;
    private JLabel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    //USER MENU FRAME LAUNCH
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
                        frame = new UserMenu();
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

    public UserMenu()
    {
        //FRAME & CONTENT PANE CREATION
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JLabel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //TITLE MESSAGE CREATION
        JLabel userLoginForm = new JLabel("User Login");
        userLoginForm.setForeground(Color.GRAY);
		userLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 18));

        //USER NAME & PASSWORD TEXT FIELDS CREATION
        JLabel enterName = new JLabel("Enter User Name: ");
        JLabel enterPassword = new JLabel("Enter Password: ");

        textField = new JTextField();
        textField.setColumns(10);
        passwordField = new JPasswordField();

        //BUTTONS CREATION
        JButton login = new JButton("Login");
        login.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {

                }
            }    
        );

        JButton back = new JButton("Back");
        back.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    MainMenu.main(new String[]{});
                    frame.dispose();
                }
            }    
        );

        //CONTENT PANE'S CUSTOM LAYOUT CREATION
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(124)
							.addComponent(userLoginForm))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(enterName)
								.addComponent(enterPassword))
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
					.addContainerGap(107, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(187, Short.MAX_VALUE)
					.addComponent(login, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(151))
                    .addComponent(back, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(userLoginForm)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(enterName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(enterPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(login, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
                    .addComponent(back, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
		);
		contentPane.setLayout(gl_contentPane);

    }
}
