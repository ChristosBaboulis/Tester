import java.util.*;

public class Utilities 
{
    private static ArrayList<Admin> adminsList = new ArrayList<Admin>();
    private static ArrayList<User> usersList = new ArrayList<User>();
    private static ArrayList<Book> booksList = new ArrayList<Book>();
    private static ArrayList<Student> studentsList = new ArrayList<Student>();

    public static ArrayList<Admin> fetchAdmins()
    {
        // DATABASE OF EXISTING ADMINS
        Admin admin = new Admin("1", "1");
        Admin admin1 = new Admin("Admin1", "AdminPassword1");
        Admin admin2 = new Admin("Admin2", "AdminPassword2");
        Admin admin3 = new Admin("Admin3", "AdminPassword3");
        Admin admin4 = new Admin("Admin4", "AdminPassword4");
        Admin admin5 = new Admin("Admin5", "AdminPassword5");
        
        adminsList.add(admin);
        adminsList.add(admin1);
        adminsList.add(admin2);
        adminsList.add(admin3);
        adminsList.add(admin4);
        adminsList.add(admin5);

        return adminsList;
    }

    public static ArrayList<User> fetchUsers()
    {
        // DATABASE OF EXISTING USERS
        User user1 = new User(1, "User1", "UserPassword1", "a@gmail.com", "a1", "This City", "123451");
        User user2 = new User(2, "User2", "UserPassword2", "b@gmail.com", "a2", "This City", "123456");
        User user3 = new User(3, "User3", "UserPassword3", "c@gmail.com", "a3", "This City", "123457");
        User user4 = new User(4, "User4", "UserPassword4", "d@gmail.com", "a4", "This City", "123458");
        User user5 = new User(5, "User5", "UserPassword5", "e@gmail.com", "a5", "This City", "123459");
        
        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);
        usersList.add(user4);
        usersList.add(user5);

        return usersList;
    }

    public static ArrayList<Book> fetchBooks()
    {
        // DATABASE OF EXISTING USERS
        Book book1 = new Book("1", "Book1", "authentication1", "publisher1", 10);
        Book book2 = new Book("2", "Book2", "authentication2", "publisher2", 20);
        Book book3 = new Book("3", "Book3", "authentication3", "publisher3", 30);
        Book book4 = new Book("4", "Book4", "authentication4", "publisher4", 40);
        Book book5 = new Book("5", "Book5", "authentication5", "publisher5", 50);
        
        booksList.add(book1);
        booksList.add(book2);
        booksList.add(book3);
        booksList.add(book4);
        booksList.add(book5);

        return booksList;
    }

    public static ArrayList<Student> fetchStudents()
    {
        // DATABASE OF EXISTING USERS
        Student student1 = new Student(1, "Student1", "123");
        Student student2 = new Student(2, "Student2", "456");
        Student student3 = new Student(3, "Student3", "789");
        Student student4 = new Student(4, "Student4", "321");
        Student student5 = new Student(5, "Student5", "765");
        
        studentsList.add(student1);
        studentsList.add(student2);
        studentsList.add(student3);
        studentsList.add(student4);
        studentsList.add(student5);

        return studentsList;
    }
}
