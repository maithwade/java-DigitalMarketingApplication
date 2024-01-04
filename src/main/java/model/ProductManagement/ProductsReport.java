/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;
import java.util.Collections;

import ui.Helpermethods;

/**
 *
 * @author kal bugrara
 */
public class ProductsReport {

    ArrayList<ProductSummary> productSummaryList;
    String sortingRule;

    public ProductsReport(String sortingRule) {
        productSummaryList = new ArrayList<ProductSummary>();
        this.sortingRule = sortingRule;
        /// We could make it "pre-populate" with the existing product data

    }

    public void addProductSummary(ProductSummary ps) {

        productSummaryList.add(ps);

        ProductSummaryComparator comparator = new ProductSummaryComparator(sortingRule);
        Collections.sort(productSummaryList, comparator);

    }

    public ProductSummary getTopProductAboveTarget() {
        ProductSummary currentTopProduct = null;

        for (ProductSummary ps : productSummaryList) {
            if (currentTopProduct == null) {
                currentTopProduct = ps; // initial step
            } else if (ps.getNumberAboveTarget() > currentTopProduct.getNumberAboveTarget()) {
                currentTopProduct = ps; // we have a new higher total
            }

        }
        return currentTopProduct;
    }

    public ArrayList<ProductSummary> getProductsAlwaysAboveTarget() {
        ArrayList<ProductSummary> productsAlwaysAboveTarget = new ArrayList<ProductSummary>(); // temp array list

        for (ProductSummary ps : productSummaryList) {
            if (ps.isProductAlwaysAboveTarget() == true) {
                productsAlwaysAboveTarget.add(ps);
            }
        }

        return productsAlwaysAboveTarget;
    }

    public void printProductReport() {
        System.out.println(" ");
        //System.out.println(Helpermethods.ANSI_PURPLE + "Product Performance Report" + Helpermethods.ANSI_RESET);
        int tableWidth = 105; // calculate the total table width
        String title = Helpermethods.PURPLE_UNDERLINED + "Product Performance Report"+ Helpermethods.ANSI_RESET;
        int paddingSize = (tableWidth - title.length()) / 2;
        String format = "%" + (paddingSize + title.length()) + "s%n";

        System.out.printf(Helpermethods.ANSI_PURPLE + format + Helpermethods.ANSI_RESET, title);
        System.out.println(" ");
        System.out.println(Helpermethods.ANSI_BLUE + "Below are product name, actual sales and number of sales above target." + Helpermethods.ANSI_RESET);
        System.out.println(" ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-5s | %-30s | %-20s | %-20s | %-20s |%n", "Index", "Product Name", "Actual Sales", "Sales Above Target", "Product Price Performance");
        System.out.println("|-------|--------------------------------|----------------------|----------------------|---------------------------|");
        for (ProductSummary ps : productSummaryList) {
            // int index = productSummaryList.indexOf(ps);
            // System.out.print((index + 1) + " ");
            // ps.printProductSummary();
            int index = productSummaryList.indexOf(ps) + 1;
            System.out.printf("| %-5d ", index);
            ps.printProductSummary();
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        

    }
}
