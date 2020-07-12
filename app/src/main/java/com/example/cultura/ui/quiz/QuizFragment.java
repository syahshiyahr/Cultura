package com.example.cultura.ui.quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cultura.R;
import com.example.cultura.adapter.CardViewQuizAdapter;
import com.example.cultura.data.quizData;
import com.example.cultura.model.quiz;

import java.util.ArrayList;

public class QuizFragment extends Fragment {
    private RecyclerView rvQuiz;
    private ArrayList<quiz> list = new ArrayList<>();
    TextView nameOfPlace, solveChallenge;
    private ImageView btn_back, btn_history;

    private QuizViewModel quizViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        nameOfPlace = view.findViewById(R.id.tv_nameOfPlace);

        rvQuiz = view.findViewById(R.id.quiz);
        rvQuiz.setHasFixedSize(true);

        list.addAll(quizData.getListData());
        rvQuiz.setLayoutManager(new LinearLayoutManager(getContext()));
        CardViewQuizAdapter cvQuizAdapter = new CardViewQuizAdapter(list);
        rvQuiz.setAdapter(cvQuizAdapter);

        return view;
    }
}