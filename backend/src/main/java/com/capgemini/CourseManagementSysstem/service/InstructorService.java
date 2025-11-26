package com.capgemini.CourseManagementSysstem.service;

import com.capgemini.CourseManagementSysstem.entity.Instructor;
import com.capgemini.CourseManagementSysstem.exception.ResourceNotFoundException;
import com.capgemini.CourseManagementSysstem.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {
    private final InstructorRepository instructorRepository;

    public Instructor addInstructor(Instructor ins){
        return  instructorRepository.save(ins);
    }

    public Instructor updateInstructor(Long id,Instructor ins){
        Instructor ins1 = instructorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Instructor can not be found : "+ins));

        ins1.setName(ins.getName());
        ins1.setEmail(ins.getEmail());

        return instructorRepository.save(ins1);
    }

    public ResponseEntity<String> deleteInstructor(Long id){
        Instructor Instructor1 = instructorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Instructor can not be found : "+id));
        instructorRepository.deleteById(id);

        return ResponseEntity.ok("Instructor removed with Id: " + id);
    }

    public Instructor getInstructorById(Long id){
        Instructor ins1 = instructorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Instructor can not be found : "+id));
        return ins1;
    }

    public List<Instructor> getAllInstructor(){
        return instructorRepository.findAll();
    }
}
