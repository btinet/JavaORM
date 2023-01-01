package core.controller;

import core.model.AbstractRepositoryFactory;
import repository.GenericRepository;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractController implements ActionListener {

    protected AbstractRepositoryFactory repository;

    public AbstractController(Boolean naturalCase){
        repository = new GenericRepository(naturalCase);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
