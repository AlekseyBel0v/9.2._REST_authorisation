package com.belov.restauthorisation.repository;

import com.belov.restauthorisation.model.Authorities;
import com.belov.restauthorisation.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private ConcurrentHashMap<String, User> userRepository = new ConcurrentHashMap<>();

    public UserRepository() {
        init();
    }

    public List<Authorities> getUserAuthorities(String name, String password) {
        return ((userRepository.get(name) == null) || (!userRepository.get(name).getPassword().equals(password))) ?
                null :
                userRepository.get(name).getAuthorities();
    }

    private void init(){
        userRepository.put("Oleg", new User("Oleg", "11111")
                .add(Authorities.DELETE).add(Authorities.WRITE)
                .add(Authorities.READ));
        userRepository.put("Ivan", new User("Ivan", "22222")
                .add(Authorities.DELETE).add(Authorities.WRITE)
                .add(Authorities.READ));
    }
}