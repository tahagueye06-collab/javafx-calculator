package be.kdg.calculator.view;

import be.kdg.calculator.model.CalculatorModel;

public class CalculatorPresenter {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorPresenter(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers(){
        view.getButton().setOnAction(actionEvent -> {
            String input=view.getTextField().getText();
            int birthYear=Integer.parseInt(input);
            model.setBirthYear(birthYear);
            updateView();
        });
    }

    private void updateView(){
        view.getLabel().setText(String.valueOf(model.getRetirementYear()));

    }

    public void addWindowEventHandlers(){

    }
}
