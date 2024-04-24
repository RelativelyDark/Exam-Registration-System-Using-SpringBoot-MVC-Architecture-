import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class RepositoryFactory {

    private static RepositoryFactory instance;

    private final EntityManager entityManager;

    private RepositoryFactory(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public static RepositoryFactory getInstance(EntityManager entityManager) {
        if (instance == null) {
            synchronized (RepositoryFactory.class) {
                if (instance == null) {
                    instance = new RepositoryFactory(entityManager);
                }
            }
        }
        return instance;
    }

    public CourseRepository createCourseRepository() {
        return new CourseRepositoryImpl(entityManager);
    }

    public QuestionRepository createQuestionRepository() {
        return new QuestionRepositoryImpl(entityManager);
    }

    public QuizRepository createQuizRepository() {
        return new QuizRepositoryImpl(entityManager);
    }

    public UserRepo createUserRepository() {
        return new UserRepoImpl(entityManager);
    }
}
