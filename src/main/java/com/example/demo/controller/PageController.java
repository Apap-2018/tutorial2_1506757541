package com.example.demo.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
		
	@RequestMapping(value = {"/challenge", "/challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}

	@RequestMapping("/generator")
	public String generatorParam(@RequestParam(value = "a", required = false, defaultValue = "0")int a, @RequestParam(value = "b", required = false, defaultValue = "0") int b, @RequestParam(value = "hm", required = false, defaultValue = "hm") String result, Model model) {
		String str = result.substring(1,2);
		String hasil = "";
		String add = "";
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		for(int i = 0; i < a; i++) {
				hasil = hasil + str;
		}
		String res = "h" + hasil;
		
		for(int j = 0; j < b; j++) {
			add = res + " " + add;
		}
		if((a == 0 || a == 1) && (b == 0 || b == 1)) {
			model.addAttribute("result", "hm");
		}
		else {
			model.addAttribute("result", add);
		}
		return "generator";
	}
	
}
