package src.Entities;

import src.uy.edu.um.adt.linkedlist.MyList;

import java.util.Date;

public class Song implements Comparable<Song>{

    private String sportifyId;
    private String name;
    private float tempo;
    private String creationDate; //Lo guarde asi para ver si cargaba mas rapido que parseando a fecha
    private MyList<Artist> artists;

    public Song(String sportifyId, String name, float tempo, String creationDate, MyList<Artist> artists) {
        this.sportifyId = sportifyId;
        this.name = name;
        this.tempo = tempo;
        this.creationDate = creationDate;
        this.artists = artists;
    }

    public String getSportifyId() {
        return sportifyId;
    }

    public void setSportifyId(String sportifyId) {
        this.sportifyId = sportifyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTempo() {
        return tempo;
    }

    public void setTempo(Long tempo) {
        this.tempo = tempo;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public MyList<Artist> getArtists() {
        return artists;
    }

    public void setArtists(MyList<Artist> artists) {
        this.artists = artists;
    }

    @Override
    public int compareTo(Song o) {
        return 0;
    }
}
