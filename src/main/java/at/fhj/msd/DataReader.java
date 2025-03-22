package at.fhj.msd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataReader {
      private String file;

      public DataReader(String file)
      {
            this.file = file;
      }

      public ArrayList<Schedeule> read()
      {
            int linec= 1;
        ArrayList<Schedeule> schedeules = new ArrayList<>();
        String content = "";
        String[] parts = new String[7];
        String line;
        File files = new File(file);

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
                        System.out.printf("File '%s' not found", file);
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
                    System.out.printf("File '%s' not found", file);
                    return null;
                }
                catch (IOException e)
                {
                    System.out.printf("Error reading file '%s'", e.getMessage());
                    return null;
                }   
    }

}


