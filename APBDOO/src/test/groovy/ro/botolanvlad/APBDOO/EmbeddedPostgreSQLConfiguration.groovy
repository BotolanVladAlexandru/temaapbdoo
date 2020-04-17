package ro.botolanvlad.APBDOO

import groovy.sql.Sql
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.testcontainers.containers.PostgreSQLContainer

import javax.annotation.PreDestroy
import javax.sql.DataSource
import java.time.Duration

@Configuration
class EmbeddedPostgreSQLConfiguration {

    private PostgreSQLContainer postgresqlContainer
    private DataSource dataSource

    @Bean(destroyMethod = 'stop', name = 'postgresProcess')
    PostgreSQLContainer postgresProcess() throws IOException {
        postgresqlContainer =
                (PostgreSQLContainer) new PostgreSQLContainer("postgres:10.4")
                        .withDatabaseName("facultate")
                        .withUsername("postgres")
                        .withPassword("postgres")
                        .withStartupTimeout(Duration.ofSeconds(600));
        postgresqlContainer.start()
        return postgresqlContainer
    }

    @Bean
    @DependsOn('postgresProcess')
    DataSource datasource() {
        dataSource = DataSourceBuilder
                .create()
                .username("postgres")
                .password("postgres")
                .url(postgresqlContainer.getJdbcUrl())
                .driverClassName("org.postgresql.Driver")
                .build() as DataSource
    }

    @Bean
    @DependsOn('datasource')
    Sql sql() {
        new Sql(dataSource)
    }

    @PreDestroy
    void preDestroy() {
        postgresqlContainer.stop()
    }
}
