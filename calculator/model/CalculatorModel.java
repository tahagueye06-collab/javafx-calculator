package be.kdg.calculator.model;

public class CalculatorModel {
    public static final int RETIREMENT_AGE=67;
    private int birthYear;

    public CalculatorModel() {
        this.birthYear = birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }



    public int getRetirementYear() {
        return birthYear + RETIREMENT_AGE;
    }

    public int getBirthYear() {
        return birthYear;
    }
}
