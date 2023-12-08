import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ArrayList<String> playersNames = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> definitions = new ArrayList<>();
        //filling words & definitons
        words.add("Plateau");
        definitions.add("A flat, elevated landform that rises sharply above the surrounding area on at least one side.");
        words.add("Pirate");
        definitions.add("A person who attacks and robs ships at sea.");
        words.add("Meteorite");
        definitions.add("Any fairly small natural object from interplanetary space—i.e., a meteoroid—that survives its passage through Earth's atmosphere and lands on the surface.");
        words.add("Star");
        definitions.add("A fixed luminous point in the night sky which is a large, remote incandescent body.");
        words.add("Guitar");
        definitions.add("A stringed musical instrument, with a fretted fingerboard, typically incurved sides, and six or twelve strings, played by plucking or strumming with the fingers or a plectrum.");
        words.add("France");
        definitions.add("A country in Western Europe, home to medieval towns, alpine villages and Mediterranean beaches, known for its wines and gourmet cuisine.");
        words.add("Amber");
        definitions.add("Hard translucent fossilized resin originating from extinct coniferous trees of the Tertiary period, typically yellowish in colour. It has been used in jewellery since antiquity.");
        words.add("Hotdog");
        definitions.add("A dish consisting of a grilled or steamed sausage served in the slit of a partially sliced bun.");
        words.add("Manager");
        definitions.add("A person responsible for controlling or administering an organization or group of staff.");
        words.add("Hyperbole");
        definitions.add("Exaggerated statements or claims not meant to be taken literally.");


        System.out.println("         How many players will be?");
        int quantityOfPlayers = scanner.nextInt();

        boolean isGameFinished = false;
        int randomWordsIndex = random.nextInt(0, words.size());
        for (int i = 0; i < quantityOfPlayers; i++) {
            System.out.println("         Enter name: ");

            playersNames.add(scanner.next());
        }

        int[] score = new int[playersNames.size()];

        Collections.shuffle(playersNames);
        ArrayList<String> result = new ArrayList<>(playersNames);
        ArrayList<String> correctlyGuessedLetters = new ArrayList<>();
        HashSet<String> wrongGuessedLetters = new HashSet<>();
        ArrayList<String> guessingWord = new ArrayList<>(List.of(words.get(randomWordsIndex).toLowerCase().split("")));
        int order = 0;
        boolean didSomePlayerReachedEnoughPointsToFinish = false;
        do {
            boolean isPlayersGuessIncorrect = false;
            while (!isPlayersGuessIncorrect) {
                if (!result.get(order).equals("winner") && !result.get(order).equals("lost") && !guessingWord.isEmpty()) {
                    System.out.println("                                                 Guess the word!" +
                            "\n" + "         "  + definitions.get(randomWordsIndex));
                    if (!correctlyGuessedLetters.isEmpty()){
                        System.out.println("               GUESSED LETTERS" + "\n" +
                                "-------------------------------------");
                        for (String s:
                                correctlyGuessedLetters) {
                            System.out.print( "   " + s.toUpperCase() + " ");

                        }
                        System.out.println( );
                        System.out.println("-------------------------------------");
                    }
                    String playersGuess = scanner.next();

                    if (playersGuess.length() > 1 && !didSomePlayerReachedEnoughPointsToFinish) {
                        if (playersGuess.equals(words.get(randomWordsIndex).toLowerCase())) {
                            System.out.println(playersNames.get(order) + " won the game!");
                            isPlayersGuessIncorrect = true;
                            isGameFinished = true;
                        } else {
                            System.out.println("         " + playersNames.get(order) + " is eliminated, because he guessed word incorrectly!" + "\n");
                            result.set(order, "lost");
                            order++;
                        }
                    } else if (playersGuess.length() == 1 && !didSomePlayerReachedEnoughPointsToFinish) {
                        if (guessingWord.contains(playersGuess)) {
                            System.out.println("         Correct! Word contains this letter!");
                            correctlyGuessedLetters.add(playersGuess);
                            guessingWord.remove(playersGuess);
                            score[order] += 100;
                            if (score[order] >= words.get(randomWordsIndex).length() * 50) {
                                System.out.println("         " + playersNames.get(order).toUpperCase() + " approached enough points to finish the game! Other players must guess the word!");
                                didSomePlayerReachedEnoughPointsToFinish = true;
                                result.set(order, "winner");
                                order++;
                            }
                        } else if (wrongGuessedLetters.contains(playersGuess)) {
                            System.out.println("         This letter has already been guessed! Try something else!");
                        } else {
                            System.out.println("         Incorrect! Word does not contain this letter!");
                            wrongGuessedLetters.add(playersGuess);
                            order++;
                        }
                    } else if (didSomePlayerReachedEnoughPointsToFinish) {
                        if (!result.get(order).equals("winner") && !result.get(order).equals("lost") && playersGuess.length() == 1) {
                            System.out.println("         You must guess the full word! Try again!");
                        } else if (!result.get(order).equals("winner") && !result.get(order).equals("lost") && playersGuess.length() > 1 && !playersGuess.equals(words.get(randomWordsIndex).toLowerCase())) {
                            System.out.println("         "  + playersNames.get(order) + " is eliminated, because he guessed word incorrectly!");
                            result.set(order, "lost");
                            order++;
                        } else if (!result.get(order).equals("winner") && !result.get(order).equals("lost") && playersGuess.length() > 1 && playersGuess.equals(words.get(randomWordsIndex).toLowerCase())) {
                            System.out.println(playersNames.get(order) + " won!");
                            isPlayersGuessIncorrect = true;
                            isGameFinished = true;
                        }
                    }
                    if (order == playersNames.size()) {
                        order = 0;
                    }
                } else {
                    ArrayList<Integer> scoreAsArrayList = new ArrayList<>();
                    for (int v :
                            score) {
                        scoreAsArrayList.add(v);
                    }
                    String winner = playersNames.get(scoreAsArrayList.indexOf(Collections.max(scoreAsArrayList)));
                    System.out.println("Winner is " + winner + "!");
                    isPlayersGuessIncorrect = true;
                    isGameFinished = true;
                }
            }
        } while (!isGameFinished);
    }
}