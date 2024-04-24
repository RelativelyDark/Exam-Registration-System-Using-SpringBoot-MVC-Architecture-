import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;
    private String title;
    private String instructor;
    private String courseMaterial;
    private String courseOutcome;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private List<Quiz> quizzes;

    public static class Builder {
        private String image;
        private String title;
        private String instructor;
        private String courseMaterial;
        private String courseOutcome;
        private List<Quiz> quizzes;

        public Builder image(String image) {
            this.image = image;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder instructor(String instructor) {
            this.instructor = instructor;
            return this;
        }

        public Builder courseMaterial(String courseMaterial) {
            this.courseMaterial = courseMaterial;
            return this;
        }

        public Builder courseOutcome(String courseOutcome) {
            this.courseOutcome = courseOutcome;
            return this;
        }

        public Builder quizzes(List<Quiz> quizzes) {
            this.quizzes = quizzes;
            return this;
        }

        public Course build() {
            Course course = new Course();
            course.setImage(image);
            course.setTitle(title);
            course.setInstructor(instructor);
            course.setCourseMaterial(courseMaterial);
            course.setCourseOutcome(courseOutcome);
            course.setQuizzes(quizzes);
            return course;
        }
    }
}
