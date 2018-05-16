package learn.com.actionbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

import learn.com.actionbar.Models.AppController;

public class SaveDataActivity extends AppCompatActivity {
    private Button obj_req,array_req;
    private String urlJsonObj="https://jsonplaceholder.typicode.com/posts/1";
 //   public static String TAG="SaveData";
    private String jsonResponse;
    private static String TAG = SaveDataActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);
        TextView txtView_pwd=(TextView)findViewById(R.id.txtView_pwd);
        //Intent i=getIntent();
        //String pwd=i.getExtras("PASSWORD");
        String pwd=getIntent().getExtras().getString("PASSWORD");

       txtView_pwd.setText(pwd.toString());
        obj_req=(Button)findViewById(R.id.btn_object_req);
         array_req=(Button)findViewById(R.id.btn_array_req);
         obj_req.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 sendObjectReq();
             }
         });


    }
    public void sendObjectReq(){
//        JsonObjectRequest jsonObjReq=new JsonObjectRequest(Method.GET,)

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                urlJsonObj, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
               Log.d(TAG, response.toString());

                try {


                    // Parsing json object response
                    // response will be a json object
                    String userId = response.getString("userId");
                    String id = response.getString("id");
                    String title = response.getString("title");
                    String body = response.getString("body");


                   // jsonResponse = "";
                    jsonResponse += "Name: " + userId + "\n\n";
                    jsonResponse += "Email: " + id + "\n\n";
                    jsonResponse += "Home: " + title + "\n\n";
                    jsonResponse += "Mobile: " + body + "\n\n";

                  //  txtResponse.setText(jsonResponse);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
               // hidepDialog();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog
               // hidepDialog();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);


    }
}
