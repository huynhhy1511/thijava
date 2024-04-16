import java.io.*;
import java.util.ArrayList;
import java.util.List;


class EmployeeFileIO {
    private String filePath;

    public EmployeeFileIO(String filePath) {
        this.filePath = filePath;
    }


    public void writeToFile(List<Employee> employees) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Employee employee : employees) {
                writer.println(employee.getClass().getSimpleName());
                writer.println(employee.id);
                writer.println(employee.fullName);
                writer.println(employee.birthDay);
                writer.println(employee.phone);
                writer.println(employee.email);
                writer.println(employee.employeeType);

                if (employee instanceof Experience) {
                    Experience experience = (Experience) employee;
                    writer.println(experience.expInYear);
                    writer.println(experience.proSkill);
                } else if (employee instanceof Fresher) {
                    Fresher fresher = (Fresher) employee;
                    writer.println(fresher.graduationDate);
                    writer.println(fresher.graduationRank);
                    writer.println(fresher.education);
                } else if (employee instanceof Intern) {
                    Intern intern = (Intern) employee;
                    writer.println(intern.majors);
                    writer.println(intern.semester);
                    writer.println(intern.universityName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Đọc danh sách nhân viên từ file
    public List<Employee> readFromFile() {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String className = line.trim();
                int id = Integer.parseInt(reader.readLine());
                String fullName = reader.readLine();
                String birthDay = reader.readLine();
                String phone = reader.readLine();
                String email = reader.readLine();
                String employeeType = reader.readLine();

                if (className.equals("Experience")) {
                    int expInYear = Integer.parseInt(reader.readLine());
                    String proSkill = reader.readLine();
                    employees.add(new Experience(fullName, birthDay, phone, email, employeeType, expInYear, proSkill));
                } else if (className.equals("Fresher")) {
                    String graduationDate = reader.readLine();
                    String graduationRank = reader.readLine();
                    String education = reader.readLine();
                    employees.add(new Fresher(fullName, birthDay, phone, email, employeeType, graduationDate, graduationRank, education));
                } else if (className.equals("Intern")) {
                    String majors = reader.readLine();
                    String semester = reader.readLine();
                    String universityName = reader.readLine();
                    employees.add(new Intern(fullName, birthDay, phone, email, employeeType, majors, semester, universityName));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }
}
