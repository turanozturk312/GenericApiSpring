package com.example.elasticmanagerjson.gantv2.Service;

import com.example.elasticmanagerjson.gantv2.Dto.DateFieldDto;
import com.example.elasticmanagerjson.gantv2.Dto.ModuleDto;
import com.example.elasticmanagerjson.gantv2.Entity.DateField;
import com.example.elasticmanagerjson.gantv2.Entity.Module;
import com.example.elasticmanagerjson.gantv2.Repository.DateFieldRepository;
import com.example.elasticmanagerjson.gantv2.Repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModuleService {

    private final ModuleRepository moduleRepository;
    private final ModelMapper modelMapper;

    public List<ModuleDto> findAll(){
        List<Module> modules = moduleRepository.findAll();
        List<ModuleDto> moduleDtos = modules.stream()
                .map(module -> modelMapper.map(module,ModuleDto.class)).collect(Collectors.toList());
        return moduleDtos;
    }

    public ModuleDto add(ModuleDto moduleDto){
        return modelMapper.map(
                moduleRepository.save(
                        modelMapper.map(moduleDto, Module.class)
                ), ModuleDto.class
        );
    }

    public ModuleDto update(ModuleDto moduleDto, Long id){
        if(moduleRepository.findById(id).isEmpty()){

        }
        return modelMapper.map(
                moduleRepository.save(modelMapper.map(moduleDto, Module.class)),ModuleDto.class
        );
    }

    public void delete(Long id){
        if(moduleRepository.findById(id).isEmpty()){

        }
        moduleRepository.deleteById(id);
    }


}
