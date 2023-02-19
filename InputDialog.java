import javax.swing.*;

public class InputDialog extends JDialog {
    private JTextField textField;

    public InputDialog(JFrame parent) {
        super(parent, "Input Dialog", true);

        textField = new JTextField(40);

        textField.addActionListener(e -> {
            String inputText = textField.getText().trim();
            if (!inputText.isEmpty()) {
                dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter input text: "));
        panel.add(textField);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(parent); // Center the dialog relative to the parent frame
    }

    public String getInputText() {
        setVisible(true); // Show the dialog
        return textField.getText();
    }
}
