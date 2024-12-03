import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private final JTextArea textAreaOutput;
    private final JTextArea textAreaInput;
    private final JSpinner spinnerOffset;

    public Main() {
        setTitle("ROT Cipher Tool");
        setResizable(false);
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);

        // Title Label
        JLabel titleLabel = new JLabel("ROT Cipher Tool", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        contentPane.add(titleLabel, BorderLayout.NORTH);

        // Center Panel for Input/Output
        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        contentPane.add(centerPanel, BorderLayout.CENTER);

        // Input Panel
        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input"));
        textAreaInput = new JTextArea();
        textAreaInput.setLineWrap(true);
        textAreaInput.setWrapStyleWord(true);
        textAreaInput.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textAreaInput.getDocument().addDocumentListener(new TextChangeListener());
        JScrollPane inputScrollPane = new JScrollPane(textAreaInput);
        inputPanel.add(inputScrollPane, BorderLayout.CENTER);
        centerPanel.add(inputPanel);

        // Output Panel
        JPanel outputPanel = new JPanel(new BorderLayout(10, 10));
        outputPanel.setBorder(BorderFactory.createTitledBorder("Output"));
        textAreaOutput = new JTextArea();
        textAreaOutput.setLineWrap(true);
        textAreaOutput.setWrapStyleWord(true);
        textAreaOutput.setEditable(false);
        textAreaOutput.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane outputScrollPane = new JScrollPane(textAreaOutput);
        outputPanel.add(outputScrollPane, BorderLayout.CENTER);
        centerPanel.add(outputPanel);

        // Bottom Panel for Controls
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        contentPane.add(bottomPanel, BorderLayout.SOUTH);

        // Offset Spinner
        JLabel offsetLabel = new JLabel("Cipher Offset:");
        bottomPanel.add(offsetLabel);

        spinnerOffset = new JSpinner(new SpinnerNumberModel(13, 1, 25, 1));
        spinnerOffset.addChangeListener(e -> cipherDecipher());
        bottomPanel.add(spinnerOffset);

        // Copy Button
        JButton copyButton = new JButton("Copy Output");
        copyButton.addActionListener(e -> copyToClipboard());
        bottomPanel.add(copyButton);

        // Clear Button
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> clearFields());
        bottomPanel.add(clearButton);
    }

    /**
     * Encrypt or decrypt the input using the ROT cipher.
     */
    private void cipherDecipher() {
        String message = textAreaInput.getText();
        int offset = (int) spinnerOffset.getValue();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c >= 'a' && c <= 'm') c += offset;
            else if (c >= 'A' && c <= 'M') c += offset;
            else if (c >= 'n' && c <= 'z') c -= offset;
            else if (c >= 'N' && c <= 'Z') c -= offset;
            sb.append(c);
        }

        textAreaOutput.setText(sb.toString());
    }

    /**
     * Copy the output text to the system clipboard.
     */
    private void copyToClipboard() {
        String outputText = textAreaOutput.getText();
        if (!outputText.isEmpty()) {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
                    new StringSelection(outputText), null);
            JOptionPane.showMessageDialog(this, "Output copied to clipboard!");
        } else {
            JOptionPane.showMessageDialog(this, "Output is empty!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Clear input and output fields.
     */
    private void clearFields() {
        textAreaInput.setText("");
        textAreaOutput.setText("");
    }

    /**
     * Listener to trigger cipher operation when input changes.
     */
    private class TextChangeListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            cipherDecipher();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            cipherDecipher();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            cipherDecipher();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main frame = new Main();
            frame.setVisible(true);
        });
    }
