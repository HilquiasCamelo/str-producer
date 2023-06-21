package com.hilquiascamelo.strproducer.controller.impl;

import com.hilquiascamelo.strproducer.model.OrderItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration ( classes = {OrderItemControllerImpl.class})
@ExtendWith ( SpringExtension.class)
class OrderItemControllerImplTest {
    @Autowired
    private OrderItemControllerImpl orderItemControllerImpl;

    /**
     * Method under test: {@link OrderItemControllerImpl#sendOrderItem(OrderItem)}
     */
    @Test
    void testSendOrderItem ( ) throws Exception
        {
            MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post( "/orders/item/create/" );
            ResultActions
                    actualPerformResult =
                    MockMvcBuilders.standaloneSetup( orderItemControllerImpl )
                            .build( )
                            .perform( requestBuilder );
            actualPerformResult.andExpect( MockMvcResultMatchers.status( )
                    .is( 400 ) );
        }
}

