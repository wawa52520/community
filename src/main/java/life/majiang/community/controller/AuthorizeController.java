package life.majiang.community.controller;

import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithubUser;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
//        1.通过index.html的连接进行访问github,从github返回的callback通过@RequestParam注解来获取code和state的值
//        设置code，state，redirect_url，state，client_id,client_secret值进行传输
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id("4e530f0e13a1e5ccaa89");
        accessTokenDTO.setClient_secret("4f1c95b8c02cb9cbaf8bbfdbe386f2026a263afc");

        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
//        System.out.println(user.getId());
        System.out.println(user.getBio());
        System.out.println(user.getAvatar_url());
        return "index";
    }

}
