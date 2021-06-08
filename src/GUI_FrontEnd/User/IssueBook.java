package GUI_FrontEnd.User;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.jar.Attributes.Name;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class IssueBook extends JFrame
{
    static IssueBook frame;
    private JLabel contentPane;
    private JTextField textField_1, textField_2, textField_3, textField_4;

    //ISSUE BOOK FRAME LAUNCH
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
                        frame = new IssueBook();
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

    public IssueBook()
    {
        //FRAME & CONTENT PANE CREATION
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JLabel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //TITLE AND OTHER MESSAGES CREATION
        JLabel title = new JLabel("Issue Book");
        title.setFont(new Font("Tahoma", Font.PLAIN, 18));
        title.setForeground(Color.GRAY);

        JLabel note = new JLabel("Note: Please check StudentID Carefully before issuing book!");
        note.setFont(new Font("Tahoma", Font.PLAIN, 10));
        note.setForeground(Color.RED);

        //TEXT FIELDS CREATION
        JLabel bookCallNo = new JLabel("Book Callno: ");
        JLabel studentId = new JLabel("Student ID: ");
        JLabel studentName = new JLabel("Student Name: ");
        JLabel studentContact = new JLabel("Student Contact: ");

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_4 = new JTextField();
        textField_4.setColumns(10);

        //BUTTONS CREATION
        JButton issueBook = new JButton("Issue Book");
        issueBook.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    //BACKEND CODE
                    JOptionPane.showMessageDialog(IssueBook.this, "Book issued successfully!");
                    UserMenu2.main(new String[] {});
                    frame.dispose();
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
                    UserMenu2.main(new String[] {});
                    frame.dispose();
                }
            }
        );

        //CONTENT PANE'S CUSTOM LAYOUT CREATION
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(10, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(bookCallNo)
								.addComponent(studentId)
								.addComponent(studentName, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addComponent(studentContact, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
							.addGap(48))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(note)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(issueBook, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(47)
									.addComponent(back)))
							.addGap(100))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(146)
					.addComponent(title)
					.addContainerGap(235, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(title)
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookCallNo)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentId)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentName)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentContact)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(issueBook, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(back))
					.addGap(18)
					.addComponent(note)
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
    }
}
