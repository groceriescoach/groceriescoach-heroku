package com.groceriescoach.core.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.groceriescoach.core.domain.GroceriesCoachSortType.Price;
import static com.groceriescoach.core.domain.GroceriesCoachSortType.UnitPrice;

public class GroceriesCoachSearchResults {

    private List<GroceriesCoachProduct> productsWithUnitPrices = new ArrayList<>();
    private List<GroceriesCoachProduct> productsWithoutUnitPrices = new ArrayList<>();
    private SearchCriteria searchCriteria;

    public GroceriesCoachSearchResults(Collection<GroceriesCoachProduct> products, GroceriesCoachSortType sortType, SearchCriteria searchCriteria) {
        addProducts(products, sortType);
        sortProducts();
        this.searchCriteria = searchCriteria;
    }

    private void sortProducts() {
        productsWithoutUnitPrices.sort(new ProductComparator(Price));
        productsWithUnitPrices.sort(new ProductComparator(UnitPrice));
    }

    private void addProduct(GroceriesCoachProduct product, GroceriesCoachSortType sortType) {
        if (product.hasUnitPrice() && sortType.isUnitPriceRequired()) {
            productsWithUnitPrices.add(product);
        } else {
            productsWithoutUnitPrices.add(product);
        }
    }

    private void addProducts(Collection<GroceriesCoachProduct> products, GroceriesCoachSortType sortType) {
        for (GroceriesCoachProduct product : products) {
            addProduct(product, sortType);
        }
    }

    public boolean isEmpty() {
        return productsWithoutUnitPrices.isEmpty() && productsWithUnitPrices.isEmpty();
    }

    public int size() {
        return productsWithoutUnitPrices.size() + productsWithUnitPrices.size();
    }

    public List<GroceriesCoachProduct> getProductsWithUnitPrices() {
        return productsWithUnitPrices;
    }

    public List<GroceriesCoachProduct> getProductsWithoutUnitPrices() {
        return productsWithoutUnitPrices;
    }

    public SearchCriteria getSearchCriteria() {
        return searchCriteria;
    }
}
