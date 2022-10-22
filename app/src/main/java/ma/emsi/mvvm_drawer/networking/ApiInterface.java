package ma.emsi.mvvm_drawer.networking;

import java.util.List;

import ma.emsi.mvvm_drawer.beans.Product;
import ma.emsi.mvvm_drawer.beans.Seller;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("/api/products")
    Call<List<Product>> getProducts();

    @GET("/products/{id}")
    Call<Product> getProduct(@Path("id") int id);

    @GET("/products/{id}/sellers")
    Call<Seller> getProductSellers(@Path("id") int id);

}
