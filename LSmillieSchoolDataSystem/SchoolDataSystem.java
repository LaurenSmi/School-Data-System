/** 
 * School Data System Assignment
 * By Lauren Smillie
 * 05/29/2022
**/

import java.time.LocalDate;
import java.util.Scanner;
public class SchoolDataSystem
{
	// Fields
	private StudentGroup allStudents;
	private TeacherGroup allTeachers;
	private CourseGroup allCourses;
	private CourseSectionGroup allCourseSections;
	private RandomPersonGenerator r;
	private Scanner in;
	
	private static final int STOPPED = 0;
	private static final int RUNNING = 1;
	
	private int state = RUNNING;
	
	public SchoolDataSystem()
	{
		allStudents = new StudentGroup();
		allTeachers = new TeacherGroup();
		r = new RandomPersonGenerator();
		allCourses = new CourseGroup();
		allCourseSections = new CourseSectionGroup();
		in = new Scanner(System.in);
		
		// Default data
		for(int i=0;i<20;i++)
		{
			Student a = r.getRandomStudent();
			Teacher b = r.getRandomTeacher();
			allStudents.add(a);
			allTeachers.add(b);
		}
		Course c = new Course("Calculus",Subject.MATH,"",Grade.TWELVE,Level.U,"Applying calculus to the real world.");
		Course d = new Course("Intro to Computer Science",Subject.COMPUTER_STUDIES,"",Grade.ELEVEN,Level.M,"Intro to coding programs in java.");
		CourseSection e = new CourseSection(c,allTeachers.get(0),Location.RM01);
		CourseSection f = new CourseSection(d,allTeachers.get(1),Location.RM03);
		e.addStudent(allStudents.get(0));
		e.addStudent(allStudents.get(1));
		f.addStudent(allStudents.get(2));
		f.addStudent(allStudents.get(3));	
		allCourses.add(c);
		allCourses.add(d);
		allCourseSections.add(e);
		allCourseSections.add(f);
	
		while(state==RUNNING)
		{
			mainMenu();
		}
	}	
	// MAIN MENU
	private void mainMenu()
	{
		System.out.println();
		System.out.println("MAIN MENU");
		System.out.println("1\t Course Related\n2\t Course Section Related\n3\t Student Related\n4\t Teacher Related\n5\t Exit");
		System.out.println();
		System.out.print("Enter choice: ");
		int choice = choiceValidity(1,5);
		choice(choice);	
	}
	
	// MINI MENUS
	public void choice(int choice)
	{
		int choice2 =0;
		if (choice == 1)
		{
			while(choice2!=5)
			{
				System.out.println("\nCOURSE RELATED");
				System.out.println("1\t Add a course\n2\t Delete a course\n3\t View a course\n4\t View all courses\n5\t Back to Main Menu");
				System.out.print("Enter choice: ");
				choice2 = choiceValidity(1,5);
				courseRelated(choice2);
			}
		}
		else if(choice ==2)
		{
			while(choice2!=7)
			{
				System.out.println("\nCOURSE SECTION RELATED");
				System.out.println("1\t Add a course section\n2\t Delete a course section\n3\t Add a student to a course section\n4\t Delete a student from a course section \n5\t View a course section \n6\t View all course sections\n7\t Back to Main Menu");
				System.out.print("Enter choice: ");
				choice2 = choiceValidity(1,7);
				courseSectionRelated(choice2);
			}
		}
		else if(choice == 3)
		{
			while(choice2!=5)
			{
				System.out.println("\nSTUDENT RELATED");
				System.out.println("1\t Add a student to the school\n2\t Delete a student from the school\n3\t View a student\n4\t View all students \n5\t Back to Main Menu");
				System.out.print("Enter choice: ");
				choice2 = choiceValidity(1,5);
				peopleRelated(choice2,1);
			}
		}
		else if(choice == 4)
		{
			while(choice2!=5)
			{
				System.out.println("\nTEACHER RELATED");
				System.out.println("1\t Add a teacher to the school\n2\t Delete a teacher from the school\n3\t View a teacher\n4\t View all teachers \n5\t Back to Main Menu");
				System.out.print("Enter choice: ");
				choice2 = choiceValidity(1,5);
				peopleRelated(choice2,2);
			}
		}
		else
		{
			state = STOPPED;
		}
	}
	
