/*Purpose of the class is that we can use custom exceptions and provide error messages 
with better understanding. */

public class InputException extends Exception
{
    //Constructor for the InputException
    public InputException(String Message)
    {
        //Usage of super to call the superclass of the constructor which we created
        //Over here the superclass is Exception, and message is passed.
        super(Message);
    }
}