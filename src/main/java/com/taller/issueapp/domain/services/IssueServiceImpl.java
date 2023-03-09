package com.taller.issueapp.domain.services;

import com.taller.issueapp.domain.models.IssueEntity;
import com.taller.issueapp.domain.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;
    @Override
    public List<IssueEntity> findAll() {
        List<IssueEntity> list = (List<IssueEntity>) issueRepository.findAll();
        return list.stream().filter(item -> !item.getState().equals("Finalizado")).collect(Collectors.toList());
    }

    @Override
    public void save(IssueEntity entity) throws Exception {
        IssueEntity issue = issueRepository.findById(entity.getId()).orElse(entity);
        int presentCount = issue.getCount();
        presentCount++;
        if(presentCount >= 4) {
            issue.setState("Urgente");
        }
        issue.setCount(presentCount);
        issueRepository.save(issue);
    }

    @Override
    public void update(IssueEntity entity) throws Exception {
        IssueEntity issue = issueRepository.findById(entity.getId()).orElseThrow(() -> new Exception("La incidencia a actualizar no existe."));
        issue.setState(entity.getState());
        issueRepository.save(issue);
    }

    @Override
    public void delete(Integer id) throws Exception {
        IssueEntity issue = issueRepository.findById(id).orElseThrow(() -> new Exception("La incidencia a eliminar no existe."));
        issue.setState("Finalizado");
        issueRepository.save(issue);
    }
}
