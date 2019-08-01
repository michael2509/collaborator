package fr.formation.collaborator.business;

import java.time.LocalDate;

public class CollaboratorPatch {

    private LocalDate endDate;

    /**
     *
     */
    public CollaboratorPatch() {
    }

    @Override
    public String toString() {
	return "CollaboratorPatch [endDate=" + endDate + "]";
    }

    public LocalDate getEndDate() {
	return endDate;
    }

    public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
    }
}
