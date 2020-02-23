package life.majiang.community.dto;

import lombok.Data;

//此功能是从token里获取内容
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;

}
