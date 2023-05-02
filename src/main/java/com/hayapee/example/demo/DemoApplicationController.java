package com.hayapee.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DemoApplicationController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("function", "textToImage");
        return "dashboard";
    }

    @PostMapping("/dashboard")
    public String dashboard(@RequestParam String function,
            @RequestParam(required = false) String textbox,
            @RequestParam(required = false) MultipartFile imageFile,
            Model model) {

        if (function.equals("textToImage")) {
            // Text to Image
            // Generate image from text and set image source in the model
            // ...
            // In this example, we simply return the input text as it is
            model.addAttribute("generatedText", textbox);
        } else if (function.equals("imageToText")) {
            // Image to Text
            // Generate text from image and set it in the model
            // ...
            // In this example, we simply return the uploaded file name
            if (imageFile != null) {
                model.addAttribute("generatedText", "Uploaded file: " + imageFile.getOriginalFilename());
            } else {
                model.addAttribute("generatedText", "");
            }
        }

        model.addAttribute("function", function);
        return "dashboard";
    }
}
