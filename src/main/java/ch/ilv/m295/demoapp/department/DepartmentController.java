package ch.ilv.m295.demoapp.department;

import ch.ilv.m295.demoapp.security.Roles;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class DepartmentController {

    private final DepartmentService departmentService;

    DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("api/department")
    @RolesAllowed(Roles.Read)
    public ResponseEntity<List<Department>> all() {
        List<Department> result = departmentService.getDepartments();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("api/department/{id}")
    public ResponseEntity<Department> one(@PathVariable Long id) {
        Department department = departmentService.getDepartment(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @PostMapping("api/department")
    public ResponseEntity<Department> newDepartment(@Valid @RequestBody Department department) {
        Department savedDepartment = departmentService.insertDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.OK);
    }

    @PutMapping("api/department/{id}")
    public ResponseEntity<Department> updateDepartment(@Valid @RequestBody Department department, @PathVariable Long id) {
        Department savedDepartment = departmentService.updateDepartment(department, id);
        return new ResponseEntity<>(savedDepartment, HttpStatus.OK);
    }

    @DeleteMapping("api/department/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }
}
