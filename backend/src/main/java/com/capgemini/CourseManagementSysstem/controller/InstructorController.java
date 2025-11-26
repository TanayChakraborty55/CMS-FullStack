package com.capgemini.CourseManagementSysstem.controller;

import com.capgemini.CourseManagementSysstem.dto.InstructorDto;
import com.capgemini.CourseManagementSysstem.entity.Instructor;
import com.capgemini.CourseManagementSysstem.service.InstructorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/instructor")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @PostMapping(path = "/add")
    public ResponseEntity<InstructorDto> addInstructor(@RequestBody @Valid InstructorDto Instructor){
        return ResponseEntity.ok(instructorService.addInstructor(Instructor));
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<InstructorDto> updateInstructor(@PathVariable Long id , @RequestBody @Valid InstructorDto Instructor){
        return ResponseEntity.ok(instructorService.updateInstructor(id,Instructor));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInstructor(@PathVariable Long id){
        return instructorService.deleteInstructor(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Instructor>> getAllInstructor(){
        List<Instructor> list = instructorService.getAllInstructor();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<InstructorDto> getInstructorById(@PathVariable Long id){

        return ResponseEntity.ok(instructorService.getInstructorById(id));
    }
}
