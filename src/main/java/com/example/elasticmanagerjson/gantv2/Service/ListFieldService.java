package com.example.elasticmanagerjson.gantv2.Service;

import com.example.elasticmanagerjson.EafadResponse;
import com.example.elasticmanagerjson.MessageCodeEnum;
import com.example.elasticmanagerjson.MessageListEnum;
import com.example.elasticmanagerjson.gantv2.Dto.ListFieldDto;
import com.example.elasticmanagerjson.gantv2.Entity.ListField;
import com.example.elasticmanagerjson.gantv2.Repository.ListFieldRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListFieldService {

    private final ListFieldRepository listFieldRepository;
    private final ModelMapper modelMapper;


    public ListFieldDto add(ListFieldDto listFieldDto){
        return modelMapper.map(
                listFieldRepository.save(modelMapper.map(listFieldDto, ListField.class)),ListFieldDto.class
        );
    }

    public ListFieldDto update(ListFieldDto ListFieldDto, Long id){
        if(listFieldRepository.findById(id).isEmpty()){

        }
        return modelMapper.map(
                listFieldRepository.save(modelMapper.map(ListFieldDto, ListField.class)),ListFieldDto.class
        );
    }

    public void delete(Long id){
        if(listFieldRepository.findById(id).isEmpty()){

        }
        listFieldRepository.deleteById(id);
    }

}
