package com.h5190073.celal_emre_yesiltepe_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import  com.h5190073.celal_emre_yesiltepe_final.R;


public class IlceViewHolder extends RecyclerView.ViewHolder {

    ImageView imgIlceLogo;
    TextView txtIlceAdi,txtMeshur,txtNufus,txtTarihiAc;

    public IlceViewHolder(@NonNull View cardView, IlceAdaptor.OnItemClickListener listener) {
        super(cardView);

        imgIlceLogo =cardView.findViewById(R.id.imgIlceLogo);
        txtIlceAdi =cardView.findViewById(R.id.txtIlceAdi);
        txtMeshur =cardView.findViewById(R.id.txtMeshur);
        txtNufus =cardView.findViewById(R.id.txtNufus);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onClick(getAdapterPosition());
            }
        });

    }
}
