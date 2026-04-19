import java.util.*;

class BrowserHistory {
    private List<String> history;
    private int currentIndex;

    // Constructor initializes with homepage
    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        currentIndex = 0;
    }

    // Visit a new URL
    public void visit(String url) {
        // Remove forward history
        while (history.size() > currentIndex + 1) {
            history.remove(history.size() - 1);
        }
        history.add(url);
        currentIndex++;
    }

    // Move back in history
    public String back(int steps) {
        currentIndex = Math.max(0, currentIndex - steps);
        return history.get(currentIndex);
    }

    // Move forward in history
    public String forward(int steps) {
        currentIndex = Math.min(history.size() - 1, currentIndex + steps);
        return history.get(currentIndex);
    }
}
