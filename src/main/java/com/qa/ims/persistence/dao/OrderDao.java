package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DatabaseUtilities;

public class OrderDao implements IDomainDao<Order> {
	
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Order create(Order order) {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("INSERT INTO orders(order_value) VALUES (?)");) {
            statement.setDouble(1, order.getorderValue());
            statement.executeUpdate();
            return readLatest();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    public Order read(Long id) {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE id = ?");) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Order> readAll() {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
            }
			return orders;
        } catch (SQLException e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    public Order readLatest() {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY id DESC LIMIT 1");) {
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Order update(Order order) {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("UPDATE orders SET order_value = ? WHERE id = ?");) {
            statement.setDouble(1, order.getorderValue());
            statement.setLong(3, order.getId());
            statement.executeUpdate();
            return read(order.getId());
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public int delete(long id) {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                Statement statement = connection.createStatement();) {
            return statement.executeUpdate("delete from orders where id = " + id);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return 0;
    }

    @Override
    public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
        Double orderValue = resultSet.getDouble("order_value");
        return new Order(orderValue);
	}

}

