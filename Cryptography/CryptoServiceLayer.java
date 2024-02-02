import java.util.*;

public class CryptoServiceLayer
{
    // Alphabet Generation
    private static String generateAlphabet()
    {
        //StringBuilder is used for appending characters in a loop.
        StringBuilder alphabet = new StringBuilder();

        //Adding all the alphabets to the string builder object.
        for(char alpha = 'a'; alpha <= 'z'; alpha++)
        {
            alphabet.append(alpha);
        }
        
        //Converting object to string.
        return alphabet.toString();
    }

    // This will hold the string 'abcdefghijklmnopqrstuvwxyz'
    private static final String Alphabet = generateAlphabet();

    //Character is calculated by shifting the input character.
    // 'inputCharacter - base' converts the char to an integer 0-25 by its position in the alphabet.
    // 'shift' is then added to this position, and '26' is added before modulus to ensure a positive number.
    // The result is taken modulo 26 to wrap around the alphabet if necessary.
    // Finally, 'base' is added to convert back to the char range of the alphabet ('a'-'z' or 'A'-'Z').
    public char shiftCharacter(char inputCharacter,int shift, char base)
    {
        return (char) ((inputCharacter + shift - base + 26) %26 + base);
    }

    //Text and Shift Key Validation
    private void validInput(String text, String shiftKey) throws InputException
    {   
        //If the input text is empty then exception will be thrown.
        if(text.trim().isEmpty() || text == null)
        {
            throw new InputException("Please Enter Text, it should not be Empty.");
        }

        //If entered shift key is empty, exception will be thrown.
        if(shiftKey.isEmpty() || shiftKey == null)
        {
            throw new InputException("Please Enter Shift Key.");
        }

        //Par
        int key = Integer.parseInt(shiftKey);
        
        //If shift Key is greater 25 or less than 0, there will be an exception.
        if(key < 0 || key > 25)
        {
            throw new InputException("Key should be in between the range of 0-25 only.");
        }
    }

    //Encryption Logic
    public String textEncryption(String text, String shiftKey) throws InputException
    {
        try
        {
            //It will call the validInput method for the validations which are defined above, if they pass it will continue
            //Otherwise it will throw InputException.
            validInput(text, shiftKey);

            //Parsing the shiftKey from String to Integer.
            int key = Integer.parseInt(shiftKey);

            //It will jump to direct encyrptdecrypt Method where further process is done foe Encryption/Decryption/Brute Force.
            return encryptDecrypt(text, key); 
            
        }

        //Exception is thrown when the shift key is not in entered in Integer.
        catch(NumberFormatException numberException)
        {
            throw new InputException("Shift Key should be Integer.");
        }
        catch(InputException exception)
        {
            System.out.println("Exception: " + exception.getMessage());

            //The operation was not successfull to process the Operation.
            return null;
        }
    }

    //Decryption Logic
    public String textDecryption(String encryptedText, String shiftKey) throws InputException
    {
        try
        {
            validInput(encryptedText, shiftKey);
            int key = Integer.parseInt(shiftKey);
            
            //It will jump to direct encyrptdecrypt Method where further process is done foe Encryption/Decryption/Brute Force.
            return encryptDecrypt(encryptedText, -key); 
        }
        catch(NumberFormatException numberException)
        {
            throw new InputException("Shift Key should be Integer.");
        }
        catch(InputException exception)
        {
            System.out.println("Exception: " + exception.getMessage());
            return null;
        }    
    }

    //Brute Force Attack Logic
    public String bruteTextDecryption(String bruteEncryptedText, Scanner scanner) throws InputException
    {
        //For collecting the results to Object.
        StringBuilder bruteForce = new StringBuilder();
        while(true)
        {
            try
            {
                //Checks whether the text is empty or not, and if empty will throw an InputException.
                if(bruteEncryptedText.isEmpty())
                {
                    throw new InputException("Please Enter Text, it should not be Empty.");
                }

                //Loop will iterate through all the possible shift Keys from 0 to 25.
                for(int shiftKey = 0; shiftKey < 26; shiftKey++)
                {
                    String decryptedText = encryptDecrypt(bruteEncryptedText, -shiftKey);

                    //Appending the Shift Key and the Decrypted text to Object.
                    bruteForce.append("Shift Key ").append(shiftKey).append(" :: ").append(decryptedText).append("\n");
                }

                //Converting an Object to String.
                return bruteForce.toString();
            }
            catch(InputException exception)
            {
                System.out.println("Error while handling the Input: " + exception.getMessage());
            }

            //If there is an Exception, it will again ask to Enter the Encrypted Text.
            System.out.println("Enter the Encrypted Cipher Text: ");
            bruteEncryptedText = scanner.nextLine();
        }
    }

    //Common Method for shifting the characters, whether it is encryption, decryption or bruteForceAttack.
    private String encryptDecrypt(String inputText, int shiftKey)
    {
        StringBuilder cryptoText = new StringBuilder();

        //Loop to iterate over each element in the input text.
        for(int i = 0; i < inputText.length(); i++)
        {
            //Current Character from the User Input.
            char currentCharacter = inputText.charAt(i);

            //Conversion of current character to lowercase.
            char lowercase = Character.toLowerCase(currentCharacter);

            //Condition to check if the current character is Letter.
            if(Character.isLetter(currentCharacter))
            {
                //Character is shifted using the shiftCharacter stated above, and 'a' is passed as a base to start the shiftinf and make 
                //sure it is in the lowercase.
                char shiftedCharacter = shiftCharacter(lowercase, shiftKey, 'a');

                //Condition to check if the character is UpperCase, then conver it to LowerCase.
                if(Character.isUpperCase(currentCharacter))
                {
                    shiftedCharacter = Character.toUpperCase(shiftedCharacter);
                }

                //Appending the Shifted Character to result.
                cryptoText.append(shiftedCharacter);
            }
            //For characters which are not alphabets like number or symbols.
            else
            {
                cryptoText.append(currentCharacter);
            }
        }

        //Converting Object to String and return the result to the where it is called.
        return cryptoText.toString();
    }
}