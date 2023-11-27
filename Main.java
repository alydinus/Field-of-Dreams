import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ArrayList<String> players = new ArrayList<>();
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
        words.add("Pizza");
        definitions.add("A dish of Italian origin, consisting of a flat round base of dough baked with a topping of tomatoes and cheese, typically with added meat, fish, or vegetables.");
        words.add("Manager");
        definitions.add("A person responsible for controlling or administering an organization or group of staff.");
        words.add("Hyperbole");
        definitions.add("Exaggerated statements or claims not meant to be taken literally.");


        System.out.println("How many players will be?");
        int NumberOfPlayers = scanner.nextInt();
        for (int i = 0; i < NumberOfPlayers; i++) {
            System.out.println("Enter player's name: ");
            players.add(scanner.next());
        }
        int i = 0;
        ArrayList<String> PlayersTurn = new ArrayList<>();
        while(i != players.size()) {
            int randomNumber = random.nextInt(0, players.size());
            PlayersTurn.add(players.get(randomNumber));
            i++;
        }
        boolean IsGameFinished = false;

        System.out.println("Guess the word:" + "\n" +
                definitions.get((int) (Math.random()*definitions.size())));


        while(!IsGameFinished){
            System.out.println(PlayersTurn.get(0) + "'s " + "turn!");


            IsGameFinished = true;
        }







    }
}