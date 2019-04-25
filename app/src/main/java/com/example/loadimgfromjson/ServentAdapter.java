package com.example.loadimgfromjson;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ServentAdapter extends BaseAdapter {
    List <ServentModel> serventModelList;
    //ArrayList <ServentModel> serventArrayList;
    Context context;
    LayoutInflater inflater;

    public ServentAdapter(Context context, List<ServentModel> serventModelList){
        this.context=context;
        this.serventModelList = serventModelList;
        inflater = LayoutInflater.from(context);
        //this.serventArrayList = new ArrayList<ServentModel>();
        //this.serventArrayList.addAll(serventModelList);
    }
    @Override
    public int getCount() {
        return serventModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return serventModelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.row,null);

        ImageView imageView = (ImageView)view.findViewById(R.id.image);
        TextView sName = (TextView)view.findViewById(R.id.txtTitle);
        TextView sDesc = (TextView) view.findViewById(R.id.txtDesc);

        //imageView.setImageResource(serventModelList.get(position).getIcon());
        sName.setText(serventModelList.get(position).getsName());
        sDesc.setText(serventModelList.get(position).getsDesc());
        loadingImage(imageView, serventModelList.get(position).getIcon());

        return view;
    }

    InputStream inputStream;
    Drawable drawable;
    private void loadingImage(ImageView imageViewView, String Icon){
        try{
            inputStream = context.getAssets().open("Item/"+Icon);
            drawable = Drawable.createFromStream(inputStream,null);
            imageViewView.setImageDrawable(drawable);
        } catch (IOException e) {
            Log.e("loadingImage",e.getMessage());
        }
    }


}
