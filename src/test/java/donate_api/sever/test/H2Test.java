package donate_api.sever.test;

import donate_api.sever.domain.Member;
import donate_api.sever.domain.repositories.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ActiveProfiles("test")
public class H2Test {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void memberTest(){
        Member member = new Member("kimsaha");
        memberRepository.save(member);

        Member findMember = memberRepository.findById(1L).get();
        System.out.println("findMember. = " + findMember.getId());
    }
}
