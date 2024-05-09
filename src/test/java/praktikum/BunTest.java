package praktikum;

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import static org.hamcrest.CoreMatchers.*;


public class BunTest {


    @Test
    public void testGetName() {
        Bun bun = new Bun("black bun",100);

        Assert.assertEquals("black bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("white bun",200);

        Assert.assertEquals(200, bun.getPrice(),0);
    }


}
