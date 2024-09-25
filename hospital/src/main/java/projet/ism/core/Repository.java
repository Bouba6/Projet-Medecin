package projet.ism.core;

import java.util.List;

public interface Repository<T> {
    boolean insert(T objet);

    List<T> selectAll();
}
