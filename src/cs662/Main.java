package cs662;

import java.util.concurrent.ExecutionException;
/**
 * Jisoo Lee 02/15/2023
 *
 * Class: Main
 * Description:
 * Main class runs creating genome methods in CreateGenomeConcurrently class and CreateGenomeSingleThread class.
 * It prints out the time spent in each run.
 */
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
	    CreateGenomeProgram multiThread = new CreateGenomeConcurrently();
        CreateGenomeProgram singleThread = new CreateGenomeSingleThread();
        //multi-thread running
        multiThread.createGenomeWithMultiThreads();
        multiThread.printTimeSpent();
        multiThread.printGenomeSequences();
        //single thread running
        singleThread.createGenomeWithSingleThread();
        singleThread.printTimeSpent();
        singleThread.printGenomeSequences();


    }
}
