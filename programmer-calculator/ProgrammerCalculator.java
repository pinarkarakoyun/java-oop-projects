import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgrammerCalculator extends JFrame {
    private JTextField display;
    private String currentInput = "";
    private String operator = "";
    private String mode = "Decimal";
    private int number1;
    private int number2;

    public ProgrammerCalculator() {
        setTitle("Programmer Calculator");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel modePanel = new JPanel();
        modePanel.setLayout(new GridLayout(3, 1));

        JRadioButton decimalButton = new JRadioButton("Decimal", true);
        JRadioButton binaryButton = new JRadioButton("Binary");
        JRadioButton hexButton = new JRadioButton("Hexadecimal");

        ButtonGroup modeGroup = new ButtonGroup();

        modeGroup.add(decimalButton);
        modeGroup.add(binaryButton);
        modeGroup.add(hexButton);

        modePanel.add(decimalButton);
        modePanel.add(binaryButton);
        modePanel.add(hexButton);

        add(modePanel, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 5));

        String[] buttons = {
                "A", "NOT", "<<", ">>", "Clear",
                "B", "And", "Or", "XOR", "+",
                "C", "7", "8", "9", "-",
                "D", "4", "5", "6", "*",
                "E", "1", "2", "3", "/",
                "F", " ", "0", " ", "="
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 16));
            button.setBackground(getButtonColor(text));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        decimalButton.addActionListener(e -> {
            mode = "Decimal";
            updateButtonStates();
        });

        binaryButton.addActionListener(e -> {
            mode = "Binary";
            updateButtonStates();
        });

        hexButton.addActionListener(e -> {
            mode = "Hexadecimal";
            updateButtonStates();
        });

        updateButtonStates();
    }

    private Color getButtonColor(String text) {
        if ("Clear".equals(text)) {
            return Color.RED;
        } else if ("0".equals(text) || "1".equals(text) || "2".equals(text) || "3".equals(text) ||
                "4".equals(text) || "5".equals(text) || "6".equals(text) || "7".equals(text) ||
                "8".equals(text) || "9".equals(text)) {
            return Color.LIGHT_GRAY;
        } else if ("A".equals(text) || "B".equals(text) || "C".equals(text) || "D".equals(text) ||
                "E".equals(text) || "F".equals(text) || "NOT".equals(text) || "And".equals(text) ||
                "<<".equals(text) || "Or".equals(text)|| ">>".equals(text)|| "XOR".equals(text)|| "+".equals(text)||
                "-".equals(text)|| "*".equals(text)|| "/".equals(text)|| "=".equals(text)) {
            return new Color(193, 213, 255);

        } else {
            return new Color(214, 217, 223);
        }


    }

    private void updateButtonStates() {
        boolean isBinary = mode.equals("Binary");
        boolean isDecimal = mode.equals("Decimal");
        boolean isHexadecimal = mode.equals("Hexadecimal");

        for (Component component : getContentPane().getComponents()) {
            if (component instanceof JPanel) {
                JPanel panel = (JPanel) component;
                for (Component button : panel.getComponents()) {
                    if (button instanceof JButton) {
                        String text = ((JButton) button).getText();
                        if ("A".equals(text) || "B".equals(text) || "C".equals(text) ||
                                "D".equals(text) || "E".equals(text) || "F".equals(text)) {
                            button.setEnabled(isHexadecimal);
                        } else if ("2".equals(text) || "3".equals(text) || "4".equals(text) ||
                                "5".equals(text) || "6".equals(text) || "7".equals(text) ||
                                "8".equals(text) || "9".equals(text)) {
                            button.setEnabled(isDecimal || isHexadecimal);
                        } else {
                            button.setEnabled(true);
                        }
                    }
                }
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "Clear":
                    display.setText("");
                    currentInput = "";
                    operator = "";
                    break;
                case "=":
                    if (!currentInput.isEmpty() && !operator.isEmpty()) {
                        number2 = parseInput(currentInput);
                        int result = calculateResult();
                        display.setText(formatOutput(result));
                        currentInput = "";
                        operator = "";
                    }
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "And":
                case "Or":
                case "XOR":
                case "<<":
                case ">>":
                    operator = command;
                    number1 = parseInput(currentInput);
                    currentInput = "";
                    break;
                default:
                    currentInput += command;
                    display.setText(currentInput);
                    break;
            }
        }
    }

    private int parseInput(String input) {
        switch (mode) {
            case "Binary":
                return Integer.parseInt(input, 2);
            case "Hexadecimal":
                return Integer.parseInt(input, 16);
            default: // Decimal (10)
                return Integer.parseInt(input);
        }
    }

    private int calculateResult() {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return number1 / number2;
            case "And":
                return number1 & number2;
            case "Or":
                return number1 | number2;
            case "XOR":
                return number1 ^ number2;
            case "<<":
                return number1 << number2;
            case ">>":
                return number1 >> number2;
            default:
                return 0;
        }
    }

    private String formatOutput(int result) {
        switch (mode) {
            case "Binary":
                return Integer.toBinaryString(result);
            case "Hexadecimal":
                return Integer.toHexString(result).toUpperCase();
            default: // Decimal
                return String.valueOf(result);
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            ProgrammerCalculator calculator = new ProgrammerCalculator();
            calculator.setVisible(true);
        });
    }
}