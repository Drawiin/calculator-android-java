package com.drawiin.calculator;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.drawiin.calculator.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainViewModel viewModel;
    private MediaPlayer numberMediaPlayer;
    private MediaPlayer backMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        setupMediaPLayer();
        setupUi();
        subscribeUi();
    }

    private void setupMediaPLayer() {
        numberMediaPlayer = MediaPlayer.create(this, R.raw.jungle_button);
        backMediaPlayer = MediaPlayer.create(this, R.raw.btn_back);
        backMediaPlayer.setVolume(0.3f, 0.3f);
        numberMediaPlayer.setVolume(0.3f, 0.3f);
    }

    private void playButtonSound() {
        numberMediaPlayer.start();
    }
    private void playButtonBack() {
        backMediaPlayer.start();
    }

    private void setupUi() {
        binding.button0.setOnClickListener((view) -> {
            viewModel.onActionReceived("0");
            playButtonSound();
        });
        binding.button1.setOnClickListener((view) -> {
            viewModel.onActionReceived("1");
            playButtonSound();
        });
        binding.button2.setOnClickListener((view) -> {
            viewModel.onActionReceived("2");
            playButtonSound();
        });
        binding.button3.setOnClickListener((view) -> {
            viewModel.onActionReceived("3");
            playButtonSound();
        });
        binding.button4.setOnClickListener((view) -> {
            viewModel.onActionReceived("4");
            playButtonSound();
        });
        binding.button5.setOnClickListener((view) -> {
            viewModel.onActionReceived("5");
            playButtonSound();
        });
        binding.button6.setOnClickListener((view) -> {
            viewModel.onActionReceived("6");
            playButtonSound();
        });
        binding.button7.setOnClickListener((view) -> {
            viewModel.onActionReceived("7");
            playButtonSound();
        });
        binding.button8.setOnClickListener((view) -> {
            viewModel.onActionReceived("8");
            playButtonSound();
        });
        binding.button9.setOnClickListener((view) -> {
            viewModel.onActionReceived("9");
            playButtonSound();
        });
        binding.buttonClear.setOnClickListener((view) -> {
            viewModel.onActionReceived("c");
            playButtonBack();
        });
        binding.buttonBackspace.setOnClickListener((view) -> {
            viewModel.onActionReceived("b");
            playButtonBack();
        });
        binding.buttonPlus.setOnClickListener((view) -> {
            viewModel.onActionReceived("+");
            playButtonSound();
        });
        binding.buttonMultiply.setOnClickListener((view) -> {
            viewModel.onActionReceived("*");
            playButtonSound();
        });
        binding.buttonMinus.setOnClickListener((view) -> {
            viewModel.onActionReceived("-");
            playButtonSound();
        });
        binding.buttonDivide.setOnClickListener((view) -> {
            viewModel.onActionReceived("/");
            playButtonSound();
        });
        binding.buttonEquals.setOnClickListener((view) -> {
            viewModel.onActionReceived("=");
            playButtonSound();
        });
    }

    private void subscribeUi() {
        viewModel.getDisplayFormattedValue().observe(this, (text) -> {
            binding.tvDisplay.setText(text);
        });
    }
}