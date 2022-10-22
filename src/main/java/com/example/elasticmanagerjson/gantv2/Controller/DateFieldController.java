package com.example.elasticmanagerjson.gantv2.Controller;

import com.example.elasticmanagerjson.APIConstants;
import com.example.elasticmanagerjson.EafadResponse;
import com.example.elasticmanagerjson.MessageCodeEnum;
import com.example.elasticmanagerjson.MessageListEnum;
import com.example.elasticmanagerjson.gantv2.Dto.DateFieldDto;
import com.example.elasticmanagerjson.gantv2.Entity.DateField;
import com.example.elasticmanagerjson.gantv2.Service.DateFieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(APIConstants.API_URL+APIConstants.GANTT_DATEFIELD)
@RequiredArgsConstructor
public class DateFieldController {

    private final DateFieldService dateFieldService;

    /*
    @GetMapping("/findAllByModuleItemId/{moduleItemId}")
    public EafadResponse<List<DateFieldDto>> findAllByModuleItemId(@PathVariable Long moduleItemId){
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_DATEFIELD_ADDED.getValue()),
                dateFieldService.findAllByModuleItemId(moduleItemId)
        );
    }*/

    @GetMapping("/findAllByFk/{fkId}")
    public EafadResponse<List<DateFieldDto>> findAllByModuleItemId(@PathVariable Long fkId) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_DATEFIELD_ADDED.getValue()),
                dateFieldService.findAllByFk("Module_item_id",fkId)
        );
    }



}
