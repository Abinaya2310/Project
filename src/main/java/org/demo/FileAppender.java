//What does this File do
//
package org.demo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

	public class FileAppender extends ExcelDataSupllier  {


		public static void writeToFile(String message, String filePath) {
	    try (FileWriter fileWriter = new FileWriter("./src/main/java/org/demo/login", true);
	    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
	    bufferedWriter.write(message);
	    bufferedWriter.newLine(); 
	    } 

	    catch (IOException e) {
	    System.out.println("An error occurred while writing to the file: " + e.getMessage());
	     }
	     }
	   
	   
	     public static void main(String[] args) {
	    
	    String filePath = "./src/main/java/org/demo/login"; // Change the file path as needed
	    writeToFile("login success","./src/main/java/org/demo/login");
	    writeToFile("Abinaya S", " ./src/main/java/org/demo/login");
	    }
        }
