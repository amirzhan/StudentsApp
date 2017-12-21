package kz.iitu.StudentsDataApp.controller;

import kz.iitu.StudentsDataApp.model.EducationHistory;
import kz.iitu.StudentsDataApp.model.Faculty;
import kz.iitu.StudentsDataApp.model.Specialty;
import kz.iitu.StudentsDataApp.model.User;
import kz.iitu.StudentsDataApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/","/welcome","/login"}, method = RequestMethod.GET)
    public String index(HttpServletRequest req, HttpServletResponse res, Model model){

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("userData");
        //ModelAndView view = new ModelAndView("login");

        String error = req.getParameter("error");
        if (error!=null) {
            model.addAttribute("error","Invalid username or password!");
            return "login";
        }

        if (user!= null && user.getUsername().equals("admin")) {
   //         view.setViewName("admin");
            List<User> userList = userService.getStudentsList();
            List <Specialty> specialties = userService.getSpecialties();
            List <Faculty> faculties = userService.getFaculties();
            List <EducationHistory> ehs = userService.getHistories();

            model.addAttribute("user", new User());
            model.addAttribute("users",userList);
            model.addAttribute("faculties",faculties);
            model.addAttribute("specialties",specialties);
            model.addAttribute("education_histories", ehs);
            return "admin";
        }
        else if (user != null) {
            //view.setViewName("welcome");
            List <EducationHistory> ehs = userService.getHistoriesByStudent(user);
            model.addAttribute("education_histories",ehs);
            return "welcome";
        }
        model.addAttribute("user",new User());

        return "login";
    }
    @RequestMapping(value="login", method= RequestMethod.POST)
    public String loginUser(HttpServletRequest req,
                            @ModelAttribute(value = "user")User user
    ) throws Exception {
        User nUser = userService.getUserByUsernameAndPassword(user.getUsername(),user.getPassword());
        if (nUser!=null) {
            System.out.println("logged in : " + nUser);
            HttpSession session = req.getSession();
            session.setAttribute("userData",nUser);
            return "redirect:/";
        }
        return "redirect:/?error=true";
    }
    @RequestMapping(value="adduser", method= RequestMethod.POST)
    public String addUser(HttpServletRequest req,
                        @ModelAttribute(value = "user")User user
    ) throws Exception {
        //user.setSpecialty(userService.getSpecialtyByName(user.getSpecialty().getName()));
        //System.out.println(specialty);
        userService.save(user);
        return "redirect:/";
    }


    @RequestMapping(value="update", method=RequestMethod.GET)
    public String updateUser(HttpServletRequest req, Model model) {
        String student_username = req.getParameter("student_username");
        HttpSession session = req.getSession();
        User currentUser = (User)session.getAttribute("userData");
        User updatingUser = userService.getUserByUsername(student_username);
        if (currentUser!=null) {

            List <Specialty> specialties = userService.getSpecialties();
            model.addAttribute("specialties",specialties);
            model.addAttribute("user",updatingUser);


            return "update";
        }
        return "redirect:/";
    }
    @RequestMapping(value="update", method = RequestMethod.POST)
    public String updateUser(HttpServletRequest req,
                           @ModelAttribute(value = "user")User updatingUser)
            throws Exception{
        HttpSession session = req.getSession();
        User currentUser = (User)session.getAttribute("userData");
        if (currentUser!=null) {
            if (!currentUser.getUsername().equals("admin"))
                session.setAttribute("userData",updatingUser);
            System.out.println("updating User " + updatingUser);
            System.out.println(updatingUser.getSpecialty().getId());
            userService.update(updatingUser);
        }
        return "redirect:/";
    }
    @RequestMapping(value="delete",method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest req) throws Exception {
        String student_username = req.getParameter("student_username");
        HttpSession session = req.getSession();
        User currentUser = (User)session.getAttribute("userData");
        if (currentUser!=null) {
            if (currentUser.getUsername().equals("admin")) {
                User deletingUser = userService.getUserByUsername(student_username);
                System.out.println(deletingUser);
                userService.delete(deletingUser);
            }
            else {
                session.removeAttribute("userData");
                userService.delete(currentUser);
            }
        }
        return "redirect:/";
    }
    @RequestMapping(value="logout",method=RequestMethod.GET)
    public String logout(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.getSession().removeAttribute("userData");
        return "redirect:/";
    }
    @RequestMapping(value="addeh",method = RequestMethod.POST)
    public String addEh(HttpServletRequest req,
                      @RequestParam(value="educated_place_name")String educated_place_name,
                      @RequestParam(value = "durating_time")String durating_time,
                      @RequestParam(value = "address")String address)
            throws Exception {
        User currentUser = (User)(req.getSession().getAttribute("userData"));
        if (currentUser!=null) {
            EducationHistory eh=null;
            if (currentUser.getUsername().equals("admin")) {
                String username = req.getParameter("username");
                User user = userService.getUserByUsername(username);
                eh = new EducationHistory(educated_place_name,durating_time,address,user);
            }
            else {
                eh = new EducationHistory(educated_place_name,durating_time,address,currentUser);
            }
            userService.save(eh);
        }
        return "redirect:/";
    }

    @RequestMapping(value="deleteEh", method = RequestMethod.GET)
    public String deleteEh(HttpServletRequest req) throws Exception{
        User currentUser = (User)req.getSession().getAttribute("userData");
        if (currentUser!=null) {
            try {
                Long id = Long.parseLong(req.getParameter("eh_id"));
                EducationHistory eh = userService.findEhById(id);
                userService.delete(eh);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/";
    }


}
