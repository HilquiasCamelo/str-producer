package com.hilquiascamelo.strproducer.controller.impl;

import com.hilquiascamelo.strproducer.services.AddressService;
import com.hilquiascamelo.strproducer.services.ObjectSendProducer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ContextConfiguration ( classes = {AddressControllerImpl.class})
@ExtendWith ( SpringExtension.class)
class AddressControllerImplTest {
    @Autowired
    private AddressControllerImpl addressControllerImpl;

    @MockBean
    private AddressService addressService;

    @MockBean
    private ObjectSendProducer objectSendProducer;


    @Test
    void testFindAll ( ) throws Exception
        {
            when( addressService.findAll( ) ).thenReturn( new ArrayList <>( ) );
            MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get( "/address/all" );
            MockMvcBuilders.standaloneSetup( addressControllerImpl )
                    .build( )
                    .perform( requestBuilder )
                    .andExpect( MockMvcResultMatchers.status( )
                            .isOk( ) )
                    .andExpect( MockMvcResultMatchers.content( )
                            .contentType( "application/json" ) )
                    .andExpect( MockMvcResultMatchers.content( )
                            .string( "[]" ) );
        }


    @Test
    void testFindAll2 ( ) throws Exception
        {
            when( addressService.findAll( ) ).thenReturn( new ArrayList <>( ) );
            MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get( "/address/all" );
            requestBuilder.characterEncoding( "Encoding" );
            MockMvcBuilders.standaloneSetup( addressControllerImpl )
                    .build( )
                    .perform( requestBuilder )
                    .andExpect( MockMvcResultMatchers.status( )
                            .isOk( ) )
                    .andExpect( MockMvcResultMatchers.content( )
                            .contentType( "application/json" ) )
                    .andExpect( MockMvcResultMatchers.content( )
                            .string( "[]" ) );
        }
}

