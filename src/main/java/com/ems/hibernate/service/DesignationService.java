package com.ems.hibernate.service;

import com.ems.hibernate.model.Designation;

import java.util.List;

public interface DesignationService {
    List<Designation> findAllDesignations();

    Designation findDesignation(String designation);
}
