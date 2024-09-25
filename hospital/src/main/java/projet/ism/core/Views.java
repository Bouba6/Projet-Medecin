package projet.ism.core;

import java.util.List;

public interface Views<T> {
    T saisie();

    void afficher(List<T> list);
}
