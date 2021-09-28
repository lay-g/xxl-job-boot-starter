package org.layweb.xxl.job;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lay
 * @since x.x
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(XxlJobProperties.class)
public class XxlJobConfiguration {

    @Bean
    public XxlJobSpringExecutor xxlJobExecutor(XxlJobProperties properties) {
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(properties.getAdminAddress());
        xxlJobSpringExecutor.setAccessToken(properties.getAccessToken());

        XxlJobProperties.XxlJobExecutorProperties executorProperties = properties.getExecutor();
        xxlJobSpringExecutor.setAppname(executorProperties.getAppName());
        xxlJobSpringExecutor.setAddress(executorProperties.getAddress());
        xxlJobSpringExecutor.setIp(executorProperties.getIp());
        xxlJobSpringExecutor.setPort(executorProperties.getPort());
        xxlJobSpringExecutor.setLogPath(executorProperties.getLogPath());
        xxlJobSpringExecutor.setLogRetentionDays(executorProperties.getLogRetentionDays());

        return xxlJobSpringExecutor;
    }
}
