package pozos.genesis.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MascotasAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        mascotas.add(new MascotasViewModel(R.drawable.mascota6, "Soila"));

        mAdapter = new MascotasAdapter(mascotas, R.layout.card, getApplicationContext());

        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favoritos:

                Intent intent = new Intent(MainActivity.this, FavoritosActivity.class);
                startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
