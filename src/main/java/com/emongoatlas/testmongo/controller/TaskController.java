package com.emongoatlas.testmongo.controller;

import com.emongoatlas.testmongo.entity.Task;
import com.emongoatlas.testmongo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongo/v1/example")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/savetask")
    @ResponseStatus(HttpStatus.OK)
    public Task createTask(@RequestBody Task task){
        return taskService.saveTask(task);
    }

    @GetMapping("/getall")
    public List<Task> getAlltasks(){
        return taskService.findAlltasks();
    }

    @GetMapping("/getbyid/{id}")
    public Task getTaskById(@PathVariable("id") String Id){
        return taskService.getTaskById(Id);
    }

   @GetMapping("/getbyseverity/{severity}")
    public List<Task> getTaskBySeverity(@PathVariable("severity") int severity){
        return taskService.getTaskBySeverity(severity);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Task> getByAssignee(@PathVariable("assignee") String assignee){
        return taskService.getTaskByAssignee(assignee);
    }

    @PutMapping
    public Task modifyTask(@RequestBody Task task){
        return  taskService.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable("taskId") String taskId){
        return  taskService.deleteTask(taskId);
    }
}
