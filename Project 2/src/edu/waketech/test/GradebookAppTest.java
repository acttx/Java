package edu.waketech.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import edu.waketech.academic.Assignment;
import edu.waketech.academic.Course;
import edu.waketech.common.Student;
import edu.waketech.common.StudentBody;
import edu.waketech.GradebookApp;

class GradebookAppTest {


	@Test
	void testCreateAssignment() {
		Course course = new Course("CSC", 251);
		Student s1 = new Student("last1", "first1", 2);
		Student s2 = new Student("last2", "first2", 3);
		StudentBody sb = StudentBody.getInstance();
		sb.add(s1);
		sb.add(s2);
		
		course.addStudent(s1.getId());
		course.addStudent(s2.getId());
		
		GradebookApp.createAssignment(course, "lab1", 50);
		List<Assignment> labList = course.getAssignment(s1.getId(), "lab1");
		Assignment foundLab = labList.get(0);
		assertEquals("lab1", foundLab.getName());
		assertEquals(50, foundLab.getPossiblePoints());
		assertTrue(foundLab.getScore() >= 35);
	}
	
	@Test
	void testCreateAssignment1() {
		Course course = new Course("CSC", 251);
		Student s1 = new Student("last1", "first1", 2);
		Student s2 = new Student("last2", "first2", 3);
		StudentBody sb = StudentBody.getInstance();
		sb.add(s1);
		sb.add(s2);
		
		course.addStudent(s1.getId());
		course.addStudent(s2.getId());
		
		GradebookApp.createAssignment(course, "lab1", 50);
		List<Assignment> labList = course.getAssignment(s2.getId(), "lab1");
		Assignment foundLab = labList.get(0);
		assertEquals("lab1", foundLab.getName());
		assertEquals(50, foundLab.getPossiblePoints());
		assertTrue(foundLab.getScore() >= 35);
	}

	@Test
	void getStudentTakingEverything() {
		Course eng101 = new Course("Eng", 101);
		Course mat101 = new Course("Mat", 101);
		Course bio101 = new Course("Bio", 101);
		
		List<Course> courses = new ArrayList<>();
		courses.add(eng101);
		courses.add(mat101);
		courses.add(bio101);
		
		Student s1 = new Student("last1", "first1", 2);
		Student s2 = new Student("nguyen", "paul", 3);
		StudentBody sb = StudentBody.getInstance();
		sb.add(s1);
		sb.add(s2);
		//s1
		eng101.addAssignment(2, new Assignment("lab1", 100, 100));
		mat101.addAssignment(2,  new Assignment("lab1", 100, 90));
		bio101.addAssignment(2, new Assignment("lab1", 100, 90));
		//s2
		eng101.addAssignment(3, new Assignment("lab1", 100, 100));
		mat101.addAssignment(3,  new Assignment("lab1", 100, 90));
		bio101.addAssignment(3, new Assignment("lab1", 100, 90));
		
		List<Integer> allStudents = new ArrayList<>();
		allStudents = GradebookApp.getStudentsTakingEverything(courses);
		
		assertEquals(2, allStudents.size());
		
	}
	
	@Test
	void courseAverageForAssignments() {
		double eng101_avg;
		double mat101_avg;
		double bio101_avg;
		
		Course eng101 = new Course("Eng", 101);
		Course mat101 = new Course("Mat", 101);
		Course bio101 = new Course("Bio", 101);
		
		List<Course> courses = new ArrayList<>();
		courses.add(eng101);
		courses.add(mat101);
		courses.add(bio101);
		
		Student s1 = new Student("last1", "first1", 2);
		Student s2 = new Student("nguyen", "paul", 3);
		StudentBody sb = StudentBody.getInstance();
		sb.add(s1);
		sb.add(s2);
		//s1
		eng101.addAssignment(2, new Assignment("lab1", 100, 100));
		mat101.addAssignment(2,  new Assignment("lab1", 100, 90));
		bio101.addAssignment(2, new Assignment("lab1", 100, 90));
		//s2
		eng101.addAssignment(3, new Assignment("lab1", 100, 100));
		mat101.addAssignment(3,  new Assignment("lab1", 100, 90));
		bio101.addAssignment(3, new Assignment("lab1", 100, 90));
		
		eng101_avg = GradebookApp.courseAverageForAssignment(eng101, "lab1");
		mat101_avg = GradebookApp.courseAverageForAssignment(mat101, "lab1");
		bio101_avg = GradebookApp.courseAverageForAssignment(bio101, "lab1");
		
		assertEquals(100, eng101_avg);
		assertEquals(90, mat101_avg);
		assertEquals(90, bio101_avg);
	}
	
	@Test
	void calculateStudentAverageInOneCourse() {
		double course_avg;
		
		Course eng101 = new Course("Eng", 101);
		
		List<Course> courses = new ArrayList<>();
		courses.add(eng101);
		
		Student s1 = new Student("last1", "first1", 2);
		StudentBody sb = StudentBody.getInstance();
		sb.add(s1);
		
		eng101.addAssignment(2, new Assignment("lab1", 100, 100));
		eng101.addAssignment(2, new Assignment("lab2", 100, 0));
		
		course_avg = GradebookApp.calculateStudentAverageInOneCourse(eng101, 2);
		
		assertEquals(50, course_avg);
		
		
	}


}
