import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculatorSwing extends JFrame implements ActionListener {
    JLabel title;
    JLabel resultLabel;
    JLabel numberOneLabel;
    JLabel numberTwoLabel;
    JLabel operationsBoxLabel;
    JTextField numberOneField;
    JTextField numberTwoField;
    JComboBox<String> operationsBox;
    JButton calculateButton;

    public SimpleCalculatorSwing() {
        //Creating the window
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //Creating the elements
        title = new JLabel("Simple Calculator");
        title.setHorizontalAlignment(SwingConstants.CENTER);

        numberOneLabel = new JLabel("Number 1: ");
        numberOneLabel.setHorizontalAlignment(SwingConstants.CENTER);

        numberTwoLabel = new JLabel("Number 2: ");
        numberTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        operationsBoxLabel = new JLabel("Choose an operation: ");
        operationsBoxLabel.setHorizontalAlignment(SwingConstants.CENTER);

        resultLabel = new JLabel("Result: ");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        numberOneField = new JTextField();
        numberOneField.setPreferredSize(new Dimension(100, 30));

        numberTwoField = new JTextField();
        numberTwoField.setPreferredSize(new Dimension(100, 30));

        operationsBox = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        calculateButton = new JButton("Calculate:");

        // Adding the elements inside the window
        add(title, BorderLayout.NORTH);

        //Creating Input panel
        JPanel inputsPanel = new JPanel(new GridLayout(4, 2));
        inputsPanel.add(numberOneLabel);
        inputsPanel.add(numberOneField);
        inputsPanel.add(operationsBoxLabel);
        inputsPanel.add(operationsBox);
        inputsPanel.add(numberTwoLabel);
        inputsPanel.add(numberTwoField);
        inputsPanel.add(resultLabel);
        add(inputsPanel, BorderLayout.CENTER);//Adding the "Inputs Panel" inside the window

        //Creating Button panel
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.add(calculateButton);
        add(buttonsPanel, BorderLayout.SOUTH);

        calculateButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            try {
                double num1 = Double.parseDouble(numberOneField.getText());
                double num2 = Double.parseDouble(numberTwoField.getText());
                String operation = (String) operationsBox.getSelectedItem();
                double result = 0;

                switch (operation) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                }

                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please, insert valid format numbers!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(this, "Error calculating division by zero", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleCalculatorSwing myCalculator = new SimpleCalculatorSwing();
            myCalculator.setVisible(true);
        });
    }
}