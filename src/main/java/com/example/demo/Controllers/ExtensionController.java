package com.example.demo.Controllers;

import com.example.demo.DTOMappers.ExtensionMapper;
import com.example.demo.DTOs.ExtensionDTO;
import com.example.demo.Entities.Extension;
import com.example.demo.Services.ExtensionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
@RequestMapping("/extensions")
public class ExtensionController {

    private final ExtensionService extensionService;
    private ExtensionMapper extensionMapper;

    public ExtensionController(ExtensionService extensionService, ExtensionMapper extensionMapper) {
        this.extensionService = extensionService;
        this.extensionMapper = extensionMapper;
    }

    //Extension
    @PostMapping()
    ResponseEntity<ExtensionDTO> addExtension(@RequestBody ExtensionDTO extensionDTO){
        extensionService.save(extensionMapper.toExtenstion(extensionDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(extensionDTO);
    }

    @GetMapping()
    public ResponseEntity<List<ExtensionDTO>> getExtensions(){
        return ResponseEntity.ok(extensionMapper.toExtensionDTOs(extensionService.findAll()));
    }

    @GetMapping("/game/{gameId}")
    public ResponseEntity<List<ExtensionDTO>> getExtensionsByGameId(@PathVariable int gameId){
        return ResponseEntity.ok(extensionMapper.toExtensionDTOs(extensionService.findByGameId(gameId)));
    }

    @GetMapping("/{extensionId}")
    ResponseEntity<ExtensionDTO> getExtension(@PathVariable int extensionId) {
        Optional<Extension> extension = extensionService.findById(extensionId);
        return ResponseEntity.ok(extensionMapper.toExtensionDTO(extension.get()));
    }

    @PutMapping("/{extensionId}")
    ResponseEntity<ExtensionDTO> updateExtension(@PathVariable int extensionId, @RequestBody ExtensionDTO extensionDTO){
        Extension extension = extensionMapper.toExtenstion(extensionDTO);
        extension.setId(extensionId);
        //extension.setBoardgame(extensionDTO.getBoardgame()); tak chyba powinno byc
        extensionService.update(extension);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(extensionDTO);
    }

    @DeleteMapping("/{extensionId}")
    ResponseEntity deleteExtension(@PathVariable int extensionId){
        extensionService.delete(extensionId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
