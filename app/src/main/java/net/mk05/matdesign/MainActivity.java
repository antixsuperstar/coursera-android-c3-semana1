package net.mk05.matdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

/**
 *  Debido a errores muy extraños y sin mayor explicación del Log, tuve que usar una librería
 *  externa para restablecer la aplicación. Más info en: https://fabric.io/
 *
 *  import com.crashlytics.android.Crashlytics;
 *  import io.fabric.sdk.android.Fabric;
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar)findViewById(R.id.tlbMainActionBar));

        GlobalState gs = (GlobalState) getApplication();

        MascotaAdaptador mA = new MascotaAdaptador(gs.misMascotas, this);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rvListaMascotas);
        rv.setLayoutManager(llm);
        rv.setAdapter(mA);

        ((ImageButton)findViewById(R.id.imTBarTop5)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MeGustan.class);
                startActivity(i);
            }
        });

    }
}
