package be.kdg.calculator;

import be.kdg.calculator.model.CalculatorModel;
import be.kdg.calculator.view.CalculatorPresenter;
import be.kdg.calculator.view.CalculatorView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main  extends Application {







    @Override
    public void start(Stage stage) throws Exception {
        CalculatorModel model=new CalculatorModel();
        CalculatorView view=new CalculatorView();
        CalculatorPresenter presenter=new CalculatorPresenter(model,view);
        stage.setScene(new Scene(view));
        presenter.addWindowEventHandlers();
        stage.show();


        stage.setTitle("Retirement calculator");


    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
