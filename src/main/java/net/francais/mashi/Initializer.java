package net.francais.mashi;

import javax.annotation.PostConstruct;

import net.francais.mashi.dic.entity.Domaine;
import net.francais.mashi.dic.entity.Example;
import net.francais.mashi.dic.entity.LangueOrigine;
import net.francais.mashi.dic.entity.MotFrancais;
import net.francais.mashi.dic.entity.MotMashi;
import net.francais.mashi.dic.entity.Nature;
import net.francais.mashi.dic.entity.Role;
import net.francais.mashi.dic.entity.User;
import net.francais.mashi.dic.service.ClassificationService;
import net.francais.mashi.dic.service.DomaineService;
import net.francais.mashi.dic.service.ExampleService;
import net.francais.mashi.dic.service.LangueOrigineService;
import net.francais.mashi.dic.service.MotFrancaisService;
import net.francais.mashi.dic.service.MotMashiService;
import net.francais.mashi.dic.service.NatureService;
import net.francais.mashi.dic.service.RoleService;
import net.francais.mashi.dic.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class Initializer {
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	@Autowired
	private NatureService natureService;
	@Autowired
	private MotFrancaisService motFrancaisService;
	@Autowired
	private MotMashiService motMashiService;
	@Autowired
	private LangueOrigineService langueOrigineService;
	@Autowired
	private ExampleService exampleService;
	@Autowired
	private DomaineService domaineService;
	@Autowired
	private ClassificationService classificationService;
	
	
	@PostConstruct
	public void init(){
		System.out.println("=====================Adding data======================");
		createRole();
		createUser();
		createDomaine();
		createNature();
		createLangueOrigine();
		System.out.println("=====================Finish adding data================");
	}
	

	private void createLangueOrigine(){
		newLangueOrigine("ANGLAIS","EN");
		newLangueOrigine("ARABE","AR");
		newLangueOrigine("FRANCAIS","FR");
		newLangueOrigine("GREC","GC");
		newLangueOrigine("HEBREU","HB");
		newLangueOrigine("KINYARWANDA","RW");
		newLangueOrigine("KIREGA","RG");
		newLangueOrigine("KIRUNDI","RW");
		newLangueOrigine("LATIN","LT");
		newLangueOrigine("SWAHILI","SW");
	}
	private void createNature(){
		newNature("Nom commun", "N");
		newNature("Verbe", "V");
		newNature("Adverbe", "ADV");
		newNature("Adjectif", "ADJ");
		newNature("Exclamation", "EXC");
		newNature("Nom propre", "NP");
		newNature("Pronom", "PR");
	}
	
	private void createDomaine(){
		newDomaine("ADJECTIF");
		newDomaine("ADVERBE");
		newDomaine("AGRICULTURE");
		newDomaine("ANATOMIE");
		newDomaine("BOTANIQUE");
		newDomaine("GRAMMAIRE");
		newDomaine("CONSTRUCTION");
		newDomaine("CUISINE");
		newDomaine("TRANSPORT");
		newDomaine("COMMERCE");
		newDomaine("EDUCATION");
		newDomaine("ELEVAGE");
		newDomaine("EXCLAMATION");
		newDomaine("FAMILLE");
		newDomaine("FORET");
		newDomaine("GEOGRAPHIE");
		newDomaine("ESPACE");
		newDomaine("HABILLEMENT");
		newDomaine("HABITATION");
		newDomaine("VACHE");
		newDomaine("JUSTICE");
		newDomaine("PHILOSOPHIE");
		newDomaine("MEDECINE");
		newDomaine("MILITAIRE");
		newDomaine("MUSIQUE");
	}
	
	private void createUser(){
		 newUser("admin", "admin@gmail.com", "admin", roleService.findByName("ROLE_ADMIN"));
		 newUser("user", "user@gmail.com", "user", roleService.findByName("ROLE_USER"));
	}
	
	private void createRole(){
		 newRole("ROLE_ADMIN");
		 newRole("ROLE_USER");
	}
	
	
	private Example newExample(MotMashi motMashi, String txtFrancais, String txtMashi){
		Example example = new Example();
		example.setMotMashi(motMashi);
		example.setTxtFrancais(txtFrancais);
		example.setTxtMashi(txtMashi);
		example.setAddedBy(userService.findByEmail("admin@gmail.com"));
		return exampleService.createOrUpdate(example);
		
	}
	
	private void newMotMashi(String mot, String precision,String origine, String pluriel, LangueOrigine langueOrigine, MotFrancais motFrancais){
		MotMashi motMashi = new MotMashi();
		motMashi.setLangueOrigine(langueOrigine);
		motMashi.setMot(mot);
		motMashi.setOrigine(origine);
		motMashi.setPluriel(pluriel);
		motMashi.setMotFrancais(motFrancais);
		motMashi.setAddedBy(userService.findByEmail("admin@gmail.com"));
		motMashiService.createOrUpdate(motMashi);
		motFrancais.setMotMashi(motMashi);
		motFrancaisService.createOrUpdate(motFrancais);
	}
	
	
	private void newMotFrancais(String mot, String precision, Domaine domaine, Nature nature){
		MotFrancais motFrancais = new MotFrancais();
		motFrancais.setDomaine(domaine);
		motFrancais.setNature(nature);
		motFrancais.setMot(mot);
		motFrancais.setPrecision(precision);
		motFrancais = motFrancaisService.createOrUpdate(motFrancais);
		domaine.addMotFrancais(motFrancais);
		nature.addMotFrancais(motFrancais);
		nature.setAddedBy(userService.findByEmail("admin@gmail.com"));
		natureService.createOrUpdate(nature);
		domaineService.createOrUpdate(domaine);
	}
	
	private LangueOrigine newLangueOrigine(String name, String abbreviation){
		LangueOrigine lOrigine = new LangueOrigine();
		lOrigine.setName(name);
		lOrigine.setAbbreviation(abbreviation);
		lOrigine.setAddedBy(userService.findByEmail("admin@gmail.com"));
		return langueOrigineService.createOrUpdate(lOrigine);
	}
    private void newDomaine(String name){
    	Domaine domaine = new Domaine();
    	domaine.setName(name);
    	domaine.setAbbreviation(name);
    	domaine.setAddedBy(userService.findByEmail("admin@gmail.com"));
        domaineService.createOrUpdate(domaine);
    }
    
    private void newNature(String name, String abbreviation){
    	Nature nature = new Nature();
    	nature.setName(name);
    	nature.setAbbreviation(abbreviation);
    	nature.setAddedBy(userService.findByEmail("admin@gmail.com"));
    	natureService.createOrUpdate(nature);
    }
    
    private void newUser(String name, String email, String psswrd,  Role role){
        User user = new User();
        user.setName(name);
        user.setPassword(psswrd);
        user.setEmail(email);
        user.setActive(true);
        user.addRole(role);
        userService.createOrUpdate(user);
    }
    
    private void newRole(String name){
       Role role = new Role();
       role.setName(name);
       roleService.createOrUpdate(role); 
    }
}
