package com.hilquiascamelo.strproducer.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OrderItemTest {
    /**
     * Method under test: {@link OrderItem#canEqual(Object)}
     */
    @Test
    void testCanEqual ( )
        {
            assertFalse( (new OrderItem( )).canEqual( "Other" ) );
        }

    /**
     * Method under test: {@link OrderItem#canEqual(Object)}
     */
    @Test
    void testCanEqual2 ( )
        {
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

            OrderItem orderItem = new OrderItem( );
            orderItem.setId( 1L );
            orderItem.setOrder( order );
            orderItem.setPrice( 10.0d );
            orderItem.setProductId( "42" );
            orderItem.setProductName( "Product Name" );
            orderItem.setQuantity( 1 );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );

            Customer customer2 = new Customer( );
            customer2.setAddress( address2 );
            customer2.setAge( 1 );
            customer2.setEmail( "jane.doe@example.org" );
            customer2.setId( 1 );
            customer2.setName( "Name" );
            customer2.setOrders( new ArrayList <>( ) );
            customer2.setPhone( "6625550144" );

            OrderEntity order2 = new OrderEntity( );
            order2.setCustomer( customer2 );
            order2.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            order2.setId( "42" );
            order2.setItems( new ArrayList <>( ) );
            order2.setStatus( "Status" );
            order2.setTotal( 10.0d );

            OrderItem orderItem2 = new OrderItem( );
            orderItem2.setId( 1L );
            orderItem2.setOrder( order2 );
            orderItem2.setPrice( 10.0d );
            orderItem2.setProductId( "42" );
            orderItem2.setProductName( "Product Name" );
            orderItem2.setQuantity( 1 );
            assertTrue( orderItem.canEqual( orderItem2 ) );
        }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link OrderItem}
     *   <li>{@link OrderItem#setId(Long)}
     *   <li>{@link OrderItem#setOrder(OrderEntity)}
     *   <li>{@link OrderItem#setPrice(double)}
     *   <li>{@link OrderItem#setProductId(String)}
     *   <li>{@link OrderItem#setProductName(String)}
     *   <li>{@link OrderItem#setQuantity(int)}
     *   <li>{@link OrderItem#toString()}
     *   <li>{@link OrderItem#getId()}
     *   <li>{@link OrderItem#getOrder()}
     *   <li>{@link OrderItem#getPrice()}
     *   <li>{@link OrderItem#getProductId()}
     *   <li>{@link OrderItem#getProductName()}
     *   <li>{@link OrderItem#getQuantity()}
     * </ul>
     */
    @Test
    void testConstructor ( )
        {
            OrderItem actualOrderItem = new OrderItem( );
            actualOrderItem.setId( 1L );
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
            actualOrderItem.setOrder( order );
            actualOrderItem.setPrice( 10.0d );
            actualOrderItem.setProductId( "42" );
            actualOrderItem.setProductName( "Product Name" );
            actualOrderItem.setQuantity( 1 );
            String actualToStringResult = actualOrderItem.toString( );
            assertEquals( 1L , actualOrderItem.getId( )
                    .longValue( ) );
            assertSame( order , actualOrderItem.getOrder( ) );
            assertEquals( 10.0d , actualOrderItem.getPrice( ) );
            assertEquals( "42" , actualOrderItem.getProductId( ) );
            assertEquals( "Product Name" , actualOrderItem.getProductName( ) );
            assertEquals( 1 , actualOrderItem.getQuantity( ) );
            assertEquals(
                    "OrderItem(id=1, productId=42, productName=Product Name, quantity=1, price=10.0, order=OrderEntity(id=42," +
                    " date=1970-01-01T00:00, customer=Customer(id=1, name=Name, age=1, email=jane.doe@example.org," +
                    " phone=6625550144, address=Address(id=1, street=Street, city=Oxford, state=MD, zipCode=21654), orders=[])," +
                    " items=[], total=10.0, status=Status))" , actualToStringResult );
        }

    /**
     * Method under test: {@link OrderItem#equals(Object)}
     */
    @Test
    void testEquals ( )
        {
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

            OrderItem orderItem = new OrderItem( );
            orderItem.setId( 1L );
            orderItem.setOrder( order );
            orderItem.setPrice( 10.0d );
            orderItem.setProductId( "42" );
            orderItem.setProductName( "Product Name" );
            orderItem.setQuantity( 1 );
            assertNotEquals( orderItem , null );
        }

    /**
     * Method under test: {@link OrderItem#equals(Object)}
     */
    @Test
    void testEquals2 ( )
        {
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

            OrderItem orderItem = new OrderItem( );
            orderItem.setId( 1L );
            orderItem.setOrder( order );
            orderItem.setPrice( 10.0d );
            orderItem.setProductId( "42" );
            orderItem.setProductName( "Product Name" );
            orderItem.setQuantity( 1 );
            assertNotEquals( orderItem , "Different type to OrderItem" );
        }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link OrderItem#equals(Object)}
     *   <li>{@link OrderItem#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3 ( )
        {
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

            OrderItem orderItem = new OrderItem( );
            orderItem.setId( 1L );
            orderItem.setOrder( order );
            orderItem.setPrice( 10.0d );
            orderItem.setProductId( "42" );
            orderItem.setProductName( "Product Name" );
            orderItem.setQuantity( 1 );
            assertEquals( orderItem , orderItem );
            int expectedHashCodeResult = orderItem.hashCode( );
            assertEquals( expectedHashCodeResult , orderItem.hashCode( ) );
        }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link OrderItem#equals(Object)}
     *   <li>{@link OrderItem#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4 ( )
        {
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

            OrderItem orderItem = new OrderItem( );
            orderItem.setId( 1L );
            orderItem.setOrder( order );
            orderItem.setPrice( 10.0d );
            orderItem.setProductId( "42" );
            orderItem.setProductName( "Product Name" );
            orderItem.setQuantity( 1 );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );

            Customer customer2 = new Customer( );
            customer2.setAddress( address2 );
            customer2.setAge( 1 );
            customer2.setEmail( "jane.doe@example.org" );
            customer2.setId( 1 );
            customer2.setName( "Name" );
            customer2.setOrders( new ArrayList <>( ) );
            customer2.setPhone( "6625550144" );

            OrderEntity order2 = new OrderEntity( );
            order2.setCustomer( customer2 );
            order2.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            order2.setId( "42" );
            order2.setItems( new ArrayList <>( ) );
            order2.setStatus( "Status" );
            order2.setTotal( 10.0d );

            OrderItem orderItem2 = new OrderItem( );
            orderItem2.setId( 1L );
            orderItem2.setOrder( order2 );
            orderItem2.setPrice( 10.0d );
            orderItem2.setProductId( "42" );
            orderItem2.setProductName( "Product Name" );
            orderItem2.setQuantity( 1 );
            assertEquals( orderItem , orderItem2 );
            int expectedHashCodeResult = orderItem.hashCode( );
            assertEquals( expectedHashCodeResult , orderItem2.hashCode( ) );
        }

    /**
     * Method under test: {@link OrderItem#equals(Object)}
     */
    @Test
    void testEquals5 ( )
        {
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

            OrderItem orderItem = new OrderItem( );
            orderItem.setId( 2L );
            orderItem.setOrder( order );
            orderItem.setPrice( 10.0d );
            orderItem.setProductId( "42" );
            orderItem.setProductName( "Product Name" );
            orderItem.setQuantity( 1 );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );

            Customer customer2 = new Customer( );
            customer2.setAddress( address2 );
            customer2.setAge( 1 );
            customer2.setEmail( "jane.doe@example.org" );
            customer2.setId( 1 );
            customer2.setName( "Name" );
            customer2.setOrders( new ArrayList <>( ) );
            customer2.setPhone( "6625550144" );

            OrderEntity order2 = new OrderEntity( );
            order2.setCustomer( customer2 );
            order2.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            order2.setId( "42" );
            order2.setItems( new ArrayList <>( ) );
            order2.setStatus( "Status" );
            order2.setTotal( 10.0d );

            OrderItem orderItem2 = new OrderItem( );
            orderItem2.setId( 1L );
            orderItem2.setOrder( order2 );
            orderItem2.setPrice( 10.0d );
            orderItem2.setProductId( "42" );
            orderItem2.setProductName( "Product Name" );
            orderItem2.setQuantity( 1 );
            assertNotEquals( orderItem , orderItem2 );
        }

    /**
     * Method under test: {@link OrderItem#equals(Object)}
     */
    @Test
    void testEquals6 ( )
        {
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

            OrderItem orderItem = new OrderItem( );
            orderItem.setId( null );
            orderItem.setOrder( order );
            orderItem.setPrice( 10.0d );
            orderItem.setProductId( "42" );
            orderItem.setProductName( "Product Name" );
            orderItem.setQuantity( 1 );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );

            Customer customer2 = new Customer( );
            customer2.setAddress( address2 );
            customer2.setAge( 1 );
            customer2.setEmail( "jane.doe@example.org" );
            customer2.setId( 1 );
            customer2.setName( "Name" );
            customer2.setOrders( new ArrayList <>( ) );
            customer2.setPhone( "6625550144" );

            OrderEntity order2 = new OrderEntity( );
            order2.setCustomer( customer2 );
            order2.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            order2.setId( "42" );
            order2.setItems( new ArrayList <>( ) );
            order2.setStatus( "Status" );
            order2.setTotal( 10.0d );

            OrderItem orderItem2 = new OrderItem( );
            orderItem2.setId( 1L );
            orderItem2.setOrder( order2 );
            orderItem2.setPrice( 10.0d );
            orderItem2.setProductId( "42" );
            orderItem2.setProductName( "Product Name" );
            orderItem2.setQuantity( 1 );
            assertNotEquals( orderItem , orderItem2 );
        }

    /**
     * Method under test: {@link OrderItem#equals(Object)}
     */
    @Test
    void testEquals7 ( )
        {
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
            OrderEntity order = mock( OrderEntity.class );
            doNothing( ).when( order )
                    .setCustomer( Mockito. < Customer >any( ) );
            doNothing( ).when( order )
                    .setDate( Mockito. < LocalDateTime >any( ) );
            doNothing( ).when( order )
                    .setId( Mockito. < String >any( ) );
            doNothing( ).when( order )
                    .setItems( Mockito. < List < OrderItem > >any( ) );
            doNothing( ).when( order )
                    .setStatus( Mockito. < String >any( ) );
            doNothing( ).when( order )
                    .setTotal( anyDouble( ) );
            order.setCustomer( customer );
            order.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            order.setId( "42" );
            order.setItems( new ArrayList <>( ) );
            order.setStatus( "Status" );
            order.setTotal( 10.0d );

            OrderItem orderItem = new OrderItem( );
            orderItem.setId( 1L );
            orderItem.setOrder( order );
            orderItem.setPrice( 10.0d );
            orderItem.setProductId( "42" );
            orderItem.setProductName( "Product Name" );
            orderItem.setQuantity( 1 );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );

            Customer customer2 = new Customer( );
            customer2.setAddress( address2 );
            customer2.setAge( 1 );
            customer2.setEmail( "jane.doe@example.org" );
            customer2.setId( 1 );
            customer2.setName( "Name" );
            customer2.setOrders( new ArrayList <>( ) );
            customer2.setPhone( "6625550144" );

            OrderEntity order2 = new OrderEntity( );
            order2.setCustomer( customer2 );
            order2.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            order2.setId( "42" );
            order2.setItems( new ArrayList <>( ) );
            order2.setStatus( "Status" );
            order2.setTotal( 10.0d );

            OrderItem orderItem2 = new OrderItem( );
            orderItem2.setId( 1L );
            orderItem2.setOrder( order2 );
            orderItem2.setPrice( 10.0d );
            orderItem2.setProductId( "42" );
            orderItem2.setProductName( "Product Name" );
            orderItem2.setQuantity( 1 );
            assertNotEquals( orderItem , orderItem2 );
        }

    /**
     * Method under test: {@link OrderItem#equals(Object)}
     */
    @Test
    void testEquals8 ( )
        {
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
            OrderEntity order = mock( OrderEntity.class );
            doNothing( ).when( order )
                    .setCustomer( Mockito. < Customer >any( ) );
            doNothing( ).when( order )
                    .setDate( Mockito. < LocalDateTime >any( ) );
            doNothing( ).when( order )
                    .setId( Mockito. < String >any( ) );
            doNothing( ).when( order )
                    .setItems( Mockito. < List < OrderItem > >any( ) );
            doNothing( ).when( order )
                    .setStatus( Mockito. < String >any( ) );
            doNothing( ).when( order )
                    .setTotal( anyDouble( ) );
            order.setCustomer( customer );
            order.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            order.setId( "42" );
            order.setItems( new ArrayList <>( ) );
            order.setStatus( "Status" );
            order.setTotal( 10.0d );

            OrderItem orderItem = new OrderItem( );
            orderItem.setId( 1L );
            orderItem.setOrder( order );
            orderItem.setPrice( 0.5d );
            orderItem.setProductId( "42" );
            orderItem.setProductName( "Product Name" );
            orderItem.setQuantity( 1 );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );

            Customer customer2 = new Customer( );
            customer2.setAddress( address2 );
            customer2.setAge( 1 );
            customer2.setEmail( "jane.doe@example.org" );
            customer2.setId( 1 );
            customer2.setName( "Name" );
            customer2.setOrders( new ArrayList <>( ) );
            customer2.setPhone( "6625550144" );

            OrderEntity order2 = new OrderEntity( );
            order2.setCustomer( customer2 );
            order2.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            order2.setId( "42" );
            order2.setItems( new ArrayList <>( ) );
            order2.setStatus( "Status" );
            order2.setTotal( 10.0d );

            OrderItem orderItem2 = new OrderItem( );
            orderItem2.setId( 1L );
            orderItem2.setOrder( order2 );
            orderItem2.setPrice( 10.0d );
            orderItem2.setProductId( "42" );
            orderItem2.setProductName( "Product Name" );
            orderItem2.setQuantity( 1 );
            assertNotEquals( orderItem , orderItem2 );
        }

    /**
     * Method under test: {@link OrderItem#equals(Object)}
     */
    @Test
    void testEquals9 ( )
        {
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
            OrderEntity order = mock( OrderEntity.class );
            doNothing( ).when( order )
                    .setCustomer( Mockito. < Customer >any( ) );
            doNothing( ).when( order )
                    .setDate( Mockito. < LocalDateTime >any( ) );
            doNothing( ).when( order )
                    .setId( Mockito. < String >any( ) );
            doNothing( ).when( order )
                    .setItems( Mockito. < List < OrderItem > >any( ) );
            doNothing( ).when( order )
                    .setStatus( Mockito. < String >any( ) );
            doNothing( ).when( order )
                    .setTotal( anyDouble( ) );
            order.setCustomer( customer );
            order.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            order.setId( "42" );
            order.setItems( new ArrayList <>( ) );
            order.setStatus( "Status" );
            order.setTotal( 10.0d );

            OrderItem orderItem = new OrderItem( );
            orderItem.setId( 1L );
            orderItem.setOrder( order );
            orderItem.setPrice( 10.0d );
            orderItem.setProductId( "Product Name" );
            orderItem.setProductName( "Product Name" );
            orderItem.setQuantity( 1 );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );

            Customer customer2 = new Customer( );
            customer2.setAddress( address2 );
            customer2.setAge( 1 );
            customer2.setEmail( "jane.doe@example.org" );
            customer2.setId( 1 );
            customer2.setName( "Name" );
            customer2.setOrders( new ArrayList <>( ) );
            customer2.setPhone( "6625550144" );

            OrderEntity order2 = new OrderEntity( );
            order2.setCustomer( customer2 );
            order2.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            order2.setId( "42" );
            order2.setItems( new ArrayList <>( ) );
            order2.setStatus( "Status" );
            order2.setTotal( 10.0d );

            OrderItem orderItem2 = new OrderItem( );
            orderItem2.setId( 1L );
            orderItem2.setOrder( order2 );
            orderItem2.setPrice( 10.0d );
            orderItem2.setProductId( "42" );
            orderItem2.setProductName( "Product Name" );
            orderItem2.setQuantity( 1 );
            assertNotEquals( orderItem , orderItem2 );
        }

    /**
     * Method under test: {@link OrderItem#equals(Object)}
     */
    @Test
    void testEquals10 ( )
        {
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
            OrderEntity order = mock( OrderEntity.class );
            doNothing( ).when( order )
                    .setCustomer( Mockito. < Customer >any( ) );
            doNothing( ).when( order )
                    .setDate( Mockito. < LocalDateTime >any( ) );
            doNothing( ).when( order )
                    .setId( Mockito. < String >any( ) );
            doNothing( ).when( order )
                    .setItems( Mockito. < List < OrderItem > >any( ) );
            doNothing( ).when( order )
                    .setStatus( Mockito. < String >any( ) );
            doNothing( ).when( order )
                    .setTotal( anyDouble( ) );
            order.setCustomer( customer );
            order.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            order.setId( "42" );
            order.setItems( new ArrayList <>( ) );
            order.setStatus( "Status" );
            order.setTotal( 10.0d );

            OrderItem orderItem = new OrderItem( );
            orderItem.setId( 1L );
            orderItem.setOrder( order );
            orderItem.setPrice( 10.0d );
            orderItem.setProductId( null );
            orderItem.setProductName( "Product Name" );
            orderItem.setQuantity( 1 );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );

            Customer customer2 = new Customer( );
            customer2.setAddress( address2 );
            customer2.setAge( 1 );
            customer2.setEmail( "jane.doe@example.org" );
            customer2.setId( 1 );
            customer2.setName( "Name" );
            customer2.setOrders( new ArrayList <>( ) );
            customer2.setPhone( "6625550144" );

            OrderEntity order2 = new OrderEntity( );
            order2.setCustomer( customer2 );
            order2.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            order2.setId( "42" );
            order2.setItems( new ArrayList <>( ) );
            order2.setStatus( "Status" );
            order2.setTotal( 10.0d );

            OrderItem orderItem2 = new OrderItem( );
            orderItem2.setId( 1L );
            orderItem2.setOrder( order2 );
            orderItem2.setPrice( 10.0d );
            orderItem2.setProductId( "42" );
            orderItem2.setProductName( "Product Name" );
            orderItem2.setQuantity( 1 );
            assertNotEquals( orderItem , orderItem2 );
        }

    /**
     * Method under test: {@link OrderItem#equals(Object)}
     */
    @Test
    void testEquals11 ( )
        {
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
            OrderEntity order = mock( OrderEntity.class );
            doNothing( ).when( order )
                    .setCustomer( Mockito. < Customer >any( ) );
            doNothing( ).when( order )
                    .setDate( Mockito. < LocalDateTime >any( ) );
            doNothing( ).when( order )
                    .setId( Mockito. < String >any( ) );
            doNothing( ).when( order )
                    .setItems( Mockito. < List < OrderItem > >any( ) );
            doNothing( ).when( order )
                    .setStatus( Mockito. < String >any( ) );
            doNothing( ).when( order )
                    .setTotal( anyDouble( ) );
            order.setCustomer( customer );
            order.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            order.setId( "42" );
            order.setItems( new ArrayList <>( ) );
            order.setStatus( "Status" );
            order.setTotal( 10.0d );

            OrderItem orderItem = new OrderItem( );
            orderItem.setId( 1L );
            orderItem.setOrder( order );
            orderItem.setPrice( 10.0d );
            orderItem.setProductId( "42" );
            orderItem.setProductName( "42" );
            orderItem.setQuantity( 1 );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );

            Customer customer2 = new Customer( );
            customer2.setAddress( address2 );
            customer2.setAge( 1 );
            customer2.setEmail( "jane.doe@example.org" );
            customer2.setId( 1 );
            customer2.setName( "Name" );
            customer2.setOrders( new ArrayList <>( ) );
            customer2.setPhone( "6625550144" );

            OrderEntity order2 = new OrderEntity( );
            order2.setCustomer( customer2 );
            order2.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            order2.setId( "42" );
            order2.setItems( new ArrayList <>( ) );
            order2.setStatus( "Status" );
            order2.setTotal( 10.0d );

            OrderItem orderItem2 = new OrderItem( );
            orderItem2.setId( 1L );
            orderItem2.setOrder( order2 );
            orderItem2.setPrice( 10.0d );
            orderItem2.setProductId( "42" );
            orderItem2.setProductName( "Product Name" );
            orderItem2.setQuantity( 1 );
            assertNotEquals( orderItem , orderItem2 );
        }

    /**
     * Method under test: {@link OrderItem#equals(Object)}
     */
    @Test
    void testEquals12 ( )
        {
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
            OrderEntity order = mock( OrderEntity.class );
            doNothing( ).when( order )
                    .setCustomer( Mockito. < Customer >any( ) );
            doNothing( ).when( order )
                    .setDate( Mockito. < LocalDateTime >any( ) );
            doNothing( ).when( order )
                    .setId( Mockito. < String >any( ) );
            doNothing( ).when( order )
                    .setItems( Mockito. < List < OrderItem > >any( ) );
            doNothing( ).when( order )
                    .setStatus( Mockito. < String >any( ) );
            doNothing( ).when( order )
                    .setTotal( anyDouble( ) );
            order.setCustomer( customer );
            order.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            order.setId( "42" );
            order.setItems( new ArrayList <>( ) );
            order.setStatus( "Status" );
            order.setTotal( 10.0d );

            OrderItem orderItem = new OrderItem( );
            orderItem.setId( 1L );
            orderItem.setOrder( order );
            orderItem.setPrice( 10.0d );
            orderItem.setProductId( "42" );
            orderItem.setProductName( null );
            orderItem.setQuantity( 1 );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );

            Customer customer2 = new Customer( );
            customer2.setAddress( address2 );
            customer2.setAge( 1 );
            customer2.setEmail( "jane.doe@example.org" );
            customer2.setId( 1 );
            customer2.setName( "Name" );
            customer2.setOrders( new ArrayList <>( ) );
            customer2.setPhone( "6625550144" );

            OrderEntity order2 = new OrderEntity( );
            order2.setCustomer( customer2 );
            order2.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            order2.setId( "42" );
            order2.setItems( new ArrayList <>( ) );
            order2.setStatus( "Status" );
            order2.setTotal( 10.0d );

            OrderItem orderItem2 = new OrderItem( );
            orderItem2.setId( 1L );
            orderItem2.setOrder( order2 );
            orderItem2.setPrice( 10.0d );
            orderItem2.setProductId( "42" );
            orderItem2.setProductName( "Product Name" );
            orderItem2.setQuantity( 1 );
            assertNotEquals( orderItem , orderItem2 );
        }

    /**
     * Method under test: {@link OrderItem#equals(Object)}
     */
    @Test
    void testEquals13 ( )
        {
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
            OrderEntity order = mock( OrderEntity.class );
            doNothing( ).when( order )
                    .setCustomer( Mockito. < Customer >any( ) );
            doNothing( ).when( order )
                    .setDate( Mockito. < LocalDateTime >any( ) );
            doNothing( ).when( order )
                    .setId( Mockito. < String >any( ) );
            doNothing( ).when( order )
                    .setItems( Mockito. < List < OrderItem > >any( ) );
            doNothing( ).when( order )
                    .setStatus( Mockito. < String >any( ) );
            doNothing( ).when( order )
                    .setTotal( anyDouble( ) );
            order.setCustomer( customer );
            order.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            order.setId( "42" );
            order.setItems( new ArrayList <>( ) );
            order.setStatus( "Status" );
            order.setTotal( 10.0d );

            OrderItem orderItem = new OrderItem( );
            orderItem.setId( 1L );
            orderItem.setOrder( order );
            orderItem.setPrice( 10.0d );
            orderItem.setProductId( "42" );
            orderItem.setProductName( "Product Name" );
            orderItem.setQuantity( 3 );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );

            Customer customer2 = new Customer( );
            customer2.setAddress( address2 );
            customer2.setAge( 1 );
            customer2.setEmail( "jane.doe@example.org" );
            customer2.setId( 1 );
            customer2.setName( "Name" );
            customer2.setOrders( new ArrayList <>( ) );
            customer2.setPhone( "6625550144" );

            OrderEntity order2 = new OrderEntity( );
            order2.setCustomer( customer2 );
            order2.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            order2.setId( "42" );
            order2.setItems( new ArrayList <>( ) );
            order2.setStatus( "Status" );
            order2.setTotal( 10.0d );

            OrderItem orderItem2 = new OrderItem( );
            orderItem2.setId( 1L );
            orderItem2.setOrder( order2 );
            orderItem2.setPrice( 10.0d );
            orderItem2.setProductId( "42" );
            orderItem2.setProductName( "Product Name" );
            orderItem2.setQuantity( 1 );
            assertNotEquals( orderItem , orderItem2 );
        }
}

