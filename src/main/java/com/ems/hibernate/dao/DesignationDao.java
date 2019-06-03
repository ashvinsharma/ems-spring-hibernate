package com.ems.hibernate.dao;

import com.ems.hibernate.model.Designation;

import java.util.List;

public interface DesignationDao {
    List<Designation> findAllDesignations();

    Designation findDesignation(String designation);
}
