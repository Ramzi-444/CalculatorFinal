package com.tool.calculator;

import com.tool.calculator.solver.Solver;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class CalculatorController {

    @FXML
    private TextField inputField;

    @FXML
    private TextField outputField;

    @FXML
    private Label equalLabel;


    private boolean isDisplayingAns = false;

    TextField getInputField() {
        return inputField;
    }

    @FXML
    void ansBtn() {
        reset();
        if(!outputField.getText().equals("")){
            inputField.setText( inputField.getText() + outputField.getText());
        }
    }

    @FXML
    void add() {
        reset();
        inputField.setText( inputField.getText() + "+");
    }

    @FXML
    void backspace() {
        reset();
        int length = inputField.getLength();
        if(length != 0) {
            inputField.setText(inputField.getText(0, length-1));
        }
    }

    @FXML
    void clear() {
        inputField.clear();
        outputField.clear();
        equalLabel.setVisible(false);
    }

    @FXML
    void closeParentheses() {
        reset();
        inputField.setText( inputField.getText() + ")");
    }

    @FXML
    void divide() {
        reset();
        inputField.setText( inputField.getText() + "÷");
    }

    @FXML
    void dot() {
        reset();
        inputField.setText( inputField.getText() + ".");
    }

    @FXML
    void equal() {
        Solver solver = new Solver(inputField.getText());
        outputField.setText(solver.getAnswer());
        isDisplayingAns = true;
        equalLabel.setVisible(true);
    }

    @FXML
    void minus() {
        reset();
        inputField.setText( inputField.getText() + "-");
    }

    @FXML
    void openParentheses() {
        reset();
        inputField.setText( inputField.getText() + "(");
    }

    @FXML
    void percentage() {
        reset();
        inputField.setText( inputField.getText() + "%");
    }

    @FXML
    void pressing1Btn() {
        reset();
        inputField.setText( inputField.getText() + "1");
    }

    @FXML
    void pressing2Btn() {
        reset();
        inputField.setText( inputField.getText() + "2");
    }

    @FXML
    void pressing3Btn() {
        reset();
        inputField.setText( inputField.getText() + "3");
    }

    @FXML
    void pressing4Btn() {
        reset();
        inputField.setText( inputField.getText() + "4");
    }

    @FXML
    void pressing5Btn() {
        reset();
        inputField.setText( inputField.getText() + "5");
    }

    @FXML
    void pressing6Btn() {
        reset();
        inputField.setText( inputField.getText() + "6");
    }

    @FXML
    void pressing7Btn() {
        reset();
        inputField.setText( inputField.getText() + "7");
    }

    @FXML
    void pressing8Btn() {
        reset();
        inputField.setText( inputField.getText() + "8");
    }

    @FXML
    void pressing9Btn() {
        reset();
        inputField.setText( inputField.getText() + "9");
    }

    @FXML
    void pressing0Btn() {
        reset();
        inputField.setText( inputField.getText() + "0");
    }

    @FXML
    void times() {
        reset();
        inputField.setText( inputField.getText() + "×");
    }
    @FXML
    void squareRoot() {
        reset();
        inputField.setText(inputField.getText() + "sqrt(");
    }
    @FXML
    void calculateSquareRoot() {
        reset();
        String expression = inputField.getText();
        int startIndex = expression.lastIndexOf("sqrt(");
        int endIndex = expression.lastIndexOf(")");
        if (startIndex >= 0 && endIndex > startIndex) {
            String numberStr = expression.substring(startIndex + 5, endIndex);
            try {
                double number = Double.parseDouble(numberStr);
                if (number >= 0) {
                    double result = Math.sqrt(number);
                    inputField.setText(expression.substring(0, startIndex) + result + expression.substring(endIndex + 1));
                } else {
                    inputField.setText("Invalid input");
                }
            } catch (NumberFormatException e) {
                inputField.setText("Invalid input");
            }
        } else {
            inputField.setText("Invalid input");
        }
    }


    private void reset(){
        if(isDisplayingAns){
            inputField.clear();
            equalLabel.setVisible(false);
            isDisplayingAns = false;
        }
    }

}

