package donate_api.sever.infra.config;

import donate_api.sever.application.service.FileService;
import donate_api.sever.application.service.WishService;
import donate_api.sever.domain.Wish;
import donate_api.sever.domain.repositories.MemberRepository;
import donate_api.sever.domain.repositories.WishRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public WishService wishService(
            WishRepository wishRepository,
            FileService fileService,
            MemberRepository memberRepository
    ){
        return new WishService(wishRepository,memberRepository,fileService);
    }
    @Bean
    public FileService fileService(){
        return new FileService();
    }
}
