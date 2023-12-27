public class NoviceCompetitor extends Competitor {
    public NoviceCompetitor(int competitorNumber, String name, String level, int age, String country, int[] scores) {
        super(competitorNumber, name, level, age, country, scores);
    }

    @Override
    public double getOverallScore() {
        int sum = 0;
        for (int score : super.getScoreArray()) {
            sum += score;
        }
        return (double) sum / super.getScoreArray().length;
    }
}