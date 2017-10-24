package net.shop;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static net.shop.CoffeeType.EXPRESSO;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    private SupplyService supplyService;

    @InjectMocks
    private  OrderService orderService;

    @Test
    public void shouldOrderCoffeeWhenShotsAreAvailable(){
        //Given Coffee beans are available
        given(supplyService.isCoffeeShotAvailable(EXPRESSO)).willReturn(true);
        //When coffee is order
        Boolean orderStatus= orderService.orderCoffee(EXPRESSO);
        //Then Kitchen should make coffee
        Assert.assertThat(orderStatus, is(true));

    }

    @Test
    public void shouldOderCoffeeWhenShotsAreNotAvailable(){
        //Given Coffee beans are available
        given(supplyService.isCoffeeShotAvailable(EXPRESSO)).willReturn(false);
        //When coffee is order
        Boolean orderStatus= orderService.orderCoffee(EXPRESSO);
        //Then Kitchen should make coffee
        Assert.assertThat(orderStatus, is(false));

    }
}
