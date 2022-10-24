package com.example.elasticmanagerjson.gantv2.Controller;

import com.example.elasticmanagerjson.APIConstants;
import com.example.elasticmanagerjson.EafadResponse;
import com.example.elasticmanagerjson.MessageCodeEnum;
import com.example.elasticmanagerjson.MessageListEnum;
import com.example.elasticmanagerjson.gantv2.Dto.ModuleFieldDto;
import com.example.elasticmanagerjson.gantv2.Service.ModuleFieldsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(APIConstants.API_URL+APIConstants.GANTT_FIELDS)
@RequiredArgsConstructor
@CrossOrigin
public class ModuleFieldController {

    private final ModuleFieldsService moduleFieldsService;

    @GetMapping("/findAllByModuleId/{moduleId}")
    @CrossOrigin
    public EafadResponse<List<ModuleFieldDto>> findAll(@PathVariable Long moduleId){
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList("Listelendi"),
                moduleFieldsService.findAll(moduleId)
        );
    }

    @PostMapping("/add")
    @CrossOrigin
    public EafadResponse<ModuleFieldDto> add(@RequestBody ModuleFieldDto moduleFieldDto){
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList("Field Eklendi"),
                moduleFieldsService.add(moduleFieldDto)
        );
    }

    @PutMapping("/update/{id}")
    @CrossOrigin
    public EafadResponse<ModuleFieldDto> update(@PathVariable Long id, @RequestBody ModuleFieldDto moduleFieldDto){
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_LISTFIELD_UPDATED.getValue()),
                moduleFieldsService.update(moduleFieldDto, id)
        );
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public EafadResponse<Boolean> delete(@PathVariable Long id){
        moduleFieldsService.delete(id);
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_LISTFIELD_DELETED.getValue()),
                true
        );
    }




}
