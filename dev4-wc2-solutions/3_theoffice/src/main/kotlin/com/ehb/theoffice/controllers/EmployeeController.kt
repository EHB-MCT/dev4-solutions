package com.ehb.theoffice.controllers

import com.ehb.theoffice.models.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("employee")
class EmployeeController {

    @PostMapping("hire")
    fun hireEmployee(@RequestBody emp: Employee): String{
        if(Office.hireEmployee(emp)){
            return "The following person has been hired: $emp"
        }else{
            return "This person could not be hired: $emp"
        }
    }

    @GetMapping("fire/{id}")
    fun fireEmployee(@PathVariable id: Int): String{
        if(Office.fireEmployee(id)){
            return "The person with id $id has been fired!"
        }else{
            return "The person with id $id has NOT been fired!"
        }

    }

    @GetMapping("all")
    fun allEmployees(): MutableSet<Employee> {
        return Office.getAllEmployees();
    }

    @GetMapping("promote/{promoter}/{employee}")
    fun promote(@PathVariable promoter: Int, @PathVariable employee: Int, ): String{
        if(Office.getAllEmployees().isEmpty()){
            seeding()
        }
        val e = Office.getAllEmployees().filter { it.id == promoter }[0];
        return e.promote(employee);
    }

    @GetMapping("seeding")
    fun seeding(): String{
        //hire a couple of employees
        Office.hireEmployee(Employee(1, "Michael Scott", "ms@dundlermifflin.com", Position.LEAD));
        Office.hireEmployee(Employee(2, "Dwight Schrute", "ds@dundlermifflin.com", Position.SECOND));
        Office.hireEmployee(Employee(3, "Jim Halpert", "jh@dundlermifflin.com", Position.SALES));
        Office.hireEmployee(Employee(4, "Pamela Beesly", "pb@dundlermifflin.com", Position.REC));
        Office.hireEmployee(Employee(5, "Kevin Malone", "km@dundlermifflin.com", Position.ACC));

        return "Employees created!"

    }

}