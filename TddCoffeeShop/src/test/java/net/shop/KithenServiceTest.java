package net.shop;


import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.inject.Inject;

import static net.shop.CoffeeType.EXPRESSO;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(MockitoJUnitRunner.class)
public class KithenServiceTest {

    @Mock
    private SupplyService supplyService;

    @InjectMocks
    private  KitchenService kitchenService;

    @Test
    public void shouldMakeCoffeeWhenShotsAreAvailable(){
        //Given Coffee beans are available
        given(supplyService.isCoffeeShotAvailable(EXPRESSO)).willReturn(true);
        //When coffee is order
        Boolean orderStatus=kitchenService.makeCoffee(EXPRESSO);
        //Then Kitchen should make coffee
        assertThat(orderStatus, is(true));
        verify(supplyService,times(1)).isCoffeeShotAvailable(EXPRESSO);

    }

    @Test
    public void shouldMakeCoffeeWhenShotsAreNotAvailable(){
        //Given Coffee beans are available
        given(supplyService.isCoffeeShotAvailable(EXPRESSO)).willReturn(false);
        //When coffee is order
        Boolean orderStatus=kitchenService.makeCoffee(EXPRESSO);
        //Then Kitchen should make coffee
        assertThat(orderStatus, is(false));

    }
}
