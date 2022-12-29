import entity.Kollegiat;
import repository.GenericRepository;

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
        Kollegiat person = (Kollegiat) repository.setEntity(new Kollegiat()).find("KID",2);

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
    }

}
