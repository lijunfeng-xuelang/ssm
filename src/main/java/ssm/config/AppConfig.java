package ssm.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

//在这里我们采用继承重写AbstractAnnotationConfigDispatcherServletInitializer的方法，来配置DisptacherServlet
public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 得到中间层(service、dao、aop、po等)的配置
    // Spring配置，得到bean

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    // 得到controler和ViewResolver的配置
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    // 标识哪些url要经过这个DisptacherServlet处理
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encoding = new CharacterEncodingFilter();

        encoding.setForceEncoding(true);

        encoding.setEncoding("UTF8");

        encoding.setForceRequestEncoding(true);

        encoding.setForceResponseEncoding(true);

        return new Filter[]{encoding};
    }
}
