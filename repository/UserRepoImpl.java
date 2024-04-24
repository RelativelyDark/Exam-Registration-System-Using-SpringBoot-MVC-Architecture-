import javax.persistence.EntityManager;

public class UserRepoImpl extends SimpleJpaRepository<User, String> implements UserRepo {

    private final EntityManager entityManager;

    public UserRepoImpl(EntityManager entityManager) {
        super(User.class, entityManager);
        this.entityManager = entityManager;
    }

 
    @Override
    public User findByUserId(String userId) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<User> query = cb.createQuery(User.class);
    Root<User> root = query.from(User.class);
    query.select(root).where(cb.equal(root.get("userId"), userId));
    TypedQuery<User> typedQuery = entityManager.createQuery(query);
    return typedQuery.getSingleResult();
}

    }

