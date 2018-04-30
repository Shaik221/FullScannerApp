package dagger.jani.com.filescanner.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.File;
import java.util.List;

import dagger.jani.com.filescanner.R;

import static dagger.jani.com.filescanner.FileUtils.getStringSizeLengthFile;


public class FileAdapter extends RecyclerView.Adapter<FileAdapter.MyViewHolder> {

    private List<File> fileList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, size;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.tv_file_name);
            size = view.findViewById(R.id.tv_file_size);
        }
    }


    public FileAdapter(List<File> fileList) {
        this.fileList = fileList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_file_size, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        File file = fileList.get(position);
        holder.title.setText(file.getName());
        holder.size.setText(getStringSizeLengthFile(file.length()));
    }

    @Override
    public int getItemCount() {
        return fileList.size();
    }
}