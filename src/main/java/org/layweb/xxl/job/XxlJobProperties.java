package org.layweb.xxl.job;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Lay
 * @since x.x
 */
@Data
@ConfigurationProperties(prefix = "xxl.job")
public class XxlJobProperties {

    private String adminAddress = "http://127.0.0.1:8080/xxl-job-admin";
    private String accessToken = "";
    private XxlJobExecutorProperties executor;

    @Data
    public static class XxlJobExecutorProperties {
        private String appName;

        private String address;
        private String ip;
        private Integer port;

        private String logPath;

        private Integer logRetentionDays = 7;
    }
}
