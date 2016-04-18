package com.company;

import com.company.tasks.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bootstrap {
    private static final double emptyDoubleArray[] = {};
    private static final double calcAverageDoubleValueTaskInputData[] = {123.66, 55.0, 729.8, 44.0};
    private static final double TransformCelsiusToFahrenheitTaskInputData = 23.0;
    private static final Double X1 = 3.0;
    private static final Double Y1 = 5.3;
    private static final Double X2 = 7.2;
    private static final Double Y2 = 1.1;

    private static TaskExecutor<Number> taskExecutor = new TaskExecutor<>();

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
    }

    public void execute() throws Exception {
        taskExecutor.addTask(new CalcAverageDoubleValueTask(calcAverageDoubleValueTaskInputData), new NotNullValidator<>());
        taskExecutor.addTask(new CalcAverageDoubleValueTask(emptyDoubleArray), new NotNullValidator<>());
        taskExecutor.addTask(new TransformCelsiusToFahrenheitTask(TransformCelsiusToFahrenheitTaskInputData));
        taskExecutor.addTask(new CalcDistanceTask(X1, Y1, X2, Y2));

        taskExecutor.execute();

        System.out.println("Valid results:");
        taskExecutor.getValidResults().forEach(System.out::println);
        System.out.println("Invalid results:");
        taskExecutor.getInvalidResults().forEach(System.out::println);
    }
}
