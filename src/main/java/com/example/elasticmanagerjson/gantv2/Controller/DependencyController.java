package com.example.elasticmanagerjson.gantv2.Controller;

import com.example.elasticmanagerjson.APIConstants;
import com.example.elasticmanagerjson.EafadResponse;
import com.example.elasticmanagerjson.MessageCodeEnum;
import com.example.elasticmanagerjson.MessageListEnum;
import com.example.elasticmanagerjson.gantv2.Dto.DependencyDto;
import com.example.elasticmanagerjson.gantv2.Dto.FieldDto;
import com.example.elasticmanagerjson.gantv2.Service.DependencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(APIConstants.API_URL + APIConstants.GANTT_DEPENDENCİES)
@RequiredArgsConstructor
@CrossOrigin
public class DependencyController {

    private final DependencyService dependencyService;

    @GetMapping("/findAllByModuleId/{moduleId}")
    @CrossOrigin
    public EafadResponse<List<DependencyDto>> findAllByModuleId(Long moduleId) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_DEPENDENCİES_LISTED.getValue()),
                dependencyService.findAllByModuleId(moduleId)
        );
    }

    @PostMapping("/add")
    @CrossOrigin
    public EafadResponse<DependencyDto> add(@RequestBody DependencyDto dependencyDto) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_FIELDS_ADDED.getValue()),
                dependencyService.add(dependencyDto)
        );
    }

    @PutMapping("/update/{id}")
    @CrossOrigin
    public EafadResponse<DependencyDto> update(@PathVariable Long id, @RequestBody DependencyDto dependencyDto) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_FIELDS_UPDATED.getValue()),
                dependencyService.update(dependencyDto, id)
        );
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public EafadResponse<Boolean> delete(@PathVariable Long id) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_FIELDS_DELETED.getValue()),
                dependencyService.delete(id)
        );
    }

}
