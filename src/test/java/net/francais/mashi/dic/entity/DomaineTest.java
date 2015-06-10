package net.francais.mashi.dic.entity;

import static org.junit.Assert.assertEquals;
import net.francais.mashi.dic.JUnit4ClassRunner;
import net.francais.mashi.dic.entities.Domaine;
import net.francais.mashi.dic.entities.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(JUnit4ClassRunner.class)
public class DomaineTest{
	
	@Autowired
	//DomaineService domaineService;
	User u;
	Domaine d;
	
//	@Test
//	public void shouldAutoWire() {
//		assertNotNull(domaineService);
//	}
//	
	
	@Before
	public void setUp() throws Exception {
		u= new User();
		d = new Domaine();
		d.setName("Name");
		d.setAbbreviation("abbreviation");
		d.setAddedBy(u);
	}

	@Test
	public void testGetName() {
		assertEquals("Name", d.getName());
	}
	
	@Test
	public void testGetAbbreviation() {
		assertEquals("abbreviation", d.getAbbreviation());
	}
	
	@Test
	public void testGetUser() {
		assertEquals(u, d.getAddedBy());
	}
	
	@Test
	public void testGetUpdated(){
		assertEquals(null,d.getUpdated());
	}

}
