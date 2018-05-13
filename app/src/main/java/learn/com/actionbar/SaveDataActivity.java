package learn.com.actionbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SaveDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);
        TextView txtView_pwd=(TextView)findViewById(R.id.txtView_pwd);
        //Intent i=getIntent();
        //String pwd=i.getExtras("PASSWORD");
        String pwd=getIntent().getExtras().getString("PASSWORD");

       txtView_pwd.setText(pwd.toString());

    }
}
