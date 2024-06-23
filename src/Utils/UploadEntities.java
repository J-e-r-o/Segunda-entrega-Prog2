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
        //newArtists = addArtists(line);

        String key = line[0].replaceAll("\"", "").trim();
        Song newSong = new Song(key, line[1], Float.parseFloat(formattedTempo), formattedString, newArtists);
        if (!songs.contains(key)) {
            songs.put(key, newSong);
        }

    }

    public static void addEntry(hashInterfaze<Song, Entry> entries, hashInterfaze<String, Song> songs, String[] line) throws Exception {

        String stringPosition = line[3];
        if (!canBeConvertedToInt(stringPosition)) {
            return;
        }
        int formattedPosition = Integer.parseInt(stringPosition.replaceAll("\"", "").trim());
        String formattedCountry = line[6].replaceAll("\"", "").trim();
        String formattedDate = line[7].replaceAll("\"", "").trim();
        if (!isValidDate(formattedDate)) { //if the data is wrong stops the execution
            return;
        }

        String key = line[0].replaceAll("\"", "").trim();
        if (!songs.contains(key)) {
            addSong(songs, line);
        }
        Song song = songs.get(key);

        Entry newEntry = new Entry(song, formattedCountry, formattedDate, formattedPosition);

        if (!entries.contains(song)) {
            entries.put(song, newEntry);
        }
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

    public static boolean canBeConvertedToInt(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
