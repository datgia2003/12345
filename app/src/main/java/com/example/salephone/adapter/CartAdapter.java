package com.example.salephone.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.salephone.R;
import com.example.salephone.entity.CartItem;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private Context context;
    private List<CartItem> cartItems;

    public CartAdapter(Context context, List<CartItem> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout cho từng item
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        // Bind dữ liệu vào ViewHolder
        CartItem cartItem = cartItems.get(position);
        holder.productName.setText(cartItem.getProduct().getName());
        holder.productImage.setImageURI(Uri.parse(cartItem.getProduct().getImage_url()));
        holder.productPrice.setText("Giá: " + cartItem.getProduct().getPrice() + " VND");
        holder.productQuantity.setText("Số lượng: " + cartItem.getQuantity());
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    // ViewHolder class để giữ view
    public static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView productName, productQuantity, productPrice;
        ImageView productImage;
        CheckBox cbProduct;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productImage = itemView.findViewById(R.id.productImage);
            productQuantity = itemView.findViewById(R.id.productQuantity);
            productPrice = itemView.findViewById(R.id.productPrice);
            cbProduct = itemView.findViewById(R.id.cbProduct);
        }
    }
}
