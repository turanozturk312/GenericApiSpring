package com.example.elasticmanagerjson.gantv2.Service;

import com.example.elasticmanagerjson.ExceptionUtil;
import com.example.elasticmanagerjson.MessageCodeEnum;
import com.example.elasticmanagerjson.gantv2.Entity.BaseEntity;
import com.example.elasticmanagerjson.gantv2.Repository.BaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.util.ObjectUtils;

import javax.persistence.MappedSuperclass;
import javax.swing.text.html.parser.Entity;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@MappedSuperclass
public abstract class BaseService<T extends BaseEntity,EntityDto> {

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


    public List<EntityDto> findAllByFk(String fkName, Long fkId) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method[] methods = BaseRepository.class.getDeclaredMethods();
        System.out.println("METHODS:");
        System.out.println(methods.length);
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        /*
        Method findAll = BaseRepository.class.getMethod("findAllBy"+fkName, Long.class);
        return modelMapper.map(findAll.invoke(fkId), List.class);*/
        return null;
    }




}
