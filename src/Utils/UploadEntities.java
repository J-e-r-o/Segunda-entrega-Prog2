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
        MyList<Artist> newArtists = new MyLinkedListImpl<Artist>();
        newArtists = addArtists(line);


        String key = line[0].replaceAll("\"", "").trim();
        Song newSong = new Song(key, line[1], Float.parseFloat(formattedTempo), formattedString, newArtists);
        if (!songs.contains(key)) {
            songs.put(key, newSong);
        }

    }

    public static void addEntry(MyList<Entry> entries, String[] line) {
        return;
    }

    public static MyList<Artist> addArtists(String[] line) {

        String artists = line[2];
        artists = artists.replaceAll("^\"|\"$", "");
        String[] artistList = artists.split(",\\s*");
        MyList<Artist> artistsToAdd = new MyLinkedListImpl<>();

        for (int i = 0; i < artistList.length; i++) {
            String artistName = artistList[i];
            Artist newArtist = new Artist(artistName);
            artistsToAdd.add(newArtist);
        }

        return artistsToAdd;
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
