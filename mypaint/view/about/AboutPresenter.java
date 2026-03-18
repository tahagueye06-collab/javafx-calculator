package be.kdg.mypaint.view.about;

import be.kdg.mypaint.model.PaintModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AboutPresenter {
    private PaintModel model;
    private AboutView view;

    public AboutPresenter(AboutView view, PaintModel model) {
        this.view = view;
        this.model = model;
        addEventhandlers();
       // updateView();
    }

    private void addEventhandlers(){
        view.getBtnOK().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                view.getScene().getWindow().hide();
            }
        });
    }
}

//private void updateView(){
    // dit is niet van toepassing
//}
