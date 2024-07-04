package donate_api.sever.presentation.api;

import donate_api.sever.application.dto.response.AccessTokenDto;
import donate_api.sever.application.service.Oauth2LoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

@RestController
@RequestMapping("/oauth2")
public class Oauth2LoginController {

    private final Oauth2LoginService oauth2LoginService;
    private final String KAKAO_CLIENT_ID = "3598243b6e8e0f4a8b44786b5c630a06";

    public Oauth2LoginController(Oauth2LoginService oauth2LoginService) {
        this.oauth2LoginService = oauth2LoginService;
    }

    @GetMapping("/apple/login")
    RedirectView appleLogin(){
        String appleAuthUrl = "appleAuth";
        return new RedirectView(appleAuthUrl);
    }

    @GetMapping("/kakao/login")
    RedirectView kakaoLogin(HttpServletRequest request){
        String state = generateState();
        request.getSession().setAttribute("state", state);
        String REDIRECT_URI = "http://localhost:8080/oauth2/kakao/callback\n";
        String kakaoAuthUrl = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id="+KAKAO_CLIENT_ID+"&redirect_uri=$"+REDIRECT_URI+"&state="+state;
        return new RedirectView(kakaoAuthUrl);
    }

    @GetMapping("/kakao/callback")
    AccessTokenDto kakaoCallback(
            @RequestParam("code") String code,
            @RequestParam("state") String state,
            HttpServletRequest request
    ){
        Object sessionState = request.getSession().getAttribute("state");
        if (sessionState == null || !sessionState.equals(state)) {
            throw new IllegalStateException("Invalid state token");
        }
        return oauth2LoginService.oauthLogin(code, sessionState);
    }

    private String generateState() {
        SecureRandom randomState = new SecureRandom();
        return new BigInteger(130, randomState).toString(32);
    }

}
