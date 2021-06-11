package com.example.todo.Controller;

import com.example.todo.Dao.TaskRepository;
import com.example.todo.Model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController {

@Autowired
private TaskRepository taskRepository;
private Task task = new Task();
private HashMap<Integer, String> taskHashMap = new HashMap<>();

@PostMapping(path = "/addTask")
public void addTask(@RequestBody String Description){
    System.out.println("Getting Task ");
    task.setDescription(Description);
    saveTask();
}

@GetMapping("/printTask")
public void printTask(){
    int count = 0;
    for (Map.Entry tasks : taskHashMap.entrySet()) {
        count = count + 1;
        System.out.println("Task " + count + " : " + tasks.getValue());
    }
}

public void saveTask(){
    System.out.println("saving task");
    taskHashMap.put(task.getId(), task.getDescription());
}

}
