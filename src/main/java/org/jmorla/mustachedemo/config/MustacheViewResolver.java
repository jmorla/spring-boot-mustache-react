package org.jmorla.mustachedemo.config;

import com.github.mustachejava.MustacheFactory;
import org.springframework.web.servlet.view.AbstractTemplateViewResolver;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

/**
 * String MVC {@link org.springframework.web.servlet.ViewResolver} for Mustache.java
 * */
public class MustacheViewResolver extends AbstractTemplateViewResolver {

    private final MustacheFactory mustacheFactory;

    private String charset;

    public MustacheViewResolver(MustacheFactory factory) {
        this.mustacheFactory = factory;
        setViewClass(requiredViewClass());
    }

    @Override
    protected Class<?> requiredViewClass() {
        return MustacheView.class;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    @Override
    protected AbstractUrlBasedView buildView(String viewName) throws Exception {
        MustacheView view = (MustacheView) super.buildView(viewName);
        view.setMustacheFactory(this.mustacheFactory);
        view.setCharset(this.charset);
        return view;
    }

    protected AbstractUrlBasedView instantiateView() {
        return (getViewClass() == MustacheView.class) ? new MustacheView() : super.instantiateView();
    }
}
