package servise;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StudentRepository;

import java.util.List;

@Service
public class StudentService   {
    private final StudentRepository studentRepository;

    @Autowired
   public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(String keyword) {
            return studentRepository.findAll();
    }

}
