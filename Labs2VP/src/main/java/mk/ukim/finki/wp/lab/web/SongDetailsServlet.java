package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Song;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "SongDetailsServlet", urlPatterns = "/songDetails")
public class SongDetailsServlet extends HttpServlet {
    private final SpringTemplateEngine templateEngine;

    public SongDetailsServlet(SpringTemplateEngine springTemplateEngine) {
        this.templateEngine = springTemplateEngine;
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        Song song = (Song)req.getSession().getAttribute("selectedSong");

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        context.setVariable("song", song);

        if (song != null){
            templateEngine.process("songDetails.html", context, resp.getWriter());
        }
    }
}