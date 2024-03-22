package com.ms.dr.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "cases")
public class Cases {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String Id;
    private String caseNumber;
    @OneToMany(mappedBy = "cases", cascade = CascadeType.ALL)
    private List<Event> events;
    @OneToMany(mappedBy = "cases", cascade = CascadeType.ALL)
    private List<Document> documents;

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
