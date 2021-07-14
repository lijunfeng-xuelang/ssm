package ssm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @EnableWebMvc是使用Java 注解快捷配置Spring Webmvc的一个注解。
 * 在使用该注解后配置一个继承于WebMvcConfigurerAdapter的配置类即可配置好Spring Webmvc。
 */
//xxx-servlet.xml
@Configuration
@EnableWebMvc
@ComponentScan("ssm.controller")
public class WebConfig extends WebMvcConfigurerAdapter
{

//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry)
//    {
//        registry.jsp("/WEB-INF/jsp/", ".jsp");
//
//        registry.viewResolver(new InternalResourceViewResolver());
//    }

    @Bean
    public ViewResolver viewResolver()
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setViewClass(JstlView.class);

//        viewResolver.setExposeContextBeansAsAttributes(true);

        viewResolver.setPrefix("/WEB-INF/jsp/");

        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        configurer.enable();
    }
}
