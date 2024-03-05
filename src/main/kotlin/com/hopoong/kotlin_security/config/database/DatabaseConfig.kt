package com.hopoong.kotlin_security.config.database

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@ComponentScan(basePackages = ["com.hopoong.kotlin_security.*"])
@EnableTransactionManagement
class DatabaseConfig {

    @Bean
    @Throws(Exception::class)
    fun sqlSessionFactory(dataSource: DataSource): SqlSessionFactory {
        val sessionFactory = SqlSessionFactoryBean()
        sessionFactory.setDataSource(dataSource)
        val resolver = PathMatchingResourcePatternResolver()
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/**/*.xml"))
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/**/**/*.xml"))
        return sessionFactory.getObject()
    }

    @Bean
    @Throws(Exception::class)
    fun sqlSessionTemplate(sqlSessionFactory: SqlSessionFactory): SqlSessionTemplate {
        return SqlSessionTemplate(sqlSessionFactory)
    }

    @Bean
    fun transactionManager(dataSource: DataSource): DataSourceTransactionManager {
        return DataSourceTransactionManager(dataSource)
    }
}