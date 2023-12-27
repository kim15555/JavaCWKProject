import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

import javax.swing.JOptionPane;

public class CompetitorController {
    private CompetitorView view;
    private CompetitorList model;

    public CompetitorController(CompetitorView view, CompetitorList model) {
        this.view = view;
        this.model = model;

        // Add listeners to the view's buttons
        view.addScoreButtonListener(new ScoreButtonListener());
        view.addTableButtonListener(new TableButtonListener());
        view.addDetailsButtonListener(new DetailsButtonListener());
        view.addEditButtonListener(new EditButtonListener());
        view.addRemoveButtonListener(new RemoveButtonListener());
        view.addCloseButtonListener(new CloseButtonListener());
    }

    private class ScoreButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle score button click
            // Implement the logic to view or alter scores
            StringBuilder scores = new StringBuilder();
            for (Competitor competitor : model.getAllCompetitors()) {
                scores.append(competitor.getName()).append(": ").append(competitor.getOverallScore()).append("\n");
            }
            view.showMessageDialog(scores.toString());
        }
    }

    private class TableButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle table button click
            // Implement the logic to view the competitor table
            String[] options = {"Sort by Name", "Sort by Score", "Sort by Level"};
            int choice = view.showOptionDialog("Select sorting criteria:", options, 0);

            // Implement logic to sort and display the table based on the selected criteria
            sortAndDisplayTable(choice);
        }

        private void sortAndDisplayTable(int choice) {
            // Sorting logic
            switch (choice) {
                case 0:
                    // Sort by Name
                    Collections.sort(model.getAllCompetitors(), Comparator.comparing(Competitor::getName));
                    break;
                case 1:
                    // Sort by Score
                    Collections.sort(model.getAllCompetitors(), Comparator.comparingDouble(Competitor::getOverallScore).reversed());
                    break;
                case 2:
                    // Sort by Level
                    Collections.sort(model.getAllCompetitors(), Comparator.comparing(Competitor::getLevel));
                    break;
                default:
                    break;
            }

            // Display the sorted table
            displayCompetitorTable();
        }

        private void displayCompetitorTable() {
            // Placeholder for displaying the sorted table
            StringBuilder table = new StringBuilder("Competitor Table:\n");
            for (Competitor competitor : model.getAllCompetitors()) {
                table.append(competitor.getShortDetails()).append("\n");
            }
            view.showMessageDialog(table.toString());
        }
    }

    private class DetailsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle details button click
            // Get the competitor number from the user
            String competitorNumberInput = view.showInputDialog("Enter competitor number:");
            try {
                int competitorNumber = Integer.parseInt(competitorNumberInput);
    
                // Check if the entered competitor number is valid
                Competitor competitor = model.getCompetitor(competitorNumber);
                if (competitor != null) {
                    // If it is valid, display the full details about the competitor
                    view.showMessageDialog(competitor.getFullDetails());
                } else {
                    view.showMessageDialog("Invalid competitor number.");
                }
    
            } catch (NumberFormatException ex) {
                view.showMessageDialog("Invalid input. Please enter a valid competitor number.");
            }
        }
    }
    

    private class EditButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle edit button click
            // Get the competitor number to edit
            String competitorNumberInput = view.showInputDialog("Enter competitor number to edit:");
            try {
                int competitorNumber = Integer.parseInt(competitorNumberInput);
    
                // Check if the entered competitor number is valid
                Competitor competitor = model.getCompetitor(competitorNumber);
                if (competitor != null) {
                    // If it is valid, prompt the user for new details
                    String newName = view.showInputDialog("Enter new name:");
                    String newLevel = view.showInputDialog("Enter new level:");
                    // You can add more fields as needed
    
                    // Update the competitor details
                    competitor.setName(newName);
                    competitor.setLevel(newLevel);
                    // Update other details as needed
    
                    view.showMessageDialog("Competitor details updated successfully:\n" + competitor.getFullDetails());
                } else {
                    view.showMessageDialog("Invalid competitor number.");
                }
    
            } catch (NumberFormatException ex) {
                view.showMessageDialog("Invalid input. Please enter a valid competitor number.");
            }
        }
    }
    

    private class RemoveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle remove button click
            // Implement the logic to remove a competitor by ID
            String competitorIdInput = view.showInputDialog("Enter competitor ID to remove:");
            try {
                int competitorId = Integer.parseInt(competitorIdInput);
    
                // Check if the competitor exists
                Competitor competitor = model.getCompetitor(competitorId);
                if (competitor != null) {
                    // Remove the competitor
                    model.removeCompetitor(competitor);
                    view.showMessageDialog("Competitor with ID " + competitorId + " has been removed.");
                } else {
                    view.showMessageDialog("Competitor with ID " + competitorId + " not found.");
                }
    
            } catch (NumberFormatException ex) {
                view.showMessageDialog("Invalid input. Please enter a valid competitor ID.");
            }
        }
    }
    

    private class CloseButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle close button click
        // Implement the logic to write the competitor report to a text file
        writeCompetitorReport();

        // Inform the user and close the application
        view.showMessageDialog("Competitor report has been written to Report.txt. Closing the application.");
        System.exit(0);
    }

    private void writeCompetitorReport() {
        try {
            PrintWriter writer = new PrintWriter("Report.txt");
            writer.println("Competitors:");
            for (Competitor c : model.getAllCompetitors()) {
                writer.println(c.getFullDetails());
            }
            writer.println("Highest Scoring Competitor: " + model.getHighestScoringCompetitor().getFullDetails());
            writer.println("Average Score: " + model.getAverageScore());
            writer.println("Score Frequency:");
            for (Map.Entry<Integer, Integer> entry : model.getScoreFrequency().entrySet()) {
                writer.println("Score " + entry.getKey() + ": " + entry.getValue() + " times");
            }
            writer.close();
        } catch (FileNotFoundException ex) {
            view.showMessageDialog("Error writing to file.");
        }
    }
}


    public static void main(String[] args) {
        // Example usage:
        CompetitorList model = new CompetitorList();
        CompetitorView view = new CompetitorView();
        CompetitorController controller = new CompetitorController(view, model);

        view.createAndShowGUI();
    }
}
