package gr.hua.dit.it21840.Internalsystem;

import gr.hua.dit.it21840.Internalsystem.entity.Application;
import gr.hua.dit.it21840.Internalsystem.entity.Authorities;
import gr.hua.dit.it21840.Internalsystem.entity.Teacher;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

//https://stackoverflow.com/questions/44046659/return-ids-in-json-response-from-spring-data-rest/44049776
@Component
public class MVCConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Authorities.class);
        config.exposeIdsFor(Teacher.class);
        config.exposeIdsFor(Application.class);
    }



}
