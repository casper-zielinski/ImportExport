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
            ArrayList<Schedeule> schedeules = new ArrayList<>();
            String content = "";
           String[] parts = new String[7];
            
                File file = new File(filename);
                try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
                    String line;
                    while (((line = br.readLine()) != null))
                    {
                
                        content += line + "\n";
                        parts = line.split(";");
                        schedeules.add(new Schedeule(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]));
                        
                    }
                    return schedeules;
                
                }
                catch (IllegalArgumentException e)
                {
                    try (FileReader fr = new FileReader(file);BufferedReader br = new BufferedReader(fr))
                    {

                            br.readLine();
                            String line;
                    while (((line = br.readLine()) != null))
                    {
                
                        content += line + "\n";
                        parts = line.split(";");
                        schedeules.add(new Schedeule(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]));
                        
                    }
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
}
