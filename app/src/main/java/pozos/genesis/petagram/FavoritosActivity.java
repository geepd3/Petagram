package pozos.genesis.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MascotasAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_lista);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList mascotas = new ArrayList<>();

        mascotas.add(new MascotasViewModel(R.drawable.mascota1, "Pinky"));
        mascotas.add(new MascotasViewModel(R.drawable.mascota2, "Mowgly"));
        mascotas.add(new MascotasViewModel(R.drawable.mascota3, "Lucas"));
        mascotas.add(new MascotasViewModel(R.drawable.mascota4, "Bunnie"));
        mascotas.add(new MascotasViewModel(R.drawable.mascota5, "Martin"));

        mAdapter = new MascotasAdapter(mascotas, R.layout.card, getApplicationContext());

        mRecyclerView.setAdapter(mAdapter);
    }
}
