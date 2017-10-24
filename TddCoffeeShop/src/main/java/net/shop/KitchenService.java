package net.shop;

public class KitchenService {

    private SupplyService supplyService;

    public Boolean makeCoffee(CoffeeType coffeeShot) {
        if (supplyService.isCoffeeShotAvailable(coffeeShot)) {
            supplyService.useCoffeeShot(coffeeShot);
            return true;
        }

        return false;
    }

}
