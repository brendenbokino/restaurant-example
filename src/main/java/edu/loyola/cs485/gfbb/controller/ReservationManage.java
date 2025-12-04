package edu.loyola.cs485.gfbb.controller;

import edu.loyola.cs485.gfbb.model.dao.ReservationDAO;
import edu.loyola.cs485.gfbb.model.entity.Reservation;

import java.text.SimpleDateFormat;
import java.util.List;

public class ReservationManage {

    public void createReservation (String id, String dateTime, String numGuests, String status) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
       // java.sql.Date dateTime = new java.sql.Date(sdf.parse(strDateTime).getTime());

        Reservation reservation = new Reservation;
        reservation.setDateTime(dateTime);
        reservation.setStatus(status);
        reservation.setNumGuests(numGuests);

         ReservationDAO dao = new ReservationDAO();
         dao.create(reservation);

         return reservation;
    }

    public List<Reservation> getAllReservations() throws Exception {
        ReservationDAO dao = new ReservationDAO();
        return dao.list();
    }

    public void deleteClient(int id) throws Exception {
        ReservationDAO dao = new ReservationDAO();
        dao.delete(id);
    }
}
