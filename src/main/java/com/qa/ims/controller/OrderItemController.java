package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

public class OrderItemController implements CrudController<OrderItem>  {
	public static final Logger LOGGER = LogManager.getLogger();
	private OrderItemDAO orderItemDAO;
	private Utils utils;
	
	public OrderItemController(OrderItemDAO orderItemDAO, Utils utils) {
		super();
		this.orderItemDAO = orderItemDAO;
		this.utils = utils;
	}
	
	@Override
	public List<OrderItem> readAll() {
		
		return null;
	}

	@Override
	public OrderItem create() {
		LOGGER.info("Please enter order id");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter item id");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter the amout to order");
		Long qty = utils.getLong();
		OrderItem orderItem = orderItemDAO.create(new OrderItem(orderId,itemId,qty));
		return orderItem;
	}

	@Override
	public OrderItem update() {
		LOGGER.info("Please enter order id");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter item id");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter the amout to order");
		Long qty = utils.getLong();
		LOGGER.info("Please enter the amout to order");
		Long id = utils.getLong();
		OrderItem orderItem = orderItemDAO.update(new OrderItem(orderId,itemId,qty,id));
		return orderItem;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = utils.getLong();
		return orderItemDAO.delete(id);
	}
	
}
