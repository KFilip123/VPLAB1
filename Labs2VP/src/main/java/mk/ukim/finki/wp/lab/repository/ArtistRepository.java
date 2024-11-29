package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {
    public List<Artist> artists = new ArrayList<>();

    public ArtistRepository() {
        artists.add(new Artist(2020L, "Cika", "Stole", "Pevac godine"));
        artists.add(new Artist(2021L, "Cika", "Bone", "Jaka krivina"));
        artists.add(new Artist(2022L, "Cika", "Kole", "Kida kako peva"));
        artists.add(new Artist(2023L, "Cika", "Mole", "Juzni vetar gas"));
        artists.add(new Artist(2024L, "Cika", "Vole", "Sve moje belo e"));
    }
    public List<Artist> findAll()
    {
        return artists;
    }
    public Optional<Artist> findById(Long id)
    {
        return artists.stream().filter(artist -> artist.getId().equals(id)).findFirst();
    }
}
