package com.example.elasticmanagerjson.gantv2.Entity;

import com.example.elasticmanagerjson.gantv2.Repository.DateFieldRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DateFieldService {

    private final DateFieldRepository dateFieldRepository;
    private final ModelMapper modelMapper;

    public List<DateFieldRepository> findAllByModuleItemId(Long moduleItemId){
        return dateFieldRepository.findAllByModule_item_id(moduleItemId);
    }

}
