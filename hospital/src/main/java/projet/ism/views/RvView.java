package projet.ism.views;

import projet.ism.core.ViewImpl;
import projet.ism.data.Medecin;
import projet.ism.data.Rv;
import projet.ism.services.MedecinService;

public class RvView extends ViewImpl<Rv> {
    MedecinService medecinService;

    public RvView(MedecinService medecinService) {
        this.medecinService = medecinService;
    }

    @Override
    public Rv saisie() {
        Rv rv = new Rv();
        System.out.println("Entrter la date du rendez-vous : ");
        rv.setDate(ViewImpl.formatDate(scanner.next()));
        System.out.println("Entrter l'heure du rendez-vous : ");
        rv.setHeure(ViewImpl.formatHeure(scanner.next()));
        rv.setMedecin(askId());

        return rv;
    }

    private Medecin askId() {
        System.out.println("Entrter l'id du medecin : ");
        int resp = scanner.nextInt();
        Medecin medecin = medecinService.findById(resp);
        if (medecin == null) {
            System.out.println("medecin introuvable");
            askId();
        }
        return medecin;
    }

}
