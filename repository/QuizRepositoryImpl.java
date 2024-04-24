import javax.persistence.EntityManager;

public class QuizRepositoryImpl extends SimpleJpaRepository<Quiz, Long> implements QuizRepository {

    private final EntityManager entityManager;

    public QuizRepositoryImpl(EntityManager entityManager) {
        super(Quiz.class, entityManager);
        this.entityManager = entityManager;
    }
}
