package com.example.elasticmanagerjson.gantt.service;

import com.example.elasticmanagerjson.ExceptionUtil;
import com.example.elasticmanagerjson.MessageCodeEnum;
import com.example.elasticmanagerjson.gantt.dto.TaskDto;
import com.example.elasticmanagerjson.gantt.entity.Task;
import com.example.elasticmanagerjson.gantt.repository.ModuleRepository;
import com.example.elasticmanagerjson.gantt.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.swing.text.html.parser.Entity;
import java.util.Arrays;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ModuleRepository moduleRepository;
    private final ModelMapper modelMapper;


    public TaskService(ModelMapper modelMapper,  TaskRepository taskRepository, ModuleRepository moduleRepository) {

        this.taskRepository = taskRepository;
        this.moduleRepository = moduleRepository;
        this.modelMapper = modelMapper;

    }

    public List<TaskDto> findAll(){
        return modelMapper.map(taskRepository.findAll(), List.class);
    }

    public TaskDto getById(Long id){
        return (TaskDto) modelMapper.map(taskRepository.findById(id).get(),TaskDto.class);
    }

    public TaskDto add(TaskDto taskDto){
        return modelMapper.map(taskRepository.save(modelMapper.map(taskDto, Task.class)),TaskDto.class);
    }

    public TaskDto update(TaskDto taskDto, Long id){
        if(ObjectUtils.isEmpty(taskRepository.findById(id))){
            ExceptionUtil.throwIfAny(Arrays.asList("böyle bi id yok"), MessageCodeEnum.ERROR);
        }
        return modelMapper.map(taskRepository.save(modelMapper.map(taskDto,Task.class)), TaskDto.class);
    }

    public Boolean delete(Long id){
        if(ObjectUtils.isEmpty(taskRepository.findById(id))){
            ExceptionUtil.throwIfAny(Arrays.asList("böyle bi id yok"), MessageCodeEnum.ERROR);
        }
        taskRepository.deleteById(id);
        return true;
    }



}
