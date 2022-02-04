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
import android.widget.Toast;

import id.yusufrizalh.simpledrawer.databinding.FragmentAboutUsBinding;

public class AboutUsFragment extends Fragment implements MainActivity.OnBackPressedListener {
    private FragmentAboutUsBinding aboutUsBinding;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        aboutUsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_about_us,
                container, false);
        ((MainActivity) getActivity()).setOnBackPressedListener(this);
        view = aboutUsBinding.getRoot();
        initView();
        return view;
    }

    private void initView() {
        ActionBar customActionBar = ((MainActivity) getActivity()).getSupportActionBar();
        customActionBar.setTitle("Tentang Kita");

        aboutUsBinding.btnOpenAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext().getApplicationContext(), "Open About Us",
                        Toast.LENGTH_SHORT).show();
            }
        });
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