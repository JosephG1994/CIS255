package test;
class CourseRegistration {
	static class Student {
		
            // instance data variables
	    private String firstName;
	    private String lastName;
	    private String studentID;
	    private boolean tuitionPaid;

	    // constructor for student
	    public Student(String firstName, String lastName, String studentID, boolean tuitionPaid) {
	    	this.firstName = firstName;
		    this.lastName = lastName;
		    this.studentID = studentID;
		    this.tuitionPaid = tuitionPaid;	
	    }

	    // getter methods
	    public String getFirstName() {
	    	return firstName;
	    }
	    public String getLastName() {
		    return lastName;
	    }
	    public String getStudentID() {
		    return studentID;
	    }
	    public boolean getTuitionPaid() {
		    return tuitionPaid;
	    }
	
	    // setter methods
	    public void setFirstName(String firstName) {
	    	this.firstName = firstName;
	    }
	    public void setLastName(String lastName) {
		    this.lastName = lastName;
	    }
	    public void setStudentID(String studentID) {
		    this.studentID = studentID;
	    }
	    public void setTuitionPaid(boolean tuitionPaid) {
		    if(tuitionPaid = true) {
		    	this.tuitionPaid = tuitionPaid;
	        }
	    }
	
	    // toString method
	    public String toString() {
		    String s = "First Name: " + firstName
				    + "\n\tLast Name: " + lastName
				    + "\n\tStudent ID: " + studentID
				    + "\n\tHas tuition been paid: " + tuitionPaid;
		    return s;
	    }
    }
	
    static class Course {
 
    	// instance data variables
	private String courseName;
	private int classCapacity;
	private Student[] studentsInSchool = new Student[7];
        private int numberOfStudents = 0;

	// constructor for course
        public Course(String courseName, int classCapacity) {
            this.courseName = courseName;
    	    this.classCapacity = classCapacity;
    	    studentsInSchool = new Student[classCapacity];
        }
    
        // addStudent method
        public boolean addStudent(Student student) {
			if ((numberOfStudents < classCapacity)) {
		        studentsInSchool[numberOfStudents++] = student;
    		    return true;
    	    }
    	    else{
    	        return false;
			}
        }
    
        // dropStudent method
        public boolean dropStudent(Student student) {
    	    if (numberOfStudents != 0) {
    	    	studentsInSchool[numberOfStudents--] = null;
    		    return true;
    	    }
    	    else {
    		    return false;
    	    }
        }
    
        // getter methods
        public String getCourseName() {
        	return courseName;
        }
        public int getClassCapacity() {
    	    return classCapacity;
        }
    
        // setter methods
        public void setCourseName(String courseName) {
    	    this.courseName = courseName;
        }
        public void setClassCapacity(int classCapacity) {
    	    if (classCapacity >=0) {
    		    this.classCapacity = classCapacity;
    	    }
        }
    
        // toString method
        public String toString() {
    	    String s ="Course Name: " + courseName + "\nClass Capacity: " + classCapacity + "\nCurrent Enrollment: " + numberOfStudents 
    	    	    + "\nstudentsInSchool:" + "\n" + studentsInSchool[0] + studentsInSchool[1] 
    	    	    + "\n" + studentsInSchool[2] + "\n" + studentsInSchool[3] + "\n" + studentsInSchool[4] 
    	    	    + "\n" + studentsInSchool[5] + "\n" + studentsInSchool[6] + "\n" + studentsInSchool[7] + "\n";
    	    return s;
        }
    }
}

