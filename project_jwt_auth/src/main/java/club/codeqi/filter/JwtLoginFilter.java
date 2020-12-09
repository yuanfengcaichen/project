package club.codeqi.filter;

import club.codeqi.bean.user.user;
import club.codeqi.config.RsaKeyProperties;
import club.codeqi.utils.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private RsaKeyProperties prop;

    public JwtLoginFilter(AuthenticationManager authenticationManager,RsaKeyProperties prop){
        this.authenticationManager = authenticationManager;
        this.prop = prop;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            user user =  new ObjectMapper().readValue(request.getInputStream(), user.class);
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            Authentication authenticate = authenticationManager.authenticate(authRequest);
            return authenticate;
        } catch (Exception e) {
            try {
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                PrintWriter out = response.getWriter();
                Map resultMap = new HashMap();
                resultMap.put("code",HttpServletResponse.SC_UNAUTHORIZED);
                resultMap.put("msg","用户名或密码错误");
                out.write(new ObjectMapper().writeValueAsString(resultMap));
                out.flush();
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        user user = new user();
        user.setUsername(authResult.getName());
        user.setPassword("");
        user.setPermissions((List) authResult.getAuthorities());
        user auuser = (club.codeqi.bean.user.user) authResult.getPrincipal();
        user.setUid(auuser.getUid());
        user.setIs_lock(auuser.getIs_lock());
        user.setRole_id(auuser.getRole_id());
        user.setCreate_time(auuser.getCreate_time());
        String token = JwtUtils.generateTokenExpireInMinutes(user,prop.getPrivateKey(),60*24);
        response.addHeader("Authorization","Bearer "+token);
        try {
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            PrintWriter out = response.getWriter();
            Map resultMap = new HashMap();
            resultMap.put("code",HttpServletResponse.SC_OK);
            resultMap.put("msg","认证通过。");
            resultMap.put("token","Bearer "+token);
            out.write(new ObjectMapper().writeValueAsString(resultMap));
            out.flush();
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
