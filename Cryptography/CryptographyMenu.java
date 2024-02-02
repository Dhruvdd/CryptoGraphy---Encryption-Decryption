import java.util.*;

public class CryptographyMenu
{
    public static void main(String args[])
    {
        //Use of Scanner is to read the user input from the terminal.
        Scanner scanner = new Scanner(System.in);

        //Calling CryptoService for the operations
        CryptoServiceLayer cryptoService = new CryptoServiceLayer();

        int choice;

        //We have useed while(!exit) loop to create a continuous loop which allows users to perform the menu.
        boolean exit = false;
        while(!exit)
        {
            try
            {
                //Display Options
                CryptoMenu();
                System.out.println("Please Select a choice to proceed ");

                //Read User Input
                String inputChoice = scanner.nextLine();

                //Check if input is a number.
                if(inputChoice.matches("\\d+"))
                {
                    choice = Integer.parseInt(inputChoice);
                }
                else
                {
                    System.out.println("Invalid Input, Please enter from the choice.");
                    //Use of Continue is to start the program from starting 
                    continue;
                }

            }

            //Catch block to handle NumberFormatException
            catch(NumberFormatException exception)
            {
                System.out.println("Invalid Input, Please enter from the choice.");
                continue;
            }
    
            switch(choice)
            {
                case 1:
                    //Encryption
                    encryption(scanner, cryptoService);
                    break;
                
                case 2:
                    //Decryption
                    decryption(scanner, cryptoService);
                    break;

                case 3:
                    //Brute Force Attack
                    bruteForce(scanner, cryptoService);
                    break;

                case 4:
                    //Exit the program
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("Enter a valid Input Option.");
                    break;
        
            }
        }
        scanner.close();
    }
    
    //Cryptography Menu
    private static void CryptoMenu()
    {
        System.out.println("-------Cyrptography Menu-------");
        System.out.println("1. Encryption");
        System.out.println("2. Decryption");
        System.out.println("3. Brute Force Attack");
        System.out.println("4. Exit");
        System.out.println("-------------------------------");
    }

    //Encrption
    private static void encryption(Scanner scanner, CryptoServiceLayer cryptoService)
    {
        String text;
        String shiftKey;

        //It will run till the Correct inputs are provided. 
        while(true)
        {
            try
            {
                System.out.println("Enter Text: ");
                text = scanner.nextLine();

                System.out.println("Enter Shift Key: ");
                shiftKey = scanner.nextLine();

                //It will direct call the  method of CryptoServiceLayer class, textEncryption method and pass the parameters to it.
                String encrypted = cryptoService.textEncryption(text, shiftKey);
                System.out.println("Encrypted Text: " + encrypted);

                //Once the text is encrypted it will exit the loop.
                break;
            }

            //Will Print the Exception and will start the loop by asking user to enter text and shift key.
            catch(InputException exception)
            {
                System.out.println("Exception: " + exception.getMessage());
            }
        }
    }

    //Decryption
    private static void decryption(Scanner scanner, CryptoServiceLayer cryptoService)
    {
        String encryptedText;
        String shiftKey;

        while(true)
        {
            try
            {
                System.out.println("Enter Encrypted Text: ");
                encryptedText = scanner.nextLine();

                System.out.println("Enter Shift Key: ");
                shiftKey = scanner.nextLine();

                //It will direct call the  method of CryptoServiceLayer class, textDecryption method and pass the parameters to it.
                String decryptedText = cryptoService.textDecryption(encryptedText, shiftKey);
                System.out.println("Decrypted Text: " + decryptedText);

                break;
            }
            catch(InputException exception)
            {
                System.out.println("Exception: " + exception.getMessage());
            }
        }
    }

    //Brute Force Attack
    private static void bruteForce(Scanner scanner, CryptoServiceLayer cryptoService)
    {
        try
        {
            System.out.println("Enter the Encrypted Text: ");
            String bruteEncryptedText = scanner.nextLine();

            System.out.println("Here are the following Bruce Force Attack Matching: ");
            
            //It will direct call the  method of CryptoServiceLayer class, bruteTextDecryption method and pass the parameters to it.
            String bruteDecodedText = cryptoService.bruteTextDecryption(bruteEncryptedText, scanner);

            System.out.println(bruteDecodedText);
        }
        catch(InputException exception)
        {
            System.out.println("Exception: " + exception.getMessage());
        }
    }
}