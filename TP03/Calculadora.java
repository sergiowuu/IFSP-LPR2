/* 
 * Sergio WU CB3025691
 * Jackson de Lima Gregorio CB3013189
*/

package TP03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {
    private JTextField display;
    private double result;
    private String operator;
    private boolean startNewNumber;

    public Calculadora() {
        setTitle("Calculadora");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        result = 0;
        operator = "=";
        startNewNumber = true;
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            try {
                if ("0123456789".contains(command)) {
                    if (startNewNumber) {
                        display.setText(command);
                        startNewNumber = false;
                    } else {
                        display.setText(display.getText() + command);
                    }
                } else if (command.equals("C")) {
                    display.setText("");
                    result = 0;
                    operator = "=";
                    startNewNumber = true;
                } else if (command.equals("=")) {
                    calculate(Double.parseDouble(display.getText()));
                    operator = "=";
                    display.setText("" + result);
                    startNewNumber = true;
                } else {
                    if (!startNewNumber) {
                        calculate(Double.parseDouble(display.getText()));
                        display.setText("" + result);
                        startNewNumber = true;
                    }
                    operator = command;
                }
            } catch (NumberFormatException ex) {
                display.setText("Erro");
                startNewNumber = true;
            } catch (ArithmeticException ex) {
                display.setText("Erro");
                startNewNumber = true;
            } finally {
                // Any cleanup code can go here
            }
        }

        private void calculate(double number) {
            switch (operator) {
                case "+":
                    result += number;
                    break;
                case "-":
                    result -= number;
                    break;
                case "*":
                    result *= number;
                    break;
                case "/":
                    if (number == 0) {
                        throw new ArithmeticException("Divisão por zero");
                    }
                    result /= number;
                    break;
                case "=":
                    result = number;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculadora().setVisible(true);
            }
        });
    }
}