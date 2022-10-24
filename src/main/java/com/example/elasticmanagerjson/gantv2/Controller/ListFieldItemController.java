package com.example.elasticmanagerjson.gantv2.Controller;

import com.example.elasticmanagerjson.APIConstants;
import com.example.elasticmanagerjson.EafadResponse;
import com.example.elasticmanagerjson.MessageCodeEnum;
import com.example.elasticmanagerjson.MessageListEnum;
import com.example.elasticmanagerjson.gantv2.Dto.ListFieldDto;
import com.example.elasticmanagerjson.gantv2.Dto.ListFieldItemDto;
import com.example.elasticmanagerjson.gantv2.Service.ListFieldItemService;
import com.example.elasticmanagerjson.gantv2.Service.ListFieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(APIConstants.API_URL + APIConstants.GANTT_LISTFIELDITEM)
@RequiredArgsConstructor
public class ListFieldItemController {

    private final ListFieldItemService listFieldItemService;

    @GetMapping("/findAllByListFieldId/{listFieldId}")
    public EafadResponse<List<ListFieldItemDto>> findAllByModuleItemId(@PathVariable Long listFieldId) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_LISTFIELDITEM_LISTED.getValue()),
                listFieldItemService.findAllByListFieldId(listFieldId)
        );
    }

    @PostMapping("/add")
    public EafadResponse<ListFieldItemDto> add(@RequestBody ListFieldItemDto listFieldItemDto) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_LISTFIELDITEM_ADDED.getValue()),
                listFieldItemService.add(listFieldItemDto)
        );
    }

    @PutMapping("/update/{id}")
    public EafadResponse<ListFieldItemDto> update(@PathVariable Long id, @RequestBody ListFieldItemDto listFieldItemDto) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_LISTFIELDITEM_UPDATED.getValue()),
                listFieldItemService.update(listFieldItemDto, id)
        );
    }

    @DeleteMapping("/delete/{id}")
    public EafadResponse<Boolean> delete(@PathVariable Long id) {
        listFieldItemService.delete(id);
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_LISTFIELDITEM_DELETED.getValue()),
                true
        );
    }
}