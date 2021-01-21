package com.h5190073.celal_emre_yesiltepe_final.util;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.h5190073.celal_emre_yesiltepe_final.R;


public class GlideUtil {
    public  static  void resmiIndiripGoster(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .error(R.drawable.logoo)
                .centerCrop()
                .into(img);
    }
}
