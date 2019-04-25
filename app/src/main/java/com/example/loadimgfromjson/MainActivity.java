package com.example.loadimgfromjson;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
        context = this;
        Gson gson = new Gson();
        JsonModel model = gson.fromJson(loadingJson(),JsonModel.class);
        //JsonModel Bronze = gson.fromJson(loadingJson(),JsonModel.class);

        listView = (ListView) findViewById(R.id.listView);
        ServentAdapter serventAdapter = new ServentAdapter(getApplicationContext(), model.getItems());
        //serventAdapter = new ServentAdapter(this,model.getServentModels());
        listView.setAdapter(serventAdapter);
        }catch (Exception e){
            Log.e("loading",e.getMessage());
        }
    }

    public String loadingJson() {
        String result = "";
        try {
            InputStream inputStream = context.getAssets().open("samplejs.json");
            int size = inputStream.available();
            byte[]buffer = new byte[size];
            inputStream.read(buffer);
            result = new String(buffer,"UTF-8");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
       /* title = new String[]{"1","2"};
        desc = new String[] {"1","2"};
        avatar = new int[] {R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_background};

        listView = findViewById(R.id.listView);

        for(int i = 0; i<title.length;i++){
            ServentModel servent = new ServentModel(title[i],desc[i],avatar[i]);
            serventArrayList.add(servent);
        }

        serventAdapter = new ServentAdapter(this,serventArrayList);
        listView.setAdapter(serventAdapter);
*/
}

