package home.amml.ad.second_pc_store.view.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import home.amml.ad.second_pc_store.R;
import home.amml.ad.second_pc_store.databinding.FragmentSecondBinding;
import home.amml.ad.second_pc_store.model.entity.User;
import home.amml.ad.second_pc_store.view.activity.MainActivity;
import home.amml.ad.second_pc_store.viewmodel.UserViewModel;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    private EditText eT_userName, eT_userPass, eT_userConfirmPass, eT_urlUserPic;

    private UserViewModel uvm;
    private User user;
    private String userName, userPass, urlUserPic;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
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

    private void initialize() {
        getViewModel();
        eT_userName = binding.txInputUserNameSecond.getEditText();
        eT_userPass = binding.txInputPassSecond.getEditText();
        eT_userConfirmPass = binding.txInputConfirmPass.getEditText();
        eT_urlUserPic = binding.txInputUrlUserPicSecond.getEditText();
        binding.btLogInSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.btSignUpSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action_btSignUp();
            }
        });
    }

    private void action_btSignUp (){
        if(checkFieldsWriteCorrect()){
            createUser();
            uvm.getLiveInsertUser().observe(this.getViewLifecycleOwner(), id -> {
                if (id > 0){
                    ((MainActivity)getActivity()).setUser(user);
                    NavHostFragment.findNavController(SecondFragment.this)
                            .navigate(R.id.action_SecondFragment_to_StoreFragment);
                }
                else {
                    showAlert("Username not available", true);
                }
            });
        } else{
            showAlert("Password and ConfirmPassword doesn't match", false);
        }

    }

    private boolean checkFieldsWriteCorrect(){
        boolean salida = true;
        if(eT_userName.getText().toString().trim().isEmpty() || eT_userPass.getText().toString().trim().isEmpty()
                || eT_userConfirmPass.getText().toString().trim().isEmpty()){
            salida = false;
        } else{
            if(!eT_userPass.getText().toString().equals(eT_userConfirmPass.getText().toString())){
                salida = false;
            }
        }
        return salida;
    }

    private void cleanFields(boolean clearUserName) {
        if (clearUserName){
            eT_userName.setText("");
        }
        eT_userPass.setText("");
        eT_userConfirmPass.setText("");
    }

    private void createUser(){
        userName = eT_userName.getText().toString().trim();
        userPass = eT_userPass.getText().toString();
        urlUserPic = picUserUrl();
        user = new User(userName, userPass, urlUserPic);
        uvm.insertUser(user);
    }

    private void getViewModel() {
        uvm = new ViewModelProvider(this).get(UserViewModel.class);
    }

    private String picUserUrl(){
        String salida = "";
        if(eT_urlUserPic.getText().toString().trim().isEmpty()){
            salida = "https://informatica.ieszaidinvergeles.org:10011/AD/images/Contacts_Image.png";
        } else{
            salida = eT_urlUserPic.getText().toString();
        }

        return salida;
    }

    private void showAlert(String message, boolean clearUserName) {
        androidx.appcompat.app.AlertDialog.Builder builder  = new AlertDialog.Builder(this.getActivity());
        builder.setTitle("Error")
                .setMessage(message)
                .setPositiveButton( android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cleanFields(clearUserName);
                    }
                });
        builder.create().show();
    }
}