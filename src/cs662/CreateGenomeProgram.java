package cs662;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Jisoo Lee 02/15/2023
 *
 * Class: CreateGenomeProgram
 * Description:
 * This class is an abstract class that creates Genome sequence in multi threads or in a single thread environment.
 * There are createGenomeWithMultiThreads(), createGenome(), createGenomeWithSingleThread(), printGenomeSequences(), and printTimeSpent().
 *
 */
public abstract class CreateGenomeProgram {
    private static final String GENOME_SEQ = "ATGC";
    //Test case 1
    private static final int WHOLE_SEQ_LENGTH = 100;
    private static final int THREADS = 5;
    private static final int CHAR_LENGTH = 10;

    //Test case 2
//    private static final int WHOLE_SEQ_LENGTH = 5000000;
//    private static final int THREADS = 5;
//    private static final int CHAR_LENGTH = 10;
    //Test case 3
//    private static final int WHOLE_SEQ_LENGTH = 26000000;
//    private static final int THREADS = 5;
//    private static final int CHAR_LENGTH = 10;

    private static final int POINTER = WHOLE_SEQ_LENGTH/THREADS;
    private List<String> finalResult = new ArrayList<>();
    private List<Long> timeStorage = new ArrayList<>();

    /* createGenomeWithMultiThreads()
     * input : none
     * output : creates list of genome sequence with thread call.
     * return : none
     * */
    public void createGenomeWithMultiThreads() throws InterruptedException, ExecutionException {
        List<Callable<List<String>>> result = new ArrayList<>();
        //make sure that THREADS count of threads are reused after created
        ExecutorService threadPool = Executors.newFixedThreadPool(THREADS);
        //dividing into THREADS (count) and run it concurrently
        for (int idx = 0; idx < THREADS; idx++) {
            int left = idx * POINTER;
            int right = (idx + 1) * POINTER;
            //creating the random genome sequence by thread
            result.add(new GenomeSequence(GENOME_SEQ, CHAR_LENGTH, left, right));
        }
        //checks the time spent while invoking the call
        System.out.println("\n\t--- Multi-thread ---");
        System.out.println("Genome Sequence Length: " + WHOLE_SEQ_LENGTH * CHAR_LENGTH + ", Thread count: " + THREADS);
        //time spent creating genome with multi threading
        long startTime = System.currentTimeMillis();
        List<Future<List<String>>> future = threadPool.invokeAll(result);
        long endTime = System.currentTimeMillis();
        long timeSpent = endTime - startTime;
        System.out.println("Time spent creating: " + timeSpent + " milliseconds");

        //combine every thread into one list
        for (Future<List<String>> list : future) {
            finalResult.addAll(list.get());
        }
        //If the sequence is too large, do not print it out
        if (WHOLE_SEQ_LENGTH <= 100) {
            System.out.println("Genome sequence : " + String.join("" , finalResult));
        }
        //thread shut down when done
        threadPool.shutdown();
    }

    /* createGenome() - this is a private method for single thread method
     * input : none
     * output : none
     * return : list of genome sequence
     * */
    private List<String> createGenome() {
        StringBuilder dnaSeq = new StringBuilder();
        Random random = new Random();
        List<String> genomeSeq = new ArrayList<>();
        //creating charLength amount of sequence repeatedly until it reaches the whole sequence length
        for (int i = 0; i < WHOLE_SEQ_LENGTH; i++) {
            //creating charLength amount of genome sequence
            for (int j = 0; j < CHAR_LENGTH; j++) {
                //appending random char from GENOME_SEQ
                int randomIdx = random.nextInt(GENOME_SEQ.length());
                dnaSeq.append(GENOME_SEQ.charAt(randomIdx));
            }
            dnaSeq.append(" ");
        }
        genomeSeq.add(dnaSeq.toString()); //adding the charLength randomly created sequence into the list
        return genomeSeq;
    }

    /* createGenomeWithSingleThread()
     * input : none
     * output : get the time value when creating the whole sequence in single thread environment.
     * return : none
     * */
    public void createGenomeWithSingleThread() {
        //checks the time spent creating the genome sequence in single thread environment
        System.out.println("\n\t--- Single-thread ---");
        System.out.println("Genome Sequence Length: " + WHOLE_SEQ_LENGTH * CHAR_LENGTH);
        //time spent when creating genome sequence with single thread
        long startTime1 = System.currentTimeMillis();
        List<String> result = createGenome();
        long endTime1 = System.currentTimeMillis();
        long timeSpent1 = endTime1 - startTime1;
        System.out.println("Time spent creating: " + timeSpent1 + " milliseconds");
        timeStorage.clear(); //clear the list for adding single thread values
        finalResult.clear(); //clear the list for adding single thread values
        //put the sequence into the list
        finalResult.addAll(result);
        //If the sequence is too large, do not print it out
        if (WHOLE_SEQ_LENGTH <= 100) {
            System.out.println("Genome sequence : " + String.join("", finalResult));
        }
    }

    /* printGenomeSequence()
     * input : none
     * output : prints out the sequence production in a timely manner
     * return : none
     * */
    public void printGenomeSequences() {
        //If the sequence is too large, do not print it out
        if (WHOLE_SEQ_LENGTH <= 100) {
            for (int i = 0; i < finalResult.size(); i++) {
                System.out.println("\t[Thread #" + (i + 1) + "] " + finalResult.get(i));
            }
        }
    }
    /* printTimeSpent()
     * input : none
     * output : prints out the time value of each run (single vs multi thread)
     * return : none
     * */
    public void printTimeSpent() {
        for (Long time : timeStorage) {
            System.out.println("Time spent creating: " + time);
        }
    }

}
