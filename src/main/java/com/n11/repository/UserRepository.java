package com.n11.repository;

import com.n11.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by atb on 1/16/2015.
 */
public interface UserRepository extends MongoRepository<User,String> {
}
