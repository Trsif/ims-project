package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	private final OrderDAO DAO = new OrderDAO();
	java.util.Date utilDate = new java.util.Date();
	@SuppressWarnings("deprecation")
	java.sql.Timestamp date = new java.sql.Timestamp(utilDate.getDate());
	@Before
	
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	@Test 
	public void testCreate() {
		final Order created = new Order(1L,1L,date);
		assertEquals(created, DAO.create(created));
	}
	@Test
	public void testReadALL() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L));
		assertEquals(expected,DAO.readAll());
	}
	@Test 
	public void testReadLases() {
		assertEquals(new Order(1l,1l,date), DAO.readLatest());
	}
	@Test
	public void testRead() {
		final long ID = 1l;
		assertEquals(new Order(ID,1l,date), DAO.read(ID));
	}
	public void testUpdate() {
		final Order updated = new Order(1L);
		assertEquals(updated,DAO.update(updated));
	}
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}

