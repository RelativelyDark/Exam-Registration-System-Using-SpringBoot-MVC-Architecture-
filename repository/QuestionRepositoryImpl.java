import javax.persistence.EntityManager;

public class QuestionRepositoryImpl extends SimpleJpaRepository<Question, Long> implements QuestionRepository {

    private final EntityManager entityManager;

    public QuestionRepositoryImpl(EntityManager entityManager) {
        super(Question.class, entityManager);
        this.entityManager = entityManager;
    }
}
