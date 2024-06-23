package src.Utils;

import src.Entities.*;
import src.uy.edu.um.adt.Heap.*;
import src.uy.edu.um.adt.linkedlist.MyList;
import src.uy.edu.um.adt.hashCerrado.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class Operations {

    public static void top10SongsFromCountryAndDate(hashInterfaze<Song, Entry> entries, String country, Date date) throws ParseException {

        MyList<Song> keys = entries.getKeys();
        Iterator<Song> iterator = keys.iterator();
        MyHeap<Entry> entriesToPrint = new MyHeapMin<>(10);
        boolean isFull = false;
        int count = 0;

        while (iterator.hasNext()) {
            Song key = iterator.next();
            String dateItem = entries.get(key).getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateItemFormatted = dateFormat.parse(dateItem);
            String countryItem = entries.get(key).getCountry();

            if (countryItem.equals(country) && dateItemFormatted == date) {
                Entry entryToAdd = entries.get(key);
                if (!isFull) {
                    try {
                        entriesToPrint.insert(entryToAdd);
                        count++;
                        if (count == 10) {
                            count++;
                        }

                    } catch (HeapOverflow e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    if (entryToAdd.compareTo(entriesToPrint.top()) > 0) {
                        try {
                            entriesToPrint.delete();
                        } catch (EmptyHeapException e) {
                            throw new RuntimeException(e);
                        }
                        try {
                            entriesToPrint.insert(entryToAdd);
                        } catch (HeapOverflow e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

            for (int i = 0; i < entriesToPrint.size(); i++) {
                Song songToPrint = entriesToPrint.top().getSong();
                String name = songToPrint.getName();
                System.out.print(i+1);
                System.out.print(", ");
                System.out.println(name);
                System.out.println("\n");
                try {
                    entriesToPrint.delete();
                } catch (EmptyHeapException e) {
                    throw new RuntimeException(e);
                }

            }

        }
    }

    public static void top5SongsFromRankingAndDate(hashInterfaze<Song, Entry> entries, Date date) throws ParseException {

        hashInterfaze<Song, Integer> songEntries = new hash<>(10000);
        MyList<Song> keys = entries.getKeys();
        Iterator<Song> iterator = keys.iterator();
        MyHeap<Integer> entriesToPrint = new MyHeapMin<>(5);


        while (iterator.hasNext()) {
            Song key = iterator.next();
            String dateItem = entries.get(key).getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateItemFormatted = dateFormat.parse(dateItem);
            int positionItem = entries.get(key).getPosition();

            if ((dateItemFormatted == date) && (positionItem <= 50)) {
                Song song = entries.get(key).getSong();
                if (!songEntries.contains(song)) {
                    songEntries.put(song, 1);
                } else {
                    int value = songEntries.get(song);
                    value++;

                    songEntries.remove(song);
                    songEntries.put(song, value);
                }
            }
        }

        boolean isFull = false;
        int count = 0;
        MyList<Song> keys2 = songEntries.getKeys();
        Iterator<Song> iterator2 = keys2.iterator();

        while (iterator2.hasNext()) {
            Song key2 = iterator2.next();
            int topValue = songEntries.get(key2);

            if (!isFull) {
                try {
                    entriesToPrint.insert(topValue);
                    count++;
                    if (count == 10) {
                        count++;
                    }

                } catch (HeapOverflow e) {
                    throw new RuntimeException(e);
                }
            } else {
                if (topValue > entriesToPrint.top()) {
                    try {
                        entriesToPrint.delete();
                    } catch (EmptyHeapException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        entriesToPrint.insert(topValue);
                    } catch (HeapOverflow e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        //esta imprimiendo por la aparicion y no por el nombre de la cancion
        for (int i = 0; i < entriesToPrint.size(); i++) {
            int value = entriesToPrint.top();
            System.out.print(i+1);
            System.out.print(", ");
            System.out.println(value);
            System.out.println("\n");
            try {
                entriesToPrint.delete();
            } catch (EmptyHeapException e) {
                throw new RuntimeException(e);
            }

        }



    }

    public static void top7artistsFromRankingAndDate(hashInterfaze<Song,Entry> entries, Date startDate, Date finishDate) {

        //IMPLEMENTACION VIEJA CON LA LISTA
        //TIEMPO DE CARGA MUY LENTO

//        hashInterfaze<Artist, Integer> artistsEntries = new hash<>(10000);
//
//        for (int i = 0; i < entries.size(); i++) {
//            Date dateItem = entries.get(i).getDate();
//            int positionItem = entries.get(i).getPosition();
//
//            if (dateItem.after(startDate) && dateItem.before(finishDate) && positionItem <= 50) {
//                Song song = entries.get(i).getSong();
//                MyList<Artist> artists = song.getArtists();
//
//                for (int j = 0; j < artists.size(); j++) {
//                    Artist artist = artists.get(i);
//                    if (!artistsEntries.contains(artist)) {
//                        artistsEntries.put(artist, 1); //Counts artists
//                    } else {
//                        int value = artistsEntries.get(artist);
//                        value++;
//
//                        artistsEntries.remove(artist);
//                        artistsEntries.put(artist,value);
//                    }
//                }
//            }
//        }
//        /*
//        recorro el hash
//            heapSort para que me devuelva el top 7
//        * */
    }

    public static int artistInTop50GivenDate(MyList<Entry> entries, Date date, Artist artist) {

//        int quantity = 0;
//        for (int i = 0; i < entries.size(); i++) {
//
//            Date dateItem = entries.get(i).getDate();
//            int positionItem = entries.get(i).getPosition();
//            Song songItem = entries.get(i).getSong();
//
//            if (dateItem == date && positionItem <= 50) {
//
//                MyList<Artist> artistsItems = songItem.getArtists();
//                for (int j = 0; j < artistsItems.size(); j++) {
//
//                    Artist artistItem = artistsItems.get(i);
//
//                    if (artistItem == artist) {
//                        quantity++;
//                    }
//                }
//            }
//        }
//
//        return quantity;
        return 0;
    }

    public static int QuantityOfSongsWithSpecificTempoAndDate(hashInterfaze<String, Song> songs, float startTempo, float finishTempo, Date startDate, Date finishDate) throws ParseException {
        int count = 0;
        MyList<String> keys = songs.getKeys();
        Iterator<String> iterator = keys.iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            float tempoItem = songs.get(key).getTempo();
            String dateItem = songs.get(key).getCreationDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateItemFormatted = dateFormat.parse(dateItem);

            if ((tempoItem >= startTempo) && (tempoItem <= finishTempo) && (dateItemFormatted.after(startDate)) && (dateItemFormatted.before(finishDate))) {
               count++;
            }
        }

        System.out.println(count);
        return count;

    }








}
