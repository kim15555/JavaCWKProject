import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CompetitorView {
    private JFrame frame;
    private JButton scoreButton;
    private JButton tableButton;
    private JButton detailsButton;
    private JButton editButton;
    private JButton removeButton;
    private JButton closeButton;

    public CompetitorView() {
        // Create GUI components
        frame = new JFrame("Competitor Management");
        scoreButton = new JButton("View/Alter Scores");
        tableButton = new JButton("View Competitor Table");
        detailsButton = new JButton("View Details");
        editButton = new JButton("Edit Competitor");
        removeButton = new JButton("Remove Competitor");
        closeButton = new JButton("Close");

        // Set up layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.add(scoreButton);
        panel.add(tableButton);
        panel.add(detailsButton);
        panel.add(editButton);
        panel.add(removeButton);
        panel.add(closeButton);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
    }

    public void addScoreButtonListener(ActionListener listener) {
        scoreButton.addActionListener(listener);
    }

    public void addTableButtonListener(ActionListener listener) {
        tableButton.addActionListener(listener);
    }

    public void addDetailsButtonListener(ActionListener listener) {
        detailsButton.addActionListener(listener);
    }

    public void addEditButtonListener(ActionListener listener) {
        editButton.addActionListener(listener);
    }

    public void addRemoveButtonListener(ActionListener listener) {
        removeButton.addActionListener(listener);
    }

    public void addCloseButtonListener(ActionListener listener) {
        closeButton.addActionListener(listener);
    }

    public void createAndShowGUI() {
        SwingUtilities.invokeLater(() -> {
            frame.setVisible(true);
        });
    }

    // New methods to display dialogs for additional functionalities

    public String showInputDialog(String message) {
        return JOptionPane.showInputDialog(frame, message);
    }

    public void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public int showOptionDialog(String message, String[] options, int defaultOption) {
        return JOptionPane.showOptionDialog(frame, message, "Select an option", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[defaultOption]);
    }
}
