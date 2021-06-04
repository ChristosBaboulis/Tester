package BackEnd.Basic_Classes;

public class Student 
{
    private int studentId;
    private String name, contact;
    
    public Student(int studentId, String name, String contact)
    {
        this.studentId = studentId;
        this.name = name;
        this.contact = contact;
    }

    public Student(Student s)
    {
        studentId = s.getStudentId();
        name = s.getName();
        contact = s.getContact();
    }

    public Student(){}

    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    public int getStudentId()
    {
        return studentId;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setContact(String contact)
    {
        this.contact = contact;
    }

    public String getContact()
    {
        return contact;
    }

    public String toString()
    {
        return "Student's ID: " + getStudentId() + ", Student's Name: " + getName() + ", Student's Contact: " + getContact();
    }

    public void copy(Student s)
    {
        studentId = s.getStudentId();
        name = s.getName();
        contact = s.getContact();
    }
}
