package BackEnd.Basic_Classes;

public class Book 
{
    private String callNo, name, authentication, publisher;
    private int quantity;

    public Book(String callNo, String  name, String authentication, String publisher, int quantity)
    {
        this.callNo = callNo;
        this.name = name;
        this.authentication = authentication;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    public Book(Book b)
    {
        callNo = b.getCallNo();
        name = b.getName();
        authentication = b.getAuthentication();
        publisher = b.getPublisher();
        quantity = b.getQuantity();
    }

    public Book(){}

    public void setCallNo(String callNo)
    {
        this.callNo = callNo;
    }

    public String getCallNo()
    {
        return callNo;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    
    public void setAuthentication(String authentication)
    {
        this.authentication = authentication;
    }

    public String getAuthentication()
    {
        return authentication;
    }
    
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    public String getPublisher()
    {
        return publisher;
    }
    
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public String toString()
    {
        return "Book's Call No: "+ getCallNo() + ", Book's name: " + getName() + ", Book's authentication: " + getAuthentication() + ", Book's publisher: " 
                + getPublisher() + ", Book's quantity: "+ getQuantity();
    }

    public void copy(Book b)
    {
        callNo = b.getCallNo();
        name = b.getName();
        authentication = b.getAuthentication();
        publisher = b.getPublisher();
        quantity = b.getQuantity();
    }
}
