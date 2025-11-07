package pe.idat.security.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.idat.security.model.Instructor;
import pe.idat.security.repository.InstructorRepository;
import pe.idat.security.service.InstructorService;

import java.util.Collection;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    @Transactional
    public Collection<Instructor> findAll() {
        return (Collection<Instructor>) instructorRepository.findAll();
    }

}