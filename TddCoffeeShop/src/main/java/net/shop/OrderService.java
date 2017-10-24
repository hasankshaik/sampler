package net.shop;

import javax.inject.Inject;

public class OrderService {

    @Inject
    private SupplyService supplyService;

    public Boolean orderCoffee(CoffeeType coffeeType){
        if (supplyService.isCoffeeShotAvailable(coffeeType)) {
            supplyService.useCoffeeShot(coffeeType);
            return true;
        }

        return false;
    }
}
