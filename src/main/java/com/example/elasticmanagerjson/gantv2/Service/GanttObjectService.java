package com.example.elasticmanagerjson.gantv2.Service;

import com.example.elasticmanagerjson.gantv2.Dto.FieldDto;
import com.example.elasticmanagerjson.gantv2.Dto.GanttObjectDto;
import com.example.elasticmanagerjson.gantv2.Entity.Field;
import com.example.elasticmanagerjson.gantv2.Entity.File;
import com.example.elasticmanagerjson.gantv2.Entity.GanttObject;
import com.example.elasticmanagerjson.gantv2.Repository.FieldRepository;
import com.example.elasticmanagerjson.gantv2.Repository.GanttObjectRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class GanttObjectService {

    private final GanttObjectRepository ganttObjectRepository;
    private final FileService fileService;
    private final ModelMapper modelMapper;

    //Findall
    public List<GanttObjectDto> findAllByModuleId(Long moduleId){
        List<GanttObject> ganttObjectList = ganttObjectRepository.findAllByModuleIdOrderByIdAsc(moduleId);
        List<GanttObjectDto> ganttObjectDtoList = ganttObjectList.stream().map(
                ganttObject -> {
                    JSONObject valueJson = new JSONObject(ganttObject.getValue());
                    valueJson.put("id",ganttObject.getId());
                    valueJson.put("moduleId",ganttObject.getModuleId());
                    ganttObject.setValue(valueJson.toString());
                    return modelMapper.map(ganttObject, GanttObjectDto.class);
                }
        ).collect(Collectors.toList());
        return ganttObjectDtoList;
    }

    //Add
    public GanttObjectDto add(GanttObjectDto ganttObjectDto){
        // values içinde file varsa o id li filein gantt obje id sine ekleneni ata
        GanttObject addedGanttObject = ganttObjectRepository.save(modelMapper.map(ganttObjectDto,GanttObject.class));
        Map<String, Object > valueFields = new JSONObject(addedGanttObject.getValue()).toMap();
        if(valueFields.containsKey("file")){
            Long id = Long.valueOf(((HashMap<String,Integer>)valueFields.get("file")).get("id"));
            File file = fileService.getFile(id);
            file.setGanttObjectId(addedGanttObject.getId());
            fileService.update(file,file.getId());
        }
        return modelMapper.map(addedGanttObject, GanttObjectDto.class);
    }

    //Update
    public GanttObjectDto update(GanttObjectDto ganttObjectDto, Long ganttObjectId){
        if(ganttObjectRepository.findById(ganttObjectId).isPresent()){
            return modelMapper.map(ganttObjectRepository.save(modelMapper.map(ganttObjectDto,GanttObject.class)), GanttObjectDto.class);
        }
        return null;
    }

    public GanttObjectDto updateActive(GanttObjectDto ganttObjectDto, Long ganttObjectId){
        if(ganttObjectRepository.findById(ganttObjectId).isPresent()){
            GanttObject ganttObject = ganttObjectRepository.findById(ganttObjectId).get();
            ganttObject.setActive(ganttObjectDto.getActive());
            return modelMapper.map(ganttObjectRepository.save(ganttObject),GanttObjectDto.class);
        }
        return null;
    }

    //Delete
    public Boolean delete(Long ganttObjectId){
        ganttObjectRepository.deleteById(ganttObjectId);
        return true;
    }

}
