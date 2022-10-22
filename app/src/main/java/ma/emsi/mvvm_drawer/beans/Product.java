package ma.emsi.mvvm_drawer.beans;

import java.util.List;

public class Product {

    private int id;
    private String name;
    private List<Seller> sellers;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sellers=" + sellers +
                '}';
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    public Product(int id, String name, List<Seller> sellers) {
        this.id = id;
        this.name = name;
        this.sellers = sellers;
    }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

