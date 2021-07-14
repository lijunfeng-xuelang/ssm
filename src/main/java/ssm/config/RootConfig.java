package ssm.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//数据库
@Configuration
@MapperScan("ssm.mapper")
//@ComponentScan(basePackageClasses = {UserService.class, UserMapper.class})
@ComponentScan(basePackages = {"ssm.service", "ssm.mapper"})
public class RootConfig
{
    @Bean
    public DruidDataSource dataSource()
    {
        DruidDataSource dataSource = new DruidDataSource();

//        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        dataSource.setUrl("jdbc:mysql://localhost:3306/ssm_pro?useSSL=true");

        dataSource.setUsername("root");

        dataSource.setPassword("root");

        return dataSource;
    }


    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean()
    {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();

        configuration.setMapUnderscoreToCamelCase(true);

        sqlSessionFactoryBean.setConfiguration(configuration);

        sqlSessionFactoryBean.setTypeAliasesPackage("com.caj.ssm.model");

        sqlSessionFactoryBean.setDataSource(dataSource());

        return sqlSessionFactoryBean;
    }

}