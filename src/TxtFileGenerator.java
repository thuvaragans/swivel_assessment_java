// Importing necessary packages to run the program.
import java.io.*;

// Is used to create a '.txt' file with the pre-assigned information such as - brandName, modelName, builtVersion.
public class TxtFileGenerator {

    // A private method to define the '.txt' file, and to assign the values for the necessary components.
    // This class is then called in the psvm method below in order to run and create the text file with the necessary data.
    private void writingTextDataToTxtFile() {
        try {
            String txtFileName = "written_data.txt"; // The '.txt' file name.
            // Initiating a FileWriter instance to write the below data into the 'written_data.txt' file.
            FileWriter txtWriter = new FileWriter(txtFileName);
            // 4 random sets of data are written into the file.
            // Each set also contains an integer representation to show the nth set in the text file (ascending order).
            txtWriter.write("1. brandName=Asus;\n1. modelName=Vivobook-S14-Flip;\n1. builtVersion=4.05;\n\n");
            txtWriter.write("2. brandName=Lenovo;\n2. modelName=IdeaPad-Slim3;\n2. builtVersion=7.1.31;\n\n");
            txtWriter.write("3. brandName=Samsung;\n3. modelName=GalaxyBook2-Pro-360;\n3. builtVersion=3.684;\n\n");
            txtWriter.write("4. brandName=Apple;\n4. modelName=Macbook-Pro;\n4. builtVersion=2.8.99;");
            txtWriter.close(); // To write the data and close the FileWriter stream. Unless closed, the data won't be written into the file.
            System.out.println("Great.\nThe Data Has Been Successfully Written To The TXT File."); // Message to show successful creation of the text file.
        } catch (IOException e) {
            System.out.println("Sorry.\nUnable To Create The Desired TXT File Containing The Data Required!!!"); // Message to show error in creating the text file.
            e.printStackTrace();
        }
    }

    // Main method.
    public static void main(String[] args) {
        TxtFileGenerator createTextFile = new TxtFileGenerator(); // Creating an instance for the class.
        createTextFile.writingTextDataToTxtFile(); // Calling the 'writingTextDataToTxtFile' method to run the class.
    }

    // Default Constructor.
    public TxtFileGenerator() {
    }

}