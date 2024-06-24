package donate_api.sever.infra.persistence.jpa;

import donate_api.sever.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentJpaRepository extends JpaRepository<Comment, Long> {
}
