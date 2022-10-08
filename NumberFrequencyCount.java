/*
NumberFrequencyCount.initialiseCounts ();

NumberFrequencyCount.incrementCounts (123);
NumberFrequencyCount.incrementCounts (67891);
:::
NumberFrequencyCount.displayFrequencyCounts ();

*/
public class NumberFrequencyCount
{
   public static double[] FREQUENCY_LIMITS = {-1_000_000, -100_000, -10_000, -1000, 0, 1000, 10_000, 100_000, 1_000_000, Double.MAX_VALUE};
   public static long[]   frequencyCounts  = new long [FREQUENCY_LIMITS.length];
   public static long     transCount;

   public static void initialiseCounts ()
   {
      for (int k = 0; k < frequencyCounts.length; k++)
      {
         frequencyCounts [k] = 0;
      }

      transCount = 0;
   }

   public static void incrementCounts (double val)
   {
      for (int k = 0; k < FREQUENCY_LIMITS.length; k++)
      {
         if (val <= FREQUENCY_LIMITS [k])
         {
            transCount++;
            frequencyCounts [k]++;
            k = FREQUENCY_LIMITS.length; // Exit Loop
         }
      }
   }

   public static void displayFrequencyCounts ()
   {
      for (int k = 0; k < frequencyCounts.length; k++)
      {
         double proportion = 100.0 * frequencyCounts [k] / transCount;

         if (FREQUENCY_LIMITS [k] < 1_000_000_000_000L)
         {

            System.out.println ("<= " + String.format ("%,.0f", FREQUENCY_LIMITS  [k]) +
                                ": "  + String.format ("%,d",   frequencyCounts [k]) +
                                " ("  + String.format ("%,.1f", proportion)          + "%)" );
         }
         else
         {
            System.out.println ("<= " + FREQUENCY_LIMITS  [k] + //String.format ("%,.0f", FREQUENCY_LIMITS  [k]) +
                                ": "  + String.format ("%,d",   frequencyCounts [k]) +
                                " ("  + String.format ("%,.1f", proportion)          + "%)" );
         }
      }

      System.out.println ();
      System.out.println (String.format ("%,d", transCount) + " transactions processed / tallied.");
      System.out.println ();
   }

}