package view.card;

import controller.AntragController;
import view.AppView;

import javax.swing.*;
import java.awt.*;

public class CardPane extends JPanel{

    private JButton btn;
    private JTextArea textArea;

    private AppView view;
    public CardPane(AppView view) {
        this.view = view;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        btn = new JButton("Alle Anträge zeigen");
        btn.addActionListener((new AntragController(this.view)::index));
        btn.setActionCommand("1");
        btn.setName("testbutton");
        add(btn, gbc);

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        textArea = new JTextArea(20, 40);
        textArea.setText("Beachte die Ausgaben in der Konsole.");
        add(new JScrollPane(textArea), gbc);
    }

    public void setContent (String s){
        this.textArea.setText(s);
        System.out.println("CardPane: " + s);
    }
}
