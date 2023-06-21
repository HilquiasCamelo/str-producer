package com.hilquiascamelo.strproducer.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CustomerTest {
    @Test
    void testConstructor ( )
        {
            Customer actualCustomer = new Customer( );
            Address address = new Address( );
            address.setCity( "Oxford" );
            address.setId( 1L );
            address.setState( "MD" );
            address.setStreet( "Street" );
            address.setZipCode( "21654" );
            actualCustomer.setAddress( address );
            actualCustomer.setAge( 1 );
            actualCustomer.setEmail( "jane.doe@example.org" );
            actualCustomer.setId( 1 );
            actualCustomer.setName( "Name" );
            ArrayList < OrderEntity > orders = new ArrayList <>( );
            actualCustomer.setOrders( orders );
            actualCustomer.setPhone( "6625550144" );
            String actualToStringResult = actualCustomer.toString( );
            assertSame( address , actualCustomer.getAddress( ) );
            assertEquals( 1 , actualCustomer.getAge( ) );
            assertEquals( "jane.doe@example.org" , actualCustomer.getEmail( ) );
            assertEquals( 1 , actualCustomer.getId( ) );
            assertEquals( "Name" , actualCustomer.getName( ) );
            assertSame( orders , actualCustomer.getOrders( ) );
            assertEquals( "6625550144" , actualCustomer.getPhone( ) );
            assertEquals(
                    "Customer(id=1, name=Name, age=1, email=jane.doe@example.org, phone=6625550144, address=Address(id=1," +
                    " street=Street, city=Oxford, state=MD, zipCode=21654), orders=[])" , actualToStringResult );
        }


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
            assertNotEquals( customer , null );
        }


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
            assertNotEquals( customer , "Different type to Customer" );
        }


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
            assertEquals( customer , customer );
            int expectedHashCodeResult = customer.hashCode( );
            assertEquals( expectedHashCodeResult , customer.hashCode( ) );
        }


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
            assertEquals( customer , customer2 );
            int expectedHashCodeResult = customer.hashCode( );
            assertEquals( expectedHashCodeResult , customer2.hashCode( ) );
        }


    @Test
    void testEquals5 ( )
        {
            Address address = mock( Address.class );
            doNothing( ).when( address )
                    .setCity( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setId( Mockito. < Long >any( ) );
            doNothing( ).when( address )
                    .setState( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setStreet( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setZipCode( Mockito. < String >any( ) );
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
            assertNotEquals( customer , customer2 );
        }


    @Test
    void testEquals6 ( )
        {
            Address address = mock( Address.class );
            doNothing( ).when( address )
                    .setCity( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setId( Mockito. < Long >any( ) );
            doNothing( ).when( address )
                    .setState( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setStreet( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setZipCode( Mockito. < String >any( ) );
            address.setCity( "Oxford" );
            address.setId( 1L );
            address.setState( "MD" );
            address.setStreet( "Street" );
            address.setZipCode( "21654" );

            Customer customer = new Customer( );
            customer.setAddress( address );
            customer.setAge( 3 );
            customer.setEmail( "jane.doe@example.org" );
            customer.setId( 1 );
            customer.setName( "Name" );
            customer.setOrders( new ArrayList <>( ) );
            customer.setPhone( "6625550144" );

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
            assertNotEquals( customer , customer2 );
        }

    @Test
    void testEquals7 ( )
        {
            Address address = mock( Address.class );
            doNothing( ).when( address )
                    .setCity( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setId( Mockito. < Long >any( ) );
            doNothing( ).when( address )
                    .setState( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setStreet( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setZipCode( Mockito. < String >any( ) );
            address.setCity( "Oxford" );
            address.setId( 1L );
            address.setState( "MD" );
            address.setStreet( "Street" );
            address.setZipCode( "21654" );

            Customer customer = new Customer( );
            customer.setAddress( address );
            customer.setAge( 1 );
            customer.setEmail( "john.smith@example.org" );
            customer.setId( 1 );
            customer.setName( "Name" );
            customer.setOrders( new ArrayList <>( ) );
            customer.setPhone( "6625550144" );

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
            assertNotEquals( customer , customer2 );
        }


    @Test
    void testEquals8 ( )
        {
            Address address = mock( Address.class );
            doNothing( ).when( address )
                    .setCity( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setId( Mockito. < Long >any( ) );
            doNothing( ).when( address )
                    .setState( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setStreet( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setZipCode( Mockito. < String >any( ) );
            address.setCity( "Oxford" );
            address.setId( 1L );
            address.setState( "MD" );
            address.setStreet( "Street" );
            address.setZipCode( "21654" );

            Customer customer = new Customer( );
            customer.setAddress( address );
            customer.setAge( 1 );
            customer.setEmail( null );
            customer.setId( 1 );
            customer.setName( "Name" );
            customer.setOrders( new ArrayList <>( ) );
            customer.setPhone( "6625550144" );

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
            assertNotEquals( customer , customer2 );
        }

    @Test
    void testEquals9 ( )
        {
            Address address = mock( Address.class );
            doNothing( ).when( address )
                    .setCity( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setId( Mockito. < Long >any( ) );
            doNothing( ).when( address )
                    .setState( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setStreet( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setZipCode( Mockito. < String >any( ) );
            address.setCity( "Oxford" );
            address.setId( 1L );
            address.setState( "MD" );
            address.setStreet( "Street" );
            address.setZipCode( "21654" );

            Customer customer = new Customer( );
            customer.setAddress( address );
            customer.setAge( 1 );
            customer.setEmail( "jane.doe@example.org" );
            customer.setId( 2 );
            customer.setName( "Name" );
            customer.setOrders( new ArrayList <>( ) );
            customer.setPhone( "6625550144" );

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
            assertNotEquals( customer , customer2 );
        }

    @Test
    void testEquals10 ( )
        {
            Address address = mock( Address.class );
            doNothing( ).when( address )
                    .setCity( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setId( Mockito. < Long >any( ) );
            doNothing( ).when( address )
                    .setState( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setStreet( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setZipCode( Mockito. < String >any( ) );
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
            customer.setName( "jane.doe@example.org" );
            customer.setOrders( new ArrayList <>( ) );
            customer.setPhone( "6625550144" );

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
            assertNotEquals( customer , customer2 );
        }

    @Test
    void testEquals11 ( )
        {
            Address address = mock( Address.class );
            doNothing( ).when( address )
                    .setCity( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setId( Mockito. < Long >any( ) );
            doNothing( ).when( address )
                    .setState( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setStreet( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setZipCode( Mockito. < String >any( ) );
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
            customer.setName( null );
            customer.setOrders( new ArrayList <>( ) );
            customer.setPhone( "6625550144" );

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
            assertNotEquals( customer , customer2 );
        }


    @Test
    void testEquals12 ( )
        {
            Address address = mock( Address.class );
            doNothing( ).when( address )
                    .setCity( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setId( Mockito. < Long >any( ) );
            doNothing( ).when( address )
                    .setState( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setStreet( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setZipCode( Mockito. < String >any( ) );
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
            customer.setPhone( "8605550118" );

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
            assertNotEquals( customer , customer2 );
        }

    @Test
    void testEquals13 ( )
        {
            Address address = mock( Address.class );
            doNothing( ).when( address )
                    .setCity( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setId( Mockito. < Long >any( ) );
            doNothing( ).when( address )
                    .setState( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setStreet( Mockito. < String >any( ) );
            doNothing( ).when( address )
                    .setZipCode( Mockito. < String >any( ) );
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
            customer.setPhone( null );

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
            assertNotEquals( customer , customer2 );
        }
}

