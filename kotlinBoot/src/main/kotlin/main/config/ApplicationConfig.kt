package main.config

import io.ebean.EbeanServer
import io.ebean.EbeanServerFactory
import io.ebean.config.ServerConfig
import io.ebean.spring.txn.SpringJdbcTransactionManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class ApplicationConfig {
    /*
   * 生成 EbeanServer Bean
   */
    @Bean
    fun getEbeanServer(dataSource: DataSource): EbeanServer {
        print("test "+dataSource)
        val config = ServerConfig()
        config.name = "ebeandb" // from ebean.properties

        //config.setDataSource(DataSourceUtil.getDataSource()) //从DataSourceUtil获取数据源
        config.setDataSource(dataSource) //这里使用spring注入的数据源
        config.setExternalTransactionManager(SpringJdbcTransactionManager()) //事物管理器

        config.loadFromProperties()
        config.setDefaultServer(true)
        config.setRegister(true)

        return EbeanServerFactory.create(config)
    }
}