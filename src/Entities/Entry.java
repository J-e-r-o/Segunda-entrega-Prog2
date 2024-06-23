package src.Entities;

import src.uy.edu.um.adt.linkedlist.MyList;

import java.util.Date;

public class Entry implements Comparable<Entry> {

    private Song song;
    private String country;
    private String date;
    private int position;


    public Entry(Song song, String country, String date, int position) {
        this.song = song;
        this.country = country;
        this.date = date;
        this.position = position;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    public int compareTo(Entry entry) {
        if(position > entry.getPosition()){
            return 1;
        }
        else if(position < entry.getPosition()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
