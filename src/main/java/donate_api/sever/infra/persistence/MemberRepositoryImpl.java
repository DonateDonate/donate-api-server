package donate_api.sever.infra.persistence;

import donate_api.sever.domain.Member;
import donate_api.sever.domain.repositories.MemberRepository;
import donate_api.sever.infra.persistence.jpa.MemberJpaRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public void save(Member member) {
        memberJpaRepository.save(member);
    }

    @Override
    public Optional<Member> findById(Long memberId) {
        return memberJpaRepository.findById(memberId);
    }
}
