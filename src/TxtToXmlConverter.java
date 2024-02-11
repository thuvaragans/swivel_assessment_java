// Importing necessary packages to run the program.
import java.io.*;
import java.nio.file.*;

// Is used to create an '.xml' file and to store the data from reading text file into it, in a Proper XML format.
public class TxtToXmlConverter {

    // A private method to define the '.xml' file, and its format.
    // Is used to read from a '.txt' file, and write into an '.xml' file.
    private void txtToXmlFile(String inputFile, String outputFile) { // 2 Parameters for the input and output files.
        try {
            // Initiating a BufferedReader instance to read the data from a '.txt' file.
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            // Initiating a FileWriter instance to write the data into an '.xml' file.
            FileWriter xmlWriter = new FileWriter(outputFile);

            xmlWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); // Writing a random XML Header.
            xmlWriter.write("    <laptops>\n"); // Writing the root element.

            String dataLine; // Defining a line of string.
            String currentStringLine = null; // Defining the number on the start of each line.

            // A while loop to write the data into the xml file with the appropriate logics needed for the correct xml format & syntax.
            while ((dataLine = bufferedReader.readLine()) != null) { // Executing the while loop when a line of string isn't empty in the text file (needs to have data).

                // This part is for the element format and syntax works (<laptop>, </laptop>).
                // An if statement to check the starting format of the string.
                if (dataLine.matches("\\d+\\..*")) { // Needs to be "1. ", "2. ", etc.
                    int dataStartingNumber = Integer.parseInt(dataLine.split("\\.")[0]); // Defining the retrieved number.
                    if (currentStringLine == null || !currentStringLine.equals("        <laptop" + dataStartingNumber + ">")) {
                        // An if statement to close the current element under a specific set number found through looping.
                        if (currentStringLine != null) {
                            xmlWriter.write("        </laptop>\n"); // Closing the element.
                        }
                        // Initiating the current element name with the set number.
                        currentStringLine = "        <laptop" + dataStartingNumber + ">";
                        // Writing the proper element name by removing the set number from it, to maintain a proper format.
                        xmlWriter.write(currentStringLine.replaceAll("\\d+", "") + "\n");
                    }
                }

                // This part is for the child element format and syntax works (<brandName>, </brandName>, <modelName>, </modelName>, <builtVersion>, </builtVersion>).
                String[] txtDataLine = dataLine.split("; "); // String array to split and store the data based on ";" at the end of each line of data.
                for (String strParts : txtDataLine) { // A for loop for splitting the key and value data.
                    // If the array element starts off with numbers followed by a dot, then creating another array.
                    // In the new array, storing the data by splitting it on the "=" part of data.
                    if (strParts.matches("\\d+\\..*")) {
                        String[] neededKeyValue = strParts.split("="); // Initiating the array to store key and value data based on split.
                        if (neededKeyValue.length == 2) { // The length for the data needs to be 2 (key, value).
                            // Defining the key data, and it starts from after the "number/s. " and end before "=".
                            // for example, if we have "1. brandName=Asus;", the key here is "brandName".
                            String relevantKey = neededKeyValue[0].substring(neededKeyValue[0].indexOf(".") + 2);
                            // Writing the child elements (brandName, modelName, builtVersion).
                            // Written in this way to maintain a proper XML format.
                            xmlWriter.write("            <" + relevantKey + ">"
                                                + neededKeyValue[1].replaceAll(".$", "") // Removing the last ";" after the value.
                                                + "</" + relevantKey + ">\n");
                        }
                    }
                }
            }

            xmlWriter.write("        </laptop>\n"); // Closing the final element since it doesn't get written during the looping process.
            xmlWriter.write("    </laptops>\n"); // Closing the root element.
            xmlWriter.close(); // To write the data and close the FileWriter stream. Unless closed, the data won't be written into the file.
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Main method.
    public static void main(String[] args) {
        String inputTxtFile = "predefined_data.txt"; // Defining the input text file.
        String outputXmlFile = "output.xml"; // Defining the output xml file.

        Path txtFilePath = Paths.get(inputTxtFile); // Assigning a path to the input text file.

        // Writing the xml data if the text file path exists to read the data from.
        if (Files.exists(txtFilePath)) {
            TxtToXmlConverter txtToXmlConverter = new TxtToXmlConverter(); // Creating an instance for the class.
            txtToXmlConverter.txtToXmlFile(inputTxtFile, outputXmlFile); // Calling the 'txtToXmlFile' method with the appropriate parameters to run the class.
            // Message to show successful completion of writing the data from the text file into the xml file.
            System.out.println("Great Job!\nThe Data From The TXT File Has Been Written Into The XML File Successfully!!!\n");
        }
        else {
            // Printing out text file not found statement.
            System.out.println("ERROR!\nSorry. The Text File '" + inputTxtFile + "' Is Not Found.\nPlease Try Again.\n");
        }
    }

    // Default Constructor.
    public TxtToXmlConverter() {
    }

}