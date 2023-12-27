import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CompetitorList {
    private ArrayList<Competitor> competitors;

    public CompetitorList() {
        this.competitors = new ArrayList<>();
    }

    public void addCompetitor(Competitor competitor) {
        this.competitors.add(competitor);
    }

    public Competitor getCompetitor(int competitorNumber) {
        for (Competitor competitor : this.competitors) {
            if (competitor.getCompetitorNumber() == competitorNumber) {
                return competitor;
            }
        }
        return null;
    }

    public ArrayList<Competitor> getAllCompetitors() {
        return this.competitors;
    }

    public Competitor getHighestScoringCompetitor() {
        Competitor highestScorer = null;
        for (Competitor competitor : this.competitors) {
            if (highestScorer == null || competitor.getOverallScore() > highestScorer.getOverallScore()) {
                highestScorer = competitor;
            }
        }
        return highestScorer;
    }

    public double getAverageScore() {
        double totalScore = 0;
        for (Competitor competitor : this.competitors) {
            totalScore += competitor.getOverallScore();
        }
        return totalScore / this.competitors.size();
    }

    public void removeCompetitor(Competitor competitor) {
        this.competitors.remove(competitor);
    }

    public Map<Integer, Integer> getScoreFrequency() {
        Map<Integer, Integer> scoreFrequency = new HashMap<>();
        for (Competitor competitor : this.competitors) {
            for (int score : competitor.getScoreArray()) {
                scoreFrequency.put(score, scoreFrequency.getOrDefault(score, 0) + 1);
            }
        }
        return scoreFrequency;
    }
}