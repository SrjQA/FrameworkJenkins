package scts.FrameworkOrangeHRM;

import java.io.IOException;
import org.testng.annotations.Test;

import scts.PageObjects.Leave;
import scts.PageObjects.Module;
import scts.PageObjects.PIM;
import scts.testComponents.BaseTest;

public class E2EFrameworkTest extends BaseTest {

	@Test
	public void e2eTest() throws IOException {
		// ADMIN Login-beforemethod in base test
		landingPage.loginApplication("Admin", "admin123");
		Module module = new Module(driver);
		// 1.Add New Employee
		module.goToPIM();
		PIM pim = new PIM(driver);
		pim.addEmployee();
		// 2.Search Employee
		// Steps: PIM > Employee List → Enter a valid Employee ID → Click Search.
		// Expected Result: Matching employee record is shown.
		module.goToPIM();
		pim.searchEmployee();
		// 3.Update Employee Job Details
		// Steps: PIM > Employee List → Select employee → Job tab → Edit job
		// title/department → Save.
		// Expected Result: Job details are updated successfully.
		pim.updateJob();

		// LEAVE MODULE
		module.goToLeave();
		Leave leave = new Leave(driver);
		// Apply for Leave
		// Steps: Leave > Apply → Select leave type, date, reason → Click Apply.
		// Expected Result: Leave application is submitted and visible in My Leave.
		leave.assignLeave();
		leave.search();
		leave.selectResultEmployee();
		// Select leave type
		leave.selectDropdown();
		leave.selectLeaveType();
		// from date
		leave.selectFromdate();
		// to date-- Auto Selected
		// save
		leave.saveleave();
		module.goToDashboard();
		// Finally quit driver-Aftermethod

	}

	
}
