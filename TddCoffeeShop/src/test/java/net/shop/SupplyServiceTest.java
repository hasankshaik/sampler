package net.shop;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static net.shop.CoffeeType.EXPRESSO;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class SupplyServiceTest {

    @Spy
    private SupplyService supplyService;

    // Add coffe stocks
    @Test
    public void shouldAddCoffeeStocksTest(){
        Long count=supplyService.getCoffeeShotCount(EXPRESSO);
        supplyService.addStock(EXPRESSO,20l);
        Long updateCount=supplyService.getCoffeeShotCount(EXPRESSO);
        assertThat(updateCount, is(count+20));
    }

    @Test
    public void shoulNotdAddCoffeeStocksWhenshotCountIsNotPositiveTest(){
        Long count=supplyService.getCoffeeShotCount(EXPRESSO);
        supplyService.addStock(EXPRESSO,-20l);
        Long updateCount=supplyService.getCoffeeShotCount(EXPRESSO);
        assertThat(updateCount,is(count));
    }

    @Test
    public void shouldReduceCountOnUseOfCoffeeShots(){
        Long count=supplyService.getCoffeeShotCount(EXPRESSO);
        supplyService.useCoffeeShot(EXPRESSO);
        Long updateCount=supplyService.getCoffeeShotCount(EXPRESSO);
        assertThat(updateCount,is(count-1));
    }
    @Test
    public void shouldReturnTrueIfcountOfCoffeeShotIsGreaterThatZero(){
        Boolean coffeeShotAvailable=supplyService.isCoffeeShotAvailable(EXPRESSO);
        supplyService.addStock(EXPRESSO,20l);
        assertThat(supplyService.isCoffeeShotAvailable(EXPRESSO),is(true));
    }

}
