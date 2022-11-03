package com.example.elasticmanagerjson.gantv2.Controller;

import com.example.elasticmanagerjson.APIConstants;
import com.example.elasticmanagerjson.EafadResponse;
import com.example.elasticmanagerjson.MessageCodeEnum;
import com.example.elasticmanagerjson.MessageListEnum;
import com.example.elasticmanagerjson.gantv2.Dto.FieldDto;
import com.example.elasticmanagerjson.gantv2.Dto.ModuleDto;
import com.example.elasticmanagerjson.gantv2.Service.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(APIConstants.API_URL + APIConstants.GANTT_FIELDS)
@RequiredArgsConstructor
@CrossOrigin
public class FieldController {

    private final FieldService fieldService;

    @GetMapping("/findAllByModuleId")
    @CrossOrigin
    public EafadResponse<List<FieldDto>> findAllByModuleId(Long moduleId) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_FIELDS_LISTED.getValue()),
                fieldService.findAllByModuleId(moduleId)
        );
    }

    @GetMapping("/findAllByModuleIdAndPart")
    @CrossOrigin
    public EafadResponse<List<FieldDto>> findAllByModuleIdAndPart(@RequestParam(name = "module_id") Long moduleId, @RequestParam(name = "part") String part) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_FIELDS_LISTED.getValue()),
                fieldService.findAllByModuleIdAndPart(moduleId, part)
        );
    }

    @PostMapping("/add")
    @CrossOrigin
    public EafadResponse<FieldDto> add(@RequestBody FieldDto fieldDto) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_FIELDS_ADDED.getValue()),
                fieldService.add(fieldDto)
        );
    }

    @PutMapping("/update/{id}")
    @CrossOrigin
    public EafadResponse<FieldDto> update(@PathVariable Long id, @RequestBody FieldDto fieldDto) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_FIELDS_UPDATED.getValue()),
                fieldService.update(fieldDto, id)
        );
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public EafadResponse<Boolean> delete(@PathVariable Long id) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_FIELDS_DELETED.getValue()),
                fieldService.delete(id)
        );
    }

}

