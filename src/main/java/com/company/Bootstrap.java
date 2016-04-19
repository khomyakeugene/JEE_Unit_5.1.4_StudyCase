package com.company;

import com.company.tasks.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bootstrap {
    private TaskProvider<Number> taskProvider;
    private Executor<Number> executor;

    public static void main(String[] args) throws Exception  {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Bootstrap bootstrap = applicationContext.getBean("bootstrap", Bootstrap.class);
        bootstrap.execute();
    }

    private void execute() throws Exception {
        taskProvider.getAllTasks().forEach(executor::addTask);

        executor.execute();

        System.out.println("Valid results:");
        executor.getValidResults().forEach(System.out::println);
        System.out.println("Invalid results:");
        executor.getInvalidResults().forEach(System.out::println);
    }

    public void setTaskProvider(TaskProvider<Number> taskProvider) {
        this.taskProvider = taskProvider;
    }

    public void setExecutor(Executor<Number> executor) {
        this.executor = executor;
    }
}
