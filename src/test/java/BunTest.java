import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private String name;
    private float price;


    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Соус фирменный Space Sauce", 300.0F}, // позитивный тест
                {"", 300}, // отсутствует название
                {null, 300}, // в названии null
                {"Соус фирменный Space Sauce Соус фирменный Space Sauce Соус фирменный Space Sauce " +
                        "Соус фирменный Space Sauce Соус фирменный Space Sauce", 300}, // длинная строка в названии
                {"Соус фирменный $pace $auce", 300}, // спецсимволы в названии
                {"Соус фирменный Space Sauce", -300}, // отрицательная цена
                {"Соус фирменный Space Sauce", 0}, // цена равна нулю
                {"Соус фирменный Space Sauce", 0.10F}, // маленькая цена
                {"Соус фирменный Space Sauce", 1000000000000.0F}, // большая цена
        };
    }

    @Test
    public void checkBunTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}