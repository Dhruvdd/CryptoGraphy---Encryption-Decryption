
**************************************************************
-> Overview of the assignment and its structure

The Assignment consists of three files which are  as follows:
    CryptographyMenu.java
    CryptoServiceLayer.java
    InputException.java

    Here I have follwed the structure of MVC Architecture where it contains Controller and Service, where the Controller is the main file through which all the necessary interaction happens between the user and the interface. And in the ServiceLayer it contains all the main logic of the code, from where code will be executing with the main logic. 

    Here Controller => CryptographyMenu.java
        This class is responsible for handling the Menu Options which will be given from User, once the user enters the choice, based on the choice the operation will be performed.
    Service Layer => CryptoServiceLayer.java
        This class contains all the methods required to perform cryptographic operations such as encryption, decryption and brute force.

    InputException.java is file which is used for custom exceptions over the files where necessary.

--------------------------------------------------------------
-> Detailed Explanantion of Each File

* In the CryptographyMenu, I have state the code for Menu option which is used for display the options where it takes the input from user and based on the input the operations is being performed, where for the main logic of Encryption, Decryption and Brute Force Attack it is written in CryptoServiceLayer.java, so for the further process the operation jumps to this file and complete the process.

* CryptoServiceLayer.java
This class contains the business logic of the operation which are being performed by the controller on receiving requests from the user interface, based on the choices to perform the cryptographic process: encryption, decryption and brute force attack.

--------------------------------------------------------------
-> Steps to Run all the files.

Step 1: For compiling the java files, write
        'javac CryptoServiceLayer.java CryptographyMenu.java InputException.java' in the terminal.

Step 2: Once all the files are compilied, just run the main file, here the main file is CryptographyMenu
        'java CryptographyMenu'

        Once the program runs it will ask for the choice:

Step 3: Upon Completion of each option enter OPtion 4 to Exit the program.

--------------------------------------------------------------
-> Validation

Program contains all types of Validation  such as :
- Starting from, by checking if user has entered correct option from the Menu, or has not passed any other such as in string;
- Now next, once user has entered the desired choice from the Menu and Text or Shift Key is empty it will throw exception.
- Checking the Shift Key, whether it is between 0-25 or it has not been entered in string.
