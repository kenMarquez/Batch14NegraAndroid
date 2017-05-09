package com.devf.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devf.recyclerview.models.Promocion;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ken on 08/05/17.
 */

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.PromoViewHolder> {

    private List<Promocion> promocionList;

    public PromoAdapter(List<Promocion> promocionList) {
        this.promocionList = promocionList;
    }

    @Override
    public PromoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
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


        public PromoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void bindPromocion(Promocion promocion) {
            tvTitle.setText(promocion.getTitulo());
            tvDescripcion.setText(promocion.getDescripcion());
            tvDescuento.setText(promocion.getDescuento() + "%");
        }


    }
}
