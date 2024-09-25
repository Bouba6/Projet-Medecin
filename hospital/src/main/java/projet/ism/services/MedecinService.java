package projet.ism.services;

import java.util.List;

import projet.ism.core.Repository;
import projet.ism.core.RepositoryMedecin;
import projet.ism.core.ServiceMedecin;
import projet.ism.data.Medecin;

public class MedecinService implements ServiceMedecin {
    RepositoryMedecin repository;

    public MedecinService(RepositoryMedecin repository) {
        this.repository = repository;
    }

    @Override
    public boolean save(Medecin objet) {
        return repository.insert(objet);

    }

    @Override
    public List<Medecin> show() {
        return repository.selectAll();
    }

    @Override
    public Medecin findById(int id) {
        return repository.SelectById(id);
    }

}
