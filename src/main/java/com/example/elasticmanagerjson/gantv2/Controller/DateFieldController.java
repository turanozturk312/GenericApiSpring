package com.example.elasticmanagerjson.gantv2.Controller;

import com.example.elasticmanagerjson.APIConstants;
import com.example.elasticmanagerjson.EafadResponse;
import com.example.elasticmanagerjson.MessageCodeEnum;
import com.example.elasticmanagerjson.MessageListEnum;
import com.example.elasticmanagerjson.gantv2.Dto.DateFieldDto;
import com.example.elasticmanagerjson.gantv2.Entity.DateField;
import com.example.elasticmanagerjson.gantv2.Entity.DateFieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(APIConstants.API_URL+APIConstants.GANTT_DATEFIELD)
@RequiredArgsConstructor
public class DateFieldController {

    private final DateFieldService dateFieldService;

    @GetMapping("/findAllByModuleItemId/{moduleItemId}")
    public EafadResponse<List<DateFieldDto>> findAllByModuleItemId(@PathVariable Long moduleItemId){
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_DATEFIELD_ADDED.getValue()),
                dateFieldService.findAllByModuleItemId(moduleItemId)
        );
    }

    @PostMapping("/add")
    public EafadResponse<DateFieldDto> add(@RequestBody DateFieldDto dateFieldDto){
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_DATEFIELD_ADDED.getValue()),
                dateFieldService.add(dateFieldDto)
        );
    }

    @PutMapping("/update/{id}")
    public EafadResponse<DateFieldDto> update(@PathVariable Long id, @RequestBody DateFieldDto dateFieldDto){
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_DATEFIELD_UPDATED.getValue()),
                dateFieldService.update(dateFieldDto, id)
        );
    }

    @DeleteMapping("/delete/{id}")
    public EafadResponse<Boolean> delete(@PathVariable Long id){
        dateFieldService.delete(id);
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_DATEFIELD_DELETED.getValue()),
                true
        );
    }

}
