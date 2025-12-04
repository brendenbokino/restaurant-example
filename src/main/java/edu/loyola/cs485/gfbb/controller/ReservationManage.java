package edu.loyola.cs485.gfbb.controller;

import edu.loyola.cs485.gfbb.model.dao.ReservationDAO;
import edu.loyola.cs485.gfbb.model.entity.Reservation;

import java.text.SimpleDateFormat;
import java.util.List;

public class ReservationManage {

    public Reservation createReservation (String id, String dateTime, String numGuests, String status) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        java.sql.Timestamp dateAndTime = new java.sql.Timestamp(sdf.parse(dateTime).getTime());

        Reservation reservation = new Reservation();
        reservation.setDateTime(dateAndTime);
        reservation.setStatus(status);
        reservation.setNumGuests(Integer.parseInt(numGuests));

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
