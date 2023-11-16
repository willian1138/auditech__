package fbw.auditech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import fbw.auditech.model.Palavras;

@Configuration
public class AppConfig {

    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public Palavras palavras(){
        return new Palavras();
    }
}
