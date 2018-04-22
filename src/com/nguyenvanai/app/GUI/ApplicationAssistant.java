package com.nguyenvanai.app.GUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.nguyenvanai.app.managers.BatchManager;
import com.nguyenvanai.app.managers.CourseManager;
import com.nguyenvanai.app.managers.ExamManager;
import com.nguyenvanai.app.managers.LecturerManager;
import com.nguyenvanai.app.managers.MajorManager;
import com.nguyenvanai.app.managers.StudentManager;
import com.nguyenvanai.app.models.AbstractEntity;
import com.nguyenvanai.app.models.Batch;
import com.nguyenvanai.app.models.Course;
import com.nguyenvanai.app.models.Exam;
import com.nguyenvanai.app.models.Lecturer;
import com.nguyenvanai.app.models.Major;
import com.nguyenvanai.app.models.Student;

public class ApplicationAssistant {

	public static final String NEW_STUDENT = "New Student";
	public static final String UPDATE_STUDENT = "Update Student";

	private static final ApplicationAssistant instance = new ApplicationAssistant();

	public static ApplicationAssistant getInstance() {
		return instance;
	}

	public ApplicationAssistant() {
	loadDataFromFile();

	//loadDefaultData();
	}

	LecturerManager lecturerManager = LecturerManager.getInstance();
	MajorManager majorManager = MajorManager.getInstance();
	CourseManager courseManager = CourseManager.getInstance();
	BatchManager batchManager = BatchManager.getInstance();
	StudentManager studentManager = StudentManager.getInstance();
	ExamManager examManager = ExamManager.getInstance();

	public static void main(String[] args) {

		System.out.println(ApplicationAssistant.getInstance().getBatchByID("B01"));
	}

	// add a student
	public boolean addStudent(Student student) {
		if (!batchManager.isExisted(student.getBatchId())) {
			return false;
		}
		if (!majorManager.isExisted(student.getMajorId())) {
			return false;
		}
		return studentManager.add(student);
	}

	// update a student
	public boolean updateStudent(Student newStudent) {
		return studentManager.update(newStudent);
	}

	// delete a student by ID
	public boolean deleteStudent(String id) {
		return studentManager.delete(id);
	}

	// Students to Array
	public Student[] studentsToArray() {
		int size = studentManager.count();
		return studentManager.all().toArray(new Student[size]);
	}

	// Courses to Array
	public Course[] coursesToArray(Collection<Course> courses) {
		int size = courseManager.count();
		return courses.toArray(new Course[size]);
	}

	// get courses by student's ID
	public Collection<Course> getCourseByMajorID(String id) {
		Collection<Course> courses = new ArrayList<>();
		for (AbstractEntity a : courseManager.all()) {
			Course c = (Course) a;
			if (c.getMajorId().equals(id)) {
				courses.add(c);
			}
		}
		return courses;
	}

	// Exams to Array
	public Exam[] examsToArray(Collection<Exam> exams) {
		int size = examManager.count();
		return exams.toArray(new Exam[size]);
	}

	// get courses by student's ID
	public Collection<Exam> getExamsByStudentID(String id) {
		Collection<Exam> exams = new ArrayList<>();
		for (AbstractEntity a : examManager.all()) {
			Exam e = (Exam) a;
			if (e.getStudentId().equals(id)) {
				exams.add(e);
			}
		}
		return exams;
	}

	// Batches to Array
	public Batch[] batchesToArray() {
		int size = batchManager.count();
		return batchManager.all().toArray(new Batch[size]);
	}

	// majors to Array
	public Major[] majorsToArray() {
		int size = majorManager.count();
		return majorManager.all().toArray(new Major[size]);
	}

	// get bath by Id
	public Batch getBatchByID(String id) {
		return (Batch) batchManager.get(id);
	}

	// get major by ID
	public Major getMajorByID(String id) {
		return (Major) majorManager.get(id);
	}

	// get course by ID
	public Course getCourseByID(String id) {
		return (Course) courseManager.get(id);
	}

	// get Lecturer by ID
	public Lecturer getLecturerByID(String id) {
		return (Lecturer) lecturerManager.get(id);
	}

	// sort students by ID
	public Student[] sortStudentByID() {
		int size = studentManager.count();
		return studentManager.sortByID().toArray(new Student[size]);
	}

	// sort students by Name
	public Student[] sortStudentByName() {
		int size = studentManager.count();
		return studentManager.sortByName().toArray(new Student[size]);
	}
	
	// save all data
	public void saveData() {
		lecturerManager.save();
		majorManager.save();
		courseManager.save();
		batchManager.save();
		studentManager.save();
		examManager.save();
	}


	// load data from file
	public void loadDataFromFile() {
		try {
			lecturerManager.loadData();
			majorManager.loadData();
			courseManager.loadData();
			batchManager.loadData();
			studentManager.loadData();
			examManager.loadData();
		} catch (Exception e) {
			loadDefaultData();
		}
		
	}

	// load default data
	public void loadDefaultData() {

		lecturerManager.add(new Lecturer("L01", "Duong", "doungnt@fpt.edu.vn", "0123456789"));
		lecturerManager.save();

		Arrays.asList("M01,M02".split(",")).forEach(id -> {
			majorManager.add(new Major(id, id + "major"));
		});

		majorManager.save();
		System.out.println(majorManager);

		Arrays.asList("C01,C02".split(",")).forEach(id -> {
			courseManager.add(new Course(id, id + "course", "M01", "L01"));
		});
		Arrays.asList("C03,C04".split(",")).forEach(id -> {
			courseManager.add(new Course(id, id + "course", "M01", "L01"));
		});

		courseManager.save();

		Arrays.asList("B01,B02".split(",")).forEach(id -> {
			batchManager.add(new Batch(id, id + "room"));
		});

		batchManager.save();

		studentManager.add(new Student("GC00702", "Tom",  "tom@gmail.com", "0123456789", "B01", "M01"));
		studentManager.add(new Student("GC00102", "Kaka",  "kaka@gmail.com", "0123456789", "B02", "M02"));
		studentManager.add(new Student("GC00502", "Terry",  "terry@gmail.com", "0123456789", "B01", "M01"));
		studentManager.add(new Student("GC00802", "Messi",  "messi@gmail.com", "0123456789", "B02", "M02"));
		studentManager.add(new Student("GC00101", "Ronaldo",  "ronaldo@gmail.com", "0123456789", "B01", "M01"));

		studentManager.save();

		Arrays.asList("E01,E02".split(",")).forEach(id -> {
			examManager.add(
					new Exam(id, id + "Name", "Make a student management systen", "distinction", "GC00702", "C01"));
		});
		Arrays.asList("E03,E04".split(",")).forEach(id -> {
			examManager.add(
					new Exam(id, id + "Name", "Make a student management systen", "distinction", "GC00502", "C02"));
		});
		Arrays.asList("E05,E06".split(",")).forEach(id -> {
			examManager.add(
					new Exam(id, id + "Name", "Make a student management systen", "distinction", "GC00102", "C02"));
		});

		examManager.save();
	}
}
