package com.onurk.repository;

import com.onurk.entity.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"firstName\": \"?0\"}}]}}")

    List<User> getByCustomerQuery(String search);

    List <User> findByFirstNameLikeOrLastNameLike(String firstName, String lastName);


}
