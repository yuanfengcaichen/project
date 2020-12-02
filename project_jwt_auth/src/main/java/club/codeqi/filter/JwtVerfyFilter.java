package club.codeqi.filter;

import club.codeqi.bean.user.user;
import club.codeqi.config.RsaKeyProperties;
import club.codeqi.utils.JwtUtils;
import club.codeqi.domain.Payload;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class JwtVerfyFilter extends BasicAuthenticationFilter {

    private RsaKeyProperties prop;

    public JwtVerfyFilter(AuthenticationManager authenticationManager,RsaKeyProperties prop) {
        super(authenticationManager);
        this.prop =prop;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        if(header == null || !header.startsWith("Bearer ")){//如果携带错误token，则给用户提示请登录
            chain.doFilter(request, response);
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            PrintWriter out = response.getWriter();
            Map resultMap = new HashMap();
            resultMap.put("code",HttpServletResponse.SC_FORBIDDEN);
            resultMap.put("msg","请登录！");
            out.write(new ObjectMapper().writeValueAsString(resultMap));
            out.flush();
            out.close();
        }
        else{
            //如果携带正确格式的token
            String token = header.replace("Bearer ","");
            Payload<user> payload = JwtUtils.getInfoFromToken(token,prop.getPublicKey(), user.class);
            user user = payload.getUserInfo();
            if(user!=null){
                UsernamePasswordAuthenticationToken authResult = new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getPermission());
                SecurityContextHolder.getContext().setAuthentication(authResult);
                chain.doFilter(request, response);
            }
        }
    }
}
