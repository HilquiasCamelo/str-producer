package com.hilquiascamelo.strproducer.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ProductTest {

    @Test
    void testCanEqual ( )
        {
            assertFalse( (new Product( )).canEqual( "Other" ) );
        }


    @Test
    void testCanEqual2 ( )
        {
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

            Product product2 = new Product( );
            product2.setAvailable( true );
            product2.setCategories( new ArrayList <>( ) );
            product2.setDescription( "The characteristics of someone or something" );
            product2.setFeatures( new HashMap <>( ) );
            product2.setId( 1 );
            product2.setManufacturer( "Manufacturer" );
            product2.setName( "Name" );
            product2.setPrice( 10.0d );
            product2.setStock( 1 );
            assertTrue( product.canEqual( product2 ) );
        }


    @Test
    void testConstructor ( )
        {
            Product actualProduct = new Product( );
            actualProduct.setAvailable( true );
            ArrayList < String > categories = new ArrayList <>( );
            actualProduct.setCategories( categories );
            actualProduct.setDescription( "The characteristics of someone or something" );
            HashMap < String, String > features = new HashMap <>( );
            actualProduct.setFeatures( features );
            actualProduct.setId( 1 );
            actualProduct.setManufacturer( "Manufacturer" );
            actualProduct.setName( "Name" );
            actualProduct.setPrice( 10.0d );
            actualProduct.setStock( 1 );
            String actualToStringResult = actualProduct.toString( );
            assertSame( categories , actualProduct.getCategories( ) );
            assertEquals( "The characteristics of someone or something" , actualProduct.getDescription( ) );
            assertSame( features , actualProduct.getFeatures( ) );
            assertEquals( 1 , actualProduct.getId( ) );
            assertEquals( "Manufacturer" , actualProduct.getManufacturer( ) );
            assertEquals( "Name" , actualProduct.getName( ) );
            assertEquals( 10.0d , actualProduct.getPrice( ) );
            assertEquals( 1 , actualProduct.getStock( ) );
            assertTrue( actualProduct.isAvailable( ) );
            assertEquals(
                    "Product(id=1, name=Name, price=10.0, manufacturer=Manufacturer, description=The characteristics of" +
                    " someone or something, stock=1, categories=[], available=true, features={})" ,
                    actualToStringResult );
        }


    @Test
    void testEquals ( )
        {
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
            assertNotEquals( product , null );
        }


    @Test
    void testEquals2 ( )
        {
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
            assertNotEquals( product , "Different type to Product" );
        }


    @Test
    void testEquals3 ( )
        {
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
            assertEquals( product , product );
            int expectedHashCodeResult = product.hashCode( );
            assertEquals( expectedHashCodeResult , product.hashCode( ) );
        }


    @Test
    void testEquals4 ( )
        {
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

            Product product2 = new Product( );
            product2.setAvailable( true );
            product2.setCategories( new ArrayList <>( ) );
            product2.setDescription( "The characteristics of someone or something" );
            product2.setFeatures( new HashMap <>( ) );
            product2.setId( 1 );
            product2.setManufacturer( "Manufacturer" );
            product2.setName( "Name" );
            product2.setPrice( 10.0d );
            product2.setStock( 1 );
            assertEquals( product , product2 );
            int expectedHashCodeResult = product.hashCode( );
            assertEquals( expectedHashCodeResult , product2.hashCode( ) );
        }

    @Test
    void testEquals5 ( )
        {
            Product product = new Product( );
            product.setAvailable( false );
            product.setCategories( new ArrayList <>( ) );
            product.setDescription( "The characteristics of someone or something" );
            product.setFeatures( new HashMap <>( ) );
            product.setId( 1 );
            product.setManufacturer( "Manufacturer" );
            product.setName( "Name" );
            product.setPrice( 10.0d );
            product.setStock( 1 );

            Product product2 = new Product( );
            product2.setAvailable( true );
            product2.setCategories( new ArrayList <>( ) );
            product2.setDescription( "The characteristics of someone or something" );
            product2.setFeatures( new HashMap <>( ) );
            product2.setId( 1 );
            product2.setManufacturer( "Manufacturer" );
            product2.setName( "Name" );
            product2.setPrice( 10.0d );
            product2.setStock( 1 );
            assertNotEquals( product , product2 );
        }


    @Test
    void testEquals6 ( )
        {
            ArrayList < String > categories = new ArrayList <>( );
            categories.add( "Name" );

            Product product = new Product( );
            product.setAvailable( true );
            product.setCategories( categories );
            product.setDescription( "The characteristics of someone or something" );
            product.setFeatures( new HashMap <>( ) );
            product.setId( 1 );
            product.setManufacturer( "Manufacturer" );
            product.setName( "Name" );
            product.setPrice( 10.0d );
            product.setStock( 1 );

            Product product2 = new Product( );
            product2.setAvailable( true );
            product2.setCategories( new ArrayList <>( ) );
            product2.setDescription( "The characteristics of someone or something" );
            product2.setFeatures( new HashMap <>( ) );
            product2.setId( 1 );
            product2.setManufacturer( "Manufacturer" );
            product2.setName( "Name" );
            product2.setPrice( 10.0d );
            product2.setStock( 1 );
            assertNotEquals( product , product2 );
        }


    @Test
    void testEquals7 ( )
        {
            Product product = new Product( );
            product.setAvailable( true );
            product.setCategories( new ArrayList <>( ) );
            product.setDescription( "Name" );
            product.setFeatures( new HashMap <>( ) );
            product.setId( 1 );
            product.setManufacturer( "Manufacturer" );
            product.setName( "Name" );
            product.setPrice( 10.0d );
            product.setStock( 1 );

            Product product2 = new Product( );
            product2.setAvailable( true );
            product2.setCategories( new ArrayList <>( ) );
            product2.setDescription( "The characteristics of someone or something" );
            product2.setFeatures( new HashMap <>( ) );
            product2.setId( 1 );
            product2.setManufacturer( "Manufacturer" );
            product2.setName( "Name" );
            product2.setPrice( 10.0d );
            product2.setStock( 1 );
            assertNotEquals( product , product2 );
        }


    @Test
    void testEquals8 ( )
        {
            Product product = new Product( );
            product.setAvailable( true );
            product.setCategories( new ArrayList <>( ) );
            product.setDescription( null );
            product.setFeatures( new HashMap <>( ) );
            product.setId( 1 );
            product.setManufacturer( "Manufacturer" );
            product.setName( "Name" );
            product.setPrice( 10.0d );
            product.setStock( 1 );

            Product product2 = new Product( );
            product2.setAvailable( true );
            product2.setCategories( new ArrayList <>( ) );
            product2.setDescription( "The characteristics of someone or something" );
            product2.setFeatures( new HashMap <>( ) );
            product2.setId( 1 );
            product2.setManufacturer( "Manufacturer" );
            product2.setName( "Name" );
            product2.setPrice( 10.0d );
            product2.setStock( 1 );
            assertNotEquals( product , product2 );
        }

    @Test
    void testEquals9 ( )
        {
            HashMap < String, String > features = new HashMap <>( );
            features.put( "Name" , "Name" );

            Product product = new Product( );
            product.setAvailable( true );
            product.setCategories( new ArrayList <>( ) );
            product.setDescription( "The characteristics of someone or something" );
            product.setFeatures( features );
            product.setId( 1 );
            product.setManufacturer( "Manufacturer" );
            product.setName( "Name" );
            product.setPrice( 10.0d );
            product.setStock( 1 );

            Product product2 = new Product( );
            product2.setAvailable( true );
            product2.setCategories( new ArrayList <>( ) );
            product2.setDescription( "The characteristics of someone or something" );
            product2.setFeatures( new HashMap <>( ) );
            product2.setId( 1 );
            product2.setManufacturer( "Manufacturer" );
            product2.setName( "Name" );
            product2.setPrice( 10.0d );
            product2.setStock( 1 );
            assertNotEquals( product , product2 );
        }

    @Test
    void testEquals10 ( )
        {
            Product product = new Product( );
            product.setAvailable( true );
            product.setCategories( new ArrayList <>( ) );
            product.setDescription( "The characteristics of someone or something" );
            product.setFeatures( new HashMap <>( ) );
            product.setId( 2 );
            product.setManufacturer( "Manufacturer" );
            product.setName( "Name" );
            product.setPrice( 10.0d );
            product.setStock( 1 );

            Product product2 = new Product( );
            product2.setAvailable( true );
            product2.setCategories( new ArrayList <>( ) );
            product2.setDescription( "The characteristics of someone or something" );
            product2.setFeatures( new HashMap <>( ) );
            product2.setId( 1 );
            product2.setManufacturer( "Manufacturer" );
            product2.setName( "Name" );
            product2.setPrice( 10.0d );
            product2.setStock( 1 );
            assertNotEquals( product , product2 );
        }


    @Test
    void testEquals11 ( )
        {
            Product product = new Product( );
            product.setAvailable( true );
            product.setCategories( new ArrayList <>( ) );
            product.setDescription( "The characteristics of someone or something" );
            product.setFeatures( new HashMap <>( ) );
            product.setId( 1 );
            product.setManufacturer( "Name" );
            product.setName( "Name" );
            product.setPrice( 10.0d );
            product.setStock( 1 );

            Product product2 = new Product( );
            product2.setAvailable( true );
            product2.setCategories( new ArrayList <>( ) );
            product2.setDescription( "The characteristics of someone or something" );
            product2.setFeatures( new HashMap <>( ) );
            product2.setId( 1 );
            product2.setManufacturer( "Manufacturer" );
            product2.setName( "Name" );
            product2.setPrice( 10.0d );
            product2.setStock( 1 );
            assertNotEquals( product , product2 );
        }


    @Test
    void testEquals12 ( )
        {
            Product product = new Product( );
            product.setAvailable( true );
            product.setCategories( new ArrayList <>( ) );
            product.setDescription( "The characteristics of someone or something" );
            product.setFeatures( new HashMap <>( ) );
            product.setId( 1 );
            product.setManufacturer( null );
            product.setName( "Name" );
            product.setPrice( 10.0d );
            product.setStock( 1 );

            Product product2 = new Product( );
            product2.setAvailable( true );
            product2.setCategories( new ArrayList <>( ) );
            product2.setDescription( "The characteristics of someone or something" );
            product2.setFeatures( new HashMap <>( ) );
            product2.setId( 1 );
            product2.setManufacturer( "Manufacturer" );
            product2.setName( "Name" );
            product2.setPrice( 10.0d );
            product2.setStock( 1 );
            assertNotEquals( product , product2 );
        }


    @Test
    void testEquals13 ( )
        {
            Product product = new Product( );
            product.setAvailable( true );
            product.setCategories( new ArrayList <>( ) );
            product.setDescription( "The characteristics of someone or something" );
            product.setFeatures( new HashMap <>( ) );
            product.setId( 1 );
            product.setManufacturer( "Manufacturer" );
            product.setName( "Manufacturer" );
            product.setPrice( 10.0d );
            product.setStock( 1 );

            Product product2 = new Product( );
            product2.setAvailable( true );
            product2.setCategories( new ArrayList <>( ) );
            product2.setDescription( "The characteristics of someone or something" );
            product2.setFeatures( new HashMap <>( ) );
            product2.setId( 1 );
            product2.setManufacturer( "Manufacturer" );
            product2.setName( "Name" );
            product2.setPrice( 10.0d );
            product2.setStock( 1 );
            assertNotEquals( product , product2 );
        }


    @Test
    void testEquals14 ( )
        {
            Product product = new Product( );
            product.setAvailable( true );
            product.setCategories( new ArrayList <>( ) );
            product.setDescription( "The characteristics of someone or something" );
            product.setFeatures( new HashMap <>( ) );
            product.setId( 1 );
            product.setManufacturer( "Manufacturer" );
            product.setName( null );
            product.setPrice( 10.0d );
            product.setStock( 1 );

            Product product2 = new Product( );
            product2.setAvailable( true );
            product2.setCategories( new ArrayList <>( ) );
            product2.setDescription( "The characteristics of someone or something" );
            product2.setFeatures( new HashMap <>( ) );
            product2.setId( 1 );
            product2.setManufacturer( "Manufacturer" );
            product2.setName( "Name" );
            product2.setPrice( 10.0d );
            product2.setStock( 1 );
            assertNotEquals( product , product2 );
        }

    @Test
    void testEquals15 ( )
        {
            Product product = new Product( );
            product.setAvailable( true );
            product.setCategories( new ArrayList <>( ) );
            product.setDescription( "The characteristics of someone or something" );
            product.setFeatures( new HashMap <>( ) );
            product.setId( 1 );
            product.setManufacturer( "Manufacturer" );
            product.setName( "Name" );
            product.setPrice( 0.5d );
            product.setStock( 1 );

            Product product2 = new Product( );
            product2.setAvailable( true );
            product2.setCategories( new ArrayList <>( ) );
            product2.setDescription( "The characteristics of someone or something" );
            product2.setFeatures( new HashMap <>( ) );
            product2.setId( 1 );
            product2.setManufacturer( "Manufacturer" );
            product2.setName( "Name" );
            product2.setPrice( 10.0d );
            product2.setStock( 1 );
            assertNotEquals( product , product2 );
        }


    @Test
    void testEquals16 ( )
        {
            Product product = new Product( );
            product.setAvailable( true );
            product.setCategories( new ArrayList <>( ) );
            product.setDescription( "The characteristics of someone or something" );
            product.setFeatures( new HashMap <>( ) );
            product.setId( 1 );
            product.setManufacturer( "Manufacturer" );
            product.setName( "Name" );
            product.setPrice( 10.0d );
            product.setStock( 3 );

            Product product2 = new Product( );
            product2.setAvailable( true );
            product2.setCategories( new ArrayList <>( ) );
            product2.setDescription( "The characteristics of someone or something" );
            product2.setFeatures( new HashMap <>( ) );
            product2.setId( 1 );
            product2.setManufacturer( "Manufacturer" );
            product2.setName( "Name" );
            product2.setPrice( 10.0d );
            product2.setStock( 1 );
            assertNotEquals( product , product2 );
        }
}

