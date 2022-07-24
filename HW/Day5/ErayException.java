package com.example.safetycoding;

public class ErayException extends Exception
{


}
// class that uses custom exception MyCustomException
public class TestErayException
{
    // main method
    public static void main(String args[])
    {
        try
        {
            // throw an object of user defined exception
            throw new ErayException();
        }
        catch (ErayException ex)
        {
            System.out.println("Caught the exception");
            System.out.println(ex.getMessage());
        }

        System.out.println("rest of the code...");
    }
}