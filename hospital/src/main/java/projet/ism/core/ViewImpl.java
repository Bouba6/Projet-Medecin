package projet.ism.core;

import java.util.logging.Logger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

public abstract class ViewImpl<T> implements Views<T> {
    protected Scanner scanner;
    private Logger logger = Logger.getLogger(ViewImpl.class.getName());

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void afficher(List<T> datas) {
        if (logger.isLoggable(Level.OFF)) {
            for (T data : datas) {
                logger.info(data.toString());
            }
        }

    }

    public static LocalDate formatDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date, formatter);
    }

    public static LocalTime formatHeure(String heure) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(heure, formatter);
    }

}
