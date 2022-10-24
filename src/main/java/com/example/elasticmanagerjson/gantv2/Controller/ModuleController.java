package com.example.elasticmanagerjson.gantv2.Controller;

import com.example.elasticmanagerjson.APIConstants;
import com.example.elasticmanagerjson.EafadResponse;
import com.example.elasticmanagerjson.MessageCodeEnum;
import com.example.elasticmanagerjson.MessageListEnum;
import com.example.elasticmanagerjson.gantv2.Dto.ListFieldItemDto;
import com.example.elasticmanagerjson.gantv2.Dto.ModuleDto;
import com.example.elasticmanagerjson.gantv2.Repository.ModuleRepository;
import com.example.elasticmanagerjson.gantv2.Service.ListFieldItemService;
import com.example.elasticmanagerjson.gantv2.Service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(APIConstants.API_URL + APIConstants.GANTT_MODULE)
@RequiredArgsConstructor
@CrossOrigin
public class ModuleController {

    private final ModuleService moduleService;

    @GetMapping("/findAll")
    @CrossOrigin
    public EafadResponse<List<ModuleDto>> findAll() {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_MODULE_LISTED.getValue()),
                moduleService.findAll()
        );
    }

    @PostMapping("/add")
    @CrossOrigin
    public EafadResponse<ModuleDto> add(@RequestBody ModuleDto moduleDto) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_MODULE_ADDED.getValue()),
                moduleService.add(moduleDto)
        );
    }

    @PutMapping("/update/{id}")
    @CrossOrigin
    public EafadResponse<ModuleDto> update(@PathVariable Long id, @RequestBody ModuleDto moduleDto) {
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_MODULE_UPDATED.getValue()),
                moduleService.update(moduleDto, id)
        );
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public EafadResponse<Boolean> delete(@PathVariable Long id) {
        moduleService.delete(id);
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList(MessageListEnum.INFO_GANTT_MODULE_DELETED.getValue()),
                true
        );
    }

}
