import java.sql.Array;
import java.sql.SQLOutput;
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

        System.out.println("How many players will be?");
        int quantityOfPlayers = scanner.nextInt();

        for (int i = 0; i < quantityOfPlayers; i++) {
            System.out.println("Enter player's name:");
            playersNames.add(scanner.next());
        }

        Collections.shuffle(playersNames);

        boolean isGameOver = false;

        int randomWordsIndex = random.nextInt(0, words.size());
        int[] score = new int[quantityOfPlayers];
        int order = 0;
        ArrayList<String> wrongGuessedLetters = new ArrayList<>();
        int guessedLetters = 0;
        do{
            System.out.println("Guess the word: " +
                    "\n" + definitions.get(randomWordsIndex));
            System.out.println(playersNames.get(order) + "'s turn!");
            boolean isPlayerGuessIncorrect = false;
            while(!isPlayerGuessIncorrect){
                String playersGuess = scanner.next();
                if (score[order] >= words.get(randomWordsIndex).length()*60){
                    System.out.println(playersNames.get(order) + " has reached maximum possible points and can win the game! So other players must guess the word!");
                    playersNames.remove(order);
                    if (order == playersNames.size() - 1) {
                        order = 0;
                    }
                    order++;
                    System.out.println(playersNames.get(order) + "'s turn to guess the word!");

                    if (playersGuess.equals(words.get(randomWordsIndex))){
                        score[order]+=words.get(randomWordsIndex).length()*100;
                    }else{
                        playersNames.remove(order);
                        order++;
                        if (order == playersNames.size() - 1) {
                            order = 0;
                        }
                        System.out.println(playersNames.get(order) + "'s turn to guess the word!");

                    }

                }
                if (playersGuess.length()>1 && playersGuess.equals(words.get(randomWordsIndex).toLowerCase())){
                    score[order]+=words.get(randomWordsIndex).length()*100;
                    isPlayerGuessIncorrect = true;
                    isGameOver = true;
                }else {
                    if (playersGuess.length()>1) {
                        System.out.println("The player " + playersNames.get(order) + " is eliminated because he guessed the word incorrectly!");
                        playersNames.remove(order);
                        order++;
                        System.out.println(playersNames.get(order) + "'s turn!");
                        if (order == playersNames.size() - 1) {
                            order = 0;
                        }
                    }else {
                        if (words.get(randomWordsIndex).toLowerCase().contains(playersGuess)) {
                            score[order] += 100;
                            System.out.println("Correct! Word contains this letter!");
                            guessedLetters++;
                            if (guessedLetters == words.get(randomWordsIndex).length()) {
                                isPlayerGuessIncorrect = true;
                                isGameOver = true;
                            }

                        } else {
                            if (!wrongGuessedLetters.contains(playersGuess)) {
                                System.out.println("Incorrect! Word does not contain this letter!");
                                wrongGuessedLetters.add(playersGuess);
                                isPlayerGuessIncorrect = true;
                                order++;
                                if (order == playersNames.size()) {
                                    order = 0;
                                }
                            } else {
                                System.out.println("This letter has already been guessed! Try another one!");
                            }


                        }
                    }
                }

            }



        }while(!isGameOver);
        ArrayList<Integer> scoreAsArrayList = new ArrayList<>();
        for (int v :
             score) {
            scoreAsArrayList.add(v);
        }
        String winner = playersNames.get(scoreAsArrayList.indexOf(Collections.max(scoreAsArrayList)));
        System.out.println("The winner is " + winner + "!");









    }


}