package com.jdsk.people.config;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class ExecutorConfig implements AsyncConfigurer {
	 @Bean(name = "taskExecutor")
	ThreadPoolTaskExecutor taskExecutor()   {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors()*5);
        executor.setQueueCapacity(Runtime.getRuntime().availableProcessors()*10);
        executor.setThreadNamePrefix("replacedAsync-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //executor.setRejectedExecutionHandler(new ThreadPoolExecutor(0, 0, 0, null, null).CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    @Override
    public ThreadPoolTaskExecutor getAsyncExecutor() {
        return taskExecutor();
    }
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}
