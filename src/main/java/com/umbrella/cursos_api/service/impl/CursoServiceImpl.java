package com.umbrella.cursos_api.service.impl;

import com.umbrella.cursos_api.model.Curso;
import com.umbrella.cursos_api.repsitory.CursoRepository;
import com.umbrella.cursos_api.service.CursoService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }


    @Override
    public Curso findById(Long id) {
        return cursoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Curso create(Curso cursoToCreate) {
        if (cursoRepository.existsByName(cursoToCreate.getName())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return cursoRepository.save(cursoToCreate);
    }
}
