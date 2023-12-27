public class AdvancedCompetitor extends Competitor {
    public AdvancedCompetitor(int competitorNumber, String name, String level, int age, String country, int[] scores) {
        super(competitorNumber, name, level, age, country, scores);
    }

    @Override
    public double getOverallScore() {
        int maxScore = Integer.MIN_VALUE;
        for (int score : super.getScoreArray()) {
            if (score > maxScore) {
                maxScore = score;
            }
        }
        return maxScore;
    }
}