package pl.coderslab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.coderslab.converter.EventConverter;
import pl.coderslab.converter.UserConverter;
import pl.coderslab.entity.Event;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"pl.coderslab" })
@EnableTransactionManagement
public class AppConfig extends WebMvcConfigurerAdapter {
    @Override
    public	void	addCorsMappings(CorsRegistry registry)	{
        registry.addMapping("/**")
                .allowedMethods("GET",	"POST",	"PUT",	"DELETE");
        //.allowedOrigins("http://localhost");
    }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("fiestaPersistenceUnit");
        return emfb;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager tm = new JpaTransactionManager(emf);
        return tm;
    }
    @Override
    public	void	configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer)	{
        configurer.enable();
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    @Bean
    public Validator validator()	{
        return	new LocalValidatorFactoryBean();
    }

    @Bean
    public UserConverter getUserConverter() {
        return new UserConverter();
    }
    @Bean
    public EventConverter getEventConverter() {
        return new EventConverter();
    }

}
