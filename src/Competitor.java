// public class Competitor {
public abstract class Competitor {
    private int competitorNumber;
    private String name;
    private String level;
    private int age;
    private String country;
    private int[] scores;

    public Competitor(int competitorNumber, String name, String level, int age, String country, int[] scores) {
        this.competitorNumber = competitorNumber;
        this.name = name;
        this.level = level;
        this.age = age;
        this.country = country;
        this.scores = scores;
    }

    public int getCompetitorNumber() {
        return competitorNumber;
    }

    public void setCompetitorNumber(int competitorNumber) {
        this.competitorNumber = competitorNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int[] getScoreArray() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public int getScore(int index) {
        return scores[index];
    }

    public void setScore(int index, int score) {
        scores[index] = score;
    }

    

    // public double getOverallScore() {
    //     // For now, return 5. You will update this method later.
    //     return 5;
    // }

    public abstract double getOverallScore();

    public String getFullDetails() {
        return "Competitor number " + competitorNumber + ", name " + name + ", country " + country + ".\n" +
               name + " is a " + level + " aged " + age + " and has an overall score of " + getOverallScore() + ".";
    }

    public String getShortDetails() {
        String initials = name.replaceAll("\\B.|\\P{L}", "");
        return "CN " + competitorNumber + " (" + initials + ") has overall score " + getOverallScore() + ".";
    }

    
}

