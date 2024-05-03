package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    @Test
    public void testGetTypeSauce() {
        Ingredient ingredient = new Ingredient(SAUCE,"hot sauce",100);

        Assert.assertEquals(SAUCE,ingredient.getType());
    }

    @Test
    public void testGetTypeFilling() {
        Ingredient ingredient = new Ingredient(FILLING,"cutlet",100);

        Assert.assertEquals(FILLING,ingredient.getType());
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(FILLING,"cutlet",100);

        Assert.assertEquals(100, ingredient.getPrice(),0);
    }


    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(FILLING,"dinosaur",200);

        Assert.assertEquals("dinosaur",ingredient.getName());
    }
}
