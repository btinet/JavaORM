package controller;

import core.controller.AbstractController;
import entity.Antrag;
import repository.AntragRepository;
import view.AppView;
import view.card.CardList;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class AntragController extends AbstractController {

    protected AppView view;
    public AntragController(AppView view) {
        super(true);
        this.view = view;
        this.repository = new AntragRepository(true);
    }

    public void index(ActionEvent e){
        ArrayList<Antrag> antragList = (ArrayList<Antrag>) repository.findAll();

        // TODO: für jeden Datensatz soll ein Button erstellt werden, der zur Methode 'show' führt.


        CardList cardList = new CardList(this.view);
        try {
            cardList.setContent(antragList);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }

        this.view.frame.add(cardList,"list");
        this.view.cardLayout.show(this.view.frame.getContentPane(), "list");


    }

    public void show(ActionEvent e){
        // Der auslösende Button enthält die id des gesuchten Datensatzes
        Antrag antrag = (Antrag) repository.find(Integer.decode(e.getActionCommand()),"AID");
        System.out.println(antrag.getAID() + " " + antrag.getTID() + " " + antrag.getKID() + " " + antrag.getGenehmigtAm());
        this.view.setContent(antrag.getAID() + " " + antrag.getTID() + " " + antrag.getKID() + " " + antrag.getGenehmigtAm());
    }

    public void update(ActionEvent e){
        Antrag antrag = (Antrag) repository.find(Integer.parseInt(e.getActionCommand()));
    }

    public void delete(ActionEvent e){
        Antrag antrag = (Antrag) repository.find(Integer.parseInt(e.getActionCommand()));
    }


}
