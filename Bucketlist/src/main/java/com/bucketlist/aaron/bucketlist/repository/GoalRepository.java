package com.bucketlist.aaron.bucketlist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bucketlist.aaron.bucketlist.entities.Goal;

/**
 * This is a Repository that extends from the CrudRepository defined by Spring
 * framework to handle database operations of the Entity type Goal.
 * 
 * @author Aaron
 * @version 1.0
 * @since 2018-11-15
 *
 */
@Repository
public interface GoalRepository extends CrudRepository<Goal, Integer> {

}
