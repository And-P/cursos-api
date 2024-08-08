package com.umbrella.cursos_api.service;

import com.umbrella.cursos_api.model.Curso;

public interface CursoService {

    Curso findById(Long id);

    Curso create(Curso cursoToCreate);

}
