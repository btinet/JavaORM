import entity.Antrag;
import entity.Kollegiat;
import entity.ThemaFach;
import repository.GenericRepository;

import java.util.ArrayList;
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
        GenericRepository repository = new GenericRepository(true); // CamelCase statt snake_case

        /*
         * Entitätsmenge für die kommenden Abfragen setzen. (Klasse muss von AbstractEntity erben)
         */
        repository.setEntity(Kollegiat.class);

        /*
         * Erstelle eine Instanz der Klasse Kollegiat und setze Attribute mit Werten aus Datensatz mit KID = 2.
         * Das Setzen der Entitätsmenge kann auch inline erfolgen insofern vorher eine andere Entität verwendet wurde:
         * Kollegiat person = (Kollegiat) repository.setEntity(new Kollegiat()).find("KID",4);
         */
        Kollegiat person = (Kollegiat) repository.find(4,"KID");

        /*
         * Neue HashMap 'condition' erzeugen.
         */
        HashMap<String, String> condition = new HashMap<>();
        /*
         * Bedingungen hinzufügen => ...WHERE Vorname = "felix"...
         */
        condition.put("Vorname","felix");
        /*
         * Eine Person in der Tabelle 'Kollegiat' suchen, die mit Vornamen 'Felix' heißt.
         */
        Kollegiat person2 = (Kollegiat) repository.findOneBy(condition);
        /*
         * 'Antrag' als neue Entitätsmenge festlegen.
         */
        repository.setEntity(Antrag.class);

        /*
         * Finde einen Antrag, der von person2 erstellt wurde.
         */
        HashMap<String, String> antragCondition = new HashMap<>();
        antragCondition.put("KID",Integer.toString(person2.getKID()));
        Antrag antrag = (Antrag) repository.findOneBy(antragCondition);


        /*
         * Finde alle Datensätze, die folgende Bedingungen erfüllen:
         */
        HashMap<String, String> groupCondition = new HashMap<>();
        groupCondition.put("TutorID","5");
        groupCondition.put("BetreuerID","8");

        repository.setEntity(Kollegiat.class);
        ArrayList<Kollegiat> kollegiaten = (ArrayList<Kollegiat>) repository.findBy(groupCondition);

        System.out.println();
        System.out.println("Kollegiaten mit TutorID = 5 und BetreuerID = 8:");
        System.out.println("============");

        /*
         * Den Namen jedes Kollegiaten ausgeben, der obige Bedingungen erfüllt.
         */
        for (Kollegiat kollegiat : kollegiaten){
            System.out.println(kollegiat.getVorname() + " " +kollegiat.getName());
        }

        repository.setEntity(ThemaFach.class);

        ThemaFach themaFach = (ThemaFach) repository.find(2,"TFID");

        System.out.println();
        System.out.println("Class: " + themaFach.getClass().getSimpleName());
        System.out.println("============");
        System.out.println("TFID: " + themaFach.getTFID());
        System.out.println("Thema: " + themaFach.getThema());
        System.out.println("Fach: " + themaFach.getFach());
        if(themaFach.getIstRefFach()){
            System.out.println("Fach ist Referenzfach");
        } else {
            System.out.println("Fach ist Begleitfach");
        }


        /*
         * Attribute der Instanz in Konsole ausgeben.
         */
        System.out.println();
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
        System.out.println("------------");
        System.out.println("AntragID: " + antrag.getAID());
        System.out.println("Einzelprüfung: " + antrag.getAlsEinzelprüfung());
        System.out.println("Genehmigt am: " + antrag.getGenehmigtAm());
        System.out.println("TutorID: " + antrag.getTID());
        System.out.println("KollegiatID: " + antrag.getKID());
        System.out.println("============\n");


    }

}
