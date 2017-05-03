package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Bao on 2017-5-3.
 */

/*包含：
    @Configuration              标记class为application上下文的bean定义的源
    @EnableAutoConfiguration
    @EnableWebMvc
    @ComponentScan              在hello中查找
*/
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
