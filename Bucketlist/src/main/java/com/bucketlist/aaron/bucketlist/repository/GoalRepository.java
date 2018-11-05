package com.bucketlist.aaron.bucketlist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bucketlist.aaron.bucketlist.entities.Goal;

@Repository
public interface GoalRepository extends CrudRepository<Goal, Integer>{

}
