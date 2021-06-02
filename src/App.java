import java.util.*;

public class App {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean upTime = true;
        ArrayList<Admin> adminsList = new ArrayList<Admin>();
        ArrayList<User> usersList = new ArrayList<User>();
        ArrayList<Book> booksList = new ArrayList<Book>();
        ArrayList<Student> studentsList = new ArrayList<Student>();
        Map<Book, Student> issuedBooks = new HashMap<Book, Student>();

        String loginInput;
        String username;
        String password;

        fetchAdmins(adminsList);    //for(Admin a: adminsList){System.out.println(a.toString());}
        fetchUsers(usersList);
        fetchBooks(booksList);
        fetchStudents(studentsList);

        System.out.println("Welcome. (Press 0 anytime to exit)\n");

        while(upTime)
        {
            System.out.println("Please choose weather you want to log in as an admin or as a user.\nPress 1 for admin and 2 for user.");
            loginInput = in.nextLine();

            if(loginInput.equals("1"))
            {
                System.out.println("Admin Login Form.\nPlease enter your username: ");
                username = in.nextLine();
                System.out.println("Please enter your password: ");
                password = in.nextLine();
                boolean check = checkForAdminAccount(username, password, adminsList);
                
                if(check)
                {
                    boolean adminUpTime = true;
                    while(adminUpTime)
                    {
                        System.out.println("\nAdmin Section\nAdd User(1)\nView Users(2)\nDelete User(3)\nLogout(4)");
                        String input = in.nextLine();
                        if(input.equals("1"))       
                        {
                            System.out.println("Name: ");
                            String name = in.nextLine();
                            System.out.println("Password: ");
                            String pass = in.nextLine();
                            System.out.println("Email: ");
                            String email = in.nextLine();
                            System.out.println("Address: ");
                            String address = in.nextLine();
                            System.out.println("City: ");
                            String city = in.nextLine();
                            System.out.println("Contact: ");
                            String contact = in.nextLine();
                            int id = getMaxId(usersList) + 1;
                            User newUser = new User(id, name, pass, email, address, city, contact);
                            usersList.add(newUser);
                            System.out.println("User Successfully added!");
                        }
                        else if(input.equals("2"))  { for(User u: usersList){ System.out.println(u.toString()); } }
                        else if(input.equals("3"))  
                        {
                            System.out.println("Please enter the ID of the user you would like to delete: ");
                            String deletedId = in.nextLine();
                            boolean deleteFlag = false;
                            for(User u: usersList)
                            {
                                if(deletedId.equals(Integer.toString(u.getId())))
                                {
                                    usersList.remove(u);
                                    deleteFlag = true;
                                    System.out.println("User "+deletedId+" deleted successfully!");
                                    break;
                                }
                            }
                            if(deleteFlag == false){System.out.println("ID not found. Delete Failed.");}
                        }
                        else if(input.equals("4"))  {break;}
                        else if(input.equals("0"))  {upTime = false; break;}
                        else                        {System.out.println("Invalid command. Please try again.");}
                    }
                }
                else
                {
                    System.out.println("Wrong username or password. Please try again.");
                }
            }
            else if(loginInput.equals("2"))
            {
                System.out.println("User Login Form.\nPlease enter your username: ");
                username = in.nextLine();
                System.out.println("Please enter your password: ");
                password = in.nextLine();
                boolean check = checkForUserAccount(username, password, usersList);

                if(check)
                {
                    boolean userUpTime = true;
                    while(userUpTime)
                    {
                        System.out.println("\nUser Section\nAdd Books(1)\nView Books(2)\nIssue Book(3)\nView Issued Books(4)\nReturn Book(5)\nLogout(6)");
                        String input = in.nextLine();
                        
                        if(input.equals("1"))       
                        {   
                            boolean bookIdFlag = true;
                            String callNo = "";
                            while(bookIdFlag)
                            {
                                boolean bookIdFlag1 = true;
                                System.out.println("Call No: ");
                                callNo = in.nextLine();
                                for(Book bit1: booksList) 
                                { 
                                    if ( callNo.equals( bit1.getCallNo() ) ) 
                                    { 
                                        System.out.println("ID already existing. Please use a new one.");
                                        bookIdFlag1 = false; 
                                        break; 
                                    } 
                                }
                                if (bookIdFlag1 == true) { bookIdFlag = false; }
                            }
                            System.out.println("Name: ");
                            String name = in.nextLine();
                            System.out.println("Authentication: ");
                            String authentication = in.nextLine();
                            System.out.println("Publisher: ");
                            String publisher = in.nextLine();
                            System.out.println("Quantity: ");
                            String quantity = in.nextLine();
                            Book newBook = new Book(callNo, name, authentication, publisher, Integer.parseInt(quantity));
                            booksList.add(newBook);
                            System.out.println("Book Successfully added!");
                        }
                        else if(input.equals("2"))  {for(Book b: booksList){ System.out.println(b.toString()); }}
                        else if(input.equals("3"))  
                        {
                            boolean bookIdFlag = true;
                            String issuedCallNo = "";
                            while(bookIdFlag)
                            {
                                boolean bookIdFlag1 = true;
                                System.out.println("Book Call No: ");
                                issuedCallNo = in.nextLine();
                                for(Book bit1: booksList) 
                                { 
                                    if ( issuedCallNo.equals( bit1.getCallNo() ) ) 
                                    { 
                                        bookIdFlag1 = false; 
                                        break; 
                                    } 
                                }
                                if (bookIdFlag1 == true) 
                                { 
                                    System.out.println("Book not found.");
                                }
                                else
                                {
                                    bookIdFlag = false;
                                }
                            }
                            System.out.println("Student ID: ");
                            String studentId = in.nextLine();
                            System.out.println("Student Name: ");
                            String studentName = in.nextLine();
                            System.out.println("Student Contact: ");
                            String studentContact = in.nextLine();
                            Student s = new Student(Integer.parseInt(studentId), studentName, studentContact);
                            Book b = new Book();
                            for(Book bit: booksList){ if ( issuedCallNo.equals( bit.getCallNo() ) ) { b.copy(bit); break; } }
                            
                            if(b.getCallNo().equals(""))
                            {
                                System.out.println("Book not existing!");
                            }
                            else
                            {
                                issuedBooks.put(b, s);
                                int temp = b.getQuantity();
                                for(Book bit: booksList)
                                { 
                                    if ( b.getCallNo().equals( bit.getCallNo() ) ) 
                                    { 
                                        bit.setQuantity(temp - 1);
                                        if(bit.getQuantity() == 0)
                                        {
                                            booksList.remove(bit);
                                        }
                                        break; 
                                    } 
                                }
                                b.setQuantity(1);
                                System.out.println("Book issued successfully!");
                            }

                        }
                        else if(input.equals("4"))  { printMap(issuedBooks); }
                        else if(input.equals("5"))  
                        {
                            System.out.println("Book Call No: ");
                            String returnedCallNo = in.nextLine();
                            System.out.println("Student ID: ");
                            String studentId = in.nextLine();
                            //findAndDeleteInMap(issuedBooks, returnedCallNo, studentId);
                            
                        }
                        else if(input.equals("6"))  {break;}
                        else if(input.equals("0"))  {upTime = false; break;}
                        else                        {System.out.println("Invalid command. Please try again.");}
                    }
                }
                else
                {
                    System.out.println("Wrong username or password. Please try again.");
                }
            }
            else if(loginInput.equals("0"))
            {
                System.out.println("Exiting...");
                break;
            }
            else
            {
                System.out.println("Invalid input. Please try again.");
            }

        }
        
    }

    public static void fetchAdmins(ArrayList<Admin> adminsList)
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
    }

    public static boolean checkForAdminAccount(String usrn, String pswd, ArrayList<Admin> adminsList)
    {
        boolean flag = false;
        if(adminsList.size() == 0)
        {
            flag = false;   //System.out.println("Mpike logw 0 size.");
        }
        else
        {
            for(Admin a: adminsList)
            {
                if(usrn.equals(a.getUsername()) && pswd.equals(a.getPassword()))
                {
                    flag = true;    //System.out.println("Mpike logw swstou user.");
                    break;
                }
                else
                {
                    flag = false;   //System.out.println("Mpike logw swstou pass.");
                }
            }
        }
        return flag;
    }

    public static boolean checkForUserAccount(String usrn, String pswd, ArrayList<User> usersList)
    {
        boolean flag = false;
        if(usersList.size() == 0)
        {
            flag = false;   //System.out.println("Mpike logw 0 size.");
        }
        else
        {
            for(User u: usersList)
            {
                if(usrn.equals(u.getUsername()) && pswd.equals(u.getPassword()))
                {
                    flag = true;    //System.out.println("Mpike logw swstou user.");
                    break;
                }
                else
                {
                    flag = false;   //System.out.println("Mpike logw swstou pass.");
                }
            }
        }
        return flag;
    }

    public static void fetchUsers(ArrayList<User> usersList)
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
    }

    public static int getMaxId(ArrayList<User> usersList)
    {
        if(usersList.size() == 0){return 0;}
        int max = 0;
        for(User u: usersList)
        {
            if(u.getId() > max)
            {
                max = u.getId();
            }
        }
        return max;
    }

    public static void fetchBooks(ArrayList<Book> booksList)
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
    }

    public static void fetchStudents(ArrayList<Student> studentsList)
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
    }

    public static void printMap(Map mp)
     {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) 
        {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }

    /*public static void findAndDeleteInMap(Map mp, String callNo, String studentId)
    {
        Iterator it = mp.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry pair = (Map.Entry)it.next();
            if( mp.getKey().getCallNo().equals(callNo) && pair.getValue().equals(studentId) )
            {
                mp.remove(pair.getKey());
            }
        }
    }*/
}
