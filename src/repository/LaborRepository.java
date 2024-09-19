package repository;


import model.Labor;

import java.util.Optional;

public interface LaborRepository {

    Optional<Labor> addLabor(Labor labor);
//    Labor getLaborOfComponent(int componentId);

}
