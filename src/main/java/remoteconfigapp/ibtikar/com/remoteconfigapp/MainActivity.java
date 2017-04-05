package remoteconfigapp.ibtikar.com.remoteconfigapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TabHost;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NewsListAdapter.OnItemViewClicked {

    //    private TextView smallText, midText, largText;
    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    private List<NewsModel> newsModels;
    private NewsListAdapter adapter;
    RecyclerView recyclerView;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        newsModels = new ArrayList<>();
        adapter = new NewsListAdapter(prepareList(newsModels), this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private List prepareList(List<NewsModel> newsModels) {
        for (int i = 0; i <= 10; i++) {
            NewsModel newsModel = new NewsModel();
            newsModel.setNewsTitle("North Carolina gets redemption by winning national title");
            newsModel.setNewsDes("USA TODAY Sports' Dan Wolken explains how the Tar Heels clawed their way to the national championship by edging Gonzaga. USA TODAY Sports");
            newsModel.setNewsUrl("https://cms-assets.tutsplus.com/uploads/users/21/posts/19431/featured_image/CodeFeature.jpg");
            newsModels.add(newsModel);
        }
        return newsModels;
    }

    @Override
    public void onItemClicked(int pos) {
        this.pos = pos;
        Intent intent = new Intent(MainActivity.this, DetailesActivity.class);
        startActivityForResult(intent, 22);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == 22) {

            NewsModel newsModel = new NewsModel();
            newsModel.setNewsUrl("https://cms-assets.tutsplus.com/uploads/users/21/posts/19431/featured_image/CodeFeature.jpg");
            newsModel.setNewsTitle("new items added");
            newsModel.setNewsDes("new items added");
            newsModel.setIsRelated(true);
            adapter.insertItems(newsModel, pos+1);
        }
    }
}
