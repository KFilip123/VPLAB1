package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.SongService;
import mk.ukim.finki.wp.lab.service.implement.ArtistServiceImplementation;
import mk.ukim.finki.wp.lab.service.implement.SongServiceImplementation;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

public class ArtistServlet {
    @WebServlet(name = "ArtistServlet", urlPatterns = {"/artist"})
    public static class ArtistListServlet extends HttpServlet {
        private final SpringTemplateEngine templateEngine;
        private final ArtistServiceImplementation artistService;

        public ArtistListServlet(final SpringTemplateEngine templateEngine, final ArtistServiceImplementation artistService) {
            this.templateEngine = templateEngine;
            this.artistService = artistService;
        }

        @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
            String artistIdString = req.getParameter("artistId");
            String trackId = (String) req.getSession().getAttribute("trackId");

            if (artistIdString != null && trackId != null){
                Long artistId = Long.parseLong(artistIdString);

                Artist artist = artistService.findById(artistId);
                Song song = SongService

                if (artist != null && song != null){
                    SongService.addArtistToSong(artist, song);
                    req.getSession().setAttribute("selectedSong", song);
                }
            }
            resp.sendRedirect("/songDetails");
        }

}
