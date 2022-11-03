package com.example.elasticmanagerjson.gantv2.Service;

import com.example.elasticmanagerjson.gantv2.Dto.FieldDto;
import com.example.elasticmanagerjson.gantv2.Dto.ListFieldItemDto;
import com.example.elasticmanagerjson.gantv2.Entity.Field;
import com.example.elasticmanagerjson.gantv2.Entity.ListFieldItem;
import com.example.elasticmanagerjson.gantv2.Repository.ListFieldItemRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListFieldItemService {

    private final ListFieldItemRepository listFieldItemRepository;
    private final ModelMapper modelMapper;

    //Findall
    public List<com.example.elasticmanagerjson.gantv2.Dto.ListFieldItemDto> findAllByFieldId(Long fieldId){
        List<ListFieldItem> listFieldItemList = listFieldItemRepository.findAllByFieldId(fieldId);
        List<com.example.elasticmanagerjson.gantv2.Dto.ListFieldItemDto> listFieldItemDtoList = listFieldItemList.stream().map(
                item -> modelMapper.map(item, com.example.elasticmanagerjson.gantv2.Dto.ListFieldItemDto.class)
        ).collect(Collectors.toList());
        return listFieldItemDtoList;
    }

    public List<ListFieldItemDto> addAll(List<ListFieldItemDto> listFieldItemDtoList){
        List<ListFieldItem> listFieldItemList = listFieldItemDtoList.stream().map(
                fieldDto -> modelMapper.map(fieldDto, ListFieldItem.class)
        ).collect(Collectors.toList());
        List<ListFieldItem> addedListFieldItems = listFieldItemRepository.saveAll(listFieldItemList);
        List<ListFieldItemDto> addedListFieldItemsDtoList = addedListFieldItems.stream().map(
                field -> modelMapper.map(field,ListFieldItemDto.class)
        ).collect(Collectors.toList());
        return addedListFieldItemsDtoList;
    }



    //Add
    public com.example.elasticmanagerjson.gantv2.Dto.ListFieldItemDto add(com.example.elasticmanagerjson.gantv2.Dto.ListFieldItemDto listFieldItemDto){
        return modelMapper.map(listFieldItemRepository.save(modelMapper.map(listFieldItemDto,ListFieldItem.class)), com.example.elasticmanagerjson.gantv2.Dto.ListFieldItemDto.class);
    }

    //Update
    public com.example.elasticmanagerjson.gantv2.Dto.ListFieldItemDto update(com.example.elasticmanagerjson.gantv2.Dto.ListFieldItemDto listFieldItemDto, Long listFieldItemId){
        if(listFieldItemRepository.findById(listFieldItemId).isPresent()){
            return modelMapper.map(listFieldItemRepository.save(modelMapper.map(listFieldItemDto,ListFieldItem.class)), com.example.elasticmanagerjson.gantv2.Dto.ListFieldItemDto.class);
        }
        return null;
    }

    //Delete
    public Boolean delete(Long listFieldItemId){
        listFieldItemRepository.deleteById(listFieldItemId);
        return true;
    }




}
