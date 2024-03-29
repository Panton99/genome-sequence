# genome-sequence


1.Program name: genome-sequence

2.Purpose
  - Learning how to make random genome sequences with multi-threads/single-thread environments.
  - Human nuclear genome is compromised of 3,200,000,000 nucleotides of DNA.
    When divided into 24 chromosomes, the length is from 50,000,000 and 260,000,000 nucleotides.
  - Shows the performance of each run with different thread environments.

3.Descriptions
  - This program generates random genome sequences with certain lengths with various thread environment.
  - It shows the time spent generating sequences and the whole genome that has been created.

4.Test Cases
    - show the difference of performance outcome when using actual genome size.
    - Test case 1
    private static final int WHOLE_SEQ_LENGTH = 100;<br>
    private static final int THREADS = 5;<br>
    private static final int CHAR_LENGTH = 10;<br>
    - Test case 2<br>
    private static final int WHOLE_SEQ_LENGTH = 5000000;<br>
    private static final int THREADS = 5;<br>
    private static final int CHAR_LENGTH = 10;<br>
    - Test case 3<br>
    private static final int WHOLE_SEQ_LENGTH = 26000000;<br>
    private static final int THREADS = 5;<br>
    private static final int CHAR_LENGTH = 10;<br>
    
5.Test case outcomes/Conclusion
```
   - Test cases
    1) Test case 1: 100 * 10 sequences
     1) Result: Multi-thread environment took more time than a single thread.
     2) Expected reason: The workload is relatively small so the benefit of parallelism is limited.
     3) Console outcome:
       	--- Multi-thread ---
       Genome Sequence Length: 1000, Thread count: 5
       Time spent creating: 3 milliseconds<br>
       Genome sequence : CCCCTTCCAG CAATGGTGGG TCCATAGGGT TTAAACAGGA TGTTTTTCCC AGCTTAAGCT AACGTAACTA TTGCATATTT CAGTTGCCAC CGGACAAGTA<br>
       TGACCTACCC AGACTAGGTC GTTAAAGACA GTTTTAGTCT ATAAAATCAG TGGGAACAGC TATCTGGGTG TGCGTTGTGG CGTCCTCAAT TCCACGCAAC <br>
       TGCTATTAGA CTATCGAATC GAAGACCTTG TGTATAACGT GAGGTCTACG AGATCCTACA TGTGAGTAAC TCCTATTTAG TCGAAGATAA CGATGTGAGC <br>
       CATTTGGGTA GGCATTTCCA GGTACCCGAG TAGTACTGAC GACTTAGCAT AACATCTTCG AGCAGATGGT AGCGATAAAT CGACGCACTA CGGTGGATTG <br>
       TCCCGTAGCT CGAAAGTTCA AGATTACCTG ACTGAGTAGA CGGCGCCACG TCTTCGTGTT CATACCACTT ACGGGGCGTC CGTGTCGGAT AGTGACACCG <br>
       GCGACCCAAT AAAACGCGAC TGGGAATACT AACGTCGTAG AATGAGAATA TAGTTCCACA AATAGTCCAA TGGGTACGAA TATTTAGACT CGTCAGCGAG <br>
       TTAGCGTGAT GAAGCGACAT CTGCTTAGGT GATGATCTGT TAAAGTATCA CCCATATGCG AGCCGTTGCG GTTAAGCCTT GGGCTGCACT GGGAAGGGCC <br>
       CGGAAAACAG GGAAGCTCGA GGAAATTGTC GCTTATATTA GTTAGGTATT GCCCTGCACA AGCAAGTAGC TGATGGTCCT GCATCTGGTT TTAGAACTGC <br>
       ATTATACTCG TGGCTAACCA CAGAGGTGCA TAAGTGTAAG CTAACGCTGG TGCATAAATC CTAACTACTT TCTGACCATC CTTTGCCATT GTCGTCTCCT <br>
       ACTCACGTAA ATTCAGCATA CCGGCGTTTA TCCATCAGGA AGCAGATTCG CAGACTTTAG AGCAACTAAC CTCGGCAGGA TTCAAGATGC GATTTAGTGC<br>
       
       [Thread #1] CCCCTTCCAG CAATGGTGGG TCCATAGGGT TTAAACAGGA TGTTTTTCCC AGCTTAAGCT AACGTAACTA TTGCATATTT CAGTTGCCAC CGGACAAGTA<br>
                   TGACCTACCC AGACTAGGTC GTTAAAGACA GTTTTAGTCT ATAAAATCAG TGGGAACAGC TATCTGGGTG TGCGTTGTGG CGTCCTCAAT TCCACGCAAC<br>
       [Thread #2] TGCTATTAGA CTATCGAATC GAAGACCTTG TGTATAACGT GAGGTCTACG AGATCCTACA TGTGAGTAAC TCCTATTTAG TCGAAGATAA CGATGTGAGC<br>
                   CATTTGGGTA GGCATTTCCA GGTACCCGAG TAGTACTGAC GACTTAGCAT AACATCTTCG AGCAGATGGT AGCGATAAAT CGACGCACTA CGGTGGATTG<br>
       [Thread #3] TCCCGTAGCT CGAAAGTTCA AGATTACCTG ACTGAGTAGA CGGCGCCACG TCTTCGTGTT CATACCACTT ACGGGGCGTC CGTGTCGGAT AGTGACACCG<br>
                   GCGACCCAAT AAAACGCGAC TGGGAATACT AACGTCGTAG AATGAGAATA TAGTTCCACA AATAGTCCAA TGGGTACGAA TATTTAGACT CGTCAGCGAG<br>
       [Thread #4] TTAGCGTGAT GAAGCGACAT CTGCTTAGGT GATGATCTGT TAAAGTATCA CCCATATGCG AGCCGTTGCG GTTAAGCCTT GGGCTGCACT GGGAAGGGCC<br>
                   CGGAAAACAG GGAAGCTCGA GGAAATTGTC GCTTATATTA GTTAGGTATT GCCCTGCACA AGCAAGTAGC TGATGGTCCT GCATCTGGTT TTAGAACTGC<br>
       [Thread #5] ATTATACTCG TGGCTAACCA CAGAGGTGCA TAAGTGTAAG CTAACGCTGG TGCATAAATC CTAACTACTT TCTGACCATC CTTTGCCATT GTCGTCTCCT<br>
                   ACTCACGTAA ATTCAGCATA CCGGCGTTTA TCCATCAGGA AGCAGATTCG CAGACTTTAG AGCAACTAAC CTCGGCAGGA TTCAAGATGC GATTTAGTGC<br>

       	--- Single-thread ---
       Genome Sequence Length: 100
       Time spent creating: 0 milliseconds
       Genome sequence : AATGAGGTTT TTCTGAAATC GCTCTGGGCA ATGCTGGGCC TAACCCCGAT CAGCGATGGA ACTAAAGGTT ACGATCCTAA AGAATCCGCA CTAAAGATCC <br>
       CGCTGCTCGC GGCTCACTGT AACAGAAAGC CCTGACTGCC CGTATCGAAT CTAACTACGC TCTAGTAATT CCTAAATGCT TGTCGGCCGG TATTGAAACG <br>
       GAAGTGGGTA TCCGCTATTT GTTTAGGCAG AAACTCGGAT ATATACCACA GTATATTCGG ACGCCCCCTG CGTGGACGCG GGGAGCTATG TGGGGGCTCC <br>
       CTATTGCGAA TGGATAAGCC GACACTTGCA ATGCTAAATG AGGACTGAAC GCTGCGATTA AATTTAGTGG CTACTCCTTG GCTGGTGACG AGAGGCCCGC <br>
       CGCCCCCCTC CATTACAAAC CATGGGTACA CCCATATGAT AGAGTAGTAG AATGCGACAA CATGACAAGG CAAACGTTCA ATAGCCAGAA GTAGGAATTG <br>
       GCAGAGAATG GGAATGATAC TTACATGAGA GTGATTGTGC GGGCTACTTA CCTATGAAAT TCGACCACAG TGTAGACAAC TCTGGGACTT AGTTCAAAGG <br>
       TAGCGACCAT CACGAGCATA CGGACTTGGT TCGCATATTC GGGTGCGGCT CAAGGCCATA AGGCTTCGAG ATTTTGTTCG GATCTATAGT TTGGTGAGAT  <br>
       CAGCCATACC CGGGCATAGG TGATATAAGC GCTCTCCCCG GGGAGTGCGA TTTACGGATG AGTTCTGGGT TTTTGAAGGA GCACTCATGA GGGGGCCGCG <br>
       CCCTTTAGGT GAACGCCGAC GGAAGGTCAG GCCCGGGCAT TACGTGCAAT AAGTCTCCCT TCATATAAAA TATCGTCACT TCTGAAGTGG GGACAACTGC <br>
       TCATCTCAGC TCTGATGGTC CGTGTGACAC AGACCCATCG ACATTAACTC GGTGTTGGCT CGCCTTATCG GAGCATACCG GATGAAATCC CAAACCGCTC<br>
       <br>
      [Thread #1] AATGAGGTTT TTCTGAAATC GCTCTGGGCA ATGCTGGGCC TAACCCCGAT CAGCGATGGA ACTAAAGGTT ACGATCCTAA AGAATCCGCA CTAAAGATCC <br>
      CGCTGCTCGC GGCTCACTGT AACAGAAAGC CCTGACTGCC CGTATCGAAT CTAACTACGC TCTAGTAATT CCTAAATGCT TGTCGGCCGG TATTGAAACG <br>
      GAAGTGGGTA TCCGCTATTT GTTTAGGCAG AAACTCGGAT ATATACCACA GTATATTCGG ACGCCCCCTG CGTGGACGCG GGGAGCTATG TGGGGGCTCC <br>
      CTATTGCGAA TGGATAAGCC GACACTTGCA ATGCTAAATG AGGACTGAAC GCTGCGATTA AATTTAGTGG CTACTCCTTG GCTGGTGACG AGAGGCCCGC <br>
      CGCCCCCCTC CATTACAAAC CATGGGTACA CCCATATGAT AGAGTAGTAG AATGCGACAA CATGACAAGG CAAACGTTCA ATAGCCAGAA GTAGGAATTG <br>
      GCAGAGAATG GGAATGATAC TTACATGAGA GTGATTGTGC GGGCTACTTA CCTATGAAAT TCGACCACAG TGTAGACAAC TCTGGGACTT AGTTCAAAGG <br>
      TAGCGACCAT CACGAGCATA CGGACTTGGT TCGCATATTC GGGTGCGGCT CAAGGCCATA AGGCTTCGAG ATTTTGTTCG GATCTATAGT TTGGTGAGAT <br>
      CAGCCATACC CGGGCATAGG TGATATAAGC GCTCTCCCCG GGGAGTGCGA TTTACGGATG AGTTCTGGGT TTTTGAAGGA GCACTCATGA GGGGGCCGCG <br>
      CCCTTTAGGT GAACGCCGAC GGAAGGTCAG GCCCGGGCAT TACGTGCAAT AAGTCTCCCT TCATATAAAA TATCGTCACT TCTGAAGTGG GGACAACTGC<br>
      TCATCTCAGC TCTGATGGTC CGTGTGACAC AGACCCATCG ACATTAACTC GGTGTTGGCT CGCCTTATCG GAGCATACCG GATGAAATCC CAAACCGCTC<br>

    2) Test case 2 - 5 million * 10 sequences
     1) Result: Multi-thread environment shows better performance than a single thread.
     2) Expected reason: With this size of workload starting to show better performance in multi-threading.
     3) Console outcome:
        	--- Multi-thread ---
        Genome Sequence Length: 50000000, Thread count: 5
        Time spent creating: 385 milliseconds

        	--- Single-thread ---
        Genome Sequence Length: 5000000
        Time spent creating: 479 milliseconds

    3) Test case 3 - 26 million * 10 sequences
     1) Result: Only the multi-threading could create the genome successfully.
     2) Expected reason: Single threading shows out-of-memory error because of lack of heap space.
                            In the multi-thread environment, the memory required to generate sequences is allocated in each thread so that reduced the
                            memory footprint.
     3) Console outcome:
        	--- Multi-thread ---
        Genome Sequence Length: 260000000, Thread count: 5
        Time spent creating: 1968 milliseconds

        	--- Single-thread ---
        Genome Sequence Length: 26000000
        Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        	at java.util.Arrays.copyOf(Arrays.java:3332)
        	at java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:124)
        	at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:448)
        	at java.lang.StringBuilder.append(StringBuilder.java:136)
        	at cs662.CreateGenomeProgram.createGenome(CreateGenomeProgram.java:91)
        	at cs662.CreateGenomeProgram.createGenomeWithSingleThread(CreateGenomeProgram.java:107)
        	at cs662.CreateGenomeSingleThread.createGenomeWithSingleThread(CreateGenomeSingleThread.java:20)
        	at cs662.Main.main(Main.java:23)
```

   #Conclusion
    <br>- Biological information shows large amount of size such as whole genome sequencing,
      which involves algorithms and programming skills in analyzing, transferring data, and storing data.
    <br>- The workload was distributed across multiple threads, allowing the program to create better use of the available resources.
    <br>- Multi-threading can lead to significant performance improvement when dealing with a large amount of size in limited time and space.
