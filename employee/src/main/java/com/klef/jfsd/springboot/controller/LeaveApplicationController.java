package com.klef.jfsd.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import com.klef.jfsd.springboot.model.LeaveApplicationModel;
import com.klef.jfsd.springboot.service.LeaveApplicationService;

@Controller
@RequestMapping("/leave")
public class LeaveApplicationController {

    @Autowired
    private LeaveApplicationService leaveApplicationService;

    @GetMapping("/apply")
    public String applyLeaveForm() {
        return "applyLeaveForm"; // Assuming you have a JSP file for leave application form
    }

    @PostMapping("/submit")
    public ModelAndView submitLeaveApplication(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        // Retrieve form data
        String leaveReason = request.getParameter("leaveReason");
        String detailedExplanation = request.getParameter("detailedExplanation");
        String leaveType = request.getParameter("leaveType");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        // Create a LeaveApplication object
        LeaveApplicationModel leaveApplication = new LeaveApplicationModel();
        leaveApplication.setLeaveReason(leaveReason);
        leaveApplication.setDetailedExplanation(detailedExplanation);
        leaveApplication.setLeaveType(leaveType);
        leaveApplication.setStartDate(startDate);
        leaveApplication.setEndDate(endDate);

        // Call the service to process the leave application
        boolean isSuccess = leaveApplicationService.applyLeave(leaveApplication);

        if (isSuccess) {
            mv.setViewName("success"); // Redirect to a success page
        } else {
            mv.setViewName("error"); // Redirect to an error page
        }

        return mv;
    }

    @GetMapping("/view")
    public ModelAndView viewLeaveApplications(@RequestParam("userId") int userId) {
        ModelAndView mv = new ModelAndView();

        // Call the service to get leave applications for the specific user
        // List<LeaveApplication> leaveApplications = leaveApplicationService.getLeaveApplications(userId);
        // mv.addObject("leaveApplications", leaveApplications);

        mv.setViewName("viewLeaveApplications"); // Assuming you have a JSP file to display leave applications
        return mv;
    }
}
