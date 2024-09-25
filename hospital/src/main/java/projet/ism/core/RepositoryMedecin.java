package projet.ism.core;

import projet.ism.data.Medecin;

public interface RepositoryMedecin extends Repository<Medecin> {
    Medecin SelectById(int id);

}
