package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	public static final Logger LOGGER = LogManager.getLogger();
	private OrderDAO orderDAO;
	private Utils utils;
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for(Order order: orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter customer id");
		Long customerId = utils.getLong();
		Order order = orderDAO.create(new Order(customerId));
		LOGGER.info("Order Created");
		return order;
	}

	@Override
	public Order update() {
		java.util.Date utilDate = new java.util.Date();
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter customer id");
		Long customerId = utils.getLong();
		@SuppressWarnings("deprecation")
		java.sql.Timestamp date = new java.sql.Timestamp(utilDate.getDate());
		Order order = orderDAO.update(new Order(id,customerId,date));
		LOGGER.info("item Updated");
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}

}
