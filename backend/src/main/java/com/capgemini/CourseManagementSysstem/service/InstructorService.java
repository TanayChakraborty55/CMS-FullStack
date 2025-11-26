package com.capgemini.CourseManagementSysstem.service;

import com.capgemini.CourseManagementSysstem.dto.InstructorDto;
import com.capgemini.CourseManagementSysstem.entity.Instructor;
import com.capgemini.CourseManagementSysstem.exception.ResourceNotFoundException;
import com.capgemini.CourseManagementSysstem.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {
    private final InstructorRepository instructorRepository;
    private final ModelMapper modelMapper;

    public InstructorDto addInstructor(InstructorDto ins){
        Instructor instructor = modelMapper.map(ins,Instructor.class);
        Instructor saved = instructorRepository.save(instructor);
        return modelMapper.map(saved,InstructorDto.class);
    }

    public InstructorDto updateInstructor(Long id,InstructorDto ins){

        Instructor instructor  = instructorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Instructor can not be found : "+ins));
        modelMapper.map(ins,instructor);
        Instructor updated  = instructorRepository.save(instructor);
        return modelMapper.map(updated,InstructorDto.class);
    }

    public ResponseEntity<String> deleteInstructor(Long id){
        Instructor Instructor1 = instructorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Instructor can not be found : "+id));
        instructorRepository.deleteById(id);

        return ResponseEntity.ok("Instructor removed with Id: " + id);
    }

    public InstructorDto getInstructorById(Long id){
        Instructor ins1 = instructorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Instructor can not be found : "+id));

        return modelMapper.map(ins1,InstructorDto.class);
    }

    public List<Instructor> getAllInstructor(){
        return instructorRepository.findAll();
    }
}
