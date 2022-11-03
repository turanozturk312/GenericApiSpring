package com.example.elasticmanagerjson.gantv2.Controller;

import com.example.elasticmanagerjson.APIConstants;
import com.example.elasticmanagerjson.EafadResponse;
import com.example.elasticmanagerjson.MessageCodeEnum;
import com.example.elasticmanagerjson.MessageListEnum;
import com.example.elasticmanagerjson.gantv2.Dto.FieldDto;
import com.example.elasticmanagerjson.gantv2.Dto.GanttObjectDto;
import com.example.elasticmanagerjson.gantv2.Service.FieldService;
import com.example.elasticmanagerjson.gantv2.Service.GanttObjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(APIConstants.API_URL + APIConstants.GANTT_GANTTOBJECTS)
@RequiredArgsConstructor
@CrossOrigin
public class GanttObjectController {

    private final GanttObjectService ganttObjectService;


    @GetMapping("/findAllByModuleId/{moduleId}")
    @CrossOrigin
    public EafadResponse<List<GanttObjectDto>> findAllByModuleId(@PathVariable Long moduleId) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_GANTTOBJECTS_LISTED.getValue()),
                ganttObjectService.findAllByModuleId(moduleId)
        );
    }


    @PostMapping("/add")
    @CrossOrigin
    public EafadResponse<GanttObjectDto> add(@RequestBody GanttObjectDto ganttObjectDto) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_GANTTOBJECTS_ADDED.getValue()),
                ganttObjectService.add(ganttObjectDto)
        );
    }

    @PutMapping("/update/{id}")
    @CrossOrigin
    public EafadResponse<GanttObjectDto> update(@PathVariable Long id, @RequestBody GanttObjectDto ganttObjectDto) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_GANTTOBJECTS_UPDATED.getValue()),
                ganttObjectService.update(ganttObjectDto, id)
        );
    }

    @PutMapping("/updateActive/{id}")
    @CrossOrigin
    public EafadResponse<GanttObjectDto> updateActive(@PathVariable Long id, @RequestBody GanttObjectDto ganttObjectDto) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_GANTTOBJECTS_UPDATED.getValue()),
                ganttObjectService.updateActive(ganttObjectDto, id)
        );
    }


    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public EafadResponse<Boolean> delete(@PathVariable Long id) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_GANTTOBJECTS_DELETED.getValue()),
                ganttObjectService.delete(id)
        );
    }

}
