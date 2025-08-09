package com.example.First;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {

		// TODO Auto-generated method stub
@RequestMapping("/")
	public String index (Model model)
	{
	model.addAttribute("name", "shreeram");
	 return "index";
	}
}
