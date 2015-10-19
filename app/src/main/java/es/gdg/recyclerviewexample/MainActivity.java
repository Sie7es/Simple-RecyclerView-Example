package es.gdg.recyclerviewexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mMyRecyclerView;
    private List<String> mDatas;
    private MyRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatas = populate();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mMyRecyclerView = (RecyclerView) findViewById(R.id.my_recyclerview);
        mMyRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mAdapter = new MyRecyclerViewAdapter(mDatas);
        mMyRecyclerView.setAdapter(mAdapter);

    }

    private List<String> populate() {
        List<String> temp = new ArrayList<String>();

        for (int cont = 0; cont < 100; cont++) {
            temp.add("My name is " + cont);
        }

        return temp;
    }


    private class MyRecyclerViewHolder extends RecyclerView.ViewHolder {

        public TextView mTitleTextView;

        public MyRecyclerViewHolder(View itemView) {
            super(itemView);

            mTitleTextView = (TextView) itemView;

        }
    }

    private class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder> {
        private List<String> mDatas;

        public MyRecyclerViewAdapter(List<String> datas) {
            mDatas = datas;
        }

        @Override
        public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);

            View view = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);

            return new MyRecyclerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyRecyclerViewHolder holder, int position) {
            String title = mDatas.get(position);

            holder.mTitleTextView.setText(title);
        }

        @Override
        public int getItemCount() {
            return mDatas.size();

        }
    }
}
