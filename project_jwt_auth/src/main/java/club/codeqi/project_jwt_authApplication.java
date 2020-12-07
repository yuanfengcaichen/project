package club.codeqi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(value = "club.codeqi.bean.*.*.xml")
public class project_jwt_authApplication {
    public static void main(String[] args) {
        SpringApplication.run(project_jwt_authApplication.class,args);
    }
}
