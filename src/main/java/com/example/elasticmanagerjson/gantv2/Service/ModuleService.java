package com.example.elasticmanagerjson.gantv2.Service;

import com.example.elasticmanagerjson.gantv2.Dto.FieldDto;
import com.example.elasticmanagerjson.gantv2.Dto.ListFieldItemDto;
import com.example.elasticmanagerjson.gantv2.Dto.ModuleDto;
import com.example.elasticmanagerjson.gantv2.Entity.Field;
import com.example.elasticmanagerjson.gantv2.Entity.ListFieldItem;
import com.example.elasticmanagerjson.gantv2.Entity.Module;
import com.example.elasticmanagerjson.gantv2.Repository.FieldRepository;
import com.example.elasticmanagerjson.gantv2.Repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModuleService {

    private final ModuleRepository moduleRepository;
    private final FieldService fieldService;
    private final ListFieldItemService listFieldItemService;
    private final ModelMapper modelMapper;

    public List<ModuleDto> findAll() {
        List<Module> modules = moduleRepository.findAllByOrderByIdAsc();
        List<ModuleDto> moduleDtos = modules.stream()
                .map(module -> modelMapper.map(module, ModuleDto.class)).collect(Collectors.toList());
        return moduleDtos;
    }

    @Transactional
    public ModuleDto add(ModuleDto moduleDto) {
        Module addedModule = moduleRepository.save(modelMapper.map(moduleDto, Module.class));
        List<Field> autoAddedFieldWithoutListField = Arrays.asList(
                new Field(addedModule.getId(), "title", "hedef", "Text"),
                //new Field(addedModule.getId(), "start", "hedef", "Date"),
                //new Field(addedModule.getId(), "end", "hedef", "Date"),
                //new Field(addedModule.getId(), "progress", "hedef", "Integer"),
                new Field(addedModule.getId(), "title", "eylem", "Text"),
                //new Field(addedModule.getId(), "start", "eylem", "Date"),
                //new Field(addedModule.getId(), "end", "eylem", "Date"),
                //new Field(addedModule.getId(), "progress", "eylem", "Integer"),
                new Field(addedModule.getId(), "Kurum", "eylem", "Kurum"),
                new Field(addedModule.getId(), "title", "isadimi", "Text"),
                new Field(addedModule.getId(), "start", "isadimi", "Date"),
                new Field(addedModule.getId(), "end", "isadimi", "Date"),
                new Field(addedModule.getId(), "progress", "isadimi", "Integer")
        );
        List< FieldDto> autoAddedFieldDtoList = autoAddedFieldWithoutListField.stream().map(
                field -> modelMapper.map(field, FieldDto.class)
        ).collect(Collectors.toList());
        fieldService.addAll(autoAddedFieldDtoList);

        //Ulaşım Durumu Field
        FieldDto UlasimDurumu = fieldService.add(
                modelMapper.map(
                modelMapper.map(new Field(addedModule.getId(),"Ulaşım Durumu","hedef","List"),FieldDto.class),FieldDto.class
                )
        );
        List<ListFieldItem> ulasimDurumuItems = Arrays.asList(
                new ListFieldItem("Kısa Vade", UlasimDurumu.getId()),
                new ListFieldItem("Orta Vade", UlasimDurumu.getId()),
                new ListFieldItem("Uzun Vade", UlasimDurumu.getId())
        );
        List< ListFieldItemDto> addedUlasimDurumuItems = ulasimDurumuItems.stream().map(
                item -> modelMapper.map(item, ListFieldItemDto.class)
        ).collect(Collectors.toList());
        listFieldItemService.addAll(addedUlasimDurumuItems);

        //Dosya Yükleme
        List<Field> dosyaYuklemeFields = Arrays.asList(
                new Field(addedModule.getId(), "Dosya Yükleme", "hedef", "File"),
                new Field(addedModule.getId(), "Yükleme", "eylem", "File")
        );
        List<FieldDto> dosyaYuklemeFieldsDtoList = dosyaYuklemeFields.stream().map(
                dosyaField -> modelMapper.map(dosyaField, FieldDto.class)
        ).collect(Collectors.toList());
        fieldService.addAll(dosyaYuklemeFieldsDtoList);



        return modelMapper.map(addedModule, ModuleDto.class);
    }

    public ModuleDto update(ModuleDto moduleDto, Long id) {
        Optional<Module> updatedModuleOpt = moduleRepository.findById(id);
        Module updatedModule = null;
        if (!updatedModuleOpt.isEmpty()) {
            updatedModule = updatedModuleOpt.get();
            updatedModule.setName(moduleDto.getName());
            updatedModule.setOrderOfItems(moduleDto.getOrderOfItems());
        }
        return modelMapper.map(
                moduleRepository.save(modelMapper.map(updatedModule, Module.class)), ModuleDto.class
        );
    }

    public void delete(Long id) {
        if (moduleRepository.findById(id).isEmpty()) {

        }
        moduleRepository.deleteById(id);
    }


}
