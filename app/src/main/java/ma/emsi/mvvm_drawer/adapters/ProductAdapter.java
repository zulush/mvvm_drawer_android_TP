package ma.emsi.mvvm_drawer.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ma.emsi.mvvm_drawer.MainActivity;
import ma.emsi.mvvm_drawer.beans.Product;
import ma.emsi.mvvm_drawer.R;

public class ProductAdapter extends BaseAdapter {
    private List<Product> objects;
    private LayoutInflater inflater;

    public ProductAdapter(Activity activity, List<Product> objects) {
        this.objects = objects;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public List<Product> getObjects() {
        return objects;
    }

    public void setObjects(List<Product> objects) {
        this.objects = objects;
    }

    public ProductAdapter(MainActivity activity) {
        this.objects = new ArrayList<Product>();
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position + 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = inflater.inflate(R.layout.product_item, null);


        TextView id = convertView.findViewById(R.id.productsId);
        TextView name = convertView.findViewById(R.id.productsName);

        id.setText(objects.get(position).getId()+"");
        name.setText(objects.get(position).getName());

        return convertView;
    }
}
