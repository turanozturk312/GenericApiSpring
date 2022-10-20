package com.example.elasticmanagerjson.gantt.service;

import com.example.elasticmanagerjson.ExceptionUtil;
import com.example.elasticmanagerjson.MessageCodeEnum;
import com.example.elasticmanagerjson.gantt.entity.BaseEntity;
import com.example.elasticmanagerjson.gantt.repository.BaseRepository;
import org.apache.logging.log4j.util.Activator;
import org.apache.logging.log4j.util.Supplier;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.bytebuddy.description.method.MethodDescription;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class BaseService<T extends BaseEntity,EntityDto> {

    private final ModelMapper modelMapper;
    private final BaseRepository<T> baseRepository;
    private final Class<T> entityType;
    private final Class<EntityDto> entityDtoType;

    public BaseService(ModelMapper modelMapper, BaseRepository<T> baseRepository, Class<T> entityType, Class<EntityDto> entityDtoType ) {
        this.modelMapper = modelMapper;
        this.baseRepository = baseRepository;
        this.entityType = entityType;
        this.entityDtoType = entityDtoType;
    }

    public List<EntityDto> findAll(){
        return modelMapper.map(baseRepository.findAll(), List.class);
    }

    public EntityDto getById(Long id){
        return (EntityDto) modelMapper.map(baseRepository.findById(id).get(),entityDtoType);
    }

    public EntityDto add(EntityDto entityDto){
        return (EntityDto) modelMapper.map(baseRepository.save((T)modelMapper.map(entityDto, entityType)),entityDto.getClass());
    }

    public EntityDto update(EntityDto entityDto, Long id){
        if(ObjectUtils.isEmpty(baseRepository.findById(id))){
            ExceptionUtil.throwIfAny(Arrays.asList("böyle bi id yok"), MessageCodeEnum.ERROR);
        }
        return  (EntityDto)modelMapper.map(baseRepository.save((T)modelMapper.map(entityDto,entityType)),entityDtoType);
    }

    public Boolean delete(Long id){
        if(ObjectUtils.isEmpty(baseRepository.findById(id))){
            ExceptionUtil.throwIfAny(Arrays.asList("böyle bi id yok"), MessageCodeEnum.ERROR);
        }
        baseRepository.deleteById(id);
        return true;
    }

}
