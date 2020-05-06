package ass1;

//Aditya Garg 
//Roll no 2018124

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Node {

	// To store the data of technical interview and companies name for the Student

	private String cname;
	private int tech;

	public Node(int tech, String cname) {
		this.tech = tech;
		this.cname = cname;
	}

	public int tt() {
		return this.tech;
	}

	public String nn() {
		return this.cname;
	}
}

class Student {

	// The student class consists of all the parameters necessary for the student
	// and their value getters for the
	// the main class. The functions/modules of this class consists of value
	// getters, alldetails(all details of sudent)
	// and the data array for storing the data of technical interview aloing with
	// its company name.

	private int rollno;
	private double cgpa;
	private String course;
	private int status;
	private String companyP;
	private int score;
	private ArrayList<Node> data;

	public Student(double cgpa, String course, int rollno) {
		this.rollno = rollno;
		this.cgpa = cgpa;
		this.status = 0;
		this.course = course;
		this.companyP = "None";
		this.score = 0;
		data = new ArrayList<>();
	}

	public void setback() {
		this.score = 0;
	}

	public void dataAdd(int t, String nn) {
		data.add(new Node(t, nn));
	}

	public void getdata() {
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).nn());
			System.out.println(data.get(i).tt());
		}
	}

	public void alldetails() {
		System.out.println(this.rollno);
		System.out.println(this.cgpa);
		System.out.println(this.course);
		if (this.status == 0) {
			System.out.println("Placement Status: Not Placed");
		} else {
			System.out.println("Placed at: " + this.companyP);
		}
	}

	public int getroll() {
		return this.rollno;
	}

	public double getcgpa() {
		return this.cgpa;
	}

	public String getcourse() {
		return this.course;
	}

	public int getstatus() {
		return this.status;
	}

	public String getcompany() {
		return this.companyP;
	}

	public int getscore() {
		return this.score;
	}

	public void Cstatus(int st) {
		this.status = st;
	}

	public void Ccompany(String company) {
		this.companyP = company;
	}

	public void Cscore(int scr) {
		this.score = scr;
	}
}

class Company {

	// The company class also consists of its main parameters and their value
	// getters for the main class. The modules
	// of this class include modules for Selected arraylist which storesnthe
	// students data which are selected into this comapny
	// and the getdetails module which outputs all the details of the company.

	private String name;
	private ArrayList<String> creq;
	private int reqs;
	private String appication;
	private ArrayList<Student> selected;
	private ArrayList<Student> elig;

	public Company(String name, int reqs) {
		this.name = name;
		this.reqs = reqs;
		creq = new ArrayList<>();
		selected = new ArrayList<>();
		this.appication = "OPEN";
		elig = new ArrayList<>();
	}

	public ArrayList<Student> my1() {
		return elig;
	}
	
	public ArrayList<Student> master() {
		return selected;
	}

	public Student farfar(int i) {
		return elig.get(i);
	}

	public int sq() {
		return elig.size();
	}

	public void adder(Student nn) {
		elig.add(nn);
	}

	public void addselect(Student no) {
		selected.add(no);
	}
	
	public int hh(int j) {
		return selected.get(j).getroll();
	}

	public void allselected2() {
		for (int i = 0; i < elig.size(); i++) {
			System.out.println(elig.get(i).getroll());
		}
	}

	public void allselected() {
		for (int i = 0; i < selected.size(); i++) {
			System.out.println(selected.get(i).getroll());
		}
	}

	public int ssize() {
		return this.selected.size();
	}

	public String getname() {
		return this.name;
	}

	public int getreqs() {
		return this.reqs;
	}

	public String getstatus() {
		return this.appication;
	}

	public void addc(String c) {
		creq.add(c);
	}

	public void change() {
		this.appication = "CLOSED";
	}

	public int isthere(String ss) {
		for (int i = 0; i < creq.size(); i++) {
			if (ss == creq.get(i)) {
				return 1;
			}
		}
		return 0;
	}

	public void getdetails() {
		System.out.println(this.name);
		System.out.println("Course Criteria");
		for (int i = 0; i < creq.size(); i++) {
			System.out.println(creq.get(i));
		}
		System.out.println("Number Of Required Students = " + this.reqs);
		System.out.println("Application Status = " + this.appication);

	}
}

public class Assign1 {

	public static void main(String[] args) {
		// The code consits of two proper class i.e Student class and the Company class
		// and one main class Assign1
		// to perform the methods as per the question, it also consists of one
		// supporting class Node.
		// the code works as given in the assignment with all the functionality of the q
		// values.
		// the main values were q=1 and q=6, for q=1 i.e making the company, the code is
		// as follows it consists
		// of a arraylist elig which contains students eligible for this company , the
		// comparator defined sorts
		// students ont he condition given in the assignment
		// For q=6 , select students, only when 6 <company name> is entered then only
		// the students are confirmed select
		// into the company and the no of unplaced students cahnges. Rest all things
		// does as mentioned in the assignment.
		// One extra q value q=10 is being added my me to force quit the application at
		// any stage.

		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();

		ArrayList<Student> stu = new ArrayList<>();
		ArrayList<Company> comp = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			double cg = s.nextDouble();
			String course = s.next();
			Student stud = new Student(cg, course, i + 1);
			stu.add(stud);
		}

		int key = 0;

