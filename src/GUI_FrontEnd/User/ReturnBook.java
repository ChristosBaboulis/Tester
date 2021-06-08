package GUI_FrontEnd.User;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
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

public class ReturnBook extends JFrame
{
    static ReturnBook frame;
    private JLabel contentPane;
    private JTextField textField_1, textField_2;

    //RETURN BOOK FRAME LAUNCH
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
                        frame = new ReturnBook();
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

    public ReturnBook()
    {
        //FRAME & CONTENT PANE CREATION
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 516, 413);
        contentPane = new JLabel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        //TITLE MESSAGE AND NOTES CREATION
        JLabel title = new JLabel("Return Book");
        title.setFont(new Font("Tahoma", Font.PLAIN, 18));
        title.setForeground(Color.GRAY);

        JLabel note = new JLabel("Note: Check the book properly!");
        note.setFont(new Font("Tahoma", Font.PLAIN, 10));
        note.setForeground(Color.RED);

        //TEXT FIELDS CREATION
        JLabel bookCallNo = new JLabel("Book Callno: ");
        JLabel studentId = new JLabel("Student Id: ");

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_2 = new JTextField();
        textField_2.setColumns(10);

        //BUTTONS CREATION
        JButton returnBook = new JButton("Return Book");
        returnBook.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    JOptionPane.showMessageDialog(ReturnBook.this, "Book returned successfully!");
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
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(studentId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(bookCallNo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(139, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(210, Short.MAX_VALUE)
					.addComponent(returnBook, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(176))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(205, Short.MAX_VALUE)
					.addComponent(title)
					.addGap(187))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(note)
					.addContainerGap(294, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(355, Short.MAX_VALUE)
					.addComponent(back)
					.addGap(46))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(title)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookCallNo)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentId)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(returnBook, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(back)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(note)
					.addGap(72))
		);
		contentPane.setLayout(gl_contentPane);
    }
}
