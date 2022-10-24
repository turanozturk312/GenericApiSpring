package com.example.elasticmanagerjson.gantv2.Controller;

import com.example.elasticmanagerjson.APIConstants;
import com.example.elasticmanagerjson.EafadResponse;
import com.example.elasticmanagerjson.MessageCodeEnum;
import com.example.elasticmanagerjson.MessageListEnum;
import com.example.elasticmanagerjson.gantv2.Dto.ListFieldDto;
import com.example.elasticmanagerjson.gantv2.Entity.ListField;
import com.example.elasticmanagerjson.gantv2.Service.ListFieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(APIConstants.API_URL+APIConstants.GANTT_LISTFIELD)
@RequiredArgsConstructor
public class ListFieldController {

    private final ListFieldService listFieldService;



    @PostMapping("/add")
    public EafadResponse<ListFieldDto> add(@RequestBody ListFieldDto ListFieldDto){
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_LISTFIELD_ADDED.getValue()),
                listFieldService.add(ListFieldDto)
        );
    }

    @PutMapping("/update/{id}")
    public EafadResponse<ListFieldDto> update(@PathVariable Long id, @RequestBody ListFieldDto ListFieldDto){
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_LISTFIELD_UPDATED.getValue()),
                listFieldService.update(ListFieldDto, id)
        );
    }

    @DeleteMapping("/delete/{id}")
    public EafadResponse<Boolean> delete(@PathVariable Long id){
        listFieldService.delete(id);
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_LISTFIELD_DELETED.getValue()),
                true
        );
    }

}
