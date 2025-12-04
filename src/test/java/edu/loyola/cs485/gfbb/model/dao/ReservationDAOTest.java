package edu.loyola.cs485.gfbb.model.dao;

import edu.loyola.cs485.gfbb.model.entity.Reservation;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ReservationDAOTest {

    @Test
    public void createReservation() throws Exception {
        ReservationDAO dao = new ReservationDAO();
        dao.setTestDatabase();

        Reservation reservation = new Reservation();
        reservation.setDateTime(new java.sql.Timestamp(System.currentTimeMillis()));
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

    }

    @Test
    public void getReservationDoesntExist() throws Exception {

    }

    @Test
    public void updateReservation() throws Exception {

    }

    @Test
    public void deleteReservation() throws Exception {

    }

}
