import java.util.*;

class Department {
    private String name;
    private int number;
    private Employee manager;
    private Date date;
    private List<Project> assignProjectPool = new ArrayList<>();

    public Department(String name,int number,Employee manager) {
        this.name = name;
        this.number = number;
        this.manager = manager;
    }
    public void assignProjectList(Project p) {
        assignProjectPool.add(p);
    }
    public String getName() {
        return name;
    }
    public void setManager(Employee e) {
        manager = e;
    }
    public Employee getManager() {
        return manager;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumber() {
        return number;
    }
    public int getDepartmentId() {
        return number;
    }
    public void setDepartmentId(int number) {
        this.number = number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
    public String toString() {
        return "\n"+"Name : "+name+"\n"+"Id : "+number+"\n"+"Manager : "+manager+"\n";
    }
}

class Project {
    private String name;
    private String location;

    public Project(String name,String location) {
        this.name = name;
        this.location = location;
    }
     public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
     public String toString() {
        return "\n"+"Name : "+name+"\n"+"Location : "+location+"\n";
    }
}

class Employee {
    private String name;
    private int Id;
    private String address;
    private double salary;
    private String gender;
    private String birthDate;
    private List<Project> projectAssignPool = new ArrayList<>();

    public Employee(String name,int Id,String address,double salary,String gender,String birthDate) {
        this.name = name;
        this.Id = Id;
        this.address = address;
        this.salary = salary;
        this.gender = gender;
        this.birthDate = birthDate;
    }
    public void assignEmployeeList(Project p) {
        projectAssignPool.add(p);
    }
    public void printAssigned() {
        for(Project p1 : projectAssignPool) {
            System.out.println(p1.toString());
        }
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setId(int Id) {
        this.Id = Id;
    }
    public int getId() {
        return Id;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }
    public String toString() {
        return "\n"+"Name : "+name+"\n"+"SSN : "+Id+"\n"+"Address : "+address+"\n"
        +"Salary : "+salary+"\n"+"Gender : "+gender+"\n"+"Birthdate : "+birthDate+"\n";
    }
}

public class LabIA {
    private static int Id,i;
    private static String name,location;
    private static boolean manager = false;
    private static int index = -1,number;
    private static double salary;
    private static String address,gender,birthDate;
    private static Employee depManager;
    private static int v = -1;
    private static List<Department> departmentPool = new ArrayList<>();
    private static List<Employee> employeePool = new ArrayList<>();
    private static List<Project> projectPool = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        int choice;

        while(true) {
            System.out.println("\n-----The choices are as follows-----");
            System.out.println("1 : Create a department");
            System.out.println("2 : Register or Unregister employee");
            System.out.println("3 : Register or Unregister project");
            System.out.println("4 : Assign project to department");
            System.out.println("5 : Assign employee to project");
            System.out.println("6 : Listings");
            System.out.println("7 : EXIT\n");
            System.out.print("Enter your choice here : ");
            choice = sc.nextInt();

            switch(choice) {
                case 1: createDepartment();
                    break;
                case 2: registerEmployee();
                    break;
                case 3: registerProject();
                    break;
                case 4: assignDepartment();
                    break;
                case 5: assignEmployee();
                    break;
                case 6: System.out.println("\nEnter your choice from the following");
                        System.out.println("1 : List the Departments");
                        System.out.println("2 : List the Projects");
                        System.out.println("3 : List the Employees");
                        System.out.println("4 : List the assigned employees to any project\n");
                        System.out.print("Enter your choice here : ");
                        choice = sc.nextInt();
                        switch(choice) {
                            case 1: listDepartments();
                                break;
                            case 2: listProjects();
                                break;
                            case 3: listEmployees();
                                break;
                            case 4: listAssignedEmployee();
                                break;
                        }
                    break;
                case 7: System.exit(0);
            }
        }
    }

    public static void listAssignedEmployee() {
        for(Employee e1 : employeePool) {
            e1.printAssigned();
        }
    }

    public static void listDepartments() {
        for (Department d1 : departmentPool) {
                System.out.println(d1.toString());
        }
    }

    public static void listProjects() {
        for (Project p1 : projectPool) {
                System.out.println(p1.toString());
        }
    }

    public static void listEmployees() {
        for (Employee e1 : employeePool) {
                System.out.println(e1.toString());
        }
    }
    
    public static void registerEmployee() {
        int choice;

        System.out.println("\nChoices are as follows");
        System.out.println("1 : Register\n2 : Unregister");
        System.out.print("Enter your choice here : ");
        choice = sc.nextInt();
        if(choice == 1) {
            System.out.println("Enter the employee Id");
            Id = sc.nextInt();
            if(isEmployee(Id) == true) {
                System.out.println("Employee Id already exists");
            }
            else {
                System.out.println("Enter the employee name");
                name = sc.next();
                System.out.println("Enter the employee address");
                address = sc.next();
                System.out.println("Enter the employee salary");
                salary = sc.nextDouble();
                System.out.println("Enter the employee gender");
                gender = sc.next();
                System.out.println("Enter the employee birthdate");
                birthDate = sc.next();
                Employee e1 = new Employee(name,Id,address,salary,gender,birthDate);
                employeePool.add(e1);
                i++;
            }
        }
        else {
            System.out.println("Enter the employee Id");
            Id = sc.nextInt();
            if(isEmployee(Id) == true) {
                employeePool.remove(index);
                i--;
                System.out.println("\nEmployee unregistered successfully!!!\n");
            }
            else {
                System.out.println("Employee does not exist");
            }
        }
    }

    public static void createDepartment() {

        System.out.println("\n----Creating a department----");
        System.out.println("Enter the department number");
        number = sc.nextInt();
        if(isDepartment(number) == true) {
            System.out.println("Department already exists");
        }
        else {
            System.out.println("Enter department name");
            name = sc.next();
            System.out.println("Enter the employee Id for the manager");
            Id = sc.nextInt();
            if(isEmployee(Id) == true) {
                depManager = employeePool.get(index);
                Department d1 = new Department(name,number,depManager);
                departmentPool.add(d1);
            }            
            else {
                System.out.println("The employee does not exist");
            }
        }
    }

    public static boolean isEmployee(int Id) {
        int m = 0;
        manager = false;
        while((manager == false) && m<i) {
            if(Id == employeePool.get(m).getId()) {
                manager = true;
                index = m;
            }
            m++;
        }
        return manager;
    }

    public static boolean isDepartment(int Id) {
        for(Department d1 : departmentPool) {
            if(d1.getDepartmentId() == Id) {
                return true;
            }
        }
        return false;
    }

    public static void registerProject() {
        System.out.println("Enter the name of the project");
        name = sc.next();
        if(isProject(name) == true) {
            System.out.println("This project name already exists");
        }
        else {
            System.out.println("Enter the location");
            location = sc.next();
            Project p1 = new Project(name,location);
            projectPool.add(p1);
            
        }
    }

    public static boolean isProject(String name) {
        for(Project p1 : projectPool) {
            if(name.equals(p1.getName())) {
                return true;
            }
        }
        return false;
    }

    public static void assignDepartment() {
        Department d1;
        Project p1;
        System.out.println("Enter the Department number");
        Id = sc.nextInt();
        if(isDepartment(Id) == true) {
            d1 = returnDepartment(Id);
            System.out.println("Enter the project name");
            name = sc.next();
            if(isProject(name) == true) {
                p1 = returnProject(name);
                d1.assignProjectList(p1);
                System.out.println("The department has been assigned");
            }
            else {
                System.out.println("The project does not exist");
            }
        }
        else {
            System.out.println("The department does not exist");
        }
    }

    public static void assignEmployee() {
        Employee e1;
        Project p1;
        System.out.println("Enter the employee Id");
        Id = sc.nextInt();
        if(isEmployee(Id) == true) {
            e1 = returnEmployee(Id);
            System.out.println("Enter the project name");
            name = sc.next();
            if(isProject(name) == true) {
                p1 = returnProject(name);
                e1.assignEmployeeList(p1);
                System.out.println("The employee has been assigned");
            }
            else {
                System.out.println("The project does not exist");
            }
        }
        else {
            System.out.println("The employee does not exist");
        }
    }

    public static Department returnDepartment(int number) {
        for(Department d1 : departmentPool) {
            if(number == d1.getNumber()) {
                return d1;
            }
        }
        return null;
    }

    public static Employee returnEmployee(int Id) {
        for(Employee e1 : employeePool) {
            if(Id == e1.getId()) {
                return e1;
            }
        }
        return null;
    }

    public static Project returnProject(String name) {
        for(Project p1 : projectPool) {
            if(name.equals(p1.getName())) {
                return p1;
            }
        }
        return null;
    }
}