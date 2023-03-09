package com.taller.issueapp.domain.services;

import com.taller.issueapp.domain.models.IssueEntity;

import java.util.List;

public interface IssueService {
    List<IssueEntity> findAll();
    void save(IssueEntity entity) throws Exception;
    void update(IssueEntity entity) throws Exception;
    void delete(Integer id) throws Exception;
}
