package Main;

public class NodoCancion {

    String spotify_id;
    String name;
    String artists;
    String daily_rank;
    String daily_movement;
    String weekly_movement;
    String country;
    String snapshot_date;
    String popularity;
    String is_explicit;
    String duration_ms;
    String album_name;
    String album_release_date;
    String danceability;
    String energy;
    String key;
    String loudness;
    String mode;
    String speechiness;
    String acousticness;
    String instrumentalness;         //Creo que deberia ser "Long" por dudo que importe
    String liveness;
    String valance;
    String tempo;
    String time_signature;

    public NodoCancion(String spotify_id,String name,String artists,String daily_rank, String daily_movement, String weekly_movement,String country,String snapshot_date,String popularity, String is_explicit, String duration_ms,
                       String album_name,String album_release_date, String danceability, String energy, String key, String loudness, String mode  ,String speechiness, String acousticness,String instrumentalness,String liveness,  String valance,
                       String tempo, String time_signature) {
        this.spotify_id=spotify_id;
        this.name= name;
        this.artists=artists;
        this.daily_rank=daily_rank;
        this.daily_movement=daily_movement;
        this.weekly_movement= weekly_movement;
        this.country=country;
        this.snapshot_date=snapshot_date;
        this.popularity=popularity;
        this.is_explicit=is_explicit;
        this.duration_ms= duration_ms;
        this.album_name=album_name;
        this.album_release_date=album_release_date;
        this.danceability= danceability;
        this.energy=energy;
        this.key=key;
        this.loudness=loudness;
        this.mode=mode;
        this.speechiness=speechiness;
        this.acousticness=acousticness;
        this.instrumentalness=instrumentalness;
        this.liveness=liveness;
        this.valance=valance;
        this.tempo=tempo;
        this.time_signature=time_signature;
    }


    @Override
    public String toString() {
        return "NodoCancion{" +
                "spotify_id='" + spotify_id + '\'' +
                ", name='" + name + '\'' +
                ", artists='" + artists + '\'' +
                ", daily_rank=" + daily_rank +
                ", daily_movement=" + daily_movement +
                ", weekly_movement=" + weekly_movement +
                ", country='" + country + '\'' +
                ", snapshot_date='" + snapshot_date + '\'' +
                ", popularity=" + popularity +
                ", is_explicit='" + is_explicit + '\'' +
                ", duration_ms=" + duration_ms +
                ", album_name='" + album_name + '\'' +
                ", album_release_date='" + album_release_date + '\'' +
                ", danceability=" + danceability +
                ", energy=" + energy +
                ", key=" + key +
                ", loudness=" + loudness +
                ", mode=" + mode +
                ", speechiness=" + speechiness +
                ", acousticness=" + acousticness +
                ", instrumentalness='" + instrumentalness + '\'' +
                ", liveness=" + liveness +
                ", valance=" + valance +
                ", tempo=" + tempo +
                ", time_signature=" + time_signature +
                '}';
    }




}

