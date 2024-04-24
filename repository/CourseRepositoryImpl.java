import javax.persistence.EntityManager;

public class CourseRepositoryImpl extends SimpleJpaRepository<Course, Long> implements CourseRepository {

    private final EntityManager entityManager;

    public CourseRepositoryImpl(EntityManager entityManager) {
        super(Course.class, entityManager);
        this.entityManager = entityManager;
    }
}
