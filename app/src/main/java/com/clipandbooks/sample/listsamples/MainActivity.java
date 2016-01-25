package com.clipandbooks.sample.listsamples;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {
    // 제목, 설명
    public final static String ITEM_TITLE = "title";
    public final static String ITEM_CAPTION = "caption";

    public SeparatedListAdpater adapter;
    public List<Map<String, ?>> security;

    // Map 컬렉션 형태로 Item 구성
    public Map<String, ?> createItem(String title, String caption) {
        Map<String, String> item = new HashMap<String, String>();
        item.put(ITEM_TITLE, title);
        item.put(ITEM_CAPTION, caption);
        return item;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        security = new LinkedList<Map<String, ?>>();
        security.add(createItem("Remember passwords",
                "Save usernames and passwords for Web Sites"));
        security.add(createItem("Clear passwords",
                "Save usernames and passwords for Web Sites"));
        security.add(createItem("Show security warnings",
                "Show warning if there is a problem with a site's security"));

        // 어댑터 생성
        adapter = new SeparatedListAdpater(this);

        // Simple 어댑터를 section으로 추가
        adapter.addSection("Security", new SimpleAdapter(this, security,
                R.layout.list_complex, new String[] { ITEM_TITLE, ITEM_CAPTION },
                new int[] { R.id.list_complex_title, R.id.list_complex_caption }));

        // Simple 어댑터를 section으로 추가
        adapter.addSection("tes1", new SimpleAdapter(this, security,
                R.layout.list_complex, new String[] { ITEM_TITLE, ITEM_CAPTION },
                new int[] { R.id.list_complex_title, R.id.list_complex_caption }));

        // Simple 어댑터를 section으로 추가
        adapter.addSection("tes2", new SimpleAdapter(this, security,
                R.layout.list_complex, new String[] { ITEM_TITLE, ITEM_CAPTION },
                new int[] { R.id.list_complex_title, R.id.list_complex_caption }));

        // Simple 어댑터를 section으로 추가
        adapter.addSection("tes3", new SimpleAdapter(this, security,
                R.layout.list_complex, new String[] { ITEM_TITLE, ITEM_CAPTION },
                new int[] { R.id.list_complex_title, R.id.list_complex_caption }));

        // Simple 어댑터를 section으로 추가
        adapter.addSection("tes4", new SimpleAdapter(this, security,
                R.layout.list_complex, new String[] { ITEM_TITLE, ITEM_CAPTION },
                new int[] { R.id.list_complex_title, R.id.list_complex_caption }));

        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String content;

        Log.d("TAG", "position:"+position);

        /*
        if(position < 3)
            content =  adapter.getItem(position).toString();
        else
        */
            content = ((Map) adapter.getItem(position)).get(ITEM_TITLE).toString();

        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }
}
