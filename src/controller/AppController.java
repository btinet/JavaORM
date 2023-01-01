package controller;

import core.controller.AbstractController;
import entity.Fach;
import entity.Kollegiat;
import view.AppView;

import java.awt.event.ActionEvent;

public class AppController extends AbstractController {

    protected AppView view;

    public AppController(AppView view){
        super(true);
        this.view = view;
        this.repository.setEntity(Fach.class);
    }

    public void index(ActionEvent e){
        repository.setEntity(Kollegiat.class);
        Kollegiat person = (Kollegiat) repository.find(Integer.decode(e.getActionCommand()),"KID");

        System.out.println();
        System.out.println("Class: " + person.getClass().getSimpleName());
        System.out.println("============");
        System.out.println("ID: " + person.getKID());
        System.out.println("Name: " + person.getVorname() + " " + person.getName());
        System.out.println("TutorID: " + person.getTutorID());
        System.out.println("BetreuerID: " + person.getBetreuerID());
        System.out.println("============\n");

        this.view.cardLayout.show(this.view.frame.getContentPane(), "One");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getID());
        this.view.setText("Test");
    }

}
