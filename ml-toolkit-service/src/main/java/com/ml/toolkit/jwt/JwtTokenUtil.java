package com.ml.toolkit.jwt;

import com.ml.toolkit.common.exception.SysException;
import com.ml.toolkit.common.result.ResultCode;
import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.domain.sys.SysUser;
import com.ml.toolkit.form.domain.sys.SimpleUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ml
 * @date 2022年12月21日 21:34
 */
@Slf4j
@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = 6395270913921949272L;

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;
    @Value("${jwt.issuer}")
    private String issuer;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;


    /**
     * 生成Token
     */
    public String findAccessToken(SysUser user) {
        // 登陆成功生成JWT
        return Jwts.builder()
                // 放入用户名和用户ID
                .setId(user.getId() + "")
                // 主题
                .setSubject(user.getAccount())
                // 签发时间
                .setIssuedAt(new Date())
                // 签发者
                .setIssuer("ml")
                // 自定义属性 放入用户拥有权限
                .claim("userMsg", "这是测试数据")
                // 失效时间
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                // 签名算法和密钥
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public void parseToken(String token) {
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            body.getSubject();
        } catch (Exception e) {
            throw new SysException(ResultCode.USER_NOT_LOGGED_IN);
        }
    }

    public SimpleUser getCurrentUser(String token) {
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            SimpleUser simpleUser = new SimpleUser();
            simpleUser.setId(Long.parseLong(body.getId()));
            return simpleUser;
        } catch (Exception e) {
            throw new SysException(ResultCode.USER_NOT_LOGGED_IN);
        }
    }

    /**
     * 判断内容是否符合规则
     *
     * @param regex   正则
     * @param content 内容
     * @return true 符合， false不符合
     */
    public static boolean matcherHasRule(String regex, String content) {
        if (ObjectUtil.isNotEmpty(regex) && ObjectUtil.isNotEmpty(content)) {
            return content.matches(regex);
        }
        return false;
    }
}
