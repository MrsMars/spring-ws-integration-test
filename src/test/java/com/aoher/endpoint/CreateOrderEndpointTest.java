package com.aoher.endpoint;

import com.aoher.types.order.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateOrderEndpointTest {

    private CreateOrderEndpoint createOrderEndpoint = new CreateOrderEndpoint();

    private Order order;

    @Before
    public void setUp() {
        ObjectFactory factory = new ObjectFactory();

        CustomerType customer = factory.createCustomerType();
        customer.setFirstName("John");
        customer.setLastName("Doe");

        ProductType product1 = factory.createProductType();
        product1.setId("1");
        product1.setName("batman action figure");

        LineItemType lineItem1 = factory.createLineItemType();
        lineItem1.setProduct(product1);
        lineItem1.setQuantity(BigInteger.valueOf(1));

        LineItemsType lineItems = factory.createLineItemsType();
        lineItems.getLineItem().add(lineItem1);

        order = factory.createOrder();
        order.setCustomer(customer);
        order.setLineItems(lineItems);
    }

    @Test
    public void testCreateOrder() {
        assertThat(createOrderEndpoint.createOne(order).getConfirmationId()).isNotBlank();
    }
}