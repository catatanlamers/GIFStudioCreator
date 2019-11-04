package com.computika.gifstudiocreator.ImageChooser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.computika.gifstudiocreator.CustomText.TextMedium;
import com.computika.gifstudiocreator.CustomText.TextMediumBold;
import com.computika.gifstudiocreator.Model.Image;
import com.computika.gifstudiocreator.R;
import com.computika.gifstudiocreator.Utility.BaseActivity;

import java.io.File;
import java.util.ArrayList;


public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Image> mFolders;
    private BaseActivity baseActivity;

    public FolderAdapter(Context mContext, ArrayList<Image> mImages) {
        this.mContext = mContext;
        this.baseActivity = (BaseActivity) mContext;
        this.mFolders = mImages;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_storeage_folder, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Image images = mFolders.get(position);
        Glide.with(mContext).load(new File(images.getThumbPath())).asBitmap().placeholder(R.drawable.rect_load).error(R.drawable.rect_load).into(holder.imgSd);
        holder.txtSd.setText(mFolders.get(position).getmImages().size() + "");
        holder.txtFolderName.setText(images.getFolderName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseActivity.replaceFragmentWithTag(new MostRecentFragment(images.getmImages()),"MOST");



            }
        });
    }


    @Override
    public int getItemCount() {
        return mFolders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgSd;
        private TextView txtFolderName;
        private TextView txtSd;


        public ViewHolder(View v) {
            super(v);

            imgSd = (ImageView) v.findViewById(R.id.imgSd);
            txtFolderName = (TextView) v.findViewById(R.id.txtFolderName);
            txtSd = (TextView) v.findViewById(R.id.txtSd);


        }

    }

}