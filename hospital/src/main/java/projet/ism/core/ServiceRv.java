package projet.ism.core;

import java.time.LocalDate;
import java.util.List;

import projet.ism.data.Rv;

public interface ServiceRv extends Service<Rv> {

    List<Rv> findByDate(LocalDate date);

}
