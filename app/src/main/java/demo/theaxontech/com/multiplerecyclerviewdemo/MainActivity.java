package demo.theaxontech.com.multiplerecyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayList<Model> list= new ArrayList<Model>();
        list.add(new Model(Model.TEXT_TYPE,"Keep","Take notes",0));
        list.add(new Model(Model.IMAGE_TYPE,"Keep","Take notes",R.drawable.image_two));
        list.add(new Model(Model.AUDIO_TYPE,"Keep","Take notes",R.drawable.black_bag));
        list.add(new Model(Model.IMAGE_TYPE,"Keep","Take notes", R.drawable.image_two));
        list.add(new Model(Model.TEXT_TYPE,"Keep","Take notes",0));
        list.add(new Model(Model.IMAGE_TYPE,"Keep","Take notes",R.drawable.image_two));
        list.add(new Model(Model.AUDIO_TYPE,"Keep","Take notes",R.drawable.black_bag));
        list.add(new Model(Model.TEXT_TYPE,"Keep","Take notes",0));
        list.add(new Model(Model.IMAGE_TYPE,"Keep","Take notes",R.drawable.image_two));
        list.add(new Model(Model.AUDIO_TYPE,"Keep","Take notes",R.drawable.black_bag));

        MultiViewTypeAdapter adapter = new MultiViewTypeAdapter(list,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}
