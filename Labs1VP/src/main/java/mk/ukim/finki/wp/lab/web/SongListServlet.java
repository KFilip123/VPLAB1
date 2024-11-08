package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.implement.SongServiceImplementation;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebApplication;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

public class SongListServlet {
    @WebServlet(name = "SongServlet", urlPatterns = {"/listSongs"})
    public static class SongServlet extends HttpServlet {
        private final SpringTemplateEngine templateEngine;
        private final SongServiceImplementation songService;

        public SongServlet(SpringTemplateEngine templateEngine, SongServiceImplementation songService) {
            this.templateEngine = templateEngine;
            this.songService = songService;
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            List<Song> songs;
            songs = songService.listSongs();

            IWebExchange webExchange = JakartaServletWebApplication.buildApplication(request.getServletContext()).buildExchange(request, response);
            WebContext webContext = new WebContext(webExchange);
            webContext.setVariable("songs", songs);
            templateEngine.process("listSongs.html", webContext, response.getWriter());
        }

        @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String trackId = req.getParameter("trackId");
            req.getSession().setAttribute("trackId", trackId);
            resp.sendRedirect("/artist");
        }

    }
}
