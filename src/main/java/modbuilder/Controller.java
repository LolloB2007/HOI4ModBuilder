package modbuilder;

import appendix.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Controller {
    
    private LinkedList<Command> exampleCommands = new LinkedList<Command>();
    
    /**
     * Default constructor
     */
    public Controller() throws FileNotFoundException
    {
        instantiateExampleCommands();
        System.out.println(exampleCommands);
    }
    
    /**
     * Method takes a String s and writes it on File dataFile. Append = true
     * @param s
     * @param dataFile
     * @throws IOException
     * @throws FileNotFoundException 
     */
    public static void writeData(String s, File dataFile) throws IOException, FileNotFoundException //append = true
    {
        FileWriter writer = new FileWriter(dataFile, true);
        
        writer.write(s + "\n");
        writer.flush();
        writer.close();
    }
    
    /**
     * Empties file, sets content equal to ""
     * @param f
     * @throws IOException 
     */
    public static void ereaseFileContent(File f) throws IOException
    {
        FileWriter w = new FileWriter(f, false);
        
        w.write("");
        w.flush();
        w.close();
    }
    
    /**
     * Reads the file given as a parameter and returns the contents as a LinkedList
     * where every line is represented by a Node
     * @param f
     * @return LinkedList<String> fileContents
     * @throws FileNotFoundException 
     */
    public static LinkedList<String> readFile(File f) throws FileNotFoundException
    {
        Scanner reader = new Scanner(f);
        
        LinkedList<String> ret = new LinkedList<String>();
        
        while(reader.hasNext())
        {
            ret.add(reader.nextLine());
        }
        
        reader.close();
        
        return ret;
    }
    
    /**
     * Extracts all example commands from the command cheat sheet every time
     * that Controller is created at every launch of the application
     * @throws FileNotFoundException 
     */
    private void instantiateExampleCommands() throws FileNotFoundException 
    {
        File htmlFile = new File("src/main/java/gui/commands_cheat_sheet.html");
        
        LinkedList<String> contents = readFile(htmlFile);
        
        for(int i = 0; i<contents.size(); i++)
        {
            if(contents.get(i).contains("<tr")) {
                exampleCommands.add(new Command(contents.get(i+1), contents.get(i+9)));
            }
        }
    }
    
    /**
     * Method that returns a row of an html table
     * @param initIndex
     * @param fileContents
     * @return LinkedList<String> row
     */
    public LinkedList<String> extractTableRow(int initIndex, LinkedList<String> fileContents)
    {
        int finalIndex = 0;
        boolean isFinished = false;
        int counter = 0;
        
        while(!isFinished) {
            if(fileContents.get(initIndex + counter).contains("</tr>")) {
                finalIndex = initIndex + counter;
                isFinished = true;
            }
            
            counter++;
        }
        
        LinkedList<String> row = new LinkedList<String>();
        
        for(int i = initIndex; i<=finalIndex; i++) {
            row.add(fileContents.get(i));
        }
        
        return row;
    }
    
    /**
     * Returns the elements within an html table's row.
     * Index 0 is the name.
     * Index 1 is the description.
     * Index 2 is the code.
     * @param row
     * @return LinkedList<String> rowElements.
     */
    public LinkedList<String> extractRowElements(LinkedList<String> row) //to be written
    {
        return null;
    }
    
}
