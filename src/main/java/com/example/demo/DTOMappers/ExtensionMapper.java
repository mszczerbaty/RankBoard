package com.example.demo.DTOMappers;


import com.example.demo.DTOs.ExtensionDTO;
import com.example.demo.Entities.Extension;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExtensionMapper {

    ExtensionDTO toExtensionDTO(Extension extension);
    Extension toExtenstion(ExtensionDTO extensionDTO);
    List<ExtensionDTO> toExtensionDTOs(List<Extension> extensions);
}
