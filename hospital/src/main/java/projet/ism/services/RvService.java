package projet.ism.services;

import java.time.LocalDate;
import java.util.List;

import projet.ism.core.RepositoryRv;
import projet.ism.core.ServiceRv;
import projet.ism.data.Rv;

public class RvService implements ServiceRv {
    public RvService(RepositoryRv repositoryRv) {
        this.repositoryRv = repositoryRv;
    }

    RepositoryRv repositoryRv;

    @Override
    public boolean save(Rv objet) {
        return repositoryRv.insert(objet);
    }

    @Override
    public List<Rv> show() {
        return repositoryRv.selectAll();
    }

    @Override
    public List<Rv> findByDate(LocalDate date) {
        return repositoryRv.filterByDate(date);
    }

}
