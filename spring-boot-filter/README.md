  先导入 servlet-api jar 包，才可以使用filter
  
  
  注意：用        <dependency>
                  <groupId>org.springframework.boot</groupId>
                  <artifactId>spring-boot-starter-thymeleaf</artifactId>
                  <version>2.0.0.M4</version>
              </dependency>
              这个版本会导致404
              
            关于WebMvcConfigurerAdapter已过时了：  注意：Spring Boot2.0的版本（创建的时候自动选择的这个版本），然后编译器告诉我WebMvcConfigurerAdapter已过时了
              新的实现是： 
                           
                   @Configuration
                   public class WebMvcConfg implements WebMvcConfigurer {
                     //省略
                   }
                   @Configuration
                   public class WebMvcConfg extends WebMvcConfigurationSupport {
                     //省略
                   }
参考(这里)[https://blog.csdn.net/hanziang1996/article/details/79655140]

问题：
1：使用拦截器跟过滤器有啥区别——过滤器在拦截器前处理，
2：过滤器生效的条件是——通过扫描servlet-api Filter 的实现类 来触发过滤链
3：拦截器生效的条件是——生成一个HandlerInterceptor 的实现类，在配置类WebMvcConfigurationSupport 通过addInterceptors使其生效    