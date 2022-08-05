package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class TButton extends JButton {
}

class Board extends JPanel {

    public Board() {
        setBounds(0,24,290,260);
        setLayout(new GridLayout(3, 3));

        ListenerAction listenerAction = new ListenerAction();

        TButton buttonA3 = new TButton();
        buttonA3.setName("ButtonA3");
        buttonA3.setFocusPainted(false);
        buttonA3.addActionListener(listenerAction);

        TButton buttonB3 = new TButton();
        buttonB3.setName("ButtonB3");
        buttonB3.setFocusPainted(false);
        buttonB3.addActionListener(listenerAction);

        TButton buttonC3 = new TButton();
        buttonC3.setName("ButtonC3");
        buttonC3.setFocusPainted(false);
        buttonC3.addActionListener(listenerAction);

        TButton buttonA2 = new TButton();
        buttonA2.setName("ButtonA2");
        buttonA2.setFocusPainted(false);
        buttonA2.addActionListener(listenerAction);

        TButton buttonB2 = new TButton();
        buttonB2.setName("ButtonB2");
        buttonB2.setFocusPainted(false);
        buttonB2.addActionListener(listenerAction);

        TButton buttonC2 = new TButton();
        buttonC2.setName("ButtonC2");
        buttonC2.setFocusPainted(false);
        buttonC2.addActionListener(listenerAction);

        TButton buttonA1 = new TButton();
        buttonA1.setName("ButtonA1");
        buttonA1.setFocusPainted(false);
        buttonA1.addActionListener(listenerAction);

        TButton buttonB1 = new TButton();
        buttonB1.setName("ButtonB1");
        buttonB1.setFocusPainted(false);
        buttonB1.addActionListener(listenerAction);

        TButton buttonC1 = new TButton();
        buttonC1.setName("ButtonC1");
        buttonC1.setFocusPainted(false);
        buttonC1.addActionListener(listenerAction);

        add(buttonA3);
        add(buttonB3);
        add(buttonC3);
        add(buttonA2);
        add(buttonB2);
        add(buttonC2);
        add(buttonA1);
        add(buttonB1);
        add(buttonC1);

        Global.buttonA3 = buttonA3;
        Global.buttonB3 = buttonB3;
        Global.buttonC3 = buttonC3;
        Global.buttonA2 = buttonA2;
        Global.buttonB2 = buttonB2;
        Global.buttonC2 = buttonC2;
        Global.buttonA1 = buttonA1;
        Global.buttonB1 = buttonB1;
        Global.buttonC1 = buttonC1;

        // set buttons text to " "
        Global.clearButtons();
        Global.setEnabledButtons(false);
        Global.nextStep = 'X';

    }
}

class ListenerAction implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        TButton btn = (TButton) e.getSource();

        if ((Global.getState() == State.NOT_STARTED || Global.getState() == State.IN_PROGRESS) && " ".equals(btn.getText())) {
            btn.setText(Character.toString(Global.nextStep));
            Global.setState(State.IN_PROGRESS);
            if (Global.nextStep == 'X') {
                Global.nextStep = 'O';
            } else {
                Global.nextStep = 'X';
            }

            if (Global.isWin("X")) {
                Global.setState(State.X_WINS);
            } else if (Global.isWin("O")) {
                Global.setState(State.O_WINS);
            } else if (Global.isDraw()) {
                Global.setState(State.DRAW);
            }
        }

    }
}

class ActionListenerStart implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        Global.clearButtons();
        Global.setState(State.NOT_STARTED);
        Global.nextStep = 'X';
        Global.startReset.setText("Reset");
        Global.player1.setEnabled(false);
        Global.player2.setEnabled(false);
    }
}

class ActionListenerPlayer implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if ("Human".equals(btn.getText())) {
            btn.setText("Robot");
        } else {
            btn.setText("Human");
        }
    }
}

public class TicTacToe extends JFrame {

    public TicTacToe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setSize(300, 345);
        setResizable(false);

        JPanel toolbar = new JPanel();
        toolbar.setBounds(0,0,290,25);
        toolbar.setLayout(new GridLayout(1, 3));

        JButton player1 = new JButton("Human");
        player1.setName("ButtonPlayer1");
        player1.setBounds(0, 0, 80, 30);
        player1.setFocusPainted(false);
        toolbar.add(player1);
        Global.player1 = player1;

        JButton startReset = new JButton("Start");
        startReset.setName("ButtonStartReset");
        startReset.setBounds(0, 0, 80, 30);
        startReset.setFocusPainted(false);
        toolbar.add(startReset);
        Global.startReset = startReset;

        ActionListenerStart actionListenerStart = new ActionListenerStart();
        startReset.addActionListener(actionListenerStart);

        JButton player2 = new JButton("Human");
        player2.setName("ButtonPlayer2");
        player2.setBounds(0, 0, 80, 30);
        player2.setFocusPainted(false);
        toolbar.add(player2);
        Global.player2 = player2;

        ActionListenerPlayer actionListenerPlayer = new ActionListenerPlayer();
        player1.addActionListener(actionListenerPlayer);
        player2.addActionListener(actionListenerPlayer);

        add(toolbar);

        add(new Board());

        JPanel panel = new JPanel();
        panel.setBounds(0,285,290,15);
        panel.setLayout(new GridLayout(1, 1));

        JLabel label = new JLabel();
        label.setName("LabelStatus");
        label.setText(Global.state.NOT_STARTED.text);
        label.setBounds(10, 0, 290, 20);
        panel.add(label);
        Global.label = label;

//        JButton reset = new JButton("Reset");
//        reset.setName("ButtonReset");
//        reset.setBounds(190, 0, 80, 30);
//        panel.add(reset);

//        ActionListenerReset actionListenerReset = new ActionListenerReset();
//        reset.addActionListener(actionListenerReset);

        add(panel);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}

