package com.bucketlist.aaron.bucketlist.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bucketlist.aaron.bucketlist.dto.GoalDTO;
import com.bucketlist.aaron.bucketlist.entities.Category;
import com.bucketlist.aaron.bucketlist.entities.Goal;
import com.bucketlist.aaron.bucketlist.exceptions.TooManyGoalsException;
import com.bucketlist.aaron.bucketlist.repository.CategoryRepository;
import com.bucketlist.aaron.bucketlist.repository.GoalRepository;

/**
 * This is a Service Class for the generated entity Goal that does the CRUD
 * operations by making calls to the Repository of the appropriate type.
 * 
 * @author Aaron
 * @version 1.0
 * @since 2018-11-15
 *
 */
@Service
public class GoalService {
	@Autowired
	private GoalRepository goalRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	/**
	 * This method calls the goalRepository to retrieve all the records in the goal
	 * table in the database and putting the information of the entity object into a
	 * goalDTO object.
	 * 
	 * @return A List of GoalDTO after the repository retrieves the Goal entity and
	 *         data of the entity have been transferred to the goalDTO
	 */
	public List<GoalDTO> getAllGoals() {
		List<Goal> goalList = new ArrayList<>();
		goalRepository.findAll().forEach(goalList::add);

		List<GoalDTO> dtoList = new ArrayList<>();
		for (Goal goal : goalList) {
			GoalDTO dto = new GoalDTO();

			dto.setId(goal.getId());
			dto.setTitle(goal.getTitle());
			dto.setImportance(goal.getImportance());
			dto.setDone(goal.getDone());

			dtoList.add(dto);
		}

		return dtoList;
	}

	/**
	 * This method deletes a goal with a specific id.
	 * 
	 * @param id The id of the goal that needs to be deleted.
	 */
	public void deleteGoal(int id) {
		goalRepository.delete(id);
	}

	/**
	 * This method updates the Goal based on the information received int the
	 * goalDTO.
	 * 
	 * @param goalDTO This GoalDTO contains the updated information of the goal that
	 *                needs be updated into the database.
	 */
	public void updateGoal(GoalDTO goalDTO) {
		Goal goal = goalRepository.findOne(goalDTO.getId());
		goal.setTitle(goalDTO.getTitle());
		goal.setDone(goalDTO.getDone());
		goal.setImportance(goalDTO.getImportance());

		goalRepository.save(goal);
	}

	/**
	 * This method creates a Goal based on the information provided by the GoalDTO
	 * received from the REST Controller. This method will throw a custom exception
	 * when there is more than 5 goals in the category.
	 * 
	 * @param goalDTO This GoalDTO contains the information that is needed to create
	 *                a category record in the database.
	 */
	public void createGoal(GoalDTO goalDTO) throws TooManyGoalsException {
		Category categoryFromGoalDTO = categoryRepository.findByCateName(goalDTO.getCateName());

		List<Goal> GoalsInCategory = categoryFromGoalDTO.getGoals();
		int size = GoalsInCategory.size();
		if (size >= 5) {
			throw new TooManyGoalsException("Too Many Goals!");
		} else {
			Category cateName = categoryRepository.findByCateName(goalDTO.getCateName());

			Goal goal = new Goal();
			goal.setTitle(goalDTO.getTitle());
			goal.setDone(goalDTO.getDone());
			goal.setImportance(goalDTO.getImportance());

			List categoryList = new ArrayList<>();
			categoryList.add(cateName);

			goal.setCategories(categoryList);

			goalRepository.save(goal);
		}
	}
}
