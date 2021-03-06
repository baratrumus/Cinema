package cinema.servlets;

import cinema.models.Order;
import cinema.models.Seat;
import cinema.service.CinemaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author Ivannikov Ilya (voldores@mail.ru)
 * @version $id
 * @since 0.1
 */

public class HallServlet extends HttpServlet {

    private final CinemaService storage = CinemaService.getInstance();

    /**
     * Загружает по ajax запросу схему зрительного зала
     * первый вход на страницу, заход в get идет не через ajax и first = null
     * так что делаем редирект, чтобы логика ajax отработалась
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/WEB-INF/views/hall.jsp").forward(req, resp);
    }

    /**
     * Подгружает через ajax список купленных мест
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ArrayList<Seat> listOfSeats = new ArrayList<>();
        for (Order order : storage.getOrders()) {
            listOfSeats.add(new Seat(order.getRow(), order.getColumn()));
        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pr = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(listOfSeats);
        pr.write(jsonInString);
        pr.flush();
    }
}