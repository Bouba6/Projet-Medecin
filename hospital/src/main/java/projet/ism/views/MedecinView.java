package projet.ism.views;

import java.util.ArrayList;
import java.util.List;

import projet.ism.core.ViewImpl;
import projet.ism.data.Medecin;
import projet.ism.data.Rv;

public class MedecinView extends ViewImpl<Medecin> {
    // RvView rvView = new RvView();

    @Override
    public Medecin saisie() {
        Medecin medecin = new Medecin();
        System.out.println("Saisir le nom du medecin : ");
        medecin.setNom(scanner.next());
        System.out.println("Saisir le prenom du medecin : ");
        medecin.setPrenom(scanner.next());
        medecin.setRv(asking());
        return medecin;
    }

    private List<Rv> asking() {
        int resp = scanner.nextInt();
        List<Rv> rvList = new ArrayList<>();
        do {
            System.out.println("Voulez-vous ajouter des rendez-vous ? 1-OUI 2-non");
            resp = scanner.nextInt();
            // Rv rv = rvView.saisie();
            // rvList.add(rv);
        } while (resp == 1);
        return rvList;
    }

}
