package com.h5190073.celal_emre_yesiltepe_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.h5190073.celal_emre_yesiltepe_final.R;
import com.h5190073.celal_emre_yesiltepe_final.util.AlertDialogUtil;
import com.h5190073.celal_emre_yesiltepe_final.util.Constants;
import com.h5190073.celal_emre_yesiltepe_final.util.PrefUtil;

public class FirstActivity extends AppCompatActivity {
    String alertDialogBaslik,alertDialogMesaj,alertDialogPositiveButton,alertDialogNegativeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        zamanlayıcı();
    }
    private void zamanlayıcı(){
        CountDownTimer countDownTimer=new CountDownTimer(Constants.GECIS_SANIYESI,Constants.COUNT_DOWN) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                internetKontrolEt();
            }
        }.start();
    }
    private void internetKontrolEt(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getActiveNetworkInfo()!=null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected()){
            secondActivity();
        }
        else{
            alertDialogPositiveButton=String.valueOf(R.string.internetKontrolAlertPositiveButton);
            alertDialogNegativeButton=String.valueOf(R.string.internetKontrolAlertNegativeButton);
            alertDialogBaslik=String.valueOf(R.string.internetAlertBaslik);
            alertDialogMesaj=String.valueOf(R.string.internetAlertMesaj);
            PrefUtil.setStringPref(getApplicationContext(), Constants.ISTENILEN_ALERT_DIALOG, Constants.INTERNET_KONTROL_ALERT_DIALOG);
            AlertDialogUtil.alertDialogTanimla(FirstActivity.this,alertDialogPositiveButton,alertDialogNegativeButton,alertDialogBaslik,alertDialogMesaj);
        }
    }
    private void secondActivity(){
        Intent intent=new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(intent);
        finish();
    }

}
