package compulsory.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "genres", schema = "public")
@NamedQueries({
        @NamedQuery(name = "Genre.findByName",
                query = "select e from Genre e where e.name= ?1"),
        @NamedQuery(name = "Genre.findById",
                query = "select e from Genre e where e.id=?1"),
})
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id_genre")
    private int id;

    @Column(name = "name")
    private String name;

    public Genre(int id) {
        this.id = id;
    }

    public Genre() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name;
    }

    //starting for homework
    @OneToMany
    @JoinColumn(name = "genre", referencedColumnName = "name")
    private List<Album> albumList;

    @ManyToMany
    @JoinTable(name = "genre_album_relation", schema = "public",
            joinColumns = @JoinColumn(name = "genre", referencedColumnName = "name"),
            inverseJoinColumns = @JoinColumn(name = "name", referencedColumnName = "genre"))
    private List<Album> albumListWhole;
}
