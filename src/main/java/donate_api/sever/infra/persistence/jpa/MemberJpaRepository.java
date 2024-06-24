package donate_api.sever.infra.persistence.jpa;

import donate_api.sever.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
}
