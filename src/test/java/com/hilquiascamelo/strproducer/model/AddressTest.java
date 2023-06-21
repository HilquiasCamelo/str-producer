package com.hilquiascamelo.strproducer.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AddressTest {

    @Test
    void testCanEqual ( )
        {
            assertFalse( (new Address( )).canEqual( "Other" ) );
        }
    @Test
    void testCanEqual2 ( )
        {
            Address address = new Address( );
            address.setCity( "Oxford" );
            address.setId( 1L );
            address.setState( "MD" );
            address.setStreet( "Street" );
            address.setZipCode( "21654" );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );
            assertTrue( address.canEqual( address2 ) );
        }

    @Test
    void testConstructor ( )
        {
            Address actualAddress = new Address( );
            actualAddress.setCity( "Oxford" );
            actualAddress.setId( 1L );
            actualAddress.setState( "MD" );
            actualAddress.setStreet( "Street" );
            actualAddress.setZipCode( "21654" );
            String actualToStringResult = actualAddress.toString( );
            assertEquals( "Oxford" , actualAddress.getCity( ) );
            assertEquals( 1L , actualAddress.getId( )
                    .longValue( ) );
            assertEquals( "MD" , actualAddress.getState( ) );
            assertEquals( "Street" , actualAddress.getStreet( ) );
            assertEquals( "21654" , actualAddress.getZipCode( ) );
            assertEquals( "Address(id=1, street=Street, city=Oxford, state=MD, zipCode=21654)" , actualToStringResult );
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
            assertNotEquals( address , null );
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
            assertNotEquals( address , "Different type to Address" );
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
            assertEquals( address , address );
            int expectedHashCodeResult = address.hashCode( );
            assertEquals( expectedHashCodeResult , address.hashCode( ) );
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

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );
            assertEquals( address , address2 );
            int expectedHashCodeResult = address.hashCode( );
            assertEquals( expectedHashCodeResult , address2.hashCode( ) );
        }

    @Test
    void testEquals5 ( )
        {
            Address address = new Address( );
            address.setCity( "London" );
            address.setId( 1L );
            address.setState( "MD" );
            address.setStreet( "Street" );
            address.setZipCode( "21654" );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );
            assertNotEquals( address , address2 );
        }

    @Test
    void testEquals6 ( )
        {
            Address address = new Address( );
            address.setCity( null );
            address.setId( 1L );
            address.setState( "MD" );
            address.setStreet( "Street" );
            address.setZipCode( "21654" );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );
            assertNotEquals( address , address2 );
        }

    @Test
    void testEquals7 ( )
        {
            Address address = new Address( );
            address.setCity( "Oxford" );
            address.setId( 2L );
            address.setState( "MD" );
            address.setStreet( "Street" );
            address.setZipCode( "21654" );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );
            assertNotEquals( address , address2 );
        }

    @Test
    void testEquals8 ( )
        {
            Address address = new Address( );
            address.setCity( "Oxford" );
            address.setId( null );
            address.setState( "MD" );
            address.setStreet( "Street" );
            address.setZipCode( "21654" );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );
            assertNotEquals( address , address2 );
        }

    @Test
    void testEquals9 ( )
        {
            Address address = new Address( );
            address.setCity( "Oxford" );
            address.setId( 1L );
            address.setState( "Street" );
            address.setStreet( "Street" );
            address.setZipCode( "21654" );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );
            assertNotEquals( address , address2 );
        }

    @Test
    void testEquals10 ( )
        {
            Address address = new Address( );
            address.setCity( "Oxford" );
            address.setId( 1L );
            address.setState( null );
            address.setStreet( "Street" );
            address.setZipCode( "21654" );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );
            assertNotEquals( address , address2 );
        }

    @Test
    void testEquals11 ( )
        {
            Address address = new Address( );
            address.setCity( "Oxford" );
            address.setId( 1L );
            address.setState( "MD" );
            address.setStreet( "Oxford" );
            address.setZipCode( "21654" );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );
            assertNotEquals( address , address2 );
        }

    @Test
    void testEquals12 ( )
        {
            Address address = new Address( );
            address.setCity( "Oxford" );
            address.setId( 1L );
            address.setState( "MD" );
            address.setStreet( null );
            address.setZipCode( "21654" );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );
            assertNotEquals( address , address2 );
        }

    @Test
    void testEquals13 ( )
        {
            Address address = new Address( );
            address.setCity( "Oxford" );
            address.setId( 1L );
            address.setState( "MD" );
            address.setStreet( "Street" );
            address.setZipCode( "OX1 1PT" );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );
            assertNotEquals( address , address2 );
        }

    @Test
    void testEquals14 ( )
        {
            Address address = new Address( );
            address.setCity( "Oxford" );
            address.setId( 1L );
            address.setState( "MD" );
            address.setStreet( "Street" );
            address.setZipCode( null );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );
            assertNotEquals( address , address2 );
        }

  
    @Test
    void testEquals15 ( )
        {
            Address address = new Address( );
            address.setCity( null );
            address.setId( 1L );
            address.setState( "MD" );
            address.setStreet( "Street" );
            address.setZipCode( "21654" );

            Address address2 = new Address( );
            address2.setCity( null );
            address2.setId( 1L );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );
            assertEquals( address , address2 );
            int expectedHashCodeResult = address.hashCode( );
            assertEquals( expectedHashCodeResult , address2.hashCode( ) );
        }

  
    @Test
    void testEquals16 ( )
        {
            Address address = new Address( );
            address.setCity( "Oxford" );
            address.setId( null );
            address.setState( "MD" );
            address.setStreet( "Street" );
            address.setZipCode( "21654" );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( null );
            address2.setState( "MD" );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );
            assertEquals( address , address2 );
            int expectedHashCodeResult = address.hashCode( );
            assertEquals( expectedHashCodeResult , address2.hashCode( ) );
        }

  
    @Test
    void testEquals17 ( )
        {
            Address address = new Address( );
            address.setCity( "Oxford" );
            address.setId( 1L );
            address.setState( null );
            address.setStreet( "Street" );
            address.setZipCode( "21654" );

            Address address2 = new Address( );
            address2.setCity( "Oxford" );
            address2.setId( 1L );
            address2.setState( null );
            address2.setStreet( "Street" );
            address2.setZipCode( "21654" );
            assertEquals( address , address2 );
            int expectedHashCodeResult = address.hashCode( );
            assertEquals( expectedHashCodeResult , address2.hashCode( ) );
        }
}

