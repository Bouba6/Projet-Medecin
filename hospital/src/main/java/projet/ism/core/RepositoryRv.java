package projet.ism.core;

import java.time.LocalDate;
import java.util.List;

import projet.ism.data.Rv;

public interface RepositoryRv extends Repository<Rv> {
    List<Rv> filterByDate(LocalDate date);

}
