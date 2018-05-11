/**
 * 
 */
package com.proginn.security.core;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.proginn.security.core.properties.SecurityProperties;

/**
 * @author zhailiang
 *
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

}
