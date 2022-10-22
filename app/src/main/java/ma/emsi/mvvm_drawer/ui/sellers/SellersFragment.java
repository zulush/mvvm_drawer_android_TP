package ma.emsi.mvvm_drawer.ui.sellers;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import ma.emsi.mvvm_drawer.MainActivity;
import ma.emsi.mvvm_drawer.R;
import ma.emsi.mvvm_drawer.adapters.ProductAdapter;
import ma.emsi.mvvm_drawer.beans.Product;
import ma.emsi.mvvm_drawer.databinding.FragmentProductsBinding;
import ma.emsi.mvvm_drawer.databinding.FragmentSellersBinding;
import ma.emsi.mvvm_drawer.ui.gallery.GalleryViewModel;
import ma.emsi.mvvm_drawer.ui.products.ProductsViewModel;

public class SellersFragment extends Fragment {


    private static final String TAG = "ProductsFragment";
    private FragmentSellersBinding binding;
    private ListView list;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sellers, container, false);
        return view;
    }
}