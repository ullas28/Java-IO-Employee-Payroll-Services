package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class EmployeePayrollServiceTest {
    @Test
    public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries() {
        EmployeePayrollData[] arrayOfEmps= {
                new EmployeePayrollData(1,"Equila Joe", 80000),
                new EmployeePayrollData(2,"Dee Holy", 70000),
                new EmployeePayrollData(3,"Fredich Karl", 90000)
        };
        EmployeePayrollService employeePayrollService;
        employeePayrollService=new EmployeePayrollService();
        employeePayrollService.writeEmployeePayrollData();
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        }
}