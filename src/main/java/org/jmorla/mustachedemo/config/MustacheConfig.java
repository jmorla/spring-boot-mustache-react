package org.jmorla.mustachedemo.config;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.util.MimeType;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Configuration
public class MustacheConfig {

    private static final MimeType DEFAULT_CONTENT_TYPE = MimeType.valueOf("text/html");

    public static final String DEFAULT_PREFIX = "classpath:/templates/";

    public static final String DEFAULT_SUFFIX = ".html";

    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    @Bean
    public MustacheFactory mustacheFactory() {
        return new DefaultMustacheFactory();
    }
    @Bean
    public MustacheViewResolver mustacheViewResolver(MustacheFactory mustacheFactory) {
        MustacheViewResolver resolver = new MustacheViewResolver(mustacheFactory);
        resolver.setPrefix(DEFAULT_PREFIX);
        resolver.setSuffix(DEFAULT_SUFFIX);
        resolver.setCache(false);
        resolver.setContentType(DEFAULT_CONTENT_TYPE.toString());
        resolver.setExposeRequestAttributes(false);
        resolver.setExposeSessionAttributes(false);
        resolver.setAllowRequestOverride(false);
        resolver.setAllowSessionOverride(false);
        resolver.setExposeSpringMacroHelpers(true);
        resolver.setCharset(DEFAULT_CHARSET.name());
        resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return resolver;
    }
}
