package com.taller.issueapp.api;

import com.taller.issueapp.domain.models.IssueEntity;
import com.taller.issueapp.domain.services.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/app")
public class IssueController {
    @Autowired
    private IssueService issueService;

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(issueService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody IssueEntity entity) {
        try {
            issueService.save(entity);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Incidencia creada con éxito.", HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody IssueEntity entity) {
        try {
            issueService.update(entity);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Incidencia actualizada con éxito.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            issueService.delete(id);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Incidencia eliminada con éxito.", HttpStatus.OK);
    }
}
