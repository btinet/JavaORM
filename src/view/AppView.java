package view;

import core.view.AbstractView;

public class AppView extends AbstractView {

    public AppView() {
        super();
        super.view = this;
        super.init();
    }

    public void setText(String s) {
        label.setText(s);
    }

    public void setContent(String s) {
        this.cardPane.setContent(s);
        this.label.setText(s);
        this.cardLayout.show(frame.getContentPane(), "One");
        System.out.println(s);
    }

}
