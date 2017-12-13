package codingpizza.com.pizzapedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mUsername_et;
    private EditText mPassword_et;
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //#1
        mUsername_et = findViewById(R.id.et_username);
        mPassword_et = findViewById(R.id.et_password);
        mButton = findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUser();
            }
        });




    }

    //#2
    private void checkUser() {
       if (mUsername_et.getText().toString().equals("") || mPassword_et.getText().toString().equals("")){
           Toast.makeText(this, "El campo usuario o contraseña no puede estar vacio", Toast.LENGTH_SHORT).show();
       } else {
           //#3
//           if (mUsername_et.getText().toString().equals("pizzauser") && mPassword_et.getText().toString().equals("codingpizza")){
           if (mUsername_et.getText().toString().equals("a") && mPassword_et.getText().toString().equals("b")){
               moveToPizzaList();
           } else {
               Toast.makeText(this, "El nombre de usuario o contraseña es incorrecto.", Toast.LENGTH_SHORT).show();
           }
       }
    }

    private void moveToPizzaList() {
        Intent pizzaListIntent = new Intent(this, PizzaListActivity.class);
        startActivity(pizzaListIntent);
    }
}
