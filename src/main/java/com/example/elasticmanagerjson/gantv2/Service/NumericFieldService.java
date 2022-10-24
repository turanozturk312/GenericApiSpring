package com.example.elasticmanagerjson.gantv2.Service;

import com.example.elasticmanagerjson.gantv2.Dto.ListFieldDto;
import com.example.elasticmanagerjson.gantv2.Dto.NumericFieldDto;
import com.example.elasticmanagerjson.gantv2.Repository.NumericFieldRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NumericFieldService {

    private final ModelMapper modelMapper;
    private final NumericFieldRepository numericFieldRepository;


}
