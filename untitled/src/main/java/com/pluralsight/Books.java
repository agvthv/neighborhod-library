package com.pluralsight;

public class Books
{
    private int id;
    private String isbn;
    private String title;
    private String checkOutTo;
    private boolean isCheckedOut;

    public Books(String title, String isbn, int id, boolean isCheckedOut){
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.checkOutTo = "";
        this.isCheckedOut = false;

    }
    public String getIsbn(){
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public boolean isCheckedOut()
    {
        return isCheckedOut;
    }

    public String getCheckOutTo()
    {
        return checkOutTo;
    }

    public void setCheckOutTo(String checkOutTo)
    {
        this.checkOutTo = checkOutTo;
    }
    public void checkOut(String name) {
        if(!this.isCheckedOut) {
            this.isCheckedOut = true;
            this.checkOutTo = name;
        } else {
            System.out.println("The book is already checked out.");
        }
    }

    public void checkIn() {
        this.isCheckedOut = false;
        this.checkOutTo = "";
    }
}


