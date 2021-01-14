package com.example.demo.DTOMappers;

import com.example.demo.DTOs.AuthorDTO;
import com.example.demo.Entities.Author;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDTO toAuthorDTO(Author author);
    Author toAuthor(AuthorDTO authorDTO);
    List<AuthorDTO> toAuthorDTOs(List<Author> authors);
}
