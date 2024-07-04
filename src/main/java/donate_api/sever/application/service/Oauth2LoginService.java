package donate_api.sever.application.service;

import donate_api.sever.application.client.OAuth2Client;
import donate_api.sever.application.dto.response.AccessTokenDto;
import org.springframework.stereotype.Service;

@Service
public class Oauth2LoginService {

    private final OAuth2Client oAuth2Client;

    public Oauth2LoginService(OAuth2Client oAuth2Client) {
        this.oAuth2Client = oAuth2Client;
    }

    public AccessTokenDto oauthLogin(String code, Object sessionState) {
        // 1. code 로 provider 에 Access 토큰 요청 -> Oauth2Client 사용
        // 2. Access Token 으로 Resource Server 에 사용자정보 요청 -> Oauth2Client 사용
        // 3. 사용자 정보로 done 애플리케이션에 회원가입 or 로그인 처리 -> SocialUserService/Repository 사용
        // 4. Authentication 토큰 발행 -> JWT 사용
    }
}
