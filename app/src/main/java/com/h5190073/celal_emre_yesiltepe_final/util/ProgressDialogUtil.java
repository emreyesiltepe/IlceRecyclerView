package com.h5190073.celal_emre_yesiltepe_final.util;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressDialogUtil {

    public static ProgressDialog progressDialog(Context context, String mesaj){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(mesaj);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.getListView();

        progressDialog.show();
        return progressDialog;
    }

}
