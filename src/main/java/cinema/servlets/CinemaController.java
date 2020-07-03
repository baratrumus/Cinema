package cinema.servlets;

import cinema.data.CinemaDB;
import cinema.data.Db;
import cinema.models.Order;
import java.util.List;

/**
 * @author Ivannikov Ilya (voldores@mail.ru)
 * @version $id
 * @since 0.1
 */

public class CinemaController implements Controller {

    private static final CinemaController INSTANCE = new CinemaController();
    private static final Db STORAGE = CinemaDB.getInstance();

    private CinemaController() {
    }

    public static CinemaController getInstance() {
        return INSTANCE;
    }


    @Override
    public boolean addOrder(Order order) {
        STORAGE.addOrder(order);
        return true;
    }

    @Override
    public List<Order> getOrders() {
        return STORAGE.getOrders();
    }
}
