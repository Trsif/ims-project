package com.qa.ims.persistence.domain;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class OrderTest {
	@Test
	
	public void testEquals() {
		EqualsVerifier.simple().forClass(OrderItem.class).verify();
	}
}
