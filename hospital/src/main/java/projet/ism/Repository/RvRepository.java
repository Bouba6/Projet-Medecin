package projet.ism.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import projet.ism.core.Repository;
import projet.ism.core.RepositoryRv;
import projet.ism.data.Medecin;
import projet.ism.data.Rv;

public class RvRepository implements RepositoryRv {
    Connection connection;
    private static final String url = "jdbc:postgresql://localhost:5433/Projet-Dette";
    private static final String user = "postgres";
    private static final String password = "root";
    private PreparedStatement stm;

    @Override
    public boolean insert(Rv objet) {
        String sql = "INSERT INTO medecin (date,heure) VALUES ('" + objet.getDate() + "','" + objet.getHeure() + "')";
        try {
            connection = setConnexion();
            stm = connection.prepareStatement(sql);
            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Connection setConnexion() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Rv> selectAll() {
        String sql = "SELECT * FROM Rv";
        try {
            connection = setConnexion();

            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            List<Rv> Rvs = new ArrayList<>();
            while (rs.next()) {
                Rv rv = new Rv();
                rv.setDate(rs.getDate("date").toLocalDate());
                rv.setHeure(rs.getTime("heure").toLocalTime());
                Rvs.add(rv);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Rv> filterByDate(LocalDate date) {
        String sql = "SELECT * FROM Rv WHERE date = ?";
        try {
            connection = setConnexion();
            stm = connection.prepareStatement(sql);
            stm.setDate(1, java.sql.Date.valueOf(date));
            ResultSet rs = stm.executeQuery();
            List<Rv> Rvs = new ArrayList<>();
            while (rs.next()) {
                Rv rv = new Rv();
                rv.setDate(rs.getDate("date").toLocalDate());
                rv.setHeure(rs.getTime("heure").toLocalTime());
                Rvs.add(rv);
            }
            return Rvs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
