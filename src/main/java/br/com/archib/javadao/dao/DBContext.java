package br.com.archib.javadao.dao;

import br.com.archib.javadao.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class DBContext {

    private AbstractApplicationContext context;

    public DBContext() {
        this.context = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    public Object get(String serviceName) {
        return context.getBean("serviceName");
    }
}