	// COURSE RELATED	
	// Returns the course code so that when this method is called in other menus, the newly-created course can be found again
	private String courseRelated(int choice)
	{
		// Add a course
		if (choice==1)
		{
			System.out.println("NEW COURSE");
			System.out.print("Enter name: ");
			in.nextLine();
			String name = in.nextLine();
			name = capitalizer(name);
			System.out.println();
			System.out.print("1\tComputer Studies\n2\tBusiness\n3\tMath\n4\tMusic\n5\tTechnology\n\nEnter subject: ");
			int input3 = choiceValidity(1,5);
			Subject subject = Subject.fromInt(input3);
			System.out.print("Enter grade (from 9-12): ");
			int input4 = choiceValidity(9,12);
			Grade grade = Grade.fromInt(input4);
			System.out.print("1\tOpen\n2\tMixed\n3\tCollege\n4\tUniversity\n\nEnter level: ");
			int input5 = choiceValidity(1,4);
			Level level = Level.fromInt(input5);
			System.out.print("Enter description of course: ");
			in.nextLine();
			String description = in.nextLine();
			Course newCourse = new Course(name,subject,"",grade,level,description);
			if(allCourses.contains(newCourse.getCode()))
			{
				System.out.println("Course could not be added. A course with this code ("+newCourse.getCode() +") already exists.");
				return "false";
			}
			allCourses.add(newCourse);
			System.out.println(newCourse.getName()+" "+newCourse.getCode()+" added.");
			return newCourse.getCode();
		}
		// Delete a course
		else if(choice ==2)
		{
			System.out.println();
			System.out.println("DELETE A COURSE");
			System.out.print("1\tDelete using list\n2\tDelete using code\n3\tBack\n\nEnter choice: ");
			int input7 = choiceValidity(1,3);
			if (input7 ==3)
			{
				return "false";
			}
			else if(input7 == 1)
			{
				System.out.println(allCourses);
				System.out.print("Enter number: ");
				int input31 = choiceValidity(1,allCourses.size())-1;
				Course toDelete = allCourses.get(input31);
				System.out.println(toDelete.getName()+" "+toDelete.getCode() +" was deleted. All course sections of this course were also deleted.");
				allCourses.remove(toDelete);
				// Deleting a course also deletes all course sections that were constructed with the course as a field
				for(int j=0; j<allCourseSections.size(); j++)
				{
					if(allCourseSections.get(j).getCourse().equals(toDelete))
					{
						allCourseSections.remove(j);
					}	
				}
				return "true";
			} 
			
			else
			{
				boolean found = false;
				System.out.print("Enter code: ");
				String toDeleteCode = in.next().toUpperCase();
				for(int i =0; i<allCourses.size(); i++)
				{
					Course temp = allCourses.get(i);
					if(temp.getCode().equals(toDeleteCode))
					{
						found = true;
						Course toDelete = allCourses.get(i);
	
						System.out.println(toDelete.getName()+" "+toDelete.getCode() +" was deleted.");
						allCourses.remove(toDelete);
						
						for(int j=0; j<allCourseSections.size(); j++)
						{
							if(allCourseSections.get(j).getCourse().equals(toDelete))
							{
								allCourseSections.remove(j);
							}
							
						}
						return "true";
					}
				}
				System.out.println("A course with that code could not be found.");
				return "false";
			}
		}
		// View a course
		else if(choice ==3)
		{
			System.out.println(allCourses);
			System.out.print("Enter course to view: ");
			int input30 = choiceValidity(1,allCourses.size())-1;
			System.out.println(allCourses.get(input30)+"\n"+allCourses.get(input30).getDescription());
			System.out.print("\nPress any key to continue: ");
			String pause = in.next();
			return "true";
		}
		// View all courses
		else if(choice ==4)
		{
			System.out.println();
			System.out.println("ALL COURSES");
			System.out.println(allCourses);
			System.out.print("Press any key to continue: ");
			String pause = in.next();
			return "true";
		}
		return "false";
	}
	
