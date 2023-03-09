package com.taller.issueapp.domain.repository;

import com.taller.issueapp.domain.models.IssueEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends CrudRepository<IssueEntity, Integer> {
}
