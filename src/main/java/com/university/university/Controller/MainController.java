package com.university.university.Controller;

import com.university.university.model.SemesterCycleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/main")
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    public int getRemainingWeek(ModelMap model){
        model.addAttribute("remainingWeek",SemesterCycleService.remainingWeek());
        return SemesterCycleService.remainingWeek();
    }
}
