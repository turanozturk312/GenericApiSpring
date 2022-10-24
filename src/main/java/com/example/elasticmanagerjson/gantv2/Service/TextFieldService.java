package com.example.elasticmanagerjson.gantv2.Service;

import com.example.elasticmanagerjson.gantv2.Dto.NumericFieldDto;
import com.example.elasticmanagerjson.gantv2.Dto.TextFieldDto;
import com.example.elasticmanagerjson.gantv2.Repository.NumericFieldRepository;
import com.example.elasticmanagerjson.gantv2.Repository.TextFieldRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TextFieldService {

    private final ModelMapper modelMapper;
    private final TextFieldRepository textFieldRepository;

}
