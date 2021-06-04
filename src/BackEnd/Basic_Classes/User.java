package BackEnd.Basic_Classes;

public class User
{
    private int id;
    private String username, password, email, address, city, contact;
    
    public User(int id, String username, String password, String email, String address, String city, String contact)
    {
        this.id = id;
        this.contact = contact;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.city = city;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setContact(String contact)
    {
        this.contact = contact;
    }

    public String getContact()
    {
        return contact;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCity()
    {
        return city;
    }

    public String toString()
    {
        return "User's ID: "+ getId() + ", User's username: " + getUsername() + ", User's password: " + getPassword() + ", User's email: " 
                + getEmail() + ", User's address: "+ getAddress() + ", User's city: " + getCity() + ", User's contact: " + getContact();
    }
}
