package projet.ism.data;

import java.util.List;

import lombok.Data;

@Data
public class Medecin {
    private int id;
    private String nom;
    private String prenom;
    private List<Rv> rv;

}
