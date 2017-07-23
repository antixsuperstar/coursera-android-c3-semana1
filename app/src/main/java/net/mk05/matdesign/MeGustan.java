package net.mk05.matdesign;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

public class MeGustan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_gustan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.meGustan_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GlobalState gs = (GlobalState)getApplication();
        ArrayList<Mascota> listaInversa = (ArrayList)gs.ultimasMascotasFavoritas.clone();

        RecyclerView mgRV = (RecyclerView)findViewById(R.id.meGustan_rvMeGustan);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        mgRV.setLayoutManager(llm);
        Collections.reverse(listaInversa); // Mostrar primero la más recientemente "gustada"
        mgRV.setAdapter(new MascotaAdaptador(listaInversa, this));
    }
}
