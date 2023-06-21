package com.hilquiascamelo.strproducer.controller.impl;

import com.hilquiascamelo.strproducer.model.Address;
import com.hilquiascamelo.strproducer.model.Customer;
import com.hilquiascamelo.strproducer.model.OrderEntity;
import com.hilquiascamelo.strproducer.services.ObjectSendProducer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class OrderControllerImplTest {
    /**
     * Method under test: {@link OrderControllerImpl#sendOrder(OrderEntity)}
     */
    @Test
    void testSendOrder ( )
        {
                      ObjectSendProducer objectSendProducer = mock( ObjectSendProducer.class );
            doNothing( ).when( objectSendProducer )
                    .send( Mockito. < Object >any( ) );
            OrderControllerImpl orderControllerImpl = new OrderControllerImpl( objectSendProducer );

            Address address = new Address( );
            address.setCity( "Oxford" );
            address.setId( 1L );
            address.setState( "MD" );
            address.setStreet( "Street" );
            address.setZipCode( "21654" );

            Customer customer = new Customer( );
            customer.setAddress( address );
            customer.setAge( 1 );
            customer.setEmail( "jane.doe@example.org" );
            customer.setId( 1 );
            customer.setName( "Name" );
            customer.setOrders( new ArrayList <>( ) );
            customer.setPhone( "6625550144" );

            OrderEntity order = new OrderEntity( );
            order.setCustomer( customer );
            order.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            order.setId( "42" );
            order.setItems( new ArrayList <>( ) );
            order.setStatus( "Status" );
            order.setTotal( 10.0d );
            ResponseEntity < OrderEntity > actualSendOrderResult = orderControllerImpl.sendOrder( order );
            assertTrue( actualSendOrderResult.hasBody( ) );
            assertTrue( actualSendOrderResult.getHeaders( )
                    .isEmpty( ) );
            assertEquals( HttpStatus.CREATED , actualSendOrderResult.getStatusCode( ) );
            verify( objectSendProducer ).send( Mockito. < Object >any( ) );
        }
}

