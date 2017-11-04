package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.MockitoAnnotations.initMocks;

public class KnowledgeBaseTest {

	@InjectMocks
	private KnowledgeBase knowledgeBase;

	@Before
	public void setUp() throws Exception {
		initMocks(this);
	}

	@Test
	public void factsTests() {
		Assert.assertTrue(this.knowledgeBase.answer("varon (juan)."));
		Assert.assertTrue(this.knowledgeBase.answer("varon(juan)."));
		Assert.assertTrue(this.knowledgeBase.answer("varon( nicolas ) ."));
		Assert.assertTrue(this.knowledgeBase.answer("padre(roberto, alejandro)."));
		Assert.assertFalse(this.knowledgeBase.answer("padre(ricardo, alejandro)."));
	}

	@Test
	public void rulesTests() {
		Assert.assertFalse(this.knowledgeBase.answer("hijo(ricardo,roberto)."));
		Assert.assertTrue(this.knowledgeBase.answer("hija(cecilia,roberto)."));
		Assert.assertTrue(this.knowledgeBase.answer("tio(nicolas, alejandro, roberto)."));
		Assert.assertFalse(this.knowledgeBase.answer("tio(alejandro, nicolas, roberto)."));

	}

}
