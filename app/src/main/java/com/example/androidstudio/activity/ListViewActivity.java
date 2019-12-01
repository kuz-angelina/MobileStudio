package com.example.androidstudio.activity;

import com.example.androidstudio.R;
import com.example.androidstudio.model.role.Client;
import com.example.androidstudio.model.role.User;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener
{

  ListView listView;
  String[] listContent;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_view);
    listView = findViewById(R.id.listViewAddOrder);
    Bundle params = getIntent().getExtras();
    int id = (int) params.getSerializable("listContentId");
    listContent = getResources().getStringArray(id);
    ArrayAdapter<String> adapterService = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listContent);
    listView.setAdapter(adapterService);
    listView.setOnItemClickListener(this);
  }

  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id)
  {
    Intent intent = new Intent();
    TextView textView = (TextView) view;
    intent.putExtra("name", textView.getText().toString());
    intent.putExtra("id", position + 1);
    setResult(RESULT_OK, intent);
    finish();
  }
}
