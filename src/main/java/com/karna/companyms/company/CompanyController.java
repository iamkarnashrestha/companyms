package com.karna.companyms.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> findAll() {
        return ResponseEntity.ok(companyService.findAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Company company) {
        boolean updated = companyService.updateCompany(id, company);
        if (updated)
            return new ResponseEntity<>("Company updated successfullt", HttpStatus.OK);
        return new ResponseEntity("Company not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByID(@PathVariable Long id) {
        if (companyService.deleteById(id))
            return ResponseEntity.ok("Company deleted successfully");
        else
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getById(@PathVariable Long id) {
        if (companyService.findCompanyByID(id) != null)
            return new ResponseEntity<>(companyService.findCompanyByID(id), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Review saved Successfully", HttpStatus.CREATED);
    }
}