package be.kdg.calculator.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class CalculatorView extends BorderPane {

    private TextField textField;
    private Button button;
    private Label label;

    public CalculatorView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes(){
        textField = new TextField();
        textField.setPrefColumnCount(4);
        button=new Button("Birthyear > Retirement year");
        label=new Label("");



    }

    private void layoutNodes(){
        BorderPane.setMargin(textField,new Insets(10));
        BorderPane.setMargin(button,new Insets(10));
        BorderPane.setMargin(label,new Insets(10));


        this.setLeft(textField);
        this.setCenter(button);
        this.setRight(label);


    }

    public TextField getTextField() {
        return textField;
    }

    public Button getButton() {
        return button;
    }

    public Label getLabel() {
        return label;
    }
}
