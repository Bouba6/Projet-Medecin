package projet.ism;

import java.util.Scanner;

import projet.ism.Repository.MedecinRepository;
import projet.ism.Repository.RvRepository;
import projet.ism.core.Repository;
import projet.ism.core.RepositoryMedecin;
import projet.ism.core.RepositoryRv;
import projet.ism.core.ViewImpl;
import projet.ism.services.MedecinService;
import projet.ism.services.RvService;
import projet.ism.views.MedecinView;
import projet.ism.views.RvView;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        RepositoryMedecin repositoryMed = new MedecinRepository();
        RepositoryRv repositoryRv = new RvRepository();

        MedecinService medecinService = new MedecinService(repositoryMed);
        RvService rvService = new RvService(repositoryRv);
        RvView rvView = new RvView(medecinService);
        MedecinView medecinView = new MedecinView();

        int choix;
        do {
            choix = menu();
            switch (choix) {
                case 1: {
                    medecinService.save(medecinView.saisie());
                    break;
                }
                case 2: {
                    rvService.show();
                    break;
                }
                case 3: {
                    rvService.save(rvView.saisie());
                }
                case 4: {
                    rvService.findByDate(ViewImpl.formatDate(scanner.next()));
                    break;
                }

            }
        } while (choix != 5);

    }

    public static int menu() {
        System.out.println("1---Créer un Medecin");
        System.out.println("2---Lister Rv");
        System.out.println("3---Creer un rv");
        System.out.println("4---filter par date");
        System.out.println("5---Quitter");
        ;

        System.out.println("--QUITTER");
        return scanner.nextInt();
    }
}