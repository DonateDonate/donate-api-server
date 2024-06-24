package donate_api.sever.infra.persistence.jpa;

import donate_api.sever.domain.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishJpaRepository extends JpaRepository<Wish, Long> {
}
