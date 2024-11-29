package mk.ukim.finki.wp.lab.service.implement;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import mk.ukim.finki.wp.lab.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImplementation implements AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumServiceImplementation(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAll(){
        return albumRepository.findAll();
    }

    @Override
    public Optional<Album> findId(Long id)
    {
        return albumRepository.findAlbumId(id);
    }

}
