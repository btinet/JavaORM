package core.view;

import view.AppView;
import view.card.CardPane;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractView {

    protected JLabel label;

    protected String text = "";

    public JFrame frame;

    public CardLayout cardLayout;

    protected CardPane cardPane;

    protected AppView view;

    public AbstractView() {
    }

    protected void init() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }



        this.label = new JLabel("Bla");
        this.label.setHorizontalAlignment(JLabel.CENTER);

        this.frame = new JFrame("eSchool Manager");
        this.cardPane = new CardPane(this.view);


        this.cardLayout = new CardLayout();
        this.frame.setLayout(this.cardLayout);
        this.frame.add(cardPane, "One");
        this.frame.add(this.label,"Two");

        // Setze Inhalt nach Name. Hier kann die Ansicht beeinflusst werden.
        this.cardLayout.show(frame.getContentPane(), "One");

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }

}
