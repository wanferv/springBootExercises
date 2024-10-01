package SistemaGestionAlumnos.controllers;

import SistemaGestionAlumnos.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class StudentController {

    private List<Student> students  = new ArrayList<>(Arrays.asList(
            new Student(1,"Jairo Maldonado","jair.maldonado@seit.com","Economíca"),
            new Student(3,"Marcela Carmona","marcela.carmona@seit.com","Ingenieria Multimedia"),
            new Student(4,"Gabriela Calero","gabriela.calero@seit.com","Biología")
    ));

    /**
     * EndPoint que permite consultar todos los alumnos de la lista
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getStudents() {
        return students;
    }

    /**
     * EndPoint que permite buscar por email a un alumno
     * @param email
     * @return
     */
    @RequestMapping(value = "{email}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable String email){

        Student response=null;
        for (Student s: students){
            if (s.getEmail().equals(email)){
                response= s;
            }
        }
        return response;
    }

    /**
     * endPoint que permite adicionar un estudiante
     * @param student
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Student postStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }

    /**
     * Metodo que permite modificar estudiante por PUT
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Student putStudent(@RequestBody Student student){
        Student response=null;
        for (Student s : students){
            if (s.getID()== student.getID()){
                s.setName(student.getName());
                s.setEmail(student.getEmail());
                s.setCourse(student.getCourse());
                response= s;
            }
        }
        return response;
    }
    /**
     * Metodo que permite modificar estudiante por PATCH
     * @return
     */

    @RequestMapping(method = RequestMethod.PATCH)
    public Student patchStudent(@RequestBody Student student){
        Student response=null;
        for (Student s : students){
            if (s.getID()== student.getID()){
                if (student.getName()!=null){
                    s.setName(student.getName());
                }
                if (student.getEmail()!= null){
                    s.setEmail(student.getEmail());
                }
                if (student.getCourse()!=null){
                    s.setCourse(student.getCourse());
                }
                response= s;
            }
        }
        return response;
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Student deleteStudent(@PathVariable int id){

        Student response=null;
        for (Student s: students){
            if (s.getID()==id){
                students.remove(s);
                response= s;
            }
        }
        return response;
    }
}