	// COURSE SECTION RELATED
	private boolean courseSectionRelated(int choice)
	{
		// Add a course section
		if(choice ==1)
		{
			Course course = new Course();
			Teacher teacher = new Teacher();
			StudentGroup students = new StudentGroup();
			Location location;
			System.out.println("NEW COURSE SECTION");
			System.out.println("1\tChoose course from all courses\n2\tCreate new course\n3\tBack");
			System.out.print("Enter choice: ");
			int input11 = choiceValidity(1,3);
			if(input11==3)
			{
				return false;
			}
			else if(input11 ==1)
			{
				if(allCourses.size() == 0)
				{
					System.out.println("No courses found. Add courses before making a new course section.");
					return false;
				}
				System.out.println(allCourses);
				System.out.print("Enter number: ");
				int input12 = choiceValidity(1,allCourses.size())-1;
				course = allCourses.get(input12);
			}
			else
			{
				String code = courseRelated(1);
				if(!code.equals("false"))
				{
					boolean found = false;
					int counter = 0;
					while(!found && counter<allCourses.size())
					{
						Course temp = allCourses.get(counter);
						if(temp.getCode().equals(code))
						{
							course = temp;
							found = true;
						}
						counter++;
					}
					if(found==false)
					{
						System.out.println("A course section with this info could not be made.");
						return false;
					}
				}
				else
				{
					System.out.println("A course section with this info could not be made.");
					return false;
				}
			}
			System.out.println("1\tChoose teacher from all teachers\n2\tCreate new teacher");
			System.out.print("Enter choice: ");
			int input = choiceValidity(1,2);
			if(input ==1)
			{
				if(allTeachers.size() == 0)
				{
					System.out.println("No teachers found. Add teachers before making a new course section.");
					return false;
				}
				System.out.println(allTeachers);
				System.out.print("Enter number: ");
				int input12 = choiceValidity(1,allTeachers.size())-1;
				teacher = allTeachers.get(input12);
			}
			else
			{
				int iD = peopleRelated(1,2);
				boolean found = false;
				int counter = 0;
				while(!found && counter<allTeachers.size())
				{
					Teacher temp = allTeachers.get(counter);
					if(temp.getID() == iD)
					{
						teacher = temp;
						found = true;
					}
					counter++;
				}
				if(found==false)
				{
					System.out.println("A course section with this info could not be made.");
					return false;
				}
			}
			// Option to add students
			System.out.print("Would you like to add students at this time? (y/n) ");
			String input14 = in.next().toUpperCase();
			if(!input14.equals("NO") && !input14.equals("N"))
			{
				System.out.println("1\tChoose students from all students\n2\tCreate new students");
				System.out.print("Enter choice: ");
				int input13 = choiceValidity(1,2);
				if(input13 ==1)
				{
					if(allStudents.size()==0)
					{
						System.out.println("No students found. Add students before making a new course section.");
						return false;	
					}				
					System.out.print("How many students do you want to add? ");
					int studentsToAdd = choiceValidity(1,allStudents.size());
					System.out.println(allStudents);
					for(int i =0;i<studentsToAdd;i++)
					{
						System.out.print("Enter number to add: ");
						int input15 = choiceValidity(1,allStudents.size())-1;
						if(!students.add(allStudents.get(input15)))
						{
							// If student was already added, do not increase counter
							System.out.println("Student already added.");
							i--;
						}
					}
				}
				else
				{
					System.out.print("How many students do you want to add? ");
					int studentsToAdd = choiceValidity(1,10000);
					for(int i=0;i<studentsToAdd;i++)
					{
						int iD = peopleRelated(1,1);
						boolean found = false;
						int counter = 0;
						while(!found&&counter<allStudents.size())
						{
							Student temp = allStudents.get(counter);
							if(temp.getID() == iD)
							{
								students.add(temp);
								found = true;
							}
							counter++;
						}
						if(found==false)
						{
							i--;
							System.out.println("\nEnter a valid new student.");
						}
					}
				}
			}
			System.out.print("\n1\tRoom 01\n2\tRoom 02\n3\tRoom 03\nEnter location: ");
			location = Location.fromInt(choiceValidity(1,3));
			CourseSection newCourseSection = new CourseSection(course,students,teacher,location);
			if(allCourseSections.add(newCourseSection))
			{
				System.out.println("\t"+newCourseSection +"\t was added");
				return true;
			}
			System.out.println("A course section with that info already exists.");
			return false;
			
		}
		// Delete a course section
		else if(choice==2)
		{
			System.out.println("DELETE A COURSE SECTION");
			System.out.println(allCourseSections);
			System.out.print("Enter number to delete: ");
			int input19 = choiceValidity(1,allCourseSections.size())-1;
			CourseSection toDelete = allCourseSections.get(input19);
			System.out.println("\t"+toDelete+"\t was deleted");
			allCourseSections.remove(toDelete);
		}
		// Add a student to a course section
		else if(choice ==3)
		{
			System.out.println("ADD STUDENT TO COURSE SECTION");
			System.out.println(allCourseSections);
			System.out.print("Choose course section to edit: ");
			int input22 = choiceValidity(1,allCourseSections.size())-1;
			System.out.println("1\tChoose student to add from list\n2\tCreate new student");
			System.out.print("Enter choice: ");
			int input20 = choiceValidity(1,2);
			if(input20 ==1)
			{
				if(allStudents.size()==0)
				{
					System.out.println("No students found. Add students to school before adding them to a course section");
					return false;	
				}
				System.out.println(allStudents);
				System.out.print("Enter number to add: ");
				int input15 = choiceValidity(1,allStudents.size())-1;
				if(allCourseSections.get(input22).getStudents().contains(allStudents.get(input15)))
				{
					System.out.println("Student already added.");
					return false;
				}
				else
				{
					System.out.println(allStudents.get(input15)+" was added.");
					allCourseSections.get(input22).addStudent(allStudents.get(input15));
					return true;
				}
			}
			else
			{
				int iD = peopleRelated(1,1);
				boolean found = false;
				int counter = 0;
				Student temp = allStudents.get(0);
				while(!found&&counter<allStudents.size())
				{
					temp = allStudents.get(counter);
					if(temp.getID() == iD)
					{
						allCourseSections.get(input22).addStudent(temp);
						found = true;
					}
					counter++;
				}
				if(found==false)
				{
					System.out.println("Student could not be added to course section.");
				}
				else
				{
					System.out.println(temp+" was added.");
				}
			}
		}
		// Remove a student from a course section
		else if (choice ==4)
		{
			System.out.println("REMOVE A STUDENT");
			System.out.println(allCourseSections);
			System.out.print("Choose course section to edit: ");
			int input23 = choiceValidity(1,allCourseSections.size())-1;
			CourseSection temp = allCourseSections.get(input23);
			StudentGroup studentList = temp.getStudents();
			if(studentList.size()==0)
			{
				System.out.println("No students found. Students must be first added to the course section to delete them.");
				return false;
			}
			System.out.print("1\tDelete student using list\n2\tDelete using ID\n\nEnter choice: ");
			int input9 = choiceValidity(1,2);
			if(input9 == 1)
			{
				System.out.println(studentList);
				System.out.print("Enter number: ");
				int input10 = choiceValidity(1,studentList.size())-1;
				Student s = studentList.get(input10);
				System.out.println(s.getFirstName()+" "+s.getLastName()+" was removed.");
				temp.removeStudent(s);
				return true;
			}
			else
			{
				System.out.print("Enter ID: ");
				int idToDelete = in.nextInt();
				int counter =0;
				boolean found = false;
				// Search all students in the course section for ID to delete
				while (!found&&counter<studentList.size())
				{
					Student s = studentList.get(counter);
					if(s.getID() == idToDelete)
					{
						temp.removeStudent(s);
						found =true;
						System.out.println(s.getFirstName()+" "+s.getLastName()+" was removed.");
						System.out.println();
						return true;
					}
					counter++;
				}
				if(!found)
				{
					System.out.println("A student with that ID ("+idToDelete+") could not be found.");
					return false;
				}
			}
		}
		// View a course section
		else if(choice==5)
		{
			System.out.println("VIEW COURSE SECTION");
			System.out.println(allCourseSections);
			System.out.print("Enter number: ");
			int input25 = choiceValidity(1,allCourseSections.size())-1;
			System.out.println("\t"+allCourseSections.get(input25)+"\n\nStudent List:\n"+allCourseSections.get(input25).getStudents());
			System.out.print("Press any key to continue: ");
			String pause2 = in.next();
			return true;
		}
		// View all course sections
		else if(choice ==6)
		{
			System.out.println("ALL COURSE SECTIONS");
			System.out.println(allCourseSections);
			System.out.print("Press any key to continue: ");
			String pause = in.next();
			return true;
		}
		return false;
	}
	
