/*
package kr.co.test.tech.example

import javax.sql.DataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.PlatformTransactionManager

@Configuration
class DataSourceConfig {
    @Value("\${spring.datasource.url}")
    private val url: String? = null

    @Value("\${spring.datasource.username}")
    private val username: String? = null

    @Value("\${spring.datasource.password}")
    private val password: String? = null

    @Value("\${spring.datasource.driver-class-name}")
    private val driverClassName: String? = null

    @Bean
    fun dataSource(): DataSource {
            val dataSourceBuilder = DataSourceBuilder.create()
            dataSourceBuilder.driverClassName(driverClassName)
            dataSourceBuilder.url(url)
            dataSourceBuilder.username(username)
            dataSourceBuilder.password(password)
            return dataSourceBuilder.build()
    }

    @Bean
    fun transactionManager(@Qualifier("dataSource") dataSource: DataSource): PlatformTransactionManager {
        return DataSourceTransactionManager(dataSource)
    }

}

*/
