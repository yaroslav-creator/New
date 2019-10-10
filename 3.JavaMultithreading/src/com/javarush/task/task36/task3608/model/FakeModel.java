package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;

public class FakeModel implements Model {

   private ModelData modelData = new ModelData();


    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        ArrayList<User> users = new ArrayList<>(  );
        users.add(new User( "Tom", 1, 15 )  );
        users.add(new User( "Sem", 1, 20 )  );
        modelData.setUsers( users );
    }
    public void loadDeletedUsers(){
        throw new UnsupportedOperationException(  );
    }
    public void loadUserById(long userId){
        throw new UnsupportedOperationException(  );
    }

    @Override
    public void deleteUserById(long Id) {
        throw new UnsupportedOperationException(  );
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException(  );
    }
}
