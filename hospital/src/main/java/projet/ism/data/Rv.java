package projet.ism.data;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class Rv {
    private int id;
    private LocalDate date;
    private Medecin medecin;
    private LocalTime heure;

}
