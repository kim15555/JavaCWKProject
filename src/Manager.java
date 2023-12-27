import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Manager {
    private CompetitorList competitorList;
    private CompetitorView competitorView;
    private CompetitorController competitorController;

    public Manager() {
        this.competitorList = new CompetitorList();
        this.competitorView = new CompetitorView();
        this.competitorController = new CompetitorController(competitorView, competitorList);
    }

    public void start() {
        // Show the GUI
        this.competitorView.createAndShowGUI();

        // Read in the details of each competitor from a text file
        try {
            Scanner fileScanner = new Scanner(new File("RunCompetitor.csv"));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] details = line.split(",");
                // Check if the line is correctly formatted
                if (details.length != 10) {
                    System.out.println("Invalid line format: " + line);
                    continue;
                }
                try {
                    Competitor competitor;
                    int[] scores = new int[]{Integer.parseInt(details[5]), Integer.parseInt(details[6]), Integer.parseInt(details[7]), Integer.parseInt(details[8]), Integer.parseInt(details[9])};
                    switch (details[2].toLowerCase()) {
                        case "novice":
                            competitor = new NoviceCompetitor(Integer.parseInt(details[0]), details[1], line, Integer.parseInt(details[3]), details[4], scores);
                            break;
                        case "intermediate":
                            competitor = new IntermediateCompetitor(Integer.parseInt(details[0]), details[1], line, Integer.parseInt(details[3]), details[4], scores);
                            break;
                        case "advanced":
                            competitor = new AdvancedCompetitor(Integer.parseInt(details[0]), details[1], line, Integer.parseInt(details[3]), details[4], scores);
                            break;
                        default:
                            System.out.println("Invalid competitor level in line: " + line);
                            continue;
                    }
                    this.competitorList.addCompetitor(competitor);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in line: " + line);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        // Allow the user to enter a competitor number using GUI input
        String competitorNumberInput = JOptionPane.showInputDialog("Enter a competitor number:");
        try {
            int competitorNumber = Integer.parseInt(competitorNumberInput);

            // Check that this is valid
            Competitor competitor = this.competitorList.getCompetitor(competitorNumber);
            if (competitor != null) {
                // If it is valid, display the short details about the competitor
                JOptionPane.showMessageDialog(null, competitor.getShortDetails());
            } else {
                JOptionPane.showMessageDialog(null, "Invalid competitor number.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid competitor number.");
        }

        // Produce a final report to a text file
        try {
            PrintWriter writer = new PrintWriter("Report.txt");
            writer.println("Competitors:");
            for (Competitor c : this.competitorList.getAllCompetitors()) {
                writer.println(c.getFullDetails());
            }
            writer.println("Highest Scoring Competitor: " + this.competitorList.getHighestScoringCompetitor().getFullDetails());
            writer.println("Average Score: " + this.competitorList.getAverageScore());
            writer.println("Score Frequency:");
            for (Map.Entry<Integer, Integer> entry : this.competitorList.getScoreFrequency().entrySet()) {
                writer.println("Score " + entry.getKey() + ": " + entry.getValue() + " times");
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.start();
    }
}
