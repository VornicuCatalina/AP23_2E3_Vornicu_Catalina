package compulsory.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "artists" , schema = "public")
@NamedQueries({
        @NamedQuery(name = "Artist.findAll",
                query = "select e from Artist e order by e.name"),
        @NamedQuery(name = "Artist.findByName",
                query = "select e from Artist e where e.name = ?1"),
        @NamedQuery(name = "Artist.findById",
                query = "select e from Artist e where e.id = ?1"),
})
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public Artist(String name) {
        this.name = name;
    }

    public Artist() {
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
