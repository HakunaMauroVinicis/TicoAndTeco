package com.example.ticoteco;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ticoteco.modelo.Post;

import java.util.ArrayList;

public class PostArrayAdapter extends ArrayAdapter<Post> {

    private int layout;
    private LayoutInflater layoutInflater;

    public PostArrayAdapter(Activity activity, int layout, ArrayList<Post> dados) {
        super(activity, layout, dados);
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout = layout;
    }

    @Override
    public View getView(int position, View row, ViewGroup parent){
        ViewHolder viewHolder;

        if (row == null) {
            // criar item novo
            row = layoutInflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.txvContatoNome = row.findViewById(R.id.);
            viewHolder.txvContatoTelefone = row.findViewById(R.id.);
            row.setTag(viewHolder);
        } else {
            // reciclar item
            viewHolder = (ViewHolder) row.getTag();
        }

        Post post = getItem(position);
        viewHolder.txvContatoNome.setText(post.getAssunto());
        viewHolder.txvContatoTelefone.setText(post.getPost());

        return row;
    }

    class ViewHolder {
        TextView txvContatoNome;
        TextView txvContatoTelefone;
    }
}
