package repository;


import model.Labor;

import java.sql.ResultSet;
import java.util.Optional;

public interface LaborRepository {

    Optional<Labor> addLabor(Labor labor);

    Labor mapResultSetToLabor(ResultSet rs) throws Exception;

    //    Labor getLaborOfComponent(int componentId);

}
