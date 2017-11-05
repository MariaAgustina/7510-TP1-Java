package ar.uba.fi.tdd.rulogic.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by mariagustina on 05/11/17.
 */
public class InvalidQueryTest {
    @InjectMocks
    private KnowledgeBase knowledgeBase;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        this.knowledgeBase.databaseFile = "src/main/resources/rules.db";
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException() {
        this.knowledgeBase.answer("varon (jua");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException2() {
        this.knowledgeBase.answer("f(x,y,z)");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException3() {
        this.knowledgeBase.answer("mujer(cecilia) ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException4() {
        this.knowledgeBase.answer("tia juan,pepa).");
    }


}
