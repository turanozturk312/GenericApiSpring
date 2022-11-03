package com.example.elasticmanagerjson.gantv2.Service;

import com.example.elasticmanagerjson.gantv2.Dto.DependencyDto;
import com.example.elasticmanagerjson.gantv2.Dto.FieldDto;
import com.example.elasticmanagerjson.gantv2.Entity.Dependeny;
import com.example.elasticmanagerjson.gantv2.Entity.Field;
import com.example.elasticmanagerjson.gantv2.Repository.DependencyRepository;
import com.example.elasticmanagerjson.gantv2.Repository.FieldRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DependencyService {

    private final DependencyRepository dependencyRepository;
    private final ModelMapper modelMapper;

    //Findall
    public List<DependencyDto> findAllByModuleId(Long moduleId){
        List<Dependeny> fieldList = dependencyRepository.findAllByModuleId(moduleId);
        List<DependencyDto> dependencyDtoList = fieldList.stream().map(
                dependency -> modelMapper.map(dependency, DependencyDto.class)
        ).collect(Collectors.toList());
        return dependencyDtoList;
    }

    //Add
    public DependencyDto add(DependencyDto dependencyDto){
        return modelMapper.map(dependencyRepository.save(modelMapper.map(dependencyDto,Dependeny.class)), DependencyDto.class);
    }

    //Update
    public DependencyDto update(DependencyDto dependencyDto, Long dependencyId){
        if(dependencyRepository.findById(dependencyId).isPresent()){
            return modelMapper.map(dependencyRepository.save(modelMapper.map(dependencyDto,Dependeny.class)), DependencyDto.class);
        }
        return null;
    }

    //Delete
    public Boolean delete(Long fieldId){
        dependencyRepository.deleteById(fieldId);
        return true;
    }

}
