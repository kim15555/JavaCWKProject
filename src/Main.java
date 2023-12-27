public class Main {
    public static void main(String[] args) {
        int[] scores = {5, 4, 5, 4, 3};
        // Competitor competitor = new Competitor(100, "Keith John Talbot", "Novice", 21, "UK", scores);


        // System.out.println(competitor.getFullDetails());
        // System.out.println(competitor.getShortDetails());
        NoviceCompetitor noviceCompetitor = new NoviceCompetitor(100, "Keith John Talbot", "Novice", 21, "UK", scores);
        IntermediateCompetitor intermediateCompetitor = new IntermediateCompetitor(101, "Jane Doe", "Intermediate", 22, "US", scores);
        AdvancedCompetitor advancedCompetitor = new AdvancedCompetitor(102, "John Smith", "Advanced", 23, "CA", scores);

        System.out.println(noviceCompetitor.getFullDetails());
        System.out.println(noviceCompetitor.getShortDetails());

        System.out.println(intermediateCompetitor.getFullDetails());
        System.out.println(intermediateCompetitor.getShortDetails());

        System.out.println(advancedCompetitor.getFullDetails());
        System.out.println(advancedCompetitor.getShortDetails());
    }
}
