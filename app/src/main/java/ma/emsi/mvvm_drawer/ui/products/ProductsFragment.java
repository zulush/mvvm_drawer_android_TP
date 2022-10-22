package ma.emsi.mvvm_drawer.ui.products;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import ma.emsi.mvvm_drawer.MainActivity;
import ma.emsi.mvvm_drawer.R;
import ma.emsi.mvvm_drawer.ui.sellers.SellersFragment;
import ma.emsi.mvvm_drawer.adapters.ProductAdapter;
import ma.emsi.mvvm_drawer.beans.Product;
import ma.emsi.mvvm_drawer.databinding.FragmentGalleryBinding;
import ma.emsi.mvvm_drawer.databinding.FragmentHomeBinding;
import ma.emsi.mvvm_drawer.databinding.FragmentProductsBinding;
import ma.emsi.mvvm_drawer.ui.gallery.GalleryViewModel;


public class ProductsFragment extends Fragment {

    private static final String TAG = "ProductsFragment";
    private FragmentProductsBinding binding;
    private ListView list;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentProductsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        // instantiate ViewModel
        ProductsViewModel mProductsViewModel = new ViewModelProvider(this).get(ProductsViewModel.class);

        // reception initial les données
        mProductsViewModel.init();

        // instantiate the adapter
        ProductAdapter adapter = new ProductAdapter((MainActivity) getActivity());
        list = root.findViewById(R.id.productsList);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                OpenSellersFragment(mProductsViewModel.getProducts().getValue().get(position));
            }
        });
        list.setAdapter(adapter);

        // set Observer of the DataLive (which is products)
        mProductsViewModel.getProducts().observe(getActivity(), new Observer<List<Product>>(){

            @Override
            public void onChanged(List<Product> products) {
                adapter.setObjects(products);
                adapter.notifyDataSetChanged();
            }
        });

        return root;
    }

    private void OpenSellersFragment(Product product) {
        Log.i(TAG, "OpenSellersFragment: " + product);
        Fragment fragment = new SellersFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment_content_main, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}