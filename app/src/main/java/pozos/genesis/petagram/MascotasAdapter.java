package pozos.genesis.petagram;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MascotasAdapter extends RecyclerView.Adapter<MascotasAdapter.MascotasViewHolder> {

    private List<MascotasViewModel> items;
    private int itemLayout;
    private static Context context;

    public MascotasAdapter(List<MascotasViewModel> mascotasList, int itemLayout, Context ctx) {
        this.items = mascotasList;
        this.itemLayout = itemLayout;
        this.context = ctx;
    }

    @Override
    public MascotasViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new MascotasViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MascotasViewHolder MascotasViewHolder, int position) {
        MascotasViewModel item = items.get(position);
        MascotasViewHolder.currentItem = items.get(position);
        MascotasViewHolder.nombre.setText(item.getNombre());
        MascotasViewHolder.imagen.setImageResource(item.getImagen());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder {

        ImageView imagen;
        TextView nombre;

        public MascotasViewModel currentItem;

        public MascotasViewHolder(View v) {
            super(v);

            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);

        }
    }
}