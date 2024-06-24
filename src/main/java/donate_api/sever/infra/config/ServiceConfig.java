package donate_api.sever.infra.config;

import donate_api.sever.application.service.FileService;
import donate_api.sever.application.service.WishService;
import donate_api.sever.domain.Wish;
import donate_api.sever.domain.repositories.WishRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public WishService wishService(WishRepository wishRepository){
        return new WishService(wishRepository);
    }
    @Bean
    public FileService fileService(){
        return new FileService();
    }
}
