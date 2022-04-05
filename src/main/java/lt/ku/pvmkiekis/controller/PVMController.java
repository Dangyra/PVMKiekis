package lt.ku.pvmkiekis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PVMController {
	
	@GetMapping("/")
	public String forma(){
		return "forma";
	}

	@PostMapping("/")
	public String pvm(
			@RequestParam("kaina") double kaina, 
			@RequestParam("kiekis") Integer kiekis,
			Model model) {
			
		double kainaBePVM = kaina - (kaina*21/121);
		kainaBePVM=Math.round(kainaBePVM*100)/100.0;
		double pvm = kaina*21/121;
		pvm=Math.round(pvm*100)/100.0;
		double bendraKaina = kainaBePVM * kiekis;
		bendraKaina=Math.round(bendraKaina*100)/100.0;
		double bendrasPVM = kiekis*pvm;
		bendrasPVM=Math.round(bendrasPVM*100)/100.0;
		double suma = kaina * kiekis;
		suma=Math.round(suma*100)/100.0;
		
		model.addAttribute("kaina", kaina);
		model.addAttribute("kiekis", kiekis);
		model.addAttribute("kainaBePVM", kainaBePVM);
		model.addAttribute("pvm", pvm);
		model.addAttribute("bendraKaina", bendraKaina);
		model.addAttribute("bendrasPVM", bendrasPVM);
		model.addAttribute("suma", suma);
		return "rezultatas";
	}

}