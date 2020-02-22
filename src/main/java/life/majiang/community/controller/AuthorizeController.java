package life.majiang.community.controller;

import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithubUser;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;


    @GetMapping("/callback")
//    通过HttpServletRequest request 拿到session
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request
                           ) {
//        1.通过index.html的连接进行访问github,从github返回的callback通过@RequestParam注解来获取code和state的值
//        设置code，state，redirect_url，state，client_id,client_secret值进行传输
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);

        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);

//        判断接受的user信息是否存在
        if (user != null){
            request.getSession().setAttribute("user",user);
            return "redirect:/";
//            拿到session，写入前端
        }else{
            return "redirect:/";
        }
//        System.out.println(user.getName());
//        System.out.println(user.getId());
//        System.out.println(user.getBio());
//        System.out.println(user.getAvatar_url());
//        return "index";
    }

}
