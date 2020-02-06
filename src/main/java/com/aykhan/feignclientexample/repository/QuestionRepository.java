package com.aykhan.feignclientexample.repository;

import com.aykhan.feignclientexample.entities.QuestionRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<QuestionRedis, Integer> {
}
