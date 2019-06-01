package com.naruto.springboot.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cglib.core.Converter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

//@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 【springboot 对于springmvc的扩展】
     *
     *1、springboot自动配置了ViewResolver,ContentNegotiatingViewResolver :组合所有的视图解析器
     * 如何定制我们自己的试图解析器？我们可以给容器中添加一个试图解析器组件(@Bean)
     * @return
     */
    @Bean
    public ContentNegotiatingViewResolver contentNegotiatingViewResolver(){
        return new MyContentNegotiatingViewResolver();
    }

    /**
     *2、springboot自动为我们配置了Converter,formatter
     *  Converter:类型转换组件
     *  Formatter :格式化器
     *  自己添加的格式化转化器，我们只需要放到容器中即可
     * @return
     */
    @Bean
    public Converter  converter(){
        return new MyConverter();
    }

    /**
     * 3、HttpMessageConverters:
     * springMvc用来转换http请求和响应的；User---Json,xml
     * HttpMessageConverters 从容器中确定，获取所有的HttpMessageConverter
     * 自己添加的HttpMessageConverter，我们只需要放到容器中即可
     *
     * @return
     */
    @Bean
    public HttpMessageConverters httpMessageConverters(){
        return new MyHttpMessageConverters();
    }

    class MyContentNegotiatingViewResolver extends ContentNegotiatingViewResolver{
        @Override
        public void setContentNegotiationManager(ContentNegotiationManager contentNegotiationManager) {
            super.setContentNegotiationManager(contentNegotiationManager);
        }

        @Override
        public ContentNegotiationManager getContentNegotiationManager() {
            return super.getContentNegotiationManager();
        }

        @Override
        public void setDefaultViews(List<View> defaultViews) {
            super.setDefaultViews(defaultViews);
        }

        @Override
        public List<View> getDefaultViews() {
            return super.getDefaultViews();
        }

        @Override
        public void setViewResolvers(List<ViewResolver> viewResolvers) {
            super.setViewResolvers(viewResolvers);
        }

        @Override
        public List<ViewResolver> getViewResolvers() {
            return super.getViewResolvers();
        }

        @Override
        protected void initServletContext(ServletContext servletContext) {
            super.initServletContext(servletContext);
        }

        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return super.resolveViewName(viewName, locale);
        }

        @Override
        protected List<MediaType> getMediaTypes(HttpServletRequest request) {
            return super.getMediaTypes(request);
        }
    }

    class MyConverter implements Converter{
        @Override
        public Object convert(Object o, Class aClass, Object o1) {
            return null;
        }
    }

    class MyHttpMessageConverters extends HttpMessageConverters{

        public MyHttpMessageConverters(HttpMessageConverter<?>... additionalConverters) {
            super(additionalConverters);
        }

        @Override
        protected List<HttpMessageConverter<?>> postProcessPartConverters(List<HttpMessageConverter<?>> converters) {
            return super.postProcessPartConverters(converters);
        }
    }


    /**
     *发送 /naruto
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //
        registry.addViewController("/naruto").setViewName("/success");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}
