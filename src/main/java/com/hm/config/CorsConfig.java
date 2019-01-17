package com.hm.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
		@Value("${boot.cors.addallowedorigin:*}")
	    private String allowedorigin;
	    @Value("${boot.cors.addallowedheader:*}")
	    private String allowedheader;
	    @Value("${boot.cors.addallowedmethod:*}")
	    private String allowedmethod;

	    private CorsConfiguration buildConfig() {
	        CorsConfiguration corsConfiguration = new CorsConfiguration();
	        corsConfiguration.setAllowedOrigins(Arrays.asList(allowedorigin.split(","))); // 1
	        corsConfiguration.addAllowedHeader(allowedheader); // 2
	        corsConfiguration.addAllowedMethod(allowedmethod); // 3
	        corsConfiguration.addExposedHeader("SESSIONID");
	        corsConfiguration.setAllowCredentials(true);
	        return corsConfiguration;
	    }
	    @Bean
	    public CorsFilter corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", buildConfig()); // 4
	        return new CorsFilter(source);
	    }
}
