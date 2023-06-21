package com.hilquiascamelo.strproducer.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hilquiascamelo.strproducer.model.Product;
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
import java.util.HashMap;

import static org.mockito.Mockito.doNothing;

@ContextConfiguration ( classes = {ProductControllerImpl.class})
@ExtendWith ( SpringExtension.class)
class ProductControllerImplTest {
    @MockBean
    private ObjectSendProducer objectSendProducer;

    @Autowired
    private ProductControllerImpl productControllerImpl;


    @Test
    void testCreateProduct ( ) throws Exception
        {
            doNothing( ).when( objectSendProducer )
                    .send( Mockito. < Object >any( ) );

            Product product = new Product( );
            product.setAvailable( true );
            product.setCategories( new ArrayList <>( ) );
            product.setDescription( "The characteristics of someone or something" );
            product.setFeatures( new HashMap <>( ) );
            product.setId( 1 );
            product.setManufacturer( "Manufacturer" );
            product.setName( "Name" );
            product.setPrice( 10.0d );
            product.setStock( 1 );
            String content = (new ObjectMapper( )).writeValueAsString( product );
            MockHttpServletRequestBuilder
                    requestBuilder =
                    MockMvcRequestBuilders.get( "/products/create" )
                            .contentType( MediaType.APPLICATION_JSON )
                            .content( content );
            ResultActions
                    actualPerformResult =
                    MockMvcBuilders.standaloneSetup( productControllerImpl )
                            .build( )
                            .perform( requestBuilder );
            actualPerformResult.andExpect( MockMvcResultMatchers.status( )
                            .isCreated( ) )
                    .andExpect( MockMvcResultMatchers.content( )
                            .contentType( "application/json" ) )
                    .andExpect( MockMvcResultMatchers.content( )
                            .string(
                                    "{\"id\":1,\"name\":\"Name\",\"price\":10.0,\"manufacturer\":\"Manufacturer\",\"description\":\"The characteristics" +
                                    " of someone or something\",\"stock\":1,\"categories\":[],\"available\":true,\"features\":{}}" ) );
        }
}

