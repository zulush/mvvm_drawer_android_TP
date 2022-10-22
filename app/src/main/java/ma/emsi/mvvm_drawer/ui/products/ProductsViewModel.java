package ma.emsi.mvvm_drawer.ui.products;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import ma.emsi.mvvm_drawer.beans.Product;
import ma.emsi.mvvm_drawer.networking.ApiClient;
import ma.emsi.mvvm_drawer.networking.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsViewModel  extends AndroidViewModel {

    MutableLiveData<List<Product>> mProducts = new MutableLiveData<>();
    private static final String TAG = "MainActivityViewModel";

    public ProductsViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Product>> getProducts() {
        return mProducts;
    }


    public void addNewProduct(){
        //add data to the server
        Log.d("On Response", "called: ");
        List<Product> currentProduct = mProducts.getValue();
        currentProduct.add(new Product(0, "test"));
        mProducts.postValue(currentProduct);
    }


    public void init() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Product>> call = apiInterface.getProducts();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.d(TAG, "onResponse: " + response.body());
                mProducts.setValue((List<Product>) response.body());

                Log.d(TAG, "getValeu(à: " + mProducts.getValue());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

}
