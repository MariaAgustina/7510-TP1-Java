package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by mariagustina on 05/11/17.
 */
public class numbersTest {
    @InjectMocks
    private KnowledgeBase knowledgeBase;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        this.knowledgeBase.databaseFile = "src/main/resources/numbers.db";
    }

    @Test
    public void factsTests() {
        Assert.assertTrue(this.knowledgeBase.answer("add(one, one, two)."));
        Assert.assertFalse(this.knowledgeBase.answer("add(two, one, one)."));
    }

    @Test
    public void rulesTests() {
        Assert.assertFalse(this.knowledgeBase.answer("subtract(one, one, two)."));
        Assert.assertTrue(this.knowledgeBase.answer("subtract(two, one, one)."));

    }
}
