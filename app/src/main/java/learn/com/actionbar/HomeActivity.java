package learn.com.actionbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends Activity {
    private EditText edTxt_username,edTxt_password;
    private Button btn_login;

    public HomeActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        edTxt_username=(EditText)findViewById(R.id.edTxt_username);
        edTxt_password=(EditText)findViewById(R.id.edTxt_password);
        btn_login=(Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getBaseContext(), SaveDataActivity.class);
                intent.putExtra("PASSWORD",edTxt_password.toString());

                startActivity(intent);

                Toast.makeText(getBaseContext(),"Login :"+edTxt_username.toString(),Toast.LENGTH_LONG).show();
               // Toast.makeText(HomeActivity.this,"Login :"+edTxt_username,Toast.LENGTH_LONG).show();

                finish();
            }
        });

    }
}
