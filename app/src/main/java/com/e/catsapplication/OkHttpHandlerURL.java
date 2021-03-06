package com.e.catsapplication;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.lang.ref.WeakReference;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpHandlerURL extends AsyncTask<String,Void,String> {

    private String image_id;
    private WeakReference<DetailsActivity> wrDA;
    Context context;

    OkHttpHandlerURL(String image_id, DetailsActivity detailsActivity, Context context) {
        this.image_id = image_id;
        wrDA = new WeakReference<>(detailsActivity);
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search?breed_id="+image_id)
                .method("GET", null)
                .addHeader("Content-Type", "application/json")
                .addHeader("x-api-key", "92021ab8-d4ef-4bc2-8518-3900313df52a")
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONArray jsonArray = new JSONArray(s);
            for (int i = 0; i < jsonArray.length(); i++){
                if(jsonArray.getJSONObject(i).has("url")){
                    String imageURL = jsonArray.getJSONObject(i).get("url").toString();
                    Picasso.with(context).load(imageURL).into(wrDA.get().imageView);
                    break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }    }
}
