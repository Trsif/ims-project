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

import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderItemDAO implements Dao<OrderItem> {
	public static final Logger LOGGER = LogManager.getLogger();
	@Override
	public List<OrderItem> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders_items");){
			List<OrderItem> orderItems = new ArrayList<>();
			while(resultSet.next()) {
				orderItems.add(modelFromResultSet(resultSet));
			}
			return orderItems;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
 	}

	@Override
	public OrderItem read(Long id) {
		try(Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM orders_items WHERE id = ?");){
			statement.setLong(1, id);
				try(ResultSet resultSet = statement.executeQuery();){
					resultSet.next();
					return modelFromResultSet(resultSet);
				}
		} catch(Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
				
		return null;
	}

	@Override
	public OrderItem create(OrderItem orderItem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders_items(order_id,item_id,qty) VALUE(?,?,?)");) {
			statement.setLong(1, orderItem.getOrderId());
			statement.setLong(2, orderItem.getItemId());
			statement.setLong(3, orderItem.getQty());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	private OrderItem readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders_items ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public OrderItem update(OrderItem orderItem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orders_items SET order_id = ? , item_id = ? , qty = ?  WHERE id = ?");) {
			statement.setLong(1, orderItem.getOrderId());
			statement.setLong(2, orderItem.getItemId());
			statement.setLong(3, orderItem.getQty());
			statement.setLong(4, orderItem.getId());
			statement.executeUpdate();
			return read(orderItem.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders_items WHERE id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}		
		return 0;
	}

	@Override
	public OrderItem modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		Long orderId = resultSet.getLong("order_id");
		Long itemId = resultSet.getLong("item_id");
		Long qty = resultSet.getLong("qty");
		return new OrderItem(id,orderId,itemId,qty);
	}

}
