package cinema.servlets;

import cinema.models.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Ivannikov Ilya (voldores@mail.ru)
 * @version $id
 * @since 0.1
 */

public class OrderServlet extends HttpServlet {

    private final CinemaController storage = CinemaController.getInstance();
    private static final Logger LOG = LoggerFactory.getLogger(OrderServlet.class);

    /**
     * Метод выводит инфо строку пользователю о выбранном месте через ajax function loadInfo()
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String place = req.getParameter("place");
        // 1-й заход в get.  Делаем редирект
        if (place != null) {
            session.setAttribute("place", place);
            session.setAttribute("orderInfo", "");
            req.getRequestDispatcher("/WEB-INF/views/pay.jsp").forward(req, resp);
        // 2-й заход в get.  Здесь можно записать инфо string для пользователя в responce
        } else {
            place =  session.getAttribute("place").toString();
            String info = session.getAttribute("orderInfo").toString();
            resp.setContentType("text/json");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter pr = resp.getWriter();
            StringBuilder sb = new StringBuilder();
            sb.append("You have chosen row ");
            sb.append(place.charAt(0));
            sb.append(" seat ");
            sb.append(place.charAt(1));
            sb.append(", Sum : 10$");
            sb.append(". " + info);
            LOG.info(sb.toString());
            pr.append(new ObjectMapper().writeValueAsString(sb));
            pr.flush();
        }
    }

    /**
     * Call from js function makeOrder()
     * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        boolean busy = false;
        String place = session.getAttribute("place").toString();
        if (place != null) {
            if (!storage.getOrders().isEmpty()) {
                for (Order ord : storage.getOrders()) {
                    if ((String.valueOf(place.charAt(1))).equals(ord.getColumn()) & (String.valueOf(place.charAt(0))).equals(ord.getRow())) {
                        String error = "Place is buzy, please select another place!";
                        LOG.info(error);
                        session.setAttribute("orderInfo", error);
                        busy = true;
                        break;
                    }
                }
            }
            if (!busy) {
                resp.setCharacterEncoding("UTF-8");
                String fullName = req.getParameter("fullName");
                String phone = req.getParameter("phone");
                Order order = new Order(fullName, phone);
                order.setColumn(String.valueOf(place.charAt(1)));
                order.setRow(String.valueOf(place.charAt(0)));
                storage.addOrder(order);
                String message = fullName + ", Your ticket has approved!";
                session.setAttribute("orderInfo", message);
                LOG.info(message);
            }
            resp.sendRedirect(String.format("%s/", req.getContextPath()));
            //req.getRequestDispatcher("/WEB-INF/views/hall.jsp").forward(req, resp);
        }
    }


}