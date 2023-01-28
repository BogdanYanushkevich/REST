package com.bogdan_yanushkevich.javacore.rest.service;

import com.bogdan_yanushkevich.javacore.rest.model.Event;
import com.bogdan_yanushkevich.javacore.rest.model.File;
import com.bogdan_yanushkevich.javacore.rest.model.User;
import com.bogdan_yanushkevich.javacore.rest.repository.EventRepository;
import com.bogdan_yanushkevich.javacore.rest.repository.FileRepositiry;
import com.bogdan_yanushkevich.javacore.rest.repository.UserRepository;
import com.bogdan_yanushkevich.javacore.rest.repository.impl.HibEventRepositoryImpl;
import com.bogdan_yanushkevich.javacore.rest.repository.impl.HibFileRepositoryImpl;
import com.bogdan_yanushkevich.javacore.rest.repository.impl.HibUserRepositoryImpl;

import java.util.List;

public class FileService {

    private final FileRepositiry fileRepository = new HibFileRepositoryImpl();
    private final UserRepository userRepository = new HibUserRepositoryImpl();
    private final EventRepository eventRepository = new HibEventRepositoryImpl();

    public File save(java.io.File file, Integer userId) {
        File fileForSave = new File();
        fileForSave.setFilePath(file.getPath());
        fileForSave.setName(file.getName());
        File createdFile = fileRepository.create(fileForSave);

        User user = userRepository.getById(userId);

        Event event = new Event();
        event.setFile(createdFile);
        event.setUser(user);
        Event createdEvent = eventRepository.create(event);

        return createdFile;
    }

    public File getById(Integer id) {
        return fileRepository.getById(id);
    }

    public File update(java.io.File file, Integer fileId) {
        File fileForEdit = new File();
        fileForEdit.setId(fileId);
        fileForEdit.setFilePath(file.getPath());
        fileForEdit.setName(file.getName());

        return fileRepository.update(fileForEdit);
    }

    public void delete(Integer id) {
        fileRepository.delete(id);
    }

    public List<File> getAll() {
        return fileRepository.getAll();
    }
}