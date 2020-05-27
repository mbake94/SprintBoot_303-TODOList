package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    TodoRepository todoRepository;

    @RequestMapping("/")
    public String listTasks(Model model){
        model.addAttribute("tasks", todoRepository.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String addTasks(Model model){
      model.addAttribute("task", new Tasks());
      return "addTask";
    }
    @PostMapping("/add")
    public String checkTask(@Valid Tasks tasks, BindingResult result){
        if(result.hasErrors()){
            return "addTask";
        } else {
            todoRepository.save(tasks);
            return "redirect:/";
        }
    }
    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model){
        model.addAttribute("task", todoRepository.findById(id).get());
        return "addTask";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model){
        model.addAttribute("task", todoRepository.findById(id).get());
        todoRepository.deleteById(id);
        return "redirect:/";
    }

}
