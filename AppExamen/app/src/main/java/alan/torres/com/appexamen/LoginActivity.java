package alan.torres.com.appexamen;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class LoginActivity extends Activity {

    private Button _btnLogin, _btnCreateA;
    private TextInputEditText _txtUser, _txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        Iniciador();
        Eventos();
    }

    public void Iniciador(){

        _btnLogin = findViewById(R.id.btnLogin);
        _btnCreateA = findViewById(R.id.btnCreateA);

        _txtUser = findViewById(R.id.txtUsuario);
        _txtPass = findViewById(R.id.txtContra);

    }

    public void Eventos(){

        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        _btnCreateA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
}
