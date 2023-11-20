package com.wipro.topgear.Hiber_Assign_2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.wipro.topgear.Hiber_Assign_2.entity.Employee;
import com.wipro.topgear.Hiber_Assign_2.service.HqlService;

public class App {

	public static void main(String[] args) throws ParseException {
		HqlService hqlService = new HqlService();
		Employee employee = new Employee(
				"SRIHRI", "SS", dateFormatter("13-01-2001"), dateFormatter("31-05-2022"), 21, 20000);
		Employee employee2 = new Employee(
				"SRIHRI", "SS", dateFormatter("13-01-2001"), dateFormatter("31-05-2022"), 21, 20000);

		hqlService.addEmp(employee);
		hqlService.addEmp(employee2);
		hqlService.deleteEmp(9);

	}

	public static Date dateFormatter(String string) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.parse(string);

	}
}
