package com.example.elasticmanagerjson.gantv2.Service;

import com.example.elasticmanagerjson.gantv2.Dto.FieldDto;
import com.example.elasticmanagerjson.gantv2.Entity.Field;
import com.example.elasticmanagerjson.gantv2.Repository.FieldRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FieldService {

     private final FieldRepository fieldRepository;
     private final ModelMapper modelMapper;

     //Findall
     public List<FieldDto> findAllByModuleId(Long moduleId){
        List<Field> fieldList = fieldRepository.findAllByModuleId(moduleId);
        List<FieldDto> fieldDtoList = fieldList.stream().map(
                field -> modelMapper.map(field, FieldDto.class)
        ).collect(Collectors.toList());
        return fieldDtoList;
    }

    public List<FieldDto> findAllByModuleIdAndPart(Long moduleId, String part){
        List<Field> fieldList = fieldRepository.findAllByModuleIdAndAndPart(moduleId,part);
        List<FieldDto> fieldDtoList = fieldList.stream().map(
                field -> modelMapper.map(field, FieldDto.class)
        ).collect(Collectors.toList());
        return fieldDtoList;
    }

    //Add
    public FieldDto add(FieldDto fieldDto){
        return modelMapper.map(fieldRepository.save(modelMapper.map(fieldDto,Field.class)), FieldDto.class);
    }

    public List<FieldDto> addAll(List<FieldDto> fieldDtoList){
         List<Field> fieldList = fieldDtoList.stream().map(
                 fieldDto -> modelMapper.map(fieldDto, Field.class)
         ).collect(Collectors.toList());
         List<Field> addedFieldList = fieldRepository.saveAll(fieldList);
         List<FieldDto> addedFieldsDtoList = addedFieldList.stream().map(
                 field -> modelMapper.map(field,FieldDto.class)
         ).collect(Collectors.toList());
         return addedFieldsDtoList;
    }

    //Update
    public FieldDto update(FieldDto fieldDto, Long fieldId){
        if(fieldRepository.findById(fieldId).isPresent()){
            return modelMapper.map(fieldRepository.save(modelMapper.map(fieldDto,Field.class)), FieldDto.class);
        }
        return null;
    }

    //Delete
    public Boolean delete(Long fieldId){
        fieldRepository.deleteById(fieldId);
        return true;
    }

}
