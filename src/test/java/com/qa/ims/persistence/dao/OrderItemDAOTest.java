package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderItemDAOTest {
	private final OrderItemDAO DAO = new OrderItemDAO();
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	@Test 
	public void testCreate() {
		final OrderItem created = new OrderItem(1l,1l,20l);
		assertEquals(created, DAO.create(created));
	}
	@Test
	public void testReadALL() {
		List<OrderItem> expected = new ArrayList<>();
		expected.add(new OrderItem(2l,2l,12l));
		assertEquals(expected, DAO.readAll());
	}
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new OrderItem(ID,1l,3L),DAO.read(ID));
	}
	public void testUpdate() {
		final OrderItem updated = new OrderItem(1l,1l,30l);
		assertEquals(updated, DAO.update(updated));
	}
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
