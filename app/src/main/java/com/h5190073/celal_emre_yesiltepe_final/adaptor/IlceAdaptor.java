package com.h5190073.celal_emre_yesiltepe_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.h5190073.celal_emre_yesiltepe_final.util.GlideUtil;
import com.h5190073.celal_emre_yesiltepe_final.R;
import com.h5190073.celal_emre_yesiltepe_final.model.IlceModel;

import java.util.List;

public class IlceAdaptor extends RecyclerView.Adapter<IlceViewHolder> {


    List<IlceModel> ilceler;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener{
        void onClick(int position);
    }


    public IlceAdaptor(List<IlceModel> ilceler, Context context,OnItemClickListener listener) {
        this.ilceler = ilceler;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public IlceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_ilce,parent,false);
        return new IlceViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull IlceViewHolder viewHolder, int position) {

        viewHolder.txtMeshur.setText(ilceler.get(position).getMeshurYemegi());
        viewHolder.txtNufus.setText(ilceler.get(position).getNufusu());
        viewHolder.txtIlceAdi.setText(ilceler.get(position).getIlceAdi());

        GlideUtil.resmiIndiripGoster(context,ilceler.get(position).getKucukResimUrl(),viewHolder.imgIlceLogo);

    }

    @Override
    public int getItemCount() {
        return ilceler.size();
    }
}
