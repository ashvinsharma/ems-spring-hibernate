package com.ems.hibernate.service;

import com.ems.hibernate.dao.DesignationDao;
import com.ems.hibernate.model.Designation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("designationService")
@Transactional
public class DesignationServiceImpl implements DesignationService {

    @Autowired
    private DesignationDao designationDao;

    @Override
    public List<Designation> findAllDesignations() {
        return designationDao.findAllDesignations();
    }

    @Override
    public Designation findDesignation(String designation) {
        return designationDao.findDesignation(designation);
    }
}
