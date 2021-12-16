package home.amml.ad.second_pc_store.view.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import home.amml.ad.second_pc_store.R;
import home.amml.ad.second_pc_store.databinding.FragmentFirstBinding;
import home.amml.ad.second_pc_store.model.entity.User;
import home.amml.ad.second_pc_store.view.activity.MainActivity;
import home.amml.ad.second_pc_store.viewmodel.UserViewModel;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    private UserViewModel uvm;

    private String userName, userPass;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public boolean checkUserLogin(){
        boolean salida = true;
        userName = binding.txInputUserNameFirst.getEditText().getText().toString().trim();
        userPass = binding.txInputPassFirst.getEditText().getText().toString();
        User user = uvm.getLiveUserWithPass(userName, userPass).getValue();
        if (user != null){
            ((MainActivity)getActivity()).setUser(user);
        } else{
            salida = false;
        }
        return salida;
    }

    private void cleanFields() {
        binding.txInputUserNameFirst.getEditText().setText("");
        binding.txInputPassFirst.getEditText().setText("");
    }

    private void getViewModel() {
        uvm = new ViewModelProvider(this).get(UserViewModel.class);
    }

    public void initialize(){
        getViewModel();
        binding.btLoginFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkUserLogin()){
                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.action_FirstFragment_to_StoreFragment);
                } else {
                    showAlert();
                }
            }
        });

        binding.btSignUpFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    private void showAlert() {
        androidx.appcompat.app.AlertDialog.Builder builder  = new AlertDialog.Builder(this.getActivity());
        builder.setTitle("Error")
                .setMessage("Incorrect user or password")
                .setPositiveButton( android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cleanFields();
                    }
                });
        builder.create().show();
    }



}