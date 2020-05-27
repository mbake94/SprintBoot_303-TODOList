package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    TodoRepository todoRepository;

    @Override
    public void run(String... strings) throws Exception{
        Tasks tasks;
        tasks = new Tasks();

        tasks.setTaskName("Mow the lawn");
        tasks.setPriority("High");
        tasks.setDate(LocalDate.of(2020, 12, 8));
        todoRepository.save(tasks);
    }

}
