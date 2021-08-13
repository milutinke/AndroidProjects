package rs.raf.vezbe.domaci2.recycler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.function.Function;

import rs.raf.vezbe.domaci2.R;
import rs.raf.vezbe.domaci2.models.User;

public class UserAdapter extends ListAdapter<User, UserAdapter.ViewHolder> {
    private final Function<User, Void> onUserDeleteCallback;

    public UserAdapter(@NonNull DiffUtil.ItemCallback<User> diffCallback, Function<User, Void> onUserDeleteCallback) {
        super(diffCallback);
        this.onUserDeleteCallback = onUserDeleteCallback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_layout, parent, false), parent.getContext(), position -> {
            onUserDeleteCallback.apply(getItem(position));
            return null;
        });
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // View Components
        private ImageView userPicture;
        private TextView userFirstNameView;
        private TextView userLastNameView;
        private TextView userPhoneView;
        private TextView userEmailView;
        private ImageView userDeleteButtonView;

        private Context context;
        private Function<Integer, Void> onDeleteButtonClicked;

        public ViewHolder(@NonNull View itemView, Context context, Function<Integer, Void> onDeleteButtonClicked) {
            super(itemView);
            init(context, onDeleteButtonClicked);
        }

        private void init(Context context, Function<Integer, Void> onDeleteButtonClicked) {
            this.context = context;
            this.onDeleteButtonClicked = onDeleteButtonClicked;

            initViews();
            initViewListeners();
        }

        private void initViews() {
            userPicture = itemView.findViewById(R.id.userPictureView);
            userFirstNameView = itemView.findViewById(R.id.userFirstNameView);
            userLastNameView = itemView.findViewById(R.id.userLastNameView);
            userPhoneView = itemView.findViewById(R.id.userPhoneNumberView);
            userEmailView = itemView.findViewById(R.id.userEmailView);
            userDeleteButtonView = itemView.findViewById(R.id.userDeleteButtonView);
        }

        private void initViewListeners() {
            userDeleteButtonView.setOnClickListener(v -> {
                if (getAdapterPosition() != RecyclerView.NO_POSITION)
                    onDeleteButtonClicked.apply(getAdapterPosition());
            });
        }

        public void bind(User user) {
            // Set the profile picture
            Glide.with(context).load(user.getPicture()).circleCrop().into(userPicture);

            // Other data
            userFirstNameView.setText(user.getFirstName());
            userLastNameView.setText(user.getLastName());
            userPhoneView.setText(user.getPhoneNumber());
            userEmailView.setText(user.getEmail());
        }
    }
}
