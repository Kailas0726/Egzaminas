package Egzaminas_uzduotis;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PagrindinisController {
	
	@Autowired
	private UserRepository user_repository;
	
	@Autowired
	private FilmuKategorijosRepository filmu_kategorijos_repository;
	
	@RequestMapping(path="/pagrindinis", method={ RequestMethod.GET, RequestMethod.POST })
    public String pagrindinis(Model model) {
		
			return "pagrindinis";
			
	}
	
	@RequestMapping(path="/prideti_filmu_kategorija", method={ RequestMethod.GET, RequestMethod.POST })
    public String prideti_filmu_kategorija(@RequestParam(name="id", required=false, defaultValue="0") Integer id
    		,@RequestParam(name="pavadinimas", required=false, defaultValue="0") String pavadinimas
    		,@RequestParam(name="prideti", required=false, defaultValue="0") String prideti
    		,Model model) {
		
			FilmuKategorijos filmu_kategorijos = new FilmuKategorijos();
			
			if ( prideti.equals( "prideti" ) ) {
			
				if (id > 0) {
					
					Optional <FilmuKategorijos> found = filmu_kategorijos_repository.findById( id );
					
					if ( found.isPresent() ) {
						
						filmu_kategorijos = found.get();
						filmu_kategorijos.setId(id);
						
					}
					
				}
			
			filmu_kategorijos.setPavadinimas(pavadinimas);
			
			filmu_kategorijos_repository.save ( filmu_kategorijos );
		
			}
		
		model.addAttribute("filmu_kategorijos", filmu_kategorijos_repository.findAll());
		
		return "prideti_filmu_kategorija";
			
	}
	
	@RequestMapping(path="/redagavimas")	
	public @ResponseBody FilmuKategorijos filmu_kategorijos(@RequestParam(name="id", required=true, defaultValue="0") Integer id ) throws IOException {

		FilmuKategorijos filmu_kategorijos = new FilmuKategorijos();
		
		if (id > 0) {
			
			Optional <FilmuKategorijos> found = filmu_kategorijos_repository.findById( id );
		
			if ( found.isPresent() ) {
			
				filmu_kategorijos = found.get();
				filmu_kategorijos.setId ( id );
			   
			} 
		}		
		
		return filmu_kategorijos;

	}
	
	@RequestMapping(path="/salinimas")
	public  String salintiZanra (@RequestParam(name="id_iraso", required=true, defaultValue="0") Integer id 
			, @RequestParam(name="salinti", required=false, defaultValue="0") String salinti
			) {
		
		FilmuKategorijos filmu_kategorijos = new FilmuKategorijos();
		
		if ( salinti.equals( "salinti" ) ) {
			//System.out.println(id);
			Optional <FilmuKategorijos> found = filmu_kategorijos_repository.findById( id );
			
				if ( found.isPresent() ) {
					
					   filmu_kategorijos = found.get();
					   filmu_kategorijos_repository.deleteById(id);

				}
			
		}
		return "redirect:prideti_filmu_kategorija";
	}
	
}
