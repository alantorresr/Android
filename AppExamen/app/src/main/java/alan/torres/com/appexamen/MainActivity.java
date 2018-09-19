package alan.torres.com.appexamen;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import Interfaces.GetApi;
import Models.Persona;
import Models.PersonaRespuesta;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView _listView;
    private ImageButton _btnBuscar, _btnAgregar;
    private EditText _txtBuscar;

    private ArrayList<Persona> listaPersonas;

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder().baseUrl("https://apiandroidexamen1.azurewebsites.net//AndroidExam1/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Inicializar();
        Eventos();
        BringAllPersona();
    }

    public void Inicializar()
    {

        _listView = (ListView) findViewById(R.id.listView);
        _btnBuscar = findViewById(R.id.btnBuscar);
        _btnAgregar = findViewById(R.id.btnAgregar);
        _txtBuscar = findViewById(R.id.txtBuscar);

        listaPersonas = new ArrayList<Persona>();

        listaPersonas.add(new Persona(1,"Nombre", "Apellidos", R.drawable.user));
        listaPersonas.add(new Persona(1,"Nombree", "Apellidos", R.drawable.user));
        listaPersonas.add(new Persona(1,"Nombre", "Apellidos", R.drawable.user));
        listaPersonas.add(new Persona(1,"Nombree", "Apellidos", R.drawable.user));
        listaPersonas.add(new Persona(1,"Nombre", "Apellidos", R.drawable.user));
        listaPersonas.add(new Persona(1,"Nombree", "Apellidos", R.drawable.user));

        AdaptadorPersonas adaptadorPersonas = new AdaptadorPersonas(this);
        _listView.setAdapter(adaptadorPersonas);
    }

    public void Eventos()
    {
        _btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });


    }

    public void BringAllPersona()
    {
        GetApi service = retrofit.create(GetApi.class);
        Call<PersonaRespuesta> personaRespuestaCall = service.obtenerListaPersonas();

        personaRespuestaCall.enqueue(new Callback<PersonaRespuesta>() {
            @Override
            public void onResponse(Call<PersonaRespuesta> call, Response<PersonaRespuesta> response) {
                if (response.isSuccessful()){
                    PersonaRespuesta personaRespuesta = response.body();
                    ArrayList<Persona> listaPersona = personaRespuesta.getResults();

                    for (int i = 0; i < listaPersona.size(); i++)
                    {
                        Persona p = listaPersona.get(i);
                        Log.i("", "Nombre: " + p.getNombre());
                    }

                }else {
                    Log.e("App", " onResponse:" + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PersonaRespuesta> call, Throwable t) {
                Log.e("App", "onFaliure: " + t.getMessage());
            }
        });
    }

    public class AdaptadorPersonas extends ArrayAdapter<Persona>{

        AppCompatActivity appCompatActivity;

        public AdaptadorPersonas(AppCompatActivity context){
            super(context, R.layout.item_list, listaPersonas);
            appCompatActivity = context;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();

            View item = inflater.inflate(R.layout.item_list, null);

            TextView _txtNombre = (TextView) item.findViewById(R.id.txtNombre);
            _txtNombre.setText(listaPersonas.get(position).getNombre());

            CircleImageView _imgPersona = (CircleImageView) item.findViewById(R.id.imgPersona);
            _imgPersona.setImageResource(listaPersonas.get(position).getFoto());

            return item;
        }


    }






















}
