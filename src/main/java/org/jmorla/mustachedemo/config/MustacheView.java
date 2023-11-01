package org.jmorla.mustachedemo.config;

import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.view.AbstractTemplateView;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Locale;
import java.util.Map;

public class MustacheView extends AbstractTemplateView {

    private MustacheFactory factory;

    private String charset;

    public void setMustacheFactory(MustacheFactory factory) {
        this.factory = factory;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    @Override
    protected void renderMergedTemplateModel(Map<String, Object> model,
                                             HttpServletRequest request,
                                             HttpServletResponse response) throws Exception {
        Mustache mustache = createTemplate(getApplicationContext().getResource(getUrl()));
        if(mustache != null) {
            mustache.execute(response.getWriter(), model);
        }
    }

    @Override
    public boolean checkResource(Locale locale) {
        Resource resource = getApplicationContext().getResource(getUrl());
        return (resource != null && resource.exists());
    }

    private Mustache createTemplate(Resource resource) throws IOException {
        try (Reader reader = getReader(resource)) {
            return this.factory.compile(reader, getUrl());
        }
    }

    private Reader getReader(Resource resource) throws IOException {
        if (this.charset != null) {
            return new InputStreamReader(resource.getInputStream(), this.charset);
        }
        return new InputStreamReader(resource.getInputStream());
    }

}
