package com.company.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = {"com.company"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
