package com.ehb.theoffice.models

object Office {
    //list of employee
    private var employees: MutableSet<Employee> = mutableSetOf();

    //hire function
    fun hireEmployee(emp: Employee): Boolean {
        return employees.add(emp);
    }
    //fire function

    fun fireEmployee(id: Int): Boolean {
        return employees.removeIf {it.id == id};
    }
    //get all function
    fun getAllEmployees(): MutableSet<Employee>{
        return this.employees
    }
    //Update the employee
    fun updateEmployee(employee: Employee) {
        employees.removeIf {it.id == employee.id}
        employees.add(employee)
    }
}