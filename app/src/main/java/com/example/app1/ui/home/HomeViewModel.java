package com.example.app1.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<Quote> currentQuote = new MutableLiveData<>();
    private final Quote[] quotes = {
            new Quote("The best time to plant a tree was 20 years ago. The second best time is now.", "Chinese Proverb"),
            new Quote("Life is what happens when you're busy making other plans.", "John Lennon"),
            new Quote("Do not wait to strike till the iron is hot; but make it hot by striking.", "William Butler Yeats"),
            new Quote("The only limit to our realization of tomorrow is our doubts of today.", "Franklin D. Roosevelt"),
            new Quote("Happiness is not something ready made. It comes from your own actions.", "Dalai Lama"),
            new Quote("Success is walking from failure to failure with no loss of enthusiasm.", "Winston Churchill"),
            new Quote("The harder you work for something, the greater you'll feel when you achieve it.", "Unknown"),
            new Quote("Don't watch the clock; do what it does. Keep going.", "Sam Levenson"),
            new Quote("Dream big and dare to fail.", "Norman Vaughan"),
            new Quote("It always seems impossible until it's done.", "Nelson Mandela")
    };

    private int currentIndex = -1;

    public HomeViewModel() {
        showRandomQuote(); // load first quote
    }

    public LiveData<Quote> getCurrentQuote() {
        return currentQuote;
    }

    // Random quote generator
    public void showRandomQuote() {
        if (quotes.length == 0) return;

        Random random = new Random();
        int newIndex = random.nextInt(quotes.length);

        // avoid immediate repeat
        while (newIndex == currentIndex) {
            newIndex = random.nextInt(quotes.length);
        }

        currentIndex = newIndex;
        currentQuote.setValue(quotes[currentIndex]);
    }
}
