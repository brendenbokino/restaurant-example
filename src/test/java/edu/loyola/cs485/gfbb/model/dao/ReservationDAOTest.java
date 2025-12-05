package edu.loyola.cs485.gfbb.model.dao;

import edu.loyola.cs485.gfbb.model.entity.Reservation;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ReservationDAOTest {

    @Test
    public void createReservation() throws Exception {
        ReservationDAO dao = new ReservationDAO();
        dao.setTestDatabase();

        Reservation reservation = new Reservation();
        reservation.setDateTime(new java.sql.Timestamp(0));
        reservation.setNumGuests(4);
        reservation.setStatus("Test Status");

        dao.create(reservation); // Method Under Test

        //clean up
        dao.delete( reservation.getId() );

        assertAll(
                () -> assertNotNull( reservation.getId() )
        );
    }

    @Test
    public void getReservation() throws Exception {
        ReservationDAO dao = new ReservationDAO();
        dao.setTestDatabase();

        Reservation res = new Reservation();
        res.setDateTime(new java.sql.Timestamp(0));
        res.setStatus("Test Status");
        res.setNumGuests(6);

        dao.create(res);
        Reservation found = dao.read(res.getId());

        //clean up
        dao.delete( res.getId() );

        assertAll(
                () -> assertEquals(found.getId(), res.getId()),
                () -> assertEquals(found.getDateTime(), res.getDateTime()),
                () -> assertEquals(found.getStatus(), res.getStatus()),
                () -> assertEquals(found.getNumGuests(), res.getNumGuests())
        );
    }

    @Test
    public void getReservationDoesntExist() throws Exception {
        ReservationDAO dao = new ReservationDAO();
        dao.setTestDatabase();

        Reservation found = dao.read(8);
        assertAll(
                () -> assertNull( found.getId() ),
                () -> assertNull( found.getDateTime() )
        );
    }
//
//    @Test
//    public void updateReservation() throws Exception {
//        ReservationDAO dao = new ReservationDAO();
//        dao.setTestDatabase();
//
//        Reservation reservation = new Reservation();
//        reservation.setDateTime(new java.sql.Timestamp(System.currentTimeMillis()));
//        reservation.setNumGuests(3);
//        reservation.setStatus("Test Status");
//
//        dao.create(reservation);
//    }

    @Test
    public void deleteReservation() throws Exception {
        ReservationDAO dao = new ReservationDAO();
        dao.setTestDatabase();

        Reservation reservation = new Reservation();
        reservation.setDateTime(new java.sql.Timestamp(0));
        reservation.setNumGuests(5);
        reservation.setStatus("Test Status");

        dao.create(reservation);

        dao.delete(reservation.getId());

        Reservation found = dao.read(reservation.getId());

        assertAll(
                () -> assertNull(found.getId())
        );
    }

    @Test
    public void getAllReservation() throws Exception{
        ReservationDAO dao = new ReservationDAO();
        dao.setTestDatabase();

        List<Reservation> resList = dao.list();
        assertAll(
                () -> assertEquals(0, resList.size())
        );
    }

}
