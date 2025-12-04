package edu.loyola.cs485.gfbb.model.dao;

import edu.loyola.cs485.gfbb.model.entity.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO extends AbstractDAO<Reservation> {
    @Override
    public void create(Reservation entity) throws SQLException {
        Connection con = getConnection(); // Always open a connection
        String sql = "INSERT INTO reservation (dt_reservation, status_reservation, num_guests) VALUES (?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        pst.setTimestamp(1, entity.getDateTime());
        pst.setString(2, entity.getStatus());
        pst.setInt(3, entity.getNumGuests());
        pst.executeUpdate();

        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            entity.setId(rs.getInt(1));
        }

        con.close(); // Dont forget to close it
    }

    @Override
    public Reservation read(int ID) throws SQLException {
        Reservation reservation = new Reservation();
        Connection con = getConnection();
        String sql = "SELECT * FROM reservation WHERE id_reservation = ?";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, ID);
        ResultSet Rs = pst.executeQuery();
        if (Rs.next()) { //IF because there should be 1 or 0 results
            reservation.setId( Rs.getInt("id_reservation") );
            reservation.setStatus( Rs.getString("status_reservation") );
            reservation.setDateTime( Rs.getTimestamp("dt_reservation") );
            reservation.setNumGuests( Rs.getInt("num_guests") );
        }

        con.close();
        return reservation;
    }

    @Override
    public void update(Reservation entity) throws SQLException {
        Connection con = getConnection();

        String sql = "UPDATE reservation " +
                "SET status_reservation = ?, num_guests = ?, dt_reservation = ?" +
                " WHERE id_reservation = ?";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, entity.getStatus());
        pst.setInt(2, entity.getNumGuests());
        pst.setTimestamp(3, entity.getDateTime());
        pst.setInt(4, entity.getId());
        pst.executeUpdate();

        con.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection con = getConnection();
        String sql = "DELETE FROM reservation WHERE id_client = ?";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, id);
        pst.executeUpdate();

        con.close();
    }

    @Override
    public List<Reservation> list() throws SQLException {
        ArrayList<Reservation> listReservation = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT * FROM reservation ORDER BY id_reservation ";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Reservation r = new Reservation();
            r.setId( rs.getInt("id_reservation") );
            r.setDateTime( rs.getTimestamp("dt_reservation") );
            r.setStatus( rs.getString("status_reservation") );
            r.setNumGuests( rs.getInt("numGuests") );

            listReservation.add( r );
        }

        return listReservation;
    }
}
