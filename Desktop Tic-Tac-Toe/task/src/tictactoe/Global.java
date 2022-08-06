package tictactoe;

import javax.swing.*;

public class Global {

    public static State state = State.NOT_STARTED;
    public static char nextStep = 'X';

    public static JLabel label;

    public static JButton player1;
    public static JButton player2;
    public static JButton startReset;

    public static TButton buttonA3;
    public static TButton buttonA2;
    public static TButton buttonA1;
    public static TButton buttonB3;
    public static TButton buttonB2;
    public static TButton buttonB1;
    public static TButton buttonC3;
    public static TButton buttonC2;
    public static TButton buttonC1;

    public static void clearButtons() {
        buttonA3.setText(" ");
        buttonA2.setText(" ");
        buttonA1.setText(" ");
        buttonB3.setText(" ");
        buttonB2.setText(" ");
        buttonB1.setText(" ");
        buttonC3.setText(" ");
        buttonC2.setText(" ");
        buttonC1.setText(" ");
    }

    public static void setEnabledButtons(boolean val) {
        buttonA3.setEnabled(val);
        buttonA2.setEnabled(val);
        buttonA1.setEnabled(val);
        buttonB3.setEnabled(val);
        buttonB2.setEnabled(val);
        buttonB1.setEnabled(val);
        buttonC3.setEnabled(val);
        buttonC2.setEnabled(val);
        buttonC1.setEnabled(val);
    }

    public static void setState(State state) {
        Global.state = state;
        Global.label.setText(state.text);
        if (state == State.IN_PROGRESS) {
            Global.setEnabledButtons(true);
        } else {
            Global.setEnabledButtons(false);
        }
    }

    public static void setState(State state, String text) {
        Global.state = state;
        Global.label.setText(text);
        if (state == State.IN_PROGRESS) {
            Global.setEnabledButtons(true);
        } else {
            Global.setEnabledButtons(false);
        }
    }

    public static State getState() {
        return Global.state;
    }

    public static boolean isWin(String val) {
        return buttonA3.getText().equals(val) && buttonB3.getText().equals(val) && buttonC3.getText().equals(val)
                || buttonA2.getText().equals(val) && buttonB2.getText().equals(val) && buttonC2.getText().equals(val)
                || buttonA1.getText().equals(val) && buttonB1.getText().equals(val) && buttonC1.getText().equals(val)
                || buttonA3.getText().equals(val) && buttonA2.getText().equals(val) && buttonA1.getText().equals(val)
                || buttonB3.getText().equals(val) && buttonB2.getText().equals(val) && buttonB1.getText().equals(val)
                || buttonC3.getText().equals(val) && buttonC2.getText().equals(val) && buttonC1.getText().equals(val)
                || buttonA3.getText().equals(val) && buttonB2.getText().equals(val) && buttonC1.getText().equals(val)
                || buttonC3.getText().equals(val) && buttonB2.getText().equals(val) && buttonA1.getText().equals(val);
    }

    public static boolean isDraw() {
        String val = " ";
        return !buttonA3.getText().equals(val) && !buttonB3.getText().equals(val) && !buttonC3.getText().equals(val)
                && !buttonA2.getText().equals(val) && !buttonB2.getText().equals(val) && !buttonC2.getText().equals(val)
                && !buttonA1.getText().equals(val) && !buttonB1.getText().equals(val) && !buttonC1.getText().equals(val);
    }

    public static void doStep() {

        String val = " ";
        if (buttonA3.getText().equals(val)) {
            buttonA3.setText(Character.toString(nextStep));
        } else if (buttonB3.getText().equals(val)) {
            buttonB3.setText(Character.toString(nextStep));
        } else if (buttonC3.getText().equals(val)) {
            buttonC3.setText(Character.toString(nextStep));
        } else if (buttonA2.getText().equals(val)) {
            buttonA2.setText(Character.toString(nextStep));
        } else if (buttonB2.getText().equals(val)) {
            buttonB2.setText(Character.toString(nextStep));
        } else if (buttonC2.getText().equals(val)) {
            buttonC2.setText(Character.toString(nextStep));
        } else if (buttonA1.getText().equals(val)) {
            buttonA1.setText(Character.toString(nextStep));
        } else if (buttonB1.getText().equals(val)) {
            buttonB1.setText(Character.toString(nextStep));
        } else if (buttonC1.getText().equals(val)) {
            buttonC1.setText(Character.toString(nextStep));
        }

        if (nextStep == 'X') {
            nextStep = 'O';
        } else {
            nextStep = 'X';
        }
    }

}
