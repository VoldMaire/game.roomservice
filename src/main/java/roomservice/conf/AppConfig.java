package roomservice.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import roomservice.datasource.UnitOfWork;
import roomservice.datasource.UnitOfWorkStub;

@Configuration
public class AppConfig {

    @Bean
    public UnitOfWork UnitOfWork(){
        return new UnitOfWorkStub();
    }
}
