package mk.ukim.finki.wp.lab.repository;


import mk.ukim.finki.wp.lab.model.Album;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AlbumRepository {
    public List<Album> albums = new ArrayList<Album>();

    public AlbumRepository()
    {
        albums.add(new Album(11L, "album1", "Regge", "2021"));
        albums.add(new Album(12L, "album2", "Turbo", "2022"));
        albums.add(new Album(13L, "album3", "Tehnich", "2023"));
        albums.add(new Album(14L, "album4", "Rap", "2024"));
        albums.add(new Album(15L, "album5", "R&B", "2024"));
    }

    public List<Album> findAll()
    {
        return albums;
    }

    public Optional<Album> findAlbumId(Long id) {
        return albums.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

}
