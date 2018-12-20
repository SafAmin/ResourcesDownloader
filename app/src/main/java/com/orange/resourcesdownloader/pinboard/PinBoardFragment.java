package com.orange.resourcesdownloader.pinboard;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.orange.resourcesdownloader.R;
import com.orange.resourcesdownloader.base.BaseFragment;
import com.orange.resourcesdownloader.models.Urls;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Display Pin Board Images in RecyclerView
 * <p>
 * Created by Safa Amin on 12/20/2018.
 */

public class PinBoardFragment extends BaseFragment implements PinBoardView {

    @BindView(R.id.rv_pin_board)
    RecyclerView rvPinBoard;
    @BindString(R.string.error)
    String errorMessage;

    private PinBoardPresenter presenter;
    private Unbinder unbinder;

    public static PinBoardFragment getInstance() {
        return new PinBoardFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pin_board, parent, false);

        unbinder = ButterKnife.bind(this, view);
        presenter = new PinBoardPresenter(this);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        presenter.getPinBoardData();
    }

    @Override
    public void invalidateView(List<Urls> urlsList) {
        int mNoOfColumns = presenter.calculateNoOfColumns(getActivity());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), mNoOfColumns);
        rvPinBoard.setLayoutManager(layoutManager);
        rvPinBoard.setNestedScrollingEnabled(false);
        rvPinBoard.setAdapter(new PinBoardAdapter(getContext(), urlsList,
                new PinBoardAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Urls item) {

                    }
                }));
    }

    @Override
    public void handleError() {
        Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public PinBoardPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unbinder.unbind();
    }
}
