package com.wlqk.cn;

import com.wlqk.cn.utils.MailSendUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanRegistryCenterConfig {
    /**
     * 邮箱工具类 bean 注册
     **/
    @Bean
    public MailSendUtils mailSendUtils() {
        return new MailSendUtils();
    }
}
