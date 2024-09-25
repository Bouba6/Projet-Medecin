package projet.ism.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projet.ism.core.Repository;
import projet.ism.core.RepositoryMedecin;
import projet.ism.data.Medecin;
import projet.ism.data.Rv;

public class MedecinRepository implements RepositoryMedecin {
    Connection connection;
    private static final String url = "jdbc:postgresql://localhost:5433/Projet-Dette";
    private static final String user = "postgres";
    private static final String password = "root";
    protected PreparedStatement stm;

    @Override
    public boolean insert(Medecin objet) {
        String sql = "INSERT INTO medecin (nom,prenom) VALUES ('" + objet.getNom() + "','" + objet.getPrenom() + "')";
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
    public List<Medecin> selectAll() {
        String sql = "SELECT * FROM medecin";
        try {
            connection = setConnexion();

            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            List<Medecin> medecins = new ArrayList<>();
            while (rs.next()) {
                Medecin medecin = new Medecin();
                medecin.setId(rs.getInt("id"));
                medecin.setNom(rs.getString("nom"));
                medecin.setPrenom(rs.getString("prenom"));
                medecins.add(medecin);
            }
            return medecins;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Medecin SelectById(int id) {
        String sql = "SELECT * FROM Medecin WHERE id = ?";
        try {
            connection = setConnexion();
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                Medecin medecin = new Medecin();
                medecin.setNom(rs.getString("nom"));
                medecin.setPrenom(rs.getString("prenom"));
                return medecin;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
