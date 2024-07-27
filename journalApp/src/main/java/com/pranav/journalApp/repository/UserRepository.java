package com.pranav.journalApp.repository;

import com.pranav.journalApp.entity.JournalEntry;
import com.pranav.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
//    This findByis a method of mongodbrepo that makesit a query so findBY and any entity variablei can giv
    User findByUsername(String username);

    void deleteByUsername(String username);

}
