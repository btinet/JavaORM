import entity.Kollegiat;
import repository.GenericRepository;

import java.util.HashMap;

public class Main {

    public static void main(String[] args){

        /*
         * Instanziere neues allgemeines Repository.
         * Instanz enthält allgemeine Abfragemethoden wie:
         *
         * find(id) ein Datensatz mit id = x.
         * findOneBy(Bedingungen) ein Datensatz mit bestimmten Bedingungen.
         * findBy(Bedingungen, Sortierung) Array mit Datensätzen mit bestimmten Bedingungen und Sortierung.
         * findAll(Sortierung) Array mit allen Datensätzen und bestimmter Sortierung.
         */
        GenericRepository repository = new GenericRepository(true);

        /*
         * Erstelle eine Instanz der Klasse Kollegiat und setze Attribute mit Werten aus Datensatz mit KID = 2;
         */
        Kollegiat person = (Kollegiat) repository.setEntity(new Kollegiat()).find("KID",4);

        /*
         * Neue HashMap 'condition' erzeugen.
         */
        HashMap<String, String> condition = new HashMap<>();

        /*
         * Bedingungen hinzufügen => ...WHERE Vorname = "felix"...
         */
        condition.put("vorname","felix");

        /*
         * Eine Person aus der Tablle 'Kollegiat' suchen, die mit Vornamen 'Felix' heißt.
         */
        Kollegiat person2 = (Kollegiat) repository.setEntity(new Kollegiat()).findOneBy(condition);

        /*
         * Attribute der Instanz in Konsole ausgeben.
         */
        System.out.println("Class: " + person.getClass().getSimpleName());
        System.out.println("============");
        System.out.println("ID: " + person.getKID());
        System.out.println("Name: " + person.getVorname() + " " + person.getName());
        System.out.println("TutorID: " + person.getTutorID());
        System.out.println("BetreuerID: " + person.getBetreuerID());
        System.out.println("============\n");

        System.out.println("Class: " + person2.getClass().getSimpleName());
        System.out.println("============");
        System.out.println("ID: " + person2.getKID());
        System.out.println("Name: " + person2.getVorname() + " " + person2.getName());
        System.out.println("TutorID: " + person2.getTutorID());
        System.out.println("BetreuerID: " + person2.getBetreuerID());
        System.out.println("============\n");
    }

}
