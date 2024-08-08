package com.umbrella.cursos_api.controller;

import com.umbrella.cursos_api.model.Curso;
import com.umbrella.cursos_api.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Long id) {
        var curso = cursoService.findById(id);
        return ResponseEntity.ok(curso);
    }

    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody Curso cursoToCreate) {
        var cursoCreated = cursoService.create(cursoToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cursoCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(cursoCreated);
    }

}
