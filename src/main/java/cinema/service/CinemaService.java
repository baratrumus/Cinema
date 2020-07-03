package cinema.service;

import cinema.data.CinemaDB;
import cinema.data.Db;
import cinema.models.Order;
import java.util.List;

/**
 * @author Ivannikov Ilya (voldores@mail.ru)
 * @version $id
 * @since 0.1
 */

public class CinemaService implements Service {

    private static final CinemaService INSTANCE = new CinemaService();
    private static final Db STORAGE = CinemaDB.getInstance();

    private CinemaService() {
    }

    public static CinemaService getInstance() {
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
