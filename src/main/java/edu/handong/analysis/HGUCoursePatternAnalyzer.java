package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	int numOfStudents;
	int numOfCourses;
	Student[] students;
	Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return array of student 
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		Student[] tmpStudents = new Student[numOfStudents];
		
		int i = 0;
		// TODO: implement this method
		// 1. lines를 반복하는 반복문이 필요.
		for (String line : lines)
		{
			// 2. 한 문자열에 대한 이름을 뽑아야 함.
			String name = line.substring(8, 14);

			// 3. 추출한 이름 -> Student newStudent = new Student(추출한 이름);
			Student newStudent = new Student(name);
			// 3-1. 중복체크를 해서같은 이름이 들어있으면 건너뛰도록.
			if (studentExist(tmpStudents, newStudent))
				continue;
			
			// 4. 배열에 넣어야 한다. tmpStudents[i] = newStudent;
			tmpStudents[i] = newStudent;
			i++;
		}
		
		return tmpStudents;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {

		// 1. students를 반복하는 for문 만든다.
		// 2. student와 students[i] 가 같은지 비교. 비교할때는 getName() 이 메서드를 써야함.
		// 3. 같으면 return true

		for (Student current : students)
		{
			if (current != null && current.getName().equals(student.getName()))
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		Course[] tmpCourses = new Course[numOfCourses];
		
		int i = 0;
		
		for (String line : lines)
		{
			String name = line.substring(16);

			Course newCourse = new Course(name);
			if (courseExist(tmpCourses, newCourse))
				continue;
			
			tmpCourses[i] = newCourse;
			i++;
		}
		
		return tmpCourses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		for (Course current : courses)
		{
			if (current != null && current.getCourseName().equals(course.getCourseName()))
			{
				return true;
			}
		}
		
		return false;
	}

}