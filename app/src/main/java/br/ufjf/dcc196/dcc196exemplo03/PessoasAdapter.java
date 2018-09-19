package br.ufjf.dcc196.dcc196exemplo03;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class PessoasAdapter extends RecyclerView.Adapter<PessoasAdapter.ViewHolder>{

    private List<String> pessoas;
    private OnPessoaClickListener listener;

    public interface OnPessoaClickListener{
        void onPessoaClick(View view, int position);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View linhaPessoa = inflater.inflate(R.layout.pessoa_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(linhaPessoa);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNome.setText(pessoas.get(position));
        holder.txtLetras.setText(String.valueOf(pessoas.get(position).length()));
    }

    @Override
    public int getItemCount() {
        return pessoas.size();
    }

    public void setOnPessoaClickListener(OnPessoaClickListener listener){
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView txtNome;
        public TextView txtLetras;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNome = (TextView) itemView.findViewById(R.id.pessoa_nome);
            txtLetras = (TextView) itemView.findViewById(R.id.pessoa_letras);
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onPessoaClick(v, position);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {
            if(listener != null){
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION){
                    listener.onPessoaClick(v, position);
                }
            }
        }
    }

    public PessoasAdapter(List<String> pessoas){
        this.pessoas = pessoas;
    }


}
