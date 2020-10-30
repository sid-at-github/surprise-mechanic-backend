package org.glovo;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Mapper {

    private static final String BASE_IMAGE_URL = "http://localhost:8080/surprise-mechanic/products/image/";

    public static List<ProductVM> map(AnalyticsDTO analyticsDTO) {
        List<ProductVM> productVMList = new ArrayList<>();
        List<String> names = analyticsDTO.getName().values().stream().collect(Collectors.toList());
        List<String> descriptions = analyticsDTO.getDescription().values().stream().collect(Collectors.toList());
        List<Double> prices = analyticsDTO.getPrice().values().stream().collect(Collectors.toList());
        List<String> categories = analyticsDTO.getCategory().values().stream().collect(Collectors.toList());
        List<String> storeNames = analyticsDTO.getStore_name().values().stream().collect(Collectors.toList());
        for (int i = 0; i < analyticsDTO.getName().values().size(); i++) {
            ProductVM productVM = new ProductVM(
                    storeNames.get(i),
                    names.get(i),
                    descriptions.get(i),
                    DecimalFormat.getCurrencyInstance(Locale.GERMANY).format(prices.get(i)),
                    BASE_IMAGE_URL + categories.get(i) + ".png"
            );
            productVMList.add(productVM);
        }
        return productVMList;
    }
}
