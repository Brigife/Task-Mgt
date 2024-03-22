package com.ms.dr.model;

import jakarta.persistence.*;

@Entity

public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String numCase;
    private String contentType;
    private byte[] data;
    // Relationship with Case
    @ManyToOne
    @JoinColumn(name = "case_number", nullable = false)
    private Cases cases;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Cases getCases() {
        return cases;
    }

    public void setCases(Cases cases) {
        this.cases = cases;
    }

    public String getNumCase() {
        return numCase;
    }

    public void setNumCase(String numCase) {
        this.numCase = numCase;
    }
}

