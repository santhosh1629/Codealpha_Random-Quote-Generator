package com.example.app1.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.app1.ui.home.Quote;

import java.util.Random;

public class SlideshowViewModel extends ViewModel {

    private final MutableLiveData<Quote> currentQuote = new MutableLiveData<>();

    private final Quote[] quotes = {
            new Quote("Life is what happens when you're busy making other plans.", "John Lennon"),
            new Quote("Get busy living or get busy dying.", "Stephen King"),
            new Quote("You only live once, but if you do it right, once is enough.", "Mae West"),
            new Quote("In the middle of every difficulty lies opportunity.", "Albert Einstein"),
            new Quote("Keep smiling, because life is a beautiful thing and there’s so much to smile about.", "Marilyn Monroe"),
            new Quote("Life is short, and it’s up to you to make it sweet.", "Sarah Louise Delany"),
            new Quote("Do not take life too seriously. You will never get out of it alive.", "Elbert Hubbard"),
            new Quote("Good friends, good books, and a sleepy conscience: this is the ideal life.", "Mark Twain"),
            new Quote("The purpose of our lives is to be happy.", "Dalai Lama"),
            new Quote("Difficulties in life are intended to make us better, not bitter.", "Dan Reeves")
    };

    private int currentIndex = -1;

    public SlideshowViewModel() {
        showRandomQuote();
    }

    public LiveData<Quote> getCurrentQuote() {
        return currentQuote;
    }

    public void showRandomQuote() {
        if (quotes.length == 0) return;
        Random random = new Random();
        int newIndex = random.nextInt(quotes.length);

        int attempts = 0;
        while (newIndex == currentIndex && attempts < 5) {
            newIndex = random.nextInt(quotes.length);
            attempts++;
        }

        currentIndex = newIndex;
        currentQuote.setValue(quotes[currentIndex]);
    }
}
