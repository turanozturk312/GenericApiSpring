package com.example.elasticmanagerjson.gantv2.Service;

import com.example.elasticmanagerjson.EafadResponse;
import com.example.elasticmanagerjson.MessageCodeEnum;
import com.example.elasticmanagerjson.MessageListEnum;
import com.example.elasticmanagerjson.gantv2.Dto.DateFieldDto;
import com.example.elasticmanagerjson.gantv2.Entity.DateField;
import com.example.elasticmanagerjson.gantv2.Repository.BaseRepository;
import com.example.elasticmanagerjson.gantv2.Repository.DateFieldRepository;
import com.example.elasticmanagerjson.gantv2.Service.BaseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DateFieldService extends BaseService<DateField,DateFieldDto> {

    private final DateFieldRepository dateFieldRepository;
    private final ModelMapper modelMapper;

    public DateFieldService(ModelMapper modelMapper, BaseRepository<DateField> baseRepository, DateFieldRepository dateFieldRepository) {
        super(modelMapper, baseRepository, DateField.class, DateFieldDto.class);
        this.dateFieldRepository = dateFieldRepository;
        this.modelMapper = modelMapper;
    }






}
