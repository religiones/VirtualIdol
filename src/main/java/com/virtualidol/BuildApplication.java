package com.virtualidol;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class BuildApplication extends SpringBootServletInitializer
{
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder)
    {
        return applicationBuilder.sources(new Class[] { VirtualidolApplication.class });
    }
}