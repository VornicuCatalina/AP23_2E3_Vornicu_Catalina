package optional;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;

public class ReadCSV {
    AlbumDAO albums=new AlbumDAO();
    public ReadCSV(String file){
        try {

            // Create an object of filereader
            // class with CSV file as a parameter.
            FileReader fileReader = new FileReader(file);

            // create csvReader object passing
            // file reader as a parameter
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
            String[] nextRecord;

            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                albums.create(Integer.parseInt(nextRecord[1]),nextRecord[2],nextRecord[3],nextRecord[4]); //int release_year, String title, String artist, String genre
                Database.getConnection().commit();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
