package projet.ism.core;

import projet.ism.data.Medecin;

public interface ServiceMedecin extends Service<Medecin> {
    Medecin findById(int id);

}
