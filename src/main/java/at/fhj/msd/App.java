package at.fhj.msd;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;




public class App {
    public static void main(String[] args) {

        System.out.println();
        ArrayList<Schedeule> schedeules = new ArrayList<>();
        Schedeule s = new Schedeule("SWD Software Development 2", "G3", "Programmieren", "14:15:00", "16:00:00", "Schwab Harald", "EDV Labor");
        Schedeule b = new Schedeule("SWD Software Development 2", "G3", "Programmieren", "14:15:00", "16:00:00", "Schwab Harald", "EDV Labor");
        Schedeule d = new Schedeule("SWD Software Development 2", "G3", "Programmieren", "14:15:00", "16:00:00", "Schwab Harald", "EDV Labor");
        schedeules.add(s);
        schedeules.add(b);
        schedeules.add(d);
        //readData("file.txt");
        //writeData(schedeules, "csv");
        DataWriter data = new DataWriter("Bob", schedeules);
        data.writeCsv();
        data.writeTsv();
        data.writeSql();

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

    public static void writeData(ArrayList<Schedeule> schedeule, String type)
    {
        String filename = "data." + type;
        try (FileWriter fw = new FileWriter(filename); BufferedWriter bw = new BufferedWriter(fw))
        {
            String sign;

            sign = switch (type) {
                case "csv" -> ",";
                case "tsv" -> "    ";
                default -> ";";
            };

            if (!(type.equals("sql")))
            {
                for (int i = 0; i < schedeule.size(); i++)
                {
                    bw.write(schedeule.get(i).asCsv(sign));
                    

                    if (i + 1 == schedeule.size())
                    {
                        System.out.println();
                        System.out.printf("Filename: %s, This document has %d lines", filename, i+1);
                    }
                }
            }
            else
            {
                for (int i = 0; i < schedeule.size(); i++)
                {
                    bw.write(schedeule.get(i).asSql());
                    if (i + 1 == schedeule.size())
                    {
                        System.out.println();
                        System.out.printf("Filename: %s, This document has %d lines", filename, i+1);
                    }
                }
            }
        } 
        catch (IOException e)
        {
            System.out.printf("Error writing to file data.%s", type);
        }
    }
}
