package com.example.todo.Controller;

import com.example.todo.Dao.TaskRepository;
import com.example.todo.Model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/messages")
public class AccountController {

@Autowired
private TaskRepository taskRepository;
private HashMap<Integer, String> taskHashMap = new HashMap<>();
private ArrayList<Task> taskList = new ArrayList<>();

@PostMapping(path = "/addTask")
public void addTask(@RequestBody String Description){
    System.out.println("Getting Task ");
    Task task = new Task(Description, 23);
    saveTask();
}

@GetMapping("/printTask")
public void printTask(){
    taskHashMap.put(1, "I would like to take dog to park");
    taskHashMap.put(2, "I should do my laundry today");
    taskHashMap.put(3, "I need to finish Java App");
    taskHashMap.put(4, "I should cook pasta for Veeru");
    taskHashMap.put(5, "I want to clean cages");
    int count = 0;
    for (Map.Entry tasks : taskHashMap.entrySet()) {
        count = count + 1;
        System.out.println("Task " + count + " : " + tasks.getValue());
    }
}

@GetMapping("/test")
public ArrayList<Task> test(){
    taskList.clear();
    taskList.add(new Task("I would like to take dog to park",1));
    taskList.add(new Task("I should do my laundry today",2));
    taskList.add(new Task("I need to finish Java App",3));
    taskList.add(new Task("I should cook pasta for Veeru",4));
    taskList.add(new Task("I want to clean cages",5));

    return taskList;
}

    @DeleteMapping("/delete")
    public String delete(){
        return "Task Deleted";
    }

public void saveTask(){
    System.out.println("saving task");
    //taskHashMap.put(task.getId(), task.getDescription());
}

}
