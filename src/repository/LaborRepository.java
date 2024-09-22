package repository;


import model.Labor;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface LaborRepository {

    boolean addLabor(Labor labor);
    Optional<List<Labor>> getLaborOfProject(int projectId);

    Labor mapResultSetToLabor(ResultSet rs) throws Exception;

    //    Labor getLaborOfComponent(int componentId);

}
