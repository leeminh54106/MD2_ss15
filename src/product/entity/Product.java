package product.entity;

import product.run.CategoriesManagement;
import product.run.ProductManagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Product {
    private String productid;
    private String productName;
    private float price;
    private String description;
    private Date created;
    private int catalogId;
    private int productStatus;

    public Product() {
    }

    public Product(int catalogId, Date created, String description, float price, String productid, String productName, int productStatus) {
        this.catalogId = catalogId;
        this.created = created;
        this.description = description;
        this.price = price;
        this.productid = productid;
        this.productName = productName;
        this.productStatus = productStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }
public  void updateProduct(Scanner sc) throws ParseException {
    this.productName = inputProductName(sc);
    this.price = inputPrice(sc);
    this.description = inputDescription(sc);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    System.out.println("nhap ngay/thang/nam");
    this.created = sdf.parse(sc.nextLine());
    this.catalogId = getcataId(sc);
    this.productStatus = inputStatus(sc);
}
    public void inputProduct(Scanner sc) throws ParseException {
        this.productid = inputProductId(sc);
        this.productName = inputProductName(sc);
        this.price = inputPrice(sc);
        this.description = inputDescription(sc);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("nhap ngay/thang/nam");
        this.created = sdf.parse(sc.nextLine());
        this.catalogId = getcataId(sc);
        this.productStatus = inputStatus(sc);
    }

    private int inputStatus(Scanner sc) {
        System.out.println("nhap trang thai:");
        System.out.println("1.dang ban");
        System.out.println("2.het hang");
        System.out.println("3.khong ban");
        System.out.println("lua chon cua ban");
        do {
            int choice = Integer.parseInt(sc.nextLine());
            if (choice > 0 && choice < 4) {
                return choice - 1;
            } else {
                System.err.println(">0 && < 4");
            }
        } while (true);
    }

    public int getcataId(Scanner sc) {
        for (Categories c : CategoriesManagement.listCategories) {
            System.out.printf("ID: %d - Name %s\n", c.getCatalogId(), c.getCatalogName());
        }
        System.out.println("nhap vao ma danh muc thuoc ve");
        do {
            int choice = Integer.parseInt(sc.nextLine());
            for (Categories c : CategoriesManagement.listCategories) {
                if (c.getCatalogId() == choice) {
                    return choice;
                }
            }
            System.err.println("ko tim thay");
        } while (true);
    }

    public String inputDescription(Scanner sc) {
        System.out.println("nhap mo ta");
        return sc.nextLine();
    }

    public float inputPrice(Scanner sc) {
        System.out.println("nhap gia san pham");
        do {
            float price = Float.parseFloat(sc.nextLine());
            if (price < 0) {
                System.err.println("gia phai > 0");
            } else {
                return price;
            }
        } while (true);
    }

    public String inputProductName(Scanner sc) {
        System.out.println("nhap ten san pham");
        do {
            String productName = sc.nextLine();
            boolean isExist = false;
            if (productName.trim().length() >= 10 && productName.trim().length() <= 50) {
                for (Product p : ProductManagement.listProduct) {
                    if (p.getProductName().equals(productName)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    return productName;
                } else {
                    System.err.println("ten khong duoc trung");
                }
            } else {
                System.err.println(">=10 or 50<=");
            }
        } while (true);
    }

    public String inputProductId(Scanner sc) {
        System.out.println("nhap ma san pham");
        String regex = "[CSA]\\w{3}";
        do {
            String productId = sc.nextLine();
            if (Pattern.matches(regex, productId)) {
                boolean isExit = false;
                for (Product p : ProductManagement.listProduct) {
                    if (p.productid.equals(productId)) {
                        isExit = true;
                        break;
                    }
                }
                if (isExit) {
                    System.err.println("ko duoc trung ma san pham");
                } else {
                    return productId;
                }
            } else {
                System.err.println("gom 4 ki tu,  bat dau bang [CSA]");
            }
        } while (true);
    }

    public void displayProduct() {
        System.out.printf("id: %s - name: %s - price: %.2f - mo ta: %s - catalogid: %d - status: %s\n",
                this.productid, this.productName, this.price, this.description, CategoriesManagement.listCategories.get(catalogId),
                this.productStatus == 0 ? "dang ban" : this.productStatus == 1 ? "het hang" : "khong ban");
    }
}
