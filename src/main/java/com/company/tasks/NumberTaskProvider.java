package com.company.tasks;

import java.util.List;

/**
 * Created by Yevhen on 19.04.2016.
 */
public class NumberTaskProvider implements TaskProvider<Number> {

    private List<Task<Number>> tasks;
    @Override
    public List<Task<Number>> getAllTasks() {
        return tasks;
    }
}
