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
                LinkedList<String> row = extractTableRow(i, contents);
                LinkedList<String> cleanedRow = cleanRow(row);
                LinkedList<String> parsedRow = htmlParseRow(cleanedRow);
                LinkedList<String> elements = getRowElements(parsedRow);
                System.out.println(elements);
                exampleCommands.add(new Command(elements.get(0), elements.get(1), elements.get(2)));
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
    public LinkedList<String> getRowElements(LinkedList<String> parsedRow)
    {
        LinkedList<String> ret = new LinkedList<String>();
        
        ret.add(parsedRow.get(0));
        ret.add(parsedRow.get(4));
        ret.add(parsedRow.get(3));
        
        return ret;
    }
    
    /**
     * Returns the parsed row (with all html tags removed)
     * @param row
     * @return LinkedList<String> parsedRow
     */
    public LinkedList<String> htmlParseRow(LinkedList<String> row) //to be written
    {
        LinkedList<String> parsedRow = new LinkedList<String>();
        
        for(int i = 0; i<row.size(); i++) {
            String cleanedText = row.get(i).replaceAll("<[^>]*>", "").trim();
            if(cleanedText.length()>0) {
                parsedRow.add(cleanedText);
            }
        }
        
        return parsedRow;
    }
    
    /**
     * Method that cleans a row so that multi-line elements are saved in a
     * single string and therefore at a single index within the LinkedList
     * that is returned
     * @param uncleanedRow
     * @return LinkedList<String> cleanRow
     */
    public LinkedList<String> cleanRow(LinkedList<String> uncleanedRow)
    {
        LinkedList<String> ret = new LinkedList<String>();
        int counter = 0;
        int init = 0;
        int fin = 0;
        
        for(int i = 0; i<uncleanedRow.size(); i++) {
            if(counter%2==0 && uncleanedRow.get(i).contains("<td")) {
                counter++;
                init = i;
            }
            
            if(counter%2==1 && uncleanedRow.get(i).contains("td>")) {
                fin = i;
                counter++;
                
                String s = "";
                
                for(int j = init; j<fin; j++) {
                    s += uncleanedRow.get(j) + "\n";
                }
                
                s += uncleanedRow.get(fin);
                
                ret.add(s);
            }
        }
        
        return ret;
    }
    
}
