package SistemaGestionAlumnos.domain;

public class Student {

    private int ID;
    private String name;
    private String email;
    private String course;

    public Student(int ID, String name, String email, String course) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
