package com.example.demo;

import javax.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final EntityManager entityManager;



    @Transactional
    public UserEntity createUser(String firstName, String lastName, String email) {
        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return entityManager.merge(user);
    }

    @Transactional
    public List<UserEntity> findAllUsers() {
        return entityManager.createQuery("from UserEntity", UserEntity.class).getResultList();
    }
    @Transactional
    public long countUsers() {
        return entityManager.createQuery("SELECT COUNT(u) FROM UserEntity u", Long.class).getSingleResult();
    }
    public List<UserEntity> findBySurname(String lastName) {
        return entityManager.createNamedQuery(UserEntity.Find_By_lastName, UserEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }




    @Transactional
    public UserEntity getUserById(int id) {
        return entityManager.find(UserEntity.class, id);
    }

    public List<UserEntity> contains(String word){
        List<UserEntity> res=new ArrayList<>() ;
        for(int i=1; i<=this.countUsers(); i++){

            if(this.getUserById(i).getFirstName().contains(word)||this.getUserById(i).getLastName().contains(word)){
                res.add(this.getUserById(i));
            }
        }
        return res;

    }



    public String toString(){
        String res="";
        List<UserEntity> mass=this.findAllUsers();
        for(int i=0; i<mass.size(); i++){
            res+=mass.get(i)+"\n";
        }
        return res;
    }

}

