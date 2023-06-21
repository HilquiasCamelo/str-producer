package com.hilquiascamelo.strproducer.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ObjectTextModelTest {
    /**
     * Method under test: {@link ObjectTextModel#canEqual(Object)}
     */
    @Test
    void testCanEqual ( )
        {
            assertFalse( (new ObjectTextModel( )).canEqual( "Other" ) );
        }

    /**
     * Method under test: {@link ObjectTextModel#canEqual(Object)}
     */
    @Test
    void testCanEqual2 ( )
        {
            ObjectTextModel objectTextModel = new ObjectTextModel( );
            objectTextModel.setAddress( "42 Main St" );
            objectTextModel.setAge( 1 );
            objectTextModel.setName( "Name" );
            objectTextModel.setOccupation( "Occupation" );

            ObjectTextModel objectTextModel2 = new ObjectTextModel( );
            objectTextModel2.setAddress( "42 Main St" );
            objectTextModel2.setAge( 1 );
            objectTextModel2.setName( "Name" );
            objectTextModel2.setOccupation( "Occupation" );
            assertTrue( objectTextModel.canEqual( objectTextModel2 ) );
        }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link ObjectTextModel}
     *   <li>{@link ObjectTextModel#setAddress(String)}
     *   <li>{@link ObjectTextModel#setAge(int)}
     *   <li>{@link ObjectTextModel#setName(String)}
     *   <li>{@link ObjectTextModel#setOccupation(String)}
     *   <li>{@link ObjectTextModel#toString()}
     *   <li>{@link ObjectTextModel#getAddress()}
     *   <li>{@link ObjectTextModel#getAge()}
     *   <li>{@link ObjectTextModel#getName()}
     *   <li>{@link ObjectTextModel#getOccupation()}
     * </ul>
     */
    @Test
    void testConstructor ( )
        {
            ObjectTextModel actualObjectTextModel = new ObjectTextModel( );
            actualObjectTextModel.setAddress( "42 Main St" );
            actualObjectTextModel.setAge( 1 );
            actualObjectTextModel.setName( "Name" );
            actualObjectTextModel.setOccupation( "Occupation" );
            String actualToStringResult = actualObjectTextModel.toString( );
            assertEquals( "42 Main St" , actualObjectTextModel.getAddress( ) );
            assertEquals( 1 , actualObjectTextModel.getAge( ) );
            assertEquals( "Name" , actualObjectTextModel.getName( ) );
            assertEquals( "Occupation" , actualObjectTextModel.getOccupation( ) );
            assertEquals( "ObjectTextModel(name=Name, age=1, occupation=Occupation, address=42 Main St)" ,
                    actualToStringResult );
        }

    /**
     * Method under test: {@link ObjectTextModel#equals(Object)}
     */
    @Test
    void testEquals ( )
        {
            ObjectTextModel objectTextModel = new ObjectTextModel( );
            objectTextModel.setAddress( "42 Main St" );
            objectTextModel.setAge( 1 );
            objectTextModel.setName( "Name" );
            objectTextModel.setOccupation( "Occupation" );
            assertNotEquals( objectTextModel , null );
        }

    /**
     * Method under test: {@link ObjectTextModel#equals(Object)}
     */
    @Test
    void testEquals2 ( )
        {
            ObjectTextModel objectTextModel = new ObjectTextModel( );
            objectTextModel.setAddress( "42 Main St" );
            objectTextModel.setAge( 1 );
            objectTextModel.setName( "Name" );
            objectTextModel.setOccupation( "Occupation" );
            assertNotEquals( objectTextModel , "Different type to ObjectTextModel" );
        }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ObjectTextModel#equals(Object)}
     *   <li>{@link ObjectTextModel#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3 ( )
        {
            ObjectTextModel objectTextModel = new ObjectTextModel( );
            objectTextModel.setAddress( "42 Main St" );
            objectTextModel.setAge( 1 );
            objectTextModel.setName( "Name" );
            objectTextModel.setOccupation( "Occupation" );
            assertEquals( objectTextModel , objectTextModel );
            int expectedHashCodeResult = objectTextModel.hashCode( );
            assertEquals( expectedHashCodeResult , objectTextModel.hashCode( ) );
        }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ObjectTextModel#equals(Object)}
     *   <li>{@link ObjectTextModel#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4 ( )
        {
            ObjectTextModel objectTextModel = new ObjectTextModel( );
            objectTextModel.setAddress( "42 Main St" );
            objectTextModel.setAge( 1 );
            objectTextModel.setName( "Name" );
            objectTextModel.setOccupation( "Occupation" );

            ObjectTextModel objectTextModel2 = new ObjectTextModel( );
            objectTextModel2.setAddress( "42 Main St" );
            objectTextModel2.setAge( 1 );
            objectTextModel2.setName( "Name" );
            objectTextModel2.setOccupation( "Occupation" );
            assertEquals( objectTextModel , objectTextModel2 );
            int expectedHashCodeResult = objectTextModel.hashCode( );
            assertEquals( expectedHashCodeResult , objectTextModel2.hashCode( ) );
        }

    /**
     * Method under test: {@link ObjectTextModel#equals(Object)}
     */
    @Test
    void testEquals5 ( )
        {
            ObjectTextModel objectTextModel = new ObjectTextModel( );
            objectTextModel.setAddress( "17 High St" );
            objectTextModel.setAge( 1 );
            objectTextModel.setName( "Name" );
            objectTextModel.setOccupation( "Occupation" );

            ObjectTextModel objectTextModel2 = new ObjectTextModel( );
            objectTextModel2.setAddress( "42 Main St" );
            objectTextModel2.setAge( 1 );
            objectTextModel2.setName( "Name" );
            objectTextModel2.setOccupation( "Occupation" );
            assertNotEquals( objectTextModel , objectTextModel2 );
        }

    /**
     * Method under test: {@link ObjectTextModel#equals(Object)}
     */
    @Test
    void testEquals6 ( )
        {
            ObjectTextModel objectTextModel = new ObjectTextModel( );
            objectTextModel.setAddress( null );
            objectTextModel.setAge( 1 );
            objectTextModel.setName( "Name" );
            objectTextModel.setOccupation( "Occupation" );

            ObjectTextModel objectTextModel2 = new ObjectTextModel( );
            objectTextModel2.setAddress( "42 Main St" );
            objectTextModel2.setAge( 1 );
            objectTextModel2.setName( "Name" );
            objectTextModel2.setOccupation( "Occupation" );
            assertNotEquals( objectTextModel , objectTextModel2 );
        }

    /**
     * Method under test: {@link ObjectTextModel#equals(Object)}
     */
    @Test
    void testEquals7 ( )
        {
            ObjectTextModel objectTextModel = new ObjectTextModel( );
            objectTextModel.setAddress( "42 Main St" );
            objectTextModel.setAge( 3 );
            objectTextModel.setName( "Name" );
            objectTextModel.setOccupation( "Occupation" );

            ObjectTextModel objectTextModel2 = new ObjectTextModel( );
            objectTextModel2.setAddress( "42 Main St" );
            objectTextModel2.setAge( 1 );
            objectTextModel2.setName( "Name" );
            objectTextModel2.setOccupation( "Occupation" );
            assertNotEquals( objectTextModel , objectTextModel2 );
        }

    /**
     * Method under test: {@link ObjectTextModel#equals(Object)}
     */
    @Test
    void testEquals8 ( )
        {
            ObjectTextModel objectTextModel = new ObjectTextModel( );
            objectTextModel.setAddress( "42 Main St" );
            objectTextModel.setAge( 1 );
            objectTextModel.setName( "Occupation" );
            objectTextModel.setOccupation( "Occupation" );

            ObjectTextModel objectTextModel2 = new ObjectTextModel( );
            objectTextModel2.setAddress( "42 Main St" );
            objectTextModel2.setAge( 1 );
            objectTextModel2.setName( "Name" );
            objectTextModel2.setOccupation( "Occupation" );
            assertNotEquals( objectTextModel , objectTextModel2 );
        }

    /**
     * Method under test: {@link ObjectTextModel#equals(Object)}
     */
    @Test
    void testEquals9 ( )
        {
            ObjectTextModel objectTextModel = new ObjectTextModel( );
            objectTextModel.setAddress( "42 Main St" );
            objectTextModel.setAge( 1 );
            objectTextModel.setName( null );
            objectTextModel.setOccupation( "Occupation" );

            ObjectTextModel objectTextModel2 = new ObjectTextModel( );
            objectTextModel2.setAddress( "42 Main St" );
            objectTextModel2.setAge( 1 );
            objectTextModel2.setName( "Name" );
            objectTextModel2.setOccupation( "Occupation" );
            assertNotEquals( objectTextModel , objectTextModel2 );
        }

    /**
     * Method under test: {@link ObjectTextModel#equals(Object)}
     */
    @Test
    void testEquals10 ( )
        {
            ObjectTextModel objectTextModel = new ObjectTextModel( );
            objectTextModel.setAddress( "42 Main St" );
            objectTextModel.setAge( 1 );
            objectTextModel.setName( "Name" );
            objectTextModel.setOccupation( "Name" );

            ObjectTextModel objectTextModel2 = new ObjectTextModel( );
            objectTextModel2.setAddress( "42 Main St" );
            objectTextModel2.setAge( 1 );
            objectTextModel2.setName( "Name" );
            objectTextModel2.setOccupation( "Occupation" );
            assertNotEquals( objectTextModel , objectTextModel2 );
        }

    /**
     * Method under test: {@link ObjectTextModel#equals(Object)}
     */
    @Test
    void testEquals11 ( )
        {
            ObjectTextModel objectTextModel = new ObjectTextModel( );
            objectTextModel.setAddress( "42 Main St" );
            objectTextModel.setAge( 1 );
            objectTextModel.setName( "Name" );
            objectTextModel.setOccupation( null );

            ObjectTextModel objectTextModel2 = new ObjectTextModel( );
            objectTextModel2.setAddress( "42 Main St" );
            objectTextModel2.setAge( 1 );
            objectTextModel2.setName( "Name" );
            objectTextModel2.setOccupation( "Occupation" );
            assertNotEquals( objectTextModel , objectTextModel2 );
        }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ObjectTextModel#equals(Object)}
     *   <li>{@link ObjectTextModel#hashCode()}
     * </ul>
     */
    @Test
    void testEquals12 ( )
        {
            ObjectTextModel objectTextModel = new ObjectTextModel( );
            objectTextModel.setAddress( null );
            objectTextModel.setAge( 1 );
            objectTextModel.setName( "Name" );
            objectTextModel.setOccupation( "Occupation" );

            ObjectTextModel objectTextModel2 = new ObjectTextModel( );
            objectTextModel2.setAddress( null );
            objectTextModel2.setAge( 1 );
            objectTextModel2.setName( "Name" );
            objectTextModel2.setOccupation( "Occupation" );
            assertEquals( objectTextModel , objectTextModel2 );
            int expectedHashCodeResult = objectTextModel.hashCode( );
            assertEquals( expectedHashCodeResult , objectTextModel2.hashCode( ) );
        }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ObjectTextModel#equals(Object)}
     *   <li>{@link ObjectTextModel#hashCode()}
     * </ul>
     */
    @Test
    void testEquals13 ( )
        {
            ObjectTextModel objectTextModel = new ObjectTextModel( );
            objectTextModel.setAddress( "42 Main St" );
            objectTextModel.setAge( 1 );
            objectTextModel.setName( null );
            objectTextModel.setOccupation( "Occupation" );

            ObjectTextModel objectTextModel2 = new ObjectTextModel( );
            objectTextModel2.setAddress( "42 Main St" );
            objectTextModel2.setAge( 1 );
            objectTextModel2.setName( null );
            objectTextModel2.setOccupation( "Occupation" );
            assertEquals( objectTextModel , objectTextModel2 );
            int expectedHashCodeResult = objectTextModel.hashCode( );
            assertEquals( expectedHashCodeResult , objectTextModel2.hashCode( ) );
        }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ObjectTextModel#equals(Object)}
     *   <li>{@link ObjectTextModel#hashCode()}
     * </ul>
     */
    @Test
    void testEquals14 ( )
        {
            ObjectTextModel objectTextModel = new ObjectTextModel( );
            objectTextModel.setAddress( "42 Main St" );
            objectTextModel.setAge( 1 );
            objectTextModel.setName( "Name" );
            objectTextModel.setOccupation( null );

            ObjectTextModel objectTextModel2 = new ObjectTextModel( );
            objectTextModel2.setAddress( "42 Main St" );
            objectTextModel2.setAge( 1 );
            objectTextModel2.setName( "Name" );
            objectTextModel2.setOccupation( null );
            assertEquals( objectTextModel , objectTextModel2 );
            int expectedHashCodeResult = objectTextModel.hashCode( );
            assertEquals( expectedHashCodeResult , objectTextModel2.hashCode( ) );
        }
}

