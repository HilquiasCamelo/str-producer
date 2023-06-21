package com.hilquiascamelo.strproducer.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OrderEntityTest {
    /**
     * Method under test: {@link OrderEntity#canEqual(Object)}
     */
    @Test
    void testCanEqual ( )
        {
            assertFalse( (new OrderEntity( )).canEqual( "Other" ) );
        }

    /**
     * Method under test: {@link OrderEntity#canEqual(Object)}
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

            OrderEntity orderEntity = new OrderEntity( );
            orderEntity.setCustomer( customer );
            orderEntity.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            orderEntity.setId( "42" );
            orderEntity.setItems( new ArrayList <>( ) );
            orderEntity.setStatus( "Status" );
            orderEntity.setTotal( 10.0d );

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

            OrderEntity orderEntity2 = new OrderEntity( );
            orderEntity2.setCustomer( customer2 );
            orderEntity2.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            orderEntity2.setId( "42" );
            orderEntity2.setItems( new ArrayList <>( ) );
            orderEntity2.setStatus( "Status" );
            orderEntity2.setTotal( 10.0d );
            assertTrue( orderEntity.canEqual( orderEntity2 ) );
        }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link OrderEntity}
     *   <li>{@link OrderEntity#setCustomer(Customer)}
     *   <li>{@link OrderEntity#setDate(LocalDateTime)}
     *   <li>{@link OrderEntity#setId(String)}
     *   <li>{@link OrderEntity#setItems(List)}
     *   <li>{@link OrderEntity#setStatus(String)}
     *   <li>{@link OrderEntity#setTotal(double)}
     *   <li>{@link OrderEntity#toString()}
     *   <li>{@link OrderEntity#getCustomer()}
     *   <li>{@link OrderEntity#getDate()}
     *   <li>{@link OrderEntity#getId()}
     *   <li>{@link OrderEntity#getItems()}
     *   <li>{@link OrderEntity#getStatus()}
     *   <li>{@link OrderEntity#getTotal()}
     * </ul>
     */
    @Test
    void testConstructor ( )
        {
            OrderEntity actualOrderEntity = new OrderEntity( );
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
            ArrayList < OrderEntity > orders = new ArrayList <>( );
            customer.setOrders( orders );
            customer.setPhone( "6625550144" );
            actualOrderEntity.setCustomer( customer );
            LocalDateTime
                    date =
                    LocalDate.of( 1970 , 1 , 1 )
                            .atStartOfDay( );
            actualOrderEntity.setDate( date );
            actualOrderEntity.setId( "42" );
            ArrayList < OrderItem > items = new ArrayList <>( );
            actualOrderEntity.setItems( items );
            actualOrderEntity.setStatus( "Status" );
            actualOrderEntity.setTotal( 10.0d );
            String actualToStringResult = actualOrderEntity.toString( );
            assertSame( customer , actualOrderEntity.getCustomer( ) );
            assertSame( date , actualOrderEntity.getDate( ) );
            assertEquals( "42" , actualOrderEntity.getId( ) );
            List < OrderItem > items2 = actualOrderEntity.getItems( );
            assertSame( items , items2 );
            assertEquals( orders , items2 );
            assertEquals( "Status" , actualOrderEntity.getStatus( ) );
            assertEquals( 10.0d , actualOrderEntity.getTotal( ) );
            assertEquals(
                    "OrderEntity(id=42, date=1970-01-01T00:00, customer=Customer(id=1, name=Name, age=1, email=jane.doe" +
                    "@example.org, phone=6625550144, address=Address(id=1, street=Street, city=Oxford, state=MD, zipCode=21654)," +
                    " orders=[]), items=[], total=10.0, status=Status)" , actualToStringResult );
        }

    /**
     * Method under test: {@link OrderEntity#equals(Object)}
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

            OrderEntity orderEntity = new OrderEntity( );
            orderEntity.setCustomer( customer );
            orderEntity.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            orderEntity.setId( "42" );
            orderEntity.setItems( new ArrayList <>( ) );
            orderEntity.setStatus( "Status" );
            orderEntity.setTotal( 10.0d );
            assertNotEquals( orderEntity , null );
        }

    /**
     * Method under test: {@link OrderEntity#equals(Object)}
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

            OrderEntity orderEntity = new OrderEntity( );
            orderEntity.setCustomer( customer );
            orderEntity.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            orderEntity.setId( "42" );
            orderEntity.setItems( new ArrayList <>( ) );
            orderEntity.setStatus( "Status" );
            orderEntity.setTotal( 10.0d );
            assertNotEquals( orderEntity , "Different type to OrderEntity" );
        }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link OrderEntity#equals(Object)}
     *   <li>{@link OrderEntity#hashCode()}
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

            OrderEntity orderEntity = new OrderEntity( );
            orderEntity.setCustomer( customer );
            orderEntity.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            orderEntity.setId( "42" );
            orderEntity.setItems( new ArrayList <>( ) );
            orderEntity.setStatus( "Status" );
            orderEntity.setTotal( 10.0d );
            assertEquals( orderEntity , orderEntity );
            int expectedHashCodeResult = orderEntity.hashCode( );
            assertEquals( expectedHashCodeResult , orderEntity.hashCode( ) );
        }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link OrderEntity#equals(Object)}
     *   <li>{@link OrderEntity#hashCode()}
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

            OrderEntity orderEntity = new OrderEntity( );
            orderEntity.setCustomer( customer );
            orderEntity.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            orderEntity.setId( "42" );
            orderEntity.setItems( new ArrayList <>( ) );
            orderEntity.setStatus( "Status" );
            orderEntity.setTotal( 10.0d );

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

            OrderEntity orderEntity2 = new OrderEntity( );
            orderEntity2.setCustomer( customer2 );
            orderEntity2.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            orderEntity2.setId( "42" );
            orderEntity2.setItems( new ArrayList <>( ) );
            orderEntity2.setStatus( "Status" );
            orderEntity2.setTotal( 10.0d );
            assertEquals( orderEntity , orderEntity2 );
            int expectedHashCodeResult = orderEntity.hashCode( );
            assertEquals( expectedHashCodeResult , orderEntity2.hashCode( ) );
        }

    /**
     * Method under test: {@link OrderEntity#equals(Object)}
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
            Customer customer = mock( Customer.class );
            doNothing( ).when( customer )
                    .setAddress( Mockito. < Address >any( ) );
            doNothing( ).when( customer )
                    .setAge( anyInt( ) );
            doNothing( ).when( customer )
                    .setEmail( Mockito. < String >any( ) );
            doNothing( ).when( customer )
                    .setId( anyInt( ) );
            doNothing( ).when( customer )
                    .setName( Mockito. < String >any( ) );
            doNothing( ).when( customer )
                    .setOrders( Mockito. < List < OrderEntity > >any( ) );
            doNothing( ).when( customer )
                    .setPhone( Mockito. < String >any( ) );
            customer.setAddress( address );
            customer.setAge( 1 );
            customer.setEmail( "jane.doe@example.org" );
            customer.setId( 1 );
            customer.setName( "Name" );
            customer.setOrders( new ArrayList <>( ) );
            customer.setPhone( "6625550144" );

            OrderEntity orderEntity = new OrderEntity( );
            orderEntity.setCustomer( customer );
            orderEntity.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            orderEntity.setId( "42" );
            orderEntity.setItems( new ArrayList <>( ) );
            orderEntity.setStatus( "Status" );
            orderEntity.setTotal( 10.0d );

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

            OrderEntity orderEntity2 = new OrderEntity( );
            orderEntity2.setCustomer( customer2 );
            orderEntity2.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            orderEntity2.setId( "42" );
            orderEntity2.setItems( new ArrayList <>( ) );
            orderEntity2.setStatus( "Status" );
            orderEntity2.setTotal( 10.0d );
            assertNotEquals( orderEntity , orderEntity2 );
        }

    /**
     * Method under test: {@link OrderEntity#equals(Object)}
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
            Customer customer = mock( Customer.class );
            doNothing( ).when( customer )
                    .setAddress( Mockito. < Address >any( ) );
            doNothing( ).when( customer )
                    .setAge( anyInt( ) );
            doNothing( ).when( customer )
                    .setEmail( Mockito. < String >any( ) );
            doNothing( ).when( customer )
                    .setId( anyInt( ) );
            doNothing( ).when( customer )
                    .setName( Mockito. < String >any( ) );
            doNothing( ).when( customer )
                    .setOrders( Mockito. < List < OrderEntity > >any( ) );
            doNothing( ).when( customer )
                    .setPhone( Mockito. < String >any( ) );
            customer.setAddress( address );
            customer.setAge( 1 );
            customer.setEmail( "jane.doe@example.org" );
            customer.setId( 1 );
            customer.setName( "Name" );
            customer.setOrders( new ArrayList <>( ) );
            customer.setPhone( "6625550144" );

            OrderEntity orderEntity = new OrderEntity( );
            orderEntity.setCustomer( customer );
            orderEntity.setDate( LocalDate.now( )
                    .atStartOfDay( ) );
            orderEntity.setId( "42" );
            orderEntity.setItems( new ArrayList <>( ) );
            orderEntity.setStatus( "Status" );
            orderEntity.setTotal( 10.0d );

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

            OrderEntity orderEntity2 = new OrderEntity( );
            orderEntity2.setCustomer( customer2 );
            orderEntity2.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            orderEntity2.setId( "42" );
            orderEntity2.setItems( new ArrayList <>( ) );
            orderEntity2.setStatus( "Status" );
            orderEntity2.setTotal( 10.0d );
            assertNotEquals( orderEntity , orderEntity2 );
        }

    /**
     * Method under test: {@link OrderEntity#equals(Object)}
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
            Customer customer = mock( Customer.class );
            doNothing( ).when( customer )
                    .setAddress( Mockito. < Address >any( ) );
            doNothing( ).when( customer )
                    .setAge( anyInt( ) );
            doNothing( ).when( customer )
                    .setEmail( Mockito. < String >any( ) );
            doNothing( ).when( customer )
                    .setId( anyInt( ) );
            doNothing( ).when( customer )
                    .setName( Mockito. < String >any( ) );
            doNothing( ).when( customer )
                    .setOrders( Mockito. < List < OrderEntity > >any( ) );
            doNothing( ).when( customer )
                    .setPhone( Mockito. < String >any( ) );
            customer.setAddress( address );
            customer.setAge( 1 );
            customer.setEmail( "jane.doe@example.org" );
            customer.setId( 1 );
            customer.setName( "Name" );
            customer.setOrders( new ArrayList <>( ) );
            customer.setPhone( "6625550144" );

            OrderEntity orderEntity = new OrderEntity( );
            orderEntity.setCustomer( customer );
            orderEntity.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            orderEntity.setId( "Id" );
            orderEntity.setItems( new ArrayList <>( ) );
            orderEntity.setStatus( "Status" );
            orderEntity.setTotal( 10.0d );

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

            OrderEntity orderEntity2 = new OrderEntity( );
            orderEntity2.setCustomer( customer2 );
            orderEntity2.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            orderEntity2.setId( "42" );
            orderEntity2.setItems( new ArrayList <>( ) );
            orderEntity2.setStatus( "Status" );
            orderEntity2.setTotal( 10.0d );
            assertNotEquals( orderEntity , orderEntity2 );
        }

    /**
     * Method under test: {@link OrderEntity#equals(Object)}
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
            Customer customer = mock( Customer.class );
            doNothing( ).when( customer )
                    .setAddress( Mockito. < Address >any( ) );
            doNothing( ).when( customer )
                    .setAge( anyInt( ) );
            doNothing( ).when( customer )
                    .setEmail( Mockito. < String >any( ) );
            doNothing( ).when( customer )
                    .setId( anyInt( ) );
            doNothing( ).when( customer )
                    .setName( Mockito. < String >any( ) );
            doNothing( ).when( customer )
                    .setOrders( Mockito. < List < OrderEntity > >any( ) );
            doNothing( ).when( customer )
                    .setPhone( Mockito. < String >any( ) );
            customer.setAddress( address );
            customer.setAge( 1 );
            customer.setEmail( "jane.doe@example.org" );
            customer.setId( 1 );
            customer.setName( "Name" );
            customer.setOrders( new ArrayList <>( ) );
            customer.setPhone( "6625550144" );

            OrderEntity orderEntity = new OrderEntity( );
            orderEntity.setCustomer( customer );
            orderEntity.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            orderEntity.setId( null );
            orderEntity.setItems( new ArrayList <>( ) );
            orderEntity.setStatus( "Status" );
            orderEntity.setTotal( 10.0d );

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

            OrderEntity orderEntity2 = new OrderEntity( );
            orderEntity2.setCustomer( customer2 );
            orderEntity2.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            orderEntity2.setId( "42" );
            orderEntity2.setItems( new ArrayList <>( ) );
            orderEntity2.setStatus( "Status" );
            orderEntity2.setTotal( 10.0d );
            assertNotEquals( orderEntity , orderEntity2 );
        }

    /**
     * Method under test: {@link OrderEntity#equals(Object)}
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
            Customer customer = mock( Customer.class );
            doNothing( ).when( customer )
                    .setAddress( Mockito. < Address >any( ) );
            doNothing( ).when( customer )
                    .setAge( anyInt( ) );
            doNothing( ).when( customer )
                    .setEmail( Mockito. < String >any( ) );
            doNothing( ).when( customer )
                    .setId( anyInt( ) );
            doNothing( ).when( customer )
                    .setName( Mockito. < String >any( ) );
            doNothing( ).when( customer )
                    .setOrders( Mockito. < List < OrderEntity > >any( ) );
            doNothing( ).when( customer )
                    .setPhone( Mockito. < String >any( ) );
            customer.setAddress( address );
            customer.setAge( 1 );
            customer.setEmail( "jane.doe@example.org" );
            customer.setId( 1 );
            customer.setName( "Name" );
            customer.setOrders( new ArrayList <>( ) );
            customer.setPhone( "6625550144" );

            OrderEntity orderEntity = new OrderEntity( );
            orderEntity.setCustomer( customer );
            orderEntity.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            orderEntity.setId( "42" );
            orderEntity.setItems( new ArrayList <>( ) );
            orderEntity.setStatus( "Status" );
            orderEntity.setTotal( 0.5d );

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

            OrderEntity orderEntity2 = new OrderEntity( );
            orderEntity2.setCustomer( customer2 );
            orderEntity2.setDate( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            orderEntity2.setId( "42" );
            orderEntity2.setItems( new ArrayList <>( ) );
            orderEntity2.setStatus( "Status" );
            orderEntity2.setTotal( 10.0d );
            assertNotEquals( orderEntity , orderEntity2 );
        }
}

