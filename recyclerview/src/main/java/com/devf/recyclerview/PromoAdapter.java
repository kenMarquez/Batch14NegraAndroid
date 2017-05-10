package com.devf.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.devf.recyclerview.models.Promocion;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Ken on 08/05/17.
 */

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.PromoViewHolder> {

    private List<Promocion> promocionList;

    private Context context;

    public PromoAdapter(List<Promocion> promocionList) {
        this.promocionList = promocionList;
    }

    @Override
    public PromoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_promocion, parent, false);

        PromoViewHolder viewHolder = new PromoViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(PromoViewHolder holder, int position) {

        Promocion promocion = promocionList.get(position);
        holder.bindPromocion(promocion);

    }

    @Override
    public int getItemCount() {
        return promocionList.size();
    }


    public class PromoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_promo_tv_titulo)
        TextView tvTitle;

        @BindView(R.id.item_promo_tv_descripcion)
        TextView tvDescripcion;

        @BindView(R.id.item_promo_tv_descuento)
        TextView tvDescuento;

        @BindView(R.id.item_promo_img_logo)
        CircleImageView imgCompany;

        View rootView;

        public PromoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindPromocion(Promocion promocion) {
            tvTitle.setText(promocion.getTitulo());
            tvDescripcion.setText(promocion.getDescripcion());
            tvDescuento.setText(promocion.getDescuento() + "%");
            if (!promocion.getUrl().isEmpty()) {

                Glide.with(context)
                        .load(promocion.getUrl())
                        .placeholder(R.drawable.amazon)
                        .error(R.mipmap.ic_launcher)
                        .into(imgCompany);
            }

        }


    }
}
