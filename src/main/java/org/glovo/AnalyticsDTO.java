package org.glovo;

import java.util.Map;

public class AnalyticsDTO {
    private Map<String, Double> hod;
    private Map<String, String> category;
    private Map<String, String> name;
    private Map<String, String> description;
    private Map<String, String> store_name;
    private Map<String, Double> price;

    public Map<String, Double> getHod() {
        return hod;
    }

    public void setHod(Map<String, Double> hod) {
        this.hod = hod;
    }

    public Map<String, String> getStore_name() {
        return store_name;
    }

    public void setStore_name(Map<String, String> store_name) {
        this.store_name = store_name;
    }

    public Map<String, String> getName() {
        return name;
    }

    public void setName(Map<String, String> name) {
        this.name = name;
    }

    public Map<String, String> getDescription() {
        return description;
    }

    public void setDescription(Map<String, String> description) {
        this.description = description;
    }

    public Map<String, Double> getPrice() {
        return price;
    }

    public void setPrice(Map<String, Double> price) {
        this.price = price;
    }

    public Map<String, String> getCategory() {
        return category;
    }

    public void setCategory(Map<String, String> category) {
        this.category = category;
    }
}
