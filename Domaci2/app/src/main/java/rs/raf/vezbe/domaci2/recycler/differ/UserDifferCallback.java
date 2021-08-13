package rs.raf.vezbe.domaci2.recycler.differ;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import rs.raf.vezbe.domaci2.models.User;

public class UserDifferCallback extends DiffUtil.ItemCallback<User> {
    @Override
    public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
        return oldItem.getFirstName().equals(newItem.getFirstName())
                && oldItem.getLastName().equals(newItem.getLastName())
                && oldItem.getPhoneNumber().equals(newItem.getPhoneNumber())
                && oldItem.getEmail().equals(newItem.getEmail());
    }
}
