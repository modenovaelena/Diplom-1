package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.MockitoAnnotations.initMocks;
import static praktikum.IngredientType.SAUCE;
import static praktikum.IngredientType.FILLING;

@RunWith(Parameterized.class)
public class BurgerTest {

    @Mock
    Bun bun;


    @Parameterized.Parameters
    public static Object[][] getTestData() {

        List<Ingredient> ingredientsPack1 = new ArrayList();
        ingredientsPack1.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingredientsPack1.add(new Ingredient(IngredientType.FILLING, "cutlet", 200));
        ingredientsPack1.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));

        List<Ingredient> ingredientsPack2 = new ArrayList();
        ingredientsPack2.add(new Ingredient(IngredientType.SAUCE, "sour cream", 100));
        ingredientsPack2.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));


        return new Object[][] {
                {ingredientsPack1, 600, String.format(
                        "(==== null ====)%n= sauce hot sauce =%n= filling cutlet =%n= sauce chili sauce =%n(==== null ====)%n%n" +
                                "Price: 600,000000%n") },
                {ingredientsPack2, 300, String.format(
                        "(==== null ====)%n= sauce sour cream =%n= filling dinosaur =%n(==== null ====)%n%n" +
                                "Price: 300,000000%n")}

        };
    }

    private List<Ingredient> ingredientsPack;
    private float price;
    private String receipt;
    public BurgerTest(List<Ingredient> ingredientsPack, float price, String receipt) {
        this.ingredientsPack=ingredientsPack;
        this.price=price;
        this.receipt=receipt;
    }


    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testSetBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertTrue(bun.equals(burger.bun));
    }

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();

        for (Ingredient ingredient : this.ingredientsPack) {
            burger.addIngredient(ingredient);
        }

        Assert.assertEquals(this.ingredientsPack.size(), burger.ingredients.size());
        Assert.assertEquals(this.ingredientsPack.get(0), burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();

        for (Ingredient ingredient : this.ingredientsPack) {
            burger.addIngredient(ingredient);
        }

        burger.removeIngredient(0);

        Assert.assertEquals(this.ingredientsPack.size() - 1, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();

        for (Ingredient ingredient : this.ingredientsPack) {
            burger.addIngredient(ingredient);
        }

        burger.moveIngredient(1,0);
        Assert.assertEquals(this.ingredientsPack.size(), burger.ingredients.size());
        Assert.assertEquals(this.ingredientsPack.get(1), burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();

        for (Ingredient ingredient : this.ingredientsPack) {
            burger.addIngredient(ingredient);
        }

        burger.setBuns(bun);

        Assert.assertEquals(this.price,burger.getPrice(),0);

        Mockito.verify(bun, Mockito.times(1)).getPrice();
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();

        for (Ingredient ingredient : this.ingredientsPack) {
            burger.addIngredient(ingredient);
        }

        burger.setBuns(bun);

        Assert.assertEquals(this.receipt, burger.getReceipt());

        Mockito.verify(bun, Mockito.times(1)).getPrice();
        Mockito.verify(bun, Mockito.times(2)).getName();
    }

}






