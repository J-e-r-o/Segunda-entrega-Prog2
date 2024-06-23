package src.Utils;

import src.Entities.*;
import src.uy.edu.um.adt.heap.MyHeap;
import src.uy.edu.um.adt.heap.MyHeapImpl;
import src.uy.edu.um.adt.linkedlist.MyList;
import src.uy.edu.um.adt.hashCerrado.*;


import java.util.Date;

public class Operations {

    public static void top10SongsFromCountryAndDate(MyList<Entry> entries, String country, Date date) {


        for(int i = 0; i < entries.size(); i++) {
            String countryItem = entries.get(i).getCountry();
            Date dateItem = entries.get(i).getDate();

            if (countryItem.equals(country) && dateItem == date) {
                break;
                //Cargar los datos en un heap
            }
        }

    }

    public static void top5SongsFromRankingAndDate(MyList<Entry> entries, Date date) {

        hashInterfaze<Song, Integer> songEntries = new hash<>(10000);

        for (int i = 0; i < entries.size(); i++) {
            Date dateItem = entries.get(i).getDate();
            int positionItem = entries.get(i).getPosition();

            if (dateItem == date && positionItem <= 50) {
                Song song = entries.get(i).getSong();
                if (!songEntries.contains(song)) {
                    songEntries.put(song, 1); //Counts song entries
                } else {
                    int value = songEntries.get(song);
                    value++;

                    songEntries.remove(song);
                    songEntries.put(song,value);
                }
            }
        }

        //MyHeap<Song> songsHeap = new MyHeapImpl<Song>(10);
        /*recorro el hash
            heapSort para que me devuelva el top 5
        */
    }

    public static void top7artistsFromRankingAndDate(MyList<Entry> entries, Date startDate, Date finishDate) {

        hashInterfaze<Artist, Integer> artistsEntries = new hash<>(10000);

        for (int i = 0; i < entries.size(); i++) {
            Date dateItem = entries.get(i).getDate();
            int positionItem = entries.get(i).getPosition();

            if (dateItem.after(startDate) && dateItem.before(finishDate) && positionItem <= 50) {
                Song song = entries.get(i).getSong();
                MyList<Artist> artists = song.getArtists();

                for (int j = 0; j < artists.size(); j++) {
                    Artist artist = artists.get(i);
                    if (!artistsEntries.contains(artist)) {
                        artistsEntries.put(artist, 1); //Counts artists
                    } else {
                        int value = artistsEntries.get(artist);
                        value++;

                        artistsEntries.remove(artist);
                        artistsEntries.put(artist,value);
                    }
                }
            }
        }
        /*
        recorro el hash
            heapSort para que me devuelva el top 7
        * */
    }

    public static int artistInTop50GivenDate(MyList<Entry> entries, Date date, Artist artist) {

        int quantity = 0;
        for (int i = 0; i < entries.size(); i++) {

            Date dateItem = entries.get(i).getDate();
            int positionItem = entries.get(i).getPosition();
            Song songItem = entries.get(i).getSong();

            if (dateItem == date && positionItem <= 50) {

                MyList<Artist> artistsItems = songItem.getArtists();
                for (int j = 0; j < artistsItems.size(); j++) {

                    Artist artistItem = artistsItems.get(i);

                    if (artistItem == artist) {
                        quantity++;
                    }
                }
            }
        }

        return quantity;
    }

    public static int QuantityOfSongsWithSpecificTempoAndDate(MyList<Song> songs, float startTempo, float finishTempo, Date startDate, Date finishDate) {

        int count = 0;
        for (int i = 0; i < songs.size(); i++) {
            float tempoItem = songs.get(i).getTempo();
            String dateItem = songs.get(i).getCreationDate();

            if ((tempoItem >= startTempo) && (tempoItem <= finishTempo) /*&& (dateItem.after(startDate)) && (dateItem.before(finishDate))*/) {
                count++;

            }
        }

        return count;

    }


}
