package repository.impl;

import model.Component;
import repository.ComponentRepository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public class ComponentRepositoryImpl implements ComponentRepository {

    public Optional<List<Component>> getComponentOfProject(int projectId){
        return Optional.empty();
    }
    public  Component mapResultSetToComponent(ResultSet rs) throws Exception{
        return null;
    }

}
