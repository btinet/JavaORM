package view;

import controller.AppController;
import core.view.AbstractView;

import javax.swing.*;
import java.awt.*;

public class AppView extends AbstractView {

    JLabel label;

    public AppView() {
        super();
        init();
    }

    private void init() {
        label = new JLabel("");
        label.setHorizontalAlignment(JLabel.CENTER);
        JButton button = new JButton("klick");
        JButton button2 = new JButton("klack");
        button.addActionListener(new AppController(this));
        button2.addActionListener(new AppController(this)::index);
        JFrame frame = new JFrame("MVC");
        frame.add(label, FlowLayout.LEFT);
        frame.add(button, FlowLayout.LEFT);
        frame.add(button2, FlowLayout.LEFT);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setText(String s) {
        label.setText(s);
    }

}
