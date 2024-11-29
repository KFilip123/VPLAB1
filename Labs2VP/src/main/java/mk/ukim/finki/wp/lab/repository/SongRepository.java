package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class SongRepository {
    public List<Song> songs = new ArrayList<Song>();
    AlbumRepository albumRepository = new AlbumRepository();

    public SongRepository() {

        songs.add(new Song("Luda traka", "Regge", 2021, albumRepository.albums.get(0)));
        songs.add(new Song("Najaka traka", "Turbofolk", 2022, albumRepository.albums.get(1)));
        songs.add(new Song("Brza traka", "Tehnich", 2023, albumRepository.albums.get(2)));
        songs.add(new Song("CC2", "Rap", 2024, albumRepository.albums.get(3)));
        songs.add(new Song("Sve moje belo e", "R&B", 2025, albumRepository.albums.get(3)));
    }

    public List<Song> findAll()
    {
        return songs;
    }

    public Song findByTrackId(String trackId)
    {
        return songs.stream().filter(song -> song.getTrackId().equals(trackId)).findFirst().orElse(null);
    }

    public Artist addArtistToSong(Artist artist, Song song) {

        Song artist_song = songs.stream()
                .filter(pesna -> pesna.equals(song))
                .findFirst()
                .orElse(null);

        if (artist_song != null) {
            artist_song.getPerformers().add(artist);
            return artist;
        }

        return null;
    }

    public Optional<Song> save(String title, String genre, Integer releaseYear, Album album){
        Song song = new Song(title, genre, releaseYear, album);
        songs.removeIf(s -> Objects.equals(s.getTitle(), title));
        songs.add(song);
        return Optional.of(song);
    }

    public void deleteById(Long id) {
        songs.removeIf(s -> s.getTrackId().equals(id));
    }
}
