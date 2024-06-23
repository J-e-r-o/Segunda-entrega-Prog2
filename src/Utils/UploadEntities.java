package src.Utils;

import src.Entities.Artist;
import src.Entities.Entry;
import src.Entities.Song;
import src.uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import src.uy.edu.um.adt.linkedlist.MyList;
import src.uy.edu.um.adt.hashCerrado.*;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;



public class UploadEntities {
    public static void addSong(hashInterfaze<String, Song> songs,String[] line) throws Exception {

        String formattedString = line[12].replaceAll("\"", "").trim();
        String formattedTempo = line[23].replaceAll("\"", "").trim();
        if (!isValidDate(formattedString)) { //if the data is wrong stops the execution
            return;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(formattedString); //album release date
        MyList<Artist> newArtists = new MyLinkedListImpl<Artist>();
        //Date parsedDate = dateFormat.parse(formattedString);
        String key = line[0].replaceAll("\"", "").trim();
        Song newSong = new Song(key, line[1], Float.parseFloat(formattedTempo), formattedString, newArtists);
        if (!songs.contains(key)) {
            songs.put(key, newSong);
        }

    }

    public static void addEntry(MyList<Entry> entries, String[] line) {
        return;
    }

    public static boolean isValidDate(String dateStr) {
        if (dateStr == null || dateStr.length() != 10) {
            return false;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); // Ensure strict parsing

        try {
            dateFormat.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}
