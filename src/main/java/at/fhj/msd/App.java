package at.fhj.msd;
import  java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;




public class App {
    public static void main(String[] args) {

        System.out.println();
        ArrayList<Schedeule> schedeules = new ArrayList<>();
        readData("file.txt");


        
        


    }

    public static ArrayList<Schedeule> readData(String filename)
    {
        int linec= 1;
            ArrayList<Schedeule> schedeules = new ArrayList<>();
            String content = "";
           String[] parts = new String[7];
           String line;
            
                File file = new File(filename);
                try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
                    
                    
                    while (((line = br.readLine()) != null))
                    {
                        content += line + "\n";
                        parts = line.split(";");
                        schedeules.add(new Schedeule(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]));
                        linec++;
                        
                        
                    }
                    return schedeules;
                
                }
                catch (IllegalArgumentException e)
                {
                    try (FileReader fr = new FileReader(file);BufferedReader br = new BufferedReader(fr))
                    {
                            // System.out.printf("Error on line %d", linec);
                            // System.out.print(" " + e.getMessage());
                            // br.readLine();
                            ArrayList<Schedeule> schedeuleserror = new ArrayList<>();
                            linec = 1;
                    while (((line = br.readLine()) != null))
                    {
                        
                        content += line + "\n";
                        parts = line.split(";");
                        if (parts[0].startsWith("SWD"))
                        {
                            schedeuleserror.add(new Schedeule(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]));
                            linec++;
                        }
                        else
                        {
                            System.out.printf("Error on line %d!!!", linec);
                            linec++;
                            System.out.print(" " + e.getMessage() + " ");
                            System.out.println();
                        }
                        
                        
                    }
                    schedeules = schedeuleserror;
                    return schedeules;
                
                            
                    }
                    catch (FileNotFoundException d)
                    {
                        System.out.printf("File '%s' not found", filename);
                        return null;
                    }
                    catch (IOException d)
                    {
                        System.out.printf("Error reading file '%s'", e.getMessage());
                        return null;
                    }

                    
                   
                }
                catch (FileNotFoundException e)
                {
                    System.out.printf("File '%s' not found", filename);
                    return null;
                }
                catch (IOException e)
                {
                    System.out.printf("Error reading file '%s'", e.getMessage());
                    return null;
                }
                
    }



    public static void writeData(Schedeule schedeule, String type)
    {
        
    }
}
