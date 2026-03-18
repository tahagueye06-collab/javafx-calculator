package be.kdg.mypaint.view.about;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AboutView extends BorderPane {

    private Button btnOK;
    private Label mylabel;

    public AboutView(){
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes(){
        btnOK= new Button("ok");
        btnOK.setPrefWidth(60);
        mylabel=new Label("Deze aplicatie  is geschreven door taha");
    }

    Button getBtnOK(){
        return btnOK;
    }

    private void layoutNodes() {
        Label myLabel = new Label("Deze applicatie is geschreven door Goofy.");
        myLabel.setFont(new Font(20));
        setTop(myLabel);
        setCenter(new ImageView(new Image("/myPaint.png")));
        setPadding(new Insets(10));
        BorderPane.setAlignment(btnOK, Pos.CENTER);
        BorderPane.setMargin(btnOK, new Insets(10));
        this.setBorder(new Border(new BorderStroke(Color.CORNFLOWERBLUE,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, new BorderWidths(2))));
        setBottom(btnOK);
    }


}
