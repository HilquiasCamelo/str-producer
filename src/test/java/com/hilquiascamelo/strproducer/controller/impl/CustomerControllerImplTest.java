package com.hilquiascamelo.strproducer.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hilquiascamelo.strproducer.model.Address;
import com.hilquiascamelo.strproducer.model.Customer;
import com.hilquiascamelo.strproducer.services.ObjectSendProducer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.doNothing;

@ContextConfiguration ( classes = {CustomerControllerImpl.class})
@ExtendWith ( SpringExtension.class)
class CustomerControllerImplTest {
    @Autowired
    private CustomerControllerImpl customerControllerImpl;

    @MockBean
    private ObjectSendProducer objectSendProducer;


    @Test
    void testCreateCustomer ( ) throws Exception
        {
            doNothing( ).when( objectSendProducer )
                    .send( Mockito. < Object >any( ) );

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
            String content = (new ObjectMapper( )).writeValueAsString( customer );
            MockHttpServletRequestBuilder
                    requestBuilder =
                    MockMvcRequestBuilders.get( "/customers/create" )
                            .contentType( MediaType.APPLICATION_JSON )
                            .content( content );
            ResultActions
                    actualPerformResult =
                    MockMvcBuilders.standaloneSetup( customerControllerImpl )
                            .build( )
                            .perform( requestBuilder );
            actualPerformResult.andExpect( MockMvcResultMatchers.status( )
                            .isCreated( ) )
                    .andExpect( MockMvcResultMatchers.content( )
                            .contentType( "application/json" ) )
                    .andExpect( MockMvcResultMatchers.content( )
                            .string(
                                    "{\"id\":1,\"name\":\"Name\",\"age\":1,\"email\":\"jane.doe@example.org\",\"phone\":\"6625550144\",\"address\":{\"id\":1," +
                                    "\"street\":\"Street\",\"city\":\"Oxford\",\"state\":\"MD\",\"zipCode\":\"21654\"},\"orders\":[]}" ) );
        }
}

