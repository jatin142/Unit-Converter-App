import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitConverterApp extends JFrame {

    private JTextField inputField;
    private JLabel resultLabel;

    public UnitConverterApp() {
        setTitle("Unit Converter");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createUI();

        setVisible(true);
    }

    private void createUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        inputField = new JTextField();
        panel.add(inputField);

        JButton toKmButton = new JButton("Miles to Kilometers");
        toKmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertMilesToKm();
            }
        });
        panel.add(toKmButton);

        JButton toMilesButton = new JButton("Kilometers to Miles");
        toMilesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertKmToMiles();
            }
        });
        panel.add(toMilesButton);

        resultLabel = new JLabel();
        panel.add(resultLabel);

        add(panel);
    }

    private void convertMilesToKm() {
        try {
            double miles = Double.parseDouble(inputField.getText());
            double km = miles * 1.60934;
            resultLabel.setText(String.format("%.2f miles is %.2f kilometers", miles, km));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a valid number");
        }
    }

    private void convertKmToMiles() {
        try {
            double km = Double.parseDouble(inputField.getText());
            double miles = km / 1.60934;
            resultLabel.setText(String.format("%.2f kilometers is %.2f miles", km, miles));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a valid number");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UnitConverterApp();
            }
        });
    }
}
