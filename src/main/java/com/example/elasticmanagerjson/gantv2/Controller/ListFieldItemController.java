package com.example.elasticmanagerjson.gantv2.Controller;

import com.example.elasticmanagerjson.APIConstants;
import com.example.elasticmanagerjson.EafadResponse;
import com.example.elasticmanagerjson.MessageCodeEnum;
import com.example.elasticmanagerjson.MessageListEnum;
import com.example.elasticmanagerjson.gantv2.Dto.FieldDto;
import com.example.elasticmanagerjson.gantv2.Dto.ListFieldItemDto;
import com.example.elasticmanagerjson.gantv2.Service.FieldService;
import com.example.elasticmanagerjson.gantv2.Service.ListFieldItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(APIConstants.API_URL + APIConstants.GANTT_LISTFIELDITEMS)
@RequiredArgsConstructor
@CrossOrigin
public class ListFieldItemController {

    private final ListFieldItemService listFieldItemService;

    @GetMapping("/findAllByFieldId/{fieldId}")
    @CrossOrigin
    public EafadResponse<List<ListFieldItemDto>> findAllByModuleId(@PathVariable Long fieldId) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_LISTFIELDITEM_LISTED.getValue()),
                listFieldItemService.findAllByFieldId(fieldId)
        );
    }

    @PostMapping("/add")
    @CrossOrigin
    public EafadResponse<ListFieldItemDto> add(@RequestBody ListFieldItemDto listFieldItemDto) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_LISTFIELDITEM_ADDED.getValue()),
                listFieldItemService.add(listFieldItemDto)
        );
    }

    @PutMapping("/update/{id}")
    @CrossOrigin
    public EafadResponse<ListFieldItemDto> update(@PathVariable Long id, @RequestBody ListFieldItemDto listFieldItemDto) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_LISTFIELDITEM_UPDATED.getValue()),
                listFieldItemService.update(listFieldItemDto, id)
        );
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public EafadResponse<Boolean> delete(@PathVariable Long id) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_LISTFIELDITEM_DELETED.getValue()),
                listFieldItemService.delete(id)
        );
    }

}