		while (key != n) {
			int q = s.nextInt();

			if (q == 1) {
				// Add Company
				String name = s.next();

				System.out.println("Number of Eligible Courses: ");
				int cc = s.nextInt();

				ArrayList<String> free = new ArrayList<>();
				for (int k = 0; k < cc; k++) {
					free.add(s.next());
				}

				System.out.println("Number of Required Students: ");
				int require = s.nextInt();

				Company cop = new Company(name, require);
				for (int j = 0; j < free.size(); j++) {
					cop.addc(free.get(j));
				}

				cop.getdetails();
				comp.add(cop);

				Comparator<Student> Comparator = new Comparator<Student>() {
					@Override
					public int compare(Student s1, Student s2) {
						if (s1.getscore() == s2.getscore()) {
							return (int) ((s1.getcgpa()) - (s2.getcgpa()));
						} else {
							return s1.getscore() - s2.getscore();
						}

					}
				};

//				ArrayList<Student> elig = new ArrayList<>();

				for (int i = 0; i < stu.size(); i++) {
					for (int j = 0; j < free.size(); j++) {
						if (stu.get(i).getcourse().equals(free.get(j))) {
//							System.out.println("----");
							cop.adder(stu.get(i));
						}
					}
				}
//				cop.allselected2();
//				System.out.println(cop.my1().size());

				System.out.println("Enter the scores for the Technical round: ");

				for (int l = 0; l < cop.my1().size(); l++) {
					System.out.println("Enter the Score for Roll no. " + cop.my1().get(l).getroll());
					int marks = s.nextInt();
					cop.my1().get(l).Cscore(marks);

					cop.my1().get(l).dataAdd(marks, cop.getname());
				}

				Collections.sort(cop.my1(), Comparator);
				Collections.reverse(cop.my1());

//				cop.allselected2();

				for (int i = 0; i < stu.size(); i++) {
					stu.get(i).setback();
				}

//				for (int i = 0; i < stu.size(); i++) {
//					System.out.println(stu.get(i).getcgpa());
//					System.out.println(stu.get(i).getroll());
//					System.out.println(stu.get(i).getscore());
//					System.out.println(stu.get(i).getcompany());
//					System.out.println(stu.get(i).getstatus());
//				}

			}

			else if (q == 2) {
				int key1 = stu.size();
				int counter1 = 0;
				for (int i = 0; i < key1; i++) {
					if (stu.get(i - counter1).getstatus() == 1) {
						System.out.println("Accounts Removed For: ");
						System.out.println(stu.get(i - counter1).getroll());
						stu.remove(i - counter1);
						counter1++;
					}
				}
			}

			else if (q == 3) {

				int key2 = comp.size();
				int counter2 = 0;

				for (int i = 0; i < key2; i++) {
					if (comp.get(i - counter2).getstatus().equals("CLOSED")) {
						System.out.println("Accounts removed For: ");
						System.out.println(comp.get(i - counter2).getname());
						comp.remove(i - counter2);
						counter2++;
					}
				}
			}

			else if (q == 4) {
				System.out.println(n - key);
			}

			else if (q == 5) {
				if (comp.size() == 0) {
					System.out.println("No Company is there in Server");
				} else {
					for (int i = 0; i < comp.size(); i++) {
						if (comp.get(i).getstatus().equals("OPEN")) {
							System.out.println(comp.get(i).getname());
						}
					}
				}
			}

			else if (q == 6) {

				int finalx2 = -1;
				String nm = s.next();
				boolean ff = false;
				for (int i = 0; i < comp.size(); i++) {
					if (comp.get(i).getname().equals(nm)) {
						finalx2 = i;
						ff = true;
					}
				}
//				System.out.println(comp.get(finalx2).getname());
				int free = 0;

//				System.out.println(comp.get(finalx2).sq());
				for (int i = 0; i < comp.get(finalx2).sq(); i++) {
					

					if (free == comp.get(finalx2).getreqs()) {
//						System.out.println("------b-----");
						break;
					}

					if (comp.get(finalx2).farfar(i).getstatus() == 0) {
//						System.out.println(comp.get(finalx2).farfar(i).getroll());
//						System.out.println("======add=======");
						
						comp.get(finalx2).addselect(comp.get(finalx2).farfar(i));
						
//						comp.get(finalx2).allselected();
						comp.get(finalx2).farfar(i).Ccompany(comp.get(finalx2).getname());
						free++;
					}
				}
				
				System.out.println("Roll no of Selected students: ");
				
				
				comp.get(finalx2).allselected();
				key = key + comp.get(finalx2).ssize();

				if (comp.get(finalx2).ssize() == comp.get(finalx2).getreqs()) {
					comp.get(finalx2).change();
				}

				for (int w = 0; w < comp.get(finalx2).ssize(); w++) {
//					System.out.println("-------p------");
					comp.get(finalx2).master().get(w).Cstatus(1);
				}
				
			}

			else if (q == 7) {
				String nmm = s.next();
				boolean far = false;
				for (int i = 0; i < comp.size(); i++) {
					if (comp.get(i).getname().equals(nmm)) {
						comp.get(i).getdetails();
						far = true;
					}
				}

				if (far == false) {
					System.out.println("No such Company Exists");
				}

			}

			else if (q == 8) {
				int roll = s.nextInt();
				boolean f2 = false;
				for (int i = 0; i < stu.size(); i++) {
					if (stu.get(i).getroll() == roll) {
						stu.get(i).alldetails();
						f2 = true;
					}
				}
				if (f2 == false) {
					System.out.println("No student with the given roll number has an account");
				}
			}

			else if (q == 9) {
				int roll2 = s.nextInt();
				boolean f3 = false;
				for (int i = 0; i < stu.size(); i++) {
					if (stu.get(i).getroll() == roll2) {
						stu.get(i).getdata();
						f3 = true;
					}

				}
				if (f3 == false) {
					System.out.println("No student with the given roll number has an account");
				}
			}

			else if (q == 10) {
				System.out.println("Force Quit the process");
				break;
			}

		}
	}
}