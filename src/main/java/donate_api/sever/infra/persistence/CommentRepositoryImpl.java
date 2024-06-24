package donate_api.sever.infra.persistence;

import donate_api.sever.domain.repositories.CommentRepository;
import donate_api.sever.infra.persistence.jpa.CommentJpaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {
    private final CommentJpaRepository commentJpaRepository;
}
