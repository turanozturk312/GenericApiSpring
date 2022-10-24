package com.example.elasticmanagerjson.gantv2.Service;

import com.example.elasticmanagerjson.gantv2.Dto.DateFieldDto;
import com.example.elasticmanagerjson.gantv2.Dto.ListFieldDto;
import com.example.elasticmanagerjson.gantv2.Dto.ListFieldItemDto;
import com.example.elasticmanagerjson.gantv2.Entity.DateField;
import com.example.elasticmanagerjson.gantv2.Entity.ListField;
import com.example.elasticmanagerjson.gantv2.Entity.ListFieldItem;
import com.example.elasticmanagerjson.gantv2.Repository.ListFieldItemRepository;
import com.example.elasticmanagerjson.gantv2.Repository.ListFieldRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListFieldItemService {

    private final ListFieldItemRepository listFieldItemRepository;
    private final ModelMapper modelMapper;

    public List<ListFieldItemDto> findAllByListFieldId(Long listFieldId){
        return modelMapper.map(modelMapper.map(listFieldItemRepository.findAllByListFieldItemId(listFieldId).get(), ListFieldItemDto.class),List.class);
    }

    public ListFieldItemDto add(ListFieldItemDto listFieldDto){
        return modelMapper.map(
                listFieldItemRepository.save(modelMapper.map(listFieldDto, ListFieldItem.class)),ListFieldItemDto.class
        );
    }

    public ListFieldItemDto update(ListFieldItemDto listFieldItemDto, Long id){
        if(listFieldItemRepository.findById(id).isEmpty()){

        }
        return modelMapper.map(
                listFieldItemRepository.save(modelMapper.map(listFieldItemDto, ListFieldItem.class)),ListFieldItemDto.class
        );
    }

    public void delete(Long id){
        if(listFieldItemRepository.findById(id).isEmpty()){

        }
        listFieldItemRepository.deleteById(id);
    }


}
