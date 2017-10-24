package net.shop;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static net.shop.CoffeeType.EXPRESSO;
import static net.shop.CoffeeType.LATTE;

public class SupplyService {

    private static final Map<CoffeeType, Long> stock = new HashMap<>();
    Logger LOGGER = Logger.getLogger(SupplyService.class.getName());

    public SupplyService() {
        stock.put(EXPRESSO, 0l);
        stock.put(LATTE, 0l);

    }

    public void addStock(CoffeeType coffeeType, Long shotsCount) {

        Long count = stock.get(coffeeType);
        if (count != null && shotsCount > 0) {
            count = count + shotsCount;
            stock.put(coffeeType, count);
        } else {
            LOGGER.severe("Cannot add .");
        }
    }

    public void useCoffeeShot(CoffeeType coffeeType) {
        Long count = stock.get(coffeeType);
        if (count != null) {
            stock.put(coffeeType, --count);
        }

    }

    public Long getCoffeeShotCount(CoffeeType coffeeType) {
        return stock.get(coffeeType);
    }

    public Boolean isCoffeeShotAvailable(CoffeeType coffeeType) {
        return stock.get(coffeeType) > 0;
    }
}
