package com.qa.ims.persistence.domain;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemOrderTest {
	@Test
	
	public void testEquals() {
		EqualsVerifier.simple().forClass(ItemOrderTest.class).verify();
	}
}
