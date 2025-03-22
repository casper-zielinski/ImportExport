package at.fhj.msd;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class DataWriter {

      private String filename;
      ArrayList<Schedeule> schedeule = new ArrayList<>();

      public DataWriter(String filename, ArrayList<Schedeule> schedeule )
      {
            this.filename = filename;
            this.schedeule = schedeule;
      }

      public void writeCsv()
      {
            String filenames = this.filename  + ".csv";
        try (FileWriter fw = new FileWriter(filenames); BufferedWriter bw = new BufferedWriter(fw))
        {
            
            
            {
                for (int i = 0; i < schedeule.size(); i++)
                {
                    bw.write(schedeule.get(i).asCsv(","));
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
            System.out.printf("Error writing to file %s.csv", this.filename);
        }
      }

      public void writeTsv()
      {
            String filenames = this.filename  + ".tsv";
        try (FileWriter fw = new FileWriter(filenames); BufferedWriter bw = new BufferedWriter(fw))
        {
            
            
            {
                for (int i = 0; i < schedeule.size(); i++)
                {
                    bw.write(schedeule.get(i).asCsv("      "));
                    if (i + 1 == schedeule.size())
                    {
                        System.out.println();
                        System.out.printf("Filename: %s, This document has %d lines", this.filename, i+1);
                    }
                }
            }
        } 
        catch (IOException e)
        {
            System.out.printf("Error writing to file %s.csv", this.filename);
        }
      }

      public void writeSql()
      {
            String filenames = this.filename  + ".sql";
        try (FileWriter fw = new FileWriter(filenames); BufferedWriter bw = new BufferedWriter(fw))
        {
            
            
            {
                for (int i = 0; i < schedeule.size(); i++)
                {
                    bw.write(schedeule.get(i).asSql());
                    if (i + 1 == schedeule.size())
                    {
                        System.out.println();
                        System.out.printf("Filename: %s, This document has %d lines", this.filename, i+1);
                    }
                }
            }
        } 
        catch (IOException e)
        {
            System.out.printf("Error writing to file %s.csv", this.filename);
        }
      }
}
