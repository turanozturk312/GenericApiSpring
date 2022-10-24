package com.example.elasticmanagerjson.gantv2.Service;

import com.example.elasticmanagerjson.gantv2.Dto.ModuleFieldDto;
import com.example.elasticmanagerjson.gantv2.Entity.ModuleField;
import com.example.elasticmanagerjson.gantv2.Repository.ModuleFieldRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModuleFieldsService {

    private final ModuleFieldRepository moduleFieldRepository;
    private final ModelMapper modelMapper;

    public List<ModuleFieldDto> findAll(@PathVariable Long moduleId) {

        List<ModuleFieldDto> moduleFieldDtoList = moduleFieldRepository.findAllByModuleId(moduleId).stream().map(
                moduleField -> modelMapper.map(moduleField, ModuleFieldDto.class)
        ).collect(Collectors.toList());

        return moduleFieldDtoList;
    }

    public ModuleFieldDto add(ModuleFieldDto moduleFieldDto) {
        return modelMapper.map(
                moduleFieldRepository.save(modelMapper.map(moduleFieldDto, ModuleField.class)),
                ModuleFieldDto.class
        );
    }

    public ModuleFieldDto update(ModuleFieldDto moduleFieldDto, Long id){
        if(moduleFieldRepository.findById(id).isEmpty()){

        }
        return modelMapper.map(
                moduleFieldRepository.save(modelMapper.map(moduleFieldDto, ModuleField.class)), ModuleFieldDto.class
        );
    }

    public void delete(Long id){
        if(moduleFieldRepository.findById(id).isEmpty()){

        }
        moduleFieldRepository.deleteById(id);
    }

}
