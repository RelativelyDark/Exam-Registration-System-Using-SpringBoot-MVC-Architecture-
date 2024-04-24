import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int marksScored;
    private String difficulty;
    private int timeLimit;
    private int rewardPoints;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_id", referencedColumnName = "id")
    private List<Question> questions;

    public static class Builder {
        private String title;
        private int marksScored;
        private String difficulty;
        private int timeLimit;
        private int rewardPoints;
        private List<Question> questions;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder marksScored(int marksScored) {
            this.marksScored = marksScored;
            return this;
        }

        public Builder difficulty(String difficulty) {
            this.difficulty = difficulty;
            return this;
        }

        public Builder timeLimit(int timeLimit) {
            this.timeLimit = timeLimit;
            return this;
        }

        public Builder rewardPoints(int rewardPoints) {
            this.rewardPoints = rewardPoints;
            return this;
        }

        public Builder questions(List<Question> questions) {
            this.questions = questions;
            return this;
        }

        public Quiz build() {
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setMarksScored(marksScored);
            quiz.setDifficulty(difficulty);
            quiz.setTimeLimit(timeLimit);
            quiz.setRewardPoints(rewardPoints);
            quiz.setQuestions(questions);
            return quiz;
        }
    }
}
