package com.computika.gifstudiocreator.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.computika.gifstudiocreator.CustomText.TextMediumBold;
import com.computika.gifstudiocreator.Interface.OnDurationChangeListner;
import com.computika.gifstudiocreator.MainActivity;
import com.computika.gifstudiocreator.Model.Picture;
import com.computika.gifstudiocreator.R;
import com.computika.gifstudiocreator.Utility.BaseFragment;

import java.io.File;



public class MyGifFragment extends BaseFragment {

    Picture picture;
    ImageView imgSelectedPIC;
    int position;

    public MyGifFragment(Picture picture, int position) {
        this.picture = picture;
        this.position = position;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_gif_fragment,container,false);
        initViews(view);
        initData();
        initClickListner();

        return view;

    }



    @Override
    public void initViews(View view) {
        imgSelectedPIC = (ImageView) view.findViewById(R.id.imgSelectedPIC);

    }

    @Override
    public void initData() {

        File file = new File(picture.getPath());
        Glide.clear(imgSelectedPIC);
        Glide.with(mContext).load(file).asBitmap().placeholder(R.drawable.image_loader).override(250,250).diskCacheStrategy(DiskCacheStrategy.ALL).into(imgSelectedPIC);


    }

    @Override
    public void initClickListner() {

        File file = new File(picture.getPath());
        Glide.clear(imgSelectedPIC);
        Glide.with(mContext).load(file).asGif().diskCacheStrategy(DiskCacheStrategy.ALL).into(imgSelectedPIC);

    }


}