	// PEOPLE RELATED
	// Returns the Teacher/Student's ID so that when this method is called in other menus, the newly-created person can be found again in its list
	private int peopleRelated(int choice, int role)
	{
		// People Menu is called for both teachers and students
		Student newStudent;
		Teacher newTeacher;
		Person newPerson;
		String person;
		boolean valid = true;
		// Teachers and students are differentiated by the field "role"
		if (role == 1)
		{
			person = "student";
		}
		else
		{
			person = "teacher";
		}
		// Add a new person
		if (choice==1)
		{
			System.out.println("NEW "+person.toUpperCase());

			System.out.print("Enter firstname: ");
			String firstName = in.next();
			firstName = capitalizer(firstName);
			System.out.print("Enter lastname: ");
			String lastName = in.next();
			lastName = capitalizer(lastName);
			System.out.print("Enter "+person+" ID: ");
			int iD = in.nextInt();
			// if student menu
			if (role == 1)
			{
				System.out.print("Enter date of birth (yyyy-mm-dd): ");
				String date = in.next();
				LocalDate dob = LocalDate.parse(date);
				newStudent = new Student(firstName, lastName, iD, dob);
				newPerson = newStudent;
				if(!allStudents.contains(iD))
				{
					valid = allStudents.add(newStudent);	
				}
				else
				{
					valid=false;
				}
			}
			// if teacher menu
			else
			{
				newTeacher = new Teacher(firstName, lastName, iD);
				newPerson = newTeacher;
				if(!allTeachers.contains(iD))
				{
					valid = allTeachers.add(newTeacher);	
				}
				else
				{
					valid = false;
				}
			}
			
			if (valid == false)
			{
				System.out.println(newPerson.getFirstName() +" "+newPerson.getLastName()+" could not be added. A "+person+" with that ID("+newPerson.getID()+ ") already exists.");
				return 0;
			}
			else
			{
				System.out.println(newPerson.getFirstName()+" "+newPerson.getLastName()+" was added.");
				return newPerson.getID();
			}
		}
		// Delete a person
		else if(choice ==2)
		{
			System.out.println("DELETE A "+person.toUpperCase());
			if(role==1 && allStudents.size()==0)
			{
				System.out.println("No students found. Students must be first added to the school to delete them.");
				return 0;
			}
			else if(role==2 && allTeachers.size()==0)
			{
				System.out.println("No teachers found. Teachers must be first added to the school to delete them.");
				return 0;
			}
			System.out.print("1\tDelete using list\n2\tDelete using ID\n3\tBack\n\nEnter choice: ");
			int input9 = choiceValidity(1,3);
			if(input9==3)
			{
				return 0;
			}
			// Student Menu
			if(input9 == 1)
			{
				if(role ==1)
				{
					System.out.println(allStudents);
					System.out.print("Enter number: ");
					int input10 = choiceValidity(1,allStudents.size())-1;
					Student s = allStudents.get(input10);
					System.out.println("\n"+capitalizer(person)+" "+s.getFirstName()+" "+s.getLastName()+" was removed from school and all course sections.");
					allStudents.remove(input10);
					// Delete student from all course sections
					for(int j=0;j<allCourseSections.size();j++)
					{
						StudentGroup toCheck = allCourseSections.get(j).getStudents();
						if(toCheck.contains(s))
						{
							allCourseSections.get(j).removeStudent(s);
						}
					}
					return 1;
				}	
				// if Teacher Menu
				else
				{
					System.out.println(allTeachers);
					System.out.print("Enter number: ");
					int input10 = choiceValidity(1,allTeachers.size())-1;
					Teacher s = allTeachers.get(input10);
					System.out.println("\n"+capitalizer(person)+" "+s.getFirstName()+" "+s.getLastName()+" was removed. All course sections that they taught were also deleted.");
					allTeachers.remove(input10);
					// Delete all course sections that the teacher taught
					for(int j=0;j<allCourseSections.size();j++)
					{
						Teacher toCheck = allCourseSections.get(j).getTeacher();
						if(toCheck.equals(s))
						{
							allCourseSections.remove(j);
						}
					}
					return 1;
				}
			}
			// if Student Menu
			else
			{
				if(role==1)
				{
					System.out.print("Enter ID to delete: ");
					int idToDelete = in.nextInt();
					int counter =0;
					boolean found = false;
					Student temp = allStudents.get(counter);
					while (!found&&counter<allStudents.size())
					{
						temp = allStudents.get(counter);
						if(temp.getID() == idToDelete)
						{
							allStudents.remove(temp);
							found =true;
							System.out.println(capitalizer(person)+" "+temp.getFirstName()+" "+temp.getLastName()+" was removed from school and all course sections.");
						}
						counter++;
					}
					if(!found)
					{
						System.out.println("A student with that ID ("+idToDelete+") could not be found.");
						return 0;
					}
					// Delete student from all necessary course sections
					for(int j=0;j<allCourseSections.size();j++)
					{
						StudentGroup toCheck = allCourseSections.get(j).getStudents();
						if(toCheck.contains(temp))
						{
							allCourseSections.get(j).removeStudent(temp);
						}
					}
					return 1;
				}
				// if Teacher Menu
				else
				{
					System.out.print("Enter ID to delete: ");
					int idToDelete = in.nextInt();
					int counter =0;
					boolean found = false;
					Teacher temp = allTeachers.get(counter);
					while (!found&&counter<allTeachers.size())
					{
						temp = allTeachers.get(counter);
						if(temp.getID() == idToDelete)
						{
							allTeachers.remove(temp);
							found =true;
							System.out.println(capitalizer(person)+" "+temp.getFirstName()+" "+temp.getLastName()+" was removed. All course sections that they taught were also deleted.");
						}
						counter++;
					}
					if(!found)
					{
						System.out.println("A teacher with that ID ("+idToDelete+") could not be found.");
						return 0;
					}
					// Delete all course sections that the teacher taught
					for(int j=0;j<allCourseSections.size();j++)
					{
						Teacher toCheck = allCourseSections.get(j).getTeacher();
						if(toCheck.equals(temp))
						{
							allCourseSections.remove(j);
						}
					}
					return 1;
					
				}
			}
		}
		// View a person
		else if(choice ==3)
		{
			System.out.println("VIEW A "+person.toUpperCase());
			{
				System.out.print("1\tFind using list\n2\tFind using ID\n3\tBack\n\nEnter choice: ");
				int input9 = choiceValidity(1,3);
				if(input9==3)
				{
					return 0;
				}
				else if(input9 == 1)
				{
					// if Student Menu
					if(role ==1)
					{
						System.out.println(allStudents);
						System.out.print("Enter number: ");
						int input10 = choiceValidity(1,allStudents.size())-1;
						Student temp= allStudents.get(input10);
						System.out.println("\n"+temp);
						System.out.print("\nCourse Sections: \n"+ studentCourses(temp)+"\n");
					}
					// if Teacher Menu
					else
					{
						System.out.println(allTeachers);
						System.out.print("Enter number: ");
						int input10 = choiceValidity(1,allStudents.size())-1;
						System.out.println(allTeachers.get(input10));
					}
					System.out.print("Press any key to continue: ");
					String pause3 = in.next();
				}
				else
				{
					// if Student Menu
					if(role==1)
					{
						System.out.print("Enter ID: ");
						int idToFind = in.nextInt();
						int counter =0;
						boolean found = false;
						while (!found&&counter<allStudents.size())
						{
							Student temp = allStudents.get(counter);
							if(temp.getID() == idToFind)
							{
								System.out.println("\n"+temp);
								System.out.print("\nCourse Sections: \n"+ studentCourses(temp));
								found =true;
								System.out.print("Press any key to continue: ");
								String pause3 = in.next();
								return 1;
							}
							counter++;
						}
						System.out.println("A student with that ID ("+idToFind+") could not be found.");
						return 0;
					}
					// if Teacher Menu
					else
					{
						System.out.print("Enter ID: ");
						int idToFind = in.nextInt();
						int counter =0;
						boolean found = false;
						while (!found&&counter<allTeachers.size())
						{
							Teacher temp = allTeachers.get(counter);
							if(temp.getID() == idToFind)
							{
								System.out.println("\n"+temp);
								found =true;
								System.out.print("Press any key to continue: ");
								String pause3 = in.next();
								return 1;
							}
							counter++;
						}
						System.out.println("A teacher with that ID ("+idToFind+") could not be found.");
						return 0;
					}
					
				}
			}
		}
		// View all
		else if(choice ==4)
		{
			System.out.println("ALL "+person.toUpperCase()+"S:");
			// if Student Menu
			if(role==1)
			{
				System.out.println(allStudents);
			}
			// if Teacher Menu
			else
			{
				System.out.println(allTeachers);
			}
			System.out.print("Press any key to continue: ");
			String pause = in.next();
			return 1;
		}
		return 0;
	}
	
	// PRIVATE HELPER METHODS
	// Ensures that numerical choice is between the given range
	private int choiceValidity(int low, int high)
	{
		int num = in.nextInt();
		if(num>high || num<low)
		{
			while(num>high || num<low)
			{
				System.out.println("Invalid Choice");
				System.out.print("Enter choice: ");
				num = in.nextInt();
			}
		}
		System.out.println();
		return num;
	}
	// Capitalizes words
	private String capitalizer(String name)
	{
		name = name.substring(0,1).toUpperCase()+name.substring(1);
		return name;
	}
	// Creates a CourseSectionGroup of all of a student's course sections
	private CourseSectionGroup studentCourses(Student s)
	{
		CourseSectionGroup studentCourses = new CourseSectionGroup();
		for(int i =0; i<allCourseSections.size();i++)
		{
			CourseSection temp = allCourseSections.get(i);
			if(temp.getStudents().contains(s))
			{
				studentCourses.add(temp);
			}
		}
		return studentCourses;
	}
	// Main Method
	public static void main(String[] args)
	{
		SchoolDataSystem system = new SchoolDataSystem();
	}
}
