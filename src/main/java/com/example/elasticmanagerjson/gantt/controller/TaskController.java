package com.example.elasticmanagerjson.gantt.controller;

import com.example.elasticmanagerjson.EafadResponse;
import com.example.elasticmanagerjson.MessageCodeEnum;
import com.example.elasticmanagerjson.gantt.dto.TaskDto;
import com.example.elasticmanagerjson.gantt.entity.Task;
import com.example.elasticmanagerjson.gantt.repository.ModuleRepository;
import com.example.elasticmanagerjson.gantt.repository.TaskRepository;
import com.example.elasticmanagerjson.gantt.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.example.elasticmanagerjson.APIConstants.API_URL;

@RestController
@RequestMapping(API_URL + "/tasks")
@RequiredArgsConstructor
@CrossOrigin
public class TaskController {

    private final TaskService taskService;
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;


    @GetMapping("findAllByModuleId/{moduleId}")
    @CrossOrigin
    public EafadResponse<List<Task>> findAllByModuleId(@PathVariable Long moduleId) {
        return new EafadResponse<List<Task>>(HttpStatus.OK, MessageCodeEnum.INFO, Arrays.asList("Verilerss getirildi."), taskRepository.findAllByModuleId(moduleId));
    }

    @GetMapping("getById/{id}")
    @CrossOrigin
    public EafadResponse<TaskDto> getById(@PathVariable Long id) {
        return new EafadResponse<TaskDto>(HttpStatus.OK, MessageCodeEnum.INFO, Arrays.asList("Veriler getirildi."), taskService.getById(id));
    }

    @PostMapping("/addTask")
    @CrossOrigin
    public EafadResponse<TaskDto> addTask(@RequestBody TaskDto taskDto) {
        return new EafadResponse<TaskDto>(HttpStatus.OK,MessageCodeEnum.INFO,Arrays.asList("Task Eklendi."), taskService.add(taskDto));
    }

    @PostMapping("/updateTask/{id}")
    @CrossOrigin
    public EafadResponse<TaskDto> updateTask(@RequestBody TaskDto taskDto, @PathVariable Long id) {
        return new EafadResponse<TaskDto>(HttpStatus.OK,MessageCodeEnum.INFO,Arrays.asList("Task Eklendi."),taskService.update(taskDto,id));
    }

    @DeleteMapping("/deleteTask/{id}")
    @CrossOrigin
    public EafadResponse<Boolean> deleteTask(@PathVariable Long id){
         return new EafadResponse<Boolean>(HttpStatus.OK,MessageCodeEnum.INFO,Arrays.asList("Task Silindi"), taskService.delete(id));
    }



}
