package com.hilquiascamelo.strproducer.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hilquiascamelo.strproducer.model.ObjectTextModel;
import com.hilquiascamelo.strproducer.services.ObjectSendProducer;
import com.hilquiascamelo.strproducer.util.MessageResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ContextConfiguration ( classes = {StringProducerControllerImpl.class})
@ExtendWith ( SpringExtension.class)
class StringProducerControllerImplTest {
    @MockBean
    private ObjectSendProducer objectSendProducer;

    @Autowired
    private StringProducerControllerImpl stringProducerControllerImpl;


    @Test
    void testSendMessage ( )
        {

            ObjectSendProducer objectSendProducer = mock( ObjectSendProducer.class );
            doNothing( ).when( objectSendProducer )
                    .send( Mockito. < Object >any( ) );
            ResponseEntity < MessageResponse >
                    actualSendMessageResult =
                    (new StringProducerControllerImpl( objectSendProducer )).sendMessage(
                            "Not all who wander are lost" );
            assertTrue( actualSendMessageResult.hasBody( ) );
            assertTrue( actualSendMessageResult.getHeaders( )
                    .isEmpty( ) );
            assertEquals( HttpStatus.CREATED , actualSendMessageResult.getStatusCode( ) );
            MessageResponse body = actualSendMessageResult.getBody( );
            assertEquals( "201 CREATED" , body.getStatus( ) );
            assertEquals( "Mensagem enviada com sucesso!" , body.getMessage( ) );
            verify( objectSendProducer ).send( Mockito. < Object >any( ) );
        }

    @Test
    void testSend ( ) throws Exception
        {
            doNothing( ).when( objectSendProducer )
                    .send( Mockito. < Object >any( ) );

            ObjectTextModel objectTextModel = new ObjectTextModel( );
            objectTextModel.setAddress( "42 Main St" );
            objectTextModel.setAge( 1 );
            objectTextModel.setName( "Name" );
            objectTextModel.setOccupation( "Occupation" );
            String content = (new ObjectMapper( )).writeValueAsString( objectTextModel );
            MockHttpServletRequestBuilder
                    requestBuilder =
                    MockMvcRequestBuilders.post( "/object" )
                            .contentType( MediaType.APPLICATION_JSON )
                            .content( content );
            ResultActions
                    actualPerformResult =
                    MockMvcBuilders.standaloneSetup( stringProducerControllerImpl )
                            .build( )
                            .perform( requestBuilder );
            actualPerformResult.andExpect( MockMvcResultMatchers.status( )
                            .isCreated( ) )
                    .andExpect( MockMvcResultMatchers.content( )
                            .contentType( "application/json" ) )
                    .andExpect( MockMvcResultMatchers.content( )
                            .string(
                                    "{\"name\":\"Name\",\"age\":1,\"occupation\":\"Occupation\",\"address\":\"42 Main St\"}" ) );
        }
}

