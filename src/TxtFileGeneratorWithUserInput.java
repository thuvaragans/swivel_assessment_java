// Importing necessary packages to run the program.
import org.apache.log4j.Logger;
import java.util.Scanner;
import java.io.*;

// Is used to create a '.txt' file with the information such as - brandName, modelName, builtVersion based on the user input.
public class TxtFileGeneratorWithUserInput {

    private static final Logger loggerTxtFileGeneratorWithUserInput = Logger.getLogger(TxtFileGeneratorWithUserInput.class); // Initiating logger for this class.

    // A private method to define the '.txt' file, and to assign the values for the necessary components based on the user input.
    // This class is then called in the psvm method below in order to run and create the text file with the necessary user input data.
    private void requestingUserInputTextData() throws IOException {
        Scanner scanner = new Scanner(System.in); // Initiating scanner for the user input phase.
        String txtFileName = "written_data_user_input.txt"; // The '.txt' file name.
        // Initiating a FileWriter instance to write the data received from the user input into the 'written_data_user_input.txt' file.
        FileWriter txtWriter = new FileWriter(txtFileName);

        int noOfLaptops = 0; // Initiating no. of laptops.
        boolean isIntValue = false; // Boolean for further use.

        System.out.println("Welcome User.");
        // A while loop to get an Int value from the user.
        // Prompting loops till a valid Int value is given by the user.
        while (!isIntValue) {
            System.out.print("Number of Laptops (Enter Integer Value) : "); // Prompting the user to input the no. of laptops they want to add.
            if (scanner.hasNextInt()) {
                noOfLaptops = scanner.nextInt(); // to store the no. of laptops.
                isIntValue = true;
            }
            else {
                scanner.nextLine();
                System.out.println("\nInvalid Value.\nPlease Provide a Valid Integer Value.\n");
            }
        }
        scanner.nextLine();

        try {
            // A for loop to loop through the no. of laptops and add the necessary values consecutively.
            for (int i = 1; i <= noOfLaptops; i++) {
                System.out.println("\nPlease provide the details for Laptop no. " + i + " below...\n");

                // To store the 'brandName' value.
                System.out.print("Brand : ");
                String laptopBrand = scanner.nextLine(); // For the user input of 'brandName'.

                // To store the 'modelName' value.
                System.out.print("Model : ");
                String laptopModel = scanner.nextLine(); // For the input of 'modelName'.

                // To store the 'builtVersion' value.
                System.out.print("Version : ");
                String laptopVersion = scanner.nextLine(); // For the input of 'builtVersion'.

                System.out.println();
                // A string format to store the relevant data in the required text file.
                String laptopDetails = (i + ". brandName=" + laptopBrand + ";\n" +
                                        i + ". modelName=" + laptopModel + ";\n" +
                                        i + ". builtVersion=" + laptopVersion + ";\n");
                txtWriter.write(laptopDetails + "\n"); // To write the data into the text file.
            }
            txtWriter.close(); // To write the data and close the FileWriter stream. Unless closed, the data won't be written into the file.
            loggerTxtFileGeneratorWithUserInput.info("Great. The Data Has Been Successfully Written To The 'written_data_user_input.txt' File.\n"); // Message to show successful creation of the text file.
        }
        catch (IOException e) {
            loggerTxtFileGeneratorWithUserInput.error("Sorry. Unable To Create The Desired 'written_data_user_input.txt' File Containing The Data Required!!!\n"); // Message to show error in creating the text file.
            e.printStackTrace();
        }
    }

    // Main method.
    public static void main(String[] args) throws IOException {
        TxtFileGeneratorWithUserInput createTextFile = new TxtFileGeneratorWithUserInput(); // Creating an instance for the class.
        createTextFile.requestingUserInputTextData(); // Calling the 'requestingUserInputTextData' method to run the class.
        loggerTxtFileGeneratorWithUserInput.info("Successfully Ran The TxtFileGeneratorWithUserInput.java Class.\n");
    }

    // Default Constructor.
    public TxtFileGeneratorWithUserInput() {
    }

}