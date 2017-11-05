package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by mariagustina on 05/11/17.
 */
public class IncompleteDatabaseTest {

    @InjectMocks
    private KnowledgeBase knowledgeBase;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        this.knowledgeBase.databaseFile = "src/main/resources/incompleteDatabase.db";
    }

    @Test
    public void factsTests() {
        Assert.assertFalse(this.knowledgeBase.answer("varon (juan)."));
    }

    @Test
    public void rulesTests() {
        Assert.assertFalse(this.knowledgeBase.answer("hijo(ricardo,roberto)."));

    }


}
