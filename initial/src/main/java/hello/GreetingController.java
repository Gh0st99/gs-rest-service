package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Bao on 2017-5-3.
 */

// 使得返回 domain object 而不是 view
// 是@Controller + @ResponseBody
@RestController
public class GreetingController {

    private static final String greetingTemplate = "Hello %s";
    private final AtomicLong counter = new AtomicLong();

    // 将/greeting 路由到该方法
    // 并没有指定get,put,post等等，因为会默认将所有http操作都路由到这上面来
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World")String name) {
        // restful 不同于传统的MVC(view)，在服务器端将greeting数据提供给HTML
        // 而只是返回其json格式的数据
        // 而Spring会帮你将其转换为JSON（MappingJackson2HttpMessageConverter）
        return new Greeting(counter.incrementAndGet(),
                String.format(greetingTemplate, name));
    }
}
