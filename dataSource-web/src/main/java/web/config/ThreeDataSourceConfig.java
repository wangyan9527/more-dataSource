package web.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "dal.db3.mapper", sqlSessionFactoryRef = "threeSqlSessionFactory")
public class ThreeDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.dataSource.three")
    public DataSource threeDataSource() {
        System.out.println(" three ******* dataSource ");
        return DataSourceBuilder.create().build();
    }

    /**
     * 多数据源时需要使用@Qualifier注解已明确使用那个数据源,否则spring无法根据类型自动注入
     *
     * @param dataSource
     * @return
     */
    @Bean
    public DataSourceTransactionManager threeTransactionManager(@Qualifier("threeDataSource") DataSource dataSource) {
        System.out.println(" three ******* dataSourceTransactionManager");
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactory threeSqlSessionFactory(@Qualifier("threeDataSource") DataSource dataSource) throws Exception {
        System.out.println(" three ****** sqlSessionFactory");
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate threeSqlSessionTemplate(@Qualifier("threeSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        System.out.println(" three ****** sqlSessionTemplate");
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
