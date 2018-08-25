package demo.theaxontech.com.multiplerecyclerviewdemo;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MultiViewTypeAdapter extends RecyclerView.Adapter {

    private ArrayList<Model> dataSet;
    private Context mContext;
    private MediaPlayer mPlayer;
    private boolean fabStateVolume = false;

    public static class TextTypeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textViewHeader) TextView txtHeader;
        @BindView(R.id.textViewFooter) TextView txtFooter;
        @BindView(R.id.card_view) CardView cardView;

        private TextTypeViewHolder(View itemView) {
            super(itemView);

            /*this.txtHeader = (TextView) itemView.findViewById(R.id.textViewHeader);
            this.txtFooter = (TextView) itemView.findViewById(R.id.textViewFooter);
            this.cardView = (CardView) itemView.findViewById(R.id.card_view);*/

            // binding view
            ButterKnife.bind(this, itemView);
        }
    }

    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textViewHeader) TextView txtHeader;
        @BindView(R.id.textViewFooter) TextView txtFooter;
        @BindView(R.id.imageViewBackground) ImageView image;

        private ImageTypeViewHolder(View itemView) {
            super(itemView);

            /*this.txtType = (TextView) itemView.findViewById(R.id.type);
            this.image = (ImageView) itemView.findViewById(R.id.background);*/

            // binding view
            ButterKnife.bind(this, itemView);
        }
    }

    public static class AudioTypeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textViewHeader) TextView txtHeader;
        @BindView(R.id.textViewFooter) TextView txtFooter;
        @BindView(R.id.imageViewBackground) ImageView image;

        private AudioTypeViewHolder(View itemView) {
            super(itemView);

            /*this.txtType = (TextView) itemView.findViewById(R.id.type);
            this.fab = (FloatingActionButton) itemView.findViewById(R.id.fab);*/

            // binding view
            ButterKnife.bind(this, itemView);
        }
    }

    public MultiViewTypeAdapter(ArrayList<Model> data, Context context) {
        this.dataSet = data;
        this.mContext = context;
        int total_types = dataSet.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case Model.TEXT_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_type, parent, false);
                return new TextTypeViewHolder(view);
            case Model.IMAGE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_type, parent, false);
                return new ImageTypeViewHolder(view);
            case Model.AUDIO_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.audio_type, parent, false);
                return new AudioTypeViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {

        switch (dataSet.get(position).type) {
            case 0:
                return Model.TEXT_TYPE;
            case 1:
                return Model.IMAGE_TYPE;
            case 2:
                return Model.AUDIO_TYPE;
            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        Model object = dataSet.get(listPosition);
        if (object != null) {
            switch (object.type) {
                case Model.TEXT_TYPE:
                    ((TextTypeViewHolder) holder).txtHeader.setText(object.textHeader);
                    ((TextTypeViewHolder) holder).txtFooter.setText(object.textFooter);

                    break;
                case Model.IMAGE_TYPE:
                    /*((ImageTypeViewHolder) holder).txtHeader.setText(object.textHeader);
                    ((ImageTypeViewHolder) holder).txtFooter.setText(object.textFooter);
                    ((ImageTypeViewHolder) holder).image.setImageResource(object.data);*/

                    Picasso.get().load(object.data).fit().into(((ImageTypeViewHolder)holder).image);

                    break;
                case Model.AUDIO_TYPE:

                    ((AudioTypeViewHolder) holder).txtHeader.setText(object.textHeader);
                    ((AudioTypeViewHolder) holder).txtFooter.setText(object.textFooter);

                    Picasso.get().load(object.data).into(((AudioTypeViewHolder)holder).image);

                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
