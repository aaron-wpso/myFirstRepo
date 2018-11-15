package com.bucketlist.aaron.bucketlist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bucketlist.aaron.bucketlist.dto.CategoryDTO;
import com.bucketlist.aaron.bucketlist.dto.GoalDTO;
import com.bucketlist.aaron.bucketlist.dto.StepDTO;
import com.bucketlist.aaron.bucketlist.exceptions.TooManyGoalsException;
import com.bucketlist.aaron.bucketlist.services.CategoryService;
import com.bucketlist.aaron.bucketlist.services.GoalService;
import com.bucketlist.aaron.bucketlist.services.StepService;

/**
 * This is the REST Controller class that receives the API calls and processes
 * the HTTP request accordingly by calling different services.
 * 
 * @author Aaron
 * @version 1.0
 * @since 2018-11-15
 */
@RestController
@RequestMapping(path = "/app")
public class AppController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	GoalService goalService;

	@Autowired
	StepService stepService;

	/**
	 * This method calls the categoryService to get all the categories saved in the
	 * database.
	 * 
	 * @return A list of CategoryDTO
	 */
	@CrossOrigin
	@GetMapping(path = "/category/getAll")
	public List<CategoryDTO> getAllCategories() {
		return categoryService.getAllCategories();
	}

	/**
	 * This method calls the categoryService to update the categories and the goals
	 * within it after receiving an updated version of the categories from the
	 * Request body.
	 * 
	 * @param categoryDTOList This is the updated version of the categories from the
	 *                        Request Body.
	 */
	@CrossOrigin
	@PutMapping(path = "/category/update")
	public void updateCategories(@RequestBody List<CategoryDTO> categoryDTOList) {
		categoryService.updateCategories(categoryDTOList);
	}

	/**
	 * This method calls the categoryService to delete a category with the specific
	 * "ID" gotten from the URI of the HTTP Request.
	 * 
	 * @param id This is the "ID" of the category needed to be deleted from the
	 *           database.
	 */
	@CrossOrigin
	@DeleteMapping(path = "/category/delete/{id}")
	public void deleteCategory(@PathVariable("id") int id) {
		categoryService.deleteCategory(id);
	}

	/**
	 * This method calls the categoryService to create a category according to the
	 * specification retrieved in the categoryDTO.
	 * 
	 * @param categoryDTO This is the categoryDTO that carries the information of
	 *                    the category needed to be created.
	 */
	@CrossOrigin
	@PostMapping(path = "/category/create")
	public void createCategory(@RequestBody CategoryDTO categoryDTO) {
		categoryService.createCategory(categoryDTO);
	}

	/**
	 * This method calls the goalService to delete a goal with the specific "ID"
	 * gotten from the URI of the HTTP Request.
	 * 
	 * @param id This is the "ID" of the goal needed to be deleted from the
	 *           database.
	 */
	@CrossOrigin
	@DeleteMapping(path = "/goal/delete/{id}")
	public void deleteGoal(@PathVariable("id") int id) {
		goalService.deleteGoal(id);
	}

	/**
	 * This method calls the goalService to get all the goals available in the
	 * database
	 * 
	 * @return A list of GoalDTO that contains all the goals' information available
	 *         in the database
	 */
	@CrossOrigin
	@GetMapping(path = "/goal/getAll")
	public List<GoalDTO> getAllGoals() {
		return goalService.getAllGoals();
	}

	/**
	 * This method calls the goalService to update a goal after receiving the
	 * information from the goalDTO from the Request Body of the HTTP Request
	 * 
	 * @param goalDTO This goalDTO contains the information that the goal needs to
	 *                be updated to.
	 */
	@CrossOrigin
	@PutMapping(path = "/goal/update")
	public void updateGoal(@RequestBody GoalDTO goalDTO) {
		goalService.updateGoal(goalDTO);
	}

	/**
	 * This method calls the goalService to create a goal after receiving the
	 * information from the goalDTO from the Request Body of the HTTP Request
	 * 
	 * @param goalDTO This goalDTO contains the information that the service needs
	 *                in order to create the goal in the database.
	 * @throws TooManyGoalsException This exception is thrown when there are more
	 *                               than 10 goals in one category.
	 */
	@CrossOrigin
	@PostMapping(path = "/goal/create")
	public void createGoal(@RequestBody GoalDTO goalDTO) throws TooManyGoalsException {
		goalService.createGoal(goalDTO);
	}

	@GetMapping(path = "/step/getAll/{id}")
	public List<StepDTO> getStep(@PathVariable("id") int goalID) {
		return stepService.getAllSteps(goalID);
	}

}
