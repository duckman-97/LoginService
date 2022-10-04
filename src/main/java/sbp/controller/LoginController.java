package sbp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sbp.model.LoginProcessor;

@Controller
public class LoginController {
	private final LoginProcessor loginProcessor;
	
	public LoginController(LoginProcessor loginProcessor) {
		this.loginProcessor = loginProcessor;
		
	}
	
	@GetMapping("/")
	public String loginGet() {
		return "login.html";
		
	}
	
	
	@PostMapping("/")
	public String loginPost(
		@RequestParam String username,
		@RequestParam String password,
		Model model
	)
	{
		loginProcessor.setUsername(username);
		loginProcessor.setPassword(password);
		boolean loggedin = loginProcessor.login();
		
		if(loggedin) {
			return "redirect:/main";
		}
		
		model.addAttribute("massage","Login faild")
;
		return "login.html";
		
	}
	
	

}
