package compulsory.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "albums", schema = "public")
@NamedQueries({@NamedQuery(name = "Album.findByName", query = "select e from Album e where e.title= ?1"), @NamedQuery(name = "Album.findById", query = "select e from Album e where e.id=?1"),})
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id_album")
    private int id;

    @Column(name = "release_year")
    private int year;

    @Column(name = "title")
    private String title;

    @Column(name = "artist")
    private String artist;

    @Column(name = "genre")
    private String genre;

    public Album(String title, String artist, String genre, int year) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
    }

    public Album() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return this.id + " " + this.title + " by the singer " + this.artist + " released in " + this.year + " has the genre " + this.genre;
    }

    //starting for homework
    @OneToMany
    @JoinColumn(name = "name", referencedColumnName = "artist")
    private List<Artist> artistList;

    @ManyToMany
    @JoinTable(name = "album_artist_relation", schema = "public", joinColumns = @JoinColumn(name = "name", referencedColumnName = "artist"), inverseJoinColumns = @JoinColumn(name = "artist", referencedColumnName = "name"))
    private List<Artist> artistListWhole;
}

