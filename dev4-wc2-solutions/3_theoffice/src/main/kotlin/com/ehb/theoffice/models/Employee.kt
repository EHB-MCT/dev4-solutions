package com.ehb.theoffice.models

import com.ehb.theoffice.models.Position

class Employee(
    var id: Int,
    var fullName: String,
    var email: String,
    var position: Position) {

    override fun toString(): String {
        return "$id \r\n$fullName \r\n$email \r\n${position.role}\r\n";
    }


    fun promote(id: Int): String{
        if(position == Position.LEAD) {
            //Retrieve set of employees
            var empList = Office.getAllEmployees();
            // retrieve employee to promote
            val e = empList.filter {it.id == id}[0];
            // Check availability for promotion
            if(e.position != Position.SECOND && e.position != Position.LEAD){
                //Promote
                e.position = Position.values()[e.position.ordinal-1];
                //Update the employee in the list
                Office.updateEmployee(e);
                return "Employee with id $id has been promoted to ${e.position.role}"
            }else{
                return "Employee with id $id cannot be promoted or does not exist"
            }
        }else{
            return "The current Employee cannot promote others!"
        }

    }

}