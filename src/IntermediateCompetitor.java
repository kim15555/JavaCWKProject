import java.util.Arrays;

public class IntermediateCompetitor extends Competitor {
    public IntermediateCompetitor(int competitorNumber, String name, String level, int age, String country, int[] scores) {
        super(competitorNumber, name, level, age, country, scores);
    }

    @Override
    public double getOverallScore() {
        int[] scores = super.getScoreArray();
        Arrays.sort(scores);
        if (scores.length % 2 == 0)
            return (scores[scores.length/2] + scores[scores.length/2 - 1]) / 2.0;
        else
            return scores[scores.length/2];
    }
}