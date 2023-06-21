package com.hilquiascamelo.strproducer.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class LogEntityTest {
    /**
     * Method under test: {@link LogEntity#canEqual(Object)}
     */
    @Test
    void testCanEqual ( )
        {
            assertFalse( (new LogEntity( )).canEqual( "Other" ) );
        }

    /**
     * Method under test: {@link LogEntity#canEqual(Object)}
     */
    @Test
    void testCanEqual2 ( )
        {
            LogEntity logEntity = new LogEntity( );
            logEntity.setId( 1L );
            logEntity.setLogLevel( "Log Level" );
            logEntity.setMessage( "Not all who wander are lost" );
            logEntity.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );

            LogEntity logEntity2 = new LogEntity( );
            logEntity2.setId( 1L );
            logEntity2.setLogLevel( "Log Level" );
            logEntity2.setMessage( "Not all who wander are lost" );
            logEntity2.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            assertTrue( logEntity.canEqual( logEntity2 ) );
        }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link LogEntity}
     *   <li>{@link LogEntity#setId(Long)}
     *   <li>{@link LogEntity#setLogLevel(String)}
     *   <li>{@link LogEntity#setMessage(String)}
     *   <li>{@link LogEntity#setTimestamp(LocalDateTime)}
     *   <li>{@link LogEntity#toString()}
     *   <li>{@link LogEntity#getId()}
     *   <li>{@link LogEntity#getLogLevel()}
     *   <li>{@link LogEntity#getMessage()}
     *   <li>{@link LogEntity#getTimestamp()}
     * </ul>
     */
    @Test
    void testConstructor ( )
        {
            LogEntity actualLogEntity = new LogEntity( );
            actualLogEntity.setId( 1L );
            actualLogEntity.setLogLevel( "Log Level" );
            actualLogEntity.setMessage( "Not all who wander are lost" );
            LocalDateTime
                    timestamp =
                    LocalDate.of( 1970 , 1 , 1 )
                            .atStartOfDay( );
            actualLogEntity.setTimestamp( timestamp );
            String actualToStringResult = actualLogEntity.toString( );
            assertEquals( 1L , actualLogEntity.getId( )
                    .longValue( ) );
            assertEquals( "Log Level" , actualLogEntity.getLogLevel( ) );
            assertEquals( "Not all who wander are lost" , actualLogEntity.getMessage( ) );
            assertSame( timestamp , actualLogEntity.getTimestamp( ) );
            assertEquals(
                    "LogEntity(id=1, message=Not all who wander are lost, logLevel=Log Level, timestamp=1970-01-01T00:00)" ,
                    actualToStringResult );
        }

    /**
     * Method under test: {@link LogEntity#equals(Object)}
     */
    @Test
    void testEquals ( )
        {
            LogEntity logEntity = new LogEntity( );
            logEntity.setId( 1L );
            logEntity.setLogLevel( "Log Level" );
            logEntity.setMessage( "Not all who wander are lost" );
            logEntity.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            assertNotEquals( logEntity , null );
        }

    /**
     * Method under test: {@link LogEntity#equals(Object)}
     */
    @Test
    void testEquals2 ( )
        {
            LogEntity logEntity = new LogEntity( );
            logEntity.setId( 1L );
            logEntity.setLogLevel( "Log Level" );
            logEntity.setMessage( "Not all who wander are lost" );
            logEntity.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            assertNotEquals( logEntity , "Different type to LogEntity" );
        }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LogEntity#equals(Object)}
     *   <li>{@link LogEntity#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3 ( )
        {
            LogEntity logEntity = new LogEntity( );
            logEntity.setId( 1L );
            logEntity.setLogLevel( "Log Level" );
            logEntity.setMessage( "Not all who wander are lost" );
            logEntity.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            assertEquals( logEntity , logEntity );
            int expectedHashCodeResult = logEntity.hashCode( );
            assertEquals( expectedHashCodeResult , logEntity.hashCode( ) );
        }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LogEntity#equals(Object)}
     *   <li>{@link LogEntity#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4 ( )
        {
            LogEntity logEntity = new LogEntity( );
            logEntity.setId( 1L );
            logEntity.setLogLevel( "Log Level" );
            logEntity.setMessage( "Not all who wander are lost" );
            logEntity.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );

            LogEntity logEntity2 = new LogEntity( );
            logEntity2.setId( 1L );
            logEntity2.setLogLevel( "Log Level" );
            logEntity2.setMessage( "Not all who wander are lost" );
            logEntity2.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            assertEquals( logEntity , logEntity2 );
            int expectedHashCodeResult = logEntity.hashCode( );
            assertEquals( expectedHashCodeResult , logEntity2.hashCode( ) );
        }

    /**
     * Method under test: {@link LogEntity#equals(Object)}
     */
    @Test
    void testEquals5 ( )
        {
            LogEntity logEntity = new LogEntity( );
            logEntity.setId( 2L );
            logEntity.setLogLevel( "Log Level" );
            logEntity.setMessage( "Not all who wander are lost" );
            logEntity.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );

            LogEntity logEntity2 = new LogEntity( );
            logEntity2.setId( 1L );
            logEntity2.setLogLevel( "Log Level" );
            logEntity2.setMessage( "Not all who wander are lost" );
            logEntity2.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            assertNotEquals( logEntity , logEntity2 );
        }

    /**
     * Method under test: {@link LogEntity#equals(Object)}
     */
    @Test
    void testEquals6 ( )
        {
            LogEntity logEntity = new LogEntity( );
            logEntity.setId( null );
            logEntity.setLogLevel( "Log Level" );
            logEntity.setMessage( "Not all who wander are lost" );
            logEntity.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );

            LogEntity logEntity2 = new LogEntity( );
            logEntity2.setId( 1L );
            logEntity2.setLogLevel( "Log Level" );
            logEntity2.setMessage( "Not all who wander are lost" );
            logEntity2.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            assertNotEquals( logEntity , logEntity2 );
        }

    /**
     * Method under test: {@link LogEntity#equals(Object)}
     */
    @Test
    void testEquals7 ( )
        {
            LogEntity logEntity = new LogEntity( );
            logEntity.setId( 1L );
            logEntity.setLogLevel( "Not all who wander are lost" );
            logEntity.setMessage( "Not all who wander are lost" );
            logEntity.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );

            LogEntity logEntity2 = new LogEntity( );
            logEntity2.setId( 1L );
            logEntity2.setLogLevel( "Log Level" );
            logEntity2.setMessage( "Not all who wander are lost" );
            logEntity2.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            assertNotEquals( logEntity , logEntity2 );
        }

    /**
     * Method under test: {@link LogEntity#equals(Object)}
     */
    @Test
    void testEquals8 ( )
        {
            LogEntity logEntity = new LogEntity( );
            logEntity.setId( 1L );
            logEntity.setLogLevel( null );
            logEntity.setMessage( "Not all who wander are lost" );
            logEntity.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );

            LogEntity logEntity2 = new LogEntity( );
            logEntity2.setId( 1L );
            logEntity2.setLogLevel( "Log Level" );
            logEntity2.setMessage( "Not all who wander are lost" );
            logEntity2.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            assertNotEquals( logEntity , logEntity2 );
        }

    /**
     * Method under test: {@link LogEntity#equals(Object)}
     */
    @Test
    void testEquals9 ( )
        {
            LogEntity logEntity = new LogEntity( );
            logEntity.setId( 1L );
            logEntity.setLogLevel( "Log Level" );
            logEntity.setMessage( "Log Level" );
            logEntity.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );

            LogEntity logEntity2 = new LogEntity( );
            logEntity2.setId( 1L );
            logEntity2.setLogLevel( "Log Level" );
            logEntity2.setMessage( "Not all who wander are lost" );
            logEntity2.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            assertNotEquals( logEntity , logEntity2 );
        }

    /**
     * Method under test: {@link LogEntity#equals(Object)}
     */
    @Test
    void testEquals10 ( )
        {
            LogEntity logEntity = new LogEntity( );
            logEntity.setId( 1L );
            logEntity.setLogLevel( "Log Level" );
            logEntity.setMessage( null );
            logEntity.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );

            LogEntity logEntity2 = new LogEntity( );
            logEntity2.setId( 1L );
            logEntity2.setLogLevel( "Log Level" );
            logEntity2.setMessage( "Not all who wander are lost" );
            logEntity2.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            assertNotEquals( logEntity , logEntity2 );
        }

    /**
     * Method under test: {@link LogEntity#equals(Object)}
     */
    @Test
    void testEquals11 ( )
        {
            LogEntity logEntity = new LogEntity( );
            logEntity.setId( 1L );
            logEntity.setLogLevel( "Log Level" );
            logEntity.setMessage( "Not all who wander are lost" );
            logEntity.setTimestamp( LocalDate.now( )
                    .atStartOfDay( ) );

            LogEntity logEntity2 = new LogEntity( );
            logEntity2.setId( 1L );
            logEntity2.setLogLevel( "Log Level" );
            logEntity2.setMessage( "Not all who wander are lost" );
            logEntity2.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            assertNotEquals( logEntity , logEntity2 );
        }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LogEntity#equals(Object)}
     *   <li>{@link LogEntity#hashCode()}
     * </ul>
     */
    @Test
    void testEquals12 ( )
        {
            LogEntity logEntity = new LogEntity( );
            logEntity.setId( null );
            logEntity.setLogLevel( "Log Level" );
            logEntity.setMessage( "Not all who wander are lost" );
            logEntity.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );

            LogEntity logEntity2 = new LogEntity( );
            logEntity2.setId( null );
            logEntity2.setLogLevel( "Log Level" );
            logEntity2.setMessage( "Not all who wander are lost" );
            logEntity2.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            assertEquals( logEntity , logEntity2 );
            int expectedHashCodeResult = logEntity.hashCode( );
            assertEquals( expectedHashCodeResult , logEntity2.hashCode( ) );
        }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LogEntity#equals(Object)}
     *   <li>{@link LogEntity#hashCode()}
     * </ul>
     */
    @Test
    void testEquals13 ( )
        {
            LogEntity logEntity = new LogEntity( );
            logEntity.setId( 1L );
            logEntity.setLogLevel( null );
            logEntity.setMessage( "Not all who wander are lost" );
            logEntity.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );

            LogEntity logEntity2 = new LogEntity( );
            logEntity2.setId( 1L );
            logEntity2.setLogLevel( null );
            logEntity2.setMessage( "Not all who wander are lost" );
            logEntity2.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            assertEquals( logEntity , logEntity2 );
            int expectedHashCodeResult = logEntity.hashCode( );
            assertEquals( expectedHashCodeResult , logEntity2.hashCode( ) );
        }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LogEntity#equals(Object)}
     *   <li>{@link LogEntity#hashCode()}
     * </ul>
     */
    @Test
    void testEquals14 ( )
        {
            LogEntity logEntity = new LogEntity( );
            logEntity.setId( 1L );
            logEntity.setLogLevel( "Log Level" );
            logEntity.setMessage( null );
            logEntity.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );

            LogEntity logEntity2 = new LogEntity( );
            logEntity2.setId( 1L );
            logEntity2.setLogLevel( "Log Level" );
            logEntity2.setMessage( null );
            logEntity2.setTimestamp( LocalDate.of( 1970 , 1 , 1 )
                    .atStartOfDay( ) );
            assertEquals( logEntity , logEntity2 );
            int expectedHashCodeResult = logEntity.hashCode( );
            assertEquals( expectedHashCodeResult , logEntity2.hashCode( ) );
        }
}

