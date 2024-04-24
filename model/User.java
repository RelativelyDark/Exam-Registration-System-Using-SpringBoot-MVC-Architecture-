import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loginUser")
public class User {
    @Id
    private String userId;
    private String password;
    private Long rewards;

    public static class Builder {
        private String userId;
        private String password;
        private Long rewards;

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder rewards(Long rewards) {
            this.rewards = rewards;
            return this;
        }

        public User build() {
            return new User(userId, password, rewards);
        }
    }
}
