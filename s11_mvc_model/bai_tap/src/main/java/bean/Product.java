package bean;

public class Product {
    int id;
    String productName;
    String quality;
    String price;
    String productDesc;

    public Product() {
    }

    public Product(int id, String productName, String quality, String price, String productDesc) {
        this.id = id;
        this.productName = productName;
        this.quality = quality;
        this.price = price;
        this.productDesc = productDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
}
