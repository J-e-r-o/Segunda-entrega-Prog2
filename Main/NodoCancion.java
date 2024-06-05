package Main;

public class NodoCancion {

    String spotify_id;
    String name;
    String artists;
    int daily_rank;
    int daily_movement;
    int weekly_movement;
    String country;
    String snapshot_date;
    int popularity;
    String is_explicit;
    int duration_ms;
    String album_name;
    String album_release_date;
    float danceability;
    float energy;
    int key;
    float loudness;
    int mode;
    float speechiness;
    float acousticness;
    String instrumentalness;         //Creo que deberia ser "Long" por dudo que importe
    float liveness;
    float valance;
    float tempo;
    int time_signature;

    public NodoCancion(String spotify_id,String name,String artists,int daily_rank, int daily_movement, int weekly_movement,String country,String snapshot_date,int popularity, String is_explicit, int duration_ms,
                       String album_name,String album_release_date, float danceability, float energy, int key, float loudness, int mode  ,float speechiness, float acousticness,String instrumentalness,float liveness,  float valance,
                       float tempo, int time_signature) {
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
}

