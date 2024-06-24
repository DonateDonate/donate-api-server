package donate_api.sever.domain.repositories;

import donate_api.sever.domain.Member;

import java.util.Optional;

public interface MemberRepository {
    void save(Member member);
    Optional<Member> findById(Long memberId);
}
