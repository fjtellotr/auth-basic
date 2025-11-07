package pe.idat.security.service;

import org.springframework.stereotype.Service;
import pe.idat.security.model.Instructor;
import java.util.Collection;


public interface InstructorService {
    public abstract Collection<Instructor> findAll();
}
