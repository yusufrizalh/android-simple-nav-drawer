package id.yusufrizalh.simpledrawer;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.yusufrizalh.simpledrawer.databinding.FragmentContactUsBinding;

public class ContactUsFragment extends Fragment implements MainActivity.OnBackPressedListener {

    private FragmentContactUsBinding contactUsBinding;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        contactUsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact_us, container, false);
        ((MainActivity) getActivity()).setOnBackPressedListener(this);
        view = contactUsBinding.getRoot();
        initView();
        return view;
    }

    private void initView() {
        ActionBar customActionBar = ((MainActivity)getActivity()).getSupportActionBar();
        customActionBar.setTitle("Contact Us");
    }

    @Override
    public void doBack() {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        transaction.replace(R.id.frameLayout, new HomeFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }
}