import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompetitorViewTest {
    public static void main(String[] args) {
        CompetitorView competitorView = new CompetitorView();

        // Add listeners to the buttons for testing
        competitorView.addScoreButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Score button clicked!");
            }
        });

        competitorView.addTableButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Table button clicked!");
            }
        });

        competitorView.addDetailsButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Details button clicked!");
            }
        });

        competitorView.addEditButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit button clicked!");
            }
        });

        competitorView.addRemoveButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Remove button clicked!");
            }
        });

        competitorView.addCloseButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Close button clicked!");
                System.exit(0); // This is just for testing; in a real application, you might want a different way to close the program.
            }
        });

        // Show the GUI
        competitorView.createAndShowGUI();
    }
}
