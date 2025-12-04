package edu.loyola.cs485.gfbb.model.dao;

import edu.loyola.cs485.gfbb.model.entity.Reservation;

import java.sql.*;
import java.util.List;

public class ReservationDAO extends AbstractDAO<Reservation> {
    @Override
    public void create(Reservation entity) throws SQLException {
        Connection con = getConnection(); // Always open a connection

        String sql = "INSERT INTO Reservation (dt_reservation, status_reservation, num_guests) VALUES (?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setTimestamp(1, entity.getDateTime());
        pst.setString(2, entity.getStatus());
        pst.setString(3, entity.getStatus());
        pst.executeUpdate();

        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            entity.setId(rs.getInt(1));
        }

        con.close(); // Dont forget to close it
    }

    @Override
    public Reservation read(int ID) throws SQLException {
        return null;
    }

    @Override
    public void update(Reservation entity) throws SQLException {

    }

    @Override
    public void delete(int ID) throws SQLException {

    }

    @Override
    public List<Reservation> list() throws SQLException {
        return List.of();
    }
}
