package product.entity;

import product.run.CategoriesManagement;

import java.util.Scanner;

public class Categories {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private Boolean catalogStatus;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, Boolean catalogStatus, String descriptions) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.catalogStatus = catalogStatus;
        this.descriptions = descriptions;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public Boolean getCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(Boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void updateCategories(Scanner sc){
        this.catalogName = inputCatalogName(sc);
        this.descriptions = inputDescriptions(sc);
        this.catalogStatus = inputCatalogStatus(sc);
    }
    public void inputCategories(Scanner sc) {
        this.catalogId = inputcatalogId();
        this.catalogName = inputCatalogName(sc);
        this.descriptions = inputDescriptions(sc);
        this.catalogStatus = inputCatalogStatus(sc);
    }

    private Boolean inputCatalogStatus(Scanner sc) {
        System.out.println("nhap trang thai");
        do {
            String status = sc.nextLine();
            if (status.equals("true") || status.equals("false")) {
                return Boolean.parseBoolean(status);
            } else {
                System.err.println("chi nhan true/false");
            }
        } while (true);
    }

    public String inputDescriptions(Scanner sc) {
        System.out.println("nhap vao mo ta:");
        return sc.nextLine();
    }

    public String inputCatalogName(Scanner sc) {

        do {
            System.out.println("nhap ten danh muc");
            String catalogName = sc.nextLine();
            if (catalogName.trim().length() <= 50) {
                boolean isExit = false;
                for (Categories c : CategoriesManagement.listCategories) {
                    if (c.getCatalogName().equals(catalogName)) {
                        System.err.println("ten khong duoc trung");
                        isExit = true;
                        break;

                    }

                }
                if (!isExit){
                    return catalogName;
                }
            } else {
                System.err.println("do dai <= 50");
            }
        } while (true);
    }

    public int inputcatalogId() {
        int max = 0;
        for (Categories c : CategoriesManagement.listCategories) {
            if (c.getCatalogId() > max) {
                max = c.getCatalogId();
            }
        }
        return max + 1;
    }

    public void displayCategories() {
        System.out.printf("ID: %d - cataName: %s - descriptions: %s - status: %s\n",
                this.catalogId, this.catalogName, this.descriptions, this.catalogStatus ? "hoat dong" : "khong hoat dong");
    }
}

