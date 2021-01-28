package com.example.validatingforminput;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.validation.Valid;

/**
 * Created 8/3/2020 by Lucas Chapman
 * This class is used to validate data by creating PersonForm objects and displays valid data
 * For more information, visit https://spring.io/guides/gs/validating-form-input/
 */
@Controller
public class WebController implements WebMvcConfigurer {
    /**
     * Displays a confirmation message to the user when what was entered is valid
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    /*
     * GET and POST requests mapping (handling)
     * Note: ("/") is used to map the results to the URL
     */
    /**
     * Maps (handles) GET requests
     * @param model used to create a PersonForm object
     * @return used to stay on form.html
     */
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("personForm", new PersonForm()); // stores the data that was entered in an object
        return "form";
    }

    /**
     * Checks if the data entered is valid and determines if the results page should be displayed
     * @param personForm contains all the data that was entered with @Valid being to validate data
     * @param bindingResult used to keep track of errors
     * @return stays on the current page (form.html) or goes to the results.html page
     */
    @PostMapping("/")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
        // Checks if any errors are found to determine if the results.html should be displayed
        if (bindingResult.hasErrors()) {    // if errors are found, stay on the current page
            return "form";
        }
        return "redirect:/results";
    }
}