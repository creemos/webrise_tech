package creemos.webrise.subs.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author kay 07.05.2025
 */
@Configuration
@EntityScan(basePackages = "creemos.webrise.subs.entity")
@ComponentScan(basePackages = "creemos.webrise.subs.service")
@EnableTransactionManagement
public class JpaConfig {
}
