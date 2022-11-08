package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class EmployeePayrollServiceTest {
    @Test
    public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries() {
        EmployeePayrollData[] arrayOfEmps= {
                new EmployeePayrollData(1,"Equila", 80000),
                new EmployeePayrollData(2,"Dia", 70000),
                new EmployeePayrollData(3,"Fredich ", 90000)
        };
        EmployeePayrollService employeePayrollService;
        employeePayrollService=new EmployeePayrollService();
        employeePayrollService.writeEmployeePayrollData();
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.fileReader();
        }
}