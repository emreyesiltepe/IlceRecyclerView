package com.h5190073.celal_emre_yesiltepe_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190073.celal_emre_yesiltepe_final.R;
import com.h5190073.celal_emre_yesiltepe_final.model.IlceModel;
import com.h5190073.celal_emre_yesiltepe_final.util.Constants;
import com.h5190073.celal_emre_yesiltepe_final.util.GlideUtil;
import com.h5190073.celal_emre_yesiltepe_final.util.ObjectUtil;


public class IlceDetayActivity extends AppCompatActivity {

    ImageView imgKapakk;
    TextView txtBaslik,txtDetay;
    IlceModel ilceModel;
    String tasinanIlceString, IlceAciklama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilce_detay);

        init();

    }

    private void init(){
         tasinanIlceString = getIntent().getStringExtra(Constants.TIKANAN_ILCE_TASINANIN_BASLIGI);
         ilceModel = ObjectUtil.jsonStringToIlce(tasinanIlceString);

        imgKapakk = findViewById(R.id.imgKapakk);
        txtBaslik = findViewById(R.id.txtBaslik);
        txtDetay = findViewById(R.id.txtDetay);


        txtBaslik.setText(ilceModel.getIlceAdi());


        GlideUtil.resmiIndiripGoster(getApplicationContext(),ilceModel.getBuyukResimUrl(),imgKapakk);



        txtIlcelerHtml();
    }

    private void txtIlcelerHtml(){
        IlceAciklama = ilceModel.getTarihiAciklama();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N)
        {
            txtDetay.setText(Html.fromHtml(IlceAciklama,Html.FROM_HTML_MODE_LEGACY));

        }
        else{
            txtDetay.setText(Html.fromHtml(IlceAciklama));

        }

    }

}