package donate_api.sever.presentation.api.config;

import donate_api.sever.domain.repositories.CommentRepository;
import donate_api.sever.domain.repositories.MemberRepository;
import donate_api.sever.domain.repositories.WishRepository;
import donate_api.sever.infra.persistence.CommentRepositoryImpl;
import donate_api.sever.infra.persistence.MemberRepositoryImpl;
import donate_api.sever.infra.persistence.WishRepositoryImpl;
import donate_api.sever.infra.persistence.jpa.CommentJpaRepository;
import donate_api.sever.infra.persistence.jpa.MemberJpaRepository;
import donate_api.sever.infra.persistence.jpa.WishJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public MemberRepository memberRepository(MemberJpaRepository rep){
        return new MemberRepositoryImpl(rep);
    }

    @Bean
    public CommentRepository commentRepository(CommentJpaRepository rep){
        return new CommentRepositoryImpl(rep);
    }

    @Bean
    public WishRepository wishRepository(WishJpaRepository rep){
        return new WishRepositoryImpl(rep);
    }
}
