package com.h5190073.celal_emre_yesiltepe_final.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190073.celal_emre_yesiltepe_final.adaptor.IlceAdaptor;
import com.h5190073.celal_emre_yesiltepe_final.R;
import com.h5190073.celal_emre_yesiltepe_final.model.IlceModel;
import com.h5190073.celal_emre_yesiltepe_final.network.Service;
import com.h5190073.celal_emre_yesiltepe_final.util.AlertDialogUtil;
import com.h5190073.celal_emre_yesiltepe_final.util.Constants;
import com.h5190073.celal_emre_yesiltepe_final.util.ObjectUtil;
import com.h5190073.celal_emre_yesiltepe_final.util.PrefUtil;
import com.h5190073.celal_emre_yesiltepe_final.util.ProgressDialogUtil;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SecondActivity extends AppCompatActivity {

    String alertDialogBaslik,alertDialogMesaj,alertDialogPositiveButton,alertDialogNegativeButton;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    TextView txtAciklama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();

    }
    private  void  init()
    {
        ilceleriGetir();
        progressDialogAlert();
        initTxt();
    }
    private  void  initTxt(){
        txtAciklama=findViewById(R.id.txtKapakYazi);
        txtAciklama.setText(getResources().getString(R.string.secondActivityAciklama));
    }
    void  ilceleriGetir()
    {

        new Service().getServiceApi().ilceleriGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<IlceModel>>() {

                    List<IlceModel> ilceler=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<IlceModel> ilcelerList) {
                        ilceler=ilcelerList;
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete()
                    {
                        for (int size =0; size<=ilceler.size(); size++){
                            if(size==ilceler.size()){
                                progressDialog.dismiss();
                            }
                            continue;
                        }

                        if(ilceler.size()>0) {



                            initRecycleView(ilceler);
                        }
                    }
                });
    }


    private  void  initRecycleView(List<IlceModel> ilceList)
    {
        recyclerView =findViewById(R.id.rcvIlceler);
        IlceAdaptor ılceAdaptor =new IlceAdaptor(ilceList, getApplicationContext(), new IlceAdaptor.OnItemClickListener() {
            @Override
            public void onClick(int position) {

                IlceModel tiklananIlce = ilceList.get(position);
                gecis(tiklananIlce);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(ılceAdaptor);
    }
    private  void  progressDialogAlert()
    {
        progressDialog= ProgressDialogUtil.progressDialog(SecondActivity.this,getResources().getString(R.string.progressDialogBaslik));
    }

    private void gecis(IlceModel tiklananIlce){
        Intent intent=new Intent(getApplicationContext(), IlceDetayActivity.class);
        String tiklananIlceString = ObjectUtil.ilceToJsonString(tiklananIlce);
        intent.putExtra(Constants.TIKANAN_ILCE_TASINANIN_BASLIGI,tiklananIlceString);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        alertDialogPositiveButton=String.valueOf(R.string.cikisAlertPositiveButton);
        alertDialogNegativeButton=String.valueOf(R.string.cikisAlertNegativeButton);
        alertDialogBaslik=String.valueOf(R.string.cikisAlertBaslik);
        alertDialogMesaj=String.valueOf(R.string.cikisAlertMesaj);
        PrefUtil.setStringPref(getApplicationContext(), Constants.ISTENILEN_ALERT_DIALOG,Constants.CIKIS_ALERT_DIALOG);
        AlertDialogUtil.alertDialogTanimla(SecondActivity.this,alertDialogPositiveButton,alertDialogNegativeButton,alertDialogBaslik,alertDialogMesaj);
    }
}
