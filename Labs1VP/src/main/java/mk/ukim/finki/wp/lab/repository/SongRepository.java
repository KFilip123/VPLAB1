package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {
    public List<Song> songs = new ArrayList<Song>();

    public SongRepository() {
        songs.add(new Song("1987", "Luda traka", "Regge", 2021));
        songs.add(new Song("1988", "Najaka traka", "Turbofolk", 2022));
        songs.add(new Song("1989", "Brza traka", "Tehnich", 2023));
        songs.add(new Song("1990", "CC2", "Rap", 2024));
        songs.add(new Song("1991", "Sve moje belo e", "R&B", 2025));
    }

    public List<Song> findAll()
    {
        return songs;
    }

    public Song findByTrackId(String trackId)
    {
        return songs.stream().filter(song -> song.getTrackId().equals(trackId)).findFirst().orElse(null);
    }

    public Artist addArtistToSong(Artist artist, Song song)
    {
        for(Song s : songs)
        {
            if(s.getTitle().equals(song.getTitle()))
            {
                s.addPerformer(artist);
                return artist;
            }
        }
        return null;
    }
}
