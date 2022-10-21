package com.example.elasticmanagerjson.gantv2.Entity;

import com.example.elasticmanagerjson.EafadResponse;
import com.example.elasticmanagerjson.MessageCodeEnum;
import com.example.elasticmanagerjson.MessageListEnum;
import com.example.elasticmanagerjson.gantv2.Dto.DateFieldDto;
import com.example.elasticmanagerjson.gantv2.Repository.DateFieldRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DateFieldService {

    private final DateFieldRepository dateFieldRepository;
    private final ModelMapper modelMapper;

    public List<DateFieldDto> findAllByModuleItemId(Long moduleItemId){
        return modelMapper.map(modelMapper.map(dateFieldRepository.findAllByModule_item_id(moduleItemId).get(), DateFieldDto.class),List.class);
    }

    public DateFieldDto add(DateFieldDto dateFieldDto){
        return modelMapper.map(
                dateFieldRepository.save(modelMapper.map(dateFieldDto, DateField.class)),DateFieldDto.class
                );
    }

    public DateFieldDto update(DateFieldDto dateFieldDto, Long id){
        if(dateFieldRepository.findById(id).isEmpty()){

        }
        return modelMapper.map(
                dateFieldRepository.save(modelMapper.map(dateFieldDto, DateField.class)),DateFieldDto.class
        );
    }

    public void delete(Long id){
        if(dateFieldRepository.findById(id).isEmpty()){

        }
        dateFieldRepository.deleteById(id);
    }

}
