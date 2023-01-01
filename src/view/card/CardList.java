package view.card;

import controller.AppController;
import entity.Antrag;
import view.AppView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class CardList extends JPanel{


    private JList<Object> list;
    private JTable table;
    private AppView view;
    public CardList(AppView view) {
        this.view = view;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        JLabel title = new JLabel("Alle Anträge");

        JButton btn = new JButton("Nur Antrag 1 anzeigen");
        btn.addActionListener((new AppController(this.view)::index));
        btn.setActionCommand("1");
        btn.setName("testbutton");
        add(title, gbc);
        add(btn, gbc);

        gbc.weightx = 1;
        gbc.weighty = 2;
        gbc.fill = GridBagConstraints.BOTH;
        this.list = new JList<>();
        this.table = new JTable();


        add(new JScrollPane(this.table), gbc);
    }

    public void setContent (ArrayList<Antrag> ar) throws IllegalAccessException {

        ArrayList<String> columnList = new ArrayList<>();

        for (Field field : Antrag.class.getDeclaredFields()){
            if(field.getModifiers() == Modifier.PROTECTED){
                columnList.add(field.getName());
            }
        }

        String[] columns = new String[columnList.size()];
        columns = columnList.toArray(columns);

        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        for(Antrag a : ar){
            ArrayList<Object> objectArrayList = new ArrayList<>();
            int $column = 1;
            for (Field field : a.getClass().getDeclaredFields()) {
                if (field.getModifiers() == Modifier.PROTECTED) {
                    field.setAccessible(true);
                    objectArrayList.add(field.get(a));
                    System.out.println(field.getName() + ": " +field.get(a));
                    field.setAccessible(false);
                }
                $column++;
            }
            Object[] object = objectArrayList.toArray(new Object[objectArrayList.size()]);
            tableModel.addRow(object);
        }

        this.table.setEnabled(false);
        this.table.setModel(tableModel);
    }
}
