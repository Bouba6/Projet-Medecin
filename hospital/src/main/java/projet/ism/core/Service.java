package projet.ism.core;

import java.util.List;

public interface Service<T> {

    boolean save(T objet);

    List<T> show();

}
