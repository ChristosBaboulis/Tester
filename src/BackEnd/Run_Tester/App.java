package BackEnd.Run_Tester;

import java.util.*;

import BackEnd.Basic_Classes.Admin;
import BackEnd.Basic_Classes.User;

public class App {
    /*public static void main(String[] args)
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

        adminsList = Utilities.fetchAdmins();
        usersList = Utilities.fetchUsers();
        booksList = Utilities.fetchBooks();
        studentsList = Utilities.fetchStudents();

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
        
    }*/

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
