package fr.formation.collaborator.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.collaborator.business.Collaborator;
import fr.formation.collaborator.business.CollaboratorPatch;

@RestController
@RequestMapping("/collaborators")
public class CollaboratorController {

    @GetMapping("/{id}")
    public Collaborator getCollab(@PathVariable("id") Long id) {
	LocalDate birthDate = LocalDate.of(1960, 1, 1);
	LocalDate startDate = LocalDate.of(1995, 9, 25);
	Collaborator collaborator = new Collaborator("azaearara", "Michael",
		"Jackson", birthDate, startDate, 222.22);
	collaborator.setId(id);
	return collaborator;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void postCollab(@RequestBody @Valid Collaborator collab) {
	System.out.println(collab);
    }

    @GetMapping()
    public List<Collaborator> getAll(@RequestParam("element") int element,
	    @RequestParam("page") int page) {
	List<Collaborator> collaborators = new ArrayList<>();
	LocalDate birthDate = LocalDate.of(1960, 1, 1);
	LocalDate startDate = LocalDate.of(1995, 9, 25);
	Collaborator collaborator1 = new Collaborator("azaearara", "Michael",
		"Jackson", birthDate, startDate, 2222.22);
	Collaborator collaborator2 = new Collaborator("azaearara", "Germain",
		"Jackson", birthDate, startDate, 222.22);
	collaborators.add(collaborator1);
	collaborators.add(collaborator2);
	return collaborators;
    }

    @PutMapping("/{id}")
    public void putCollab(@PathVariable("id") Long id,
	    @RequestBody Collaborator collab) {
	System.out.println(collab);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
	System.out.println("Deleting collab with id " + id);
    }

    @PatchMapping("/{id}/fired")
    public void fire(@RequestBody CollaboratorPatch collabPatch) {
	System.out.println(collabPatch);
    }
}
