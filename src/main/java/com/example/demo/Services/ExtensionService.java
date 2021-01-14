package com.example.demo.Services;

import com.example.demo.Entities.Extension;
import com.example.demo.Repositories.ExtensionRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ExtensionService {

    ExtensionRepo extensionRepo;

    public ExtensionService(ExtensionRepo extensionRepo) {
        this.extensionRepo = extensionRepo;
    }

    public void save(@RequestBody Extension extension){
        extensionRepo.save(extension);
    }

    public Optional<Extension> findById(@PathVariable int extensionId) {
        return extensionRepo.findById(extensionId);
    }

    public List<Extension> findAll() {
        return (List<Extension>) extensionRepo.findAll();
    }

    public void update(@RequestBody Extension extension){
        extensionRepo.save(extension);
    }

    public void delete(@PathVariable int extensionId){
        extensionRepo.deleteById(extensionId);
    }

    public List<Extension> findByGameId(@PathVariable int gameId) {
        return extensionRepo.findByGameId(gameId);
    }
}
