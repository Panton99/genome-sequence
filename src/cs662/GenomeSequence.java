package cs662;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Jisoo Lee 02/15/2023
 *
 * Class: GenomeSequence
 * Description:
 * GenomeSequence class implements Callable. This class has call method that creates random 10 length of DNA sequence.
 */
public class GenomeSequence implements Callable<List<String>> {
    private List<String> list = new ArrayList<>();
    private String seq;
    private int left;
    private int right;
    private int charLength;
    private final Random random = new Random();

    /* GenomeSequence() constructor
     * input : String seq, int charLength, int left, int right
     * output : none
     * return : none
     * */
    public GenomeSequence(String seq, int charLength , int left, int right) {
        this.seq = seq;
        this.charLength = charLength;
        this.right = right;
        this.left = left;
    }

    /* call()
     * input : none
     * output : none
     * return : list of sequences
     * */
    @Override
    public List<String> call() {
        StringBuilder dnaSeq = new StringBuilder();
        //creating charLength amount of sequence repeatedly until the left index
        for (int i = left; i < right; i++) {
            //creating charLength amount of genome sequence
            for (int j = 0; j < charLength; j++) {
                //choose random index using Random
                int randomIdx = random.nextInt(seq.length());
                //appending random char from seq input
                dnaSeq.append(seq.charAt(randomIdx));
            }
            dnaSeq.append(" ");
        }
        String dnaSeqString = dnaSeq.toString();
        list.add(dnaSeqString); //adding the charLength randomly created sequence into the list

        return list;
    }


}
